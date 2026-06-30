package com.bagile.gmo.security;

import jakarta.validation.constraints.NotBlank;

/** Credentials posted to {@code POST /api/auth/login}. */
public record LoginRequest(
        @NotBlank(message = "email is required") String email,
        @NotBlank(message = "password is required") String password) {
}
