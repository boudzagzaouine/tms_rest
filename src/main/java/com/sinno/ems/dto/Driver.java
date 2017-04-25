package com.sinno.ems.dto;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import java.util.Set;

/**
 * Created by yasser on 22/09/2016.
 */
public class Driver implements Serializable {

    private long id;
    private String code;
    private String passportNumber;
    private String passportLink;
    private String lastName;
    private String firstName;
    private Date birthDay;
    private String cellPhone;
    private Set<Incident> incidents;
    private Set<Road> roads;
    private Set<Badge> badges;
    private Adresse adresse;
    private DriverSituation driverSituation;

    private Date dateCreation;
    private Date dateUpDate;
    private User creationUser;
    private User upDateUser;
    private List<DriverBadge>idBadge;
    private List<DriverBadge>idDriver;


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

    public String getPassportLink() {
        return passportLink;
    }

    public void setPassportLink(String passportLink) {
        this.passportLink = passportLink;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public Date getBirthDay() {
        return birthDay;
    }

    public void setBirthDay(Date birthDay) {
        this.birthDay = birthDay;
    }

    public String getCellPhone() {
        return cellPhone;
    }

    public void setCellPhone(String cellPhone) {
        this.cellPhone = cellPhone;
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

    public Adresse getAdresse() {
        return adresse;
    }

    public void setAdresse(Adresse adresse) {
        this.adresse = adresse;
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

    public List<DriverBadge> getIdBadge() {
        return idBadge;
    }

    public void setIdBadge(List<DriverBadge> idBadge) {
        this.idBadge = idBadge;
    }

    public List<DriverBadge> getIdDriver() {
        return idDriver;
    }

    public void setIdDriver(List<DriverBadge> idDriver) {
        this.idDriver = idDriver;
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
