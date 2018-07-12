package com.sinno.ems.mapper;

import com.sinno.ems.dto.Currency;

import java.util.*;

/**
 * Created by Enissay on 22/12/2016.
 */
public class CurrencyMapper {
    private static Map<String, String> map;

    static {
        map = new HashMap<>();
        map.put("id", "prmCurrencyId");
        map.put("code", "prmCurrencyCode");
        map.put("description", "prmCurrencyDescription");
        map.put("creationDate", "prmCurrencyCreationDate");
        map.put("updateDate", "prmCurrencyUpdateDate");
        map.put("byDefault", "prmCurrencyByDefault");
        //map.put("organisation", "prmCurrencyOrganisation");
    }

    public static String getField(String key) {
        return map.get(key);
    }


    public static Map<String, String> getMap() {
        return map;
    }

    public static PrmCurrency toEntity(Currency currency, boolean lazy) {
        if (null == currency) {
            return null;
        }
        PrmCurrency prmCurrency = new PrmCurrency();
        prmCurrency.setPrmCurrencyId(currency.getId());
        prmCurrency.setPrmCurrencyCode(currency.getCode() != null ? currency.getCode().toUpperCase() : null);
        prmCurrency.setPrmCurrencyDescription(currency.getDescription());
        prmCurrency.setPrmCurrencyCreationDate(currency.getCreationDate());
        prmCurrency.setPrmCurrencyUpdateDate(currency.getUpdateDate());
        prmCurrency.setPrmCurrencyByDefault(currency.getByDefault());
        if (!lazy) {
            // prmCurrency.setOrgOrganisation(OrganisationMapper.toEntity(currency.getOrganisation(), true));
        }
        return prmCurrency;
    }

    public static Currency toDto(PrmCurrency prmCurrency, boolean lazy) {
        if (null == prmCurrency) {
            return null;
        }
        Currency currency = new Currency();
        currency.setId(prmCurrency.getPrmCurrencyId());
        currency.setCode(prmCurrency.getPrmCurrencyCode());
        currency.setDescription(prmCurrency.getPrmCurrencyDescription());
        currency.setCreationDate(prmCurrency.getPrmCurrencyCreationDate());
        currency.setUpdateDate(prmCurrency.getPrmCurrencyUpdateDate());
        currency.setByDefault(prmCurrency.getPrmCurrencyByDefault());
        if (!lazy) {
            // currency.setOrganisation(OrganisationMapper.toDto(prmCurrency.getOrgOrganisation(), true));
        }
        return currency;
    }

    public static List<Currency> toDtos(List<PrmCurrency> prmCurrencys, boolean lazy) {
        if (null == prmCurrencys) {
            return null;
        }
        List<Currency> currencies = new ArrayList<>();
        for (PrmCurrency prmCurrency : prmCurrencys) {
            currencies.add(toDto(prmCurrency, lazy));
        }
        return currencies;
    }

    public static List<Currency> toDtos(Iterable<PrmCurrency> prmCurrencys, boolean lazy) {
        if (null == prmCurrencys) {
            return null;
        }
        List<Currency> currencies = new ArrayList<>();
        for (PrmCurrency prmCurrency : prmCurrencys) {
            currencies.add(toDto(prmCurrency, lazy));
        }
        return currencies;
    }

    public static Set<PrmCurrency> toEntities(Set<Currency> currencies, boolean lazy) {
        if (null == currencies) {
            return null;
        }
        Set<PrmCurrency> prmCurrencys = new HashSet<>();
        for (Currency currency : currencies) {
            prmCurrencys.add(toEntity(currency, lazy));
        }
        return prmCurrencys;
    }

    public static Set<Currency> toDtos(Set<PrmCurrency> prmCurrencys, boolean lazy) {
        if (null == prmCurrencys) {
            return null;
        }
        Set<Currency> currencies = new HashSet<>();
        for (PrmCurrency prmCurrency : prmCurrencys) {
            currencies.add(toDto(prmCurrency, lazy));
        }
        return currencies;
    }
}
