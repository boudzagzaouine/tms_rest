/**
 *
 */
package com.bagile.gmo.mapper;

import com.bagile.gmo.dto.Organisation;
import com.bagile.gmo.entities.OrgOrganisation;


import java.util.*;

/**
 * @author aelguezzar
 */
public class OrganisationMapper {
    private OrganisationMapper() {
    }

    private static Map<String, String> map;

    static {
        map = new HashMap<>();

        map.put("id", "orgOrganisationId");
        map.put("nomOrganisation", "orgOrganisationNom_Organisation");
        map.put("line1", "orgOrganisationLine1");
        map.put("line2", "orgOrganisationLine2");
        map.put("zip", "orgOrganisationZip");
        map.put("city", "orgOrganisationCity");
        map.put("country", "orgOrganisationCountry");
        map.put("nomAdressSiegePrincipale", "orgOrganisationNomAdressSiegePrincipale");
        map.put("addressType", "orgOrganisationTypeAdress");
        map.put("containerManager", "orgOrganisationGestionConteneurs");
        map.put("code", "orgOrganisationCode");
        map.put("telephonePrincipalOrganisation", "orgOrganisationTelephone_Principal_Organisation");
        map.put("fax", "orgOrganisationFax");
        map.put("logo", "orgOrganisationLogo");
        map.put("siret", "orgOrganisationSiret");
        map.put("classificationFiscale", "orgOrganisationClassificationFisclae");
        map.put("description", "orgOrganisationDescription");
        map.put("nomContactPrincipal", "orgOrganisationNom_Contact_Principal");
        map.put("prenomContactPrincipal", "orgOrganisationoPrenom_Contact_Principal");
        map.put("emailContactPrincipal", "orgOrganisationEmail_Contact_Principal");
        map.put("telephoneContactPrincipal", "orgOrganisationTelephone_Contact_Principal");
        map.put("nomContactLogistique", "orgOrganisationNom_Contact_Logistique");
        map.put("prenomContactLogistique", "orgOrganisationPrenom_Contact_Logistique");
        map.put("emailContactLogistique", "orgOrganisationEmail_Contact_Logistique");
        map.put("telephoneContactLogistique", "orgOrganisationTelephone_Contact_Logistique");
        map.put("commentaire", "orgOrganisationCommentaire");
        map.put("image", "orgOrganisationImage");
        map.put("webSite","orgOrganisationWebSite");
        map.put("commonIdentifierCompany","orgOrganisationCommonIdentifierCompany");
        map.put("taxpayerIdentification","orgOrganisationTaxpayerIdentification");
        map.put("professionalTax","orgOrganisationProfessionalTax");

    }

    public static Map<String, String> getMap() {
        return map;
    }

    public static String getField(String key) {
        return map.get(key);
    }

    public static Organisation toDto(OrgOrganisation orgOrganisation, boolean lazy) {
        if (null == orgOrganisation) {
            return null;
        }
        Organisation organisation = new Organisation();

        organisation.setId(orgOrganisation.getOrgOrganisationId());
        organisation.setNomOrganisation(orgOrganisation.getOrgOrganisationNom());
        organisation.setTelephonePrincipalOrganisation(orgOrganisation.getOrgOrganisationTelephone());
        organisation.setWebSite(orgOrganisation.getOrgOrganisationWebSite());
        organisation.setGeneraleCondition(orgOrganisation.getOrgOrganisationGeneraleCondition());
        organisation.setAddressType(orgOrganisation.getOrgOrganisationTypeAdress());
        organisation.setCity(orgOrganisation.getOrgOrganisationCity());
        organisation.setGestionConteneurs(orgOrganisation.getOrgOrganisationGestionConteneurs());
        organisation.setNomAdressSiegePrincipal(orgOrganisation.getOrgOrganisationNomAdressSiegePrincipale());
        organisation.setFirstAddressLine(orgOrganisation.getOrgOrganisationLine1());
        organisation.setSecondAddressLine(orgOrganisation.getOrgOrganisationLine2());
        organisation.setZipCode(orgOrganisation.getOrgOrganisationZip());
        organisation.setCountry(orgOrganisation.getOrgOrganisationCountry());

        organisation.setFax(orgOrganisation.getOrgOrganisationFax());
        organisation.setCode(orgOrganisation.getOrgOrganisationCode());
        organisation.setLogo(orgOrganisation.getOrgOrganisationLogo());
        organisation.setSiret(orgOrganisation.getOrgOrganisationSiret());
        organisation.setClassificationFiscale(orgOrganisation.getOrgOrganisationClassicationFisclae());
        organisation.setDescription(orgOrganisation.getOrgOrganisationDescription());
        organisation.setNomContactPrincipal(orgOrganisation.getOrgOrganisationNomContact());
        organisation.setPrenomContactPrincipal(orgOrganisation.getOrgOrganisationPrenomContact());
        organisation.setNomContactLogistique(orgOrganisation.getOrgOrganisationNomContactLogistique());
        organisation.setPrenomContactLogistique(orgOrganisation.getOrgOrganisationPrenomContactLogistique());
        organisation.setEmailContactLogistique(orgOrganisation.getOrgOrganisationEmailContactLogistique());
        organisation.setTelephoneContactLogistique(orgOrganisation.getOrgOrganisationTelephoneContactLogistique());
        organisation.setComment(orgOrganisation.getOrgOrganisationCommentaire());
        organisation.setEmailContactPrincipal(orgOrganisation.getOrgOrganisationEmailContact());
        organisation.setTelephoneContactPrincipal(orgOrganisation.getOrgOrganisationTelephoneContact());
        organisation.setCommonIdentifierCompany(orgOrganisation.getOrgOrganisationCommonIdentifierCompany());
        organisation.setTaxpayerIdentification(orgOrganisation.getOrgOrganisationTaxpayerIdentification());
        organisation.setProfessionalTax(orgOrganisation.getOrgOrganisationProfessionalTax());

        organisation.setImage(orgOrganisation.getOrgOrganisationImage());
        return organisation;
    }

