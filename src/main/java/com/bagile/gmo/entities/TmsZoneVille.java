package com.bagile.gmo.entities;

import com.bagile.gmo.dto.Ville;

import javax.persistence.*;
import java.io.Serializable;
@Entity
@Table(name = "tms_zoneville")
public class TmsZoneVille extends EmsEntity implements Serializable {

    private static final long serialVersionUID = 2773120607426017439L;
    private Long zoneVilleId;


    private PrmVille prmVille;


    private  GmoZone gmoZone;

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq")
    @SequenceGenerator(name = "seq", sequenceName = "seq_tms_zoneville_id", allocationSize = 1)
    @Column(name = "tms_zonevilleid", unique = true, nullable = false, precision = 10, scale = 0)
    public Long getZoneVilleId() {
        return zoneVilleId;
    }

    public void setZoneVilleId(Long zoneVilleId) {
        this.zoneVilleId = zoneVilleId;
    }
    @ManyToOne
    @JoinColumn(name = "tms_villeid")
    public PrmVille getPrmVille() {
        return prmVille;
    }

    public void setPrmVille(PrmVille prmVille) {
        this.prmVille = prmVille;
    }

    @ManyToOne
    @JoinColumn(name = "tms_zoneid")
    public GmoZone getGmoZone() {
        return gmoZone;
    }

    public void setGmoZone(GmoZone gmoZone) {
        this.gmoZone = gmoZone;
    }


}
