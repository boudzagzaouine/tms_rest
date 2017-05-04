package com.sinno.ems.entities;

import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.Max;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.math.BigDecimal;
import java.util.Date;

/**
 * Created by ASMAE on 27/04/2016.
 */

@Entity
@Table(name = "stk_stock_exception")
public class StkStockException implements java.io.Serializable {
    private long stkStockExceptionId;

    private String stkStockExceptionReason;

    private LocLocation locLocationOld;
    @NotNull
    private OwnOwner ownOwnerOld;
    private Date stkStockExceptionUpdateDateOld;
    @Size(max = 255)
    private String stkStockExceptionVariable1Old;
    @Size(max = 255)
    private String stkStockExceptionVariable2Old;
    @Size(max = 255)
    private String stkStockExceptionVariable3Old;
    @Size(max = 255)
    private String stkStockExceptionVariable4Old;
    @Size(max = 255)
    private String stkStockExceptionVariable5Old;
    @Size(max = 255)
    private String stkStockExceptionVariable6Old;
    @Size(max = 255)
    private String stkStockExceptionVariable7Old;
    @Size(max = 255)
    private String stkStockExceptionVariable8Old;
    @Size(max = 255)
    private String stkStockExceptionVariable9Old;
    @Size(max = 255)
    private String stkStockExceptionVariable10Old;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date stkStockExceptionCreationDateOld;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date stkStockExceptionReceptionDateOld;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date stkStockExceptionCreationDateNew;
    @NotNull
    private PdtProduct pdtProductOld;
    private PrmBlockType prmBlockTypeOld;
    private RcpSupplier rcpSupplierOld;
    private PrmColor prmColorOld;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date stkStockExceptionDlcOld;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date stkStockExceptionDluoOld;
    @Size(max = 255)
    private String stkStockExceptionSerialNoOld;
    @Size(max = 255)
    private String stkStockExceptionLotOld;
    private StkContainer stkContainerOld;

    @Max(999999999)
    @NotNull
    private BigDecimal stkStockExceptionQuantityOld;
    @Max(999999999)
    @NotNull
    private BigDecimal stkStockExceptionQuantityNew;//
    private PdtUom pdtUomOld;
    private PdtUom pdtUomNew;

    private Boolean stkStockExceptioKitOld;
    private RcpReceptionLine rcpReceptionLineOld;
    @Size(max = 50)
    private String stkStockExceptionQualityNew;
    @Max(999999999)
    private BigDecimal stkStockExceptionWeightNew;
    @Size(max = 50)
    private String stkStockExceptionQualityOld;
    @Max(999999999)
    private BigDecimal stkStockExceptionWeightOld;
    private StkException stkException;
    private String stkStockExceptionAction;
    private PdtProductDimension pdtProductDimension;
    private UsrUser usrUser;

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq")
    @SequenceGenerator(name = "seq", sequenceName = "seq_stk_stock_exception", allocationSize = 1)
    @Column(name = "stk_stockexceptionid", unique = true, nullable = false, precision = 10, scale = 0)
    public long getStkStockExceptionId() {
        return stkStockExceptionId;
    }