    public static OrgOrganisation toEntity(Organisation organisation, boolean lazy) {
        if (null == organisation) {
            return null;
        }
        OrgOrganisation orgOrganisation = new OrgOrganisation();

        orgOrganisation.setOrgOrganisationId(organisation.getId());
        orgOrganisation.setOrgOrganisationCode(organisation.getCode() != null ? organisation.getCode().toUpperCase() : null);
        orgOrganisation.setOrgOrganisationNom(organisation.getNomOrganisation());
        orgOrganisation.setOrgOrganisationTelephone(organisation.getTelephonePrincipalOrganisation());
        orgOrganisation.setOrgOrganisationWebSite(organisation.getWebSite());
        orgOrganisation.setOrgOrganisationGeneraleCondition(organisation.getGeneraleCondition());
        orgOrganisation.setOrgOrganisationCity(organisation.getCity());
        orgOrganisation.setOrgAddressLine1(organisation.getFirstAddressLine());
        orgOrganisation.setOrgOrganisationLine2(organisation.getSecondAddressLine());
        orgOrganisation.setOrgOrganisationCountry(organisation.getCountry());
        orgOrganisation.setOrgOrganisationGestionConteneurs(organisation.isGestionConteneurs());
        orgOrganisation.setOrgOrganisationTypeAdress(organisation.getAddressType());
        orgOrganisation.setOrgOrganisationZip(organisation.getZipCode());
        orgOrganisation.setOrgOrganisationNomAdressSiegePrincipale(organisation.getNomAdressSiegePrincipal());

        orgOrganisation.setOrgOrganisationFax(organisation.getFax());
        orgOrganisation.setOrgOrganisationLogo(organisation.getLogo());
        orgOrganisation.setOrgOrganisationSiret(organisation.getSiret());
        orgOrganisation.setOrgOrganisationClassicationFisclae(organisation.getClassificationFiscale());
        orgOrganisation.setOrgOrganisationDescription(organisation.getDescription());
        orgOrganisation.setOrgOrganisationNomContact(organisation.getNomContactPrincipal());
        orgOrganisation.setOrgOrganisationPrenomContact(organisation.getPrenomContactPrincipal());
        orgOrganisation.setOrgOrganisationNomContactLogistique(organisation.getNomContactLogistique());
        orgOrganisation.setOrgOrganisationPrenomContactLogistique(organisation.getPrenomContactLogistique());
        orgOrganisation.setOrgOrganisationEmailContactLogistique(organisation.getEmailContactLogistique());
        orgOrganisation.setOrgOrganisationTelephoneContactLogistique(organisation.getTelephoneContactLogistique());
        orgOrganisation.setOrgOrganisationCommentaire(organisation.getComment());
        orgOrganisation.setOrgOrganisationEmailContact(organisation.getEmailContactPrincipal());
        orgOrganisation.setOrgOrganisationTelephoneContact(organisation.getTelephoneContactPrincipal());
        orgOrganisation.setOrgOrganisationImage(organisation.getImage());
        orgOrganisation.setOrgOrganisationCommonIdentifierCompany(organisation.getCommonIdentifierCompany());
        orgOrganisation.setOrgOrganisationTaxpayerIdentification(organisation.getTaxpayerIdentification());
        orgOrganisation.setOrgOrganisationProfessionalTax(organisation.getProfessionalTax());

        return orgOrganisation;
    }

    public static List<Organisation> toDtos(List<OrgOrganisation> orgOrganisations, boolean lazy) {
        if (null == orgOrganisations) {
            return null;
        }
        List<Organisation> organisations = new ArrayList<>();
        for (OrgOrganisation orgOrganisation : orgOrganisations) {
            organisations.add(toDto(orgOrganisation, lazy));
        }
        return organisations;
    }

    public static List<Organisation> toDtos(Iterable<OrgOrganisation> orgOrganisations, boolean lazy) {
        if (null == orgOrganisations) {
            return null;
        }
        List<Organisation> organisations = new ArrayList<>();
        for (OrgOrganisation orgOrganisation : orgOrganisations) {
            organisations.add(toDto(orgOrganisation, lazy));
        }
        return organisations;
    }

    public static Set<OrgOrganisation> toEntities(Set<Organisation> organisations, boolean lazy) {
        if (null == organisations) {
            return null;
        }
        Set<OrgOrganisation> orgOrganisations = new HashSet<>();
        for (Organisation organisation : organisations) {
            orgOrganisations.add(toEntity(organisation, lazy));
        }
        return orgOrganisations;
    }

    public static Set<Organisation> toDtos(Set<OrgOrganisation> orgOrganisations, boolean lazy) {
        if (null == orgOrganisations) {
            return null;
        }
        Set<Organisation> organisations = new HashSet<>();
        for (OrgOrganisation orgOrganisation : orgOrganisations) {
            organisations.add(toDto(orgOrganisation, lazy));
        }
        return organisations;
    }
}
