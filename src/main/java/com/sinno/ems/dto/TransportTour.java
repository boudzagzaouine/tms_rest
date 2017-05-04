package com.sinno.ems.dto;

/**
 * Created by Enissay on 18/04/2017.
 */
public class TransportTour {
    private long id;
    private Transport transport;
    private Tour tour;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Transport getTransport() {
        return transport;
    }

    public void setTransport(Transport transport) {
        this.transport = transport;
    }

    public Tour getTour() {
        return tour;
    }

    public void setTour(Tour tour) {
        this.tour = tour;
    }
}
