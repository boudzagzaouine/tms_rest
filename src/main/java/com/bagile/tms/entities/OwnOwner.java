package com.bagile.tms.entities;

// Generated 8 mars 2015 01:55:29 by Hibernate Tools 4.3.1

import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.Date;

/**
 * OwnOwner generated by hbm2java
 */
@Entity
@Table(name = "own_owner", uniqueConstraints = @UniqueConstraint(columnNames = "own_ownercode"))
public class OwnOwner extends EmsEntity implements java.io.Serializable {

    /**
     *
     */
    private static final long serialVersionUID = 1484351263626605420L;
    private long ownOwnerId;
    @Size(max = 30)
    @NotNull
    private String ownOwnerCode;
    @Size(max = 255)
    private String ownOwnerDescription;
    @Size(max = 20)
    private String ownOwnerSiret;
    @Size(max = 255)
    private String ownOwnerComment;
    @NotNull
    private Boolean ownOwnerIsActive;
    @DateTimeFormat(pattern = "yyyy-MM-dd")

    private Date ownOwnerCreationDate;
    @DateTimeFormat(pattern = "yyyy-MM-dd")

    private Date ownOwnerUpdateDate;
    @Size(max = 255)
    private String ownOwnerVariable1;
    @Size(max = 255)
    private String ownOwnerVariable2;
    @Size(max = 255)
    private String ownOwnerVariable3;
    @Size(max = 255)
    private String ownOwnerVariable4;
    @Size(max = 255)
    private String ownOwnerVariable5;
    @Size(max = 255)
    private String ownOwnerVariable6;
    @Size(max = 255)
    private String ownOwnerVariable7;
    @Size(max = 255)
    private String ownOwnerVariable8;
    @Size(max = 255)
    private String ownOwnerVariable9;
    @Size(max = 255)
    private String ownOwnerVariable10;


   // private OrgOrganisation orgOrganisation;
   // @NotNull
   // private AdrAddress adrAddress;
    @NotNull
    private String ownOwnerName;
    @NotNull
    private String ownOwnerSurname;
    @NotNull
    private String ownOwnerEmail;
    private String ownOwnerPrimaryTel;
    private String ownOwnerSecondaryTel;
    @NotNull
    private byte[] ownOwnerImage;

    public OwnOwner() {
    }

    public OwnOwner(long ownOwnerId, String ownOwnerCode,
                    Boolean ownOwnerIsActive) {
        this.ownOwnerId = ownOwnerId;
        this.ownOwnerCode = ownOwnerCode;
        this.ownOwnerIsActive = ownOwnerIsActive;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq")
    @SequenceGenerator(name = "seq", sequenceName = "seq_own_owner", allocationSize = 1)
    @Column(name = "own_ownerid", unique = true, nullable = false, precision = 10, scale = 0)
    public long getOwnOwnerId() {
        return this.ownOwnerId;
    }

    public void setOwnOwnerId(long ownOwnerId) {
        this.ownOwnerId = ownOwnerId;
    }



    @Column(name = "own_ownercode", unique = true, nullable = false, length = 30)

    public String getOwnOwnerCode() {
        return this.ownOwnerCode;
    }

    public void setOwnOwnerCode(String ownOwnerCode) {
        this.ownOwnerCode = ownOwnerCode;
    }

  /*  @OneToOne(fetch = FetchType.LAZY)
    @PrimaryKeyJoinColumn(name = "own_ownerorganisationid")
    public OrgOrganisation getOrgOrganisation() {
        return orgOrganisation;
    }

    public void setOrgOrganisation(OrgOrganisation orgOrganisation) {
        this.orgOrganisation = orgOrganisation;
    }
*/
    @Column(name = "own_ownerdescription")
    public String getOwnOwnerDescription() {
        return this.ownOwnerDescription;
    }

    public void setOwnOwnerDescription(String ownOwnerDescription) {
        this.ownOwnerDescription = ownOwnerDescription;
    }

    @Column(name = "own_ownersiret", length = 20)
    public String getOwnOwnerSiret() {
        return this.ownOwnerSiret;
    }

    public void setOwnOwnerSiret(String ownOwnerSiret) {
        this.ownOwnerSiret = ownOwnerSiret;
    }

    @Column(name = "own_ownercomment")
    public String getOwnOwnerComment() {
        return this.ownOwnerComment;
    }

    public void setOwnOwnerComment(String ownOwnerComment) {
        this.ownOwnerComment = ownOwnerComment;
    }

    @Column(name = "own_ownerisactive", nullable = false)
    public Boolean getOwnOwnerIsActive() {
        return ownOwnerIsActive;
    }

    public void setOwnOwnerIsActive(Boolean ownOwnerIsActive) {
        this.ownOwnerIsActive = ownOwnerIsActive;
    }

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "own_ownercreationdate")
    public Date getOwnOwnerCreationDate() {
        return this.ownOwnerCreationDate;
    }

