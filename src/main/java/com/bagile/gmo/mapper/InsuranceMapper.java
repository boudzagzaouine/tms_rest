package com.bagile.gmo.mapper;

import com.bagile.gmo.dto.Insurance;
import com.bagile.gmo.entities.GmoInsurance;

import java.util.*;

public class InsuranceMapper {
    public InsuranceMapper() {
    }

    private static Map<String, String> map;

    static {
        map = new HashMap<>();

        map.put("id", "gmoInsuranceId");
        map.put("code", "gmoInsuranceCode");
        map.put("number", "gmoInsuranceNumber");
        map.put("description", "gmoInsuranceDescription");
        map.put("amount", "gmoInsuranceAmount");
        map.put("startDate", "gmoInsuranceStartDate");
        map.put("endDate", "gmoInsuranceEndDate");
        map.put("insuranceType", "gmoInsuranceType");
        map.put("supplier", "rcpSupplier");
        map.put("vehicle", "gmoVehicle");
         map.put("patrimony","gmoPatrimony");
        map.put("vehicleCode", "gmoInsuranceVehicleCode");
        map.put("insuranceTermLignes", "gmoInsuranceTermLignes");

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

    public static GmoInsurance toEntity(Insurance insurance, boolean lazy) {
        if (null == insurance) {
            return null;
        }
        GmoInsurance gmoInsurance = new GmoInsurance();
        gmoInsurance.setGmoInsuranceId(insurance.getId());
        gmoInsurance.setGmoInsuranceCode(insurance.getCode());
        gmoInsurance.setGmoInsuranceNumber (insurance.getNumber ());
        gmoInsurance.setGmoInsuranceDescription (insurance.getDescription ());
        gmoInsurance.setGmoInsuranceAmount (insurance.getAmount ());
        gmoInsurance.setGmoInsuranceStartDate (insurance.getStartDate ());
        gmoInsurance.setGmoInsuranceEndDate (insurance.getEndDate ());
        //gmoInsurance.setGmoInsuranceVehicleCode (insurance.getVehicleCode ());

        gmoInsurance.setCreatedBy(insurance.getCreatedBy());
        gmoInsurance.setUpdatedBy(insurance.getUpdatedBy());
        gmoInsurance.setCreationDate(insurance.getCreationDate());
        gmoInsurance.setUpdateDate(insurance.getUpdateDate());

        if(!lazy) {
         // gmoInsurance.setGmoInsuranceTermLigne (InsuranceTermLigneMapper.toEntities(insurance.getInsuranceTermLignes(),false));
             gmoInsurance.setRcpSupplier (SupplierMapper.toEntity(insurance.getSupplier (),false));
              gmoInsurance.setGmoInsuranceTermsLignes (InsuranceTermsVehicleMapper.toEntities (insurance.getInsuranceTermLignes (), false));
             gmoInsurance.setGmoInsuranceType (InsuranceTypeMapper.toEntity (insurance.getInsuranceType (), false));
            gmoInsurance.setGmoPatrimony (PatrimonyMapper.toEntity (insurance.getPatrimony (), false));
            gmoInsurance.setOwnOwner (OwnerMapper.toEntity (insurance.getOwner (), false));

            //gmoInsurance.setGmoVehicle (VehicleMapper.toEntity (insurance.getVehicle (), true));

           // oneToMany(gmoInsurance);
        }
        return gmoInsurance;
    }

    public static Insurance toDto(GmoInsurance gmoInsurance, boolean lazy) {
        if (null == gmoInsurance) {
            return null;
        }
        Insurance insurance = new Insurance();
        insurance.setId(gmoInsurance.getGmoInsuranceId());
        insurance.setCode(gmoInsurance.getGmoInsuranceCode());
        insurance.setNumber (gmoInsurance.getGmoInsuranceNumber ());
        insurance.setDescription (gmoInsurance.getGmoInsuranceDescription ());
        insurance.setAmount (gmoInsurance.getGmoInsuranceAmount ());
        insurance.setStartDate (gmoInsurance.getGmoInsuranceStartDate ());
        insurance.setEndDate (gmoInsurance.getGmoInsuranceEndDate ());
        //insurance.setVehicleCode (gmoInsurance.getGmoInsuranceVehicleCode ());

        insurance.setCreatedBy(gmoInsurance.getCreatedBy());
        insurance.setUpdatedBy(gmoInsurance.getUpdatedBy());
        insurance.setCreationDate(gmoInsurance.getCreationDate());
        insurance.setUpdateDate(gmoInsurance.getUpdateDate());

        if(!lazy) {

             insurance.setSupplier (SupplierMapper.toDto (gmoInsurance.getRcpSupplier (), false));
            insurance.setInsuranceTermLignes (InsuranceTermsVehicleMapper.toDtos (gmoInsurance.getGmoInsuranceTermsLignes (), false));
            insurance.setInsuranceType (InsuranceTypeMapper.toDto (gmoInsurance.getGmoInsuranceType (), false));
            //insurance.setVehicle (VehicleMapper.toDto (gmoInsurance.getGmoVehicle (), false));
            insurance.setPatrimony(PatrimonyMapper.toDto(gmoInsurance.getGmoPatrimony(),false));
            insurance.setOwner(OwnerMapper.toDto(gmoInsurance.getOwnOwner(),false));

        }
        return insurance;
    }


    /*private static void oneToMany(GmoInsurance insurance){
        insurance.getGmoInsuranceTermsLignes().forEach(
                e->{
                     e.setCreationDate(new Date());
                    e.setGmoInsurance(insurance);
                }
        );


    }*/

    public static List<Insurance> toDtos(Iterable<? extends GmoInsurance> gmoInsurances, boolean lazy) {
        if (null == gmoInsurances) {
            return null;
        }
        List<Insurance> vehicules = new ArrayList<>();

        for (GmoInsurance gmoInsurance : gmoInsurances) {
            vehicules.add(toDto(gmoInsurance, lazy));
        }
        return vehicules;
    }

    public static Set<GmoInsurance> toEntities(Iterable<? extends Insurance> insurances, boolean lazy) {
        if (null == insurances) {
            return null;
        }
        Set<GmoInsurance> gmoInsurances = new HashSet<>();
        for (Insurance insurance : insurances) {
            gmoInsurances.add(toEntity(insurance, lazy));
        }
        return gmoInsurances;
    }

    public static Set<Insurance> toDtos(Set<GmoInsurance> gmoInsurances, boolean lazy) {
        if (null == gmoInsurances) {
            return null;
        }
        Set<Insurance> insurances = new HashSet<>();
        for (GmoInsurance gmoInsurance : gmoInsurances) {
            insurances.add(toDto(gmoInsurance, lazy));
        }
        return insurances;
    }
}
