package com.lazycoffee.Sec2_Building_RESTful_Services_with_Spring.jwtutils;


import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service  // This makes the class a Spring Bean
public class CustomUserDetailsService implements UserDetailsService {

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        // Here you can fetch the user from a database
        // For now, let's use a hardcoded user for demonstration
        if ("user".equals(username)) {
            return new User("user", "{noop}password", new ArrayList<>()); // {noop} for no password encoding
        } else {
            throw new UsernameNotFoundException("User not found with username: " + username);
        }
    }
}