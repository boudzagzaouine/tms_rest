package com.sinno.ems.entities;

import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.util.Date;

/**
 * Created by ASMAE on 03/05/2016.
 */

@Entity
@Table(name = "prm_msg_recieve")
public class PrmMsgReceive implements Serializable{
    private long prmMsgRecieveId;
    @Size(max = 255)
    private String prmMsgRecieveFileType;
    private boolean prmMsgRecieveActive;
    @Size(max = 255)
    private String prmMsgRecieveFormat;
    @Size(max = 255)
    private String prmMsgRecievePath;
    @Size(max = 255)
    private String prmMsgRecieveArcPath;
    private Long prmMsgRecieveFrequency;
    private Long prmMsgRecieveArcDelay;
    private Long prmMsgRecievePriority;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date prmMsgRecieveCreationDate;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date prmMsgRecieveUpdateDate;

    public PrmMsgReceive() {
    }

    public PrmMsgReceive(long prmMsgRecieveId,
                         String prmMsgRecieveFileType,
                         boolean prmMsgRecieveActive,
                         String prmMsgRecieveFormat,
                         String prmMsgRecievePath,
                         String prmMsgRecieveArcPath,
                         Long prmMsgRecieveFrequency,
                         Long prmMsgRecieveArcDelay,
                         Date prmMsgRecieveCreationDate,
                         Date prmMsgRecieveUpdateDate) {
        this.prmMsgRecieveId = prmMsgRecieveId;
        this.prmMsgRecieveFileType = prmMsgRecieveFileType;
        this.prmMsgRecieveActive = prmMsgRecieveActive;
        this.prmMsgRecieveFormat = prmMsgRecieveFormat;
        this.prmMsgRecievePath = prmMsgRecievePath;
        this.prmMsgRecieveArcPath = prmMsgRecieveArcPath;
        this.prmMsgRecieveFrequency = prmMsgRecieveFrequency;
        this.prmMsgRecieveArcDelay = prmMsgRecieveArcDelay;
        this.prmMsgRecieveCreationDate = prmMsgRecieveCreationDate;
        this.prmMsgRecieveUpdateDate = prmMsgRecieveUpdateDate;
    }



    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq")
    @SequenceGenerator(name = "seq", sequenceName = "seq_prm_msgRecieve", allocationSize = 1)
    @Column(name = "prm_msgrecieveid", unique = true)
    public long getPrmMsgRecieveId() {
        return this.prmMsgRecieveId;
    }

    public void setPrmMsgRecieveId(long prmMsgRecieveId) {
        this.prmMsgRecieveId = prmMsgRecieveId;
    }

    @Column(name = "prm_msgrecievefiletype")
    public String getPrmMsgRecieveFileType() {
        return this.prmMsgRecieveFileType;
    }

    public void setPrmMsgRecieveFileType(String prmMsgRecieveFileType) {
        this.prmMsgRecieveFileType = prmMsgRecieveFileType;
    }

    @Column(name = "prm_msgrecieveactive")
    public boolean isPrmMsgRecieveActive() {
        return this.prmMsgRecieveActive;
    }

    public void setPrmMsgRecieveActive(boolean prmMsgRecieveActive) {
        this.prmMsgRecieveActive = prmMsgRecieveActive;
    }

    @Column(name = "prm_msgrecieveformat")
    public String getPrmMsgRecieveFormat() {
        return this.prmMsgRecieveFormat;
    }

    public void setPrmMsgRecieveFormat(String prmMsgRecieveFormat) {
        this.prmMsgRecieveFormat = prmMsgRecieveFormat;
    }

    @Column(name = "prm_msgrecievepath")
    public String getPrmMsgRecievePath() {
        return this.prmMsgRecievePath;
    }

    public void setPrmMsgRecievePath(String prmMsgRecievePath) {
        this.prmMsgRecievePath = prmMsgRecievePath;
    }

    @Column(name = "prm_msgrecievearcpath")
    public String getPrmMsgRecieveArcPath() {
        return this.prmMsgRecieveArcPath;
    }

    public void setPrmMsgRecieveArcPath(String prmMsgRecieveArcPath) {
        this.prmMsgRecieveArcPath = prmMsgRecieveArcPath;
    }

    @Column(name = "prm_msgrecievefrequency")
    public Long getPrmMsgRecieveFrequency() {
        return this.prmMsgRecieveFrequency;
    }

    public void setPrmMsgRecieveFrequency(Long prmMsgRecieveFrequency) {
        this.prmMsgRecieveFrequency = prmMsgRecieveFrequency;
    }



    @Column(name = "prm_msgrecievearcdelay")
    public Long getPrmMsgRecieveArcDelay() {
        return this.prmMsgRecieveArcDelay;
    }

    public void setPrmMsgRecieveArcDelay(Long prmMsgRecieveArcDelay) {
        this.prmMsgRecieveArcDelay = prmMsgRecieveArcDelay;
    }

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "prm_msgrecievecreationdate")
    public Date getPrmMsgRecieveCreationDate() {
        return this.prmMsgRecieveCreationDate;
    }

    public void setPrmMsgRecieveCreationDate(Date prmMsgRecieveCreationDate) {
        this.prmMsgRecieveCreationDate = prmMsgRecieveCreationDate;
    }

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "prm_msgrecieveupdatedate")

    public Date getPrmMsgRecieveUpdateDate() {
        return this.prmMsgRecieveUpdateDate;
    }

    public void setPrmMsgRecieveUpdateDate(Date prmMsgRecieveUpdateDate) {
        this.prmMsgRecieveUpdateDate = prmMsgRecieveUpdateDate;
    }
    @Column(name = "prm_msgrecievepriority", precision = 10,scale = 0)
    public Long getPrmMsgRecievePriority() {
        return prmMsgRecievePriority;
    }

    public void setPrmMsgRecievePriority(Long prmMsgRecievePriority) {
        this.prmMsgRecievePriority = prmMsgRecievePriority;
    }
}
