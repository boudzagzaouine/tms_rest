package com.bagile.gmo.entities;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;


@Entity
@Table(name = "tms_servicetype")
public class TmsServiceType extends EmsEntity {

	private static final long serialVersionUID = 2773120607426017439L;

	private Long tmsServiceTypeId;
    private String tmsServiceTypeCode;
    private String tmsServiceTypeDescription;

    private OwnOwner ownOwner;

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq")
    @SequenceGenerator(name = "seq", sequenceName = "seq_tms_service_type_id", allocationSize = 1)
    @Column(name = "tms_servicetypeid", unique = true, nullable = false, precision = 10, scale = 0)
    public Long getTmsServiceTypeId() {
        return tmsServiceTypeId;
    }

    public void setTmsServiceTypeId(Long tmsServiceTypeId) {
        this.tmsServiceTypeId = tmsServiceTypeId;
    }

    @Column(name = "tms_servicetypecode", unique = true, nullable = false, length = 90)
    public String getTmsServiceTypeCode() {
        return tmsServiceTypeCode;
    }

    public void setTmsServiceTypeCode(String tmsServiceTypeCode) {
        this.tmsServiceTypeCode = tmsServiceTypeCode;
    }

    @Column(name = "tms_servicetypedescription")
    public String getTmsServiceTypeDescription() {
        return tmsServiceTypeDescription;
    }

    public void setTmsServiceTypeDescription(String tmsServiceTypeDescription) {
        this.tmsServiceTypeDescription = tmsServiceTypeDescription;
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
