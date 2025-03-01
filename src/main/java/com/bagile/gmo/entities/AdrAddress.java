package com.bagile.gmo.entities;

// Generated 8 mars 2015 01:55:29 by Hibernate Tools 4.3.1

import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.Max;
import javax.validation.constraints.Size;
import java.util.Date;

@Entity
@Table(name = "adr_address")
public class AdrAddress extends EmsEntity implements java.io.Serializable {

    private static final long serialVersionUID = 4952125416242393842L;
    private Long adrAddressId;

    private OwnOwner ownOwner;

    @Size(max = 100)
    private String adrAddressCode;

    @Size(max = 200)
    private String adrAddressName;

    @Size(max = 20)
    private String adrAddressContactTel;


    private String adrAddressLine1;


    private String adrAdressLine2;

    @Size(max = 10)
    private String adrAddressZip;

    @Size(max = 200)
    private String adrAddressCity;

    private PrmVille prmVille;

    @Size(max = 200)
    private String adrAddressState;

    @Size(max = 200)
    private String adrAddressCountry;

    private PrmPays prmPays;

    @Size(max = 20)
    private String adrAddressDigiCode;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date adrAddressCreationDate;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date adrAddressUpdateDate;

    @Max(999999999)
    private Long addAddressType; // 2: facture  / 1:  livraison

    private Boolean addAddressDelivery;
    @Size(max = 255)
    private String adrAddressVariable1;
    @Size(max = 255)
    private String adrAddressVariable2;
    @Size(max = 255)
    private String adrAddressVariable3;
    @Size(max = 255)
    private String adrAddressVariable4;
    @Size(max = 255)
    private String adrAddressVariable5;
    @Size(max = 255)
    private String adrAddressVariable6;
    @Size(max = 255)
    private String adrAddressVariable7;
    @Size(max = 255)
    private String adrAddressVariable8;
    @Size(max = 255)
    private String adrAddressVariable9;
    @Size(max = 255)
    private String adrAddressVariable10;

    private String adrAddressAddressTypeTms;
    private TrpTransport trpTransport;
    private Double adrAddressLatitude;
    private Double adrAddressLongitude;

    public AdrAddress() {
    }

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq")
    @SequenceGenerator(name = "seq", sequenceName = "seq_adr_address", allocationSize = 1)
    @Column(name = "adr_addressid", unique = true, nullable = false, precision = 10, scale = 0)
    public Long getAdrAddressId() {
        return this.adrAddressId;
    }

    public void setAdrAddressId(Long adrAddressId) {
        this.adrAddressId = adrAddressId;
    }

