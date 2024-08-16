package com.CodeCorpApi.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.CodeCorpApi.Models.User;
import com.CodeCorpApi.Repos.UserRepository;

@RestController
public class UserController {

    @Autowired
    private UserRepository userRepository;


    @PostMapping("/register")
    public String registerUser(@RequestBody User user) {
        user.setPassword(user.getPassword());
        userRepository.save(user);
        return "User registered successfully!";
    }
}