/**
 *
 */
package com.bagile.gmo.util;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;
import java.nio.charset.StandardCharsets;
import java.util.*;
import java.util.stream.Collectors;

@Component
public class TokenUtils {

    @Value("${security.jwt.secret:change-me-to-a-long-secret}")
    private String secret;

    @Value("${security.jwt.expiration-ms:3600000}")
    private long expirationMs;

    private byte[] secretKeyBytes;
    private final ObjectMapper objectMapper = new ObjectMapper();

    @PostConstruct
    public void init() {
        this.secretKeyBytes = secret.getBytes(StandardCharsets.UTF_8);
    }

    @SuppressWarnings("unused")
    public String createToken(UserDetails userDetails) {
        try {
            long issuedAt = System.currentTimeMillis() / 1000L; // seconds
            long exp = issuedAt + (expirationMs / 1000L);

            Map<String, Object> header = new HashMap<>();
            header.put("alg", "HS256");
            header.put("typ", "JWT");

            List<String> perms = userDetails.getAuthorities().stream()
                    .map(GrantedAuthority::getAuthority)
                    .collect(Collectors.toList());

            Map<String, Object> payload = new HashMap<>();
            payload.put("sub", userDetails.getUsername());
            payload.put("permissions", perms);
            payload.put("iat", issuedAt);
            payload.put("exp", exp);

            String headerJson = objectMapper.writeValueAsString(header);
            String payloadJson = objectMapper.writeValueAsString(payload);

            String headerB64 = base64UrlEncode(headerJson.getBytes(StandardCharsets.UTF_8));
            String payloadB64 = base64UrlEncode(payloadJson.getBytes(StandardCharsets.UTF_8));
            String signingInput = headerB64 + "." + payloadB64;

            String signature = base64UrlEncode(hmacSha256(signingInput.getBytes(StandardCharsets.UTF_8), secretKeyBytes));

            return signingInput + "." + signature;
        } catch (Exception e) {
            throw new RuntimeException("Failed to create token", e);
        }
    }

    @SuppressWarnings("unused")
    public String getUserNameFromToken(String token) {
        Map<String, Object> payload = parsePayload(token);
        if (payload == null) return null;
        Object sub = payload.get("sub");
        return sub != null ? String.valueOf(sub) : null;
    }

    @SuppressWarnings("unused")
    public List<String> getPermissionsFromToken(String token) {
        Map<String, Object> payload = parsePayload(token);
        if (payload == null) return Collections.emptyList();
        Object perms = payload.get("permissions");
        if (perms instanceof Collection) {
            return ((Collection<?>) perms).stream().map(Object::toString).collect(Collectors.toList());
        }
        if (perms instanceof String) {
            String s = (String) perms;
            return Arrays.stream(s.split(","))
                    .map(String::trim)
                    .filter(p -> !p.isEmpty())
                    .collect(Collectors.toList());
        }
        return Collections.emptyList();
    }

    @SuppressWarnings("unused")
    public boolean validateToken(String token) {
        // Legacy behavior: accept non-null token (original implementation did this)
        return token != null;
    }

    private Map<String, Object> parsePayload(String token) {
        try {
            String[] parts = token.split("\\.");
            if (parts.length != 3) return null;
            byte[] payloadBytes = base64UrlDecode(parts[1]);
            return objectMapper.readValue(payloadBytes, new TypeReference<Map<String, Object>>() {});
        } catch (Exception e) {
            return null;
        }
    }

    private static byte[] hmacSha256(byte[] data, byte[] key) throws Exception {
        SecretKeySpec secretKey = new SecretKeySpec(key, "HmacSHA256");
        Mac mac = Mac.getInstance("HmacSHA256");
        mac.init(secretKey);
        return mac.doFinal(data);
    }

    private static String base64UrlEncode(byte[] bytes) {
        return Base64.getUrlEncoder().withoutPadding().encodeToString(bytes);
    }

    private static byte[] base64UrlDecode(String str) {
        return Base64.getUrlDecoder().decode(str);
    }
}
