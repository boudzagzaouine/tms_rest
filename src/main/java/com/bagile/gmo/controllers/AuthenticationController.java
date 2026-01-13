package com.bagile.gmo.controllers;

import com.bagile.gmo.login.LoginRequest;
import com.bagile.gmo.auth.security.JwtTokenService;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/auth", produces = MediaType.APPLICATION_JSON_VALUE)
public class AuthenticationController {

    private final AuthenticationManager authenticationManager;
    private final JwtTokenService jwtTokenService;
    private final UserDetailsService authUserDetailsService;
    private final PasswordEncoder passwordEncoder;

    public AuthenticationController(AuthenticationManager authenticationManager,
                                    JwtTokenService jwtTokenService,
                                    @Qualifier("authUserDetailsService") UserDetailsService authUserDetailsService,
                                    PasswordEncoder passwordEncoder) {
        this.authenticationManager = authenticationManager;
        this.jwtTokenService = jwtTokenService;
        this.authUserDetailsService = authUserDetailsService;
        this.passwordEncoder = passwordEncoder;
    }

    @PostMapping(value = "/login", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<AuthResponse> login(@RequestBody LoginRequest request) {
        // Pre-check: load user and verify password to give clearer error messages
        UserDetails preloaded;
        try {
            preloaded = authUserDetailsService.loadUserByUsername(request.getEmail());
        } catch (UsernameNotFoundException ex) {
            AuthResponse body = new AuthResponse(false, null, null, "Bad credentials: user not found");
            return ResponseEntity.status(401).contentType(MediaType.APPLICATION_JSON).body(body);
        }

        if (!passwordEncoder.matches(request.getPassword(), preloaded.getPassword())) {
            AuthResponse body = new AuthResponse(false, null, null, "Bad credentials: password mismatch");
            return ResponseEntity.status(401).contentType(MediaType.APPLICATION_JSON).body(body);
        }

        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(request.getEmail(), request.getPassword())
        );

        Object principal = authentication.getPrincipal();
        UserDetails userDetails;
        if (principal instanceof UserDetails) {
            userDetails = (UserDetails) principal;
        } else {
            // fallback: try loading by username (shouldn't normally happen)
            userDetails = org.springframework.security.core.userdetails.User
                    .withUsername(request.getEmail())
                    .password("")
                    .authorities(new java.util.ArrayList<>())
                    .accountExpired(false)
                    .accountLocked(false)
                    .credentialsExpired(false)
                    .disabled(false)
                    .build();
        }

        String token = jwtTokenService.generateToken(userDetails);

        AuthResponse resp = new AuthResponse(true, token, "Bearer", "User logged in successfully with email: " + userDetails.getUsername());
        return ResponseEntity.ok().contentType(MediaType.APPLICATION_JSON).body(resp);
    }
}
