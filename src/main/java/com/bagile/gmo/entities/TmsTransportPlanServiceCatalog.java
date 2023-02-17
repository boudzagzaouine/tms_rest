package com.bagile.gmo.entities;

import javax.persistence.*;
import java.math.BigDecimal;


@Entity
@Table(name = "tms_transporplanservicecatalog")
public class TmsTransportPlanServiceCatalog extends EmsEntity {

	private static final long serialVersionUID = 2773120607426017439L;

	private Long tmsTransporPlanServiceCatalogId;
    private PdtProduct pdtProduct;
    private TrpTransport TrpTransport;
    private AdrAddress adrAddress;
    private Boolean tmsTransporPlanServiceCatalogPInvoice ;
    private BigDecimal tmsTransporPlanServiceCatalogPurchasePriceHT;
    private PrmVat prmPurchaseVat;
    private BigDecimal tmsTransporPlanServiceCatalogPurchasePriceTTC;

    private BigDecimal tmsTransporPlanServiceCatalogSalePriceHT;
    private PrmVat prmSaleVat;
    private BigDecimal tmsTransporPlanServiceCatalogSalePriceTTC;
    private BigDecimal tmsTransporPlanServiceCatalogSalePriceVat;

    private OwnOwner ownOwner;
    private TmsTransportPlan tmsTransportPlan;

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq")
    @SequenceGenerator(name = "seq", sequenceName = "seq_tms_transporplanservicecatalog_id", allocationSize = 1)
    @Column(name = "tms_transporplanservicecatalogid", unique = true, nullable = false, precision = 10, scale = 0)
    public Long getTmsTransporPlanServiceCatalogId() {
        return tmsTransporPlanServiceCatalogId;
    }

    public void setTmsTransporPlanServiceCatalogId(Long tmsTransporPlanServiceCatalogId) {
        this.tmsTransporPlanServiceCatalogId = tmsTransporPlanServiceCatalogId;
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
    @ManyToOne()
    @JoinColumn(name = "tms_adraddressid")
    public AdrAddress getAdrAddress() {
        return adrAddress;
    }

    public void setAdrAddress(AdrAddress adrAddress) {
        this.adrAddress = adrAddress;
    }

    @Column(name = "tms_transporplanservicecataloginvoice")
    public Boolean getTmsTransporPlanServiceCatalogPInvoice() {
        return tmsTransporPlanServiceCatalogPInvoice;
    }

    public void setTmsTransporPlanServiceCatalogPInvoice(Boolean tmsTransporPlanServiceCatalogPInvoice) {
        this.tmsTransporPlanServiceCatalogPInvoice = tmsTransporPlanServiceCatalogPInvoice;
    }

    @Column(name = "tms_transporplanservicecatalogpurcahsepriceht")
    public BigDecimal getTmsTransporPlanServiceCatalogPurchasePriceHT() {
        return tmsTransporPlanServiceCatalogPurchasePriceHT;
    }

    public void setTmsTransporPlanServiceCatalogPurchasePriceHT(BigDecimal tmsTransporPlanServiceCatalogPurchasePriceHT) {
        this.tmsTransporPlanServiceCatalogPurchasePriceHT = tmsTransporPlanServiceCatalogPurchasePriceHT;
    }

    @Column(name = "tms_transporplanservicecatalogpurcahsepricevat")

    public BigDecimal getTmsTransporPlanServiceCatalogSalePriceVat() {
        return tmsTransporPlanServiceCatalogSalePriceVat;
    }

    public void setTmsTransporPlanServiceCatalogSalePriceVat(BigDecimal tmsTransporPlanServiceCatalogSalePriceVat) {
        this.tmsTransporPlanServiceCatalogSalePriceVat = tmsTransporPlanServiceCatalogSalePriceVat;
    }

    @ManyToOne()
    @JoinColumn(name = "tms_prmpurchasevatid")
    public PrmVat getPrmPurchaseVat() {
        return prmPurchaseVat;
    }

    public void setPrmPurchaseVat(PrmVat prmPurchaseVat) {
        this.prmPurchaseVat = prmPurchaseVat;
    }

    @Column(name = "tms_transporplanservicecatalogpurchasepricettc")
    public BigDecimal getTmsTransporPlanServiceCatalogPurchasePriceTTC() {
        return tmsTransporPlanServiceCatalogPurchasePriceTTC;
    }

    public void setTmsTransporPlanServiceCatalogPurchasePriceTTC(BigDecimal tmsTransporPlanServiceCatalogPurchasePriceTTC) {
        this.tmsTransporPlanServiceCatalogPurchasePriceTTC = tmsTransporPlanServiceCatalogPurchasePriceTTC;
    }

    @Column(name = "tms_transporplanservicecatalogsalepriceht")

    public BigDecimal getTmsTransporPlanServiceCatalogSalePriceHT() {
        return tmsTransporPlanServiceCatalogSalePriceHT;
    }

    public void setTmsTransporPlanServiceCatalogSalePriceHT(BigDecimal tmsTransporPlanServiceCatalogSalePriceHT) {
        this.tmsTransporPlanServiceCatalogSalePriceHT = tmsTransporPlanServiceCatalogSalePriceHT;
    }

    @ManyToOne()
    @JoinColumn(name = "tms_prmsalevatid")
    public PrmVat getPrmSaleVat() {
        return prmSaleVat;
    }

    public void setPrmSaleVat(PrmVat prmSaleVat) {
        this.prmSaleVat = prmSaleVat;
    }
    @Column(name = "tms_transporplanservicecatalogsalepricettc")

    public BigDecimal getTmsTransporPlanServiceCatalogSalePriceTTC() {
        return tmsTransporPlanServiceCatalogSalePriceTTC;
    }

    public void setTmsTransporPlanServiceCatalogSalePriceTTC(BigDecimal tmsTransporPlanServiceCatalogSalePriceTTC) {
        this.tmsTransporPlanServiceCatalogSalePriceTTC = tmsTransporPlanServiceCatalogSalePriceTTC;
    }

    @ManyToOne()
    @JoinColumn(name = "tms_transportplanid")
    public TmsTransportPlan getTmsTransportPlan() {
        return tmsTransportPlan;
    }

    public void setTmsTransportPlan(TmsTransportPlan tmsTransportPlan) {
        this.tmsTransportPlan = tmsTransportPlan;
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
