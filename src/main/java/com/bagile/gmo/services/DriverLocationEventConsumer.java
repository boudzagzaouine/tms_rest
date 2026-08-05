package com.bagile.gmo.services;

import com.bagile.gmo.dto.event.DriverLocationEvent;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

/**
 * Consumes driver GPS pings off the {@code driver-locations} topic and persists them through the
 * existing {@link TransportPlanLocationService#save} path — same DB write the synchronous endpoint
 * did, now moved off the request thread. This is the second half of the strangler migration: the old
 * POST still works, but new traffic can flow through Kafka.
 *
 * <p>Auto-start is gated on {@code tms.location-streaming.enabled} so the API can run without a
 * broker during local development.</p>
 */
@Service
public class DriverLocationEventConsumer {

    private static final Logger log = LoggerFactory.getLogger(DriverLocationEventConsumer.class);

    private final TransportPlanLocationService transportPlanLocationService;

    public DriverLocationEventConsumer(TransportPlanLocationService transportPlanLocationService) {
        this.transportPlanLocationService = transportPlanLocationService;
    }

    @KafkaListener(
            topics = "${tms.location-streaming.topic:driver-locations}",
            groupId = "${spring.kafka.consumer.group-id:tms-location-ingest}",
            autoStartup = "${tms.location-streaming.enabled:true}")
    public void onLocation(DriverLocationEvent event) {
        try {
            transportPlanLocationService.save(event.toDto());
            if (log.isDebugEnabled()) {
                log.debug("Persisted streamed location for transportPlan {}", event.transportPlanId());
            }
        } catch (Exception e) {
            // Swallow-and-log so one bad ping (e.g. an unknown transportPlanId) does not stall the
            // partition. A production build would route these to a dead-letter topic instead.
            log.error("Failed to persist streamed location for transportPlan {}: {}",
                    event.transportPlanId(), e.getMessage());
        }
    }
}
