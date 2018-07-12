package com.sinno.ems.mapper;

import java.util.*;

/**
 * Created by Adil on 1/24/2017.
 */
public class AccountWarrantyMapper {
    private AccountWarrantyMapper(){}

    private static Map<String, String> map;
    static {
        map = new HashMap<>();
        map.put("id","pdtAccountWarrantyId");
        map.put("code","pdtAccountWarrantyCode");
        map.put("product","pdtAccountWarrantyProduct");
        map.put("serialNumber","pdtAccountWarrantySerialNumber");
        map.put("beginDate","pdtAccountWarrantyBeginDate");
        map.put("endDate","pdtAccountWarrantyEndDate");
        map.put("creationDate","pdtAccountWarrantyCreation");
        map.put("updateDate","pdtAccountWarrantyUpdateDate");
    }

    public static Map<String, String> getMap() {
        return map;
    }

    public static String getField(String key) {
        return map.get(key);
    }

    public static AccountWarranty toDto(PdtAccountWarranty pdtAccountWarranty, boolean lazy){

        if (null == pdtAccountWarranty) return null;

        AccountWarranty accountWarranty = new AccountWarranty();
        accountWarranty.setCode(pdtAccountWarranty.getPdtAccountWarrantyCode());
        accountWarranty.setSerialNumber(pdtAccountWarranty.getPdtAccountWarrantyProductSerialNumber());
        accountWarranty.setBeginDate(pdtAccountWarranty.getPdtAccountWarrantyBeginDate());
        accountWarranty.setEndDate(pdtAccountWarranty.getPdtAccountWarrantyEndDate());
        accountWarranty.setCreationDate(pdtAccountWarranty.getPdtAccountCreationDate());
        accountWarranty.setUpdateDate(pdtAccountWarranty.getPdtAccountUpdateDate());

        if(!lazy){
            accountWarranty.setProduct(ProductMapper.toDto(pdtAccountWarranty.getPdtAccountWarrantyProduct(), true));
        }

        return accountWarranty;

    }

    public static PdtAccountWarranty toEntity(AccountWarranty accountWarranty, boolean lazy){

        PdtAccountWarranty pdtAccountWarranty = new PdtAccountWarranty();

        pdtAccountWarranty.setPdtAccountWarrantyCode(accountWarranty.getCode());
        pdtAccountWarranty.setPdtAccountWarrantyProductSerialNumber(accountWarranty.getSerialNumber());
        pdtAccountWarranty.setPdtAccountWarrantyBeginDate(accountWarranty.getBeginDate());
        pdtAccountWarranty.setPdtAccountWarrantyEndDate(accountWarranty.getEndDate());
        pdtAccountWarranty.setPdtAccountCreationDate(accountWarranty.getCreationDate());
        pdtAccountWarranty.setPdtAccountUpdateDate(accountWarranty.getUpdateDate());

        if (!lazy) {
            pdtAccountWarranty.setPdtAccountWarrantyProduct(ProductMapper.toEntity(accountWarranty.getProduct(), true));
        }

        return pdtAccountWarranty;
    }
    
    
    public static List<AccountWarranty> toDtos(List<PdtAccountWarranty> pdtAccountWarrantys, boolean lazy) {
        if (null == pdtAccountWarrantys) {
            return null;
        }
        List<AccountWarranty> accounts = new ArrayList<>();
        for (PdtAccountWarranty pdtAccountWarranty : pdtAccountWarrantys) {
            accounts.add(toDto(pdtAccountWarranty, lazy));
        }
        return accounts;
    }

    public static List<AccountWarranty> toDtos(Iterable<PdtAccountWarranty> pdtAccountWarrantys, boolean lazy) {
        if (null == pdtAccountWarrantys) {
            return null;
        }
        List<AccountWarranty> accounts = new ArrayList<>();
        for (PdtAccountWarranty pdtAccountWarranty : pdtAccountWarrantys) {
            accounts.add(toDto(pdtAccountWarranty, lazy));
        }
        return accounts;
    }

    public static Set<PdtAccountWarranty> toEntities(Set<AccountWarranty> accounts, boolean lazy) {
        if (null == accounts) {
            return null;
        }
        Set<PdtAccountWarranty> pdtAccountWarrantys = new HashSet<>();
        for (AccountWarranty account : accounts) {
            pdtAccountWarrantys.add(toEntity(account, lazy));
        }
        return pdtAccountWarrantys;
    }

    public static Set<AccountWarranty> toDtos(Set<PdtAccountWarranty> pdtAccountWarrantys, boolean lazy) {
        if (null == pdtAccountWarrantys) {
            return null;
        }
        Set<AccountWarranty> accounts = new HashSet<>();
        for (PdtAccountWarranty pdtAccountWarranty : pdtAccountWarrantys) {
            accounts.add(toDto(pdtAccountWarranty, lazy));
        }
        return accounts;
    }
}
