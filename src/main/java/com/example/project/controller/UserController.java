package com.example.project.controller;

import com.example.project.domain.User;
import com.example.project.service.UserService;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

public class UserController {

    private UserService userService;

    public UserController(UserService userService){
        this.userService = userService;
    }

    @GetMapping("/users")
    public List<User> getUsers(){
        return userService.getUsers();
    }
}

