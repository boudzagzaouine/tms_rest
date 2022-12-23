package com.bagile.gmo.entities;


import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by fama on 06/03/2017.
 */
@Entity
@Table(name = "cmd_activityarea", uniqueConstraints = {
        @UniqueConstraint(columnNames = "cmd_activityareacode")})
public class CmdActivityArea extends EmsEntity implements Serializable {
    private long cmdActivityAreaId;
    @NotNull
    @Size(max = 30)
    private String cmdActivityAreaCode;
    private String cmdActivityAreaDescription;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date cmdActivityAreaCreationDate;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date cmdActivityAreaUpdateDate;

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq")
    @SequenceGenerator(name = "seq", sequenceName = "seq_cmdactivityarea", allocationSize = 1)
    @Column(name = "cmd_activityareaid", unique = true, nullable = false, precision = 10, scale = 0)
    public long getCmdActivityAreaId() {
        return cmdActivityAreaId;
    }

    public void setCmdActivityAreaId(long cmdActivityAreaId) {
        this.cmdActivityAreaId = cmdActivityAreaId;
    }

    @Column(name = "cmd_activityareacode", unique = true, nullable = false)
    public String getCmdActivityAreaCode() {
        return cmdActivityAreaCode;
    }

    public void setCmdActivityAreaCode(String cmdActivityAreaCode) {
        this.cmdActivityAreaCode = cmdActivityAreaCode;
    }


    @Column(name = "cmd_activityareadescription")
    public String getCmdActivityAreaDescription() {
        return cmdActivityAreaDescription;
    }

    public void setCmdActivityAreaDescription(String cmdActivityAreaDescription) {
        this.cmdActivityAreaDescription = cmdActivityAreaDescription;
    }

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "cmd_activityareacreatedate")
    public Date getCmdActivityAreaCreationDate() {
        return cmdActivityAreaCreationDate;
    }

    public void setCmdActivityAreaCreationDate(Date cmdActivityAreaCreationDate) {
        this.cmdActivityAreaCreationDate = cmdActivityAreaCreationDate;
    }

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "cmd_activityareaupdatedate")
    public Date getCmdActivityAreaUpdateDate() {
        return cmdActivityAreaUpdateDate;
    }

    public void setCmdActivityAreaUpdateDate(Date cmdActivityAreaUpdateDate) {
        this.cmdActivityAreaUpdateDate = cmdActivityAreaUpdateDate;
    }
}
