package com.bagile.tms.entities;

import javax.persistence.*;
import javax.validation.constraints.Max;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 * Created by Enissay on 13/04/2016.
 */
@Entity
@Table(name="org_organisation")
public class OrgOrganisation {
    private long orgOrganisationId;
    @NotNull
    @Size(max = 30)
    private String orgOrganisationCode;
    @NotNull
    @Size(max = 50)
    private String orgOrganisationNom;
    @NotNull
    @Size(max = 50)
    private String orgOrganisationLine1;
    @Size(max = 50)
    private String orgOrganisationLine2;
    @NotNull
    @Size(max = 10)
    private String orgOrganisationZip;
    @NotNull
    @Size(max = 50)
    private String orgOrganisationCity;
    @NotNull
    @Size(max = 50)
    private String orgOrganisationCountry;
    @NotNull
    @Size(max = 20)
    private String orgOrganisationTelephone;
    @NotNull
    @Size(max = 20)
    private String orgOrganisationFax;
    private String orgOrganisationLogo;
    @NotNull
    @Size(max = 20)
    private String orgOrganisationSiret;
    @Size(max = 5)
    private String orgOrganisationClassicationFisclae;
    @Size(max = 255)
    private String orgOrganisationDescription;
    @NotNull
    @Size(max = 50)
    private String orgOrganisationNomContact;
    @NotNull
    @Size(max = 50)
    private String orgOrganisationPrenomContact;
    @Size(max = 100)
    private String orgOrganisationEmailContact;
    @Size(max = 20)
    private String orgOrganisationTelephoneContact;
    @NotNull
    @Size(max = 50)
    private String orgOrganisationNomContactLogistique;
    @NotNull
    @Size(max = 50)
    private String orgOrganisationPrenomContactLogistique;
    @Size(max = 50)
    private String orgOrganisationEmailContactLogistique;
    @Size(max = 20)
    private String orgOrganisationTelephoneContactLogistique;
    @Size(max = 255)
    private String orgOrganisationCommentaire;

    @NotNull
    @Size(max = 30)
    private String orgOrganisationNomAdressSiegePrincipale;
    @Max(999999999)
    private Long orgOrganisationTypeAdress;
    private Boolean orgOrganisationGestionConteneurs;
 
    private OwnOwner ownOwner;
    private String orgOrganisationWebSite;
    private String orgOrganisationGeneraleCondition;

    private byte[] orgOrganisationImage;

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq")
    @SequenceGenerator(name = "seq", sequenceName = "seq_org_organisation", allocationSize = 1)
    @Column(name = "org_organisationid", unique = true, nullable = false, precision = 10, scale = 0)
    public long getOrgOrganisationId() {
        return orgOrganisationId;
    }

    public void setOrgOrganisationId(long orgOrganisationId) {
        this.orgOrganisationId = orgOrganisationId;
    }

    @Column(name="org_organisationline1",nullable = false, length = 50)
    public String getOrgOrganisationLine1() {
        return orgOrganisationLine1;
    }

    public void setOrgAddressLine1(String orgOrganisationLine1) {
        this.orgOrganisationLine1 = orgOrganisationLine1;
    }

    @Column(name="org_organisationline2", length = 50)
    public String getOrgOrganisationLine2() {
        return orgOrganisationLine2;
    }

    public void setOrgOrganisationLine2(String orgOrganisationLine2) {
        this.orgOrganisationLine2 = orgOrganisationLine2;
    }

    @Column(name="org_organisationzip",nullable = false, length = 10)
    public String getOrgOrganisationZip() {
        return orgOrganisationZip;
    }

    public void setOrgOrganisationZip(String orgOrganisationZip) {
        this.orgOrganisationZip = orgOrganisationZip;
    }

    @Column(name="org_organisationcity",nullable = false, length = 50)
    public String getOrgOrganisationCity() {
        return orgOrganisationCity;
    }

    public void setOrgOrganisationCity(String orgOrganisationCity) {
        this.orgOrganisationCity = orgOrganisationCity;
    }

    @Column(name="org_organisationcountry",nullable = false, length = 50)
    public String getOrgOrganisationCountry() {
        return orgOrganisationCountry;
    }

    public void setOrgOrganisationCountry(String orgOrganisationCountry) {
        this.orgOrganisationCountry = orgOrganisationCountry;
    }

