package com.bagile.gmo.entities;

import javax.persistence.*;
import java.util.Date;


@Entity
@Table(name = "gmo_document")
public class GmoDocument extends EmsEntity {

	private static final long serialVersionUID = 2773120607426017439L;

	private Long gmoDocumentId;
    private String gmoDocumentCode;
    private String gmoDocumentDescription;

    private GmoDocumentType gmoDocumentType;
    private byte[] gmoDocumentFile;

    private String gmoDocumentFileType;
    private String gmoDocumentDesignation;
    private Date gmoDocumentDate;

private GmoSinister gmoSinister;


    private OwnOwner ownOwner;

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq")
    @SequenceGenerator(name = "seq", sequenceName = "seq_gmo_document_id", allocationSize = 1)
    @Column(name = "gmo_documentid", unique = true, nullable = false, precision = 10, scale = 0)
    public Long getGmoDocumentId() {
        return gmoDocumentId;
    }

    public void setGmoDocumentId(Long gmoDocumentId) {
        this.gmoDocumentId = gmoDocumentId;
    }

    @Column(name = "gmo_documentcode", nullable = false, length = 90)
    public String getGmoDocumentCode() {
        return gmoDocumentCode;
    }

    public void setGmoDocumentCode(String gmoDocumentCode) {
        this.gmoDocumentCode = gmoDocumentCode;
    }

    @Column(name = "gmo_documentdescription")
    public String getGmoDocumentDescription() {
        return gmoDocumentDescription;
    }

    public void setGmoDocumentDescription(String gmoDocumentDescription) {
        this.gmoDocumentDescription = gmoDocumentDescription;
    }

    @Column(name = "gmo_documentfiletype")
    public String getGmoDocumentFileType() {
        return gmoDocumentFileType;
    }

    public void setGmoDocumentFileType(String gmoDocumentFileType) {
        this.gmoDocumentFileType = gmoDocumentFileType;
    }

    @Column(name = "gmo_documentfile")
    public byte[] getGmoDocumentFile() {
        return gmoDocumentFile;
    }

    public void setGmoDocumentFile(byte[] gmoDocumentFile) {
        this.gmoDocumentFile = gmoDocumentFile;
    }



    @Column(name = "gmo_documentdesignation")
    public String getGmoDocumentDesignation() {
        return gmoDocumentDesignation;
    }

    public void setGmoDocumentDesignation(String gmoDocumentDesignation) {
        this.gmoDocumentDesignation = gmoDocumentDesignation;
    }
    @Column(name = "gmo_documentdate")
    public Date getGmoDocumentDate() {
        return gmoDocumentDate;
    }

    public void setGmoDocumentDate(Date gmoDocumentDate) {
        this.gmoDocumentDate = gmoDocumentDate;
    }

    @ManyToOne()
    @JoinColumn(name="gmo_sinisterid")
    public GmoSinister getGmoSinister() {
        return gmoSinister;
    }

    public void setGmoSinister(GmoSinister gmoSinister) {
        this.gmoSinister = gmoSinister;
    }

    @ManyToOne()
    @JoinColumn(name="gmo_ownownerid")
    public OwnOwner getOwnOwner() {
        return ownOwner;
    }

    public void setOwnOwner(OwnOwner ownOwner) {
        this.ownOwner = ownOwner;
    }

    @ManyToOne()
    @JoinColumn(name="gmo_documenttypeid")
    public GmoDocumentType getGmoDocumentType() {
        return gmoDocumentType;
    }

    public void setGmoDocumentType(GmoDocumentType gmoDocumentType) {
        this.gmoDocumentType = gmoDocumentType;
    }
}
