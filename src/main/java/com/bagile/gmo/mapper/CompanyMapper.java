/**
 *
 */
package com.bagile.gmo.mapper;

import com.bagile.gmo.dto.Company;
import com.bagile.gmo.entities.CmdCompany;

import java.util.*;

/**
 * @author aelguezzar
 */
public class CompanyMapper {
    private CompanyMapper() {

    }

    private static Map<String, String> map;

    static {
        map = new HashMap<>();
        map.put("id", "cmdCompanyId");
        map.put("owner", "ownOwner");
        map.put("code", "cmdCompanyCode");
        map.put("siret", "cmdCompanySiret");
        map.put("comment", "cmdCompanyComment");
        map.put("creationDate", "cmdCompanyCreationDate");
        map.put("updateDate", "cmdCompanyUpdateDate");
        map.put("variable1", "cmdCompanyVariable1");
        map.put("variable2", "cmdCompanyVariable2");
        map.put("variable3", "cmdCompanyVariable3");
        map.put("variable4", "cmdCompanyVariable4");
        map.put("variable5", "cmdCompanyVariable5");
        map.put("variable6", "cmdCompanyVariable6");
        map.put("variable7", "cmdCompanyVariable7");
        map.put("variable8", "cmdCompanyVariable8");
        map.put("variable9", "cmdCompanyVariable9");
        map.put("variable10", "cmdCompanyVariable10");
        map.put("name", "cmdCompanyName");
        map.put("address", "adrAddress");
        map.put("commonIdentifierOfCompany", "cmdCommonIdentifierOfCompany");
        map.put("fiscalIdentifier", "cmdCompanyProfessionalTax");
        map.put("professionalTax", "cmdCompanyProfessionalTax");
        map.put("tradeRegister", "cmdCompanyTradeRegister");
        map.put("cnssNumber", "cmdCompanyCnssNumber");
    }

    public static String getField(String key) {
        return map.get(key);
    }


    public static Map<String, String> getMap() {
        return map;
    }

    public static Company toDto(CmdCompany cmdCompany, boolean lazy) {
        if (null == cmdCompany) {
            return null;
        }
        Company company = new Company();
        company.setCode(cmdCompany.getCmdCompanyCode());
        company.setComment(cmdCompany.getCmdCompanyComment());
        company.setCreationDate(cmdCompany.getCmdCompanyCreationDate());
        company.setId(cmdCompany.getCmdCompanyId());
        company.setSiret(cmdCompany.getCmdCompanySiret());
        company.setUpdateDate(cmdCompany.getCmdCompanyUpdateDate());
        company.setVariable1(cmdCompany.getCmdCompanyVariable1());
        company.setVariable2(cmdCompany.getCmdCompanyVariable2());
        company.setVariable3(cmdCompany.getCmdCompanyVariable3());
        company.setVariable4(cmdCompany.getCmdCompanyVariable4());
        company.setVariable5(cmdCompany.getCmdCompanyVariable5());
        company.setVariable6(cmdCompany.getCmdCompanyVariable6());
        company.setVariable7(cmdCompany.getCmdCompanyVariable7());
        company.setVariable8(cmdCompany.getCmdCompanyVariable8());
        company.setVariable9(cmdCompany.getCmdCompanyVariable9());
        company.setVariable10(cmdCompany.getCmdCompanyVariable10());
        company.setName(cmdCompany.getCmdCompanyName());
        company.setCnssNumber(cmdCompany.getCmdCompanyCnssNumber());
        company.setProfessionalTax(cmdCompany.getCmdCompanyProfessionalTax());
        company.setCommonIdentifierOfCompany(cmdCompany.getCmdCommonIdentifierOfCompany());
        company.setTradeRegister(cmdCompany.getCmdCompanyTradeRegister());
        company.setFiscalIdentifier(cmdCompany.getCmdCompanyFiscalIdentifier());
        company.setUpdatedBy(cmdCompany.getUpdatedBy());
        company.setCreatedBy(cmdCompany.getCreatedBy());
        if (!lazy) {
            company.setOwner(OwnerMapper.toDto(cmdCompany.getOwnOwner(), true));
            company.setAddress(AddressMapper.toDto(cmdCompany.getAdrAddress(), true));
            //company.setAccounts(AccountMapper.toDtos(cmdCompany.getCmdAccounts(), true));
        }
        return company;
    }

