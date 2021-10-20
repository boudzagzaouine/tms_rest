package com.bagile.gmo.dto;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Objects;

public class Driver extends EmsDto implements Serializable {


    private static final long serialVersionUID = 9165430360445575972L;
    private long id;
    private String code;
    private String cin;
    private Date birthDate;
    private Date lastMedicalVisit;
   // private BigDecimal commission;
    //private Contact contact;
    private Boolean working=false;
   // private Badge badge;
private String carte;
    private String name;
    private String surname ;
    private String tele1;
    private String fax ;
    private String type;
    private  String email;
    private String comment;
    //private List<CommissionDriver> commissions=new ArrayList<>();
    private List<BadgeTypeDriver> badgeTypeDrivers = new ArrayList<>();
    private SubscriptionCard subscriptionCard;

    private List<Turn> turns = new ArrayList<>();

    private Owner owner;

    private BigDecimal charged ;

    private BigDecimal salary ;
    private Date dateOfAssignment ;

    public Driver() {
    }

    public boolean isWorking() {
        return working;
    }

    public void setWorking(boolean working) {
        this.working = working;
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

    public String getCin() {
        return cin;
    }

    public void setCin(String cin) {
        this.cin = cin;
    }

    public Date getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }

    public Date getLastMedicalVisit() {
        return lastMedicalVisit;
    }

    public void setLastMedicalVisit(Date lastMedicalVisit) {
        this.lastMedicalVisit = lastMedicalVisit;
    }

    public Owner getOwner() {
        return owner;
    }

    public void setOwner(Owner owner) {
        this.owner = owner;
    }

    /*   public Badge getBadge() {
        return badge;
    }

    public void setBadge(Badge badge) {
        this.badge = badge;
    }*/

    public SubscriptionCard getSubscriptionCard() {
        return subscriptionCard;
    }

    public void setSubscriptionCard(SubscriptionCard subscriptionCard) {
        this.subscriptionCard = subscriptionCard;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getTele1() {
        return tele1;
    }

    public void setTele1(String tele1) {
        this.tele1 = tele1;
    }

    public String getFax() {
        return fax;
    }

    public void setFax(String fax) {
        this.fax = fax;
    }

    public String getType() {
        return type;
    }

    public void setType(String Type) {
        this.type = Type;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    /*public List<CommissionDriver> getCommissions() {
        return commissions;
    }

    public void setCommissions(List<CommissionDriver> commissions) {
        this.commissions = commissions;
    }*/

    public List<BadgeTypeDriver> getBadgeTypeDrivers() {
        return badgeTypeDrivers;
    }

    public void setBadgeTypeDrivers(List<BadgeTypeDriver> badgeTypeDrivers) {
        this.badgeTypeDrivers = badgeTypeDrivers;
    }

    public List<Turn> getTurns() {
        return turns;
    }

    public void setTurns(List<Turn> turns) {
        this.turns = turns;
    }


    public BigDecimal getCharged() {
        return charged;
    }

    public void setCharged(BigDecimal charged) {
        this.charged = charged;
    }

    public BigDecimal getSalary() {
        return salary;
    }

    public void setSalary(BigDecimal salary) {
        this.salary = salary;
    }


    public Date getDateOfAssignment() {
        return dateOfAssignment;
    }

    public void setDateOfAssignment(Date dateOfAssignment) {
        this.dateOfAssignment = dateOfAssignment;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Driver driver = (Driver) o;
        return getId() == driver.getId();
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId());
    }

    public String getCarte() {
        return carte;
    }

    public void setCarte(String carte) {
        this.carte = carte;
    }
}
