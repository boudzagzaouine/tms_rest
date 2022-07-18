package com.bagile.gmo.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Set;

public class ContractAccount extends EmsDto implements Serializable, Comparable<ContractAccount> {

    /**
     *
     */
    private static final long serialVersionUID = 7224899519213320749L;

    private long id;
   private String  code ;
   private Date  date;

   private Account account;
   private String contractType  ;
   private VehicleCategory vehicleCategory  ;
   private long quantity  ;

    private Address senderAddress  ;
    private Address receiverAdresse ;

   private Date  startDate ;
  private Date  endDate;
  private BigDecimal   price ;
  private String  packageType ;

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

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getContractType() {
        return contractType;
    }

    public void setContractType(String contractType) {
        this.contractType = contractType;
    }

    public VehicleCategory getVehicleCategory() {
        return vehicleCategory;
    }

    public void setVehicleCategory(VehicleCategory vehicleCategory) {
        this.vehicleCategory = vehicleCategory;
    }

    public long getQuantity() {
        return quantity;
    }

    public void setQuantity(long quantity) {
        this.quantity = quantity;
    }

    public Address getSenderAddress() {
        return senderAddress;
    }

    public void setSenderAddress(Address senderAddress) {
        this.senderAddress = senderAddress;
    }

    public Address getReceiverAdresse() {
        return receiverAdresse;
    }

    public void setReceiverAdresse(Address receiverAdresse) {
        this.receiverAdresse = receiverAdresse;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public String getPackageType() {
        return packageType;
    }

    public void setPackageType(String packageType) {
        this.packageType = packageType;
    }

    public Account getAccount() {
        return account;
    }

    public void setAccount(Account account) {
        this.account = account;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 7 * hash + (int) this.id;
        hash = 7 * hash + (int) this.id;
        return hash;
    }

    @Override
    public int compareTo(ContractAccount o) {
        return o.updateDate.compareTo(this.updateDate);
    }
}