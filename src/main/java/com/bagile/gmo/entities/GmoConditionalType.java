package com.bagile.gmo.entities;

import javax.persistence.*;


@Entity
@Table(name = "gmo_conditionaltype")
public class GmoConditionalType extends EmsEntity {

	private static final long serialVersionUID = 2773120607426017439L;

	private Long gmoConditionalTypeId;
    private String gmoConditionalTypeCode;
    private String gmoConditionalTypeDescription;
    private OwnOwner ownOwner;

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq")
    @SequenceGenerator(name = "seq", sequenceName = "seq_gmo_conditional_type_id", allocationSize = 1)
    @Column(name = "gmo_conditionaltypeid", unique = true, nullable = false, precision = 10, scale = 0)
    public Long getGmoConditionalTypeId() {
        return gmoConditionalTypeId;
    }

    public void setGmoConditionalTypeId(Long gmoConditionalTypeId) {
        this.gmoConditionalTypeId = gmoConditionalTypeId;
    }

    @Column(name = "gmo_conditionaltypecode", unique = true, nullable = false, length = 90)
    public String getGmoConditionalTypeCode() {
        return gmoConditionalTypeCode;
    }

    public void setGmoConditionalTypeCode(String gmoConditionalTypeCode) {
        this.gmoConditionalTypeCode = gmoConditionalTypeCode;
    }

    @Column(name = "gmo_conditionaltypedescription")
    public String getGmoConditionalTypeDescription() {
        return gmoConditionalTypeDescription;
    }

    public void setGmoConditionalTypeDescription(String gmoConditionalTypeDescription) {
        this.gmoConditionalTypeDescription = gmoConditionalTypeDescription;
    }

    @ManyToOne()
    @JoinColumn(name="gmo_ownownerid")
    public OwnOwner getOwnOwner() {
        return ownOwner;
    }

    public void setOwnOwner(OwnOwner ownOwner) {
        this.ownOwner = ownOwner;
    }
}
