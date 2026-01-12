package com.bagile.gmo.auth.controller;

import com.bagile.gmo.auth.entities.UserEntity;
import com.bagile.gmo.auth.repositories.UserRepository;
import com.bagile.gmo.login.LoginRequest;
import org.springframework.context.annotation.Profile;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/dev/auth")
@Profile("dev")
public class DebugAuthController {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    public DebugAuthController(UserRepository userRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @PostMapping("/check-password")
    public ResponseEntity<?> checkPassword(@RequestBody LoginRequest request) {
        String email = request.getEmail();
        String raw = request.getPassword();

        return userRepository.findByEmail(email)
                .map(user -> {
                    boolean matches = passwordEncoder.matches(raw, user.getPassword());
                    Map<String, Object> resp = new HashMap<>();
                    resp.put("email", email);
                    resp.put("exists", true);
                    resp.put("matches", matches);
                    // include masked hash length and prefix for debugging only
                    String hash = user.getPassword();
                    String masked = hash == null ? null : (hash.length() <= 10 ? hash : hash.substring(0, 6) + "...len=" + hash.length());
                    resp.put("storedHashPreview", masked);
                    return ResponseEntity.ok(resp);
                })
                .orElseGet(() -> {
                    Map<String, Object> resp = new HashMap<>();
                    resp.put("email", email);
                    resp.put("exists", false);
                    resp.put("matches", false);
                    return ResponseEntity.status(404).body(resp);
                });
    }

    @PostMapping("/recreate-user")
    public ResponseEntity<?> recreateUser(@RequestBody LoginRequest request) {
        String email = request.getEmail();
        String raw = request.getPassword();

        // delete existing if present
        userRepository.findByEmail(email).ifPresent(userRepository::delete);

        UserEntity user = new UserEntity();
        user.setEmail(email);
        user.setPassword(passwordEncoder.encode(raw));
        user.setEnabled(true);

        userRepository.save(user);

        Map<String, Object> resp = new HashMap<>();
        resp.put("email", email);
        resp.put("created", true);
        resp.put("storedHashPreview", user.getPassword().length() <= 10 ? user.getPassword() : user.getPassword().substring(0,6) + "...len=" + user.getPassword().length());
        return ResponseEntity.ok(resp);
    }
}
