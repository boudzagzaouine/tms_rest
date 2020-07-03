package com.bagile.gmo.entities;

import javax.persistence.*;


@Entity
@Table(name = "gmo_operationtypee")
public class GmoOperationType extends EmsEntity {

	private static final long serialVersionUID = 2773120607426017439L;

	private long gmoOperationTypeId;
    private String gmoOperationTypeCode;
    private String gmoOperationTypeDescription;
    private GmoProgramType gmoProgramType ;


    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq")
    @SequenceGenerator(name = "seq", sequenceName = "seq_gmo_operation_type_id", allocationSize = 1)
    @Column(name = "gmo_operationtypeeid", unique = true, nullable = false, precision = 10, scale = 0)
    public long getGmoOperationTypeId() {
        return gmoOperationTypeId;
    }

    public void setGmoOperationTypeId(long gmoOperationTypeId) {
        this.gmoOperationTypeId = gmoOperationTypeId;
    }

    @Column(name = "gmo_operationtypeecode", unique = true, nullable = false, length = 90)
    public String getGmoOperationTypeCode() {
        return gmoOperationTypeCode;
    }

    public void setGmoOperationTypeCode(String gmoOperationTypeCode) {
        this.gmoOperationTypeCode = gmoOperationTypeCode;
    }

    @Column(name = "gmo_operationtypeedescription")
    public String getGmoOperationTypeDescription() {
        return gmoOperationTypeDescription;
    }

    public void setGmoOperationTypeDescription(String gmoOperationTypeDescription) {
        this.gmoOperationTypeDescription = gmoOperationTypeDescription;
    }

    @ManyToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name = "gmo_programtype")
    public GmoProgramType getGmoProgramType() {
        return gmoProgramType;
    }

    public void setGmoProgramType(GmoProgramType gmoProgramType) {
        this.gmoProgramType = gmoProgramType;
    }
}
