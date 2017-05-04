package com.sinno.ems.dto;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by Enissay on 28/03/2017.
 */
public class Process {
    private Long id;
    private String code;
    private String description;
    private Date creationDate;
    private Date updateDate;
    private Set<MachineProcess> machineProcesses=new HashSet<MachineProcess>(0);


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public Date getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(Date creationDate) {
        this.creationDate = creationDate;
    }

    public Date getUpdateDate() {
        return updateDate;
    }

    public void setUpdateDate(Date updateDate) {
        this.updateDate = updateDate;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Set<MachineProcess> getMachineProcesses() {
        return machineProcesses;
    }

    public void setMachineProcesses(Set<MachineProcess> machineProcesses) {
        this.machineProcesses = machineProcesses;
    }
}
