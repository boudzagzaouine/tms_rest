package com.bagile.gmo.entities;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;


@Entity
@Table(name = "tms_transporplanservicecatalog")
public class TmsTransportPlanServiceCatalog extends EmsEntity {

	private static final long serialVersionUID = 2773120607426017439L;

	private Long tmsTransporPlanServiceCatalogId;
    private PdtProduct pdtProduct;
    private TrpTransport TrpTransport;
    private CmdAccount cmdAccount;

    private AdrAddress adrAddress;
    private Boolean tmsTransporPlanServiceCatalogPInvoice ;
    private BigDecimal tmsTransporPlanServiceCatalogPurchasePriceHT;
    private PrmVat prmPurchaseVat;
    private BigDecimal tmsTransporPlanServiceCatalogPurchasePriceTTC;
    private BigDecimal tmsTransporPlanServiceCatalogPurchasePriceVat;

    private BigDecimal tmsTransporPlanServiceCatalogSalePriceHT;

    private PrmVat prmSaleVat;
    private BigDecimal tmsTransporPlanServiceCatalogSalePriceTTC;
    private BigDecimal tmsTransporPlanServiceCatalogSalePriceVat;
  private Long tmsTransporPlanServiceCatalogQuantity;

    private Date tmsTransporPlanServiceCatalogDateService;

    private BigDecimal tmsTransporPlanServiceCatalogTotalPurchasePriceHT;
    private BigDecimal tmsTransporPlanServiceCatalogTotalPurchasePriceVat;
    private BigDecimal tmsTransporPlanServiceCatalogTotalPurchasePriceTTC;

    private BigDecimal tmsTransporPlanServiceCatalogTotalSalePriceHT;
    private BigDecimal tmsTransporPlanServiceCatalogTotalSalePriceTTC;
    private BigDecimal tmsTransporPlanServiceCatalogTotalSalePriceVat;


    private OwnOwner ownOwner;
    private TmsOrderTransport tmsOrderTransport;

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
    @JoinColumn(name = "tms_addressid")
    public AdrAddress getAdrAddress() {
        return adrAddress;
    }

