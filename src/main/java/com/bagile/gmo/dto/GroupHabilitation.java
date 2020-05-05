package com.bagile.gmo.dto;

import java.io.Serializable;

public class GroupHabilitation extends EmsDto  implements Serializable {

    private static final long serialVersionUID = -6477675518066822987L;

    private long id;
    private Habilitation habilitation;
    private UserGroup userGroup;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Habilitation getHabilitation() {
        return habilitation;
    }

    public void setHabilitation(Habilitation habilitation) {
        this.habilitation = habilitation;
    }

    public UserGroup getUserGroup() {
        return userGroup;
    }

    public void setUserGroup(UserGroup userGroup) {
        this.userGroup = userGroup;
    }

    @Override
    public boolean equals(Object object) {
        boolean result = false;
        if (object == null || object.getClass() != getClass()) {
            result = false;
        } else {
            GroupHabilitation obj = (GroupHabilitation) object;
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