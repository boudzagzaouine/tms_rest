package com.bagile.gmo.entities;


import javax.persistence.*;


@Entity
@Table(name = "tms_marchandisetype")
public class TmsMarchandiseType extends EmsEntity {

	private static final long serialVersionUID = 2773120607426017439L;

	private Long tmsMarchandiseTypeId;
    private String tmsMarchandiseTypeCode;
    private String tmsMarchandiseTypeDescription;

    private OwnOwner ownOwner;

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq")
    @SequenceGenerator(name = "seq", sequenceName = "seq_tms_marchandise_type_id", allocationSize = 1)
    @Column(name = "tms_marchandisetypeid", unique = true, nullable = false, precision = 10, scale = 0)
    public Long getTmsMarchandiseTypeId() {
        return tmsMarchandiseTypeId;
    }

    public void setTmsMarchandiseTypeId(Long tmsMarchandiseTypeId) {
        this.tmsMarchandiseTypeId = tmsMarchandiseTypeId;
    }

    @Column(name = "tms_marchandisetypecode", unique = true, nullable = false, length = 90)
    public String getTmsMarchandiseTypeCode() {
        return tmsMarchandiseTypeCode;
    }

    public void setTmsMarchandiseTypeCode(String tmsMarchandiseTypeCode) {
        this.tmsMarchandiseTypeCode = tmsMarchandiseTypeCode;
    }

    @Column(name = "tms_marchandisetypedescription")
    public String getTmsMarchandiseTypeDescription() {
        return tmsMarchandiseTypeDescription;
    }

    public void setTmsMarchandiseTypeDescription(String tmsMarchandiseTypeDescription) {
        this.tmsMarchandiseTypeDescription = tmsMarchandiseTypeDescription;
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
