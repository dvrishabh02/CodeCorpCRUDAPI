package com.CodeCorpApi.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.JdbcUserDetailsManager;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.sql.DataSource;

@RestController
public class UserController {

    @Autowired
    PasswordEncoder encode;

   @Autowired
    DataSource dataSource;

    @PostMapping("/register")
    public String registerUser(@RequestParam String userName, @RequestParam String password, @RequestParam String Role) {

        UserDetails user1 = User.withUsername(userName)
                .password(encode.encode(password))
                .roles(Role)
                .build();
        JdbcUserDetailsManager jdbcUserDetailsManager = new JdbcUserDetailsManager(dataSource);
        jdbcUserDetailsManager.createUser(user1);
        return "User registered successfully!";
    }
}