    public void setOrgOrganisationNomAdressSiegePrincipale(String orgOrganisationNomAdressSiegePrincipale) {
        this.orgOrganisationNomAdressSiegePrincipale = orgOrganisationNomAdressSiegePrincipale;
    }

    @Column(name="org_organisationnomadresssiegeprincipale",nullable = false, length = 30)
    public String getOrgOrganisationNomAdressSiegePrincipale() {
        return orgOrganisationNomAdressSiegePrincipale;
    }

    public void setOrgOrganisationTypeAdress(Long orgOrganisationTypeAdress) {
        this.orgOrganisationTypeAdress = orgOrganisationTypeAdress;
    }

    @Column(name="org_organisationtypeadress", precision = 10, scale = 0)
    public Long getOrgOrganisationTypeAdress() {
        return orgOrganisationTypeAdress;
    }

    @Column(name="org_organisationgestionconteneurs")
    public Boolean getOrgOrganisationGestionConteneurs() {
        return orgOrganisationGestionConteneurs;
    }

    public void setOrgOrganisationGestionConteneurs(Boolean orgOrganisationGestionConteneurs) {
        this.orgOrganisationGestionConteneurs = orgOrganisationGestionConteneurs;
    }

    @Column(name="org_organisationcode",nullable = false,length = 30)
    public String getOrgOrganisationCode() {
        return orgOrganisationCode;
    }

    public void setOrgOrganisationCode(String orgOrganisationCode) {
        this.orgOrganisationCode = orgOrganisationCode;
    }
    @Column(name="org_organisationnom",nullable = false, length = 50)
    public String getOrgOrganisationNom() {
        return orgOrganisationNom;
    }

    public void setOrgOrganisationNom(String orgOrganisationNom) {
        this.orgOrganisationNom = orgOrganisationNom;
    }

    @Column(name="org_organisationtelephone",nullable = false, length = 20)
    public String getOrgOrganisationTelephone() {
        return orgOrganisationTelephone;
    }

    public void setOrgOrganisationTelephone(String orgOrganisationTelephone) {
        this.orgOrganisationTelephone = orgOrganisationTelephone;
    }
    @Column(name="org_organisationfax",nullable = false, length = 20)

    public String getOrgOrganisationFax() {
        return orgOrganisationFax;
    }

    public void setOrgOrganisationFax(String orgOrganisationFax) {
        this.orgOrganisationFax = orgOrganisationFax;
    }
    @Column(name="org_organisationlogo")
    public String getOrgOrganisationLogo() {
        return orgOrganisationLogo;
    }

    public void setOrgOrganisationLogo(String orgOrganisationLogo) {
        this.orgOrganisationLogo = orgOrganisationLogo;
    }
    @Column(name="org_organisationsiret",nullable = false, length = 20)
    public String getOrgOrganisationSiret() {
        return orgOrganisationSiret;
    }

    public void setOrgOrganisationSiret(String orgOrganisationSiret) {
        this.orgOrganisationSiret = orgOrganisationSiret;
    }
    @Column(name="org_organisationclasifactionfiscale", length = 5)

    public String getOrgOrganisationClassicationFisclae() {
        return orgOrganisationClassicationFisclae;
    }

    public void setOrgOrganisationClassicationFisclae(String orgOrganisationClassicationFisclae) {
        this.orgOrganisationClassicationFisclae = orgOrganisationClassicationFisclae;
    }
    @Column(name="org_organisationdescription", length = 255)
    public String getOrgOrganisationDescription() {
        return orgOrganisationDescription;
    }

    public void setOrgOrganisationDescription(String orgOrganisationDescription) {
        this.orgOrganisationDescription = orgOrganisationDescription;
    }
    @Column(name="org_organisationnomcontact",nullable = false, length = 50)

    public String getOrgOrganisationNomContact() {
        return orgOrganisationNomContact;
    }

    public void setOrgOrganisationNomContact(String orgOrganisationNomContact) {
        this.orgOrganisationNomContact = orgOrganisationNomContact;
    }
    @Column(name="org_organisationprenomcontact",nullable = false, length = 50)

    public String getOrgOrganisationPrenomContact() {
        return orgOrganisationPrenomContact;
    }

