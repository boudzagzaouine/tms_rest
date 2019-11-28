package com.bagile.tms.entities;

import javax.persistence.*;

@Entity
@Table(name="prm_contact")
public class PrmContact extends EmsEntity {

    private static final long serialVersionUID = -2556249835469329497L;

    private Long prmContactId;

    private String prmContactName;

    private String prmContactSurname;
    private String prmContactTele1;

    private String prmContactFax;
    private String prmContactType;
    private String prmContactEmail;
    private String prmContactComment;
    private Boolean prmContactActive;


    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq")
    @SequenceGenerator(name = "seq", sequenceName = "seq_prm_contact_id", allocationSize = 1)
    @Column(name = "prm_contactid", unique = true, nullable = false, precision = 10, scale = 0)
    public Long getPrmContactId() {
        return prmContactId;
    }
    public void setPrmContactId(Long prmContactId) {
        this.prmContactId = prmContactId;
    }

    @Column(name = "prm_contactname")
    public String getPrmContactName() {
        return prmContactName;
    }
    public void setPrmContactName(String prmContactName) {
        this.prmContactName = prmContactName;
    }

    @Column(name = "prm_contactsurname")
    public String getPrmContactSurname() {
        return prmContactSurname;
    }

    public void setPrmContactSurname(String prmContactSurname) {
        this.prmContactSurname = prmContactSurname;
    }

    @Column(name = "prm_Contacttele1")
    public String getPrmContactTele1() {
        return prmContactTele1;
    }

    public void setPrmContactTele1(String prmContactTele1) {
        this.prmContactTele1 = prmContactTele1;
    }

    @Column(name = "prm_contactfax")
    public String getPrmContactFax() {
        return prmContactFax;
    }

    public void setPrmContactFax(String prmContactFax) {
        this.prmContactFax = prmContactFax;
    }

    @Column(name = "prm_contacttype")
    public String getPrmContactType() {
        return prmContactType;
    }
    public void setPrmContactType(String prmContactType) {
        this.prmContactType = prmContactType;
    }

    @Column(name = "prm_contactemail")
    public String getPrmContactEmail() {
        return prmContactEmail;
    }
    public void setPrmContactEmail(String prmContactEmail) {
        this.prmContactEmail = prmContactEmail;
    }

    @Column(name = "prm_contactcomment")
    public String getPrmContactComment() {
        return prmContactComment;
    }
    public void setPrmContactComment(String prmContactComment) {
        this.prmContactComment = prmContactComment;
    }

    @Column(name = "prm_contactactive")
    public Boolean isPrmContactActive() {
        return prmContactActive;
    }
    public void setPrmContactActive(Boolean prmContactActive) {
        if (prmContactActive == null) {
            this.prmContactActive = false;
            return;
        }
        this.prmContactActive = prmContactActive;
    }

}
