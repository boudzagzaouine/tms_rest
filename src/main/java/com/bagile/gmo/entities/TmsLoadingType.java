package com.bagile.gmo.entities;

import javax.persistence.*;


@Entity
@Table(name = "tms_lodingtype")
public class TmsLoadingType extends EmsEntity {

	private static final long serialVersionUID = 2773120607426017439L;

	private Long tmsLoadingTypeId;
    private String tmsLoadingTypeCode;
    private String tmsLoadingTypeDescription;
    private OwnOwner ownOwner;

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq")
    @SequenceGenerator(name = "seq", sequenceName = "seq_tms_loading_type_id", allocationSize = 1)
    @Column(name = "tms_loadingtypeid", unique = true, nullable = false, precision = 10, scale = 0)
    public Long getTmsLoadingTypeId() {
        return tmsLoadingTypeId;
    }

    public void setTmsLoadingTypeId(Long tmsLoadingTypeId) {
        this.tmsLoadingTypeId = tmsLoadingTypeId;
    }

    @Column(name = "tms_loadingtypecode", unique = true, nullable = false, length = 90)
    public String getTmsLoadingTypeCode() {
        return tmsLoadingTypeCode;
    }

    public void setTmsLoadingTypeCode(String tmsLoadingTypeCode) {
        this.tmsLoadingTypeCode = tmsLoadingTypeCode;
    }

    @Column(name = "tms_loadingtypedescription")
    public String getTmsLoadingTypeDescription() {
        return tmsLoadingTypeDescription;
    }

    public void setTmsLoadingTypeDescription(String tmsLoadingTypeDescription) {
        this.tmsLoadingTypeDescription = tmsLoadingTypeDescription;
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
