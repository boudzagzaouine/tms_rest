package com.sinno.ems.mapper;

import java.util.*;

/**
 * Created by Adil on 2/24/2017.
 */
public class BankMapper {
    private BankMapper(){

    }
    private static Map<String, String> map;

    static {
        map = new HashMap<>();

        map.put("id","prmBankId");
        map.put("code","prmBankCode");
        map.put("name","prmBankName");
        map.put("description","prmBankDescription");
        map.put("organisation","prmBankOrganisation");
        map.put("creationDate","prmBankCreationDate");
        map.put("updateDate","prmBankUpdateDate");
    }

    public static Map<String, String> getMap() {
        return map;
    }
    public static String getField(String key) {
        return map.get(key);
    }

    public static PrmBank toEntity(Bank bank, boolean lazy) {
        PrmBank prmBank = new PrmBank();
        prmBank.setPrmBankId(bank.getId());
        prmBank.setPrmBankCode(bank.getCode());
        prmBank.setPrmBankName(bank.getName());
        prmBank.setPrmBankDescription(bank.getDescription());
        prmBank.setPrmBankCreationDate(bank.getCreationDate());
        prmBank.setPrmBankUpdateDate(bank.getUpdateDate());
        if(!lazy){
            prmBank.setPrmBankOrganisation(OrganisationMapper.toEntity(bank.getOrganisation(), true));
        }
        return prmBank;
    }

    public static Bank toDto(PrmBank prmBank, boolean lazy){
        Bank bank = new Bank();
        bank.setId(prmBank.getPrmBankId());
        bank.setCode(prmBank.getPrmBankCode());
        bank.setName(prmBank.getPrmBankName());
        bank.setDescription(prmBank.getPrmBankDescription());
        bank.setCreationDate(prmBank.getPrmBankCreationDate());
        bank.setUpdateDate(prmBank.getPrmBankUpdateDate());

        if (!lazy){
            bank.setOrganisation(OrganisationMapper.toDto(prmBank.getPrmBankOrganisation(), true));
        }

        return bank;
    }

    public static List<Bank> toDtos(List<PrmBank> prmBanks, boolean lazy) {
        if (null == prmBanks) {
            return null;
        }
        List<Bank> banks = new ArrayList<>();
        for (PrmBank prmBank : prmBanks) {
            banks.add(toDto(prmBank, lazy));
        }
        return banks;
    }

    public static List<Bank> toDtos(Iterable<PrmBank> prmBanks, boolean lazy) {
        if (null == prmBanks) {
            return null;
        }
        List<Bank> banks = new ArrayList<>();
        for (PrmBank prmBank : prmBanks) {
            banks.add(toDto(prmBank, lazy));
        }
        return banks;
    }

    public static Set<PrmBank> toEntities(Set<Bank> banks, boolean lazy) {
        if (null == banks) {
            return null;
        }
        Set<PrmBank> prmBanks = new HashSet<>();
        for (Bank bank : banks) {
            prmBanks.add(toEntity(bank, lazy));
        }
        return prmBanks;
    }

    public static Set<Bank> toDtos(Set<PrmBank> prmBanks, boolean lazy) {
        if (null == prmBanks) {
            return null;
        }
        Set<Bank> banks = new HashSet<>();
        for (PrmBank prmBank : prmBanks) {
            banks.add(toDto(prmBank, lazy));
        }
        return banks;
    }
}
