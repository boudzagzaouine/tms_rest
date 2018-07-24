package com.bagile.tms.dto;

import java.io.Serializable;

/**
 * Created by adadi on 2/25/2016.
 */
public class UserGroupWarehouse implements Serializable {
    private long id;
    private UserGroup userGroup;
    private Warehouse warehouse;

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

    public Warehouse getWarehouse() {
        return warehouse;
    }

    public void setWarehouse(Warehouse warehouse) {
        this.warehouse = warehouse;
    }

    @Override
    public boolean equals(Object object) {
        boolean result = false;
        if (object == null || object.getClass() != getClass()) {
            result = false;
        } else {
            UserGroupWarehouse obj = (UserGroupWarehouse) object;
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
