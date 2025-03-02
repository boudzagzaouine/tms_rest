package com.bagile.gmo.entities;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.bagile.gmo.dto.EmsDto;

/**
 * PrmOrderStatus generated by hbm2java
 */
@Entity
@Table(name = "prm_orderstatus", uniqueConstraints = {@UniqueConstraint(columnNames = "prm_orderstatuscode")})
public class PrmOrderStatus extends EmsDto implements java.io.Serializable {

    private Long prmOrderStatusId;
    @Size(max = 30)
    @NotNull
    private String prmOrderStatusCode;
    @Size(max = 255)
    private String prmOrderStatusDescription;
    @NotNull
    private boolean prmOrderStatusOrderType;
    private Boolean prmOrderStatusArchivable;

    private Boolean prmOrderStatusDevis;
    private Boolean prmOrderStatusPurshaseOrder;
    private Boolean prmOrderStatusSaleOrder;
    private Boolean prmOrderStatusPreparation;
    private Boolean prmOrderStatusProduction;
    private Boolean prmOrderStatusDelivery;
    private Boolean prmOrderStatusReception;
    private Boolean prmOrderStatusActive;

    public PrmOrderStatus() {
    }

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq")
    @SequenceGenerator(name = "seq", sequenceName = "seq_prm_orderstatus", allocationSize = 1)
    @Column(name = "prm_orderstatusid", unique = true, nullable = false, precision = 10, scale = 0)
    public Long getPrmOrderStatusId() {
        return this.prmOrderStatusId;
    }

    public void setPrmOrderStatusId(Long prmOrderStatusId) {
        this.prmOrderStatusId = prmOrderStatusId;
    }

    @Column(name = "prm_orderstatuscode", unique = true, nullable = false, length = 30)
    public String getPrmOrderStatusCode() {
        return this.prmOrderStatusCode;
    }

    public void setPrmOrderStatusCode(String prmOrderStatusCode) {
        this.prmOrderStatusCode = prmOrderStatusCode;
    }

    @Column(name = "prm_orderstatusdescription")
    public String getPrmOrderStatusDescription() {
        return this.prmOrderStatusDescription;
    }

    public void setPrmOrderStatusDescription(String prmOrderStatusDescription) {
        this.prmOrderStatusDescription = prmOrderStatusDescription;
    }

    @Column(name = "prm_orderstatusordertype", nullable = false, precision = 1, scale = 0)
    public boolean isPrmOrderStatusOrderType() {
        return this.prmOrderStatusOrderType;
    }

    public void setPrmOrderStatusOrderType(boolean prmOrderStatusOrderType) {
        this.prmOrderStatusOrderType = prmOrderStatusOrderType;
    }
    @Column(name = "prm_orderstatusarchivable", precision = 1, scale = 0)
    public Boolean getPrmOrderStatusArchivable() {
        return prmOrderStatusArchivable;
    }

    public void setPrmOrderStatusArchivable(Boolean prmOrderStatusArchivable) {
        this.prmOrderStatusArchivable = prmOrderStatusArchivable;
    }


    @Column(name="prm_orderstatusdevis")
    public Boolean getPrmOrderStatusDevis() {
        return prmOrderStatusDevis;
    }

    public void setPrmOrderStatusDevis(Boolean prmOrderStatusDevis) {
        this.prmOrderStatusDevis = prmOrderStatusDevis;
    }
    @Column(name="prm_orderstatuspurshaseorder")

    public Boolean getPrmOrderStatusPurshaseOrder() {
        return prmOrderStatusPurshaseOrder;
    }

    public void setPrmOrderStatusPurshaseOrder(Boolean prmOrderStatusPurshaseOrder) {
        this.prmOrderStatusPurshaseOrder = prmOrderStatusPurshaseOrder;
    }
    @Column(name="prm_orderstatussaleorder")

    public Boolean getPrmOrderStatusSaleOrder() {
        return prmOrderStatusSaleOrder;
    }

    public void setPrmOrderStatusSaleOrder(Boolean prmOrderStatusSaleOrder) {
        this.prmOrderStatusSaleOrder = prmOrderStatusSaleOrder;
    }
    @Column(name="prm_orderstatuspreparation")

    public Boolean getPrmOrderStatusPreparation() {
        return prmOrderStatusPreparation;
    }

    public void setPrmOrderStatusPreparation(Boolean prmOrderStatusPreparation) {
        this.prmOrderStatusPreparation = prmOrderStatusPreparation;
    }
    @Column(name="prm_orderstatusproduction")

    public Boolean getPrmOrderStatusProduction() {
        return prmOrderStatusProduction;
    }

    public void setPrmOrderStatusProduction(Boolean prmOrderStatusProduction) {
        this.prmOrderStatusProduction = prmOrderStatusProduction;
    }
    @Column(name="prm_orderstatusdelivery")

    public Boolean getPrmOrderStatusDelivery() {
        return prmOrderStatusDelivery;
    }

    public void setPrmOrderStatusDelivery(Boolean prmOrderStatusDelivery) {
        this.prmOrderStatusDelivery = prmOrderStatusDelivery;
    }
    @Column(name="prm_orderstatusreception")
    public Boolean getPrmOrderStatusReception() {
        return prmOrderStatusReception;
    }

    public void setPrmOrderStatusReception(Boolean prmOrderStatusReception) {
        this.prmOrderStatusReception = prmOrderStatusReception;
    }
    @Column(name = "prm_orderstatusactive")
    public Boolean getPrmOrderStatusActive() {
        return prmOrderStatusActive;
    }

    public void setPrmOrderStatusActive(Boolean prmOrderStatusActive) {
        this.prmOrderStatusActive = prmOrderStatusActive;
    }
}
