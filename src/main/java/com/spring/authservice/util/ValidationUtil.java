package com.spring.authservice.util;

import com.spring.authservice.models.UserInfoDto;

public class ValidationUtil {

    public static void validateUserAttributes(UserInfoDto dto) {

        if (dto.getUsername() == null || dto.getUsername().isBlank()) {
            throw new IllegalArgumentException("Username cannot be empty");
        }

        if (dto.getEmail() != null &&
                !dto.getEmail().matches("^[A-Za-z0-9+_.-]+@(.+)$")) {
            throw new IllegalArgumentException("Invalid email format");
        }

        if (dto.getPassword() == null || dto.getPassword().length() < 6) {
            throw new IllegalArgumentException("Password must be at least 6 characters");
        }
    }

}