    public static CmdCompany toEntity(Company company, boolean lazy) {
        if (null == company) {
            return null;
        }
        CmdCompany cmdCompany = new CmdCompany();
        cmdCompany.setCmdCompanyCode(company.getCode() != null ? company.getCode().toUpperCase() : null);
        cmdCompany.setCmdCompanyComment(company.getComment());
        cmdCompany.setCmdCompanyCreationDate(company.getCreationDate());
        cmdCompany.setCmdCompanyId(company.getId());
        cmdCompany.setCmdCompanySiret(company.getSiret());
        cmdCompany.setCmdCompanyUpdateDate(company.getUpdateDate());
        cmdCompany.setCmdCompanyVariable1(company.getVariable1());
        cmdCompany.setCmdCompanyVariable2(company.getVariable2());
        cmdCompany.setCmdCompanyVariable3(company.getVariable3());
        cmdCompany.setCmdCompanyVariable4(company.getVariable4());
        cmdCompany.setCmdCompanyVariable5(company.getVariable5());
        cmdCompany.setCmdCompanyVariable6(company.getVariable6());
        cmdCompany.setCmdCompanyVariable7(company.getVariable7());
        cmdCompany.setCmdCompanyVariable8(company.getVariable8());
        cmdCompany.setCmdCompanyVariable9(company.getVariable9());
        cmdCompany.setCmdCompanyVariable10(company.getVariable10());
        cmdCompany.setCmdCompanyName(company.getName());
        company.setCnssNumber(cmdCompany.getCmdCompanyCnssNumber());
        cmdCompany.setCmdCompanyProfessionalTax(company.getProfessionalTax());
        cmdCompany.setCmdCommonIdentifierOfCompany(company.getCommonIdentifierOfCompany());
        cmdCompany.setCmdCompanyTradeRegister(company.getTradeRegister());
        cmdCompany.setCmdCompanyFiscalIdentifier(company.getFiscalIdentifier());
        if (!lazy) {
            //cmdCompany.setCmdAccounts(AccountMapper.toEntities(company.getCards(), true));
            cmdCompany.setOwnOwner(OwnerMapper.toEntity(company.getOwner(), true));
            cmdCompany.setAdrAddress(AddressMapper.toEntity(company.getAddress(), true));
        }
        return cmdCompany;
    }

    public static List<Company> toDtos(List<CmdCompany> cmdCompanies, boolean lazy) {
        if (null == cmdCompanies) {
            return null;
        }
        List<Company> companies = new ArrayList<>();
        for (CmdCompany cmdCompany : cmdCompanies) {
            companies.add(toDto(cmdCompany, lazy));
        }
        return companies;
    }

    public static List<Company> toDtos(Iterable<CmdCompany> cmdCompanies, boolean lazy) {
        if (null == cmdCompanies) {
            return null;
        }
        List<Company> companies = new ArrayList<>();
        for (CmdCompany cmdCompany : cmdCompanies) {
            companies.add(toDto(cmdCompany, lazy));
        }
        return companies;
    }

    public static Set<CmdCompany> toEntities(Set<Company> companies, boolean lazy) {
        if (null == companies) {
            return null;
        }
        Set<CmdCompany> cmdCompanies = new HashSet<>();
        for (Company company : companies) {
            cmdCompanies.add(toEntity(company, lazy));
        }
        return cmdCompanies;
    }

    public static Set<Company> toDtos(Set<CmdCompany> cmdCompanies, boolean lazy) {
        if (null == cmdCompanies) {
            return null;
        }
        Set<Company> companies = new HashSet<>();
        for (CmdCompany cmdCompany : cmdCompanies) {
            companies.add(toDto(cmdCompany, lazy));
        }
        return companies;
    }

}
