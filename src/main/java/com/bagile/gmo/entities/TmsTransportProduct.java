package com.bagile.gmo.entities;

import javax.persistence.*;
import java.math.BigDecimal;


@Entity
@Table(name = "tms_transportproduct")
public class TmsTransportProduct extends EmsEntity {

	private static final long serialVersionUID = 2773120607426017439L;

	private Long tmsTransportProductId;
    private PdtProduct pdtProduct;
    private TrpTransport TrpTransport;
    private BigDecimal tmsTransportProductPriceHT;
    private PrmVat prmVat;
    private BigDecimal tmsTransportProductPriceTTC;
    private OwnOwner ownOwner;


    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq")
    @SequenceGenerator(name = "seq", sequenceName = "seq_tms_transport_product_id", allocationSize = 1)
    @Column(name = "tms_transportproductid", unique = true, nullable = false, precision = 10, scale = 0)
    public Long getTmsTransportProductId() {
        return tmsTransportProductId;
    }

    public void setTmsTransportProductId(Long tmsTransportProductId) {
        this.tmsTransportProductId = tmsTransportProductId;
    }

    @ManyToOne()
    @JoinColumn(name = "tms_pdtproductid")
    public PdtProduct getPdtProduct() {
        return pdtProduct;
    }

    public void setPdtProduct(PdtProduct pdtProduct) {
        this.pdtProduct = pdtProduct;
    }
    @ManyToOne()
    @JoinColumn(name = "tms_trptransportid")
    public TrpTransport getTrpTransport() {
        return TrpTransport;
    }

    public void setTrpTransport(TrpTransport trpTransport) {
        TrpTransport = trpTransport;
    }

    @Column(name = "tms_transportproductpriceht")
    public BigDecimal getTmsTransportProductPriceHT() {
        return tmsTransportProductPriceHT;
    }

    public void setTmsTransportProductPriceHT(BigDecimal tmsTransportProductPriceHT) {
        this.tmsTransportProductPriceHT = tmsTransportProductPriceHT;
    }
    @ManyToOne()
    @JoinColumn(name = "tms_prmvatid")
    public PrmVat getPrmVat() {
        return prmVat;
    }

    public void setPrmVat(PrmVat prmVat) {
        this.prmVat = prmVat;
    }

    @Column(name = "tms_transportproductpricettc")
    public BigDecimal getTmsTransportProductPriceTTC() {
        return tmsTransportProductPriceTTC;
    }

    public void setTmsTransportProductPriceTTC(BigDecimal tmsTransportProductPriceTTC) {
        this.tmsTransportProductPriceTTC = tmsTransportProductPriceTTC;
    }



    @ManyToOne()
    @JoinColumn(name="gmo_ownownerid")
    public OwnOwner getOwnOwner() {
        return ownOwner;
    }

    public void setOwnOwner(OwnOwner ownOwner) {
        this.ownOwner = ownOwner;
    }
}
