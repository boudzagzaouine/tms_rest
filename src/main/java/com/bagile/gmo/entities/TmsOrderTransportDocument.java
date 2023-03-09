package com.bagile.gmo.entities;

import javax.persistence.*;

@Entity
@Table(name = "tms_ordertransportdocument")
public class TmsOrderTransportDocument extends EmsEntity{
    private static final long serialVersionUID = 2773120607426017439L;
    private Long tmsOrderTransportDocumentId;
    private byte[] tmsOrderTransportDocumentFile;
    private String tmsOrderTransportDocumentFileType;
    private String tmsOrderTransportDocumentFileName;
   private TmsOrderTransportInfoLineDocument tmsOrderTransportInfoLineDocument;



    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq")
    @SequenceGenerator(name = "seq", sequenceName = "seq_tms_ordertransportdocument_id", allocationSize = 1)
    @Column(name = "tms_ordertransportdocumentid", unique = true, nullable = false, precision = 10, scale = 0)
    public Long getTmsOrderDocumentId() {
        return tmsOrderTransportDocumentId;
    }

    public void setTmsOrderDocumentId(Long tmsOrderTransportDocumentId) {
        this.tmsOrderTransportDocumentId = tmsOrderTransportDocumentId;
    }

    @Column(name = "tms_ordertransportdocumentfilename")
    public String getTmsOrderDocumentFileName() {
        return tmsOrderTransportDocumentFileName;
    }

    public void setTmsOrderDocumentFileName(String tmsOrderTransportDocumentFileName) {
        this.tmsOrderTransportDocumentFileName = tmsOrderTransportDocumentFileName;
    }

    @Column(name = "tms_ordertransportdocumentfiletype")
    public String getTmsOrderDocumentFileType() {
        return tmsOrderTransportDocumentFileType;
    }

    public void setTmsOrderDocumentFileType(String tmsOrderTransportDocumentFileType) {
        this.tmsOrderTransportDocumentFileType = tmsOrderTransportDocumentFileType;
    }

    @Column(name = "tms_ordertransportdocumentfile")
    public byte[] getTmsOrderDocumentFile() {
        return tmsOrderTransportDocumentFile;
    }

    public void setTmsOrderDocumentFile(byte[] tmsOrderTransportDocumentFile) {
        this.tmsOrderTransportDocumentFile = tmsOrderTransportDocumentFile;
    }
    @ManyToOne()
    @JoinColumn(name="tms_ordertransportinfolinedocumentid")
    public TmsOrderTransportInfoLineDocument getTmsOrderTransportInfoLineDocument() {
        return tmsOrderTransportInfoLineDocument;
    }

    public void setTmsOrderTransportInfoLineDocument(TmsOrderTransportInfoLineDocument tmsOrderTransportInfoLineDocument) {
        this.tmsOrderTransportInfoLineDocument = tmsOrderTransportInfoLineDocument;
    }

}
