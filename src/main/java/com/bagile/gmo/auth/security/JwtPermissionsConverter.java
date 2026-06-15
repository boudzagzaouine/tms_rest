package com.bagile.gmo.auth.security;

import org.springframework.core.convert.converter.Converter;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

import java.util.*;
import java.util.stream.Collectors;

// This class will be used by JwtAuthenticationConverter (when oauth2 classes are available).
// To avoid a hard dependency here in the current project state we keep a simple shape.
public class JwtPermissionsConverter implements Converter<Object, Collection<GrantedAuthority>> {

    private final String claimName;

    public JwtPermissionsConverter() { this("permissions"); }

    public JwtPermissionsConverter(String claimName) { this.claimName = claimName; }

    @Override
    @SuppressWarnings("unchecked")
    public Collection<GrantedAuthority> convert(Object source) {
        if (source == null) return Collections.emptySet();
        Collection<String> perms = new HashSet<>();
        if (source instanceof Map) {
            Object claim = ((Map<String, Object>) source).get(claimName);
            if (claim instanceof Collection) {
                perms = ((Collection<?>) claim).stream().map(Object::toString).collect(Collectors.toSet());
            } else if (claim instanceof String) {
                perms = Arrays.stream(((String) claim).split(","))
                        .map(String::trim).filter(s->!s.isEmpty()).collect(Collectors.toSet());
            }
        } else if (source instanceof Collection) {
            perms = ((Collection<?>) source).stream().map(Object::toString).collect(Collectors.toSet());
        }
        return perms.stream().map(SimpleGrantedAuthority::new).collect(Collectors.toSet());
    }
}