    public void setOrgOrganisationPrenomContact(String orgOrganisationPrenomContact) {
        this.orgOrganisationPrenomContact = orgOrganisationPrenomContact;
    }
    @Column(name="org_organisationemailcontact", length = 100)
    public String getOrgOrganisationEmailContact() {
        return orgOrganisationEmailContact;
    }

    public void setOrgOrganisationEmailContact(String orgOrganisationEmailContact) {
        this.orgOrganisationEmailContact = orgOrganisationEmailContact;
    }

    @Column(name="org_organisationtelephonecontact", length = 20)
    public String getOrgOrganisationTelephoneContact() {
        return orgOrganisationTelephoneContact;
    }

    public void setOrgOrganisationTelephoneContact(String orgOrganisationTelephoneContact) {
        this.orgOrganisationTelephoneContact = orgOrganisationTelephoneContact;
    }
    @Column(name="org_organisationnomcontactlogistique",nullable = false, length = 50)
    public String getOrgOrganisationNomContactLogistique() {
        return orgOrganisationNomContactLogistique;
    }

    public void setOrgOrganisationNomContactLogistique(String orgOrganisationNomContactLogistique) {
        this.orgOrganisationNomContactLogistique = orgOrganisationNomContactLogistique;
    }
    @Column(name="org_organisationprenomcontactlogistique",nullable = false, length = 50)

    public String getOrgOrganisationPrenomContactLogistique() {
        return orgOrganisationPrenomContactLogistique;
    }

    public void setOrgOrganisationPrenomContactLogistique(String orgOrganisationPrenomContactLogistique) {
        this.orgOrganisationPrenomContactLogistique = orgOrganisationPrenomContactLogistique;
    }

    @Column(name="org_organisationemailcontactlogistique", length = 50)

    public String getOrgOrganisationEmailContactLogistique() {
        return orgOrganisationEmailContactLogistique;
    }

    public void setOrgOrganisationEmailContactLogistique(String orgOrganisationEmailContactLogistique) {
        this.orgOrganisationEmailContactLogistique = orgOrganisationEmailContactLogistique;
    }
    @Column(name="org_organisationtelephonecontactlogistique", length = 20)

    public String getOrgOrganisationTelephoneContactLogistique() {
        return orgOrganisationTelephoneContactLogistique;
    }

    public void setOrgOrganisationTelephoneContactLogistique(String orgOrganisationTelephoneContactLogistique) {
        this.orgOrganisationTelephoneContactLogistique = orgOrganisationTelephoneContactLogistique;
    }
    @Column(name="org_organisationcommentaire", length = 255)
    public String getOrgOrganisationCommentaire() {
        return orgOrganisationCommentaire;
    }

    public void setOrgOrganisationCommentaire(String orgOrganisationCommentaire) {
        this.orgOrganisationCommentaire = orgOrganisationCommentaire;
    }

    public void setOrgOrganisationLine1(String orgOrganisationLine1) {
        this.orgOrganisationLine1 = orgOrganisationLine1;
    }

    public OwnOwner getOwnOwner() {
        return ownOwner;
    }

    public void setOwnOwner(OwnOwner ownOwner) {
        this.ownOwner = ownOwner;
    }

    public OrgOrganisation() {
    }

	/**
	 * @return the orgOrganisationImage
	 */
    @Column(name="org_organisationimage", nullable = false)
	public byte[] getOrgOrganisationImage() {
		return orgOrganisationImage;
	}

	/**
	 * @param orgOrganisationImage the orgOrganisationImage to set
	 */
	public void setOrgOrganisationImage(byte[] orgOrganisationImage) {
		this.orgOrganisationImage = orgOrganisationImage;
	}
    @Column(name = "org_organisationwebsite")
    public String getOrgOrganisationWebSite() {
        return orgOrganisationWebSite;
    }
    public void setOrgOrganisationWebSite(String orgOrganisationWebSite) {
        this.orgOrganisationWebSite = orgOrganisationWebSite;
    }

    @Column(name = "org_organisationgeneralcondition")
    public String getOrgOrganisationGeneraleCondition() {
        return orgOrganisationGeneraleCondition;
    }

    public void setOrgOrganisationGeneraleCondition(String orgOrganisationGeneraleCondition) {
        this.orgOrganisationGeneraleCondition = orgOrganisationGeneraleCondition;
    }


}
