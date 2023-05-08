package com.bagile.gmo.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Set;

public class Account extends EmsDto implements Serializable, Comparable<Account> {

    /**
     *
     */
    private static final long serialVersionUID = 7224899519213320749L;

    private long id;

    private String code;

    private String name;

//    private String codeName;

    private String telephone ;

    private String email;

    private Owner owner;

    private Address deliveryAddress;

    private String comment;

    private Transport transport;

    private String terms;

    private Company company;

    private Date creationDate;

    private Date updateDate;

    private Boolean active;

    private String variable1;

    private String variable2;

    private String variable3;

    private String variable4;

    private String variable5;

    private String variable6;

    private String variable7;

    private String variable8;

    private String variable9;

    private String variable10;
    private Set<SaleOrder> saleOrders;
    private Contact contact;
    private String description;
    private String password;
    private BigDecimal billedAmount;
    private BigDecimal credit;
    private BigDecimal payedAmount;
    private BigDecimal turnOverLastYear;
    private BigDecimal turnover;
    private BigDecimal maxCredit;
    private Boolean wholesale;


    private List<Planning> plannings= new ArrayList<>();
  //  private List<Address> addresses= new ArrayList<>();
    private List<Contact> contacts= new ArrayList<>();

  private Date deliveryDate ;

    private BigDecimal latitude;
    private BigDecimal longitude;

    public List<Planning> getPlannings() {
        return plannings;
    }

    public void setPlannings(List<Planning> plannings) {
        this.plannings = plannings;
    }

//    public List<Address> getAddresses() {
//        return addresses;
//    }
//
//    public void setAddresses(List<Address> addresses) {
//        this.addresses = addresses;
//    }

    public List<Contact> getContacts() {
        return contacts;
    }

    public void setContacts(List<Contact> contacts) {
        this.contacts = contacts;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public long getId() {
        return this.id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Owner getOwner() {
        return this.owner;
    }

    public void setOwner(Owner owner) {
        this.owner = owner;
    }

    public String getComment() {
        return this.comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public Company getCompany() {
        return this.company;
    }

    public void setCompany(Company company) {
        this.company = company;
    }

    public Transport getTransport() {
        return this.transport;
    }

    public void setTransport(Transport transport) {
        this.transport = transport;
    }

    public String getCode() {
        return this.code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getTerms() {
        return this.terms;
    }

    public void setTerms(String terms) {
        this.terms = terms;
    }

    public Boolean getActive() {
        return this.active;
    }

    public void setActive(Boolean active) {
        this.active = active;
    }

    public String getCodeName() {
        return this.code +" - "+this.name;
    }

    public Address getDeliveryAddress() {
        return deliveryAddress;
    }

    public void setDeliveryAddress(Address deliveryAddress) {
        this.deliveryAddress = deliveryAddress;
    }

    public Date getUpdateDate() {
        return this.updateDate;
    }

    public void setUpdateDate(Date updateDate) {
        this.updateDate = updateDate;
    }

    public String getVariable1() {
        return this.variable1;
    }

    public void setVariable1(String variable1) {
        this.variable1 = variable1;
    }

    public String getVariable2() {
        return this.variable2;
    }

    public void setVariable2(String variable2) {
        this.variable2 = variable2;
    }

    public String getVariable3() {
        return this.variable3;
    }

    public void setVariable3(String variable3) {
        this.variable3 = variable3;
    }

    public String getVariable4() {
        return this.variable4;
    }

    public void setVariable4(String variable4) {
        this.variable4 = variable4;
    }

    public String getVariable5() {
        return this.variable5;
    }

    public void setVariable5(String variable5) {
        this.variable5 = variable5;
    }

    public String getVariable6() {
        return this.variable6;
    }

    public void setVariable6(String variable6) {
        this.variable6 = variable6;
    }

    public String getVariable7() {
        return this.variable7;
    }

    public void setVariable7(String variable7) {
        this.variable7 = variable7;
    }

    public String getVariable8() {
        return this.variable8;
    }

    public void setVariable8(String variable8) {
        this.variable8 = variable8;
    }

    public String getVariable9() {
        return this.variable9;
    }

    public void setVariable9(String variable9) {
        this.variable9 = variable9;
    }

    public String getVariable10() {
        return this.variable10;
    }

    public void setVariable10(String variable10) {
        this.variable10 = variable10;
    }

    public Date getCreationDate() {
        return this.creationDate;
    }

    public void setCreationDate(Date creationDate) {
        this.creationDate = creationDate;
    }

    public Set<SaleOrder> getSaleOrders() {
        return saleOrders;
    }


    public Contact getContact() {
        return contact;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setContact(Contact contact) {
        this.contact = contact;
    }



    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Date getDeliveryDate() {
        return deliveryDate;
    }

    public void setDeliveryDate(Date deliveryDate) {
        this.deliveryDate = deliveryDate;
    }

    public BigDecimal getBilledAmount() {
        return billedAmount;
    }

    public void setBilledAmount(BigDecimal billedAmount) {
        this.billedAmount = billedAmount;
    }

    public BigDecimal getCredit() {
        return credit;
    }

    public void setCredit(BigDecimal credit) {
        this.credit = credit;
    }

    public BigDecimal getPayedAmount() {
        return payedAmount;
    }

    public void setPayedAmount(BigDecimal payedAmount) {
        this.payedAmount = payedAmount;
    }

    public BigDecimal getTurnover() {
        return turnover;
    }

    public void setTurnover(BigDecimal turnover) {
        this.turnover = turnover;
    }



    public BigDecimal getMaxCredit() {
        return maxCredit;
    }

    public void setMaxCredit(BigDecimal maxCredit) {
        this.maxCredit = maxCredit;
    }

    public Boolean getWholesale() {
        return wholesale;
    }

    public void setWholesale(Boolean wholesale) {
        this.wholesale = wholesale;
    }

    public BigDecimal getLatitude() {
        return latitude;
    }

    public void setLatitude(BigDecimal latitude) {
        this.latitude = latitude;
    }

    public BigDecimal getLongitude() {
        return longitude;
    }

    public void setLongitude(BigDecimal longitude) {
        this.longitude = longitude;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public boolean equals(Object object) {
        boolean result = false;
        if (object == null || object.getClass() != getClass()) {
            result = false;
        } else {
            Account obj = (Account) object;
            if (this.id == obj.getId()) {
                result = true;
            }
        }
        return result;
    }

    public BigDecimal getTurnOverLastYear() {
        return turnOverLastYear;
    }

    public void setTurnOverLastYear(BigDecimal turnOverLastYear) {
        this.turnOverLastYear = turnOverLastYear;
    }
    @JsonIgnore


    @Override
    public int hashCode() {
        int hash = 3;
        hash = 7 * hash + (int) this.id;
        hash = 7 * hash + (int) this.id;
        return hash;
    }

    @Override
    public int compareTo(Account o) {
        return o.updateDate.compareTo(this.updateDate);
    }
}