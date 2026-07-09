package com.bagile.gmo.controllers;

import com.bagile.gmo.services.PushService;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

/**
 * Lets the driver app register its Expo push token so the backend can send
 * delivery notifications even when the app is closed. Authenticated (any valid
 * JWT); the app supplies its own driverId.
 */
@RestController
@RequestMapping("/api/driver")
public class DriverPushController {

    private final PushService pushService;

    public DriverPushController(PushService pushService) {
        this.pushService = pushService;
    }

    @PostMapping(value = "/push-token", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> registerToken(@RequestBody Map<String, Object> body) {
        Object token = body.get("token");
        if (token == null || token.toString().isEmpty()) {
            return ResponseEntity.badRequest().body(result("error", "token required"));
        }
        Long driverId = body.get("driverId") == null
                ? null
                : Long.valueOf(body.get("driverId").toString());
        String platform = body.get("platform") == null ? null : body.get("platform").toString();

        pushService.saveToken(driverId, token.toString(), platform);
        return ResponseEntity.ok(result("saved", true));
    }

    private static Map<String, Object> result(String key, Object value) {
        Map<String, Object> m = new HashMap<>();
        m.put(key, value);
        return m;
    }
}
