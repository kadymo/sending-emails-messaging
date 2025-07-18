package com.backend.user.domain.mapper;

import com.backend.user.domain.User;
import com.backend.user.domain.dto.UserDto;
import org.springframework.stereotype.Component;

@Component
public class UserMapper {
    public UserDto toUserDto(User user) {
        if (user == null) {
            return null;
        }

        return UserDto.builder()
                .email(user.getEmail())
                .username(user.getUsername())
                .build();
    }

    public User toUser(UserDto userDto) {
        if (userDto == null) {
            return null;
        }

        return User.builder()
                .email(userDto.getEmail())
                .username(userDto.getUsername())
                .build();
    }
}
