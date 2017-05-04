package com.sinno.ems.entities;

import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.util.Date;

/**
 * Created by ASMAE on 04/05/2016.
 */

@Entity
@Table(name = "prm_msg_send")
public class PrmMsgSend implements Serializable {

    private long prmMsgSendId;
    @Size(max = 255)
    private String prmMsgSendFileType;
    private boolean prmMsgSendActive;
    @Size(max = 255)
    private String prmMsgSendFormat;
    @Size(max = 255)
    private String prmMsgSendPath;
    @Size(max = 255)
    private String prmMsgSendArcPath;
    private Long prmMsgSendFrequency;
    private Long prmMsgSendArcDelay;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date prmMsgSendCreationDate;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date prmMsgSendUpdateDate;
    private Long prmMsgSendPriority;
    private String prmMsgSendFileName;
    private String prmMsgSendLangue;


    public PrmMsgSend() {
    }

    public PrmMsgSend(long prmMsgSendId, String prmMsgSendFileType,
                      boolean prmMsgSendActive, String prmMsgSendFormat,
                      String prmMsgSendPath, String prmMsgSendArcPath,
                      Long prmMsgSendFrequency, Long prmMsgSendArcDelay,
                      Date prmMsgSendCreationDate,
                      Date prmMsgSendUpdateDate,String prmMsgSendLangue) {
        this.prmMsgSendId = prmMsgSendId;
        this.prmMsgSendFileType = prmMsgSendFileType;
        this.prmMsgSendActive = prmMsgSendActive;
        this.prmMsgSendFormat = prmMsgSendFormat;
        this.prmMsgSendPath = prmMsgSendPath;
        this.prmMsgSendArcPath = prmMsgSendArcPath;
        this.prmMsgSendFrequency = prmMsgSendFrequency;
        this.prmMsgSendArcDelay = prmMsgSendArcDelay;
        this.prmMsgSendCreationDate = prmMsgSendCreationDate;
        this.prmMsgSendUpdateDate = prmMsgSendUpdateDate;
        this.prmMsgSendLangue=prmMsgSendLangue;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq")
    @SequenceGenerator(name = "seq", sequenceName = "seq_prm_msgSend", allocationSize = 1)
    @Column(name = "prm_msgsendid", unique = true)
    public long getPrmMsgSendId() {
        return this.prmMsgSendId;
    }

    public void setPrmMsgSendId(long prmMsgSendId) {
        this.prmMsgSendId = prmMsgSendId;
    }

    @Column(name = "prm_msgsendlangue")
    public String getPrmMsgSendLangue() {
        return prmMsgSendLangue;
    }

    @Column
    public void setPrmMsgSendLangue(String prmMsgSendLangue) {
        this.prmMsgSendLangue = prmMsgSendLangue;
    }

    @Column(name = "prm_msgsendfiletype")
    public String getPrmMsgSendFileType() {
        return this.prmMsgSendFileType;
    }

    public void setPrmMsgSendFileType(String prmMsgSendFileType) {
        this.prmMsgSendFileType = prmMsgSendFileType;
    }

    @Column(name = "prm_msgsendactive")
    public boolean isPrmMsgSendActive() {
        return this.prmMsgSendActive;
    }

    public void setPrmMsgSendActive(boolean prmMsgSendActive) {
        this.prmMsgSendActive = prmMsgSendActive;
    }

    @Column(name = "prm_msgsendformat")
    public String getPrmMsgSendFormat() {
        return this.prmMsgSendFormat;
    }

    public void setPrmMsgSendFormat(String prmMsgSendFormat) {
        this.prmMsgSendFormat = prmMsgSendFormat;
    }

    @Column(name = "prm_msgsendpath")
    public String getPrmMsgSendPath() {
        return this.prmMsgSendPath;
    }

    public void setPrmMsgSendPath(String prmMsgSendPath) {
        this.prmMsgSendPath = prmMsgSendPath;
    }

    @Column(name = "prm_msgsendarcpath")
    public String getPrmMsgSendArcPath() {
        return this.prmMsgSendArcPath;
    }

    public void setPrmMsgSendArcPath(String prmMsgSendArcPath) {
        this.prmMsgSendArcPath = prmMsgSendArcPath;
    }

    @Column(name = "prm_msgsendfrequency")
    public Long getPrmMsgSendFrequency() {
        return this.prmMsgSendFrequency;
    }

    public void setPrmMsgSendFrequency(Long prmMsgSendFrequency) {
        this.prmMsgSendFrequency = prmMsgSendFrequency;
    }


    @Column(name = "prm_msgsendarcdelay")
    public Long getPrmMsgSendArcDelay() {
        return this.prmMsgSendArcDelay;
    }

    public void setPrmMsgSendArcDelay(Long prmMsgSendArcDelay) {
        this.prmMsgSendArcDelay = prmMsgSendArcDelay;
    }

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "prm_msgsendcreationdate")
    public Date getPrmMsgSendCreationDate() {
        return this.prmMsgSendCreationDate;
    }

    public void setPrmMsgSendCreationDate(Date prmMsgSendCreationDate) {
        this.prmMsgSendCreationDate = prmMsgSendCreationDate;
    }

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "prm_msgsendupdatedate")

    public Date getPrmMsgSendUpdateDate() {
        return this.prmMsgSendUpdateDate;
    }

    public void setPrmMsgSendUpdateDate(Date prmMsgSendUpdateDate) {
        this.prmMsgSendUpdateDate = prmMsgSendUpdateDate;
    }

    @Column(name = "prm_msgsendpriority", precision = 10, scale = 0)

    public Long getPrmMsgSendPriority() {
        return prmMsgSendPriority;
    }

    public void setPrmMsgSendPriority(Long prmMsgSendPriority) {
        this.prmMsgSendPriority = prmMsgSendPriority;
    }

    @Column(name = "prm_msgsendfilename")
    public String getPrmMsgSendFileName() {
        return prmMsgSendFileName;
    }

    public void setPrmMsgSendFileName(String prmMsgSendFileName) {
        this.prmMsgSendFileName = prmMsgSendFileName;
    }
}
