package com.bagile.tms.dto;

import java.util.Date;
import java.util.Set;

/**
 * Created by Enissay on 19/04/2017.
 */
public class TourSaleOrder {
    private String code;
    private String status;
    private String warehouse;
    private String owner;
    private String account;
    private String location;
    private Date loadDate;
    private Address address;
    private Set<TourSaleOrderLine> tourSaleOrderLines;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getWarehouse() {
        return warehouse;
    }

    public void setWarehouse(String warehouse) {
        this.warehouse = warehouse;
    }

    public String getOwner() {
        return owner;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public Date getLoadDate() {
        return loadDate;
    }

    public void setLoadDate(Date loadDate) {
        this.loadDate = loadDate;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public Set<TourSaleOrderLine> getTourSaleOrderLines() {
        return tourSaleOrderLines;
    }

    public void setTourSaleOrderLines(Set<TourSaleOrderLine> tourSaleOrderLines) {
        this.tourSaleOrderLines = tourSaleOrderLines;
    }
}
