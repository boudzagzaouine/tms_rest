package com.bagile.gmo.security;

import com.bagile.gmo.dto.User;
import com.bagile.gmo.services.UserService;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;

@Service
public class CustomUserDetailsService implements org.springframework.security.core.userdetails.UserDetailsService {

    private final UserService userService;

    public CustomUserDetailsService(UserService userService) {
        this.userService = userService;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        // The existing service API requires email+password; use empty password to lookup by email only.
        User user = userService.findByEmailAndPassowrd(username, "");
        if (user == null) {
            throw new UsernameNotFoundException("User not found: " + username);
        }

        // The project User DTO does expose isActive() as primitive boolean and has getPassword()/getEmail().
        // Map permissions later; here provide a default authority while preserving active state.
        List<GrantedAuthority> authorities = Collections.singletonList(new SimpleGrantedAuthority("ROLE_USER"));

        boolean active = user.isActive();
        boolean disabled = !active;

        return org.springframework.security.core.userdetails.User.builder()
                .username(user.getEmail())
                .password(user.getPassword())
                .authorities(authorities)
                .accountLocked(false)
                .disabled(disabled)
                .build();
    }
}
