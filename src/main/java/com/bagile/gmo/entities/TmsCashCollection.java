package com.bagile.gmo.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import java.math.BigDecimal;
import java.util.Date;

/**
 * An amount of cash a driver actually collected at a stop ("retour de fonds").
 *
 * <p>Kept as an append-only record rather than a column on the info-line: the expected amount and
 * the collected amount are different facts, a driver may collect a different sum than planned, and
 * money handled by a person needs an audit trail (who, when, how much, which leg). Created
 * automatically by ddl-auto=update.</p>
 */
@Entity
@Table(name = "tms_cash_collection")
public class TmsCashCollection {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "transport_plan_id")
    private Long transportPlanId;

    @Column(name = "order_transport_id")
    private Long orderTransportId;

    /** Which leg the money was collected on: 1 = enlevement (pickup), 2 = livraison (delivery). */
    @Column(name = "leg")
    private Integer leg;

    /** What the order said should be collected, captured at collection time for later comparison. */
    @Column(name = "expected_amount")
    private BigDecimal expectedAmount;

    /** What the driver reports actually collecting. */
    @Column(name = "collected_amount")
    private BigDecimal collectedAmount;

    /** Payment method code as shown to the driver (CHEQUE, ESPECE, ...). */
    @Column(name = "payment_type_code")
    private String paymentTypeCode;

    @Column(name = "driver_id")
    private Long driverId;

    @Column(name = "collected_at")
    private Date collectedAt;

    /** Free-text explanation, required by the app when collected != expected. */
    @Column(name = "note", length = 500)
    private String note;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getTransportPlanId() {
        return transportPlanId;
    }

    public void setTransportPlanId(Long transportPlanId) {
        this.transportPlanId = transportPlanId;
    }

    public Long getOrderTransportId() {
        return orderTransportId;
    }

    public void setOrderTransportId(Long orderTransportId) {
        this.orderTransportId = orderTransportId;
    }

    public Integer getLeg() {
        return leg;
    }

    public void setLeg(Integer leg) {
        this.leg = leg;
    }

    public BigDecimal getExpectedAmount() {
        return expectedAmount;
    }

    public void setExpectedAmount(BigDecimal expectedAmount) {
        this.expectedAmount = expectedAmount;
    }

    public BigDecimal getCollectedAmount() {
        return collectedAmount;
    }

    public void setCollectedAmount(BigDecimal collectedAmount) {
        this.collectedAmount = collectedAmount;
    }

    public String getPaymentTypeCode() {
        return paymentTypeCode;
    }

    public void setPaymentTypeCode(String paymentTypeCode) {
        this.paymentTypeCode = paymentTypeCode;
    }

    public Long getDriverId() {
        return driverId;
    }

    public void setDriverId(Long driverId) {
        this.driverId = driverId;
    }

    public Date getCollectedAt() {
        return collectedAt;
    }

    public void setCollectedAt(Date collectedAt) {
        this.collectedAt = collectedAt;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }
}
