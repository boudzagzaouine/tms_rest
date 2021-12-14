package com.bagile.gmo.entities;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name="tms_turn")
public class TmsTurn extends EmsEntity {

    private Long tmsTurnId;
    private String tmsTurnCode;
   // private Set<GmoDriver> gmoDrivers =new HashSet<>();
  //  private GmoVehicle gmoVehicle;
 //  private TrpTransport trpTransport;
    private Date dateDelivery ;
    private Set<TmsTurnSoPo> tmsTurnSoPos = new HashSet<>();
    private Set<TmsTurnTransport> tmsTurnTransports = new HashSet<>();

    private TmsTurnType tmsTurnType;

    private BigDecimal tmsTurnTotalSoTTC;
    private BigDecimal tmsTurnTotalPoTTC;
    private BigDecimal tmsTurnTotalSoQnt;
    private BigDecimal tmsTurnTotalPoQnt ;
    private BigDecimal tmsTurnTotalSoPriceTurn ;
    private BigDecimal tmsTurnTotalPoPriceTurn;
    private String tmsTurnPackagingType;

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq")
    @SequenceGenerator(name = "seq", sequenceName = "seq_tms_turn_id", allocationSize = 1)
    @Column(name = "tms_turnid", unique = true, nullable = false, precision = 10, scale = 0)
    public Long getTmsTurnId() {
        return tmsTurnId;
    }

    public void setTmsTurnId(Long tmsTurnId) {
        this.tmsTurnId = tmsTurnId;
    }

  /*  @ManyToMany
    @JoinTable(
            name = "tms_tour_driver",
            joinColumns = @JoinColumn(name = "tms_tour_id"),
            inverseJoinColumns = @JoinColumn(name = "tms_driver_id"))
    public Set<GmoDriver> getGmoDrivers() {
        return gmoDrivers;
    }*/

   /* public void setGmoDrivers(Set<GmoDriver> tmsDrivers) {
        this.gmoDrivers = tmsDrivers;
    }

    @ManyToOne()
    @JoinColumn(name = "tms_turnvehicleid")
    public GmoVehicle getGmoVehicle() {
        return gmoVehicle;
    }

    public void setGmoVehicle(GmoVehicle tmsVehicle) {
        this.gmoVehicle = tmsVehicle;
    }

    @ManyToOne()
    @JoinColumn(name = "tms_turntransportid")
    public TrpTransport getTrpTransport() {
        return trpTransport;
    }

    public void setTrpTransport(TrpTransport trpTransport) {
        this.trpTransport = trpTransport;
    }*/

    @ManyToOne()
    @JoinColumn(name = "tms_turnTypeid")
    public TmsTurnType getTmsTurnType() {
        return tmsTurnType;
    }

    public void setTmsTurnType(TmsTurnType tmsTurnType) {
        this.tmsTurnType = tmsTurnType;
    }

    @Column(name = "tms_turndate")
    public Date getDateDelivery() {
        return dateDelivery;
    }

    public void setDateDelivery(Date dateDelivery) {
        this.dateDelivery = dateDelivery;
    }




    @Column(name = "tms_turnpackagingtype")
    public String getTmsTurnPackagingType() {
        return tmsTurnPackagingType;
    }

    public void setTmsTurnPackagingType(String tmsTurnPackagingType) {
        this.tmsTurnPackagingType = tmsTurnPackagingType;
    }

    @Column(name = "tms_turncode")
    public String getTmsTurnCode() {
        return tmsTurnCode;
    }

    public void setTmsTurnCode(String tmsTurnCode) {
        this.tmsTurnCode = tmsTurnCode;
    }

    @OneToMany(mappedBy = "tmsTurn")
    public Set<TmsTurnSoPo> getTmsTurnSoPos() {
        return tmsTurnSoPos;
    }

    public void setTmsTurnSoPos(Set<TmsTurnSoPo> tmsTurnSoPos) {
        this.tmsTurnSoPos = tmsTurnSoPos;
    }

    @OneToMany(mappedBy = "tmsTurnn")
    public Set<TmsTurnTransport> getTmsTurnTransports() {
        return tmsTurnTransports;
    }

    public void setTmsTurnTransports(Set<TmsTurnTransport> tmsTurnTransports) {
        this.tmsTurnTransports = tmsTurnTransports;
    }

    @Column(name = "tms_turntotalsottc")
    public BigDecimal getTmsTurnTotalSoTTC() {
        return tmsTurnTotalSoTTC;
    }

    public void setTmsTurnTotalSoTTC(BigDecimal tmsTurnTotalSoTTC) {
        this.tmsTurnTotalSoTTC = tmsTurnTotalSoTTC;
    }

    @Column(name = "tms_turntotalpottc")
    public BigDecimal getTmsTurnTotalPoTTC() {
        return tmsTurnTotalPoTTC;
    }

    public void setTmsTurnTotalPoTTC(BigDecimal tmsTurnTotalPoTTC) {
        this.tmsTurnTotalPoTTC = tmsTurnTotalPoTTC;
    }

    @Column(name = "tms_turntotalsoqnt")
    public BigDecimal getTmsTurnTotalSoQnt() {
        return tmsTurnTotalSoQnt;
    }

    public void setTmsTurnTotalSoQnt(BigDecimal tmsTurnTotalSoQnt) {
        this.tmsTurnTotalSoQnt = tmsTurnTotalSoQnt;
    }

    @Column(name = "tms_turntotalpoqnt")
    public BigDecimal getTmsTurnTotalPoQnt() {
        return tmsTurnTotalPoQnt;
    }

    public void setTmsTurnTotalPoQnt(BigDecimal tmsTurnTotalPoQnt) {
        this.tmsTurnTotalPoQnt = tmsTurnTotalPoQnt;
    }

    @Column(name = "tms_turntotalsopriceturn")
    public BigDecimal getTmsTurnTotalSoPriceTurn() {
        return tmsTurnTotalSoPriceTurn;
    }

    public void setTmsTurnTotalSoPriceTurn(BigDecimal tmsTurnTotalSoPriceTurn) {
        this.tmsTurnTotalSoPriceTurn = tmsTurnTotalSoPriceTurn;
    }

    @Column(name = "tms_turntotalpopriceturn")
    public BigDecimal getTmsTurnTotalPoPriceTurn() {
        return tmsTurnTotalPoPriceTurn;
    }

    public void setTmsTurnTotalPoPriceTurn(BigDecimal tmsTurnTotalPoPriceTurn) {
        this.tmsTurnTotalPoPriceTurn = tmsTurnTotalPoPriceTurn;
    }
}
