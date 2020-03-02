package com.bagile.tms.dto;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

public class SaleOrder  extends EmsDto implements Serializable {


    private static final long serialVersionUID = 6988216201358611010L;

    private long id;
    private Owner owner;
    private Transport transport;
    private String code;
    private Date updateDate;
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
    private Short containers;
    private Date creationDate;
    private String description;
    private Warehouse warehouse;
    private Warehouse warehouseDestination;
    private Supplier supplier;
   private Account account;
    private Date loadDate;
    private String customerCode;
    private OrderStatus orderStatus;
    private String transportContact;
    private String immatriculation;
    private Date expectedDate;
    private OrderType orderType;
    private String remarks;
    private Set<SaleOrderLine> lines;
    private AddressInfo deliveryAddress;
    private AddressInfo invoiceAddress;
    private String transportTel;
    private String transfertCode;
    private Boolean sendedToWms;
    private BigDecimal discount;
    private BigDecimal totalPriceHT;
    private BigDecimal totalPriceTTC;
    private BigDecimal payedAmount=BigDecimal.ZERO;
    private BigDecimal vat;
    private Boolean active;
    private Boolean accounted = true;
    private BigDecimal totalPriceHTDefaultCurrency;
    private BigDecimal totalPriceTTCDefaultCurrency;
    private BigDecimal vatDefaultCurrency;
    private BigDecimal exchangeRate;



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

    public Short getContainers() {
        return this.containers;
    }

    public void setContainers(Short containers) {
        this.containers = containers;
    }

    public Date getCreationDate() {
        return this.creationDate;
    }

    public void setCreationDate(Date creationDate) {
        this.creationDate = creationDate;
    }

    public String getDescription() {
        return this.description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Warehouse getWarehouse() {
        return warehouse;
    }

    public void setWarehouse(Warehouse warehouse) {
        this.warehouse = warehouse;
    }

    public Warehouse getWarehouseDestination() {
        return warehouseDestination;
    }

    public void setWarehouseDestination(Warehouse warehouseDestination) {
        this.warehouseDestination = warehouseDestination;
    }

    public Supplier getSupplier() {
        return this.supplier;
    }

    public void setSupplier(Supplier supplier) {
        this.supplier = supplier;
    }

    public Account getAccount() {
        return this.account;
    }

    public void setAccount(Account account) {
        this.account = account;
    }

    public Date getLoadDate() {
        return this.loadDate;
    }

    public void setLoadDate(Date loadDate) {
        this.loadDate = loadDate;
    }

    public String getCustomerCode() {
        return this.customerCode;
    }

    public void setCustomerCode(String customerCode) {
        this.customerCode = customerCode;
    }

    public OrderStatus getOrderStatus() {
        return this.orderStatus;
    }

    public void setOrderStatus(OrderStatus orderStatus) {
        this.orderStatus = orderStatus;
    }

    public String getTransportContact() {
        return this.transportContact;
    }

    public void setTransportContact(String transportContact) {
        this.transportContact = transportContact;
    }

    public String getImmatriculation() {
        return this.immatriculation;
    }

    public void setImmatriculation(String immatriculation) {
        this.immatriculation = immatriculation;
    }

    public Date getExpectedDate() {
        return this.expectedDate;
    }

    public void setExpectedDate(Date expectedDate) {
        this.expectedDate = expectedDate;
    }

    public OrderType getOrderType() {
        return this.orderType;
    }

    public void setOrderType(OrderType orderType) {
        this.orderType = orderType;
    }

    public String getRemarks() {
        return this.remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }

    public String getTransfertCode() {
        return transfertCode;
    }

    public void setTransfertCode(String transfertCode) {
        this.transfertCode = transfertCode;
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

    public String getTransportTel() {
        return transportTel;
    }

    public void setTransportTel(String transportTel) {
        this.transportTel = transportTel;
    }

    public Boolean getSendedToWms() {
        return sendedToWms;
    }

    public void setSendedToWms(Boolean sendedToWms) {
        this.sendedToWms = sendedToWms;
    }

    public Set<SaleOrderLine> getLines() {
        return lines;
    }

    /**
     * @param lines the lines to set
     */
    public void setLines(Set<SaleOrderLine> lines) {
        this.lines = lines;
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

    public BigDecimal getPayedAmount() {
        return payedAmount;
    }

    public void setPayedAmount(BigDecimal payedAmount) {
        this.payedAmount = payedAmount;
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
            SaleOrder obj = (SaleOrder) object;
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