package com.bagile.gmo.entities;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="gmo_maintenanceline")
public class GmoMaintenanceLine extends EmsEntity {

	private static final long serialVersionUID = -6143066188263513604L;
	
	private long gmoMaintenanceLineId;
    private PdtProduct gmoMaintenanceLineProduct;
    private String gmoMaintenanceLineDescription;
    private BigDecimal gmoMaintenanceLineQuantity;
    private BigDecimal gmoMaintenanceLineUnitPrice;
    private BigDecimal gmoMaintenanceLineTotalPriceHT;
    private BigDecimal gmoMaintenanceLineTotalPriceTTC;
    private GmoMaintenancePlan gmoMaintenanceLineMaintenancePlan;
    private  BigDecimal gmoAmountVat;
    
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE ,generator = "seq")
    @SequenceGenerator (name = "seq", sequenceName = "seq_gmo_maintenance_line_id", allocationSize = 1)
    @Column(name = "gmo_maintenancelineid")
    public long getGmoMaintenanceLineId() {
        return gmoMaintenanceLineId;
    }

    public void setGmoMaintenanceLineId(long gmoMaintenanceLineId) {
        this.gmoMaintenanceLineId = gmoMaintenanceLineId;
    }

    @ManyToOne
    @JoinColumn(name = "gmo_maintenancelineproductid")
    public PdtProduct getGmoMaintenanceLineProduct() {
        return gmoMaintenanceLineProduct;
    }

    public void setGmoMaintenanceLineProduct(PdtProduct gmoMaintenanceLineProduct) {
        this.gmoMaintenanceLineProduct = gmoMaintenanceLineProduct;
    }
    @Column(name = "gmo_maintenancelinedescription")
    public String getGmoMaintenanceLineDescription() {
        return gmoMaintenanceLineDescription;
    }

    public void setGmoMaintenanceLineDescription(String gmoMaintenanceLineDescription) {
        this.gmoMaintenanceLineDescription = gmoMaintenanceLineDescription;
    }

    @Column(name = "gmo_maintenancelineamountvat")
    public BigDecimal getGmoAmountVat() {
        return gmoAmountVat;
    }

    public void setGmoAmountVat(BigDecimal gmoAmountVat) {
        this.gmoAmountVat = gmoAmountVat;
    }

    @Column(name = "gmo_maintenancelinequantity")
    public BigDecimal getGmoMaintenanceLineQuantity() {
        return gmoMaintenanceLineQuantity;
    }

    public void setGmoMaintenanceLineQuantity(BigDecimal gmoMaintenanceLineQuantity) {
        this.gmoMaintenanceLineQuantity = gmoMaintenanceLineQuantity;
    }
    @Column(name = "gmo_maintenancelineunitprice")
    public BigDecimal getGmoMaintenanceLineUnitPrice() {
        return gmoMaintenanceLineUnitPrice;
    }

    public void setGmoMaintenanceLineUnitPrice(BigDecimal gmoMaintenanceLineUnitPrice) {
        this.gmoMaintenanceLineUnitPrice = gmoMaintenanceLineUnitPrice;
    }

    @Column(name = "gmo_maintenancelinetotalpriceht")
    public BigDecimal getGmoMaintenanceLineTotalPriceHT() {
        return gmoMaintenanceLineTotalPriceHT;
    }

    public void setGmoMaintenanceLineTotalPriceHT(BigDecimal gmoMaintenanceLineTotalPriceHT) {
        this.gmoMaintenanceLineTotalPriceHT = gmoMaintenanceLineTotalPriceHT;
    }
@Column(name = "gmo_maintenancelinetotalpricettc")
    public BigDecimal getGmoMaintenanceLineTotalPriceTTC() {
        return gmoMaintenanceLineTotalPriceTTC;
    }

    public void setGmoMaintenanceLineTotalPriceTTC(BigDecimal gmoMaintenanceLineTotalPriceTTC) {
        this.gmoMaintenanceLineTotalPriceTTC = gmoMaintenanceLineTotalPriceTTC;
    }

    @ManyToOne()
    @JoinColumn(name = "gmo_maintenancelinemaintenanceplanid")
    public GmoMaintenancePlan getGmoMaintenanceLineMaintenancePlan() {
        return gmoMaintenanceLineMaintenancePlan;
    }

    public void setGmoMaintenanceLineMaintenancePlan(GmoMaintenancePlan gmoMaintenanceLineMaintenancePlan) {
        this.gmoMaintenanceLineMaintenancePlan = gmoMaintenanceLineMaintenancePlan;
    }
}
