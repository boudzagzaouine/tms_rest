package com.bagile.tms.entities;

import javax.persistence.*;
import java.math.BigDecimal;
@Entity
@Table(name="tms_maintenanceline")
public class TmsMaintenanceLine extends EmsEntity {
    private long tmsMaintenanceLineId;
    private PdtProduct tmsMaintenanceLineProduct;
    private String tmsMaintenanceLineDescription;
    private BigDecimal tmsMaintenanceLineQuantity;
    private BigDecimal tmsMaintenanceLineUnitPrice;
    private BigDecimal tmsMaintenanceLineTotalPriceHT;
    private BigDecimal tmsMaintenanceLineTotalPriceTTC;
    private TmsMaintenancePlan tmsMaintenanceLineMaintenancePlan;
 private  BigDecimal tmsAmountVat;
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE ,generator = "seq")
    @SequenceGenerator (name = "seq", sequenceName = "seq_tms_maintenance_line_id", allocationSize = 1)
    @Column(name = "tms_maintenancelineid")
    public long getTmsMaintenanceLineId() {
        return tmsMaintenanceLineId;
    }

    public void setTmsMaintenanceLineId(long tmsMaintenanceLineId) {
        this.tmsMaintenanceLineId = tmsMaintenanceLineId;
    }

    @ManyToOne
    @JoinColumn(name = "tms_maintenancelineproductid")
    public PdtProduct getTmsMaintenanceLineProduct() {
        return tmsMaintenanceLineProduct;
    }

    public void setTmsMaintenanceLineProduct(PdtProduct tmsMaintenanceLineProduct) {
        this.tmsMaintenanceLineProduct = tmsMaintenanceLineProduct;
    }
    @Column(name = "tms_maintenancelinedescription")
    public String getTmsMaintenanceLineDescription() {
        return tmsMaintenanceLineDescription;
    }

    public void setTmsMaintenanceLineDescription(String tmsMaintenanceLineDescription) {
        this.tmsMaintenanceLineDescription = tmsMaintenanceLineDescription;
    }

    @Column(name = "tms_maintenancelineamountvat")
    public BigDecimal getTmsAmountVat() {
        return tmsAmountVat;
    }

    public void setTmsAmountVat(BigDecimal tmsAmountVat) {
        this.tmsAmountVat = tmsAmountVat;
    }

    @Column(name = "tms_maintenancelinequantity")
    public BigDecimal getTmsMaintenanceLineQuantity() {
        return tmsMaintenanceLineQuantity;
    }

    public void setTmsMaintenanceLineQuantity(BigDecimal tmsMaintenanceLineQuantity) {
        this.tmsMaintenanceLineQuantity = tmsMaintenanceLineQuantity;
    }
    @Column(name = "tms_maintenancelineunitprice")
    public BigDecimal getTmsMaintenanceLineUnitPrice() {
        return tmsMaintenanceLineUnitPrice;
    }

    public void setTmsMaintenanceLineUnitPrice(BigDecimal tmsMaintenanceLineUnitPrice) {
        this.tmsMaintenanceLineUnitPrice = tmsMaintenanceLineUnitPrice;
    }

    @Column(name = "tms_maintenancelinetotalpriceht")
    public BigDecimal getTmsMaintenanceLineTotalPriceHT() {
        return tmsMaintenanceLineTotalPriceHT;
    }

    public void setTmsMaintenanceLineTotalPriceHT(BigDecimal tmsMaintenanceLineTotalPriceHT) {
        this.tmsMaintenanceLineTotalPriceHT = tmsMaintenanceLineTotalPriceHT;
    }
@Column(name = "tms_maintenancelinetotalpricettc")
    public BigDecimal getTmsMaintenanceLineTotalPriceTTC() {
        return tmsMaintenanceLineTotalPriceTTC;
    }

    public void setTmsMaintenanceLineTotalPriceTTC(BigDecimal tmsMaintenanceLineTotalPriceTTC) {
        this.tmsMaintenanceLineTotalPriceTTC = tmsMaintenanceLineTotalPriceTTC;
    }

    @ManyToOne()
    @JoinColumn(name = "tms_maintenancelinemaintenanceplanid")
    public TmsMaintenancePlan getTmsMaintenanceLineMaintenancePlan() {
        return tmsMaintenanceLineMaintenancePlan;
    }

    public void setTmsMaintenanceLineMaintenancePlan(TmsMaintenancePlan tmsMaintenanceLineMaintenancePlan) {
        this.tmsMaintenanceLineMaintenancePlan = tmsMaintenanceLineMaintenancePlan;
    }
}
