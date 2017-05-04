package com.sinno.ems.entities;

import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;

/**
 * Created by Adil on 3/1/2017.
 */
@Entity
@Table(name = "usr_box")
@SequenceGenerator(name = "seq", sequenceName = "seq_usr_box", allocationSize = 1)
public class UsrBox {
    private Long usrBoxId;
    private String usrBoxCode;
    private String usrBoxDescription;
    private BigDecimal usrBoxInitPrice;
    private BigDecimal usrBoxFlashPrice;
    private Date usrBoxCreationDate;
    private Date usrBoxUpdateDate;
    private UsrAgency usrAgency;


    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq")
    @Column(name = "usr_boxid")
    public Long getUsrBoxId() {
        return usrBoxId;
    }

    public void setUsrBoxId(Long usrBoxId) {
        this.usrBoxId = usrBoxId;
    }

    @Column(name = "usr_boxcode")
    public String getUsrBoxCode() {
        return usrBoxCode;
    }

    public void setUsrBoxCode(String usrBoxCode) {
        this.usrBoxCode = usrBoxCode;
    }

    @Column(name = "usr_boxdescription")
    public String getUsrBoxDescription() {
        return usrBoxDescription;
    }

    public void setUsrBoxDescription(String usrBoxDescription) {
        this.usrBoxDescription = usrBoxDescription;
    }

    @Column(name = "usr_boxinitprice")
    public BigDecimal getUsrBoxInitPrice() {
        return usrBoxInitPrice;
    }

    public void setUsrBoxInitPrice(BigDecimal usrBoxInitPrice) {
        this.usrBoxInitPrice = usrBoxInitPrice;
    }


    @Column(name = "usr_boxflashprice")
    public BigDecimal getUsrBoxFlashPrice() {
        return usrBoxFlashPrice;
    }

    public void setUsrBoxFlashPrice(BigDecimal usrBoxFlashPrice) {
        this.usrBoxFlashPrice = usrBoxFlashPrice;
    }

    @Temporal(TemporalType.TIMESTAMP)
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    public Date getUsrBoxCreationDate() {
        return usrBoxCreationDate;
    }

    public void setUsrBoxCreationDate(Date usrBoxCreationDate) {
        this.usrBoxCreationDate = usrBoxCreationDate;
    }

    @Temporal(TemporalType.TIMESTAMP)
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    public Date getUsrBoxUpdateDate() {
        return usrBoxUpdateDate;
    }

    public void setUsrBoxUpdateDate(Date getUsrBoxUpdateDate) {
        this.usrBoxUpdateDate = getUsrBoxUpdateDate;
    }

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "usr_boxagencyid", nullable = false)
    public UsrAgency getUsrAgency() {
        return usrAgency;
    }

    public void setUsrAgency(UsrAgency usrAgency) {
        this.usrAgency = usrAgency;
    }
}
