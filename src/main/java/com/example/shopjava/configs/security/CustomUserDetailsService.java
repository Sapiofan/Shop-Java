package com.example.shopjava.configs.security;

import com.example.shopjava.entities.Role;
import com.example.shopjava.entities.User;
import com.example.shopjava.repos.UserRepository;
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
        if(!password.equals(repeatPSW)){
            return "You haven't repeated password correctly";
        }
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        String encodedPassword = passwordEncoder.encode(password);
        user.setPassword(encodedPassword);
        user.setCreatedAt(new Date());
        user.setRole(Role.USER);
        userRepository.save(user);
        //Automatically sign in after registration
        signIn(email, password, request);
        return "";
    }

    public String signIn(String email, String password, HttpServletRequest request){
        User user = userRepository.findByEmail(email);
        if (user == null) {
            return "Email was wrong";
        }
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        if(!passwordEncoder.matches(password, user.getPassword())){
            return "Password was wrong";
        }

        UsernamePasswordAuthenticationToken authReq
                = new UsernamePasswordAuthenticationToken(user.getEmail(), password);
        Authentication auth = authenticationManager.authenticate(authReq);
        SecurityContext sc = SecurityContextHolder.getContext();
        sc.setAuthentication(auth);
        HttpSession session = request.getSession(true);
        session.setAttribute(SPRING_SECURITY_CONTEXT_KEY, sc);
        return "";
    }
}
