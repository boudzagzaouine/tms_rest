package com.bagile.tms.entities;

// Generated 8 mars 2015 01:55:29 by Hibernate Tools 4.3.1

import javax.persistence.*;
import javax.validation.constraints.NotNull;

/**
 * UsrGrouphabilitation generated by hbm2java
 */
@Entity
@Table(name = "usr_grouphabilitation")
public class UsrGroupHabilitation implements java.io.Serializable {

    private static final long serialVersionUID = 1358730598440653284L;

    private long usrGroupHabilitationId;
    @NotNull
    private UsrHabilitation usrHabilitation;
    @NotNull
    private UsrUserGroup usrUserGroup;


    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq")
    @SequenceGenerator(name = "seq", sequenceName = "seq_usr_grouphabilitation", allocationSize = 1)
    @Column(name = "usr_grouphabilitationid", unique = true, nullable = false, precision = 10, scale = 0)
    public long getUsrGroupHabilitationId() {
        return this.usrGroupHabilitationId;
    }

    public void setUsrGroupHabilitationId(long usrGroupHabilitationId) {
        this.usrGroupHabilitationId = usrGroupHabilitationId;
    }

    @ManyToOne
    @JoinColumn(name = "usr_grouphabilitationhabilitationid", nullable = false)
    public UsrHabilitation getUsrHabilitation() {
        return this.usrHabilitation;
    }

    public void setUsrHabilitation(UsrHabilitation usrHabilitation) {
        this.usrHabilitation = usrHabilitation;
    }

    @ManyToOne
    @JoinColumn(name = "usr_grouphabilitationusergroupid", nullable = false)
    public UsrUserGroup getUsrUserGroup() {
        return this.usrUserGroup;
    }

    public void setUsrUserGroup(UsrUserGroup usrUserGroup) {
        this.usrUserGroup = usrUserGroup;
    }


}
