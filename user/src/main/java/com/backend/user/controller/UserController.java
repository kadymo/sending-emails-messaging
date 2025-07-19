package com.backend.user.controller;

import com.backend.user.domain.dto.UserDto;
import com.backend.user.producer.UserProducer;
import com.backend.user.service.UserService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/users")
public class UserController {
    private final UserService service;

    public UserController(UserService service, UserProducer producer) {
        this.service = service;
    }

    @PostMapping
    public UserDto createUser(@RequestBody UserDto user) {
        UserDto createdUser = service.createUser(user);
        return createdUser;
    }
}
