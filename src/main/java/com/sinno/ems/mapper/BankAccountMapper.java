package com.sinno.ems.mapper;

import com.sinno.ems.dto.BankAccount;
import com.sinno.ems.entities.PrmBankAccount;

import java.util.*;

/**
 * Created by Adil on 2/24/2017.
 */
public class BankAccountMapper {
    private BankAccountMapper(){

    }
    private static Map<String, String> map;

    static {
        map = new HashMap<>();

        map.put("id","prmBankAccountId");
        map.put("code","prmBankAccountCode");
        map.put("number","prmBankAccountNumber");
        map.put("description","prmBankAccountDescription");
        map.put("bankAccount","prmBankAccountBank");
        map.put("creationDate","prmBankAccountCreationDate");
        map.put("updateDate","prmBankAccountUpdateDate");
    }

    public static Map<String, String> getMap() {
        return map;
    }
    public static String getField(String key) {
        return map.get(key);
    }

    public static PrmBankAccount toEntity(BankAccount bankAccount, boolean lazy) {
        PrmBankAccount prmBankAccount = new PrmBankAccount();
        prmBankAccount.setPrmBankAccountId(bankAccount.getId());
        prmBankAccount.setPrmBankAccountCode(bankAccount.getCode());
        prmBankAccount.setPrmBankAccountNumber(bankAccount.getNumber());
        prmBankAccount.setPrmBankAccountDescription(bankAccount.getDescription());
        prmBankAccount.setPrmBankAccountCreationDate(bankAccount.getCreationDate());
        prmBankAccount.setPrmBankAccountUpdateDate(bankAccount.getUpdateDate());
        if(!lazy){
            prmBankAccount.setPrmBankAccountBank(BankMapper.toEntity(bankAccount.getBank(), true));
        }
        return prmBankAccount;
    }

    public static BankAccount toDto(PrmBankAccount prmBankAccount, boolean lazy){
        BankAccount bankAccount = new BankAccount();
        bankAccount.setId(prmBankAccount.getPrmBankAccountId());
        bankAccount.setCode(prmBankAccount.getPrmBankAccountCode());
        bankAccount.setNumber(prmBankAccount.getPrmBankAccountNumber());
        bankAccount.setDescription(prmBankAccount.getPrmBankAccountDescription());
        bankAccount.setCreationDate(prmBankAccount.getPrmBankAccountCreationDate());
        bankAccount.setUpdateDate(prmBankAccount.getPrmBankAccountUpdateDate());

        if (!lazy){
            bankAccount.setBank( BankMapper.toDto(prmBankAccount.getPrmBankAccountBank(), true));
        }

        return bankAccount;
    }

    public static List<BankAccount> toDtos(List<PrmBankAccount> prmBankAccounts, boolean lazy) {
        if (null == prmBankAccounts) {
            return null;
        }
        List<BankAccount> bankAccounts = new ArrayList<>();
        for (PrmBankAccount prmBankAccount : prmBankAccounts) {
            bankAccounts.add(toDto(prmBankAccount, lazy));
        }
        return bankAccounts;
    }

    public static List<BankAccount> toDtos(Iterable<PrmBankAccount> prmBankAccounts, boolean lazy) {
        if (null == prmBankAccounts) {
            return null;
        }
        List<BankAccount> bankAccounts = new ArrayList<>();
        for (PrmBankAccount prmBankAccount : prmBankAccounts) {
            bankAccounts.add(toDto(prmBankAccount, lazy));
        }
        return bankAccounts;
    }

    public static Set<PrmBankAccount> toEntities(Set<BankAccount> bankAccounts, boolean lazy) {
        if (null == bankAccounts) {
            return null;
        }
        Set<PrmBankAccount> prmBankAccounts = new HashSet<>();
        for (BankAccount bankAccount : bankAccounts) {
            prmBankAccounts.add(toEntity(bankAccount, lazy));
        }
        return prmBankAccounts;
    }

    public static Set<BankAccount> toDtos(Set<PrmBankAccount> prmBankAccounts, boolean lazy) {
        if (null == prmBankAccounts) {
            return null;
        }
        Set<BankAccount> bankAccounts = new HashSet<>();
        for (PrmBankAccount prmBankAccount : prmBankAccounts) {
            bankAccounts.add(toDto(prmBankAccount, lazy));
        }
        return bankAccounts;
    }
}
