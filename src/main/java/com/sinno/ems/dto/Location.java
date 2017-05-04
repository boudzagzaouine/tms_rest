package com.sinno.ems.dto;

import java.io.Serializable;
import java.util.Date;
import java.util.Set;

public class Location implements Serializable {

    /**
     *
     */
    private static final long serialVersionUID = 4622081652907516322L;

    private long id;
    private Zone zone;
    private String code;
    private Date updateDate;
    private Boolean active;
    private Warehouse warehouse;
    private Date creationDate;
    private LocationStatus locationStatus;
    private Boolean defaultLocation;
    private Long wmsId;
    private OrderStatus orderStatus;
    private Set<Product> products;
    private Set<Stock> stocks;
    private Set<StockArc> stockArcs;
    private Set<Container> containers;
    private Set<ContainerArc> containerArcs;
    private Set<ReceptionLine> receptionLines;
    private Set<ReceptionLineArc> receptionLineArcs;
    private Set<PurshaseOrderLine> purshaseOrderLines;
    private Set<PurshaseOrderLineArc> purshaseOrderLineArcs;
    private Set<SaleOrderStock> saleOrderStocks;
    private Set<SaleOrderStockArc> saleOrderStockArcs;
    private Set<SaleOrderLine> saleOrderLines;
    private Set<SaleOrderLineArc> saleOrderLineArcs;

    private Boolean picking;
    private Boolean reserve;


    public long getId() {
        return this.id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Zone getZone() {
        return this.zone;
    }

    public void setZone(Zone zone) {
        this.zone = zone;
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

    public Date getCreationDate() {
        return this.creationDate;
    }

    public void setCreationDate(Date creationDate) {
        this.creationDate = creationDate;
    }

    public Warehouse getWarehouse() {
        return this.warehouse;
    }

    public void setWarehouse(Warehouse warehouse) {
        this.warehouse = warehouse;
    }

    /**
     * @return the active
     */
    public Boolean getActive() {
        return active;
    }

    /**
     * @param active the active to set
     */
    public void setActive(Boolean active) {
        this.active = active;
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

    public OrderStatus getOrderStatus() {
        return orderStatus;
    }

    public void setOrderStatus(OrderStatus orderStatus) {
        this.orderStatus = orderStatus;
    }

    public Boolean getPicking() {
        return picking;
    }

    public void setPicking(Boolean picking) {
        this.picking = picking;
    }

    public Boolean getReserve() {
        return reserve;
    }

    public void setReserve(Boolean reserve) {
        this.reserve = reserve;
    }

    public LocationStatus getLocationStatus() {
        return locationStatus;
    }

    public void setLocationStatus(LocationStatus locationStatus) {
        this.locationStatus = locationStatus;
    }

    public Boolean getDefaultLocation() {
        return defaultLocation;
    }

    public void setDefaultLocation(Boolean defaultLocation) {
        this.defaultLocation = defaultLocation;
    }

    public Long getWmsId() {
        return wmsId;
    }

    public void setWmsId(Long wmsId) {
        this.wmsId = wmsId;
    }

    @Override
    public boolean equals(Object object) {
        boolean result = false;
        if (object == null || object.getClass() != getClass()) {
            result = false;
        } else {
            Location obj = (Location) object;
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