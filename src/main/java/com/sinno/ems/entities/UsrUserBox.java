package com.sinno.ems.entities;

import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by Adil on 3/1/2017.
 */
@Entity
@Table(name = "usr_userbox")
@SequenceGenerator(name = "seq", sequenceName = "seq_usr_userbox", allocationSize = 1)
public class UsrUserBox {
    private Long usrUserBoxID;

    private UsrBox usrUserBoxBox;

    private UsrUser usrUserBoxUser;

    private Date usrUserBoxCreationDate;

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq")
    public Long getUsrUserBoxID() {
        return usrUserBoxID;
    }

    public void setUsrUserBoxID(Long usrUserBoxID) {
        this.usrUserBoxID = usrUserBoxID;
    }


    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "usr_userboxboxid")
    public UsrBox getUsrUserBoxBox() {
        return usrUserBoxBox;
    }

    public void setUsrUserBoxBox(UsrBox usrUserBoxBox) {
        this.usrUserBoxBox = usrUserBoxBox;
    }


    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_userboxuserid")
    public UsrUser getUsrUserBoxUser() {
        return usrUserBoxUser;
    }

    public void setUsrUserBoxUser(UsrUser usrUserBoxUser) {
        this.usrUserBoxUser = usrUserBoxUser;
    }

    @Temporal(TemporalType.TIMESTAMP)
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    public Date getUsrUserBoxCreationDate() {
        return usrUserBoxCreationDate;
    }

    public void setUsrUserBoxCreationDate(Date usrUserBoxCreationDate) {
        this.usrUserBoxCreationDate = usrUserBoxCreationDate;
    }


}
