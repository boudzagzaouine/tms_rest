package com.bagile.tms.dto;

import java.io.Serializable;
import java.util.Date;

public class Owner extends EmsDto implements Serializable {

    private static final long serialVersionUID = -7523102087085976433L;

    private long id;
    private String comment;
    private String code;
    private String siret;
    private Boolean active;
    private String description;
   // private Address address;
    private String name;
    private String surname;
    private String email;
    private String primaryTel;
    private String secondaryTel;
 //   private Organisation organisation;
    private Date firstInvoiceDate;
    private byte[] image;


    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getSiret() {
        return siret;
    }

    public void setSiret(String siret) {
        this.siret = siret;
    }

    public Boolean getActive() {
        return active;
    }

    public void setActive(Boolean active) {
        this.active = active;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    /*public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public Organisation getOrganisation() {
        return organisation;
    }

    public void setOrganisation(Organisation organisation) {
        this.organisation = organisation;
    }*/

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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPrimaryTel() {
        return primaryTel;
    }

    public void setPrimaryTel(String primaryTel) {
        this.primaryTel = primaryTel;
    }

    public String getSecondaryTel() {
        return secondaryTel;
    }

    public void setSecondaryTel(String secondaryTel) {
        this.secondaryTel = secondaryTel;
    }

    public Date getFirstInvoiceDate() {
        return firstInvoiceDate;
    }

    public void setFirstInvoiceDate(Date firstInvoiceDate) {
        this.firstInvoiceDate = firstInvoiceDate;
    }

    public byte[] getImage() {
        return image;
    }

    public void setImage(byte[] image) {
        this.image = image;
    }


    @Override
    public boolean equals(Object object) {
        boolean result = false;
        if (object == null || object.getClass() != getClass()) {
            result = false;
        } else {
            Owner obj = (Owner) object;
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