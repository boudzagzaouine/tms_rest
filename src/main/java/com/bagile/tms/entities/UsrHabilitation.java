package com.bagile.tms.entities;

// Generated 8 mars 2015 01:55:29 by Hibernate Tools 4.3.1

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.security.core.GrantedAuthority;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/**
 * UsrHabilitation generated by hbm2java
 */
@Entity
@Table(name = "usr_habilitation", uniqueConstraints = @UniqueConstraint(columnNames = "usr_habilitationcode"))
public class UsrHabilitation extends EmsEntity implements java.io.Serializable, GrantedAuthority {

    private static final long serialVersionUID = -5912577005612840837L;

    private long usrHabilitationId;
    @Size(max = 50)
    @NotNull
    private String usrHabilitationCode;
    @Size(max = 255)
    private String usrHabilitationDescription;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date usrHabilitationCreationDate;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date usrHabilitationUpdateDate;
    private UsrHabilitation usrHabilitationParent;
    private String usrHabilitationLabelFR;
    private String usrHabilitationLabelEN;

    private Set<UsrHabilitation> usrHabilitations = new HashSet<>(
            0);
    private Boolean usrHabilitationActive;

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq")
    @SequenceGenerator(name = "seq", sequenceName = "seq_usr_habilitation", allocationSize = 1)
    @Column(name = "usr_habilitationid", unique = true, nullable = false, precision = 10, scale = 0)
    public long getUsrHabilitationId() {
        return this.usrHabilitationId;
    }

    public void setUsrHabilitationId(long usrHabilitationId) {
        this.usrHabilitationId = usrHabilitationId;
    }

    @Column(name = "usr_habilitationcode", unique = true, nullable = false, length = 50)
    public String getUsrHabilitationCode() {
        return this.usrHabilitationCode;
    }

    public void setUsrHabilitationCode(String usrHabilitationCode) {
        this.usrHabilitationCode = usrHabilitationCode;
    }

    @Column(name = "usr_habilitationdescription")
    public String getUsrHabilitationDescription() {
        return this.usrHabilitationDescription;
    }

    public void setUsrHabilitationDescription(String usrHabilitationDescription) {
        this.usrHabilitationDescription = usrHabilitationDescription;
    }

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "usr_habilitationcreationdate")
    public Date getUsrHabilitationCreationDate() {
        return this.usrHabilitationCreationDate;
    }

    public void setUsrHabilitationCreationDate(Date usrHabilitationCreationDate) {
        this.usrHabilitationCreationDate = usrHabilitationCreationDate;
    }

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "usr_habilitationupdatedate")
    public Date getUsrHabilitationUpdateDate() {
        return this.usrHabilitationUpdateDate;
    }

    public void setUsrHabilitationUpdateDate(Date usrHabilitationUpdateDate) {
        this.usrHabilitationUpdateDate = usrHabilitationUpdateDate;
    }

    @Override
    public String getAuthority() {
        return getUsrHabilitationCode();
    }

    public void setAuthority(String authority) {
    }

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "usr_habilitation_parent")
    public UsrHabilitation getUsrHabilitationParent() {
        return usrHabilitationParent;
    }

    public void setUsrHabilitationParent(UsrHabilitation usrHabilitationParent) {
        this.usrHabilitationParent = usrHabilitationParent;
    }

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "usrHabilitationParent")
    public Set<UsrHabilitation> getUsrHabilitations() {
        return usrHabilitations;
    }

    public void setUsrHabilitations(Set<UsrHabilitation> usrHabilitations) {
        this.usrHabilitations = usrHabilitations;
    }
    @Column(name = "usr_habilitationactive")
    public Boolean getUsrHabilitationActive() {
        return usrHabilitationActive;
    }

    public void setUsrHabilitationActive(Boolean usrHabilitationActive) {
        this.usrHabilitationActive = usrHabilitationActive;
    }
    @Column(name = "usr_habilitationlabelfr", length = 150)

    public String getUsrHabilitationLabelFR() {
        return usrHabilitationLabelFR;
    }

    public void setUsrHabilitationLabelFR(String usrHabilitationLabelFR) {
        this.usrHabilitationLabelFR = usrHabilitationLabelFR;
    }
    @Column(name = "usr_habilitationlabelen", length = 150)

    public String getUsrHabilitationLabelEN() {
        return usrHabilitationLabelEN;
    }

    public void setUsrHabilitationLabelEN(String usrHabilitationLabelEN) {
        this.usrHabilitationLabelEN = usrHabilitationLabelEN;
    }
}
