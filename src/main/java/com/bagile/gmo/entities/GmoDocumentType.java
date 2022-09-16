package com.bagile.gmo.entities;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;


@Entity
@Table(name = "gmo_documenttype")
public class GmoDocumentType extends EmsEntity {

	private static final long serialVersionUID = 2773120607426017439L;

	private Long gmoDocumentTypeId;
    private String gmoDocumentTypeCode;
    private String gmoDocumentTypeDescription;
    private OwnOwner ownOwner;

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq")
    @SequenceGenerator(name = "seq", sequenceName = "seq_gmo_document_type_id", allocationSize = 1)
    @Column(name = "gmo_documenttypeid", unique = true, nullable = false, precision = 10, scale = 0)
    public Long getGmoDocumentTypeId() {
        return gmoDocumentTypeId;
    }

    public void setGmoDocumentTypeId(Long gmoDocumentTypeId) {
        this.gmoDocumentTypeId = gmoDocumentTypeId;
    }

    @Column(name = "gmo_documenttypecode", unique = true, nullable = false, length = 90)
    public String getGmoDocumentTypeCode() {
        return gmoDocumentTypeCode;
    }

    public void setGmoDocumentTypeCode(String gmoDocumentTypeCode) {
        this.gmoDocumentTypeCode = gmoDocumentTypeCode;
    }

    @Column(name = "gmo_documenttypedescription")
    public String getGmoDocumentTypeDescription() {
        return gmoDocumentTypeDescription;
    }

    public void setGmoDocumentTypeDescription(String gmoDocumentTypeDescription) {
        this.gmoDocumentTypeDescription = gmoDocumentTypeDescription;
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
