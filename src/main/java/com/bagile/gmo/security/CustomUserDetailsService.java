package com.bagile.gmo.security;

import com.bagile.gmo.entities.UsrGroupHabilitation;
import com.bagile.gmo.entities.UsrHabilitation;
import com.bagile.gmo.entities.UsrUser;
import com.bagile.gmo.repositories.UserRepository;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Service("customUserDetailsService")
public class CustomUserDetailsService implements org.springframework.security.core.userdetails.UserDetailsService {

    private final UserRepository userRepository;

    public CustomUserDetailsService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    @Transactional(readOnly = true)
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        UsrUser user = userRepository.findByUsrUserEmail(username);
        if (user == null || user.getUsrUserIsActive() == null || !user.getUsrUserIsActive()) {
            throw new UsernameNotFoundException("User not found or not active: " + username);
        }

        // Collect permissions (habilitation codes) from user's group
        Set<UsrGroupHabilitation> groupHabs = null;
        if (user.getUsrUserGroup() != null) {
            groupHabs = user.getUsrUserGroup().getUsrGroupHabilitations();
        }

        List<GrantedAuthority> authorities;
        if (groupHabs == null || groupHabs.isEmpty()) {
            authorities = Collections.emptyList();
        } else {
            authorities = groupHabs.stream()
                    .map(UsrGroupHabilitation::getUsrHabilitation)
                    .filter(h -> h != null && h.getUsrHabilitationCode() != null)
                    .map(UsrHabilitation::getUsrHabilitationCode)
                    .map(SimpleGrantedAuthority::new)
                    .collect(Collectors.toList());
        }

        return org.springframework.security.core.userdetails.User.builder()
                .username(user.getUsrUserEmail())
                .password(user.getUsrUserPassword())
                .authorities(authorities)
                .accountExpired(false)
                .accountLocked(false)
                .credentialsExpired(false)
                .disabled(!user.getUsrUserIsActive())
                .build();
    }
}
