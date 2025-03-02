package com.bagile.gmo.entities;

// Generated 8 mars 2015 01:55:29 by Hibernate Tools 4.3.1

import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.Max;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.math.BigDecimal;
import java.util.Date;

/**
 * RcpReceptionstock generated by hbm2java
 */
@Entity
@Table(name = "rcp_receptionstock")
public class RcpReceptionStock extends EmsEntity implements java.io.Serializable {

    private Long rcpReceptionStockId;
   // @NotNull
    private OwnOwner ownOwner;
    @NotNull
    private PdtProduct pdtProduct;
   // private PrmBlockType prmBlockType;
    //private PrmColor prmColor;
    @NotNull
    private RcpReception rcpReception;
    @NotNull
    private RcpReceptionLine rcpReceptionLine;
    private RcpSupplier rcpSupplier;
   // @NotNull
    private WrhWarehouse wrhWarehouse;



    @Max(999999999)
    @NotNull
    private BigDecimal rcpReceptionStockQuantityReceived;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date rcpReceptionStockDlc;
    @DateTimeFormat(pattern = "yyyy-MM-dd")

    private Date rcpReceptionStockDluo;
    @Size(max = 255)
    private String rcpReceptionStockSerialNo;
    @Size(max = 255)
    private String rcpReceptionStockLot;
    @DateTimeFormat(pattern = "yyyy-MM-dd")

    private Date rcpReceptionStockReceptionDate;
    @DateTimeFormat(pattern = "yyyy-MM-dd")

    private Date rcpReceptionStockCreationDate;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date rcpReceptionStockUpdateDate;

  //  private StkContainer stkContainer;
    private PdtUom pdtUom;
    private LocLocation locLocation;
    private PdtUom pdtUomRecieved;
    @Size(max=50)
    private String rcpReceptionStockQuality;
    @Max(999999999)
    private BigDecimal rcpReceptionStockWeight;
   // private PdtProductDimension pdtProductDimension;
    private PdtProductPack pdtProductPack;


    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq")
    @SequenceGenerator(name = "seq", sequenceName = "seq_rcp_receptionstock", allocationSize = 1)
    @Column(name = "rcp_receptionstockid", unique = true, nullable = false, precision = 10, scale = 0)
    public Long getRcpReceptionStockId() {
        return this.rcpReceptionStockId;
    }

