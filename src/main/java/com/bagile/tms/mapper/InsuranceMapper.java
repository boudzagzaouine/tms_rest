package com.bagile.tms.mapper;

import com.bagile.tms.dto.Insurance;
import com.bagile.tms.entities.TmsInsurance;

import java.util.*;

public class InsuranceMapper {
    public InsuranceMapper() {
    }

    private static Map<String, String> map;

    static {
        map = new HashMap<>();

        map.put("id", "tmsInsuranceId");
        map.put("code", "tmsInsuranceCode");
        map.put("number", "tmsInsuranceNumber");
        map.put("description", "tmsInsuranceDescription");
        map.put("amount", "tmsInsuranceAmount");
        map.put("startDate", "tmsInsuranceStartDate");
        map.put("endDate", "tmsInsuranceEndDate");
        map.put("insuranceTerm", "tmsInsuranceTerm");
        map.put("supplier", "rcpSupplier");
        map.put("vehicleCode", "tmsInsuranceVehicleCode");

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

    public static TmsInsurance toEntity(Insurance insurance, boolean lazy) {
        if (null == insurance) {
            return null;
        }
        TmsInsurance tmsInsurance = new TmsInsurance();
        tmsInsurance.setTmsInsuranceId(insurance.getId());
        tmsInsurance.setTmsInsuranceCode(insurance.getCode());
        tmsInsurance.setTmsInsuranceNumber (insurance.getNumber ());
        tmsInsurance.setTmsInsuranceDescription (insurance.getDescription ());
        tmsInsurance.setTmsInsuranceAmount (insurance.getAmount ());
        tmsInsurance.setTmsInsuranceStartDate (insurance.getStartDate ());
        tmsInsurance.setTmsInsuranceEndDate (insurance.getEndDate ());
        tmsInsurance.setTmsInsuranceVehicleCode (insurance.getVehicleCode ());

        tmsInsurance.setCreatedBy(insurance.getCreatedBy());
        tmsInsurance.setUpdatedBy(insurance.getUpdatedBy());
        tmsInsurance.setCreationDate(insurance.getCreationDate());
        tmsInsurance.setUpdateDate(insurance.getUpdateDate());

        if(!lazy) {
             tmsInsurance.setTmsInsuranceTerm (InsuranceTermMapper.toEntity(insurance.getInsuranceTerm (),true));
             tmsInsurance.setRcpSupplier (SupplierMapper.toEntity(insurance.getSupplier (),true));
             tmsInsurance.setTmsVehicle (VehicleMapper.toEntity (insurance.getVehicle (), true));
        }
        return tmsInsurance;
    }

    public static Insurance toDto(TmsInsurance tmsInsurance, boolean lazy) {
        if (null == tmsInsurance) {
            return null;
        }
        Insurance insurance = new Insurance();
        insurance.setId((int) tmsInsurance.getTmsInsuranceId());
        insurance.setCode(tmsInsurance.getTmsInsuranceCode());
        insurance.setNumber (tmsInsurance.getTmsInsuranceNumber ());
        insurance.setDescription (tmsInsurance.getTmsInsuranceDescription ());
        insurance.setAmount (tmsInsurance.getTmsInsuranceAmount ());
        insurance.setStartDate (tmsInsurance.getTmsInsuranceStartDate ());
        insurance.setEndDate (tmsInsurance.getTmsInsuranceEndDate ());
        insurance.setVehicleCode (tmsInsurance.getTmsInsuranceVehicleCode ());

        insurance.setCreatedBy(tmsInsurance.getCreatedBy());
        insurance.setUpdatedBy(tmsInsurance.getUpdatedBy());
        insurance.setCreationDate(tmsInsurance.getCreationDate());
        insurance.setUpdateDate(tmsInsurance.getUpdateDate());

        if(!lazy) {

             insurance.setInsuranceTerm (InsuranceTermMapper.toDto(tmsInsurance.getTmsInsuranceTerm (),true));
             insurance.setSupplier (SupplierMapper.toDto (tmsInsurance.getRcpSupplier (), true));
             insurance.setVehicle (VehicleMapper.toDto (tmsInsurance.getTmsVehicle (), true));
        }
        return insurance;
    }


    public static List<Insurance> toDtos(Iterable<? extends TmsInsurance> tmsInsurances, boolean lazy) {
        if (null == tmsInsurances) {
            return null;
        }
        List<Insurance> vehicules = new ArrayList<>();

        for (TmsInsurance tmsInsurance : tmsInsurances) {
            vehicules.add(toDto(tmsInsurance, lazy));
        }
        return vehicules;
    }

    public static Set<TmsInsurance> toEntities(Set<Insurance> insurances, boolean lazy) {
        if (null == insurances) {
            return null;
        }
        Set<TmsInsurance> tmsInsurances = new HashSet<>();
        for (Insurance insurance : insurances) {
            tmsInsurances.add(toEntity(insurance, lazy));
        }
        return tmsInsurances;
    }

    public static Set<Insurance> toDtos(Set<TmsInsurance> tmsInsurances, boolean lazy) {
        if (null == tmsInsurances) {
            return null;
        }
        Set<Insurance> insurances = new HashSet<>();
        for (TmsInsurance tmsInsurance : tmsInsurances) {
            insurances.add(toDto(tmsInsurance, lazy));
        }
        return insurances;
    }
}
