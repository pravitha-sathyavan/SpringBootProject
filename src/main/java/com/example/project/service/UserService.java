package com.example.project.service;

import com.example.project.domain.User;
import com.example.project.persistance.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    private UserRepository userRepository;

    public UserService(UserRepository userRepository){
        this.userRepository = userRepository;
    }
    public List<User> getUsers(){
        return userRepository.findAll();
    }
}
