package com.bagile.gmo.entities;

import javax.persistence.*;
import javax.validation.constraints.Max;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.math.BigDecimal;
import java.util.HashSet;
import java.util.Set;

/**
 * TrpTransport generated by hbm2java
 */
@Entity
@Table(name = "trp_transport", uniqueConstraints = @UniqueConstraint(columnNames = "trp_transportcode"))
public class TrpTransport extends EmsEntity implements java.io.Serializable {

    private Long trpTransportId;

    @Size(max = 30)
    @NotNull
    private String trpTransportCode;
    private String trpTransportName;
    private AdrAddress adrAddress;
    @Size(max = 255)
    private String trpTransportDescription;
    @Max(999999999)
    private BigDecimal trpTransportSiret;
    @Size(max = 255)
    private String trpTransportComment;


    @NotNull
    private Boolean trpTransportIsActive;

    @Size(max = 255)
    private String trpTransportVariable1;
    @Size(max = 255)
    private String trpTransportVariable2;
    @Size(max = 255)
    private String trpTransportVariable3;
    @Size(max = 255)
    private String trpTransportVariable4;
    @Size(max = 255)
    private String trpTransportVariable5;
    @Size(max = 255)
    private String trpTransportVariable6;
    @Size(max = 255)
    private String trpTransportVariable7;
    @Size(max = 255)
    private String trpTransportVariable8;
    @Size(max = 255)
    private String trpTransportVariable9;
    @Size(max = 255)
    private String trpTransportVariable10;

    private Set<GmoTransportCategoryVehicle> gmoTransportCategoryVehicles=new HashSet<>();

    private Set<GmoTurn> gmoTurns=new HashSet<>();

  private OwnOwner ownOwner;

  private Boolean trpTransportGmao;
    public TrpTransport() {
    }

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq")
    @SequenceGenerator(name = "seq", sequenceName = "seq_trp_transport", allocationSize = 1)
    @Column(name = "trp_transportid", unique = true, nullable = false, precision = 10, scale = 0)
    public Long getTrpTransportId() {
        return this.trpTransportId;
    }

