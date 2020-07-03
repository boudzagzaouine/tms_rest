package com.bagile.gmo.entities;

import javax.persistence.*;


@Entity
@Table(name = "gmo_periodicitytype")
public class GmoPeriodicityType extends EmsEntity {

	private static final long serialVersionUID = 2773120607426017439L;

	private long gmoPeriodicityTypeId;
    private String gmoPeriodicityTypeCode;
    private String gmoPeriodicityTypeDescription;


    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq")
    @SequenceGenerator(name = "seq", sequenceName = "seq_gmo_periodicitytype_id", allocationSize = 1)
    @Column(name = "gmo_periodicitytypeid", unique = true, nullable = false, precision = 10, scale = 0)
    public long getGmoPeriodicityTypeId() {
        return gmoPeriodicityTypeId;
    }

    public void setGmoPeriodicityTypeId(long gmoPeriodicityTypeId) {
        this.gmoPeriodicityTypeId = gmoPeriodicityTypeId;
    }

    @Column(name = "gmo_periodicitytypecode", unique = true, nullable = false, length = 90)
    public String getGmoPeriodicityTypeCode() {
        return gmoPeriodicityTypeCode;
    }

    public void setGmoPeriodicityTypeCode(String gmoPeriodicityTypeCode) {
        this.gmoPeriodicityTypeCode = gmoPeriodicityTypeCode;
    }

    @Column(name = "gmo_periodicitytypedescription")
    public String getGmoPeriodicityTypeDescription() {
        return gmoPeriodicityTypeDescription;
    }

    public void setGmoPeriodicityTypeDescription(String gmoPeriodicityTypeDescription) {
        this.gmoPeriodicityTypeDescription = gmoPeriodicityTypeDescription;
    }

  
}
