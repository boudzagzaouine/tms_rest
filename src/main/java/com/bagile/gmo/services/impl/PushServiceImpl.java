package com.bagile.gmo.services.impl;

import com.bagile.gmo.entities.GmoDriverPushToken;
import com.bagile.gmo.repositories.DriverPushTokenRepository;
import com.bagile.gmo.services.PushService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@Service
public class PushServiceImpl implements PushService {

    private static final Logger log = LoggerFactory.getLogger(PushServiceImpl.class);
    private static final String EXPO_PUSH_URL = "https://exp.host/--/api/v2/push/send";

    private final DriverPushTokenRepository repository;
    private final ObjectMapper objectMapper = new ObjectMapper();
    // Push is best-effort and off the request thread.
    private final ExecutorService executor = Executors.newFixedThreadPool(2);

    public PushServiceImpl(DriverPushTokenRepository repository) {
        this.repository = repository;
    }

    @Override
    @Transactional
    public void saveToken(Long driverId, String token, String platform) {
        if (token == null || token.trim().isEmpty()) return;
        // One row per device token: update its owner/timestamp, or create it.
        Optional<GmoDriverPushToken> existing = repository.findFirstByToken(token);
        GmoDriverPushToken row = existing.orElseGet(GmoDriverPushToken::new);
        row.setDriverId(driverId);
        row.setToken(token);
        row.setPlatform(platform);
        row.setUpdatedAt(new Date());
        repository.save(row);
    }

    @Override
    public void notifyDriver(Long driverId, String title, String body, Map<String, Object> data) {
        if (driverId == null) return;
        List<GmoDriverPushToken> tokens;
        try {
            tokens = repository.findByDriverId(driverId);
        } catch (Exception e) {
            log.warn("push: could not load tokens for driver {}", driverId, e);
            return;
        }
        for (GmoDriverPushToken t : tokens) {
            final String token = t.getToken();
            executor.submit(() -> sendOne(token, title, body, data));
        }
    }

    private void sendOne(String token, String title, String body, Map<String, Object> data) {
        HttpURLConnection conn = null;
        try {
            Map<String, Object> payload = new LinkedHashMap<>();
            payload.put("to", token);
            payload.put("title", title);
            payload.put("body", body);
            payload.put("sound", "default");
            payload.put("channelId", "orders");
            if (data != null) payload.put("data", data);
            byte[] json = objectMapper.writeValueAsString(payload).getBytes(StandardCharsets.UTF_8);

            conn = (HttpURLConnection) new URL(EXPO_PUSH_URL).openConnection();
            conn.setRequestMethod("POST");
            conn.setConnectTimeout(10000);
            conn.setReadTimeout(10000);
            conn.setDoOutput(true);
            conn.setRequestProperty("Content-Type", "application/json");
            conn.setRequestProperty("Accept", "application/json");
            try (OutputStream os = conn.getOutputStream()) {
                os.write(json);
            }
            int code = conn.getResponseCode();
            if (code >= 300) log.warn("push send status {} for token {}", code, token);
        } catch (Exception e) {
            log.warn("push send failed", e);
        } finally {
            if (conn != null) conn.disconnect();
        }
    }
}
