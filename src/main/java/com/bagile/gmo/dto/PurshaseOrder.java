package com.bagile.gmo.dto;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import java.util.Set;

public class PurshaseOrder  extends EmsDto implements Serializable {

    private static final long serialVersionUID = -1064668601145894690L;

    private long id;
    private Owner owner;
    private Transport transport;
    private String code;
    private AddressInfo address;
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
  //  private Set<Reception> receptions;
    private Short containers;
    private Date creationDate;
    private String description;
    private Date receptionDate;
    private OrderStatus orderStatus;
    private String supplierOrderCode;
    private Date expectedDate;
    private Warehouse warehouse;
    private Warehouse warehouseSource;
    private String transportContact;
    private String immatriculation;
    private Set<PurshaseOrderLine> purshaseOrderLines;
    private OrderType orderType;
    private String remarks;
    private String telContact;
    private Supplier supplier;
    private Long cmdType;
    private String accountOrderCode;
    private String transfertCode;
    private BigDecimal totalPriceHT;
    private BigDecimal totalPriceTTC;
    private BigDecimal discount;
    private BigDecimal vat;
    private Currency currency;
    private Boolean active;
    private SaleOrder saleOrder;
    private Boolean accounted=true;
    //private Set<ExtraCost> extraCosts;
    //private Set<BillingTermPurshase> billingTermPurshases;
   // private PaymentStatus paymentStatus;
    private Box box;
    private BigDecimal payedAmount=BigDecimal.ZERO;
    private BigDecimal totalPriceHTDefaultCurrency;
    private BigDecimal totalPriceTTCDefaultCurrency;
    private BigDecimal vatDefaultCurrency;
    private BigDecimal exchangeRate;
    private BigDecimal provisionalCost;
    private BigDecimal extraCost;
    //private Deal deal;
    private Account account;

    private String notes;

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

    public AddressInfo getAddress() {
        return address;
    }

    public void setAddress(AddressInfo address) {
        this.address = address;
    }

    public Date getUpdateDate() {
        return updateDate;
    }

    public void setUpdateDate(Date updateDate) {
        this.updateDate = updateDate;
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

   /* public Set<Reception> getReceptions() {
        return receptions;
    }

    public void setReceptions(Set<Reception> receptions) {
        this.receptions = receptions;
    }*/

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }

    public Short getContainers() {
        return containers;
    }

    public void setContainers(Short containers) {
        this.containers = containers;
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

    public OrderStatus getOrderStatus() {
        return orderStatus;
    }

    public void setOrderStatus(OrderStatus orderStatus) {
        this.orderStatus = orderStatus;
    }

    public String getSupplierOrderCode() {
        return supplierOrderCode;
    }

    public void setSupplierOrderCode(String supplierOrderCode) {
        this.supplierOrderCode = supplierOrderCode;
    }

    public Date getExpectedDate() {
        return expectedDate;
    }

    public void setExpectedDate(Date expectedDate) {
        this.expectedDate = expectedDate;
    }

    public Warehouse getWarehouse() {
        return warehouse;
    }

    public void setWarehouse(Warehouse warehouse) {
        this.warehouse = warehouse;
    }

    public String getTransportContact() {
        return transportContact;
    }

    public void setTransportContact(String transportContact) {
        this.transportContact = transportContact;
    }

    public String getImmatriculation() {
        return immatriculation;
    }

    public void setImmatriculation(String immatriculation) {
        this.immatriculation = immatriculation;
    }

    public Set<PurshaseOrderLine> getPurshaseOrderLines() {
        return purshaseOrderLines;
    }

    public void setPurshaseOrderLines(Set<PurshaseOrderLine> purshaseOrderLines) {
        this.purshaseOrderLines = purshaseOrderLines;
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

    public String getTelContact() {
        return telContact;
    }

    public void setTelContact(String telContact) {
        this.telContact = telContact;
    }

    public Supplier getSupplier() {
        return supplier;
    }

    public void setSupplier(Supplier supplier) {
        this.supplier = supplier;
    }

    public Long getCmdType() {
        return cmdType;
    }

    public void setCmdType(Long cmdType) {
        this.cmdType = cmdType;
    }

    public Warehouse getWarehouseSource() {
        return warehouseSource;
    }

    public void setWarehouseSource(Warehouse warehouseSource) {
        this.warehouseSource = warehouseSource;
    }

    public String getAccountOrderCode() {
        return accountOrderCode;
    }

    public void setAccountOrderCode(String accountOrderCode) {
        this.accountOrderCode = accountOrderCode;
    }

    public String getTransfertCode() {
        return transfertCode;
    }

    public void setTransfertCode(String transfertCode) {
        this.transfertCode = transfertCode;
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

    public BigDecimal getDiscount() {
        return discount;
    }

    public void setDiscount(BigDecimal discount) {
        this.discount = discount;
    }

    public BigDecimal getVat() {
        return vat;
    }

    public void setVat(BigDecimal vat) {
        this.vat = vat;
    }

    public Currency getCurrency() {
        return currency;
    }

    public void setCurrency(Currency currency) {
        this.currency = currency;
    }

    public Boolean getActive() {
        return active;
    }

    public void setActive(Boolean active) {
        this.active = active;
    }

    public SaleOrder getSaleOrder() {
        return saleOrder;
    }

    public void setSaleOrder(SaleOrder saleOrder) {
        this.saleOrder = saleOrder;
    }

/*    public Set<BillingTermPurshase> getBillingTermPurshases() {
        return billingTermPurshases;
    }

    public void setBillingTermPurshases(Set<BillingTermPurshase> billingTermPurshases) {
        this.billingTermPurshases = billingTermPurshases;
    }
*/
  /*  public Set<ExtraCost> getExtraCosts() {
        return extraCosts;
    }

    public void setExtraCosts(Set<ExtraCost> extraCosts) {
        this.extraCosts = extraCosts;
    }
*/
    public Boolean getAccounted() {
        return accounted;
    }

    public void setAccounted(Boolean accounted) {
        this.accounted = accounted;
    }

   /* public PaymentStatus getPaymentStatus() {
        return paymentStatus;
    }

    public void setPaymentStatus(PaymentStatus paymentStatus) {
        this.paymentStatus = paymentStatus;
    }
*/

    public Box getBox() {
        return box;
    }

    public void setBox(Box box) {
        this.box = box;
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

   /* public Deal getDeal() {
        return deal;
    }

    public void setDeal(Deal deal) {
        this.deal = deal;
    }*/

    public Account getAccount() {
        return account;
    }

    public void setAccount(Account account) {
        this.account = account;
    }

    @Override
    public boolean equals(Object object) {
        boolean result = false;
        if (object == null || object.getClass() != getClass()) {
            result = false;
        } else {
            PurshaseOrder obj = (PurshaseOrder) object;
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