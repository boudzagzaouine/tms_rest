package com.bagile.tms.entities;

import javax.persistence.*;

import java.util.Date;

@Entity
@Table(name="tms_contact")
public class TmsContact  {

    @Id
    @GeneratedValue
    @Column(name = "tms_contactid")
    private int tmsContactid;
    @Column(name = "tms_contactname")
    private String tmsContactname;
    @Column(name = "tms_contactcreationdate")
    private Date tmsContactcreationDate;
    @Column(name = "tms_contactsurname")
    private String tmsContactsurname ;
    @Column(name = "Tms_Contacttele1")
    private String TmsContacttele1 ;
    @Column(name = "tms_contactfax")
    private String tmsContactfax ;
    @Column(name = "tms_contacttype")
    private String tmsContactType;
    @Column(name = "tms_contactemail")
    private  String tmsContactemail;
    @Column(name = "tms_contactcomment")
    private String tmsContactcomment;
    @Column(name = "tms_contactactive")
    private boolean  tmsContactactive ;


    public TmsContact() {
    }

    public String getTmsContacttele1() {
        return TmsContacttele1;
    }

    public void setTmsContacttele1(String tmsContacttele1) {
        TmsContacttele1 = tmsContacttele1;
    }

    public int getTmsContactid() {
        return tmsContactid;
    }

    public void setTmsContactid(int tmsContactid) {
        this.tmsContactid = tmsContactid;
    }

    public String getTmsContactname() {
        return tmsContactname;
    }

    public void setTmsContactname(String tmsContactname) {
        this.tmsContactname = tmsContactname;
    }

    public Date getTmsContactcreationDate() {
        return tmsContactcreationDate;
    }

    public void setTmsContactcreationDate(Date tmsContactcreationDate) {
        this.tmsContactcreationDate = tmsContactcreationDate;
    }

    public String getTmsContactsurname() {
        return tmsContactsurname;
    }

    public void setTmsContactsurname(String tmsContactsurname) {
        this.tmsContactsurname = tmsContactsurname;
    }

    public String getTmsContactfax() {
        return tmsContactfax;
    }

    public void setTmsContactfax(String tmsContactfax) {
        this.tmsContactfax = tmsContactfax;
    }

    public String getTmsContactcontactType() {
        return tmsContactType;
    }

    public void setTmsContactcontactType(String tmsContactcontactType) {
        this.tmsContactType = tmsContactcontactType;
    }

    public String getTmsContactemail() {
        return tmsContactemail;
    }

    public void setTmsContactemail(String tmsContactemail) {
        this.tmsContactemail = tmsContactemail;
    }

    public String getTmsContactcomment() {
        return tmsContactcomment;
    }

    public void setTmsContactcomment(String tmsContactcomment) {
        this.tmsContactcomment = tmsContactcomment;
    }

    public boolean getTmsContactactive() {
        return tmsContactactive;
    }

    public void setTmsContactactive(boolean tmsContactactive) {
        this.tmsContactactive = tmsContactactive;
    }
}