    public void setStkStockExceptionId(long stkStockExceptionId) {
        this.stkStockExceptionId = stkStockExceptionId;
    }

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "stk_stockexceptionlocationid")
    public LocLocation getLocLocationOld() {
        return locLocationOld;
    }

    public void setLocLocationOld(LocLocation locLocationOld) {
        this.locLocationOld = locLocationOld;
    }

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "stk_stockexceptionownerid", nullable = false)
    public OwnOwner getOwnOwnerOld() {
        return ownOwnerOld;
    }

    public void setOwnOwnerOld(OwnOwner ownOwnerOld) {
        this.ownOwnerOld = ownOwnerOld;
    }

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "stk_stockexceptionupdatedate")
    public Date getStkStockExceptionUpdateDateOld() {
        return stkStockExceptionUpdateDateOld;
    }

    public void setStkStockExceptionUpdateDateOld(Date stkStockExceptionUpdateDateOld) {
        this.stkStockExceptionUpdateDateOld = stkStockExceptionUpdateDateOld;
    }

    @Column(name = "stk_stockexceptionreason")
    public String getStkStockExceptionReason() {
        return stkStockExceptionReason;
    }

    public void setStkStockExceptionReason(String stkStockExceptionReason) {
        this.stkStockExceptionReason = stkStockExceptionReason;
    }

    @Column(name = "stk_stockexceptionvariable1")
    public String getStkStockExceptionVariable1Old() {
        return stkStockExceptionVariable1Old;
    }

    public void setStkStockExceptionVariable1Old(String stkStockExceptionVariable1Old) {
        this.stkStockExceptionVariable1Old = stkStockExceptionVariable1Old;
    }

    @Column(name = "stk_stockexceptionvariable2")
    public String getStkStockExceptionVariable2Old() {
        return stkStockExceptionVariable2Old;
    }

    public void setStkStockExceptionVariable2Old(String stkStockExceptionVariable2Old) {
        this.stkStockExceptionVariable2Old = stkStockExceptionVariable2Old;
    }

    @Column(name = "stk_stockexceptionvariable3")
    public String getStkStockExceptionVariable3Old() {
        return stkStockExceptionVariable3Old;
    }

    public void setStkStockExceptionVariable3Old(String stkStockExceptionVariable3Old) {
        this.stkStockExceptionVariable3Old = stkStockExceptionVariable3Old;
    }

    @Column(name = "stk_stockexceptionvariable4")
    public String getStkStockExceptionVariable4Old() {
        return stkStockExceptionVariable4Old;
    }

    public void setStkStockExceptionVariable4Old(String stkStockExceptionVariable4Old) {
        this.stkStockExceptionVariable4Old = stkStockExceptionVariable4Old;
    }

    @Column(name = "stk_stockexceptionvariable5")
    public String getStkStockExceptionVariable5Old() {
        return stkStockExceptionVariable5Old;
    }

    public void setStkStockExceptionVariable5Old(String stkStockExceptionVariable5Old) {
        this.stkStockExceptionVariable5Old = stkStockExceptionVariable5Old;
    }

    @Column(name = "stk_stockexceptionvariable6")
    public String getStkStockExceptionVariable6Old() {
        return stkStockExceptionVariable6Old;
    }

    public void setStkStockExceptionVariable6Old(String stkStockExceptionVariable6Old) {
        this.stkStockExceptionVariable6Old = stkStockExceptionVariable6Old;
    }

    @Column(name = "stk_stockexceptionvariable7")
    public String getStkStockExceptionVariable7Old() {
        return stkStockExceptionVariable7Old;
    }

    public void setStkStockExceptionVariable7Old(String stkStockExceptionVariable7Old) {
        this.stkStockExceptionVariable7Old = stkStockExceptionVariable7Old;
    }

    @Column(name = "stk_stockexceptionvariable8")
    public String getStkStockExceptionVariable8Old() {
        return stkStockExceptionVariable8Old;
    }

    public void setStkStockExceptionVariable8Old(String stkStockExceptionVariable8Old) {
        this.stkStockExceptionVariable8Old = stkStockExceptionVariable8Old;
    }

    @Column(name = "stk_stockexceptionvariable9")
    public String getStkStockExceptionVariable9Old() {
        return stkStockExceptionVariable9Old;
    }

    public void setStkStockExceptionVariable9Old(String stkStockExceptionVariable9Old) {
        this.stkStockExceptionVariable9Old = stkStockExceptionVariable9Old;
    }

    @Column(name = "stk_stockexceptionvariable10")
    public String getStkStockExceptionVariable10Old() {
        return stkStockExceptionVariable10Old;
    }

    public void setStkStockExceptionVariable10Old(String stkStockExceptionVariable10Old) {
        this.stkStockExceptionVariable10Old = stkStockExceptionVariable10Old;
    }


    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "stk_stockexceptioncreationdate")
    public Date getStkStockExceptionCreationDateOld() {
        return stkStockExceptionCreationDateOld;
    }

    public void setStkStockExceptionCreationDateOld(Date stkStockExceptionCreationDateOld) {
        this.stkStockExceptionCreationDateOld = stkStockExceptionCreationDateOld;
    }

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "stk_stockexceptionreceptiondateold")
    public Date getStkStockExceptionReceptionDateOld() {
        return stkStockExceptionReceptionDateOld;
    }

    public void setStkStockExceptionReceptionDateOld(Date stkStockExceptionReceptionDateOld) {
        this.stkStockExceptionReceptionDateOld = stkStockExceptionReceptionDateOld;
    }

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "stk_stockexceptioncreationdatenew")
    public Date getStkStockExceptionCreationDateNew() {
        return stkStockExceptionCreationDateNew;
    }

    public void setStkStockExceptionCreationDateNew(Date stkStockExceptionCreationDateNew) {
        this.stkStockExceptionCreationDateNew = stkStockExceptionCreationDateNew;
    }

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "stk_stockexceptionproductid", nullable = false)
    public PdtProduct getPdtProductOld() {
        return pdtProductOld;
    }

    public void setPdtProductOld(PdtProduct pdtProductOld) {
        this.pdtProductOld = pdtProductOld;
    }

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "stk_stockexceptionblockid")
    public PrmBlockType getPrmBlockTypeOld() {
        return prmBlockTypeOld;
    }

    public void setPrmBlockTypeOld(PrmBlockType prmBlockTypeOld) {
        this.prmBlockTypeOld = prmBlockTypeOld;
    }

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "stk_stockexceptionsupplierid")
    public RcpSupplier getRcpSupplierOld() {
        return rcpSupplierOld;
    }

    public void setRcpSupplierOld(RcpSupplier rcpSupplierOld) {
        this.rcpSupplierOld = rcpSupplierOld;
    }

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "stk_stockexceptioncolorid")
    public PrmColor getPrmColorOld() {
        return prmColorOld;
    }

    public void setPrmColorOld(PrmColor prmColorOld) {
        this.prmColorOld = prmColorOld;
    }

    @Temporal(TemporalType.DATE)
    @Column(name = "stk_stockexceptiondlc")
    public Date getStkStockExceptionDlcOld() {
        return stkStockExceptionDlcOld;
    }

    public void setStkStockExceptionDlcOld(Date stkStockExceptionDlcOld) {
        this.stkStockExceptionDlcOld = stkStockExceptionDlcOld;
    }

    @Temporal(TemporalType.DATE)
    @Column(name = "stk_stockexceptiondluo")
    public Date getStkStockExceptionDluoOld() {
        return stkStockExceptionDluoOld;
    }

    public void setStkStockExceptionDluoOld(Date stkStockExceptionDluoOld) {
        this.stkStockExceptionDluoOld = stkStockExceptionDluoOld;
    }

    @Column(name = "stk_stockexceptionserialno", length = 50)
    public String getStkStockExceptionSerialNoOld() {
        return stkStockExceptionSerialNoOld;
    }

    public void setStkStockExceptionSerialNoOld(String stkStockExceptionSerialNoOld) {
        this.stkStockExceptionSerialNoOld = stkStockExceptionSerialNoOld;
    }

    @Column(name = "stk_stockexceptionlot", length = 50)
    public String getStkStockExceptionLotOld() {
        return stkStockExceptionLotOld;
    }

    public void setStkStockExceptionLotOld(String stkStockExceptionLotOld) {
        this.stkStockExceptionLotOld = stkStockExceptionLotOld;
    }

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "stk_stockexceptioncontainerid")
    public StkContainer getStkContainerOld() {
        return stkContainerOld;
    }

    public void setStkContainerOld(StkContainer stkContainerOld) {
        this.stkContainerOld = stkContainerOld;
    }

    @Column(name = "stk_stockexceptionquantity", nullable = false, precision = 12, scale = 5)
    public BigDecimal getStkStockExceptionQuantityOld() {
        return stkStockExceptionQuantityOld;
    }

    public void setStkStockExceptionQuantityOld(BigDecimal stkStockExceptionQuantityOld) {
        this.stkStockExceptionQuantityOld = stkStockExceptionQuantityOld;
    }

    @Column(name = "stk_stockexceptionquantitynew", nullable = false, precision = 12, scale = 5)
    public BigDecimal getStkStockExceptionQuantityNew() {
        return stkStockExceptionQuantityNew;
    }

    public void setStkStockExceptionQuantityNew(BigDecimal stkStockExceptionQuantityNew) {
        this.stkStockExceptionQuantityNew = stkStockExceptionQuantityNew;
    }

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "stk_stockexceptionuomnewid")
    public PdtUom getPdtUomNew() {
        return pdtUomNew;
    }

    public void setPdtUomNew(PdtUom pdtUomNew) {
        this.pdtUomNew = pdtUomNew;
    }

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "stk_stockexceptionuomoldid")
    public PdtUom getPdtUomOld() {
        return pdtUomOld;
    }

    public void setPdtUomOld(PdtUom pdtUomOld) {
        this.pdtUomOld = pdtUomOld;
    }

    @Column(name = "stk_stockexceptionkit")
    public Boolean getStkStockExceptioKitOld() {
        return stkStockExceptioKitOld;
    }

    public void setStkStockExceptioKitOld(Boolean stkStockExceptioKitOld) {
        this.stkStockExceptioKitOld = stkStockExceptioKitOld;
    }

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "stk_stockexceptionreceptionlineoldid")
    public RcpReceptionLine getRcpReceptionLineOld() {
        return rcpReceptionLineOld;
    }

    public void setRcpReceptionLineOld(RcpReceptionLine rcpReceptionLineOld) {
        this.rcpReceptionLineOld = rcpReceptionLineOld;
    }

    @Column(name = "stk_stockexceptionqualitynew", precision = 10, scale = 0)

    public String getStkStockExceptionQualityNew() {
        return stkStockExceptionQualityNew;
    }

    @Column(name = "stk_stockexceptionqualitynew", length = 50)

    public void setStkStockExceptionQualityNew(String stkStockExceptionQualityNew) {
        this.stkStockExceptionQualityNew = stkStockExceptionQualityNew;
    }

    @Column(name = "stk_stockexceptionweightnew", precision = 12, scale = 5)
    public BigDecimal getStkStockExceptionWeightNew() {
        return stkStockExceptionWeightNew;
    }

    public void setStkStockExceptionWeightNew(BigDecimal stkStockExceptionWeightNew) {
        this.stkStockExceptionWeightNew = stkStockExceptionWeightNew;
    }

    @Column(name = "stk_stockexceptionqualityold")

    public String getStkStockExceptionQualityOld() {
        return stkStockExceptionQualityOld;
    }

    public void setStkStockExceptionQualityOld(String stkStockExceptionQualityOld) {
        this.stkStockExceptionQualityOld = stkStockExceptionQualityOld;
    }

    @Column(name = "stk_stockexceptionweightold", precision = 12, scale = 5)

    public BigDecimal getStkStockExceptionWeightOld() {
        return stkStockExceptionWeightOld;
    }

    public void setStkStockExceptionWeightOld(BigDecimal stkStockExceptionWeightOld) {
        this.stkStockExceptionWeightOld = stkStockExceptionWeightOld;
    }

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "stk_stockexceptionstkexceptionid")
    public StkException getStkException() {
        return stkException;
    }

    public void setStkException(StkException stkException) {
        this.stkException = stkException;
    }

    @Column(name = "stk_stockexceptionaction")
    public String getStkStockExceptionAction() {
        return stkStockExceptionAction;
    }

    public void setStkStockExceptionAction(String stkStockExceptionAction) {
        this.stkStockExceptionAction = stkStockExceptionAction;
    }

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "stk_stockexceptionusruserid")
    public UsrUser getUsrUser() {
        return usrUser;
    }

    public void setUsrUser(UsrUser usrUser) {
        this.usrUser = usrUser;
    }
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "stk_stockexceptionproductdimensionid")
    public PdtProductDimension getPdtProductDimension() {
        return pdtProductDimension;
    }

    public void setPdtProductDimension(PdtProductDimension pdtProductDimension) {
        this.pdtProductDimension = pdtProductDimension;
    }
}
