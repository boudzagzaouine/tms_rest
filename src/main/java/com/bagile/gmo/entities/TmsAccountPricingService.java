package com.bagile.gmo.entities;

import javax.persistence.*;
import java.math.BigDecimal;


@Entity
@Table(name = "tms_account_pricing_service",
        uniqueConstraints ={@UniqueConstraint
                (columnNames ={"tms_cmdcompanyid","tms_cmdacountid","tms_productserviceid"})})

public class TmsAccountPricingService extends EmsEntity {

	private static final long serialVersionUID = 2773120607426017439L;

	private Long tmsAccountPricingServiceId;
    private CmdCompany cmdCompany;
    private CmdAccount cmdAccount;
  private PdtProduct pdtProduct;
  
    private BigDecimal tmsAccountPricingServiceSaleAmountHt;
    private BigDecimal tmsAccountPricingServiceSaleAmountTtc;
    private BigDecimal tmsAccountPricingServiceSaleAmountTva;
    private PrmVat prmSaleVat;





    private OwnOwner ownOwner;

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq")
    @SequenceGenerator(name = "seq", sequenceName = "seq_tms_account_pricing_service_id", allocationSize = 1)
    @Column(name = "gmo_accountpricingserviceid", unique = true, nullable = false, precision = 10, scale = 0)
    public Long getTmsAccountPricingServiceId() {
        return tmsAccountPricingServiceId;
    }

    public void setTmsAccountPricingServiceId(Long tmsAccountPricingServiceId) {
        this.tmsAccountPricingServiceId = tmsAccountPricingServiceId;
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
    @JoinColumn(name="tms_cmdacountid")
    public CmdAccount getCmdAccount() {
        return cmdAccount;
    }

    public void setCmdAccount(CmdAccount cmdAccount) {
        this.cmdAccount = cmdAccount;
    }



    @ManyToOne()
    @JoinColumn(name="tms_productserviceid")
    public PdtProduct getPdtProduct() {
        return pdtProduct;
    }

    public void setPdtProduct(PdtProduct pdtProduct) {
        this.pdtProduct = pdtProduct;
    }
    
    
    
    @Column(name="tms_accountpricingservicesaleamountht")
    public BigDecimal getTmsAccountPricingServiceSaleAmountHt() {
        return tmsAccountPricingServiceSaleAmountHt;
    }

    public void setTmsAccountPricingServiceSaleAmountHt(BigDecimal tmsAccountPricingServiceSaleAmountHt) {
        this.tmsAccountPricingServiceSaleAmountHt = tmsAccountPricingServiceSaleAmountHt;
    }
    @Column(name="tms_accountpricingservicesaleamountttc")
    public BigDecimal getTmsAccountPricingServiceSaleAmountTtc() {
        return tmsAccountPricingServiceSaleAmountTtc;
    }

    public void setTmsAccountPricingServiceSaleAmountTtc(BigDecimal tmsAccountPricingServiceSaleAmountTtc) {
        this.tmsAccountPricingServiceSaleAmountTtc = tmsAccountPricingServiceSaleAmountTtc;
    }
    @Column(name="tms_accountpricingservicesaleamounttva")
    public BigDecimal getTmsAccountPricingServiceSaleAmountTva() {
        return tmsAccountPricingServiceSaleAmountTva;
    }

    public void setTmsAccountPricingServiceSaleAmountTva(BigDecimal tmsAccountPricingServiceSaleAmountTva) {
        this.tmsAccountPricingServiceSaleAmountTva = tmsAccountPricingServiceSaleAmountTva;
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