    @Column(name = "add_addresstype", precision = 10, scale = 0)
    public Long getAddAddressType() {
        return addAddressType;
    }

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "adr_addressownerid")
    public OwnOwner getOwnOwner() {
        return this.ownOwner;
    }

    public void setOwnOwner(OwnOwner ownOwner) {
        this.ownOwner = ownOwner;
    }


    @OneToOne
    @JoinColumn(name = "adr_addresstransportid", referencedColumnName = "trp_transportid")
    public TrpTransport getTrpTransport() {
        return trpTransport;
    }

    public void setTrpTransport(TrpTransport trpTransport) {
        this.trpTransport = trpTransport;
    }

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "adr_addressvilleid")
    public PrmVille getPrmVille() {
        return prmVille;
    }

    public void setPrmVille(PrmVille prmVille) {
        this.prmVille = prmVille;
    }

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "adr_addresspayid")
    public PrmPays getPrmPays() {
        return prmPays;
    }

    public void setPrmPays(PrmPays prmPays) {
        this.prmPays = prmPays;
    }

    @Column(name = "adr_addresscode", length = 30)
    public String getAdrAddressCode() {
        return this.adrAddressCode;
    }

    public void setAdrAddressCode(String adrAddressCode) {
        this.adrAddressCode = adrAddressCode;
    }

    @Column(name = "adr_addressname", length = 200)

    public String getAdrAddressName() {
        return adrAddressName;
    }

    public void setAdrAddressName(String adrAddressName) {
        this.adrAddressName = adrAddressName;
    }

    @Column(name = "adr_addressdelivery")

    public Boolean getAddAddressDelivery() {
        return addAddressDelivery;
    }

    public void setAddAddressDelivery(Boolean addAddressDelivery) {
        this.addAddressDelivery = addAddressDelivery;
    }

    @Column(name = "adr_addresscontacttel", length = 20)
    public String getAdrAddressContactTel() {
        return this.adrAddressContactTel;
    }


    public void setAdrAddressContactTel(String adrAddressContactTel) {
        this.adrAddressContactTel = adrAddressContactTel;
    }

    @Column(name = "adr_addressaddresstypetms", length = 20)
    public String getAdrAddressAddressTypeTms() {
        return adrAddressAddressTypeTms;
    }

    public void setAdrAddressAddressTypeTms(String adrAddressAddressTypeTms) {
        this.adrAddressAddressTypeTms = adrAddressAddressTypeTms;
    }

    //    columnDefinition = "NVARCHAR(MAX)"
    @Column(name = "adr_addressline1")
    public String getAdrAddressLine1() {
        return this.adrAddressLine1;
    }

    public void setAdrAddressLine1(String adrAddressLine1) {
        this.adrAddressLine1 = adrAddressLine1;
    }

    @Column(name = "adr_adressline2")
    public String getAdrAdressLine2() {
        return this.adrAdressLine2;
    }

    public void setAdrAdressLine2(String adrAdressLine2) {
        this.adrAdressLine2 = adrAdressLine2;
    }

    @Column(name = "adr_addresszip", length = 10)
    public String getAdrAddressZip() {
        return this.adrAddressZip;
    }

    public void setAdrAddressZip(String adrAddressZip) {
        this.adrAddressZip = adrAddressZip;
    }

    @Column(name = "adr_addresscity")
    public String getAdrAddressCity() {
        return this.adrAddressCity;
    }

    public void setAdrAddressCity(String adrAddressCity) {
        this.adrAddressCity = adrAddressCity;
    }

    @Column(name = "adr_addressstate")
    public String getAdrAddressState() {
        return this.adrAddressState;
    }

    public void setAdrAddressState(String adrAddressState) {
        this.adrAddressState = adrAddressState;
    }

    @Column(name = "adr_addresscountry")
    public String getAdrAddressCountry() {
        return this.adrAddressCountry;
    }

    public void setAdrAddressCountry(String adrAddressCountry) {
        this.adrAddressCountry = adrAddressCountry;
    }

    @Column(name = "adr_addressdigicode", length = 20)
    public String getAdrAddressDigiCode() {
        return this.adrAddressDigiCode;
    }

    public void setAdrAddressDigiCode(String adrAddressDigiCode) {
        this.adrAddressDigiCode = adrAddressDigiCode;
    }

    @Column(name = "adr_addresslatitude")
    public Double getAdrAddressLatitude() {
        return adrAddressLatitude;
    }

    public void setAdrAddressLatitude(Double adrAddressLatitude) {
        this.adrAddressLatitude = adrAddressLatitude;
    }

    @Column(name = "adr_addresslongitude")
    public Double getAdrAddressLongitude() {
        return adrAddressLongitude;
    }

    public void setAdrAddressLongitude(Double adrAddressLongitude) {
        this.adrAddressLongitude = adrAddressLongitude;
    }

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "adr_addresscreationdate")
    public Date getAdrAddressCreationDate() {
        return this.adrAddressCreationDate;
    }

    public void setAdrAddressCreationDate(Date adrAddressCreationDate) {
        this.adrAddressCreationDate = adrAddressCreationDate;
    }

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "adr_addressupdatedate")
    public Date getAdrAddressUpdateDate() {
        return this.adrAddressUpdateDate;
    }

    public void setAdrAddressUpdateDate(Date adrAddressUpdateDate) {
        this.adrAddressUpdateDate = adrAddressUpdateDate;
    }

    @Column(name = "adr_addressvariable1")
    public String getAdrAddressVariable1() {
        return this.adrAddressVariable1;
    }

    public void setAdrAddressVariable1(String adrAddressVariable1) {
        this.adrAddressVariable1 = adrAddressVariable1;
    }

    @Column(name = "adr_addressvariable2")
    public String getAdrAddressVariable2() {
        return this.adrAddressVariable2;
    }

    public void setAdrAddressVariable2(String adrAddressVariable2) {
        this.adrAddressVariable2 = adrAddressVariable2;
    }

    @Column(name = "adr_addressvariable3")
    public String getAdrAddressVariable3() {
        return this.adrAddressVariable3;
    }

    public void setAdrAddressVariable3(String adrAddressVariable3) {
        this.adrAddressVariable3 = adrAddressVariable3;
    }

    @Column(name = "adr_addressvariable4")
    public String getAdrAddressVariable4() {
        return this.adrAddressVariable4;
    }

    public void setAdrAddressVariable4(String adrAddressVariable4) {
        this.adrAddressVariable4 = adrAddressVariable4;
    }

    @Column(name = "adr_addressvariable5")
    public String getAdrAddressVariable5() {
        return this.adrAddressVariable5;
    }

    public void setAdrAddressVariable5(String adrAddressVariable5) {
        this.adrAddressVariable5 = adrAddressVariable5;
    }

    @Column(name = "adr_addressvariable6")
    public String getAdrAddressVariable6() {
        return this.adrAddressVariable6;
    }

    public void setAdrAddressVariable6(String adrAddressVariable6) {
        this.adrAddressVariable6 = adrAddressVariable6;
    }

    @Column(name = "adr_addressvariable7")
    public String getAdrAddressVariable7() {
        return this.adrAddressVariable7;
    }

    public void setAdrAddressVariable7(String adrAddressVariable7) {
        this.adrAddressVariable7 = adrAddressVariable7;
    }

    @Column(name = "adr_addressvariable8")
    public String getAdrAddressVariable8() {
        return this.adrAddressVariable8;
    }

    public void setAdrAddressVariable8(String adrAddressVariable8) {
        this.adrAddressVariable8 = adrAddressVariable8;
    }

    @Column(name = "adr_addressvariable9")
    public String getAdrAddressVariable9() {
        return this.adrAddressVariable9;
    }

    public void setAdrAddressVariable9(String adrAddressVariable9) {
        this.adrAddressVariable9 = adrAddressVariable9;
    }

    @Column(name = "adr_addressvariable10")
    public String getAdrAddressVariable10() {
        return this.adrAddressVariable10;
    }

    public void setAdrAddressVariable10(String adrAddressVariable10) {
        this.adrAddressVariable10 = adrAddressVariable10;
    }

    public void setAddAddressType(Long addAddressType) {
        this.addAddressType = addAddressType;
    }
}
