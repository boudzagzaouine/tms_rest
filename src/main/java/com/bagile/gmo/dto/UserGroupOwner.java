package com.bagile.gmo.dto;

import java.io.Serializable;

/**
 * Created by adadi on 2/25/2016.
 */
public class UserGroupOwner extends EmsDto implements Serializable {
    /**
     *
     */
    private static final long serialVersionUID = 6425820522366895750L;
    private long id;
    private UserGroup userGroup;
    private Owner owner;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public UserGroup getUserGroup() {
        return userGroup;
    }

    public void setUserGroup(UserGroup userGroup) {
        this.userGroup = userGroup;
    }

    public Owner getOwner() {
        return owner;
    }

    public void setOwner(Owner owner) {
        this.owner = owner;
    }

    @Override
    public boolean equals(Object object) {
        boolean result = false;
        if (object == null || object.getClass() != getClass()) {
            result = false;
        } else {
            UserGroupOwner obj = (UserGroupOwner) object;
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
}
