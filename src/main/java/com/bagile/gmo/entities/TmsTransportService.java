package com.bagile.gmo.entities;

import javax.persistence.*;
import java.math.BigDecimal;


@Entity
@Table(name = "tms_transport_service",
        uniqueConstraints ={@UniqueConstraint
                (columnNames ={"tms_trptranportid","tms_productserviceid"})})

public class TmsTransportService extends EmsEntity {

	private static final long serialVersionUID = 2773120607426017439L;

	private Long tmsTransportServiceId;
    private TrpTransport trpTransport;
  private PdtProduct pdtProduct;

  
    private BigDecimal tmsTransportServicePurchaseAmountHt;
    private BigDecimal tmsTransportServicePurchaseAmountTtc;
    private BigDecimal tmsTransportServicePurchaseAmountTva;
    private PrmVat prmPurchaseVat;





    private OwnOwner ownOwner;

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq")
    @SequenceGenerator(name = "seq", sequenceName = "seq_tms_transport_service_id", allocationSize = 1)
    @Column(name = "tms_transportserviceid", unique = true, nullable = false, precision = 10, scale = 0)
    public Long getTmsTransportServiceId() {
        return tmsTransportServiceId;
    }

    public void setTmsTransportServiceId(Long tmsTransportServiceId) {
        this.tmsTransportServiceId = tmsTransportServiceId;
    }

    

    @ManyToOne()
    @JoinColumn(name="tms_trptranportid")
    public TrpTransport getTrpTransport() {
        return trpTransport;
    }

    public void setTrpTransport(TrpTransport trpTransport) {
        this.trpTransport = trpTransport;
    }


    

    @ManyToOne()
    @JoinColumn(name="tms_productserviceid")
    public PdtProduct getPdtProduct() {
        return pdtProduct;
    }

    public void setPdtProduct(PdtProduct pdtProduct) {
        this.pdtProduct = pdtProduct;
    }
    
    
    
    @Column(name="tms_transportservicepurchaseamountht")
    public BigDecimal getTmsTransportServicePurchaseAmountHt() {
        return tmsTransportServicePurchaseAmountHt;
    }

    public void setTmsTransportServicePurchaseAmountHt(BigDecimal tmsTransportServiceSaleAmountHt) {
        this.tmsTransportServicePurchaseAmountHt = tmsTransportServiceSaleAmountHt;
    }
    @Column(name="tms_transportservicepurchaseamountttc")
    public BigDecimal getTmsTransportServicePurchaseAmountTtc() {
        return tmsTransportServicePurchaseAmountTtc;
    }

    public void setTmsTransportServicePurchaseAmountTtc(BigDecimal tmsTransportServiceSaleAmountTtc) {
        this.tmsTransportServicePurchaseAmountTtc = tmsTransportServiceSaleAmountTtc;
    }
    @Column(name="tms_transportservicepurchaseamounttva")
    public BigDecimal getTmsTransportServicePurchaseAmountTva() {
        return tmsTransportServicePurchaseAmountTva;
    }

    public void setTmsTransportServicePurchaseAmountTva(BigDecimal tmsTransportServiceSaleAmountTva) {
        this.tmsTransportServicePurchaseAmountTva = tmsTransportServiceSaleAmountTva;
    }

    @ManyToOne()
    @JoinColumn(name="tms_purchasevatid")
    public PrmVat getPrmPurchaseVat() {
        return prmPurchaseVat;
    }

    public void setPrmPurchaseVat(PrmVat prmSaleVat) {
        this.prmPurchaseVat = prmSaleVat;
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
