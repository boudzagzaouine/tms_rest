package com.bagile.gmo.config;

import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.config.TopicBuilder;

/**
 * Kafka wiring for driver-location streaming. Declares the {@code driver-locations} topic so it is
 * auto-created on startup (via the broker's admin client) with several partitions — one trip maps to
 * one partition key, so multiple partitions let many trips stream in parallel while staying ordered
 * per trip. See {@code docker-compose.yml} for the local broker.
 */
@Configuration
public class KafkaConfig {

    @Value("${tms.location-streaming.topic:driver-locations}")
    private String locationTopic;

    @Bean
    public NewTopic driverLocationsTopic() {
        return TopicBuilder.name(locationTopic)
                .partitions(3)
                .replicas(1)
                .build();
    }
}
