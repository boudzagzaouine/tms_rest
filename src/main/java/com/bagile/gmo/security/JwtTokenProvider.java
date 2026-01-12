package com.bagile.gmo.security;

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
import java.util.Base64;
import java.util.HashMap;
import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.util.stream.Collectors;

@Component
public class JwtTokenProvider {

    @Value("${security.jwt.secret}")
    private String secret;

    @Value("${security.jwt.expiration-ms}")
    private long validityInMilliseconds;

    private byte[] secretKeyBytes;
    private final ObjectMapper objectMapper = new ObjectMapper();

    @PostConstruct
    public void init() {
        this.secretKeyBytes = secret.getBytes(StandardCharsets.UTF_8);
    }

    public String generateToken(UserDetails userDetails) {
        try {
            long issuedAt = System.currentTimeMillis() / 1000L; // seconds
            long exp = issuedAt + (validityInMilliseconds / 1000L);

            Map<String, Object> header = new HashMap<>();
            header.put("alg", "HS256");
            header.put("typ", "JWT");

            List<String> roles = userDetails.getAuthorities().stream()
                    .map(GrantedAuthority::getAuthority)
                    .collect(Collectors.toList());

            Map<String, Object> payload = new HashMap<>();
            payload.put("sub", userDetails.getUsername());
            payload.put("roles", roles);
            payload.put("iat", issuedAt);
            payload.put("exp", exp);

            String headerJson = objectMapper.writeValueAsString(header);
            String payloadJson = objectMapper.writeValueAsString(payload);

            String headerB64 = base64UrlEncode(headerJson.getBytes(StandardCharsets.UTF_8));
            String payloadB64 = base64UrlEncode(payloadJson.getBytes(StandardCharsets.UTF_8));

            String signingInput = headerB64 + "." + payloadB64;
            String signature = base64UrlEncode(hmacSha256(signingInput.getBytes(StandardCharsets.UTF_8), secretKeyBytes));

            return signingInput + "." + signature;
        } catch (Exception ex) {
            throw new RuntimeException("Failed to generate token", ex);
        }
    }

    public boolean validateToken(String token) {
        try {
            Map<String, Object> payload = parsePayload(token);
            if (payload == null) return false;
            Object expObj = payload.get("exp");
            if (expObj == null) return false;
            long exp = toLong(expObj);
            long now = System.currentTimeMillis() / 1000L;
            if (now > exp) return false;

            // verify signature
            String[] parts = token.split("\\.");
            if (parts.length != 3) return false;
            String signingInput = parts[0] + "." + parts[1];
            String expectedSig = base64UrlEncode(hmacSha256(signingInput.getBytes(StandardCharsets.UTF_8), secretKeyBytes));
            return safeEquals(expectedSig, parts[2]);
        } catch (Exception ex) {
            return false;
        }
    }

    public String getUsername(String token) {
        Map<String, Object> payload = parsePayload(token);
        if (payload == null) return null;
        Object sub = payload.get("sub");
        return sub != null ? String.valueOf(sub) : null;
    }

    public List<String> getRoles(String token) {
        Map<String, Object> payload = parsePayload(token);
        if (payload == null) return new ArrayList<>();
        Object roles = payload.get("roles");
        if (roles instanceof List) {
            List<?> rl = (List<?>) roles;
            List<String> out = new ArrayList<>();
            for (Object o : rl) out.add(String.valueOf(o));
            return out;
        }
        return new ArrayList<>();
    }

    private Map<String, Object> parsePayload(String token) {
        try {
            String[] parts = token.split("\\.");
            if (parts.length != 3) return null;
            byte[] payloadBytes = base64UrlDecode(parts[1]);
            return objectMapper.readValue(payloadBytes, new TypeReference<Map<String, Object>>() {});
        } catch (Exception ex) {
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

    private static long toLong(Object obj) {
        if (obj instanceof Number) return ((Number) obj).longValue();
        try { return Long.parseLong(String.valueOf(obj)); } catch (Exception e) { return 0L; }
    }

    private static boolean safeEquals(String a, String b) {
        if (a == null || b == null) return false;
        if (a.length() != b.length()) return false;
        int result = 0;
        for (int i = 0; i < a.length(); i++) result |= a.charAt(i) ^ b.charAt(i);
        return result == 0;
    }
}
