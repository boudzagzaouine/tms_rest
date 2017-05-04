package com.sinno.ems.dto;

import java.io.Serializable;
import java.util.Date;

/**
 * Created by ASMAE on 04/05/2016.
 */
public class MsgSend implements Serializable {
    private long id;
    private String fileType;
    private String fileName;
    private Boolean active;
    private String format;
    private String path;
    private String arcPath;
    private Long frequency;
    private Long arcDelay;
    private Long priority;
    private Date creationDate;
    private Date updateDate;
    private String langue;

    public String getLangue() {
        return langue;
    }

    public void setLangue(String langue) {
        this.langue = langue;
    }

    public long getId() {
        return this.id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getFileType() {
        return this.fileType;
    }

    public void setFileType(String fileType) {
        this.fileType = fileType;
    }

    public Boolean getActive() {
        return this.active;
    }

    public void setActive(Boolean active) {
        this.active = active;
    }

    public String getFormat() {
        return this.format;
    }

    public void setFormat(String format) {
        this.format = format;
    }

    public String getPath() {
        return this.path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public String getArcPath() {
        return this.arcPath;
    }

    public void setArcPath(String arcPath) {
        this.arcPath = arcPath;
    }

    public Long getFrequency() {
        return this.frequency;
    }

    public void setFrequency(Long frequency) {
        this.frequency = frequency;
    }

    public Long getArcDelay() {
        return this.arcDelay;
    }

    public void setArcDelay(Long arcDelay) {
        this.arcDelay = arcDelay;
    }

    public Date getCreationDate() {
        return this.creationDate;
    }

    public void setCreationDate(Date creationDate) {
        this.creationDate = creationDate;
    }

    public Date getUpdateDate() {
        return this.updateDate;
    }

    public void setUpdateDate(Date updateDate) {
        this.updateDate = updateDate;
    }

    public Long getPriority() {
        return priority;
    }

    public void setPriority(Long priority) {
        this.priority = priority;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    @Override
    public boolean equals(Object object) {
        boolean result = false;
        if (object == null || object.getClass() != getClass()) {
            result = false;
        } else {
            MsgSend obj = (MsgSend) object;
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
