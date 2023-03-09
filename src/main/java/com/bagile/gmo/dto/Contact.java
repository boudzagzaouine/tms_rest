package com.bagile.gmo.dto;

import java.io.Serializable;
import java.util.Objects;

public class Contact extends EmsDto implements Serializable {

    /**
     *
     */
    private static final long serialVersionUID = 6104428812454596331L;
    private long id;
    private String code;
    private String name;
    private String surname ;
    private String tel1;
    private String tel2;
    private String fax ;
   // private String contactType;
    private  String email;
    private String comment;
    private boolean  active ;
    private Owner owner;

    private Account account;
    private Transport transport ;

    private ContactFunction contactFunction;

    private Address address;
    private Boolean delivery ;
    public Contact() {
    }

    public String getTel1() {
        return tel1;
    }

    public void setTel1(String tel1) {
        this.tel1 = tel1;
    }

    public String getTel2() {
        return tel2;
    }

    public void setTel2(String tel2) {
        this.tel2 = tel2;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Boolean getDelivery() {
        return delivery;
    }

    public void setDelivery(Boolean delivery) {
        this.delivery = delivery;
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

    public ContactFunction getContactFunction() {
        return contactFunction;
    }

    public void setContactFunction(ContactFunction contactFunction) {
        this.contactFunction = contactFunction;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public Transport getTransport() {
        return transport;
    }

    public void setTransport(Transport transport) {
        this.transport = transport;
    }

    public String getFax() {
        return fax;
    }

    public void setFax(String fax) {
        this.fax = fax;
    }

    public Account getAccount() {
        return account;
    }

    public void setAccount(Account account) {
        this.account = account;
    }

    /*  public String getContactType() {
            return contactType;
        }

        public void setContactType(String contactType) {
            this.contactType = contactType;
        }
    */

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
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

    public Owner getOwner() {
        return owner;
    }

    public void setOwner(Owner owner) {
        this.owner = owner;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Contact contact = (Contact) o;
        return getId()==(contact.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId());
    }
}
