package com.bagile.gmo.entities;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;


@Entity
@Table(name = "gmo_actiontype")
public class GmoActionType extends EmsEntity {

	private static final long serialVersionUID = 2773120607426017439L;

	private Long gmoActionTypeId;
    private String gmoActionTypeCode;
    private String gmoActionTypeDescription;
    private Set<GmoActionTypeRepair> gmoActionTypeRepairs = new HashSet<>();

    private OwnOwner ownOwner;

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq")
    @SequenceGenerator(name = "seq", sequenceName = "seq_gmo_action_type_id", allocationSize = 1)
    @Column(name = "gmo_actiontypeid", unique = true, nullable = false, precision = 10, scale = 0)
    public Long getGmoActionTypeId() {
        return gmoActionTypeId;
    }

    public void setGmoActionTypeId(Long gmoActionTypeId) {
        this.gmoActionTypeId = gmoActionTypeId;
    }

    @Column(name = "gmo_actiontypecode", unique = true, nullable = false, length = 90)
    public String getGmoActionTypeCode() {
        return gmoActionTypeCode;
    }

    public void setGmoActionTypeCode(String gmoActionTypeCode) {
        this.gmoActionTypeCode = gmoActionTypeCode;
    }

    @Column(name = "gmo_actiontypedescription")
    public String getGmoActionTypeDescription() {
        return gmoActionTypeDescription;
    }

    public void setGmoActionTypeDescription(String gmoActionTypeDescription) {
        this.gmoActionTypeDescription = gmoActionTypeDescription;
    }



    @ManyToOne
    @JoinColumn(name = "gmo_notificationtypeownowner")
    public OwnOwner getOwnOwner() {
        return ownOwner;
    }

    public void setOwnOwner(OwnOwner ownOwner) {
        this.ownOwner = ownOwner;
    }

    @OneToMany(fetch = FetchType.LAZY,cascade = CascadeType.ALL,mappedBy = "gmoActionType", orphanRemoval=true)
    public Set<GmoActionTypeRepair> getGmoActionTypeRepairs() {
        return gmoActionTypeRepairs;
    }

    public void setGmoActionTypeRepairs(Set<GmoActionTypeRepair> gmoActionTypeRepairs) {
        this.gmoActionTypeRepairs = gmoActionTypeRepairs;
    }
}
