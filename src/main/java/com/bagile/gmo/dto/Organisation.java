package com.bagile.gmo.dto;

import java.io.Serializable;

/**
 * Created by Administrateur on 13/04/2016.
 */
public class Organisation  extends EmsDto implements Serializable {

    private long id;

    private String code;

    private String nomOrganisation;

    // private Address address;


    private String telephonePrincipalOrganisation;

    private String fax;

    private String logo;

    private String siret;

    private String classificationFiscale;
    private String description;
    private String nomContactPrincipal;
    private String prenomContactPrincipal;
    private String emailContactPrincipal;
    private String telephoneContactPrincipal;
    private String nomContactLogistique;
    private String prenomContactLogistique;
    private String emailContactLogistique;
    private String telephoneContactLogistique;
    private String comment;
    private Long addressType;
    private String firstAddressLine;
    private String secondAddressLine;
    private String zipCode;
    private String city;
    private String country;
    private String nomAdressSiegePrincipal;
    private Boolean gestionConteneurs;
    private String webSite;
    private String generaleCondition;
    private String commonIdentifierCompany; // ICE
    private String taxpayerIdentification;
    private String  professionalTax; // TP
    private byte[] image;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getNomOrganisation() {
        return nomOrganisation;
    }

    public void setNomOrganisation(String nomOrganisation) {
        this.nomOrganisation = nomOrganisation;
    }

    /* public Address getAddress() {
          return address;
     }

     public void setAddress(Address address) {
          this.address = address;
     }
     */
    public String getTelephonePrincipalOrganisation() {
        return telephonePrincipalOrganisation;
    }

    public void setTelephonePrincipalOrganisation(String telephonePrincipalOrganisation) {
        this.telephonePrincipalOrganisation = telephonePrincipalOrganisation;
    }

    public String getFax() {
        return fax;
    }

    public void setFax(String fax) {
        this.fax = fax;
    }

    public String getLogo() {
        return logo;
    }

    public void setLogo(String logo) {
        this.logo = logo;
    }

    public String getSiret() {
        return siret;
    }

    public void setSiret(String siret) {
        this.siret = siret;
    }

    public String getClassificationFiscale() {
        return classificationFiscale;
    }

    public void setClassificationFiscale(String classificationFiscale) {
        this.classificationFiscale = classificationFiscale;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getNomContactPrincipal() {
        return nomContactPrincipal;
    }

    public void setNomContactPrincipal(String nomContactPrincipal) {
        this.nomContactPrincipal = nomContactPrincipal;
    }

    public String getPrenomContactPrincipal() {
        return prenomContactPrincipal;
    }

    public void setPrenomContactPrincipal(String prenomContactPrincipal) {
        this.prenomContactPrincipal = prenomContactPrincipal;
    }

    public String getEmailContactPrincipal() {
        return emailContactPrincipal;
    }

    public void setEmailContactPrincipal(String emailContactPrincipal) {
        this.emailContactPrincipal = emailContactPrincipal;
    }

    public String getTelephoneContactPrincipal() {
        return telephoneContactPrincipal;
    }

    public void setTelephoneContactPrincipal(String telephoneContactPrincipal) {
        this.telephoneContactPrincipal = telephoneContactPrincipal;
    }

    public String getNomContactLogistique() {
        return nomContactLogistique;
    }

    public void setNomContactLogistique(String nomContactLogistique) {
        this.nomContactLogistique = nomContactLogistique;
    }

    public String getPrenomContactLogistique() {
        return prenomContactLogistique;
    }

    public void setPrenomContactLogistique(String prenomContactLogistique) {
        this.prenomContactLogistique = prenomContactLogistique;
    }

    public String getEmailContactLogistique() {
        return emailContactLogistique;
    }

    public void setEmailContactLogistique(String emailContactLogistique) {
        this.emailContactLogistique = emailContactLogistique;
    }

    public String getTelephoneContactLogistique() {
        return telephoneContactLogistique;
    }

    public void setTelephoneContactLogistique(String telephoneContactLogistique) {
        this.telephoneContactLogistique = telephoneContactLogistique;
    }


    public String getNomAdressSiegePrincipal() {
        return nomAdressSiegePrincipal;
    }

    public void setNomAdressSiegePrincipal(String nomAdressSiegePrincipal) {
        this.nomAdressSiegePrincipal = nomAdressSiegePrincipal;
    }

    public Boolean isGestionConteneurs() {
        return gestionConteneurs;
    }

    public void setGestionConteneurs(Boolean gestionConteneurs) {
        this.gestionConteneurs = gestionConteneurs;
    }


    public Long getAddressType() {
        return addressType;
    }

    public void setAddressType(Long addressType) {
        this.addressType = addressType;
    }

    public String getFirstAddressLine() {
        return firstAddressLine;
    }

    public void setFirstAddressLine(String firstAddressLine) {
        this.firstAddressLine = firstAddressLine;
    }

    public String getSecondAddressLine() {
        return secondAddressLine;
    }

    public void setSecondAddressLine(String secondAddressLine) {
        this.secondAddressLine = secondAddressLine;
    }

    public String getZipCode() {
        return zipCode;
    }

    public void setZipCode(String zipCode) {
        this.zipCode = zipCode;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }


    @Override
    public boolean equals(Object object) {
        boolean result = false;
        if (object == null || object.getClass() != getClass()) {
            result = false;
        } else {
            Organisation obj = (Organisation) object;
            if (this.id == obj.getId()) {
                result = true;
            }
        }
        return result;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 7 * hash + (int) this.id;
        hash = 7 * hash + (int) this.id;
        return hash;
    }

	/**
	 * @return the image
	 */
	public byte[] getImage() {
		return image;
	}

	/**
	 * @param image the image to set
	 */
	public void setImage(byte[] image) {
		this.image = image;
	}

    public String getWebSite() {
        return webSite;
    }

    public void setWebSite(String webSite) {
        this.webSite = webSite;
    }

    public String getGeneraleCondition() {
        return generaleCondition;
    }

    public void setGeneraleCondition(String generaleCondition) {
        this.generaleCondition = generaleCondition;
    }

    public String getCommonIdentifierCompany() {
        return commonIdentifierCompany;
    }

    public void setCommonIdentifierCompany(String commonIdentifierCompany) {
        this.commonIdentifierCompany = commonIdentifierCompany;
    }

    public String getTaxpayerIdentification() {
        return taxpayerIdentification;
    }

    public void setTaxpayerIdentification(String taxpayerIdentification) {
        this.taxpayerIdentification = taxpayerIdentification;
    }

    public String getProfessionalTax() {
        return professionalTax;
    }

    public void setProfessionalTax(String professionalTax) {
        this.professionalTax = professionalTax;
    }
}
