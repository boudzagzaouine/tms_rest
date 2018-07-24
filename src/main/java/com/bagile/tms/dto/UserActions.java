package com.bagile.tms.dto;

import java.io.Serializable;
import java.util.Date;

public class UserActions implements Serializable {

    private static final long serialVersionUID = 2849719547189894436L;

    private Actions actions;
    private long id;
    private Date creationDate;
    private User user;

    public Actions getActions() {
        return this.actions;
    }

    public void setActions(Actions actions) {
        this.actions = actions;
    }

    public long getId() {
        return this.id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Date getCreationDate() {
        return this.creationDate;
    }

    public void setCreationDate(Date creationDate) {
        this.creationDate = creationDate;
    }

    public User getUser() {
        return this.user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @Override
    public boolean equals(Object object) {
        boolean result = false;
        if (object == null || object.getClass() != getClass()) {
            result = false;
        } else {
            UserActions obj = (UserActions) object;
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