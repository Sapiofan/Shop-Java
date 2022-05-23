package com.example.shopjava.configs.security;

import com.example.shopjava.entities.Cart;
import com.example.shopjava.entities.Favorite;
import com.example.shopjava.entities.Role;
import com.example.shopjava.entities.User;
import com.example.shopjava.repos.CartRepository;
import com.example.shopjava.repos.FavoriteRepository;
import com.example.shopjava.repos.UserRepository;
import com.example.shopjava.services.CartService;
import com.example.shopjava.services.FavoriteService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.Date;

import static org.springframework.security.web.context.HttpSessionSecurityContextRepository.SPRING_SECURITY_CONTEXT_KEY;

@Service
public class CustomUserDetailsService implements UserDetailsService {
    @Autowired
    private UserRepository userRepository;

    @Autowired
    AuthenticationManager authenticationManager;

    @Autowired
    private CartRepository cartRepository;

    @Autowired
    private FavoriteRepository favoriteRepository;

    private static final Logger log = LoggerFactory.getLogger(CustomUserDetailsService.class);

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        User user = userRepository.findByEmail(email);
        if (user == null) {
            throw new UsernameNotFoundException("User not found");
        }
        return new CustomUserDetails(user);
    }

    public String signUp(String email, String password, String repeatPSW, HttpServletRequest request) {
        User user = userRepository.findByEmail(email);
        if (user != null) {
            return "User with such email already exists";
        }
        user = new User();
        user.setEmail(email);
        if (!password.equals(repeatPSW)) {
            return "You haven't repeated password correctly";
        }
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        String encodedPassword = passwordEncoder.encode(password);
        user.setPassword(encodedPassword);
        user.setRole(Role.USER);
        Favorite favorite = new Favorite();
        favorite.setUser(user);
        Cart cart = new Cart(0, 0);
        cart.setUser(user);
        user.setFavorite(favorite);
        user.setCart(cart);
        userRepository.save(user);
        return "";
    }

    public String signIn(String email, String password, HttpServletRequest request) {
        log.info("Sign in method is opened");
        User user = userRepository.findByEmail(email);
        if (user == null) {
            log.warn("Wrong email");
            return "Email was wrong";
        }
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        if (!passwordEncoder.matches(password, user.getPassword())) {
            log.warn("Wrong password");
            return "Password was wrong";
        }

        UsernamePasswordAuthenticationToken authReq
                = new UsernamePasswordAuthenticationToken(user.getEmail(), password);
        Authentication auth = authenticationManager.authenticate(authReq);
        SecurityContext sc = SecurityContextHolder.getContext();
        sc.setAuthentication(auth);
        HttpSession session = request.getSession(true);
        session.setAttribute(SPRING_SECURITY_CONTEXT_KEY, sc);
        log.info("Login was successful: " + email);
        return "";
    }

    public User getUserByEmail(String email) {
        return userRepository.findByEmail(email);
    }

    @PostConstruct
    public void createDefaultAdmin(){
        User user = userRepository.findByEmail("somemail@gmail.com");
        if (user != null) {
            log.info("Admin has already exists");
            return;
        }
        user = new User();
        user.setEmail("somemail@gmail.com");
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        String encodedPassword = passwordEncoder.encode("somePassword");
        user.setPassword(encodedPassword);
        user.setRole(Role.ADMIN);
        Favorite favorite = new Favorite();
        favorite.setUser(user);
        Cart cart = new Cart(0, 0);
        cart.setUser(user);
        user.setFavorite(favorite);
        user.setCart(cart);
        userRepository.save(user);
    }

    public void saveUser(User user){
        userRepository.save(user);
    }
}
