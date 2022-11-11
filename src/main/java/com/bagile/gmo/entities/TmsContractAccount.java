package com.bagile.gmo.entities;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;


@Entity
@Table(name = "tms_contractaccount")
public class TmsContractAccount extends EmsEntity {

	private static final long serialVersionUID = 2773120607426017439L;

	private Long tmsContractAccountId;
    private String tmsContractAccountCode;
    private Date tmsContractAccountDate;
    private CmdAccount cmdAccount;
    private String tmsContractAccountContractType;
    private GmoVehicleCategory gmoVehicleCategory;


    private PrmVille prmVilleSource;
    private PrmVille prmVilleDistination ;

    private long tmsContractAccountQuantity;
    private AdrAddress adrSenderAddress;
    private AdrAddress adrReceiverAdresse;
    private Date tmsContractAccountStartDate;
    private Date tmsContractAccountEndDate;

    private BigDecimal tmsContractAccountPrice;


    private String tmsContractAccountPackageType;

    private TmsTurnType tmsTurnType;

    private OwnOwner ownOwner;



    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq")
    @SequenceGenerator(name = "seq", sequenceName = "seq_tms_contract_account_id", allocationSize = 1)
    @Column(name = "tms_contractaccountid", unique = true, nullable = false, precision = 10, scale = 0)
    public Long getTmsContractAccountId() {
        return tmsContractAccountId;
    }

    public void setTmsContractAccountId(Long tmsContractAccountId) {
        this.tmsContractAccountId = tmsContractAccountId;
    }

    @Column(name = "tms_contractaccountcode")
    public String getTmsContractAccountCode() {
        return tmsContractAccountCode;
    }

    public void setTmsContractAccountCode(String tmsContractAccountCode) {
        this.tmsContractAccountCode = tmsContractAccountCode;
    }
    @Column(name = "tms_contractaccountdate")
    public Date getTmsContractAccountDate() {
        return tmsContractAccountDate;
    }

    public void setTmsContractAccountDate(Date tmsContractAccountDate) {
        this.tmsContractAccountDate = tmsContractAccountDate;
    }

    @Column(name = "tms_contractaccountcontracttype")
    public String getTmsContractAccountContractType() {
        return tmsContractAccountContractType;
    }

    public void setTmsContractAccountContractType(String tmsContractAccountContractType) {
        this.tmsContractAccountContractType = tmsContractAccountContractType;
    }

    @ManyToOne()
    @JoinColumn(name = "tms_cmdaccountid")
    public CmdAccount getCmdAccount() {
        return cmdAccount;
    }

    public void setCmdAccount(CmdAccount cmdAccount) {
        this.cmdAccount = cmdAccount;
    }


    @ManyToOne()
    @JoinColumn(name = "tms_turntypeid")
    public TmsTurnType getTmsTurnType() {
        return tmsTurnType;
    }

    public void setTmsTurnType(TmsTurnType tmsTurnType) {
        this.tmsTurnType = tmsTurnType;
    }

    @ManyToOne()
    @JoinColumn(name = "tms_prmvillesourceid")
    public PrmVille getPrmVilleSource() {
        return prmVilleSource;
    }

    public void setPrmVilleSource(PrmVille prmVilleSource) {
        this.prmVilleSource = prmVilleSource;
    }

    @ManyToOne()
    @JoinColumn(name = "tms_prmvilledistinationid")
    public PrmVille getPrmVilleDistination() {
        return prmVilleDistination;
    }

    public void setPrmVilleDistination(PrmVille prmVilleDistination) {
        this.prmVilleDistination = prmVilleDistination;
    }

    @ManyToOne()
    @JoinColumn(name = "tms_contractaccountvehiclecategory")
    public GmoVehicleCategory getGmoVehicleCategory() {
        return gmoVehicleCategory;
    }

    public void setGmoVehicleCategory(GmoVehicleCategory gmoVehicleCategory) {
        this.gmoVehicleCategory = gmoVehicleCategory;
    }

    @Column(name = "tms_contractaccountquantity")
    public long getTmsContractAccountQuantity() {
        return tmsContractAccountQuantity;
    }

    public void setTmsContractAccountQuantity(long tmsContractAccountQuantity) {
        this.tmsContractAccountQuantity = tmsContractAccountQuantity;
    }

    @ManyToOne(fetch = FetchType.LAZY, cascade = {CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH})
    @JoinColumn(name = "tms_adrsenderaddressid")
    public AdrAddress getAdrSenderAddress() {
        return adrSenderAddress;
    }

    public void setAdrSenderAddress(AdrAddress adrSenderAddress) {
        this.adrSenderAddress = adrSenderAddress;
    }

    @ManyToOne(fetch = FetchType.LAZY, cascade = {CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH})
    @JoinColumn(name = "tms_adrrenderaddressid")
    public AdrAddress getAdrReceiverAdresse() {
        return adrReceiverAdresse;
    }

    public void setAdrReceiverAdresse(AdrAddress adrReceiverAdresse) {
        this.adrReceiverAdresse = adrReceiverAdresse;
    }

    @Column(name = "tms_contractaccountstartdate")
    public Date getTmsContractAccountStartDate() {
        return tmsContractAccountStartDate;
    }

    public void setTmsContractAccountStartDate(Date tmsContractAccountStartDate) {
        this.tmsContractAccountStartDate = tmsContractAccountStartDate;
    }
    @Column(name = "tms_contractaccountpackagetype")
    public String getTmsContractAccountPackageType() {
        return tmsContractAccountPackageType;
    }

    public void setTmsContractAccountPackageType(String tmsContractAccountPackageType) {
        this.tmsContractAccountPackageType = tmsContractAccountPackageType;
    }



    @Column(name = "tms_contractaccountenddate")
    public Date getTmsContractAccountEndDate() {
        return tmsContractAccountEndDate;
    }

    public void setTmsContractAccountEndDate(Date tmsContractAccountEndDate) {
        this.tmsContractAccountEndDate = tmsContractAccountEndDate;
    }

    @Column(name = "tms_contractaccountprice")
    public BigDecimal getTmsContractAccountPrice() {
        return tmsContractAccountPrice;
    }

    public void setTmsContractAccountPrice(BigDecimal tmsContractAccountPrice) {
        this.tmsContractAccountPrice = tmsContractAccountPrice;
    }

    @ManyToOne()
@JoinColumn(name = "tms_ownownerid")
    public OwnOwner getOwnOwner() {
        return ownOwner;
    }

    public void setOwnOwner(OwnOwner ownOwner) {
        this.ownOwner = ownOwner;
    }
}
