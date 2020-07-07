package com.bagile.gmo.entities;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
@Table(name="gmo_actionline")
public class GmoActionLine extends EmsEntity {

	private static final long serialVersionUID = -6143066188263513604L;
	private long gmoActionLineId;
    private PdtProduct pdtProduct;
    private GmoAction gmoAction;
    private String gmoActionLineDescription;
    private BigDecimal gmoActionLineTotalPriceHT;
    private BigDecimal gmoActionLineTotalPriceTTC;
    private  BigDecimal gmoAmountVat;
    private BigDecimal gmoActionLineQuantity;

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




    @Column(name = "gmo_actionlinedescription")
    public String getGmoActionLineDescription() {
        return gmoActionLineDescription;
    }

    public void setGmoActionLineDescription(String gmoActionLineDescription) {
        this.gmoActionLineDescription = gmoActionLineDescription;
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

}
