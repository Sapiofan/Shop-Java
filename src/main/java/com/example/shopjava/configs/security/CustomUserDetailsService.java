package com.example.shopjava.configs.security;

import com.example.shopjava.entities.Role;
import com.example.shopjava.entities.User;
import com.example.shopjava.repos.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class CustomUserDetailsService implements UserDetailsService {
    @Autowired
    private UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        User user = userRepository.findByEmail(email);
        if (user == null) {
            throw new UsernameNotFoundException("User not found");
        }
        return new CustomUserDetails(user);
    }

    public String signUp(String email, String password, String repeatPSW) {
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
        return "";
    }
}
