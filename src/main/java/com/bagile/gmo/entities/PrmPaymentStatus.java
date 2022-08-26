package com.bagile.gmo.entities;

import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.util.Date;

/**
 * Created by Adil on 2/23/2017.
 */
@Entity
@Table(name = "prm_paymentstatus", uniqueConstraints = @UniqueConstraint(columnNames = "prm_paymentstatuscode"))
public class PrmPaymentStatus extends EmsEntity{
    private Long prmPaymentStatusID;
    @Size(max=30)
    private String prmPaymentStatusCode;
    @Size(max = 255)
    private String prmPaymentStatusDescription;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date prmPaymentStatusCreationDate ;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date prmPaymentStatusUpdateDate ;

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq")
    @SequenceGenerator(name = "seq", sequenceName = "seq_prm_paymentStatus", allocationSize = 1)
    @Column(name = "prm_paymentstatusid", unique = true, nullable = false, precision = 10, scale = 0)
    public Long getPrmPaymentStatusID() {
        return prmPaymentStatusID;
    }

    public void setPrmPaymentStatusID(Long prmPaymentStatusID) {
        this.prmPaymentStatusID = prmPaymentStatusID;
    }

    @Column(name = "prm_paymentstatuscode", unique = true, nullable = false, length = 30)
    public String getPrmPaymentStatusCode() {
        return prmPaymentStatusCode;
    }
    public void setPrmPaymentStatusCode(String prmPaymentStatusCode) {
        this.prmPaymentStatusCode = prmPaymentStatusCode;
    }
    @Column(name = "prm_paymentstatusdescription")
    public String getPrmPaymentStatusDescription() {
        return prmPaymentStatusDescription;
    }


    public void setPrmPaymentStatusDescription(String prmPaymentStatusDescription) {
        this.prmPaymentStatusDescription = prmPaymentStatusDescription;
    }

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "prm_paymentstatuscreationdate")
    public Date getPrmPaymentStatusCreationDate() {
        return prmPaymentStatusCreationDate;
    }

    public void setPrmPaymentStatusCreationDate(Date prmPaymentStatusCreationDate) {
        this.prmPaymentStatusCreationDate = prmPaymentStatusCreationDate;
    }

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "prm_paymentstatusupdatedate")
    public Date getPrmPaymentStatusUpdateDate() {
        return prmPaymentStatusUpdateDate;
    }

    public void setPrmPaymentStatusUpdateDate(Date prmPaymentStatusUpdateDate) {
        this.prmPaymentStatusUpdateDate = prmPaymentStatusUpdateDate;
    }
}
