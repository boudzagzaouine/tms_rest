package com.bagile.gmo.entities;

import com.bagile.gmo.dto.MaintenancePlan;

import java.math.BigDecimal;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
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
    private PdtProduct pdtProduct;
    private GmoAction gmoAction;
    private GmoMaintenanceState gmoMaintenanceState;
    private String gmoMaintenanceLineDescription;
    private BigDecimal gmoMaintenanceLineTotalPriceHT;
    private BigDecimal gmoMaintenanceLineTotalPriceTTC;
    private  BigDecimal gmoAmountVat;
    private GmoMaintenancePlan gmoMaintenancePlan ;

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

    @ManyToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name = "pdt_productid")
    public PdtProduct getPdtProduct() {
        return pdtProduct;
    }

    public void setPdtProduct(PdtProduct pdtProduct) {
        this.pdtProduct = pdtProduct;
    }

    @ManyToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name = "gmo_actionid")
    public GmoAction getGmoAction() {
        return gmoAction;
    }

    public void setGmoAction(GmoAction gmoAction) {
        this.gmoAction = gmoAction;
    }


    @ManyToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name = "gmo_maintenanceplanid")
    public GmoMaintenancePlan getGmoMaintenancePlan() {
        return gmoMaintenancePlan;
    }

    public void setGmoMaintenancePlan(GmoMaintenancePlan gmoMaintenancePlan) {
        this.gmoMaintenancePlan = gmoMaintenancePlan;
    }




    @ManyToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name = "gmo_maintenancestateid")
    public GmoMaintenanceState getGmoMaintenanceState() {
        return gmoMaintenanceState;
    }

    public void setGmoMaintenanceState(GmoMaintenanceState gmoMaintenanceState) {
        this.gmoMaintenanceState = gmoMaintenanceState;
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
