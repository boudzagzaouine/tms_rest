package com.bagile.tms.entities;

import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import java.util.Date;

@Entity
@Table(name="prm_contact")
public class PrmContact extends EmsEntity {

    /**
     *
     */
    private static final long serialVersionUID = -2556249835469329497L;
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq")
    @SequenceGenerator(name = "seq", sequenceName = "seq_prm_contact_id", allocationSize = 1)
    @Column(name = "prm_contactid", unique = true, nullable = false, precision = 10, scale = 0)
    private int prmContactId;
    @Column(name = "prm_contactname")
    private String prmContactName;
    @Temporal(value = TemporalType.TIMESTAMP)
    @Column(name = "prm_contactcreationdate")
    private Date prmContactCreationDate;
    @Temporal(value = TemporalType.TIMESTAMP)
    @Column(name = "prm_contactupdatedate")
    private Date prmContactUpdateDate;
    @Column(name = "prm_contactsurname")
    private String prmContactSurname;
    @Column(name = "prm_Contacttele1")
    private String prmContactTele1;
    @Column(name = "prm_contactfax")
    private String prmContactFax;
    @Column(name = "prm_contacttype")
    private String prmContactType;
    @Column(name = "prm_contactemail")
    private String prmContactEmail;
    @Column(name = "prm_contactcomment")
    private String prmContactComment;
    @Column(name = "prm_contactactive")
    private boolean prmContactActive;

    public int getPrmContactId() {
        return prmContactId;
    }

    public void setPrmContactId(int prmContactId) {
        this.prmContactId = prmContactId;
    }

    public String getPrmContactName() {
        return prmContactName;
    }

    public void setPrmContactName(String prmContactName) {
        this.prmContactName = prmContactName;
    }

    public Date getPrmContactCreationDate() {
        return prmContactCreationDate;
    }

    public void setPrmContactCreationDate(Date prmContactCreationDate) {
        this.prmContactCreationDate = prmContactCreationDate;
    }

    public Date getPrmContactUpdateDate() {
        return prmContactUpdateDate;
    }

    public void setPrmContactUpdateDate(Date prmContactUpdateDate) {
        this.prmContactUpdateDate = prmContactUpdateDate;
    }

    public String getPrmContactSurname() {
        return prmContactSurname;
    }

    public void setPrmContactSurname(String prmContactSurname) {
        this.prmContactSurname = prmContactSurname;
    }

    public String getPrmContactTele1() {
        return prmContactTele1;
    }

    public void setPrmContactTele1(String prmContactTele1) {
        this.prmContactTele1 = prmContactTele1;
    }

    public String getPrmContactFax() {
        return prmContactFax;
    }

    public void setPrmContactFax(String prmContactFax) {
        this.prmContactFax = prmContactFax;
    }

    public String getPrmContactType() {
        return prmContactType;
    }

    public void setPrmContactType(String prmContactType) {
        this.prmContactType = prmContactType;
    }

    public String getPrmContactEmail() {
        return prmContactEmail;
    }

    public void setPrmContactEmail(String prmContactEmail) {
        this.prmContactEmail = prmContactEmail;
    }

    public String getPrmContactComment() {
        return prmContactComment;
    }

    public void setPrmContactComment(String prmContactComment) {
        this.prmContactComment = prmContactComment;
    }

    public boolean isPrmContactActive() {
        return prmContactActive;
    }

    public void setPrmContactActive(boolean prmContactActive) {
        this.prmContactActive = prmContactActive;
    }
}
