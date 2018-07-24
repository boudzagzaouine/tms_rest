package com.bagile.tms.dto;

import java.io.Serializable;
import java.util.Date;
import java.util.Set;

/**
 * Created by yasser on 22/09/2016.
 */
public class Acte implements Serializable {

    private long id;
    private String code;
    private String nature;
    private String description;
    private String periodicity;
    private String duration;
    private Date dateLastAct;
    private Set<MaintenancePlan> maintenancePlans;

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

    public String getNature() {
        return nature;
    }

    public void setNature(String nature) {
        this.nature = nature;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getPeriodicity() {
        return periodicity;
    }

    public void setPeriodicity(String periodicity) {
        this.periodicity = periodicity;
    }

    public String getDuration() {
        return duration;
    }

    public void setDuration(String duration) {
        this.duration = duration;
    }

    public Date getDateLastAct() {
        return dateLastAct;
    }

    public void setDateLastAct(Date dateLastAct) {
        this.dateLastAct = dateLastAct;
    }

    public Set<MaintenancePlan> getMaintenancePlans() {
        return maintenancePlans;
    }

    public void setMaintenancePlans(Set<MaintenancePlan> maintenancePlans) {
        this.maintenancePlans = maintenancePlans;
    }

    @Override
    public boolean equals(Object object) {
        boolean result =false;
        if(object==null || object.getClass()!=getClass())
        {
            result=false;
        }
        else
        {
            Acte obj = (Acte)object;
            if (this.id==obj.getId())
            {
                result=true;
            }
        }
        return result;
    }

    @Override
    public int hashCode(){
        int hash=3;
        hash = 7*hash+(int)this.id;
        hash = 7*hash+(int)this.id;
        return hash;
    }
}
