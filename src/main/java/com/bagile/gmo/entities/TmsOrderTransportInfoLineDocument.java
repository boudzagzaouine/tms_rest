package com.bagile.gmo.entities;

import javax.persistence.*;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;


@Entity
@Table(name = "tms_ordertransportinfolinedocument")
public class TmsOrderTransportInfoLineDocument extends EmsEntity {

	private static final long serialVersionUID = 2773120607426017439L;

	private Long tmsOrderTransportInfoLineDocumentId;

    private String tmsOrderTransportInfoLineDocumentContreType  ; // BL ou FACTURE
    private Long tmsOrderTransportInfoLineDocumentType ; // 1 Enlevement . 2 Livraison . 3 Enlevement/Livraison
    private String tmsOrderTransportInfoLineDocumentNumero;
    private  TmsOrderTransportDocumentType tmsOrderTransportInfoLineDocumentDocumentType;

    private byte[] tmsOrderTransportInfoLineDocumentFile;

    private String tmsOrderTransportInfoLineDocumentFileType;
    private String tmsOrderTransportInfoLineDocumentDesignation;
    private Date tmsOrderTransportInfoLineDocumentDate;

   private TmsOrderTransportInfoLine tmsOrderTransportInfoLine;

   private Set<TmsOrderTransportDocument> tmsOrderTransportDocumentSet = new HashSet<>();
  private Long  tmsDocumentStatus;
    private OwnOwner ownOwner;

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq")
    @SequenceGenerator(name = "seq", sequenceName = "seq_tms_ordertransportinfolineordertransportinfolinedocument_id", allocationSize = 1)
    @Column(name = "tms_ordertransportinfolinedocumentid", unique = true, nullable = false, precision = 10, scale = 0)
    public Long getTmsOrderTransportInfoLineDocumentId() {
        return tmsOrderTransportInfoLineDocumentId;
    }

    public void setTmsOrderTransportInfoLineDocumentId(Long tmsOrderTransportInfoLineDocumentId) {
        this.tmsOrderTransportInfoLineDocumentId = tmsOrderTransportInfoLineDocumentId;
    }



    @Column(name = "tms_ordertransportinfolinedocumentfiletype")
    public String getTmsOrderTransportInfoLineDocumentFileType() {
        return tmsOrderTransportInfoLineDocumentFileType;
    }

    public void setTmsOrderTransportInfoLineDocumentFileType(String tmsOrderTransportInfoLineDocumentFileType) {
        this.tmsOrderTransportInfoLineDocumentFileType = tmsOrderTransportInfoLineDocumentFileType;
    }

    @Column(name = "tms_ordertransportinfolinedocumentcontretype")

    public String getTmsOrderTransportInfoLineDocumentContreType() {
        return tmsOrderTransportInfoLineDocumentContreType;
    }

    public void setTmsOrderTransportInfoLineDocumentContreType(String tmsOrderTransportInfoLineDocumentContreType) {
        this.tmsOrderTransportInfoLineDocumentContreType = tmsOrderTransportInfoLineDocumentContreType;
    }
    @Column(name = "tms_ordertransportinfolinedocumenttype")

    public Long getTmsOrderTransportInfoLineDocumentType() {
        return tmsOrderTransportInfoLineDocumentType;
    }

    public void setTmsOrderTransportInfoLineDocumentType(Long tmsOrderTransportInfoLineDocumentType) {
        this.tmsOrderTransportInfoLineDocumentType = tmsOrderTransportInfoLineDocumentType;
    }

    @Column(name = "tms_ordertransportinfolinedocumentnumero")

    public String getTmsOrderTransportInfoLineDocumentNumero() {
        return tmsOrderTransportInfoLineDocumentNumero;
    }

    public void setTmsOrderTransportInfoLineDocumentNumero(String tmsOrderTransportInfoLineDocumentNumero) {
        this.tmsOrderTransportInfoLineDocumentNumero = tmsOrderTransportInfoLineDocumentNumero;
    }

    @Column(name = "tms_ordertransportinfolinedocumentfile")
    public byte[] getTmsOrderTransportInfoLineDocumentFile() {
        return tmsOrderTransportInfoLineDocumentFile;
    }

    public void setTmsOrderTransportInfoLineDocumentFile(byte[] tmsOrderTransportInfoLineDocumentFile) {
        this.tmsOrderTransportInfoLineDocumentFile = tmsOrderTransportInfoLineDocumentFile;
    }

    @Column(name = "tms_ordertransportinfolinedocumentdesignation")
    public String getTmsOrderTransportInfoLineDocumentDesignation() {
        return tmsOrderTransportInfoLineDocumentDesignation;
    }

    public void setTmsOrderTransportInfoLineDocumentDesignation(String tmsOrderTransportInfoLineDocumentDesignation) {
        this.tmsOrderTransportInfoLineDocumentDesignation = tmsOrderTransportInfoLineDocumentDesignation;
    }
    @Column(name = "tms_ordertransportinfolinedocumentdate")
    public Date getTmsOrderTransportInfoLineDocumentDate() {
        return tmsOrderTransportInfoLineDocumentDate;
    }

    public void setTmsOrderTransportInfoLineDocumentDate(Date tmsOrderTransportInfoLineDocumentDate) {
        this.tmsOrderTransportInfoLineDocumentDate = tmsOrderTransportInfoLineDocumentDate;
    }

    @Column(name = "tms_documentstatus")
    public Long getTmsDocumentStatus() {
        return tmsDocumentStatus;
    }
    public void setTmsDocumentStatus(Long tmsDocumentStatus) {
        this.tmsDocumentStatus = tmsDocumentStatus;
    }

    @OneToMany(mappedBy = "tmsOrderTransportInfoLineDocument", cascade = CascadeType.ALL,orphanRemoval = true,fetch = FetchType.LAZY)
    public Set<TmsOrderTransportDocument> getTmsOrderTransportDocumentSet() {
        return tmsOrderTransportDocumentSet;
    }

    public void setTmsOrderTransportDocumentSet(Set<TmsOrderTransportDocument> tmsOrderTransportDocumentSet) {
        this.tmsOrderTransportDocumentSet = tmsOrderTransportDocumentSet;
    }

    @ManyToOne()
    @JoinColumn(name="tms_ordertransportinfolineid")
    public TmsOrderTransportInfoLine getTmsOrderTransportInfoLine() {
        return tmsOrderTransportInfoLine;
    }

    public void setTmsOrderTransportInfoLine(TmsOrderTransportInfoLine tmsOrderTransportInfoLine) {
        this.tmsOrderTransportInfoLine = tmsOrderTransportInfoLine;
    }


    @ManyToOne()
    @JoinColumn(name="tms_ordertransportdocumentdocumenttypeid")
    public TmsOrderTransportDocumentType getTmsOrderTransportInfoLineDocumentDocumentType() {
        return tmsOrderTransportInfoLineDocumentDocumentType;
    }

    public void setTmsOrderTransportInfoLineDocumentDocumentType(TmsOrderTransportDocumentType tmsOrderTransportInfoLineDocumentDocumentType) {
        this.tmsOrderTransportInfoLineDocumentDocumentType = tmsOrderTransportInfoLineDocumentDocumentType;
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
