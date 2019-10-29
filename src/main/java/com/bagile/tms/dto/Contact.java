package com.bagile.tms.dto;

import java.io.Serializable;
import java.util.Objects;

public class Contact extends EmsDto implements Serializable {

    /**
     *
     */
    private static final long serialVersionUID = 6104428812454596331L;
    private Long id;
    private String name;
    private String surname ;
    private String tele1;
    private String fax ;
    private String contactType;
    private  String email;
    private String comment;
    private boolean  active ;

    public Contact() {
    }

    public String getTele1() {
        return tele1;
    }

    public void setTele1(String tele1) {
        this.tele1 = tele1;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public String getFax() {
        return fax;
    }

    public void setFax(String fax) {
        this.fax = fax;
    }

    public String getContactType() {
        return contactType;
    }

    public void setContactType(String contactType) {
        this.contactType = contactType;
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

    public Boolean getActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Contact contact = (Contact) o;
        return getId().equals(contact.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId());
    }
}
