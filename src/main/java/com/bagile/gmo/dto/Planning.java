package com.bagile.gmo.dto;

import java.io.Serializable;
import java.util.Date;
import java.util.Objects;

public class Planning extends EmsDto implements Serializable {
    /**
     *
     */
    private static final long serialVersionUID = -134482768077497935L;
    private long id;
    private String Day ;
    private String morning;
    private Date morningTimeStart;
    private Date morningTimeEnd;
    private String evering;
    private Date everingTimeStart;
    private Date everingTimeEnd;
    private Owner owner;
 private Boolean closingDay;
    private Account account;
    private Supplier supplier;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getDay() {
        return Day;
    }

    public void setDay(String day) {
        Day = day;
    }

    public String getMorning() {
        return morning;
    }

    public void setMorning(String morning) {
        this.morning = morning;
    }

    public Date getMorningTimeStart() {
        return morningTimeStart;
    }

    public void setMorningTimeStart(Date morningTimeStart) {
        this.morningTimeStart = morningTimeStart;
    }

    public Date getMorningTimeEnd() {
        return morningTimeEnd;
    }

    public void setMorningTimeEnd(Date morningTimeEnd) {
        this.morningTimeEnd = morningTimeEnd;
    }

    public String getEvering() {
        return evering;
    }

    public void setEvering(String evering) {
        this.evering = evering;
    }

    public Date getEveringTimeStart() {
        return everingTimeStart;
    }

    public void setEveringTimeStart(Date everingTimeStart) {
        this.everingTimeStart = everingTimeStart;
    }

    public Date getEveringTimeEnd() {
        return everingTimeEnd;
    }

    public void setEveringTimeEnd(Date everingTimeEnd) {
        this.everingTimeEnd = everingTimeEnd;
    }

    public Owner getOwner() {
        return owner;
    }

    public void setOwner(Owner owner) {
        this.owner = owner;
    }

    public Boolean getClosingDay() {
        return closingDay;
    }

    public void setClosingDay(Boolean closingDay) {
        this.closingDay = closingDay;
    }

    public Account getAccount() {
        return account;
    }

    public void setAccount(Account account) {
        this.account = account;
    }

    public Supplier getSupplier() {
        return supplier;
    }

    public void setSupplier(Supplier supplier) {
        this.supplier = supplier;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Planning badgeType = (Planning) o;
        return getId() == badgeType.getId();
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId());
    }
}
