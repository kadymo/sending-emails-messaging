package com.backend.user.service;

import com.backend.user.domain.User;
import com.backend.user.domain.dto.UserDto;
import com.backend.user.domain.mapper.UserMapper;
import com.backend.user.repository.UserRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class UserService {
    private final UserRepository repository;
    private final UserMapper mapper;

    public UserService(UserRepository repository, UserMapper mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }

    @Transactional
    public UserDto createUser(UserDto user) {
        User newUser = User.builder()
                .email(user.getEmail())
                .username(user.getUsername())
                .build();

        User savedUser = repository.save(newUser);
        return mapper.toUserDto(savedUser);
    }
}
