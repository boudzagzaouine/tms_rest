package com.bagile.gmo.security;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.JwtException;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import javax.crypto.SecretKey;
import java.nio.charset.StandardCharsets;
import java.util.Date;

/**
 * Stateless JWT provider. Tokens carry only the user's identity (small tokens); authorities are
 * loaded from the user store on each request by {@link JwtAuthenticationFilter}.
 *
 * <p>Two token types, distinguished by the {@code type} claim:</p>
 * <ul>
 *   <li>{@code access} — short-lived, sent on every API call.</li>
 *   <li>{@code refresh} — long-lived, used only against {@code /api/auth/refresh} to mint a new
 *       access token so the user isn't forced to log in again when the access token expires.</li>
 * </ul>
 */
@Service
public class JwtService {

    private static final String CLAIM_TYPE = "type";
    private static final String TYPE_ACCESS = "access";
    private static final String TYPE_REFRESH = "refresh";

    private final SecretKey key;
    private final long expirationMs;
    private final long refreshExpirationMs;

    public JwtService(@Value("${jwt.secret}") String secret,
                      @Value("${jwt.expiration-ms}") long expirationMs,
                      @Value("${jwt.refresh-expiration-ms}") long refreshExpirationMs) {
        // HS256 requires a key of at least 256 bits (32 bytes).
        this.key = Keys.hmacShaKeyFor(secret.getBytes(StandardCharsets.UTF_8));
        this.expirationMs = expirationMs;
        this.refreshExpirationMs = refreshExpirationMs;
    }

    /** Access-token lifetime in ms (used to populate the login/refresh response). */
    public long getExpirationMs() {
        return expirationMs;
    }

    /** Short-lived access token, sent on every request. */
    public String generateToken(String username, Long userId) {
        return build(username, userId, TYPE_ACCESS, expirationMs);
    }

    /** Long-lived refresh token, used only to obtain new access tokens. */
    public String generateRefreshToken(String username, Long userId) {
        return build(username, userId, TYPE_REFRESH, refreshExpirationMs);
    }

    private String build(String username, Long userId, String type, long ttlMs) {
        Date now = new Date();
        return Jwts.builder()
                .subject(username)
                .claim("uid", userId)
                .claim(CLAIM_TYPE, type)
                .issuedAt(now)
                .expiration(new Date(now.getTime() + ttlMs))
                .signWith(key)
                .compact();
    }

    /** Valid signature + not expired. */
    public boolean isValid(String token) {
        try {
            parse(token);
            return true;
        } catch (JwtException | IllegalArgumentException ex) {
            return false;
        }
    }

    /** True only for a valid access token (a refresh token must not authenticate API calls). */
    public boolean isAccessToken(String token) {
        return isValid(token) && TYPE_ACCESS.equals(getType(token));
    }

    /** True only for a valid refresh token. */
    public boolean isRefreshToken(String token) {
        return isValid(token) && TYPE_REFRESH.equals(getType(token));
    }

    public String extractUsername(String token) {
        try {
            return parse(token).getSubject();
        } catch (JwtException | IllegalArgumentException ex) {
            return null;
        }
    }

    public Long extractUserId(String token) {
        try {
            Object uid = parse(token).get("uid");
            return uid == null ? null : Long.valueOf(String.valueOf(uid));
        } catch (Exception ex) {
            return null;
        }
    }

    private String getType(String token) {
        try {
            Object type = parse(token).get(CLAIM_TYPE);
            return type == null ? null : String.valueOf(type);
        } catch (JwtException | IllegalArgumentException ex) {
            return null;
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
