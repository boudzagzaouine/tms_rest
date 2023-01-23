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
  
    private BigDecimal tmsTransportAccountServiceSaleAmountHt;
    private BigDecimal tmsTransportAccountServiceSaleAmountTtc;
    private BigDecimal tmsTransportAccountServiceSaleAmountTva;
    private PrmVat prmSaleVat;





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
    
    
    
    @Column(name="tms_transportservicesaleamountht")
    public BigDecimal getTmsTransportAccountServiceSaleAmountHt() {
        return tmsTransportAccountServiceSaleAmountHt;
    }

    public void setTmsTransportAccountServiceSaleAmountHt(BigDecimal tmsTransportAccountServiceSaleAmountHt) {
        this.tmsTransportAccountServiceSaleAmountHt = tmsTransportAccountServiceSaleAmountHt;
    }
    @Column(name="tms_transportservicesaleamountttc")
    public BigDecimal getTmsTransportAccountServiceSaleAmountTtc() {
        return tmsTransportAccountServiceSaleAmountTtc;
    }

    public void setTmsTransportAccountServiceSaleAmountTtc(BigDecimal tmsTransportAccountServiceSaleAmountTtc) {
        this.tmsTransportAccountServiceSaleAmountTtc = tmsTransportAccountServiceSaleAmountTtc;
    }
    @Column(name="tms_transportservicesaleamounttva")
    public BigDecimal getTmsTransportAccountServiceSaleAmountTva() {
        return tmsTransportAccountServiceSaleAmountTva;
    }

    public void setTmsTransportAccountServiceSaleAmountTva(BigDecimal tmsTransportAccountServiceSaleAmountTva) {
        this.tmsTransportAccountServiceSaleAmountTva = tmsTransportAccountServiceSaleAmountTva;
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
