package com.bagile.tms.mapper;

import com.bagile.tms.dto.MaintenanceLine;
import com.bagile.tms.entities.TmsMaintenanceLine;

import java.util.*;

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

    public static TmsMaintenanceLine toEntity(MaintenanceLine maintenanceLine, boolean lazy) {
        if (null == maintenanceLine) {
            return null;
        }
        TmsMaintenanceLine tmsMaintenanceLine = new TmsMaintenanceLine();
        tmsMaintenanceLine.setTmsMaintenanceLineId(maintenanceLine.getId());
        tmsMaintenanceLine.setTmsMaintenanceLineDescription (maintenanceLine.getDescription ());
        tmsMaintenanceLine.setTmsMaintenanceLineQuantity (maintenanceLine.getQuantity ());
        tmsMaintenanceLine.setTmsMaintenanceLineUnitPrice (maintenanceLine.getUnitPrice ());
        tmsMaintenanceLine.setTmsMaintenanceLineTotalPriceHT (maintenanceLine.getTotalPriceHT ());
        tmsMaintenanceLine.setTmsMaintenanceLineTotalPriceTTC (maintenanceLine.getTotalPriceTTC ());

        tmsMaintenanceLine.setCreatedBy(maintenanceLine.getCreatedBy());
        tmsMaintenanceLine.setUpdatedBy(maintenanceLine.getUpdatedBy());
        tmsMaintenanceLine.setCreationDate(maintenanceLine.getCreationDate());
        tmsMaintenanceLine.setUpdateDate(maintenanceLine.getUpdateDate());

        if(!lazy) {
             tmsMaintenanceLine.setTmsMaintenanceLineProduct (ProductMapper.toEntity(maintenanceLine.getProduct (),true));
            tmsMaintenanceLine.setTmsMaintenanceLineMaintenancePlan (MaintenancePlanMapper.toEntity(maintenanceLine.getMaintenancePlan (),true));

        }
        return tmsMaintenanceLine;
    }

    public static MaintenanceLine toDto(TmsMaintenanceLine tmsMaintenanceLine, boolean lazy) {
        if (null == tmsMaintenanceLine) {
            return null;
        }
        MaintenanceLine maintenanceLine = new MaintenanceLine();
        maintenanceLine.setId((int) tmsMaintenanceLine.getTmsMaintenanceLineId());
        maintenanceLine.setDescription(tmsMaintenanceLine.getTmsMaintenanceLineDescription());
        maintenanceLine.setQuantity (tmsMaintenanceLine.getTmsMaintenanceLineQuantity ());
        maintenanceLine.setUnitPrice (tmsMaintenanceLine.getTmsMaintenanceLineUnitPrice ());
        maintenanceLine.setTotalPriceHT (tmsMaintenanceLine.getTmsMaintenanceLineTotalPriceHT ());
        maintenanceLine.setTotalPriceTTC (tmsMaintenanceLine.getTmsMaintenanceLineTotalPriceTTC ());

        maintenanceLine.setCreatedBy(tmsMaintenanceLine.getCreatedBy());
        maintenanceLine.setUpdatedBy(tmsMaintenanceLine.getUpdatedBy());
        maintenanceLine.setCreationDate(tmsMaintenanceLine.getCreationDate());
        maintenanceLine.setUpdateDate(tmsMaintenanceLine.getUpdateDate());

        if(!lazy) {

             maintenanceLine.setProduct (ProductMapper.toDto (tmsMaintenanceLine.getTmsMaintenanceLineProduct (), true));
             maintenanceLine.setMaintenancePlan (MaintenancePlanMapper.toDto (tmsMaintenanceLine.getTmsMaintenanceLineMaintenancePlan (), true));
        }
        return maintenanceLine;
    }


    public static List<MaintenanceLine> toDtos(Iterable<? extends TmsMaintenanceLine> tmsMaintenanceLines, boolean lazy) {
        if (null == tmsMaintenanceLines) {
            return null;
        }
        List<MaintenanceLine> vehicules = new ArrayList<>();

        for (TmsMaintenanceLine tmsMaintenanceLine : tmsMaintenanceLines) {
            vehicules.add(toDto(tmsMaintenanceLine, lazy));
        }
        return vehicules;
    }

    public static Set<TmsMaintenanceLine> toEntities(Set<MaintenanceLine> maintenanceLines, boolean lazy) {
        if (null == maintenanceLines) {
            return null;
        }
        Set<TmsMaintenanceLine> tmsMaintenanceLines = new HashSet<>();
        for (MaintenanceLine maintenanceLine : maintenanceLines) {
            tmsMaintenanceLines.add(toEntity(maintenanceLine, lazy));
        }
        return tmsMaintenanceLines;
    }

    public static Set<MaintenanceLine> toDtos(Set<TmsMaintenanceLine> tmsMaintenanceLines, boolean lazy) {
        if (null == tmsMaintenanceLines) {
            return null;
        }
        Set<MaintenanceLine> maintenanceLines = new HashSet<>();
        for (TmsMaintenanceLine tmsMaintenanceLine : tmsMaintenanceLines) {
            maintenanceLines.add(toDto(tmsMaintenanceLine, lazy));
        }
        return maintenanceLines;
    }
}
