package com.bagile.gmo.services;

import com.bagile.gmo.dto.event.DriverLocationEvent;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

/**
 * Publishes driver GPS pings to the {@code driver-locations} Kafka topic. Producing is fire-and-log:
 * the REST endpoint returns immediately and the {@link DriverLocationEventConsumer} does the DB work
 * off the stream, so a burst of location updates no longer blocks request threads.
 */
@Service
public class DriverLocationEventProducer {

    private static final Logger log = LoggerFactory.getLogger(DriverLocationEventProducer.class);

    private final KafkaTemplate<String, DriverLocationEvent> kafkaTemplate;

    @Value("${tms.location-streaming.topic:driver-locations}")
    private String topic;

    public DriverLocationEventProducer(KafkaTemplate<String, DriverLocationEvent> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    public void publish(DriverLocationEvent event) {
        kafkaTemplate.send(topic, event.partitionKey(), event)
                .whenComplete((result, ex) -> {
                    if (ex != null) {
                        log.error("Failed to publish driver location for transportPlan {}: {}",
                                event.transportPlanId(), ex.getMessage());
                    } else if (log.isDebugEnabled()) {
                        log.debug("Published driver location for transportPlan {} to partition {}",
                                event.transportPlanId(), result.getRecordMetadata().partition());
                    }
                });
    }
}
