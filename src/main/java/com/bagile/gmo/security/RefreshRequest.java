package com.bagile.gmo.security;

import jakarta.validation.constraints.NotBlank;

/** Body posted to {@code POST /api/auth/refresh} to obtain a new access token. */
public record RefreshRequest(
        @NotBlank(message = "refreshToken is required") String refreshToken) {
}
