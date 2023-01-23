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

  
    private BigDecimal tmsTransportServiceSaleAmountHt;
    private BigDecimal tmsTransportServiceSaleAmountTtc;
    private BigDecimal tmsTransportServiceSaleAmountTva;
    private PrmVat prmSaleVat;





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
    
    
    
    @Column(name="tms_transportservicesaleamountht")
    public BigDecimal getTmsTransportServiceSaleAmountHt() {
        return tmsTransportServiceSaleAmountHt;
    }

    public void setTmsTransportServiceSaleAmountHt(BigDecimal tmsTransportServiceSaleAmountHt) {
        this.tmsTransportServiceSaleAmountHt = tmsTransportServiceSaleAmountHt;
    }
    @Column(name="tms_transportservicesaleamountttc")
    public BigDecimal getTmsTransportServiceSaleAmountTtc() {
        return tmsTransportServiceSaleAmountTtc;
    }

    public void setTmsTransportServiceSaleAmountTtc(BigDecimal tmsTransportServiceSaleAmountTtc) {
        this.tmsTransportServiceSaleAmountTtc = tmsTransportServiceSaleAmountTtc;
    }
    @Column(name="tms_transportservicesaleamounttva")
    public BigDecimal getTmsTransportServiceSaleAmountTva() {
        return tmsTransportServiceSaleAmountTva;
    }

    public void setTmsTransportServiceSaleAmountTva(BigDecimal tmsTransportServiceSaleAmountTva) {
        this.tmsTransportServiceSaleAmountTva = tmsTransportServiceSaleAmountTva;
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
