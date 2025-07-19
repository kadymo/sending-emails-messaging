package com.backend.user.service;

import com.backend.user.domain.User;
import com.backend.user.domain.dto.UserDto;
import com.backend.user.domain.mapper.UserMapper;
import com.backend.user.producer.UserProducer;
import com.backend.user.repository.UserRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class UserService {
    private final UserRepository repository;
    private final UserProducer producer;
    private final UserMapper mapper;

    public UserService(UserRepository repository, UserProducer producer,UserMapper mapper) {
        this.repository = repository;
        this.producer = producer;
        this.mapper = mapper;
    }

    @Transactional
    public UserDto createUser(UserDto user) {
        User newUser = User.builder()
                .email(user.getEmail())
                .username(user.getUsername())
                .build();

        User savedUser = repository.save(newUser);
        UserDto dto = mapper.toUserDto(savedUser);
        producer.sendMessage(dto);
        return dto;
    }
}
