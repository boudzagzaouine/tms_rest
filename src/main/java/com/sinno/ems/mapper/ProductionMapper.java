package com.sinno.ems.mapper;

import com.sinno.ems.dto.Production;
import com.sinno.ems.entities.PrcProduction;

import java.util.*;

/**
 * Created by Enissay on 03/04/2017.
 */
public class ProductionMapper {
    private ProductionMapper() {

    }

    private static Map<String, String> map;

    static {
        map = new HashMap<>();

        map.put("id", "pdtProcessId");
        map.put("code", "pdtProductionCode");
        map.put("productionDate", "pdtProductionDate");
        map.put("creationDate", "pdtProductionCreationDate");
        map.put("updateDate", "pdtProductionUpdateDate");
        map.put("owner", "ownOwner");
        map.put("warehouse", "wrhWarehouse");
        map.put("orderStatus", "prmOrderStatus");
        map.put("description", "prcProductionDescription");
    }

    public static Map<String, String> getMap() {
        return map;
    }

    public static String getField(String key) {
        return map.get(key);
    }

    public static PrcProduction toEntity(Production production, boolean lazy) {
        if (null == production) {
            return null;
        }
        PrcProduction prcProduction = new PrcProduction();
        prcProduction.setPrcProductionId(production.getId());
        prcProduction.setPrcProductionCode(production.getCode());
        prcProduction.setPrcProductionDate(production.getProductionDate());
        prcProduction.setPrcProductionCreationDate(production.getCreationDate());
        prcProduction.setPrcProductionUpdateDate(production.getProductionDate());
        prcProduction.setPrcProductionDescription(production.getDescription());
        if (!lazy) {
            prcProduction.setPrmOrderStatus(OrderStatusMapper.toEntity(production.getOrderStatus(), true));
            prcProduction.setOwnOwner(OwnerMapper.toEntity(production.getOwner(), true));
            prcProduction.setWrhWarehouse(WarehouseMapper.toEntity(production.getWarehouse(), true));
            prcProduction.setPrcProductionLines(ProductionLineMapper.toEntities(production.getProductionLines(), false));
            oneToMany(prcProduction);
        }
        return prcProduction;
    }

    public static void oneToMany(PrcProduction prcProduction) {
        if (null != prcProduction.getPrcProductionLines()) {
            prcProduction.getPrcProductionLines().stream().forEach(sl -> {
                sl.setPrcProduction(prcProduction);
            });
        }
    }

    public static Production toDto(PrcProduction prcProduction, boolean lazy) {
        if (null == prcProduction) {
            return null;
        }
        Production production = new Production();
        production.setId(prcProduction.getPrcProductionId());
        production.setCode(prcProduction.getPrcProductionCode());
        production.setProductionDate(prcProduction.getPrcProductionDate());
        production.setCreationDate(prcProduction.getPrcProductionCreationDate());
        production.setProductionDate(prcProduction.getPrcProductionUpdateDate());
        production.setDescription(prcProduction.getPrcProductionDescription());

        if (!lazy) {
            production.setOrderStatus(OrderStatusMapper.toDto(prcProduction.getPrmOrderStatus(), true));
            production.setOwner(OwnerMapper.toDto(prcProduction.getOwnOwner(), true));
            production.setWarehouse(WarehouseMapper.toDto(prcProduction.getWrhWarehouse(), true));
            production.setProductionLines(ProductionLineMapper.toDtos(prcProduction.getPrcProductionLines(), false));
        }

        return production;
    }

    public static List<Production> toDtos(List<PrcProduction> prcProductions, boolean lazy) {
        if (null == prcProductions) {
            return null;
        }
        List<Production> productions = new ArrayList<>();
        for (PrcProduction pdtProcess : prcProductions) {
            productions.add(toDto(pdtProcess, lazy));
        }
        return productions;
    }

    public static List<Production> toDtos(Iterable<PrcProduction> prcProductions, boolean lazy) {
        if (null == prcProductions) {
            return null;
        }
        List<Production> productions = new ArrayList<>();
        for (PrcProduction pdtProcess : prcProductions) {
            productions.add(toDto(pdtProcess, lazy));
        }
        return productions;
    }

    public static Set<PrcProduction> toEntities(Set<Production> productions, boolean lazy) {
        if (null == productions) {
            return null;
        }
        Set<PrcProduction> prcProductions = new HashSet<>();
        for (Production production : productions) {
            prcProductions.add(toEntity(production, lazy));
        }
        return prcProductions;
    }

    public static Set<Production> toDtos(Set<PrcProduction> prcProductions, boolean lazy) {
        if (null == prcProductions) {
            return null;
        }
        Set<Production> productions = new HashSet<>();
        for (PrcProduction pdtProcess : prcProductions) {
            productions.add(toDto(pdtProcess, lazy));
        }
        return productions;
    }
}
