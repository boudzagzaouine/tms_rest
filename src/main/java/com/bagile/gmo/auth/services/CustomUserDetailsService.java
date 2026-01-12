package com.bagile.gmo.auth.services;

import com.bagile.gmo.auth.entities.PermissionEntity;
import com.bagile.gmo.auth.entities.RoleEntity;
import com.bagile.gmo.auth.entities.UserEntity;
import com.bagile.gmo.auth.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Primary;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;
import java.util.stream.Collectors;

@Primary
@Service("authUserDetailsService")
public class CustomUserDetailsService implements org.springframework.security.core.userdetails.UserDetailsService {

    private final UserRepository userRepository;

    public CustomUserDetailsService(@Qualifier("authUserRepository") UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    @Transactional(readOnly = true)
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        UserEntity user = userRepository.findByEmail(username)
                .orElseThrow(() -> new UsernameNotFoundException("User not found: " + username));

        // collect permissions from roles
        Set<String> perms = new HashSet<>();
        if (user.getRoles() != null) {
            for (RoleEntity role : user.getRoles()) {
                if (role.getPermissions() != null) {
                    for (PermissionEntity p : role.getPermissions()) {
                        perms.add(p.getName());
                    }
                }
            }
        }

        List<GrantedAuthority> authorities = perms.stream().map(SimpleGrantedAuthority::new).collect(Collectors.toList());

        return org.springframework.security.core.userdetails.User.builder()
                .username(user.getEmail())
                .password(user.getPassword())
                .authorities(authorities)
                .accountExpired(false)
                .accountLocked(false)
                .credentialsExpired(false)
                .disabled(!user.isEnabled())
                .build();
    }
}
