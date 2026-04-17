package com.ai.backend.auth.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public record LoginRequest(
        @NotBlank(message = "username is required")
        @Size(max = 100, message = "username must not exceed 100 characters")
        String username,
        @NotBlank(message = "password is required")
        @Size(min = 8, max = 255, message = "password must be between 8 and 255 characters")
        String password
) {
}
