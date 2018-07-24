package com.sinno.ems.dto;

import java.io.Serializable;
import java.util.Date;
import java.util.Set;

/**
 * Created by yasser on 22/09/2016.
 */
public class Driver implements Serializable {

    private long id;
    private String code;
    private String passportNumber;

    private Set<Incident> incidents;
    private Set<Road> roads;
    private Set<Badge> badges;
    private Address address;
    private DriverSituation driverSituation;
    private Contact contact;
    private Date dateCreation;
    private Date dateUpDate;
    private User creationUser;
    private User upDateUser;
    private Set<DriverBadge> driverBadges;


    public DriverSituation getDriverSituation() {
        return driverSituation;
    }

    public void setDriverSituation(DriverSituation driverSituation) {
        this.driverSituation = driverSituation;
    }

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

    public String getPassportNumber() {
        return passportNumber;
    }

    public void setPassportNumber(String passportNumber) {
        this.passportNumber = passportNumber;
    }

    public Set<Incident> getIncidents() {
        return incidents;
    }

    public void setIncidents(Set<Incident> incidents) {
        this.incidents = incidents;
    }

    public Set<Road> getRoads() {
        return roads;
    }

    public void setRoads(Set<Road> roads) {
        this.roads = roads;
    }

    public Set<Badge> getBadges() {
        return badges;
    }

    public void setBadges(Set<Badge> badges) {
        this.badges = badges;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public Date getDateCreation() {
        return dateCreation;
    }

    public void setDateCreation(Date dateCreation) {
        this.dateCreation = dateCreation;
    }

    public Date getDateUpDate() {
        return dateUpDate;
    }

    public void setDateUpDate(Date dateUpDate) {
        this.dateUpDate = dateUpDate;
    }

    public User getCreationUser() {
        return creationUser;
    }

    public void setCreationUser(User creationUser) {
        this.creationUser = creationUser;
    }

    public User getUpDateUser() {
        return upDateUser;
    }

    public void setUpDateUser(User upDateUser) {
        this.upDateUser = upDateUser;
    }

    public Set<DriverBadge> getDriverBadges() {
        return driverBadges;
    }

    public void setDriverBadges(Set<DriverBadge> driverBadges) {
        this.driverBadges = driverBadges;
    }

    public Contact getContact() {
        return contact;
    }

    public void setContact(Contact contact) {
        this.contact = contact;
    }

    @Override
    public boolean equals(Object object) {
        boolean result = false;
        if (object == null || object.getClass() != getClass()) {
            result = false;
        } else {
            Driver obj = (Driver) object;
            if (this.id == obj.getId()) {
                result = true;
            }
        }
        return result;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 7 * hash + (int) this.id;
        hash = 7 * hash + (int) this.id;
        return hash;
    }
}
