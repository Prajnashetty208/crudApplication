package com.springboot.crudapplication.security.service;

import com.springboot.crudapplication.security.model.User;
import com.springboot.crudapplication.security.repo.UserRepository;
import com.springboot.crudapplication.security.service.CustomUserDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;


@Service
public class AuthenticationService implements UserDetailsService {
    @Autowired
    UserRepository repo;

    @Override
    public UserDetails loadUserByUsername(String name) throws UsernameNotFoundException {
        //Checks repository for the user
        User user = repo.findByName(name);
        //If missing
        if (user == null)
            throw new UsernameNotFoundException("UnAuthorized");
        //Else SET user details returned from the repo
        return new CustomUserDetailsService(user);
    }

}
