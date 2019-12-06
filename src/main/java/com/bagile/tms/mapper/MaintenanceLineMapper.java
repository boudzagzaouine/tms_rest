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
        map.put("code", "tmsMaintenanceLineCode");
        map.put("number", "tmsMaintenanceLineNumber");
        map.put("description", "tmsMaintenanceLineDescription");
        map.put("amount", "tmsMaintenanceLineAmount");
        map.put("startDate", "tmsMaintenanceLineStartDate");
        map.put("endDate", "tmsMaintenanceLineEndDate");
        map.put("maintenanceLineTerm", "tmsMaintenanceLineTerm");
        map.put("supplier", "rcpSupplier");
        map.put("maintenanceLine", "tmsMaintenanceLine");

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
        tmsMaintenanceLine.setTmsMaintenanceLineCode(maintenanceLine.getCode());
        tmsMaintenanceLine.setTmsMaintenanceLineNumber (maintenanceLine.getNumber ());
        tmsMaintenanceLine.setTmsMaintenanceLineDescription (maintenanceLine.getDescription ());
        tmsMaintenanceLine.setTmsMaintenanceLineAmount (maintenanceLine.getAmount ());
        tmsMaintenanceLine.setTmsMaintenanceLineStartDate (maintenanceLine.getStartDate ());
        tmsMaintenanceLine.setTmsMaintenanceLineEndDate (maintenanceLine.getEndDate ());

        tmsMaintenanceLine.setCreatedBy(maintenanceLine.getCreatedBy());
        tmsMaintenanceLine.setUpdatedBy(maintenanceLine.getUpdatedBy());
        tmsMaintenanceLine.setCreationDate(maintenanceLine.getCreationDate());
        tmsMaintenanceLine.setUpdateDate(maintenanceLine.getUpdateDate());

        if(!lazy) {
             tmsMaintenanceLine.setTmsMaintenanceLineTerm (MaintenanceLineTermMapper.toEntity(maintenanceLine.getMaintenanceLineTerm (),true));
             tmsMaintenanceLine.setRcpSupplier (SupplierMapper.toEntity(maintenanceLine.getSupplier (),true));
             tmsMaintenanceLine.setTmsVehicle (VehicleMapper.toEntity (maintenanceLine.getVehicle (), true));
        }
        return tmsMaintenanceLine;
    }

    public static MaintenanceLine toDto(TmsMaintenanceLine tmsMaintenanceLine, boolean lazy) {
        if (null == tmsMaintenanceLine) {
            return null;
        }
        MaintenanceLine maintenanceLine = new MaintenanceLine();
        maintenanceLine.setId((int) tmsMaintenanceLine.getTmsMaintenanceLineId());
        maintenanceLine.setCode(tmsMaintenanceLine.getTmsMaintenanceLineCode());
        maintenanceLine.setNumber (tmsMaintenanceLine.getTmsMaintenanceLineNumber ());
        maintenanceLine.setDescription (tmsMaintenanceLine.getTmsMaintenanceLineDescription ());
        maintenanceLine.setAmount (tmsMaintenanceLine.getTmsMaintenanceLineAmount ());
        maintenanceLine.setStartDate (tmsMaintenanceLine.getTmsMaintenanceLineStartDate ());
        maintenanceLine.setEndDate (tmsMaintenanceLine.getTmsMaintenanceLineEndDate ());

        maintenanceLine.setCreatedBy(tmsMaintenanceLine.getCreatedBy());
        maintenanceLine.setUpdatedBy(tmsMaintenanceLine.getUpdatedBy());
        maintenanceLine.setCreationDate(tmsMaintenanceLine.getCreationDate());
        maintenanceLine.setUpdateDate(tmsMaintenanceLine.getUpdateDate());

        if(!lazy) {

             maintenanceLine.setMaintenanceLineTerm (MaintenanceLineTermMapper.toDto(tmsMaintenanceLine.getTmsMaintenanceLineTerm (),true));
             maintenanceLine.setSupplier (SupplierMapper.toDto (tmsMaintenanceLine.getRcpSupplier (), true));
             maintenanceLine.setVehicle (VehicleMapper.toDto (tmsMaintenanceLine.getTmsVehicle (), true));
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
