package com.bagile.gmo.entities;

import javax.persistence.*;


@Entity
@Table(name = "gmo_actiontype")
public class GmoActionType extends EmsEntity {

	private static final long serialVersionUID = 2773120607426017439L;

	private long gmoActionTypeId;
    private String gmoActionTypeCode;
    private String gmoActionTypeDescription;

    private OwnOwner ownOwner;

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq")
    @SequenceGenerator(name = "seq", sequenceName = "seq_gmo_action_type_id", allocationSize = 1)
    @Column(name = "gmo_actiontypeid", unique = true, nullable = false, precision = 10, scale = 0)
    public long getGmoActionTypeId() {
        return gmoActionTypeId;
    }

    public void setGmoActionTypeId(long gmoActionTypeId) {
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
}
