package com.bagile.gmo.dto;

import java.math.BigDecimal;
import java.util.Date;
import java.util.Set;

/**
 * Created by pc on 21/04/2016.
 */
public class Delivery  extends EmsDto {

    private long id;
    private String code;
    private String description;
    private Account Account;
    private Warehouse warehouse;
    private Transport transport;
    private Owner owner;
    private OrderStatus orderStatus;
    private SaleOrder saleOrder;
    private OrderType orderType;
    private Date expectedDate;
    private Date loadDate;
    private Date creationDate;
    private Date updateDate;
    private String comment;
    private Long containerCount;
    private AddressInfo deliveryAddress;
    private AddressInfo invoiceAddress;
    private String transportTel;
    private String remarks;
    private String transportContact;
    private String immatriculation;
    private Set<DeliveryLine> lines;
    private String transfertCode;
    private Boolean sendedToWms;
    private BigDecimal discount;
    private BigDecimal totalPriceHT;
    private BigDecimal totalPriceTTC;
    private BigDecimal vat;
    private Boolean active;
    private Boolean accounted;
    private BigDecimal exchangeRate;
    private BigDecimal totalPriceHTDefaultCurrency;
    private BigDecimal totalPriceTTCDefaultCurrency;
    private BigDecimal vatDefaultCurrency;
    public Delivery() {
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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Account getAccount() {
        return Account;
    }

    public void setAccount(Account account) {
        Account = account;
    }

    public Warehouse getWarehouse() {
        return warehouse;
    }

    public void setWarehouse(Warehouse warehouse) {
        this.warehouse = warehouse;
    }

    public Transport getTransport() {
        return transport;
    }

    public void setTransport(Transport transport) {
        this.transport = transport;
    }

    public Owner getOwner() {
        return owner;
    }

    public void setOwner(Owner owner) {
        this.owner = owner;
    }

    public OrderStatus getOrderStatus() {
        return orderStatus;
    }

    public void setOrderStatus(OrderStatus orderStatus) {
        this.orderStatus = orderStatus;
    }

    public SaleOrder getSaleOrder() {
        return saleOrder;
    }

    public void setSaleOrder(SaleOrder saleOrder) {
        this.saleOrder = saleOrder;
    }

    public OrderType getOrderType() {
        return orderType;
    }

    public void setOrderType(OrderType orderType) {
        this.orderType = orderType;
    }

    public Date getExpectedDate() {
        return expectedDate;
    }

    public void setExpectedDate(Date expectedDate) {
        this.expectedDate = expectedDate;
    }

    public Date getLoadDate() {
        return loadDate;
    }

    public void setLoadDate(Date loadDate) {
        this.loadDate = loadDate;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public Long getContainerCount() {
        return containerCount;
    }

    public void setContainerCount(Long containerCount) {
        this.containerCount = containerCount;
    }

    public AddressInfo getDeliveryAddress() {
        return deliveryAddress;
    }

    public void setDeliveryAddress(AddressInfo deliveryAddress) {
        this.deliveryAddress = deliveryAddress;
    }

    public AddressInfo getInvoiceAddress() {
        return invoiceAddress;
    }

    public void setInvoiceAddress(AddressInfo invoiceAddress) {
        this.invoiceAddress = invoiceAddress;
    }



    public Set<DeliveryLine> getLines() {
        return lines;
    }

    public void setLines(Set<DeliveryLine> lines) {
        this.lines = lines;
    }


    public String getTransportTel() {
        return transportTel;
    }

    public void setTransportTel(String transportTel) {
        this.transportTel = transportTel;
    }

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }

    public String getTransportContact() {
        return transportContact;
    }

    public void setTransportContact(String transportContact) {
        this.transportContact = transportContact;
    }

    public Date getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(Date creationDate) {
        this.creationDate = creationDate;
    }

    public Date getUpdateDate() {
        return updateDate;
    }

    public void setUpdateDate(Date updateDate) {
        this.updateDate = updateDate;
    }


    public String getImmatriculation() {
        return immatriculation;
    }

    public void setImmatriculation(String immatriculation) {
        this.immatriculation = immatriculation;
    }

    public String getTransfertCode() {
        return transfertCode;
    }

    public void setTransfertCode(String transfertCode) {
        this.transfertCode = transfertCode;
    }

    public void setSendedToWms(Boolean sendedToWms) {
        this.sendedToWms = sendedToWms;
    }

    public Boolean getSendedToWms() {
        return sendedToWms;
    }



    public BigDecimal getDiscount() {
        return discount;
    }

    public void setDiscount(BigDecimal discount) {
        this.discount = discount;
    }

    public BigDecimal getTotalPriceHT() {
        return totalPriceHT;
    }

    public void setTotalPriceHT(BigDecimal totalPriceHT) {
        this.totalPriceHT = totalPriceHT;
    }

    public BigDecimal getTotalPriceTTC() {
        return totalPriceTTC;
    }

    public void setTotalPriceTTC(BigDecimal totalPriceTTC) {
        this.totalPriceTTC = totalPriceTTC;
    }


    public BigDecimal getVat() {
        return vat;
    }

    public void setVat(BigDecimal vat) {
        this.vat = vat;
    }

    public Boolean getActive() {
        return active;
    }

    public void setActive(Boolean active) {
        this.active = active;
    }

    public Boolean getAccounted() {
        return accounted;
    }

    public void setAccounted(Boolean accounted) {
        this.accounted = accounted;
    }

    public BigDecimal getTotalPriceHTDefaultCurrency() {
        return totalPriceHTDefaultCurrency;
    }

    public void setTotalPriceHTDefaultCurrency(BigDecimal totalPriceHTDefaultCurrency) {
        this.totalPriceHTDefaultCurrency = totalPriceHTDefaultCurrency;
    }

    public BigDecimal getTotalPriceTTCDefaultCurrency() {
        return totalPriceTTCDefaultCurrency;
    }

    public void setTotalPriceTTCDefaultCurrency(BigDecimal totalPriceTTCDefaultCurrency) {
        this.totalPriceTTCDefaultCurrency = totalPriceTTCDefaultCurrency;
    }

    public BigDecimal getVatDefaultCurrency() {
        return vatDefaultCurrency;
    }

    public void setVatDefaultCurrency(BigDecimal vatDefaultCurrency) {
        this.vatDefaultCurrency = vatDefaultCurrency;
    }

    public BigDecimal getExchangeRate() {
        return exchangeRate;
    }

    public void setExchangeRate(BigDecimal exchangeRate) {
        this.exchangeRate = exchangeRate;
    }

    @Override
    public boolean equals(Object object) {
        boolean result = false;
        if (object == null || object.getClass() != getClass()) {
            result = false;
        } else {
            Delivery obj = (Delivery) object;
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
