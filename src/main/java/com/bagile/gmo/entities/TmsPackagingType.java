package com.bagile.gmo.entities;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;


@Entity
@Table(name = "tms_packagingtype")
public class TmsPackagingType extends EmsEntity {

	private static final long serialVersionUID = 2773120607426017439L;

	private Long tmsPackagingTypeId;
    private String tmsPackagingTypeCode;
    private String tmsPackagingTypeDescription;

    private OwnOwner ownOwner;

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq")
    @SequenceGenerator(name = "seq", sequenceName = "seq_tms_packaging_type_id", allocationSize = 1)
    @Column(name = "tms_packagingtypeid", unique = true, nullable = false, precision = 10, scale = 0)
    public Long getTmsPackagingTypeId() {
        return tmsPackagingTypeId;
    }

    public void setTmsPackagingTypeId(Long tmsPackagingTypeId) {
        this.tmsPackagingTypeId = tmsPackagingTypeId;
    }

    @Column(name = "tms_packagingtypecode", unique = true, nullable = false, length = 90)
    public String getTmsPackagingTypeCode() {
        return tmsPackagingTypeCode;
    }

    public void setTmsPackagingTypeCode(String tmsPackagingTypeCode) {
        this.tmsPackagingTypeCode = tmsPackagingTypeCode;
    }

    @Column(name = "tms_packagingtypedescription")
    public String getTmsPackagingTypeDescription() {
        return tmsPackagingTypeDescription;
    }

    public void setTmsPackagingTypeDescription(String tmsPackagingTypeDescription) {
        this.tmsPackagingTypeDescription = tmsPackagingTypeDescription;
    }



    @ManyToOne
    @JoinColumn(name = "tms_notificationtypeownowner")
    public OwnOwner getOwnOwner() {
        return ownOwner;
    }

    public void setOwnOwner(OwnOwner ownOwner) {
        this.ownOwner = ownOwner;
    }

   
}
