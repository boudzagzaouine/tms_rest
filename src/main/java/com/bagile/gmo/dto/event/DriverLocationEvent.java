package com.bagile.gmo.dto.event;

import com.bagile.gmo.dto.TransportPlanLocation;

import java.util.Date;

/**
 * Lightweight, self-contained payload published to the {@code driver-locations} Kafka topic each
 * time a driver's device reports a GPS position. It intentionally carries only the flat identifiers
 * the mobile app sends (no nested JPA entities), so it serialises cleanly to JSON and the consumer
 * can rebuild a {@link TransportPlanLocation} to persist via the existing service.
 *
 * <p>The event is keyed by {@code transportPlanId} on the topic so all pings for one trip land on
 * the same partition and stay ordered.</p>
 */
public record DriverLocationEvent(
        double latitude,
        double longitude,
        Long transportPlanId,
        Long orderTransportId,
        Long orderTransportInfoId,
        Long orderTransportInfoLineId,
        Long vehicleId,
        Long driverId,
        Date date,
        String type,
        Long accountId,
        String accountName) {

    /** Build an event from the DTO the REST/mobile client submits. */
    public static DriverLocationEvent from(TransportPlanLocation l) {
        return new DriverLocationEvent(
                l.getLatitude(),
                l.getLongitude(),
                l.getTransportPlanId(),
                l.getOrderTransportId(),
                l.getOrderTransportInfoId(),
                l.getOrderTransportInfoLineId(),
                l.getVehicleId(),
                l.getDriverId(),
                l.getDate(),
                l.getType(),
                l.getAccountId(),
                l.getAccountName());
    }

    /** Rebuild the persistence DTO the location service expects from this event. */
    public TransportPlanLocation toDto() {
        TransportPlanLocation l = new TransportPlanLocation();
        l.setLatitude(latitude);
        l.setLongitude(longitude);
        l.setTransportPlanId(transportPlanId);
        l.setOrderTransportId(orderTransportId);
        l.setOrderTransportInfoId(orderTransportInfoId);
        l.setOrderTransportInfoLineId(orderTransportInfoLineId);
        l.setVehicleId(vehicleId);
        l.setDriverId(driverId);
        l.setDate(date);
        l.setType(type);
        l.setAccountId(accountId);
        l.setAccountName(accountName);
        return l;
    }

    /** Kafka partition key: keep all pings for one trip ordered on the same partition. */
    public String partitionKey() {
        return transportPlanId != null ? String.valueOf(transportPlanId)
                : (vehicleId != null ? "v" + vehicleId : "unassigned");
    }
}
