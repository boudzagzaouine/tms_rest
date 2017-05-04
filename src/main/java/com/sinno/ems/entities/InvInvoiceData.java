package com.sinno.ems.entities;

import javax.persistence.*;
import javax.validation.constraints.Max;
import java.math.BigDecimal;
import java.util.Date;

/**
 * Created by Enissay on 31/10/2016.
 */
@Entity
@Table(name = "inv_invoicedata")
public class InvInvoiceData {
    private long invInvoiceDataId;
    private OwnOwner ownOwner;
    private InvMovementType invMovementType;
    @Max(999999999)
    private BigDecimal invInvoiceDataPrice;
    @Max(999999999)
    private BigDecimal invInvoiceDataTotalPrice;
    @Max(999999999)
    private BigDecimal invInvoiceDataQuantity;

    private Date invInvoiceDataInvoiceDate;
    private Date invInvoiceDataUpdateDate;
    private Date invInvoiceDataCreationDate;


    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq")
    @SequenceGenerator(name = "seq", sequenceName = "seq_inv_invoicedata", allocationSize = 1)
    @Column(name = "inv_invoicedataid", unique = true, nullable = false, precision = 10, scale = 0)

    public long getInvInvoiceDataId() {
        return invInvoiceDataId;
    }

    public void setInvInvoiceDataId(long invInvoiceDataId) {
        this.invInvoiceDataId = invInvoiceDataId;
    }

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "inv_invoicedataownerid")
    public OwnOwner getOwnOwner() {
        return ownOwner;
    }

    public void setOwnOwner(OwnOwner ownOwner) {
        this.ownOwner = ownOwner;
    }

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "inv_invoicedatamovementtypeid")
    public InvMovementType getInvMovementType() {
        return invMovementType;
    }

    public void setInvMovementType(InvMovementType invMovementType) {
        this.invMovementType = invMovementType;
    }

    @Column(name = "inv_invoicedataprice")
    public BigDecimal getInvInvoiceDataPrice() {
        return invInvoiceDataPrice;
    }

    public void setInvInvoiceDataPrice(BigDecimal invInvoiceDataPrice) {
        this.invInvoiceDataPrice = invInvoiceDataPrice;
    }

    @Column(name = "inv_invoicedatatotalprice")

    public BigDecimal getInvInvoiceDataTotalPrice() {
        return invInvoiceDataTotalPrice;
    }

    public void setInvInvoiceDataTotalPrice(BigDecimal invInvoiceDataTotalPrice) {
        this.invInvoiceDataTotalPrice = invInvoiceDataTotalPrice;
    }

    @Column(name = "inv_invoicedataquantity")

    public BigDecimal getInvInvoiceDataQuantity() {
        return invInvoiceDataQuantity;
    }

    public void setInvInvoiceDataQuantity(BigDecimal invInvoiceDataQuantity) {
        this.invInvoiceDataQuantity = invInvoiceDataQuantity;
    }



    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "inv_invoicedatainvoicedate")
    public Date getInvInvoiceDataInvoiceDate() {
        return invInvoiceDataInvoiceDate;
    }

    public void setInvInvoiceDataInvoiceDate(Date invInvoiceDataInvoiceDate) {
        this.invInvoiceDataInvoiceDate = invInvoiceDataInvoiceDate;
    }

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "inv_invoicedataupdatedate")
    public Date getInvInvoiceDataUpdateDate() {
        return invInvoiceDataUpdateDate;
    }

    public void setInvInvoiceDataUpdateDate(Date invInvoiceDataUpdateDate) {
        this.invInvoiceDataUpdateDate = invInvoiceDataUpdateDate;
    }
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "inv_invoicedatacreationdate")
    public Date getInvInvoiceDataCreationDate() {
        return invInvoiceDataCreationDate;
    }

    public void setInvInvoiceDataCreationDate(Date invInvoiceDataCreationDate) {
        this.invInvoiceDataCreationDate = invInvoiceDataCreationDate;
    }
}
