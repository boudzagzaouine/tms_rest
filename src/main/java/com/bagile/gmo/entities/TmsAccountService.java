package com.bagile.gmo.entities;

import javax.persistence.*;
import java.math.BigDecimal;


@Entity
@Table(name = "tms_account_service",
        uniqueConstraints ={@UniqueConstraint
                (columnNames ={"tms_cmdcompanyid","tms_adraddressid","tms_productserviceid"})})

public class TmsAccountService extends EmsEntity {

	private static final long serialVersionUID = 2773120607426017439L;

	private Long tmsAccountServiceId;
    private CmdCompany cmdCompany;
    private AdrAddress adrAddress;
  private PdtProduct pdtProduct;
  
    private BigDecimal tmsAccountServiceSaleAmountHt;
    private BigDecimal tmsAccountServiceSaleAmountTtc;
    private BigDecimal tmsAccountServiceSaleAmountTva;
    private PrmVat prmSaleVat;





    private OwnOwner ownOwner;

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq")
    @SequenceGenerator(name = "seq", sequenceName = "seq_tms_account_service_id", allocationSize = 1)
    @Column(name = "gmo_accountserviceid", unique = true, nullable = false, precision = 10, scale = 0)
    public Long getTmsAccountServiceId() {
        return tmsAccountServiceId;
    }

    public void setTmsAccountServiceId(Long tmsAccountServiceId) {
        this.tmsAccountServiceId = tmsAccountServiceId;
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
    @JoinColumn(name="tms_adraddressid")
    public AdrAddress getAdrAddress() {
        return adrAddress;
    }
    public void setAdrAddress(AdrAddress adrAddress) {
        this.adrAddress = adrAddress;
    }

    @ManyToOne()
    @JoinColumn(name="tms_productserviceid")
    public PdtProduct getPdtProduct() {
        return pdtProduct;
    }

    public void setPdtProduct(PdtProduct pdtProduct) {
        this.pdtProduct = pdtProduct;
    }
    
    
    
    @Column(name="tms_accountservicesaleamountht")
    public BigDecimal getTmsAccountServiceSaleAmountHt() {
        return tmsAccountServiceSaleAmountHt;
    }

    public void setTmsAccountServiceSaleAmountHt(BigDecimal tmsAccountServiceSaleAmountHt) {
        this.tmsAccountServiceSaleAmountHt = tmsAccountServiceSaleAmountHt;
    }
    @Column(name="tms_accountservicesaleamountttc")
    public BigDecimal getTmsAccountServiceSaleAmountTtc() {
        return tmsAccountServiceSaleAmountTtc;
    }

    public void setTmsAccountServiceSaleAmountTtc(BigDecimal tmsAccountServiceSaleAmountTtc) {
        this.tmsAccountServiceSaleAmountTtc = tmsAccountServiceSaleAmountTtc;
    }
    @Column(name="tms_accountservicesaleamounttva")
    public BigDecimal getTmsAccountServiceSaleAmountTva() {
        return tmsAccountServiceSaleAmountTva;
    }

    public void setTmsAccountServiceSaleAmountTva(BigDecimal tmsAccountServiceSaleAmountTva) {
        this.tmsAccountServiceSaleAmountTva = tmsAccountServiceSaleAmountTva;
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
    @JoinColumn(name="gmo_ownownerid")
    public OwnOwner getOwnOwner() {
        return ownOwner;
    }

    public void setOwnOwner(OwnOwner ownOwner) {
        this.ownOwner = ownOwner;
    }
   }
