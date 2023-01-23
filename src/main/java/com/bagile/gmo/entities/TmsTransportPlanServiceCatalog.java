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
    private BigDecimal tmsTransporPlanServiceCatalogPriceHT;
    private PrmVat prmVat;
    private BigDecimal tmsTransporPlanServiceCatalogPriceTTC;
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

    @Column(name = "tms_transporplanservicecatalogpriceht")
    public BigDecimal getTmsTransporPlanServiceCatalogPriceHT() {
        return tmsTransporPlanServiceCatalogPriceHT;
    }

    public void setTmsTransporPlanServiceCatalogPriceHT(BigDecimal tmsTransporPlanServiceCatalogPriceHT) {
        this.tmsTransporPlanServiceCatalogPriceHT = tmsTransporPlanServiceCatalogPriceHT;
    }
    @ManyToOne()
    @JoinColumn(name = "tms_prmvatid")
    public PrmVat getPrmVat() {
        return prmVat;
    }

    public void setPrmVat(PrmVat prmVat) {
        this.prmVat = prmVat;
    }

    @ManyToOne()
    @JoinColumn(name = "tms_transportplanid")
    public TmsTransportPlan getTmsTransportPlan() {
        return tmsTransportPlan;
    }

    public void setTmsTransportPlan(TmsTransportPlan tmsTransportPlan) {
        this.tmsTransportPlan = tmsTransportPlan;
    }

    @Column(name = "tms_transporplanservicecatalogpricettc")
    public BigDecimal getTmsTransporPlanServiceCatalogPriceTTC() {
        return tmsTransporPlanServiceCatalogPriceTTC;
    }

    public void setTmsTransporPlanServiceCatalogPriceTTC(BigDecimal tmsTransporPlanServiceCatalogPriceTTC) {
        this.tmsTransporPlanServiceCatalogPriceTTC = tmsTransporPlanServiceCatalogPriceTTC;
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
