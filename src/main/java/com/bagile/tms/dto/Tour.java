package com.bagile.tms.dto;

import java.util.List;


public class Tour {
    private long id;
    private String code;
    private List<TourSaleOrder> saleOrders;
    private String vehicule;
    private List<String> transporters;
    private String status;


    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public List<TourSaleOrder> getSaleOrders() {
        return saleOrders;
    }

    public void setSaleOrders(List<TourSaleOrder> saleOrders) {
        this.saleOrders = saleOrders;
    }

    public String getVehicule() {
        return vehicule;
    }

    public void setVehicule(String vehicule) {
        this.vehicule = vehicule;
    }

    public List<String> getTransporters() {
        return transporters;
    }

    public void setTransporters(List<String> transporters) {
        this.transporters = transporters;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