    public void setOwnOwnerCreationDate(Date ownOwnerCreationDate) {
        this.ownOwnerCreationDate = ownOwnerCreationDate;
    }

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "own_ownerupdatedate")
    public Date getOwnOwnerUpdateDate() {
        return this.ownOwnerUpdateDate;
    }

    public void setOwnOwnerUpdateDate(Date ownOwnerUpdateDate) {
        this.ownOwnerUpdateDate = ownOwnerUpdateDate;
    }

    @Column(name = "own_ownervariable1")
    public String getOwnOwnerVariable1() {
        return this.ownOwnerVariable1;
    }

    public void setOwnOwnerVariable1(String ownOwnerVariable1) {
        this.ownOwnerVariable1 = ownOwnerVariable1;
    }

    @Column(name = "own_ownervariable2")
    public String getOwnOwnerVariable2() {
        return this.ownOwnerVariable2;
    }

    public void setOwnOwnerVariable2(String ownOwnerVariable2) {
        this.ownOwnerVariable2 = ownOwnerVariable2;
    }

    @Column(name = "own_ownervariable3")
    public String getOwnOwnerVariable3() {
        return this.ownOwnerVariable3;
    }

    public void setOwnOwnerVariable3(String ownOwnerVariable3) {
        this.ownOwnerVariable3 = ownOwnerVariable3;
    }

    @Column(name = "own_ownervariable4")
    public String getOwnOwnerVariable4() {
        return this.ownOwnerVariable4;
    }

    public void setOwnOwnerVariable4(String ownOwnerVariable4) {
        this.ownOwnerVariable4 = ownOwnerVariable4;
    }

    @Column(name = "own_ownervariable5")
    public String getOwnOwnerVariable5() {
        return this.ownOwnerVariable5;
    }

    public void setOwnOwnerVariable5(String ownOwnerVariable5) {
        this.ownOwnerVariable5 = ownOwnerVariable5;
    }

    @Column(name = "own_ownervariable6")
    public String getOwnOwnerVariable6() {
        return this.ownOwnerVariable6;
    }

    public void setOwnOwnerVariable6(String ownOwnerVariable6) {
        this.ownOwnerVariable6 = ownOwnerVariable6;
    }

    @Column(name = "own_ownervariable7")
    public String getOwnOwnerVariable7() {
        return this.ownOwnerVariable7;
    }

    public void setOwnOwnerVariable7(String ownOwnerVariable7) {
        this.ownOwnerVariable7 = ownOwnerVariable7;
    }

    @Column(name = "own_ownervariable8")
    public String getOwnOwnerVariable8() {
        return this.ownOwnerVariable8;
    }

    public void setOwnOwnerVariable8(String ownOwnerVariable8) {
        this.ownOwnerVariable8 = ownOwnerVariable8;
    }

    @Column(name = "own_ownervariable9")
    public String getOwnOwnerVariable9() {
        return this.ownOwnerVariable9;
    }

    public void setOwnOwnerVariable9(String ownOwnerVariable9) {
        this.ownOwnerVariable9 = ownOwnerVariable9;
    }

    @Column(name = "own_ownervariable10")
    public String getOwnOwnerVariable10() {
        return this.ownOwnerVariable10;
    }

    public void setOwnOwnerVariable10(String ownOwnerVariable10) {
        this.ownOwnerVariable10 = ownOwnerVariable10;
    }

    /*@ManyToOne
    @JoinColumn(name = "own_owneraddressid",nullable = false)
    public AdrAddress getAdrAddress() {
        return adrAddress;
    }

    public void setAdrAddress(AdrAddress adrAddress) {
        this.adrAddress = adrAddress;
    }*/

    @Column(name = "own_ownername",nullable = false,length = 50)
    public String getOwnOwnerName() {
        return ownOwnerName;
    }

    public void setOwnOwnerName(String name) {
        this.ownOwnerName = name;
    }
    @Column(name = "own_ownersurname",nullable = false,length = 50)

    public String getOwnOwnerSurname() {
        return ownOwnerSurname;
    }

    public void setOwnOwnerSurname(String ownOwnerSurname) {
        this.ownOwnerSurname = ownOwnerSurname;
    }
    @Column(name = "own_owneremail",nullable = false,length = 100)

    public String getOwnOwnerEmail() {
        return ownOwnerEmail;
    }

    public void setOwnOwnerEmail(String ownOwnerEmail) {
        this.ownOwnerEmail = ownOwnerEmail;
    }
    @Column(name = "own_ownerprimarytel",length = 20)

    public String getOwnOwnerPrimaryTel() {
        return ownOwnerPrimaryTel;
    }

    public void setOwnOwnerPrimaryTel(String ownOwnerPrimaryTel) {
        this.ownOwnerPrimaryTel = ownOwnerPrimaryTel;
    }
    @Column(name = "own_ownersecondarytel",length = 20)

    public String getOwnOwnerSecondaryTel() {
        return ownOwnerSecondaryTel;
    }

    public void setOwnOwnerSecondaryTel(String ownOwnerSecondaryTel) {
        this.ownOwnerSecondaryTel = ownOwnerSecondaryTel;
    }
    @Column(name="own_ownerimage", nullable = false)
    public byte[] getOwnOwnerImage() {
        return ownOwnerImage;
    }

    public void setOwnOwnerImage(byte[] ownOwnerImage) {
        this.ownOwnerImage = ownOwnerImage;
    }


    @Override
    public boolean equals(Object object) {
        boolean result = false;
        if (object == null || object.getClass() != getClass()) {
            result = false;
        } else {
            OwnOwner obj = (OwnOwner) object;
            if (this.getOwnOwnerId() == obj.getOwnOwnerId()) {
                result = true;
            }
        }
        return result;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 7 * hash + (int) this.getOwnOwnerId();
        hash = 7 * hash + (int) this.getOwnOwnerId();
        return hash;
    }
}
