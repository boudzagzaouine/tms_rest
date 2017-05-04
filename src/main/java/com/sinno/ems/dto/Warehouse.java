package com.sinno.ems.dto;

import java.io.Serializable;
import java.util.Date;
import java.util.Set;

public class Warehouse implements Serializable {

    /**
     *
     */
    private static final long serialVersionUID = -5756625495799597845L;

    private long id;
    private String code;
    private Date updateDate;
    private Address address;
    private String description;
    private Date creationDate;
    private Set<SaleOrder> saleOrders;
    private Set<Product> products;
    private Set<Stock> stocks;
    private Set<Container> containers;
    private Set<StockArc> stockArcs;
    private Set<StockReserved> stockReserveds;
    private Set<SaleOrderArc> saleOrderArcs;
    private Set<ReceptionLine> receptionLines;
    private Set<ReceptionStock> receptionStocks;
    private Set<ContainerArc> containerArcs;
    private Set<ReceptionLineArc> receptionLineArcs;
    private Set<PurshaseOrderLineArc> purshaseOrderLineArcs;
    private Set<SaleOrderStockArc> saleOrderStockArcs;
    private Set<SaleOrderLineArc> saleOrderLineArcs;
    private Set<SaleOrderLine> saleOrderLines;
    private Set<PurshaseOrderLine> purshaseOrderLines;
    private Set<SaleOrderStock> saleOrderStocks;
    private Set<ReceptionStockArc> receptionStockArcs;
    private Set<Location> locations;
    private Set<Aisle> aisles;
    private Set<Product> products_1;
    private Set<ZoneWarehouse> zoneWarehouses;
    private String email;
    private String telephone;
    private Boolean active;

    public long getId() {
        return this.id;
    }

