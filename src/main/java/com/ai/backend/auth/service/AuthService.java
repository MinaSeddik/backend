package com.ai.backend.auth.service;

import com.ai.backend.auth.dto.LoginRequest;
import com.ai.backend.auth.dto.LoginResponse;
import com.ai.backend.error.InvalidCredentialsException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.AuthenticationException;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Slf4j
public class AuthService {

    private static final String LOGIN_SUCCESS_MESSAGE = "Authentication successful";

    private final AuthenticationManager authenticationManager;

    public LoginResponse authenticate(LoginRequest request) {
        log.info("Authentication attempt received for username={}", request.username());

        try {
            authenticationManager.authenticate(
                    UsernamePasswordAuthenticationToken.unauthenticated(request.username(), request.password())
            );

            log.info("Authentication succeeded for username={}", request.username());
            return new LoginResponse(request.username(), LOGIN_SUCCESS_MESSAGE);
        } catch (AuthenticationException ex) {
            log.warn("Authentication failed for username={}", request.username());
            throw new InvalidCredentialsException("Invalid username or password");
        }
    }
}
