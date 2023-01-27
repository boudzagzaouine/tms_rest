package com.bagile.gmo.entities;

import javax.persistence.*;
import java.math.BigDecimal;


@Entity
@Table(name = "tms_transportaccount_service",
        uniqueConstraints ={@UniqueConstraint
                (columnNames ={"tms_trptranportid","tms_cmdcompanyid","tms_adraddressid","tms_productserviceid"})})

public class TmsTransportAccountService extends EmsEntity {

	private static final long serialVersionUID = 2773120607426017439L;

	private Long tmsTransportAccountServiceId;
    private TrpTransport trpTransport;
    private CmdCompany cmdCompany;
    private AdrAddress adrAddress;
  private PdtProduct pdtProduct;
  
    private BigDecimal tmsTransportAccountServicePurchaseAmountHt;
    private BigDecimal tmsTransportAccountServicePurchaseAmountTtc;
    private BigDecimal tmsTransportAccountServicePurchaseAmountTva;
    private PrmVat prmPurchaseVat;





    private OwnOwner ownOwner;

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq")
    @SequenceGenerator(name = "seq", sequenceName = "seq_tms_transport_service_id", allocationSize = 1)
    @Column(name = "tms_transportserviceid", unique = true, nullable = false, precision = 10, scale = 0)
    public Long getTmsTransportAccountServiceId() {
        return tmsTransportAccountServiceId;
    }

    public void setTmsTransportAccountServiceId(Long tmsTransportAccountServiceId) {
        this.tmsTransportAccountServiceId = tmsTransportAccountServiceId;
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
    @JoinColumn(name="tms_adraddressid")
    public AdrAddress getAdrAddress() {
        return adrAddress;
    }

    public void setAdrAddress(AdrAddress adrAddress) {
        this.adrAddress = adrAddress;
    }

    @ManyToOne()
    @JoinColumn(name="tms_cmdcompanyid")
    public CmdCompany getCmdCompany() {
        return cmdCompany;
    }

    public void setCmdCompany(CmdCompany cmdCompany) {
        this.cmdCompany = cmdCompany;
    }

    @ManyToOne()
    @JoinColumn(name="tms_productserviceid")
    public PdtProduct getPdtProduct() {
        return pdtProduct;
    }

    public void setPdtProduct(PdtProduct pdtProduct) {
        this.pdtProduct = pdtProduct;
    }
    
    
    
    @Column(name="tms_transportservicepurcahseamountht")
    public BigDecimal getTmsTransportAccountServicePurchaseAmountHt() {
        return tmsTransportAccountServicePurchaseAmountHt;
    }

    public void setTmsTransportAccountServicePurchaseAmountHt(BigDecimal tmsTransportAccountServiceSaleAmountHt) {
        this.tmsTransportAccountServicePurchaseAmountHt = tmsTransportAccountServiceSaleAmountHt;
    }
    @Column(name="tms_transportservicepurcahseamountttc")
    public BigDecimal getTmsTransportAccountServicePurchaseAmountTtc() {
        return tmsTransportAccountServicePurchaseAmountTtc;
    }

    public void setTmsTransportAccountServicePurchaseAmountTtc(BigDecimal tmsTransportAccountServiceSaleAmountTtc) {
        this.tmsTransportAccountServicePurchaseAmountTtc = tmsTransportAccountServiceSaleAmountTtc;
    }
    @Column(name="tms_transportservicepurchaseamounttva")
    public BigDecimal getTmsTransportAccountServicePurchaseAmountTva() {
        return tmsTransportAccountServicePurchaseAmountTva;
    }

    public void setTmsTransportAccountServicePurchaseAmountTva(BigDecimal tmsTransportAccountServiceSaleAmountTva) {
        this.tmsTransportAccountServicePurchaseAmountTva = tmsTransportAccountServiceSaleAmountTva;
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
