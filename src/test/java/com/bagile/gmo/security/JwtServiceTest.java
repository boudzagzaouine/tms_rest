package com.bagile.gmo.security;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * Pure unit test of the JWT round-trip (no Spring context, no database).
 * Proves generate -> validate -> extract and that tampered/garbage tokens are rejected.
 */
class JwtServiceTest {

    private static final String SECRET = "tms-voieexpress-dev-secret-change-me-in-production-0123456789";
    private final JwtService jwt = new JwtService(SECRET, 3_600_000L);

    @Test
    void generatedTokenIsValidAndCarriesClaims() {
        String token = jwt.generateToken("ems@ems.com", 6L, List.of("USER", "ACCOUNT_VIEW"));

        assertTrue(jwt.isValid(token), "freshly generated token must validate");
        assertEquals("ems@ems.com", jwt.extractUsername(token));
        assertTrue(jwt.extractRoles(token).contains("ACCOUNT_VIEW"));
        assertTrue(jwt.extractRoles(token).contains("USER"));
    }

    @Test
    void tamperedOrGarbageTokensAreRejected() {
        String token = jwt.generateToken("ems@ems.com", 6L, List.of("USER"));

        assertFalse(jwt.isValid(token + "tampered"), "tampered signature must be rejected");
        assertFalse(jwt.isValid("not.a.jwt"), "garbage must be rejected");
        assertFalse(jwt.isValid(""), "empty must be rejected");
    }

    @Test
    void aTokenSignedWithADifferentSecretIsRejected() {
        JwtService other = new JwtService("a-totally-different-secret-key-of-sufficient-length-123456", 3_600_000L);
        String foreign = other.generateToken("ems@ems.com", 6L, List.of("USER"));

        assertFalse(jwt.isValid(foreign), "token signed by another key must be rejected");
    }
}
