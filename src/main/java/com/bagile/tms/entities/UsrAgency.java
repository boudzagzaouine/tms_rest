package com.bagile.tms.entities;

import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Date;

/**
 * Created by Enissay on 02/01/2017.
 */
@Entity
@Table(name = "usr_agency")
public class UsrAgency {
    private long usrAgencyId;
    @NotNull
    private String usrAgencyCode;
    private String usrAgencyDescription;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date usrAgencyCreationDate;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date usrAgencyUpdateDate;

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq")
    @SequenceGenerator(name = "seq", sequenceName = "seq_usr_agency", allocationSize = 1)
    @Column(name = "usr_agencyid", unique = true, nullable = false, precision = 10, scale = 0)
    public long getUsrAgencyId() {
        return usrAgencyId;
    }

    public void setUsrAgencyId(long usrAgencyId) {
        this.usrAgencyId = usrAgencyId;
    }

    @Column(name = "usr_agencycode", unique = true, nullable = false, length = 50)
    public String getUsrAgencyCode() {
        return usrAgencyCode;
    }

    public void setUsrAgencyCode(String usrAgencyCode) {
        this.usrAgencyCode = usrAgencyCode;
    }

    @Column(name = "usr_agencydescription", length = 150)
    public String getUsrAgencyDescription() {
        return usrAgencyDescription;
    }

    public void setUsrAgencyDescription(String usrAgencyDescription) {
        this.usrAgencyDescription = usrAgencyDescription;
    }

      @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "usr_agencycreationdate")
    public Date getUsrAgencyCreationDate() {
        return usrAgencyCreationDate;
    }

    public void setUsrAgencyCreationDate(Date usrAgencyCreationDate) {
        this.usrAgencyCreationDate = usrAgencyCreationDate;
    }

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "usr_agencyupdatedate")
    public Date getUsrAgencyUpdateDate() {
        return usrAgencyUpdateDate;
    }

    public void setUsrAgencyUpdateDate(Date usrAgencyUpdateDate) {
        this.usrAgencyUpdateDate = usrAgencyUpdateDate;
    }


}