    public void setRcpReceptionStockId(Long rcpReceptionStockId) {
        this.rcpReceptionStockId = rcpReceptionStockId;
    }

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "rcp_receptionstockownerid", nullable = false)
    public OwnOwner getOwnOwner() {
        return this.ownOwner;
    }

    public void setOwnOwner(OwnOwner ownOwner) {
        this.ownOwner = ownOwner;
    }

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "rcp_receptionstockproductid", nullable = false)
    public PdtProduct getPdtProduct() {
        return this.pdtProduct;
    }

    public void setPdtProduct(PdtProduct pdtProduct) {
        this.pdtProduct = pdtProduct;
    }

   /* @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "rcp_receptionstockblocktypeid")
    public PrmBlockType getPrmBlockType() {
        return this.prmBlockType;
    }

    public void setPrmBlockType(PrmBlockType prmBlockType) {
        this.prmBlockType = prmBlockType;
    }
*/
  /*  @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "rcp_receptionstockcolorid")
    public PrmColor getPrmColor() {
        return this.prmColor;
    }

    public void setPrmColor(PrmColor prmColor) {
        this.prmColor = prmColor;
    }
*/
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "rcp_receptionstockreceptionid", nullable = false)
    public RcpReception getRcpReception() {
        return this.rcpReception;
    }

    public void setRcpReception(RcpReception rcpReception) {
        this.rcpReception = rcpReception;
    }

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "rcp_receptionstockreceptionlineid", nullable = false)
    public RcpReceptionLine getRcpReceptionLine() {
        return this.rcpReceptionLine;
    }

    public void setRcpReceptionLine(RcpReceptionLine rcpReceptionLine) {
        this.rcpReceptionLine = rcpReceptionLine;
    }

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "rcp_receptionstocksupplierid")
    public RcpSupplier getRcpSupplier() {
        return this.rcpSupplier;
    }

    public void setRcpSupplier(RcpSupplier rcpSupplier) {
        this.rcpSupplier = rcpSupplier;
    }

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "rcp_receptionstockwarehouseid")
    public WrhWarehouse getWrhWarehouse() {
        return this.wrhWarehouse;
    }

    public void setWrhWarehouse(WrhWarehouse wrhWarehouse) {
        this.wrhWarehouse = wrhWarehouse;
    }

    @Column(name = "rcp_receptionstockquantityreceived", nullable = false, precision = 12, scale = 5)
    public BigDecimal getRcpReceptionStockQuantityReceived() {
        return this.rcpReceptionStockQuantityReceived;
    }

    public void setRcpReceptionStockQuantityReceived(
            BigDecimal rcpReceptionStockQuantityReceived) {
        this.rcpReceptionStockQuantityReceived = rcpReceptionStockQuantityReceived;
    }

    @Temporal(TemporalType.DATE)
    @Column(name = "rcp_receptionstockdlc", length = 13)
    public Date getRcpReceptionStockDlc() {
        return this.rcpReceptionStockDlc;
    }

    public void setRcpReceptionStockDlc(Date rcpReceptionStockDlc) {
        this.rcpReceptionStockDlc = rcpReceptionStockDlc;
    }

    @Temporal(TemporalType.DATE)
    @Column(name = "rcp_receptionstockdluo", length = 13)
    public Date getRcpReceptionStockDluo() {
        return this.rcpReceptionStockDluo;
    }

    public void setRcpReceptionStockDluo(Date rcpReceptionStockDluo) {
        this.rcpReceptionStockDluo = rcpReceptionStockDluo;
    }

    @Column(name = "rcp_receptionstockserialno", length = 51)
    public String getRcpReceptionStockSerialNo() {
        return this.rcpReceptionStockSerialNo;
    }

    public void setRcpReceptionStockSerialNo(String rcpReceptionStockSerialNo) {
        this.rcpReceptionStockSerialNo = rcpReceptionStockSerialNo;
    }

    @Column(name = "rcp_receptionstocklot", length = 50)
    public String getRcpReceptionStockLot() {
        return this.rcpReceptionStockLot;
    }

    public void setRcpReceptionStockLot(String rcpReceptionStockLot) {
        this.rcpReceptionStockLot = rcpReceptionStockLot;
    }

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "rcp_receptionstockreceptiondate")
    public Date getRcpReceptionStockReceptionDate() {
        return this.rcpReceptionStockReceptionDate;
    }

    public void setRcpReceptionStockReceptionDate(
            Date rcpReceptionStockReceptionDate) {
        this.rcpReceptionStockReceptionDate = rcpReceptionStockReceptionDate;
    }

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "rcp_receptionstockcreationdate")
    public Date getRcpReceptionStockCreationDate() {
        return this.rcpReceptionStockCreationDate;
    }

    public void setRcpReceptionStockCreationDate(
            Date rcpReceptionStockCreationDate) {
        this.rcpReceptionStockCreationDate = rcpReceptionStockCreationDate;
    }

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "rcp_receptionstockupdatedate")
    public Date getRcpReceptionStockUpdateDate() {
        return this.rcpReceptionStockUpdateDate;
    }

    public void setRcpReceptionStockUpdateDate(Date rcpReceptionStockUpdateDate) {
        this.rcpReceptionStockUpdateDate = rcpReceptionStockUpdateDate;
    }

  /*  @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="rcp_receptionstockcontainerid")
    public StkContainer getStkContainer() {
        return stkContainer;
    }

    public void setStkContainer(StkContainer stkContainer) {
        this.stkContainer = stkContainer;
    }
    */
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="rcp_receptionstockuomid")
    public PdtUom getPdtUom() {
        return pdtUom;
    }

    public void setPdtUom(PdtUom pdtUom) {
        this.pdtUom = pdtUom;
    }

   @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="rcp_receptionstocklocationid")
    public LocLocation getLocLocation() {
        return locLocation;
    }

    public void setLocLocation(LocLocation locLocation) {
        this.locLocation = locLocation;
    }

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="rcp_receptionstockuomrecievedid")
    public PdtUom getPdtUomRecieved() {
        return pdtUomRecieved;
    }

    public void setPdtUomRecieved(PdtUom pdtUomRecieved) {
        this.pdtUomRecieved = pdtUomRecieved;
    }

    @Column(name = "rcp_receptionstockquality",length = 50)

    public String getRcpReceptionStockQuality() {
        return rcpReceptionStockQuality;
    }

    public void setRcpReceptionStockQuality(String rcpReceptionStockQuality) {
        this.rcpReceptionStockQuality = rcpReceptionStockQuality;
    }
    @Column(name = "rcp_receptionstockweight",precision = 10,scale =0 )

    public BigDecimal getRcpReceptionStockWeight() {
        return rcpReceptionStockWeight;
    }

    public void setRcpReceptionStockWeight(BigDecimal rcpReceptionStockWeight) {
        this.rcpReceptionStockWeight = rcpReceptionStockWeight;
    }

   /* @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "rcp_receptionstockproductdimensionid")
    public PdtProductDimension getPdtProductDimension() {
        return pdtProductDimension;
    }

    public void setPdtProductDimension(PdtProductDimension pdtProductDimension) {
        this.pdtProductDimension = pdtProductDimension;
    }
    */
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "rcp_receptionstockpackid")
    public PdtProductPack getPdtProductPack() {

        return pdtProductPack;
    }

    public void setPdtProductPack(PdtProductPack pdtProductPack) {
        this.pdtProductPack = pdtProductPack;
    }
}
