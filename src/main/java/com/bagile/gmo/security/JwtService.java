package com.bagile.gmo.security;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.JwtException;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import javax.crypto.SecretKey;
import java.nio.charset.StandardCharsets;
import java.util.Collections;
import java.util.Date;
import java.util.List;

/**
 * Stateless JWT provider. Tokens are signed with HS256 and carry the user's email as subject,
 * the user id and the list of habilitation codes (the application's existing authorities) as
 * claims. No server-side session or DB lookup is needed to validate a token.
 */
@Service
public class JwtService {

    private final SecretKey key;
    private final long expirationMs;

    public JwtService(@Value("${jwt.secret}") String secret,
                      @Value("${jwt.expiration-ms}") long expirationMs) {
        // HS256 requires a key of at least 256 bits (32 bytes).
        this.key = Keys.hmacShaKeyFor(secret.getBytes(StandardCharsets.UTF_8));
        this.expirationMs = expirationMs;
    }

    /** Milliseconds the issued tokens stay valid (used to populate the login response). */
    public long getExpirationMs() {
        return expirationMs;
    }

    /**
     * Builds a signed JWT carrying only the user's identity (small token). Authorities/habilitations
     * are NOT embedded; they are loaded from the user store on each request by the auth filter.
     */
    public String generateToken(String username, Long userId) {
        Date now = new Date();
        Date expiry = new Date(now.getTime() + expirationMs);
        return Jwts.builder()
                .subject(username)
                .claim("uid", userId)
                .issuedAt(now)
                .expiration(expiry)
                .signWith(key)
                .compact();
    }

    /** Returns true if the token's signature is valid and it has not expired. */
    public boolean isValid(String token) {
        try {
            parse(token);
            return true;
        } catch (JwtException | IllegalArgumentException ex) {
            return false;
        }
    }

    /** Extracts the username (subject). Returns null if the token cannot be parsed. */
    public String extractUsername(String token) {
        try {
            return parse(token).getSubject();
        } catch (JwtException | IllegalArgumentException ex) {
            return null;
        }
    }

    /** Extracts the habilitation codes carried in the {@code roles} claim. */
    @SuppressWarnings("unchecked")
    public List<String> extractRoles(String token) {
        try {
            Object roles = parse(token).get("roles");
            if (roles instanceof List<?>) {
                return (List<String>) roles;
            }
            return Collections.emptyList();
        } catch (JwtException | IllegalArgumentException ex) {
            return Collections.emptyList();
        }
    }

    private Claims parse(String token) {
        return Jwts.parser()
                .verifyWith(key)
                .build()
                .parseSignedClaims(token)
                .getPayload();
    }
}
