package com.bagile.tms.dto;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import java.util.Set;

public class SaleOrder implements Serializable {

    /**
     *
     */
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
    private Address AddressBySaleOrderDeliveryAddress;
    private Address AddressBySaleOrderInvoiceAddress;
    private Long cmdSaleOrderNumberLine;
    private Long cmdSaleOrderNumberLineCmd;
    private String transportTel;
    private Boolean active;
    private Warehouse warehouse;
    private Warehouse warehouseDestination;

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

    public Account getAccount() {
        return account;
    }

    public void setAccount(Account account) {
        this.account = account;
    }

    public Date getLoadDate() {
        return loadDate;
    }

    public void setLoadDate(Date loadDate) {
        this.loadDate = loadDate;
    }

    public String getCustomerCode() {
        return customerCode;
    }

    public void setCustomerCode(String customerCode) {
        this.customerCode = customerCode;
    }

    public OrderStatus getOrderStatus() {
        return orderStatus;
    }

    public void setOrderStatus(OrderStatus orderStatus) {
        this.orderStatus = orderStatus;
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

    public Date getExpectedDate() {
        return expectedDate;
    }

    public void setExpectedDate(Date expectedDate) {
        this.expectedDate = expectedDate;
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

    public Set<SaleOrderLine> getLines() {
        return lines;
    }

    public void setLines(Set<SaleOrderLine> lines) {
        this.lines = lines;
    }

    public Address getAddressBySaleOrderDeliveryAddress() {
        return AddressBySaleOrderDeliveryAddress;
    }

    public void setAddressBySaleOrderDeliveryAddress(Address addressBySaleOrderDeliveryAddress) {
        AddressBySaleOrderDeliveryAddress = addressBySaleOrderDeliveryAddress;
    }

    public Address getAddressBySaleOrderInvoiceAddress() {
        return AddressBySaleOrderInvoiceAddress;
    }

    public void setAddressBySaleOrderInvoiceAddress(Address addressBySaleOrderInvoiceAddress) {
        AddressBySaleOrderInvoiceAddress = addressBySaleOrderInvoiceAddress;
    }

    public Long getCmdSaleOrderNumberLine() {
        return cmdSaleOrderNumberLine;
    }

    public void setCmdSaleOrderNumberLine(Long cmdSaleOrderNumberLine) {
        this.cmdSaleOrderNumberLine = cmdSaleOrderNumberLine;
    }

    public Long getCmdSaleOrderNumberLineCmd() {
        return cmdSaleOrderNumberLineCmd;
    }

    public void setCmdSaleOrderNumberLineCmd(Long cmdSaleOrderNumberLineCmd) {
        this.cmdSaleOrderNumberLineCmd = cmdSaleOrderNumberLineCmd;
    }

    public String getTransportTel() {
        return transportTel;
    }

    public void setTransportTel(String transportTel) {
        this.transportTel = transportTel;
    }

    public Boolean getActive() {
        return active;
    }

    public void setActive(Boolean active) {
        this.active = active;
    }

    public Warehouse getWarehouse() {
        return warehouse;
    }

    public void setWarehouse(Warehouse warehouse) {
        this.warehouse = warehouse;
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

    public Warehouse getWarehouseDestination() {
        return warehouseDestination;
    }

    public void setWarehouseDestination(Warehouse warehouseDestination) {
        this.warehouseDestination = warehouseDestination;
    }
}