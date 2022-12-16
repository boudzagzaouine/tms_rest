package com.bagile.gmo.entities;


import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
@Entity
@Table(name = "prm_ville", uniqueConstraints = {
        @UniqueConstraint(columnNames = {"prm_villecode"})})
public class PrmVille extends EmsEntity implements Serializable {
    private long prmVilleId;
    private String prmVilleCode;
    private String prmVilleDescription;
    private PrmPays prmPays;
    private Date prmVilleCreationDate;
    private Date prmVilleUpdateDate;

    private Double  prmVilleLatitude;
    private Double  prmVilleLongitude;

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq")
    @SequenceGenerator(name = "seq", sequenceName = "seq_prm_ville", allocationSize = 1)
    @Column(name = "prm_villeid", unique = true, nullable = false, precision = 10, scale = 0)
    public long getPrmVilleId() {
        return prmVilleId;
    }

    public void setPrmVilleId(long prmVilleId) {
        this.prmVilleId = prmVilleId;
    }

    @Column(name = "prm_villecode", unique = true, nullable = false)
    public String getPrmVilleCode() {
        return prmVilleCode;
    }

    public void setPrmVilleCode(String prmVilleCode) {
        this.prmVilleCode = prmVilleCode;
    }

    @Column(name = "prm_villedescription")
    public String getPrmVilleDescription() {
        return prmVilleDescription;
    }

    public void setPrmVilleDescription(String prmVilleDescription) {
        this.prmVilleDescription = prmVilleDescription;
    }

    @Column(name = "prm_villelatitude")
    public Double getPrmVilleLatitude() {
        return prmVilleLatitude;
    }

    public void setPrmVilleLatitude(Double prmVilleLatitude) {
        this.prmVilleLatitude = prmVilleLatitude;
    }
    @Column(name = "prm_villelongtitude")
    public Double getPrmVilleLongitude() {
        return prmVilleLongitude;
    }

    public void setPrmVilleLongitude(Double prmVilleLongitude) {
        this.prmVilleLongitude = prmVilleLongitude;
    }

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "prm_villepaysid")
    public PrmPays getPrmPays() {
        return prmPays;
    }

    public void setPrmPays(PrmPays prmPays) {
        this.prmPays = prmPays;
    }

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "prm_villecreationdate")
    public Date getPrmVilleCreationDate() {
        return prmVilleCreationDate;
    }

    public void setPrmVilleCreationDate(Date prmVilleCreationDate) {
        this.prmVilleCreationDate = prmVilleCreationDate;
    }

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "prm_villeupdatedate")
    public Date getPrmVilleUpdateDate() {
        return prmVilleUpdateDate;
    }

    public void setPrmVilleUpdateDate(Date prmVilleUpdateDate) {
        this.prmVilleUpdateDate = prmVilleUpdateDate;
    }
}
