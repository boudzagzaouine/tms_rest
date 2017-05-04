package com.sinno.ems.entities;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

/**
 * Created by Enissay on 03/01/2017.
 */
@Entity
@Table(name = "usr_useragency")
public class UsrUserAgency {

    private long usrUserAgencyId;
    @NotNull
    private UsrAgency usrAgency;
    @NotNull
    private UsrUser usrUser;

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq")
    @SequenceGenerator(name = "seq", sequenceName = "usr_user_agency_seq", allocationSize = 1)
    @Column(name = "usr_useragencyid", unique = true, nullable = false, precision = 10, scale = 0)
    public long getUsrUserAgencyId() {
        return usrUserAgencyId;
    }

    public void setUsrUserAgencyId(long usrUserAgencyId) {
        this.usrUserAgencyId = usrUserAgencyId;
    }
    @ManyToOne
    @JoinColumn(name = "usr_useragencyagencyid", nullable = false)
    public UsrAgency getUsrAgency() {
        return usrAgency;
    }

    public void setUsrAgency(UsrAgency usrAgency) {
        this.usrAgency = usrAgency;
    }
    @ManyToOne
    @JoinColumn(name = "usr_useragencyuserid", nullable = false)
    public UsrUser getUsrUser() {
        return usrUser;
    }

    public void setUsrUser(UsrUser usrUser) {
        this.usrUser = usrUser;
    }


}
