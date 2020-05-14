package com.bagile.gmo.entities;

import java.math.BigDecimal;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="gmo_maintenanceline")
public class GmoMaintenanceLine extends EmsEntity {

	private static final long serialVersionUID = -6143066188263513604L;
	
	private long gmoMaintenanceLineId;
    private GmoMaintenanceLineRef gmoMaintenanceLineRef;

    private Set<GmoMaintenanceProduct> gmoMaintenanceLineProducts = new HashSet<>();
    private String gmoMaintenanceLineDescription;
    private BigDecimal gmoMaintenanceLineTotalPriceHT;
    private BigDecimal gmoMaintenanceLineTotalPriceTTC;
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
    @JoinColumn(name = "gmo_maintenancelinerefid")
    public GmoMaintenanceLineRef getGmoMaintenanceLineRef() {
        return gmoMaintenanceLineRef;
    }

    public void setGmoMaintenanceLineRef(GmoMaintenanceLineRef gmoMaintenanceLineRef) {
        this.gmoMaintenanceLineRef = gmoMaintenanceLineRef;
    }

    @OneToMany
    public Set<GmoMaintenanceProduct> getGmoMaintenanceLineProducts() {
        return gmoMaintenanceLineProducts;
    }

    public void setGmoMaintenanceLineProducts(Set<GmoMaintenanceProduct> gmoMaintenanceLineProducts) {
        this.gmoMaintenanceLineProducts = gmoMaintenanceLineProducts;
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
}
