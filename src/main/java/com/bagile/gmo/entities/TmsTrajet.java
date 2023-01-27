package com.bagile.gmo.entities;


import javax.persistence.*;
import java.math.BigDecimal;

@Entity
@Table(name="tms_trajet",
        uniqueConstraints ={@UniqueConstraint
                (columnNames ={
                               "tms_villesournceid","tms_villedistinationid"})})
public class TmsTrajet extends EmsEntity {

    private Long tmsTrajetId;
  private String tmsTrajetCode;
    private PrmPays prmPaysSource;
    private PrmVille tmsVilleSource ;
    private PrmPays prmPaysDestination;
    private PrmVille tmsVilleDestination;

 


 

    private OwnOwner ownOwner;


    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq")
    @SequenceGenerator(name = "seq", sequenceName = "seq_tms_trajet_id", allocationSize = 1)
    @Column(name = "tms_trajetid", unique = true, nullable = false, precision = 10, scale = 0)
    public Long getTmsTrajetId() {
        return tmsTrajetId;
    }

    public void setTmsTrajetId(Long tmsTrajetId) {
        this.tmsTrajetId = tmsTrajetId;
    }

    @Column(name="tms_trajetcode",unique = true,nullable = false)
    public String getTmsTrajetCode() {
        return tmsTrajetCode;
    }

    public void setTmsTrajetCode(String tmsTrajetCode) {
        this.tmsTrajetCode = tmsTrajetCode;
    }

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "tms_payssourceid")
    public PrmPays getPrmPaysSource() {
        return prmPaysSource;
    }

    public void setPrmPaysSource(PrmPays prmPaysSource) {
        this.prmPaysSource = prmPaysSource;
    }

  
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "tms_villesournceid")
    public PrmVille getTmsVilleSource() {
        return tmsVilleSource;
    }

    public void setTmsVilleSource(PrmVille tmsVilleSource) {
        this.tmsVilleSource = tmsVilleSource;
    }

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "tms_paysdestinationid")
    public PrmPays getPrmPaysDestination() {
        return prmPaysDestination;
    }

    public void setPrmPaysDestination(PrmPays prmPaysDestination) {
        this.prmPaysDestination = prmPaysDestination;
    }

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "tms_villedistinationid")
    public PrmVille getTmsVilleDestination() {
        return tmsVilleDestination;
    }

    public void setTmsVilleDestination(PrmVille tmsVilleDestination) {
        this.tmsVilleDestination = tmsVilleDestination;
    }
    
    @ManyToOne()
   @JoinColumn(name="tms_ownownerid")
    public OwnOwner getOwnOwner() {
        return ownOwner;
    }

    public void setOwnOwner(OwnOwner ownOwner) {
        this.ownOwner = ownOwner;
    }





}