    public void setId(long id) {
        this.id = id;
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

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    /**
     * @return the description
     */
    public String getDescription() {
        return description;
    }

    /**
     * @param description the description to set
     */
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * @return the creationDate
     */
    public Date getCreationDate() {
        return creationDate;
    }

    /**
     * @param creationDate the creationDate to set
     */
    public void setCreationDate(Date creationDate) {
        this.creationDate = creationDate;
    }

    /**
     * @return the saleOrders
     */
    public Set<SaleOrder> getSaleOrders() {
        return saleOrders;
    }

    /**
     * @param saleOrders the saleOrders to set
     */
    public void setSaleOrders(Set<SaleOrder> saleOrders) {
        this.saleOrders = saleOrders;
    }

    /**
     * @return the products
     */
    public Set<Product> getProducts() {
        return products;
    }

    /**
     * @param products the products to set
     */
    public void setProducts(Set<Product> products) {
        this.products = products;
    }

    /**
     * @return the stocks
     */
    public Set<Stock> getStocks() {
        return stocks;
    }

    /**
     * @param stocks the stocks to set
     */
    public void setStocks(Set<Stock> stocks) {
        this.stocks = stocks;
    }

    /**
     * @return the containers
     */
    public Set<Container> getContainers() {
        return containers;
    }

    /**
     * @param containers the containers to set
     */
    public void setContainers(Set<Container> containers) {
        this.containers = containers;
    }

    /**
     * @return the stockArcs
     */
    public Set<StockArc> getStockArcs() {
        return stockArcs;
    }

    /**
     * @param stockArcs the stockArcs to set
     */
    public void setStockArcs(Set<StockArc> stockArcs) {
        this.stockArcs = stockArcs;
    }

    /**
     * @return the stockReserveds
     */
    public Set<StockReserved> getStockReserveds() {
        return stockReserveds;
    }

    /**
     * @param stockReserveds the stockReserveds to set
     */
    public void setStockReserveds(Set<StockReserved> stockReserveds) {
        this.stockReserveds = stockReserveds;
    }

    /**
     * @return the saleOrderArcs
     */
    public Set<SaleOrderArc> getSaleOrderArcs() {
        return saleOrderArcs;
    }

    /**
     * @param saleOrderArcs the saleOrderArcs to set
     */
    public void setSaleOrderArcs(Set<SaleOrderArc> saleOrderArcs) {
        this.saleOrderArcs = saleOrderArcs;
    }

    /**
     * @return the receptionLines
     */
    public Set<ReceptionLine> getReceptionLines() {
        return receptionLines;
    }

    /**
     * @param receptionLines the receptionLines to set
     */
    public void setReceptionLines(Set<ReceptionLine> receptionLines) {
        this.receptionLines = receptionLines;
    }

    /**
     * @return the receptionStocks
     */
    public Set<ReceptionStock> getReceptionStocks() {
        return receptionStocks;
    }

    /**
     * @param receptionStocks the receptionStocks to set
     */
    public void setReceptionStocks(Set<ReceptionStock> receptionStocks) {
        this.receptionStocks = receptionStocks;
    }

    /**
     * @return the containerArcs
     */
    public Set<ContainerArc> getContainerArcs() {
        return containerArcs;
    }

    /**
     * @param containerArcs the containerArcs to set
     */
    public void setContainerArcs(Set<ContainerArc> containerArcs) {
        this.containerArcs = containerArcs;
    }

    /**
     * @return the receptionLineArcs
     */
    public Set<ReceptionLineArc> getReceptionLineArcs() {
        return receptionLineArcs;
    }

    /**
     * @param receptionLineArcs the receptionLineArcs to set
     */
    public void setReceptionLineArcs(Set<ReceptionLineArc> receptionLineArcs) {
        this.receptionLineArcs = receptionLineArcs;
    }

    /**
     * @return the purshaseOrderLineArcs
     */
    public Set<PurshaseOrderLineArc> getPurshaseOrderLineArcs() {
        return purshaseOrderLineArcs;
    }

    /**
     * @param purshaseOrderLineArcs the purshaseOrderLineArcs to set
     */
    public void setPurshaseOrderLineArcs(
            Set<PurshaseOrderLineArc> purshaseOrderLineArcs) {
        this.purshaseOrderLineArcs = purshaseOrderLineArcs;
    }

    /**
     * @return the saleOrderStockArcs
     */
    public Set<SaleOrderStockArc> getSaleOrderStockArcs() {
        return saleOrderStockArcs;
    }

    /**
     * @param saleOrderStockArcs the saleOrderStockArcs to set
     */
    public void setSaleOrderStockArcs(Set<SaleOrderStockArc> saleOrderStockArcs) {
        this.saleOrderStockArcs = saleOrderStockArcs;
    }

    /**
     * @return the saleOrderLineArcs
     */
    public Set<SaleOrderLineArc> getSaleOrderLineArcs() {
        return saleOrderLineArcs;
    }

    /**
     * @param saleOrderLineArcs the saleOrderLineArcs to set
     */
    public void setSaleOrderLineArcs(Set<SaleOrderLineArc> saleOrderLineArcs) {
        this.saleOrderLineArcs = saleOrderLineArcs;
    }

    /**
     * @return the saleOrderLines
     */
    public Set<SaleOrderLine> getSaleOrderLines() {
        return saleOrderLines;
    }

    /**
     * @param saleOrderLines the saleOrderLines to set
     */
    public void setSaleOrderLines(Set<SaleOrderLine> saleOrderLines) {
        this.saleOrderLines = saleOrderLines;
    }

    /**
     * @return the purshaseOrderLines
     */
    public Set<PurshaseOrderLine> getPurshaseOrderLines() {
        return purshaseOrderLines;
    }

    /**
     * @param purshaseOrderLines the purshaseOrderLines to set
     */
    public void setPurshaseOrderLines(Set<PurshaseOrderLine> purshaseOrderLines) {
        this.purshaseOrderLines = purshaseOrderLines;
    }

    /**
     * @return the saleOrderStocks
     */
    public Set<SaleOrderStock> getSaleOrderStocks() {
        return saleOrderStocks;
    }

    /**
     * @param saleOrderStocks the saleOrderStocks to set
     */
    public void setSaleOrderStocks(Set<SaleOrderStock> saleOrderStocks) {
        this.saleOrderStocks = saleOrderStocks;
    }

    /**
     * @return the receptionStockArcs
     */
    public Set<ReceptionStockArc> getReceptionStockArcs() {
        return receptionStockArcs;
    }

    /**
     * @param receptionStockArcs the receptionStockArcs to set
     */
    public void setReceptionStockArcs(Set<ReceptionStockArc> receptionStockArcs) {
        this.receptionStockArcs = receptionStockArcs;
    }

    /**
     * @return the locations
     */
    public Set<Location> getLocations() {
        return locations;
    }

    /**
     * @param locations the locations to set
     */
    public void setLocations(Set<Location> locations) {
        this.locations = locations;
    }

    /**
     * @return the aisles
     */
    public Set<Aisle> getAisles() {
        return aisles;
    }

    /**
     * @param aisles the aisles to set
     */
    public void setAisles(Set<Aisle> aisles) {
        this.aisles = aisles;
    }

    /**
     * @return the products_1
     */
    public Set<Product> getProducts_1() {
        return products_1;
    }

    /**
     * @param products_1 the products_1 to set
     */
    public void setProducts_1(Set<Product> products_1) {
        this.products_1 = products_1;
    }

    /**
     * @return the zones
     */


    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public Boolean getActive() {
        return active;
    }

    public void setActive(Boolean active) {
        this.active = active;
    }

    public Set<ZoneWarehouse> getZoneWarehouses() {
        return zoneWarehouses;
    }

    public void setZoneWarehouses(Set<ZoneWarehouse> zoneWarehouses) {
        this.zoneWarehouses = zoneWarehouses;
    }

    @Override
    public boolean equals(Object object) {
        boolean result = false;
        if (object == null || object.getClass() != getClass()) {
            result = false;
        } else {
            Warehouse obj = (Warehouse) object;
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