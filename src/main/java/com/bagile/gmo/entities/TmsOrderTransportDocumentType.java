package com.bagile.gmo.entities;

import javax.persistence.*;

@Entity
@Table(name = "tms_ordertransportdocumenttype")
public class TmsOrderTransportDocumentType extends EmsEntity{
    private static final long serialVersionUID = 2773120607426017439L;
    private Long tmsOrderTransportDocumentTypeId;
    private String tmsOrderTransportDocumentTypeCode;
    private String tmsOrderTransportDocumentTypeDescription;



    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq")
    @SequenceGenerator(name = "seq", sequenceName = "seq_tms_ordertransportdocumenttype_id", allocationSize = 1)
    @Column(name = "tms_ordertransportdocumenttypeid", unique = true, nullable = false, precision = 10, scale = 0)
    public Long getTmsOrderTransportDocumentTypeId() {
        return tmsOrderTransportDocumentTypeId;
    }

    public void setTmsOrderTransportDocumentTypeId(Long tmsOrderTransportDocumentTypeId) {
        this.tmsOrderTransportDocumentTypeId = tmsOrderTransportDocumentTypeId;
    }



    @Column(name = "tms_ordertransportdocumenttypecode")
    public String getTmsOrderTransportDocumentTypeCode() {
        return tmsOrderTransportDocumentTypeCode;
    }

    public void setTmsOrderTransportDocumentTypeCode(String tmsOrderTransportDocumentTypeCode) {
        this.tmsOrderTransportDocumentTypeCode = tmsOrderTransportDocumentTypeCode;
    }

    @Column(name = "tms_ordertransportdocumenttypedescription")
    public String getTmsOrderTransportDocumentTypeDescription() {
        return tmsOrderTransportDocumentTypeDescription;
    }

    public void setTmsOrderTransportDocumentTypeDescription(String tmsOrderTransportDocumentTypeDescription) {
        this.tmsOrderTransportDocumentTypeDescription = tmsOrderTransportDocumentTypeDescription;
    }
}
