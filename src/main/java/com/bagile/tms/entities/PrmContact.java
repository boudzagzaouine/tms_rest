package com.bagile.tms.entities;

import javax.persistence.*;

import java.util.Date;

@Entity
@Table(name="prm_contact")
public class PrmContact {

    @Id
    @GeneratedValue
    @Column(name = "prm_contactid")
    private int prmContactid;
    @Column(name = "prm_contactname")
    private String prmContactname;
    @Column(name = "prm_contactcreationdate")
    private Date prmContactcreationDate;
    @Column(name = "prm_contactsurname")
    private String prmContactsurname ;
    @Column(name = "prm_Contacttele1")
    private String prmContacttele1 ;
    @Column(name = "prm_contactfax")
    private String prmContactfax ;
    @Column(name = "prm_contacttype")
    private String prmContactType;
    @Column(name = "prm_contactemail")
    private  String prmContactemail;
    @Column(name = "prm_contactcomment")
    private String prmContactcomment;
    @Column(name = "prm_contactactive")
    private boolean  prmContactactive ;


    public PrmContact() {
    }

    public String getprmContacttele1() {
        return prmContacttele1;
    }

    public void setprmContacttele1(String prmContacttele1) {
        prmContacttele1 = prmContacttele1;
    }

    public int getprmContactid() {
        return prmContactid;
    }

    public void setprmContactid(int prmContactid) {
        this.prmContactid = prmContactid;
    }

    public String getprmContactname() {
        return prmContactname;
    }

    public void setprmContactname(String prmContactname) {
        this.prmContactname = prmContactname;
    }

    public Date getprmContactcreationDate() {
        return prmContactcreationDate;
    }

    public void setprmContactcreationDate(Date prmContactcreationDate) {
        this.prmContactcreationDate = prmContactcreationDate;
    }

    public String getprmContactsurname() {
        return prmContactsurname;
    }

    public void setprmContactsurname(String prmContactsurname) {
        this.prmContactsurname = prmContactsurname;
    }

    public String getprmContactfax() {
        return prmContactfax;
    }

    public void setprmContactfax(String prmContactfax) {
        this.prmContactfax = prmContactfax;
    }

    public String getprmContactcontactType() {
        return prmContactType;
    }

    public void setprmContactcontactType(String prmContactcontactType) {
        this.prmContactType = prmContactcontactType;
    }

    public String getprmContactemail() {
        return prmContactemail;
    }

    public void setprmContactemail(String tmsContactemail) {
        this.prmContactemail = prmContactemail;
    }

    public String getprmContactcomment() {
        return prmContactcomment;
    }

    public void setprmContactcomment(String prmContactcomment) {
        this.prmContactcomment = prmContactcomment;
    }

    public boolean getprmContactactive() {
        return prmContactactive;
    }

    public void setprmContactactive(boolean tmsContactactive) {
        this.prmContactactive = prmContactactive;
    }
}
