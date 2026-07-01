package com.bagile.gmo.security;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * Pure unit test of the JWT round-trip (no Spring context, no database).
 * Proves generate -> validate -> extract identity and that tampered/garbage tokens are rejected.
 * (The token carries only identity now; authorities are loaded from the user store per request.)
 */
class JwtServiceTest {

    private static final String SECRET = "tms-voieexpress-dev-secret-change-me-in-production-0123456789";
    private final JwtService jwt = new JwtService(SECRET, 3_600_000L, 604_800_000L);

    @Test
    void generatedTokenIsValidAndCarriesIdentity() {
        String token = jwt.generateToken("ems@ems.com", 6L);

        assertTrue(jwt.isValid(token), "freshly generated token must validate");
        assertEquals("ems@ems.com", jwt.extractUsername(token));
    }

    @Test
    void tamperedOrGarbageTokensAreRejected() {
        String token = jwt.generateToken("ems@ems.com", 6L);

        assertFalse(jwt.isValid(token + "tampered"), "tampered signature must be rejected");
        assertFalse(jwt.isValid("not.a.jwt"), "garbage must be rejected");
        assertFalse(jwt.isValid(""), "empty must be rejected");
    }

    @Test
    void aTokenSignedWithADifferentSecretIsRejected() {
        JwtService other = new JwtService("a-totally-different-secret-key-of-sufficient-length-123456", 3_600_000L, 604_800_000L);
        String foreign = other.generateToken("ems@ems.com", 6L);

        assertFalse(jwt.isValid(foreign), "token signed by another key must be rejected");
    }

    @Test
    void accessAndRefreshTokensAreDistinguished() {
        String access = jwt.generateToken("ems@ems.com", 6L);
        String refresh = jwt.generateRefreshToken("ems@ems.com", 6L);

        assertTrue(jwt.isAccessToken(access));
        assertFalse(jwt.isRefreshToken(access));
        assertTrue(jwt.isRefreshToken(refresh));
        assertFalse(jwt.isAccessToken(refresh), "a refresh token must not authenticate API calls");
    }
}