    public void setAdrAddress(AdrAddress adrAddress) {
        this.adrAddress = adrAddress;
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
    @JoinColumn(name = "tms_cmdAccountid")
    public CmdAccount getCmdAccount() {
        return cmdAccount;
    }

    public void setCmdAccount(CmdAccount cmdAccount) {
        this.cmdAccount = cmdAccount;
    }




    @Column(name = "tms_transporplanservicecataloginvoice")
    public Boolean getTmsTransporPlanServiceCatalogPInvoice() {
        return tmsTransporPlanServiceCatalogPInvoice;
    }

    public void setTmsTransporPlanServiceCatalogPInvoice(Boolean tmsTransporPlanServiceCatalogPInvoice) {
        this.tmsTransporPlanServiceCatalogPInvoice = tmsTransporPlanServiceCatalogPInvoice;
    }

    @Column(name = "tms_transporplanservicecatalogdateservice")
    public Date getTmsTransporPlanServiceCatalogDateService() {
        return tmsTransporPlanServiceCatalogDateService;
    }

    public void setTmsTransporPlanServiceCatalogDateService(Date tmsTransporPlanServiceCatalogDateService) {
        this.tmsTransporPlanServiceCatalogDateService = tmsTransporPlanServiceCatalogDateService;
    }

    @Column(name = "tms_transporplanservicecatalogpurcahsepriceht")
    public BigDecimal getTmsTransporPlanServiceCatalogPurchasePriceHT() {
        return tmsTransporPlanServiceCatalogPurchasePriceHT;
    }

    public void setTmsTransporPlanServiceCatalogPurchasePriceHT(BigDecimal tmsTransporPlanServiceCatalogPurchasePriceHT) {
        this.tmsTransporPlanServiceCatalogPurchasePriceHT = tmsTransporPlanServiceCatalogPurchasePriceHT;
    }

    @Column(name = "tms_transporplanservicecatalogtotalpurcahsepriceht")

    public BigDecimal getTmsTransporPlanServiceCatalogTotalPurchasePriceHT() {
        return tmsTransporPlanServiceCatalogTotalPurchasePriceHT;
    }

    public void setTmsTransporPlanServiceCatalogTotalPurchasePriceHT(BigDecimal tmsTransporPlanServiceCatalogTotalPurchasePriceHT) {
        this.tmsTransporPlanServiceCatalogTotalPurchasePriceHT = tmsTransporPlanServiceCatalogTotalPurchasePriceHT;
    }

    @Column(name = "tms_transporplanservicecatalogtotalpurcahsepricevat")

    public BigDecimal getTmsTransporPlanServiceCatalogTotalPurchasePriceVat() {
        return tmsTransporPlanServiceCatalogTotalPurchasePriceVat;
    }

    public void setTmsTransporPlanServiceCatalogTotalPurchasePriceVat(BigDecimal prmTotalPurchaseVat) {
        this.tmsTransporPlanServiceCatalogTotalPurchasePriceVat = prmTotalPurchaseVat;
    }

    @Column(name = "tms_transporplanservicecatalogtotalpurcahsepricettc")

    public BigDecimal getTmsTransporPlanServiceCatalogTotalPurchasePriceTTC() {
        return tmsTransporPlanServiceCatalogTotalPurchasePriceTTC;
    }

    public void setTmsTransporPlanServiceCatalogTotalPurchasePriceTTC(BigDecimal tmsTransporPlanServiceCatalogTotalPurchasePriceTTC) {
        this.tmsTransporPlanServiceCatalogTotalPurchasePriceTTC = tmsTransporPlanServiceCatalogTotalPurchasePriceTTC;
    }

    @Column(name = "tms_transporplanservicecatalogquantity")
    public Long getTmsTransporPlanServiceCatalogQuantity() {
        return tmsTransporPlanServiceCatalogQuantity;
    }

    public void setTmsTransporPlanServiceCatalogQuantity(Long tmsTransporPlanServiceCatalogQuantity) {
        this.tmsTransporPlanServiceCatalogQuantity = tmsTransporPlanServiceCatalogQuantity;
    }

    @Column(name = "tms_transporplanservicecatalogsalepricevat")

    public BigDecimal getTmsTransporPlanServiceCatalogSalePriceVat() {
        return tmsTransporPlanServiceCatalogSalePriceVat;
    }

    public void setTmsTransporPlanServiceCatalogSalePriceVat(BigDecimal tmsTransporPlanServiceCatalogSalePriceVat) {
        this.tmsTransporPlanServiceCatalogSalePriceVat = tmsTransporPlanServiceCatalogSalePriceVat;
    }

    @Column(name = "tms_transporplanservicecatalogtotalsalepriceht")
    public BigDecimal getTmsTransporPlanServiceCatalogTotalSalePriceHT() {
        return tmsTransporPlanServiceCatalogTotalSalePriceHT;
    }

    public void setTmsTransporPlanServiceCatalogTotalSalePriceHT(BigDecimal tmsTransporPlanServiceCatalogTotalSalePriceHT) {
        this.tmsTransporPlanServiceCatalogTotalSalePriceHT = tmsTransporPlanServiceCatalogTotalSalePriceHT;
    }

    @Column(name = "tms_transporplanservicecatalogtotalsalepricettc")

    public BigDecimal getTmsTransporPlanServiceCatalogTotalSalePriceTTC() {
        return tmsTransporPlanServiceCatalogTotalSalePriceTTC;
    }

    public void setTmsTransporPlanServiceCatalogTotalSalePriceTTC(BigDecimal tmsTransporPlanServiceCatalogTotalSalePriceTTC) {
        this.tmsTransporPlanServiceCatalogTotalSalePriceTTC = tmsTransporPlanServiceCatalogTotalSalePriceTTC;
    }

    @Column(name = "tms_transporplanservicecatalogtotalsalepricevat")

    public BigDecimal getTmsTransporPlanServiceCatalogTotalSalePriceVat() {
        return tmsTransporPlanServiceCatalogTotalSalePriceVat;
    }

    public void setTmsTransporPlanServiceCatalogTotalSalePriceVat(BigDecimal tmsTransporPlanServiceCatalogTotalSalePriceVat) {
        this.tmsTransporPlanServiceCatalogTotalSalePriceVat = tmsTransporPlanServiceCatalogTotalSalePriceVat;
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

    @Column(name = "tms_transporplanservicecatalogpurchasepricevat")

    public void setTmsTransporPlanServiceCatalogPurchasePriceTTC(BigDecimal tmsTransporPlanServiceCatalogPurchasePriceTTC) {
        this.tmsTransporPlanServiceCatalogPurchasePriceTTC = tmsTransporPlanServiceCatalogPurchasePriceTTC;
    }

    public BigDecimal getTmsTransporPlanServiceCatalogPurchasePriceVat() {
        return tmsTransporPlanServiceCatalogPurchasePriceVat;
    }

    public void setTmsTransporPlanServiceCatalogPurchasePriceVat(BigDecimal tmsTransporPlanServiceCatalogPurchasePriceVat) {
        this.tmsTransporPlanServiceCatalogPurchasePriceVat = tmsTransporPlanServiceCatalogPurchasePriceVat;
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
    @JoinColumn(name = "tms_ordertransportid")
    public TmsOrderTransport getTmsOrderTransport() {
        return tmsOrderTransport;
    }

    public void setTmsOrderTransport(TmsOrderTransport tmsOrderTransport) {
        this.tmsOrderTransport = tmsOrderTransport;
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
