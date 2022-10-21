package com.bagile.gmo.entities;

import com.bagile.gmo.dto.PackagingType;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name="tms_orderdelivery")
public class TmsOrderDelivery extends EmsEntity {

    private Long tmsOrderDeliveryId;
    private String tmsOrderDeliveryCode;

    private Date dateDelivery ;


    private TmsTurnType tmsOrderDeliveryType;
    private String  tmsOrderDeliveryLoadingType;

    private CmdAccount cmdAccount;

   private TmsDeliveryInfo tmsDeliveryInfoAller;
   private   TmsDeliveryInfo tmsDeliveryInfoRetour;
    private TmsTurnStatus tmsTurnStatus;




    private Set<TmsOrderDeliveryTransport> tmsOrderDeliveryTransports = new HashSet<>();





    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq")
    @SequenceGenerator(name = "seq", sequenceName = "seq_tms_orderdelivery_id", allocationSize = 1)
    @Column(name = "tms_orderdeliveryid", unique = true, nullable = false, precision = 10, scale = 0)
    public Long getTmsOrderDeliveryId() {
        return tmsOrderDeliveryId;
    }

    public void setTmsOrderDeliveryId(Long tmsOrderDeliveryId) {
        this.tmsOrderDeliveryId = tmsOrderDeliveryId;
    }

    @Column(name = "tms_orderdeliverycode",nullable = false)
    public String getTmsOrderDeliveryCode() {
        return tmsOrderDeliveryCode;
    }

    public void setTmsOrderDeliveryCode(String tmsOrderDeliveryCode) {
        this.tmsOrderDeliveryCode = tmsOrderDeliveryCode;
    }

    @Column(name="tms_orderdeliverydate")
    public Date getDateDelivery() {
        return dateDelivery;
    }

    public void setDateDelivery(Date dateDelivery) {
        this.dateDelivery = dateDelivery;
    }


    @OneToMany(mappedBy = "tmsOrderDelivery",cascade = CascadeType.ALL,orphanRemoval = true,fetch = FetchType.LAZY)
    public Set<TmsOrderDeliveryTransport> getTmsOrderDeliveryTransports() {
        return tmsOrderDeliveryTransports;
    }

    public void setTmsOrderDeliveryTransports(Set<TmsOrderDeliveryTransport> tmsOrderDeliveryTransports) {
        this.tmsOrderDeliveryTransports = tmsOrderDeliveryTransports;
    }

    @ManyToOne()
 @JoinColumn(name = "tms_orderdeliveryType")
    public TmsTurnType getTmsOrderDeliveryType() {
        return tmsOrderDeliveryType;
    }

    public void setTmsOrderDeliveryType(TmsTurnType tmsOrderDeliveryType) {
        this.tmsOrderDeliveryType = tmsOrderDeliveryType;
    }



    @ManyToOne(fetch = FetchType.LAZY,cascade = CascadeType.MERGE)
    @JoinColumn(name = "tms_orderdeliverydeliveryinfoaller")
    public TmsDeliveryInfo getTmsDeliveryInfoAller() {
        return tmsDeliveryInfoAller;
    }

    public void setTmsDeliveryInfoAller(TmsDeliveryInfo tmsDeliveryInfoAller) {
        this.tmsDeliveryInfoAller = tmsDeliveryInfoAller;
    }
    @ManyToOne(fetch = FetchType.LAZY,cascade = CascadeType.MERGE)
    @JoinColumn(name = "tms_orderdeliverydeliveryinforetour")
    public TmsDeliveryInfo getTmsDeliveryInfoRetour() {
        return tmsDeliveryInfoRetour;
    }

    public void setTmsDeliveryInfoRetour(TmsDeliveryInfo tmsDeliveryInfoRetour) {
        this.tmsDeliveryInfoRetour = tmsDeliveryInfoRetour;
    }

    @ManyToOne()
    @JoinColumn(name = "tms_turnstatusid")
    public TmsTurnStatus getTmsTurnStatus() {
        return tmsTurnStatus;
    }

    public void setTmsTurnStatus(TmsTurnStatus tmsTurnStatus) {
        this.tmsTurnStatus = tmsTurnStatus;
    }

    @Column(name="tms_orderdeliveryloadingtype")
    public String getTmsOrderDeliveryLoadingType() {
        return tmsOrderDeliveryLoadingType;
    }

    public void setTmsOrderDeliveryLoadingType(String tmsOrderDeliveryLoadingType) {
        this.tmsOrderDeliveryLoadingType = tmsOrderDeliveryLoadingType;
    }



    @ManyToOne()
    @JoinColumn(name = "cmd_accountid")
    public CmdAccount getCmdAccount() {
        return cmdAccount;
    }

    public void setCmdAccount(CmdAccount cmdAccount) {
        this.cmdAccount = cmdAccount;
    }









}
