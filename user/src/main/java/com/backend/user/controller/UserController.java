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
    private final UserProducer producer;

    public UserController(UserService service, UserProducer producer) {
        this.service = service;
        this.producer = producer;
    }

    @PostMapping
    public UserDto createUser(@RequestBody UserDto user) {
        UserDto createdUser = service.createUser(user);
        producer.sendMessage(createdUser);
        return createdUser;
    }
}
