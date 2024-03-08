package com.bagile.gmo.entities;

import javax.persistence.*;
import java.math.BigDecimal;


@Entity
@Table(name = "tms_transportplanproductservice")
public class TmsTransportPlanProductService extends EmsEntity {

	private static final long serialVersionUID = 2773120607426017439L;

	private Long tmsTransportPlanProductServiceId;
    private PdtProduct pdtProduct;
    private TrpTransport TrpTransport;
    private BigDecimal tmsTransportPlanProductServicePriceHT;
    private PrmVat prmVat;
    private BigDecimal tmsTransportPlanProductServicePriceTTC;

    private TmsTransportPlan tmsTransportPlan;
    private OwnOwner ownOwner;




    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq")
    @SequenceGenerator(name = "seq", sequenceName = "seq_tms_transportplan_productservice_id", allocationSize = 1)
    @Column(name = "tms_transportplanproductserviceid", unique = true, nullable = false, precision = 10, scale = 0)
    public Long getTmsTransportPlanProductServiceId() {
        return tmsTransportPlanProductServiceId;
    }

    public void setTmsTransportPlanProductServiceId(Long tmsTransportPlanProductServiceId) {
        this.tmsTransportPlanProductServiceId = tmsTransportPlanProductServiceId;
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

    @Column(name = "tms_transportplanproductservicepriceht")
    public BigDecimal getTmsTransportPlanProductServicePriceHT() {
        return tmsTransportPlanProductServicePriceHT;
    }

    public void setTmsTransportPlanProductServicePriceHT(BigDecimal tmsTransportPlanProductServicePriceHT) {
        this.tmsTransportPlanProductServicePriceHT = tmsTransportPlanProductServicePriceHT;
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

    @Column(name = "tms_transportplanproductservicepricettc")
    public BigDecimal getTmsTransportPlanProductServicePriceTTC() {
        return tmsTransportPlanProductServicePriceTTC;
    }

    public void setTmsTransportPlanProductServicePriceTTC(BigDecimal tmsTransportPlanProductServicePriceTTC) {
        this.tmsTransportPlanProductServicePriceTTC = tmsTransportPlanProductServicePriceTTC;
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
