package com.springboot.crudapplication.security.config;

import com.springboot.crudapplication.security.model.User;
import com.springboot.crudapplication.security.repo.UserRepository;
import com.springboot.crudapplication.security.service.CustomUserDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Configuration
@EnableWebSecurity
public class WebSecurityConfiguration extends WebSecurityConfigurerAdapter {

//    @Autowired
//    UserDetailsService service;

    @Autowired
    UserRepository repo;

    @Bean
    AuthenticationProvider authProvider() {
        DaoAuthenticationProvider dao = new DaoAuthenticationProvider();

        /*Inner class to override loadUserByUsername
        instead of class AuthenticationService
         */
        UserDetailsService service =new UserDetailsService(){
            @Override
            public UserDetails loadUserByUsername(String name) throws UsernameNotFoundException {
                //Checks repository for the user
                User user = repo.findByName(name);
                //If missing
                if (user == null) throw new UsernameNotFoundException("UnAuthorized");
                //Else set user details returned from the repo
                return new CustomUserDetailsService(user);
            }
        };

        //to Load by username
        dao.setUserDetailsService(service);
        //To decrypt the password
        dao.setPasswordEncoder(new BCryptPasswordEncoder());
        return dao;
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
                .antMatchers("/")
                .permitAll()
                .regexMatchers("/api/*")
                .permitAll()
                .antMatchers(HttpMethod.POST,"/api/**")
                .hasAuthority("USER")
                .antMatchers(HttpMethod.GET,"/api/order/**")
                .hasAuthority("USER")
                .antMatchers("/home")
                .hasAuthority("USER")
                .antMatchers("/admin")
                .hasAuthority("ADMIN")
                .anyRequest()
                .authenticated()
                .and()
                .csrf().disable()
                .httpBasic();

    }
}
