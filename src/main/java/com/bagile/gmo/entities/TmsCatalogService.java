package com.bagile.gmo.entities;


import javax.persistence.*;
import java.math.BigDecimal;

@Entity
@Table(name="tms_catalogservice",
        uniqueConstraints ={@UniqueConstraint
                (columnNames ={"pdt_productid"})})
public class TmsCatalogService extends EmsEntity {

    private Long tmsCatalogServiceId;
    private PdtProduct pdtProduct;
    private BigDecimal tmsCatalogServicePurchaseAmountHt;
    private BigDecimal tmsCatalogServicePurchaseAmountTtc;
    private BigDecimal tmsCatalogServicePurchaseAmountTva;
    private PrmVat prmPurchaseVat;



    private BigDecimal tmsCatalogServiceSaleAmountHt;
    private BigDecimal tmsCatalogServiceSaleAmountTtc;
    private BigDecimal tmsCatalogServiceSaleAmountTva;
    private PrmVat prmSaleVat;

    private OwnOwner ownOwner;


    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq")
    @SequenceGenerator(name = "seq", sequenceName = "seq_tms_catalogservice_id", allocationSize = 1)
    @Column(name = "tms_catalogserviceid", unique = true, nullable = false, precision = 10, scale = 0)
    public Long getTmsCatalogServiceId() {
        return tmsCatalogServiceId;
    }

    public void setTmsCatalogServiceId(Long tmsCatalogServiceId) {
        this.tmsCatalogServiceId = tmsCatalogServiceId;
    }

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "pdt_productid")
    public PdtProduct getPdtProduct() {
        return pdtProduct;
    }

    public void setPdtProduct(PdtProduct pdtProduct) {
        this.pdtProduct = pdtProduct;
    }




    @Column(name = "tms_catalogservicepurchaseamountht")
    public BigDecimal getTmsCatalogServicePurchaseAmountHt() {
        return tmsCatalogServicePurchaseAmountHt;
    }

    public void setTmsCatalogServicePurchaseAmountHt(BigDecimal tmsCatalogServicePurchaseAmountHt) {
        this.tmsCatalogServicePurchaseAmountHt = tmsCatalogServicePurchaseAmountHt;
    }


    @Column(name = "tms_catalogservicepurchaseamountttc")
    public BigDecimal getTmsCatalogServicePurchaseAmountTtc() {
        return tmsCatalogServicePurchaseAmountTtc;
    }

    public void setTmsCatalogServicePurchaseAmountTtc(BigDecimal tmsCatalogServicePurchaseAmountTtc) {
        this.tmsCatalogServicePurchaseAmountTtc = tmsCatalogServicePurchaseAmountTtc;
    }

    @Column(name = "tms_catalogservicepurchaseamountvat")
    public BigDecimal getTmsCatalogServicePurchaseAmountTva() {
        return tmsCatalogServicePurchaseAmountTva;
    }

    public void setTmsCatalogServicePurchaseAmountTva(BigDecimal tmsCatalogServicePurchaseAmountTva) {
        this.tmsCatalogServicePurchaseAmountTva = tmsCatalogServicePurchaseAmountTva;
    }

    @ManyToOne()
    @JoinColumn(name="tms_purchasevatid")
    public PrmVat getPrmPurchaseVat() {
        return prmPurchaseVat;
    }

    public void setPrmPurchaseVat(PrmVat prmPurchaseVat) {
        this.prmPurchaseVat = prmPurchaseVat;
    }


    @Column(name = "tms_catalogservicesaleamountht")
    public BigDecimal getTmsCatalogServiceSaleAmountHt() {
        return tmsCatalogServiceSaleAmountHt;
    }

    public void setTmsCatalogServiceSaleAmountHt(BigDecimal tmsCatalogServiceSaleAmountHt) {
        this.tmsCatalogServiceSaleAmountHt = tmsCatalogServiceSaleAmountHt;
    }

    @Column(name = "tms_catalogservicesaleamountttc")
    public BigDecimal getTmsCatalogServiceSaleAmountTtc() {
        return tmsCatalogServiceSaleAmountTtc;
    }

    public void setTmsCatalogServiceSaleAmountTtc(BigDecimal tmsCatalogServiceSaleAmountTtc) {
        this.tmsCatalogServiceSaleAmountTtc = tmsCatalogServiceSaleAmountTtc;
    }

    @Column(name = "tms_catalogservicesaleamounttva")
    public BigDecimal getTmsCatalogServiceSaleAmountTva() {
        return tmsCatalogServiceSaleAmountTva;
    }

    public void setTmsCatalogServiceSaleAmountTva(BigDecimal tmsCatalogServiceSaleAmountTva) {
        this.tmsCatalogServiceSaleAmountTva = tmsCatalogServiceSaleAmountTva;
    }




    @ManyToOne()
    @JoinColumn(name="tms_salevatid")
    public PrmVat getPrmSaleVat() {
        return prmSaleVat;
    }

    public void setPrmSaleVat(PrmVat prmSaleVat) {
        this.prmSaleVat = prmSaleVat;
    }

    @ManyToOne()
   @JoinColumn(name="tms_ownownerid")
    public OwnOwner getOwnOwner() {
        return ownOwner;
    }

    public void setOwnOwner(OwnOwner ownOwner) {
        this.ownOwner = ownOwner;
    }





}

