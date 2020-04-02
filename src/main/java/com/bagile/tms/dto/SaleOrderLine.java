package com.bagile.tms.dto;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import java.util.Set;

public class SaleOrderLine  extends EmsDto implements Serializable {

    /**
     *
     */
    private static final long serialVersionUID = -8747248049547537558L;

    private long id;
    private Long lineNumber;
    private Owner owner;
    private Date date;
    private Transport transport;
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
    private Date creationDate;
    private String description;
    private Warehouse warehouse;
    private Product product;
    private Date dlc;
    private Date dluo;
    private String serialNo;
    private String lot;
    private SaleOrder saleOrder;
    private BigDecimal quantityServed;
    private OrderStatus orderStatus;
    private BigDecimal quantity;
    private BigDecimal quantityReserved;
    private BigDecimal quantityPrepare;
    private BigDecimal quantityDeliver;
    private BigDecimal remainingQuantity;
    private Uom uom;

    private String comment;
    private String quality;
    private BigDecimal weight;
    private String containerCode;
    private BigDecimal totalPriceHT;
    private BigDecimal totalPriceTTC;
    private Vat vat;
    private BigDecimal discount;
    private BigDecimal salePrice;
    private Product menu;
    private Long  menuQuantity;
    private Long menuNumber;
    private SaleOrderLine parentService;
    private Set<SaleOrderLine> services;
    private Boolean isPromotion;
   private ProductPack productPack;


    public long getId() {
        return this.id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Long getLineNumber() {
        return this.lineNumber;
    }

    public void setLineNumber(Long lineNumber) {
        this.lineNumber = lineNumber;
    }

    public Owner getOwner() {
        return this.owner;
    }

    public void setOwner(Owner owner) {
        this.owner = owner;
    }

    public Date getDate() {
        return this.date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Transport getTransport() {
        return this.transport;
    }

    public void setTransport(Transport transport) {
        this.transport = transport;
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

    public String getDescription() {
        return this.description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Warehouse getWarehouse() {
        return this.warehouse;
    }

    public void setWarehouse(Warehouse warehouse) {
        this.warehouse = warehouse;
    }

    public Product getProduct() {
        return this.product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public Date getDlc() {
        return this.dlc;
    }

    public void setDlc(Date dlc) {
        this.dlc = dlc;
    }

    public Date getDluo() {
        return this.dluo;
    }

    public void setDluo(Date dluo) {
        this.dluo = dluo;
    }

    public String getSerialNo() {
        return this.serialNo;
    }

    public void setSerialNo(String serialNo) {
        this.serialNo = serialNo;
    }

    public String getLot() {
        return this.lot;
    }

    public void setLot(String lot) {
        this.lot = lot;
    }

    public SaleOrder getSaleOrder() {
        return this.saleOrder;
    }

    public void setSaleOrder(SaleOrder saleOrder) {
        this.saleOrder = saleOrder;
    }

    public BigDecimal getQuantityServed() {
        return this.quantityServed;
    }

    public void setQuantityServed(BigDecimal quantityServed) {
        this.quantityServed = quantityServed;
    }

    public OrderStatus getOrderStatus() {
        return this.orderStatus;
    }

    public void setOrderStatus(OrderStatus orderStatus) {
        this.orderStatus = orderStatus;
    }

    public BigDecimal getQuantity() {
        return this.quantity;
    }

    public void setQuantity(BigDecimal quantity) {
        this.quantity = quantity;
    }

    public BigDecimal getQuantityReserved() {
        return quantityReserved;
    }

    public void setQuantityReserved(BigDecimal quantityReserved) {
        this.quantityReserved = quantityReserved;
    }

    public BigDecimal getQuantityPrepare() {
        return quantityPrepare;
    }

    public void setQuantityPrepare(BigDecimal quantityPrepare) {
        this.quantityPrepare = quantityPrepare;
    }

    public BigDecimal getQuantityDeliver() {
        return quantityDeliver;
    }

    public void setQuantityDeliver(BigDecimal quantityDeliver) {
        this.quantityDeliver = quantityDeliver;
    }

    public Uom getUom() {
        return this.uom;
    }

    public void setUom(Uom uom) {
        this.uom = uom;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public String getQuality() {
        return quality;
    }

    public void setQuality(String quality) {
        this.quality = quality;
    }

    public BigDecimal getWeight() {
        return weight;
    }

    public void setWeight(BigDecimal weight) {
        this.weight = weight;
    }

    public String getContainerCode() {
        return containerCode;
    }

    public void setContainerCode(String containerCode) {
        this.containerCode = containerCode;
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

    public Vat getVat() {
        return vat;
    }

    public void setVat(Vat vat) {
        this.vat = vat;
    }

    public BigDecimal getDiscount() {
        return discount;
    }

    public void setDiscount(BigDecimal discount) {
        this.discount = discount;
    }

    public BigDecimal getSalePrice() {
        return salePrice;
    }

    public void setSalePrice(BigDecimal salePrice) {
        this.salePrice = salePrice;
    }

    public Product getMenu() {
        return menu;
    }

    public void setMenu(Product menu) {
        this.menu = menu;
    }

    public Long getMenuQuantity() {
        return menuQuantity;
    }

    public void setMenuQuantity(Long menuQuantity) {
        this.menuQuantity = menuQuantity;
    }

    public Long getMenuNumber() {
        return menuNumber;
    }

    public void setMenuNumber(Long menuNumber) {
        this.menuNumber = menuNumber;
    }


    public SaleOrderLine getParentService() {
        return parentService;
    }

    public void setParentService(SaleOrderLine parentService) {
        this.parentService = parentService;
    }

    public Set<SaleOrderLine> getServices() {
        return services;
    }

    public void setServices(Set<SaleOrderLine> services) {
        this.services = services;
    }


    public Boolean getPromotion() {
        return isPromotion;
    }

    public void setPromotion(Boolean promotion) {
        isPromotion = promotion;
    }

    public ProductPack getProductPack() {
        return productPack;
    }

    public void setProductPack(ProductPack productPack) {
        this.productPack = productPack;
    }

    public BigDecimal getRemainingQuantity() {
        return remainingQuantity;
    }

    public void setRemainingQuantity(BigDecimal remainingQuantity) {
        this.remainingQuantity = remainingQuantity;
    }
}