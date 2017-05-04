package com.sinno.ems.entities;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

/**
 * Created by adadi on 2/25/2016.
 */
@Entity
@Table(name = "usr_user_group_own_owner")
public class UsrUserGroupOwner implements Serializable {
    private long usrUserGroupOwnOwnerId;
    @NotNull
    private UsrUserGroup usrUserGroup;
    @NotNull
    private OwnOwner ownOwner;

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq")
    @SequenceGenerator(name = "seq", sequenceName = "usr_user_group_own_owner_usr_user_group_own_owner_id_seq", allocationSize = 1)
    @Column(name = "usr_user_group_own_owner_id", unique = true, nullable = false, precision = 10, scale = 0)
    public long getUsrUserGroupOwnOwnerId() {
        return usrUserGroupOwnOwnerId;
    }

    public void setUsrUserGroupOwnOwnerId(long usrUserGroupOwnOwnerId) {
        this.usrUserGroupOwnOwnerId = usrUserGroupOwnOwnerId;
    }

    @ManyToOne
    @JoinColumn(name = "usr_usergroup_id", nullable = false)
    public UsrUserGroup getUsrUserGroup() {
        return usrUserGroup;
    }

    public void setUsrUserGroup(UsrUserGroup usrUserGroup) {
        this.usrUserGroup = usrUserGroup;
    }

    @ManyToOne
    @JoinColumn(name = "own_owner_id", nullable = false)
    public OwnOwner getOwnOwner() {
        return ownOwner;
    }

    public void setOwnOwner(OwnOwner ownOwner) {
        this.ownOwner = ownOwner;
    }
}