    public void setTrpTransportId(Long trpTransportId) {
        this.trpTransportId = trpTransportId;
    }


    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "trp_transportaddressid", nullable = false)
    public AdrAddress getAdrAddress() {
        return adrAddress;
    }

    public void setAdrAddress(AdrAddress adrAddress) {
        this.adrAddress = adrAddress;
    }

    @Column(name = "trp_transportisactive", nullable = false)
    public Boolean getTrpTransportIsActive() {
        return trpTransportIsActive;
    }
    public void setTrpTransportIsActive(Boolean trpTransportIsActive) {
        this.trpTransportIsActive = trpTransportIsActive;
    }

    @Column(name = "trp_transportcode", unique = true, nullable = false, length = 30)
    public String getTrpTransportCode() {
        return this.trpTransportCode;
    }

    public void setTrpTransportCode(String trpTransportCode) {
        this.trpTransportCode = trpTransportCode;
    }

    @Column(name = "trp_transportdescription")
    public String getTrpTransportDescription() {
        return this.trpTransportDescription;
    }

    public void setTrpTransportDescription(String trpTransportDescription) {
        this.trpTransportDescription = trpTransportDescription;
    }

    @Column(name = "trp_transportsiret", precision = 20, scale = 0)
    public BigDecimal getTrpTransportSiret() {
        return this.trpTransportSiret;
    }

    public void setTrpTransportSiret(BigDecimal trpTransportSiret) {
        this.trpTransportSiret = trpTransportSiret;
    }

    @Column(name = "trp_transportcomment")
    public String getTrpTransportComment() {
        return this.trpTransportComment;
    }

    public void setTrpTransportComment(String trpTransportComment) {
        this.trpTransportComment = trpTransportComment;
    }


    @Column(name = "trp_transportgmao")
    public Boolean getTrpTransportGmao() {
        return trpTransportGmao;
    }

    public void setTrpTransportGmao(Boolean trpTransportGmao) {
        this.trpTransportGmao = trpTransportGmao;
    }

    @Column(name = "trp_transportvariable1")
    public String getTrpTransportVariable1() {
        return this.trpTransportVariable1;
    }

    public void setTrpTransportVariable1(String trpTransportVariable1) {
        this.trpTransportVariable1 = trpTransportVariable1;
    }

    @Column(name = "trp_transportvariable2")
    public String getTrpTransportVariable2() {
        return this.trpTransportVariable2;
    }

    public void setTrpTransportVariable2(String trpTransportVariable2) {
        this.trpTransportVariable2 = trpTransportVariable2;
    }

    @Column(name = "trp_transportvariable3")
    public String getTrpTransportVariable3() {
        return this.trpTransportVariable3;
    }

    public void setTrpTransportVariable3(String trpTransportVariable3) {
        this.trpTransportVariable3 = trpTransportVariable3;
    }

    @Column(name = "trp_transportvariable4")
    public String getTrpTransportVariable4() {
        return this.trpTransportVariable4;
    }

    public void setTrpTransportVariable4(String trpTransportVariable4) {
        this.trpTransportVariable4 = trpTransportVariable4;
    }

    @Column(name = "trp_transportvariable5")
    public String getTrpTransportVariable5() {
        return this.trpTransportVariable5;
    }

    public void setTrpTransportVariable5(String trpTransportVariable5) {
        this.trpTransportVariable5 = trpTransportVariable5;
    }

    @Column(name = "trp_transportvariable6")
    public String getTrpTransportVariable6() {
        return this.trpTransportVariable6;
    }

    public void setTrpTransportVariable6(String trpTransportVariable6) {
        this.trpTransportVariable6 = trpTransportVariable6;
    }

    @Column(name = "trp_transportvariable7")
    public String getTrpTransportVariable7() {
        return this.trpTransportVariable7;
    }

    public void setTrpTransportVariable7(String trpTransportVariable7) {
        this.trpTransportVariable7 = trpTransportVariable7;
    }

    @Column(name = "trp_transportvariable8")
    public String getTrpTransportVariable8() {
        return this.trpTransportVariable8;
    }

    public void setTrpTransportVariable8(String trpTransportVariable8) {
        this.trpTransportVariable8 = trpTransportVariable8;
    }

    @Column(name = "trp_transportvariable9")
    public String getTrpTransportVariable9() {
        return this.trpTransportVariable9;
    }

    public void setTrpTransportVariable9(String trpTransportVariable9) {
        this.trpTransportVariable9 = trpTransportVariable9;
    }

    @Column(name = "trp_transportvariable10")
    public String getTrpTransportVariable10() {
        return this.trpTransportVariable10;
    }

    public void setTrpTransportVariable10(String trpTransportVariable10) {
        this.trpTransportVariable10 = trpTransportVariable10;
    }

    @Column(name = "trp_transportname")
    public String getTrpTransportName() {
        return trpTransportName;
    }

    public void setTrpTransportName(String trpTransportName) {
        this.trpTransportName = trpTransportName;
    }

    @OneToMany(mappedBy = "trpTransport",cascade = CascadeType.ALL,orphanRemoval = true,fetch = FetchType.LAZY)
    public Set<GmoTransportCategoryVehicle> getGmoTransportCategoryVehicles() {
        return gmoTransportCategoryVehicles;
    }

    public void setGmoTransportCategoryVehicles(Set<GmoTransportCategoryVehicle> gmoTransportCategoryVehicles) {
        this.gmoTransportCategoryVehicles = gmoTransportCategoryVehicles;
    }

    @OneToMany(mappedBy = "trpTransport",cascade = CascadeType.ALL,fetch = FetchType.LAZY)
    public Set<GmoTurn> getGmoTurns() {
        return gmoTurns;
    }

    public void setGmoTurns(Set<GmoTurn> gmoTurns) {
        this.gmoTurns = gmoTurns;
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
