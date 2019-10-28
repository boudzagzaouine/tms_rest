package com.bagile.tms.dto;

import java.io.Serializable;
import java.util.Set;

public class UserGroup extends EmsDto implements Serializable {

    private static final long serialVersionUID = 2986205153031584174L;

    private long id;
    private Owner owner;
    private String code;
    private Set<User> users;
    private String description;
    private Long type;
    private Set<GroupHabilitation> groupHabilitations;
    private Set<UserGroupOwner> userGroupOwners;
    private Set<UserGroupWarehouse> userGroupWarehouses;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Owner getOwner() {
        return owner;
    }

    public void setOwner(Owner owner) {
        this.owner = owner;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public Set<User> getUsers() {
        return users;
    }

    public void setUsers(Set<User> users) {
        this.users = users;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Set<GroupHabilitation> getGroupHabilitations() {
        return groupHabilitations;
    }

    public void setGroupHabilitations(Set<GroupHabilitation> groupHabilitations) {
        this.groupHabilitations = groupHabilitations;
    }

    public Set<UserGroupOwner> getUserGroupOwners() {
        return userGroupOwners;
    }

    public void setUserGroupOwners(Set<UserGroupOwner> userGroupOwners) {
        this.userGroupOwners = userGroupOwners;
    }



    public Long getType() {
        return type;
    }

    public void setType(Long type) {
        this.type = type;
    }

    @Override
    public boolean equals(Object object) {
        boolean result = false;
        if (object == null || object.getClass() != getClass()) {
            result = false;
        } else {
            UserGroup obj = (UserGroup) object;
            if (this.id == obj.getId()) {
                result = true;
            }
        }
        return result;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 7 * hash + (int) this.id;
        hash = 7 * hash + (int) this.id;
        return hash;
    }

    public void setUserGroupWarehouses(Set<UserGroupWarehouse> userGroupWarehouses) {
        this.userGroupWarehouses = userGroupWarehouses;
    }

    public Set<UserGroupWarehouse> getUserGroupWarehouses() {
        return userGroupWarehouses;
    }
}