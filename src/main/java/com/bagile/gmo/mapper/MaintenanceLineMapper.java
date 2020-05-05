package com.bagile.gmo.mapper;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import com.bagile.gmo.dto.MaintenanceLine;
import com.bagile.gmo.entities.GmoMaintenanceLine;

public class MaintenanceLineMapper {
    public MaintenanceLineMapper() {
    }

    private static Map<String, String> map;

    static {
        map = new HashMap<>();

        map.put("id", "tmsMaintenanceLineId");
        map.put("product", "tmsMaintenanceLineCode");
        map.put("description", "tmsMaintenanceLineNumber");
        map.put("unitPrice", "tmsMaintenanceLineDescription");
        map.put("totalPriceHT", "tmsMaintenanceLineAmount");
        map.put("totalPriceTTC", "tmsMaintenanceLineStartDate");
        map.put("maintenancePlan", "tmsMaintenanceLineEndDate");
        map.put("amountVat", "tmsAmountVat");

        map.put("creationDate", "creationDate");
        map.put("updateDate", "updateDate");
        map.put("createdBy", "createdBy");
        map.put("updatedBy", "updatedBy");
    }

    public static Map<String, String> getMap() {
        return map;
    }

    public static String getField(String key) {
        return map.get(key);
    }

    public static GmoMaintenanceLine toEntity(MaintenanceLine maintenanceLine, boolean lazy) {
        if (null == maintenanceLine) {
            return null;
        }
        GmoMaintenanceLine gmoMaintenanceLine = new GmoMaintenanceLine();
        gmoMaintenanceLine.setGmoMaintenanceLineId(maintenanceLine.getId());
        gmoMaintenanceLine.setGmoMaintenanceLineDescription (maintenanceLine.getDescription ());
        gmoMaintenanceLine.setGmoMaintenanceLineQuantity (maintenanceLine.getQuantity ());
        gmoMaintenanceLine.setGmoMaintenanceLineUnitPrice (maintenanceLine.getUnitPrice ());
        gmoMaintenanceLine.setGmoMaintenanceLineTotalPriceHT (maintenanceLine.getTotalPriceHT ());
        gmoMaintenanceLine.setGmoMaintenanceLineTotalPriceTTC (maintenanceLine.getTotalPriceTTC ());
        gmoMaintenanceLine.setGmoAmountVat (maintenanceLine.getAmountVat ());

        gmoMaintenanceLine.setCreatedBy(maintenanceLine.getCreatedBy());
        gmoMaintenanceLine.setUpdatedBy(maintenanceLine.getUpdatedBy());
        gmoMaintenanceLine.setCreationDate(maintenanceLine.getCreationDate());
        gmoMaintenanceLine.setUpdateDate(maintenanceLine.getUpdateDate());

        if(!lazy) {
             gmoMaintenanceLine.setGmoMaintenanceLineProduct (ProductMapper.toEntity(maintenanceLine.getProduct (),false));
            gmoMaintenanceLine.setGmoMaintenanceLineMaintenancePlan (MaintenancePlanMapper.toEntity(maintenanceLine.getMaintenancePlan (),true));

        }
        return gmoMaintenanceLine;
    }

    public static MaintenanceLine toDto(GmoMaintenanceLine gmoMaintenanceLine, boolean lazy) {
        if (null == gmoMaintenanceLine) {
            return null;
        }
        MaintenanceLine maintenanceLine = new MaintenanceLine();
        maintenanceLine.setId((int) gmoMaintenanceLine.getGmoMaintenanceLineId());
        maintenanceLine.setDescription(gmoMaintenanceLine.getGmoMaintenanceLineDescription());
        maintenanceLine.setQuantity (gmoMaintenanceLine.getGmoMaintenanceLineQuantity ());
        maintenanceLine.setUnitPrice (gmoMaintenanceLine.getGmoMaintenanceLineUnitPrice ());
        maintenanceLine.setTotalPriceHT (gmoMaintenanceLine.getGmoMaintenanceLineTotalPriceHT ());
        maintenanceLine.setTotalPriceTTC (gmoMaintenanceLine.getGmoMaintenanceLineTotalPriceTTC ());
        maintenanceLine.setAmountVat (gmoMaintenanceLine.getGmoAmountVat ());

        maintenanceLine.setCreatedBy(gmoMaintenanceLine.getCreatedBy());
        maintenanceLine.setUpdatedBy(gmoMaintenanceLine.getUpdatedBy());
        maintenanceLine.setCreationDate(gmoMaintenanceLine.getCreationDate());
        maintenanceLine.setUpdateDate(gmoMaintenanceLine.getUpdateDate());

        if(!lazy) {

             maintenanceLine.setProduct (ProductMapper.toDto (gmoMaintenanceLine.getGmoMaintenanceLineProduct (), false));
             maintenanceLine.setMaintenancePlan (MaintenancePlanMapper.toDto (gmoMaintenanceLine.getGmoMaintenanceLineMaintenancePlan (), true));
        }
        return maintenanceLine;
    }


    public static List<MaintenanceLine> toDtos(Iterable<? extends GmoMaintenanceLine> gmoMaintenanceLines, boolean lazy) {
        if (null == gmoMaintenanceLines) {
            return null;
        }
        List<MaintenanceLine> vehicules = new ArrayList<>();

        for (GmoMaintenanceLine gmoMaintenanceLine : gmoMaintenanceLines) {
            vehicules.add(toDto(gmoMaintenanceLine, lazy));
        }
        return vehicules;
    }

    public static Set<GmoMaintenanceLine> toEntities(Iterable<? extends MaintenanceLine> maintenanceLines, boolean lazy) {
        if (null == maintenanceLines) {
            return null;
        }
        Set<GmoMaintenanceLine> gmoMaintenanceLines = new HashSet<>();
        for (MaintenanceLine maintenanceLine : maintenanceLines) {
            gmoMaintenanceLines.add(toEntity(maintenanceLine, lazy));
        }
        return gmoMaintenanceLines;
    }
}
