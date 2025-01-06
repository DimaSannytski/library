package com.ua.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.ua.entity.User;
import com.ua.service.UserService;

@Service
public class CustomUserDetailService implements UserDetailsService {

    @Autowired
    private UserService userService;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        final User user = userService.findByEmail(username);
        if (user == null) {
            throw new UsernameNotFoundException(username);
        }
        UserDetails userDetails = 
        		org.springframework.security.core.userdetails.User.withUsername(
        				user.getEmail()).password(user.getPassword()).authorities(user.getRole().toString()).build();

        return userDetails;
    }
}
