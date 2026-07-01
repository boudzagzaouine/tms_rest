package com.bagile.gmo.controllers;

import com.bagile.gmo.dto.User;
import com.bagile.gmo.security.JwtService;
import com.bagile.gmo.security.LoginRequest;
import com.bagile.gmo.security.RefreshRequest;
import com.bagile.gmo.services.UserService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.util.DigestUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.nio.charset.StandardCharsets;
import java.time.Instant;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * Issues a short-lived access token + a long-lived refresh token for valid credentials, and returns
 * the full user profile in the same response so the frontend needs a single login call. The stored
 * password is MD5, so the submitted (plain) password is MD5-hashed here and compared against the
 * existing user store. Habilitations are NOT in the token; {@code JwtAuthenticationFilter} loads
 * them from the user store on each request.
 */
@RestController
@RequestMapping("/api/auth")
public class AuthenticationController {

    private final UserService userService;
    private final JwtService jwtService;

    public AuthenticationController(UserService userService, JwtService jwtService) {
        this.userService = userService;
        this.jwtService = jwtService;
    }

    @PostMapping(value = "/login", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> login(@Valid @RequestBody LoginRequest request) {
        String md5Password = DigestUtils.md5DigestAsHex(
                request.password().getBytes(StandardCharsets.UTF_8));

        // findByEmailAndPassowrd only returns active users matching the (email, md5) pair.
        User user = userService.findByEmailAndPassowrd(request.email(), md5Password);
        if (user == null) {
            return unauthorized("Invalid email or password");
        }

        Map<String, Object> body = new LinkedHashMap<>();
        body.put("accessToken", jwtService.generateToken(request.email(), user.getId()));
        body.put("refreshToken", jwtService.generateRefreshToken(request.email(), user.getId()));
        body.put("tokenType", "Bearer");
        body.put("expiresIn", jwtService.getExpirationMs() / 1000);
        // Full profile (userGroup, habilitations, owner, ...) so the frontend needs a single call.
        body.put("user", user);

        return ResponseEntity.ok(body);
    }

    /** Exchanges a valid refresh token for a new access token (no re-authentication). */
    @PostMapping(value = "/refresh", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> refresh(@Valid @RequestBody RefreshRequest request) {
        String refreshToken = request.refreshToken();
        if (!jwtService.isRefreshToken(refreshToken)) {
            return unauthorized("Invalid or expired refresh token");
        }
        String username = jwtService.extractUsername(refreshToken);
        Long userId = jwtService.extractUserId(refreshToken);
        if (username == null) {
            return unauthorized("Invalid refresh token");
        }

        Map<String, Object> body = new LinkedHashMap<>();
        body.put("accessToken", jwtService.generateToken(username, userId));
        body.put("tokenType", "Bearer");
        body.put("expiresIn", jwtService.getExpirationMs() / 1000);
        return ResponseEntity.ok(body);
    }

    private ResponseEntity<Map<String, Object>> unauthorized(String message) {
        Map<String, Object> error = new LinkedHashMap<>();
        error.put("timestamp", Instant.now().toString());
        error.put("status", HttpStatus.UNAUTHORIZED.value());
        error.put("message", message);
        return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(error);
    }
}
