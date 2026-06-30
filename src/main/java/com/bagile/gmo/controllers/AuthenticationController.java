package com.bagile.gmo.controllers;

import com.bagile.gmo.dto.User;
import com.bagile.gmo.dto.UserGroup;
import com.bagile.gmo.security.JwtService;
import com.bagile.gmo.security.LoginRequest;
import com.bagile.gmo.services.UserService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.util.DigestUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.nio.charset.StandardCharsets;
import java.time.Instant;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * Issues JWTs for valid credentials. The stored password is an MD5 hash, so the submitted
 * (plain) password is MD5-hashed here and compared against the existing user store; no password
 * data migration is required. The token carries the user's habilitation codes as authorities.
 */
@RestController
@RequestMapping("/api/auth")
public class AuthenticationController {

    private final UserService userService;
    private final UserDetailsService userDetailsService;
    private final JwtService jwtService;

    public AuthenticationController(UserService userService,
                                    @Qualifier("userDetailsService") UserDetailsService userDetailsService,
                                    JwtService jwtService) {
        this.userService = userService;
        this.userDetailsService = userDetailsService;
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

        // Reload via the standard UserDetailsService so the token carries the user's real
        // authorities (habilitation codes), exactly as the rest of the app expects them.
        List<String> roles;
        try {
            UserDetails details = userDetailsService.loadUserByUsername(request.email());
            roles = details.getAuthorities().stream()
                    .map(GrantedAuthority::getAuthority)
                    .collect(Collectors.toList());
        } catch (UsernameNotFoundException | NullPointerException ex) {
            return unauthorized("Invalid email or password");
        }

        // Coarse role on top of the fine-grained habilitation codes: every authenticated user is a
        // USER; members of the "SUPER ADMIN" group are also ADMIN (drives /api/admin/** rules).
        roles.add("USER");
        UserGroup group = user.getUserGroup();
        if (group != null && group.getCode() != null
                && group.getCode().toUpperCase().contains("ADMIN")) {
            roles.add("ADMIN");
        }

        String token = jwtService.generateToken(request.email(), user.getId(), roles);

        Map<String, Object> userInfo = new LinkedHashMap<>();
        userInfo.put("id", user.getId());
        userInfo.put("username", request.email());
        userInfo.put("roles", roles);

        Map<String, Object> body = new LinkedHashMap<>();
        body.put("accessToken", token);
        body.put("tokenType", "Bearer");
        body.put("expiresIn", jwtService.getExpirationMs() / 1000);
        body.put("user", userInfo);

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
