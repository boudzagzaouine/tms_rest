package com.bagile.tms.dto;

import java.io.Serializable;
import java.util.Date;
import java.util.Set;

public class Actions implements Serializable {

    private static final long serialVersionUID = -1939236486687240855L;

    private long id;

    private String code;

    private Date creationDate;

    private Set<UserActions> userActionses;

    public long getId() {
        return this.id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getCode() {
        return this.code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public Date getCreationDate() {
        return this.creationDate;
    }

    public void setCreationDate(Date creationDate) {
        this.creationDate = creationDate;
    }

    public Set<UserActions> getUserActionses() {
        return userActionses;
    }

    public void setUserActionses(Set<UserActions> userActionses) {
        this.userActionses = userActionses;
    }

    @Override
    public boolean equals(Object object) {
        boolean result = false;
        if (object == null || object.getClass() != getClass()) {
            result = false;
        } else {
            Actions obj = (Actions) object;
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