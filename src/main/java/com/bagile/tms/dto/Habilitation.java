package com.bagile.tms.dto;

import java.io.Serializable;
import java.util.Date;
import java.util.Set;

public class Habilitation implements Serializable {

    private static final long serialVersionUID = -2286588942030519144L;

    private long id;
    private String code;
    private String description;
    private Date updateDate;
    private Date creationDate;
    private Habilitation habilitation;
    private Set<GroupHabilitation> groupHabilitations;
    private Set<Habilitation> habilitations;
    private String authority;
    private Boolean active;
    private String labelFR;
    private String LabelEN;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Date getUpdateDate() {
        return updateDate;
    }

    public void setUpdateDate(Date updateDate) {
        this.updateDate = updateDate;
    }

    public Date getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(Date creationDate) {
        this.creationDate = creationDate;
    }

    public Habilitation getHabilitation() {
        return habilitation;
    }

    public void setHabilitation(Habilitation habilitation) {
        this.habilitation = habilitation;
    }

    public Set<GroupHabilitation> getGroupHabilitations() {
        return groupHabilitations;
    }

    public void setGroupHabilitations(Set<GroupHabilitation> groupHabilitations) {
        this.groupHabilitations = groupHabilitations;
    }

    public Set<Habilitation> getHabilitations() {
        return habilitations;
    }

    public void setHabilitations(Set<Habilitation> habilitations) {
        this.habilitations = habilitations;
    }

    public String getAuthority() {
        return code;
    }

    public void setAuthority(String authority) {

    }

    public Boolean getActive() {
        return active;
    }

    public void setActive(Boolean active) {
        this.active = active;
    }

    public String getLabelFR() {
        return labelFR;
    }

    public void setLabelFR(String labelFR) {
        this.labelFR = labelFR;
    }

    public String getLabelEN() {
        return LabelEN;
    }

    public void setLabelEN(String labelEN) {
        LabelEN = labelEN;
    }

    @Override
    public boolean equals(Object object) {
        boolean result = false;
        if (object == null || object.getClass() != getClass()) {
            result = false;
        } else {
            Habilitation obj = (Habilitation) object;
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