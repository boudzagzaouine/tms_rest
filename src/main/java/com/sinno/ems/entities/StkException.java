package com.sinno.ems.entities;

import javax.persistence.*;

/**
 * Created by adadi on 6/13/2016.
 */
@Entity
@Table(name = "stk_exception")
public class StkException {

    private long stkExceptionId;
    private String stkExceptionName;
    private String stkExceptionDescription;

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq")
    @SequenceGenerator(name = "seq", sequenceName = "seq_stk_exception", allocationSize = 1)
    @Column(name = "stk_exceptionid", unique = true, nullable = false, precision = 10, scale = 0)
    public long getStkExceptionId() {
        return stkExceptionId;
    }

    public void setStkExceptionId(long stkExceptionId) {
        this.stkExceptionId = stkExceptionId;
    }

    @Column(name = "stk_exceptionname")

    public String getStkExceptionName() {
        return stkExceptionName;
    }

    public void setStkExceptionName(String stkExceptionName) {
        this.stkExceptionName = stkExceptionName;
    }

    @Column(name = "stk_exceptiondescription",length = 255)

    public String getStkExceptionDescription() {
        return stkExceptionDescription;
    }

    public void setStkExceptionDescription(String stkExceptionDescription) {
        this.stkExceptionDescription = stkExceptionDescription;
    }
}
