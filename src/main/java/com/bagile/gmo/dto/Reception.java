package com.bagile.gmo.dto;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import java.util.Set;

public class Reception  extends EmsDto implements Serializable {

    private static final long serialVersionUID = 2609034821898581259L;

    private long id;
    private Owner owner;
    private Transport transport;
    private String code;
    private Date updateDate;
    private AddressInfo address;
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
    private Date creationDate;
    private String description;
    private Date receptionDate;
    private Supplier supplier;
    private String orderCode;
    private Date expectedDate;
    private PurshaseOrder purshaseOrder;
    private OrderType orderType;
    private String remarks;
    private OrderStatus orderStatus;
    private Warehouse warehouse;
    private Long numberOfContainers;
    private Location location;
    private Delivery delivery;
    private String transportTel;
    private Set<ReceptionLine> receptionLines;
    private Set<ReceptionStock> receptionStocks;
    private String immatriculation;
    private Account account;
    private String transportContact;
    private String transfertCode;
    private Boolean sendedToWms;
    private BigDecimal discount;
    private BigDecimal totalPriceHT;
    private BigDecimal totalPriceTTC;
    private Currency currency;
    private BigDecimal vat;
    private Boolean active;
    private Boolean accounted;
    private BigDecimal totalPriceHTDefaultCurrency;
    private BigDecimal totalPriceTTCDefaultCurrency;
    private BigDecimal vatDefaultCurrency;
    private BigDecimal exchangeRate;
    private Box box;
    private BigDecimal provisionalCost;
    private BigDecimal extraCost;
    private Date supplierDeliveryDate;

    private Boolean gmao ;
    private Boolean invoice;

    public String getTransportContact() {
        return transportContact;
    }

    public void setTransportContact(String transportContact) {
        this.transportContact = transportContact;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Owner getOwner() {
        return owner;
    }

    public void setOwner(Owner owner) {
        this.owner = owner;
    }

    public Boolean getInvoice() {
        return invoice;
    }

    public void setInvoice(Boolean invoice) {
        this.invoice = invoice;
    }

    public Transport getTransport() {
        return transport;
    }

    public void setTransport(Transport transport) {
        this.transport = transport;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public Date getUpdateDate() {
        return updateDate;
    }

    public void setUpdateDate(Date updateDate) {
        this.updateDate = updateDate;
    }

    public AddressInfo getAddress() {
        return address;
    }

    public void setAddress(AddressInfo address) {
        this.address = address;
    }

    public String getVariable1() {
        return variable1;
    }

    public void setVariable1(String variable1) {
        this.variable1 = variable1;
    }

    public String getVariable2() {
        return variable2;
    }

    public void setVariable2(String variable2) {
        this.variable2 = variable2;
    }

    public String getVariable3() {
        return variable3;
    }

    public void setVariable3(String variable3) {
        this.variable3 = variable3;
    }

    public String getVariable4() {
        return variable4;
    }

    public void setVariable4(String variable4) {
        this.variable4 = variable4;
    }

    public String getVariable5() {
        return variable5;
    }

    public void setVariable5(String variable5) {
        this.variable5 = variable5;
    }

    public String getVariable6() {
        return variable6;
    }

    public void setVariable6(String variable6) {
        this.variable6 = variable6;
    }

    public String getVariable7() {
        return variable7;
    }

    public void setVariable7(String variable7) {
        this.variable7 = variable7;
    }

    public String getVariable8() {
        return variable8;
    }

    public void setVariable8(String variable8) {
        this.variable8 = variable8;
    }

    public String getVariable9() {
        return variable9;
    }

    public void setVariable9(String variable9) {
        this.variable9 = variable9;
    }

    public String getVariable10() {
        return variable10;
    }

    public void setVariable10(String variable10) {
        this.variable10 = variable10;
    }

    public Date getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(Date creationDate) {
        this.creationDate = creationDate;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Date getReceptionDate() {
        return receptionDate;
    }

    public void setReceptionDate(Date receptionDate) {
        this.receptionDate = receptionDate;
    }

    public Supplier getSupplier() {
        return supplier;
    }

    public void setSupplier(Supplier supplier) {
        this.supplier = supplier;
    }


    public Boolean getGmao() {
        return gmao;
    }

    public void setGmao(Boolean gmao) {
        this.gmao = gmao;
    }

    public String getOrderCode() {
        return orderCode;
    }

    public void setOrderCode(String orderCode) {
        this.orderCode = orderCode;
    }

    public Date getExpectedDate() {
        return expectedDate;
    }

    public void setExpectedDate(Date expectedDate) {
        this.expectedDate = expectedDate;
    }

    public PurshaseOrder getPurshaseOrder() {
        return purshaseOrder;
    }

    public void setPurshaseOrder(PurshaseOrder purshaseOrder) {
        this.purshaseOrder = purshaseOrder;
    }

    public OrderType getOrderType() {
        return orderType;
    }

    public void setOrderType(OrderType orderType) {
        this.orderType = orderType;
    }

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }

    public Set<ReceptionLine> getReceptionLines() {
        return receptionLines;
    }

    public void setReceptionLines(Set<ReceptionLine> receptionLines) {
        this.receptionLines = receptionLines;
    }

    public Set<ReceptionStock> getReceptionStocks() {
        return receptionStocks;
    }

    public void setReceptionStocks(Set<ReceptionStock> receptionStocks) {
        this.receptionStocks = receptionStocks;
    }

    public OrderStatus getOrderStatus() {
        return orderStatus;
    }

    public void setOrderStatus(OrderStatus orderStatus) {
        this.orderStatus = orderStatus;
    }

    public Warehouse getWarehouse() {
        return warehouse;
    }

    public void setWarehouse(Warehouse warehouse) {
        this.warehouse = warehouse;
    }

    public Long getNumberOfContainers() {
        return numberOfContainers;
    }

    public void setNumberOfContainers(Long numberOfContainers) {
        this.numberOfContainers = numberOfContainers;
    }

    public Delivery getDelivery() {
        return delivery;
    }

    public void setDelivery(Delivery delivery) {
        this.delivery = delivery;
    }

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    public String getTransportTel() {
        return transportTel;
    }

    public void setTransportTel(String transportTel) {
        this.transportTel = transportTel;
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

    public Account getAccount() {
        return account;
    }

    public void setAccount(Account account) {
        this.account = account;
    }

    public Boolean getSendedToWms() {
        return sendedToWms;
    }

    public void setSendedToWms(Boolean sendedToWms) {
        this.sendedToWms = sendedToWms;
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

    public Currency getCurrency() {
        return currency;
    }

    public void setCurrency(Currency currency) {
        this.currency = currency;
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

    public Box getBox() {
        return box;
    }

    public void setBox(Box box) {
        this.box = box;
    }

    public BigDecimal getProvisionalCost() {
        return provisionalCost;
    }

    public void setProvisionalCost(BigDecimal provisionalCost) {
        this.provisionalCost = provisionalCost;
    }

    public BigDecimal getExtraCost() {
        return extraCost;
    }

    public void setExtraCost(BigDecimal extraCost) {
        this.extraCost = extraCost;
    }
    public Date getSupplierDeliveryDate() {
        return supplierDeliveryDate;
    }

    public void setSupplierDeliveryDate(Date supplierDeliveryDate) {
        this.supplierDeliveryDate = supplierDeliveryDate;
    }



    @Override
    public boolean equals(Object object) {
        boolean result = false;
        if (object == null || object.getClass() != getClass()) {
            result = false;
        } else {
            Reception obj = (Reception) object;
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