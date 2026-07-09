package com.bagile.gmo.services;

import java.util.Map;

/** Stores driver push tokens and sends delivery notifications via Expo push. */
public interface PushService {

    void saveToken(Long driverId, String token, String platform);

    /** Fire-and-forget push to every registered device of a driver. */
    void notifyDriver(Long driverId, String title, String body, Map<String, Object> data);
}
