package com.bagile.gmo.auth.security;

import com.bagile.gmo.util.TokenUtils;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

@Service
public class JwtTokenService {

    private final TokenUtils tokenUtils;

    public JwtTokenService(TokenUtils tokenUtils) {
        this.tokenUtils = tokenUtils;
    }

    public String generateToken(UserDetails user) {
        return tokenUtils.createToken(user);
    }
}
