package com.bagile.gmo.entities;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@Entity
@Table(name="gmo_actionlinemaintenance")
public class GmoActionLineMaintenance extends EmsEntity {

	private static final long serialVersionUID = -6143066188263513604L;
	private long gmoActionLineId;
    private PdtProduct pdtProduct;
    private String gmoActionLineDescription;
    private BigDecimal gmoActionLineTotalPriceHT;
    private BigDecimal gmoActionLineTotalPriceTTC;
    private  BigDecimal gmoAmountVat;
    private BigDecimal gmoActionLineQuantity;
    private BigDecimal gmoActionLineunitPrice;
    private BigDecimal gmoActionLineOrderQuantity;
    private BigDecimal gmoActionLineMaintenanceOrderQuantity;
    private Set<GmoMaintenanceStock> gmoMaintenanceStocks=new HashSet<GmoMaintenanceStock>(0);
    private GmoMaintenance gmoMaintenance;
 private OwnOwner ownOwner;

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE ,generator = "seq")
    @SequenceGenerator (name = "seq", sequenceName = "seq_gmo_actionline_id", allocationSize = 1)
    @Column(name = "gmo_gmo_actionlineid")
    public long getGmoActionLineId() {
        return gmoActionLineId;
    }

    public void setGmoActionLineId(long gmoActionLineId) {
        this.gmoActionLineId = gmoActionLineId;
    }

    @ManyToOne
    @JoinColumn(name = "pdt_productid")
    public PdtProduct getPdtProduct() {
        return pdtProduct;
    }

    public void setPdtProduct(PdtProduct pdtProduct) {
        this.pdtProduct = pdtProduct;
    }


    public BigDecimal getGmoActionLineMaintenanceOrderQuantity() {
        return gmoActionLineMaintenanceOrderQuantity;
    }

    public void setGmoActionLineMaintenanceOrderQuantity(BigDecimal gmoActionLineMaintenanceOrderQuantity) {
        this.gmoActionLineMaintenanceOrderQuantity = gmoActionLineMaintenanceOrderQuantity;
    }

    @OneToMany(fetch = FetchType.LAZY,mappedBy = "gmoActionLineMaintenance",cascade = CascadeType.ALL)
    public Set<GmoMaintenanceStock> getGmoMaintenanceStocks() {
        return gmoMaintenanceStocks;
    }

    public void setGmoMaintenanceStocks(Set<GmoMaintenanceStock> gmoMaintenanceStocks) {
        this.gmoMaintenanceStocks = gmoMaintenanceStocks;
    }


    @Column(name = "gmo_actionlinemaintenancequantity", precision = 12, scale = 5)
    public BigDecimal getGmoActionLineOrderQuantity() {
        return gmoActionLineOrderQuantity;
    }

    public void setGmoActionLineOrderQuantity(BigDecimal gmoActionLineOrderQuantity) {
        this.gmoActionLineOrderQuantity = gmoActionLineOrderQuantity;
    }




    @Column(name = "gmo_actionlinedescription")
    public String getGmoActionLineDescription() {
        return gmoActionLineDescription;
    }

    public void setGmoActionLineDescription(String gmoActionLineDescription) {
        this.gmoActionLineDescription = gmoActionLineDescription;
    }

    @Column(name = "gmo_actionlineunitprice")
    public BigDecimal getGmoActionLineunitPrice() {
        return gmoActionLineunitPrice;
    }

    public void setGmoActionLineunitPrice(BigDecimal gmoActionLineunitPrice) {
        this.gmoActionLineunitPrice = gmoActionLineunitPrice;
    }

    @Column(name = "gmo_amountvatid")
    public BigDecimal getGmoAmountVat() {
        return gmoAmountVat;
    }

    public void setGmoAmountVat(BigDecimal gmoAmountVat) {
        this.gmoAmountVat = gmoAmountVat;
    }

    @Column(name = "gmo_actionlinetotalpriceht")
    public BigDecimal getGmoActionLineTotalPriceHT() {
        return gmoActionLineTotalPriceHT;
    }

    public void setGmoActionLineTotalPriceHT(BigDecimal gmoActionLineTotalPriceHT) {
        this.gmoActionLineTotalPriceHT = gmoActionLineTotalPriceHT;
    }
    @Column(name = "gmo_actionlinetotalpricettc")
    public BigDecimal getGmoActionLineTotalPriceTTC() {
        return gmoActionLineTotalPriceTTC;
    }

    public void setGmoActionLineTotalPriceTTC(BigDecimal gmoActionLineTotalPriceTTC) {
        this.gmoActionLineTotalPriceTTC = gmoActionLineTotalPriceTTC;
    }

    @Column(name = "gmo_actionlinequantity")
    public BigDecimal getGmoActionLineQuantity() {
        return gmoActionLineQuantity;
    }

    public void setGmoActionLineQuantity(BigDecimal gmoQuantity) {
        this.gmoActionLineQuantity = gmoQuantity;
    }


    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "gmo_maintenanceid")
    public GmoMaintenance getGmoMaintenance() {
        return gmoMaintenance;
    }

    public void setGmoMaintenance(GmoMaintenance gmoMaintenance) {
        this.gmoMaintenance = gmoMaintenance;
    }


    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "gmo_ownownerid")
    public OwnOwner getOwnOwner() {
        return ownOwner;
    }

    public void setOwnOwner(OwnOwner ownOwner) {
        this.ownOwner = ownOwner;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        GmoActionLineMaintenance that = (GmoActionLineMaintenance) o;
        return gmoActionLineId == that.gmoActionLineId;
    }

    @Override
    public int hashCode() {
        return Objects.hash(gmoActionLineId);
    }
}
