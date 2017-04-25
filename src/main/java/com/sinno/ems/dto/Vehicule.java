package com.sinno.ems.dto;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import java.util.Set;

/**
 * Created by yasser on 22/09/2016.
 */
public class Vehicule implements Serializable {
    private long id;
    private String code;
    private Long nbreEssieux;
    private BigDecimal emptyWeight;
    private Date dateOfRegistration;
    private String brand;
    private String model;
    private VehiculeStatus status;
    private VehiculeType type;
    private Set<Badge> badges;
    private PoliceAssurance policeAssurance;
    private MaintenancePlan maintenancePlan;
    private String matricule;
    private Date dateCreation;
    private Date dateUpDate;
    private User creationUser;
    private User upDateUser;

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

    public Long getNbreEssieux() {
        return nbreEssieux;
    }

    public void setNbreEssieux(Long nbreEssieux) {
        this.nbreEssieux = nbreEssieux;
    }

    public BigDecimal getEmptyWeight() {
        return emptyWeight;
    }

    public void setEmptyWeight(BigDecimal emptyWeight) {
        this.emptyWeight = emptyWeight;
    }

    public Date getDateOfRegistration() {
        return dateOfRegistration;
    }

    public void setDateOfRegistration(Date dateOfRegistration) {
        this.dateOfRegistration = dateOfRegistration;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public VehiculeStatus getStatus() {
        return status;
    }

    public void setStatus(VehiculeStatus status) {
        this.status = status;
    }

    public VehiculeType getType() {
        return type;
    }

    public void setType(VehiculeType type) {
        this.type = type;
    }

    public Set<Badge> getBadges() {
        return badges;
    }

    public void setBadges(Set<Badge> badges) {
        this.badges = badges;
    }

    public PoliceAssurance getPoliceAssurance() {
        return policeAssurance;
    }

    public void setPoliceAssurance(PoliceAssurance policeAssurance) {
        this.policeAssurance = policeAssurance;
    }

    public MaintenancePlan getMaintenancePlan() {
        return maintenancePlan;
    }

    public void setMaintenancePlan(MaintenancePlan maintenancePlan) {
        this.maintenancePlan = maintenancePlan;
    }

    public String getMatricule() {
        return matricule;
    }

    public void setMatricule(String matricule) {
        this.matricule = matricule;
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

    @Override
    public boolean equals(Object object) {
        boolean result = false;
        if (object == null || object.getClass() != getClass()) {
            result = false;
        } else {
            Vehicule obj = (Vehicule) object;
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
