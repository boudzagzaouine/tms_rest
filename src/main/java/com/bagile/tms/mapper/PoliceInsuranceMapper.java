package com.bagile.tms.mapper;

import com.bagile.tms.dto.PoliceAssurance;
import com.bagile.tms.entities.TmsPoliceInsurance;

import java.util.*;

/**
 * Created by bouzi on 3/21/2017.
 */
public class PoliceInsuranceMapper {
    public PoliceInsuranceMapper() {
    }
    private static Map<String, String> map;
    static {
        map = new HashMap<>();
        map.put("id","tmsPoliceInsuranceId");
        map.put("code","tmsPoliceInsuranceCode");
        map.put("policeNumber","tmsPoliceInsuranceNumber");
        map.put("startDate","tmsPoliceInsuranceStartDate");
        map.put("endDate","tmsPoliceInsuranceEndDate");
        map.put("type","tmsPoliceInsuranceType");
        map.put("phoneNumber","tmsPoliceInsurancePhoneNumber");
        map.put("vehicule","vehicules");
    }

    public static Map<String, String> getMap() {
        return map;
    }

    public static String getField(String key) {
        return map.get(key);
    }

    public static TmsPoliceInsurance toEntity(PoliceAssurance policeAssurance , boolean lazy){
        if(null == policeAssurance){
            return null;
        }
        TmsPoliceInsurance tmsPoliceInsurance = new TmsPoliceInsurance();
        tmsPoliceInsurance.setTmsPoliceInsuranceId(policeAssurance.getId());
        tmsPoliceInsurance.setTmsPoliceInsuranceCode(policeAssurance.getCode() != null ? policeAssurance.getCode().toUpperCase(): null  );
        tmsPoliceInsurance.setTmsPoliceInsuranceNumber(policeAssurance.getPoliceNumber());
        tmsPoliceInsurance.setTmsPoliceInsuranceStartDate(policeAssurance.getStartDate());
        tmsPoliceInsurance.setTmsPoliceInsuranceEndDate(policeAssurance.getEndDate());
        tmsPoliceInsurance.setTmsPoliceInsuranceType(policeAssurance.getType());
        tmsPoliceInsurance.setTmsPoliceInsurancePhoneNumber(policeAssurance.getPhoneNumber());
        if (!lazy){
            tmsPoliceInsurance.setVehicules(VehicleMapper.toEntity(policeAssurance.getVehicule(),true));
        }
        return tmsPoliceInsurance;
    }
    public static PoliceAssurance toDto(TmsPoliceInsurance tmsPoliceInsurance, boolean lazy){
        if (null == tmsPoliceInsurance){
            return null;
        }
        PoliceAssurance policeAssurance = new PoliceAssurance();
        policeAssurance.setId(tmsPoliceInsurance.getTmsPoliceInsuranceId());
        policeAssurance.setCode(tmsPoliceInsurance.getTmsPoliceInsuranceCode());
        policeAssurance.setPhoneNumber(tmsPoliceInsurance.getTmsPoliceInsurancePhoneNumber());
        policeAssurance.setStartDate(tmsPoliceInsurance.getTmsPoliceInsuranceStartDate());
        policeAssurance.setEndDate(tmsPoliceInsurance.getTmsPoliceInsuranceEndDate());
        policeAssurance.setType(tmsPoliceInsurance.getTmsPoliceInsuranceType());
        policeAssurance.setPhoneNumber(tmsPoliceInsurance.getTmsPoliceInsurancePhoneNumber());
        if (!lazy){
            policeAssurance.setVehicule(VehicleMapper.toDto(tmsPoliceInsurance.getVehicules(),true));
        }
    return policeAssurance;
    }
    public static List<PoliceAssurance>toDtos(List<TmsPoliceInsurance> tmsPoliceInsurances, boolean lazy){
        if(null == tmsPoliceInsurances){
            return null;
        }
        List<PoliceAssurance>policeAssurances = new ArrayList<>();
        for (TmsPoliceInsurance tmsPoliceInsurance : tmsPoliceInsurances){
            policeAssurances.add(toDto(tmsPoliceInsurance,lazy));
        }
        return policeAssurances;
    }
    public static List<PoliceAssurance>toDtos(Iterable<TmsPoliceInsurance>tmsPoliceInsurances, boolean lazy){
        if(null == tmsPoliceInsurances){
            return null;
        }
        List<PoliceAssurance>policeAssurances = new ArrayList<>();
        for (TmsPoliceInsurance tmsPoliceInsurance :tmsPoliceInsurances) {
            policeAssurances.add(toDto(tmsPoliceInsurance,lazy));
        }
        return policeAssurances;
    }
    public  static Set<TmsPoliceInsurance>toEntities(Set<PoliceAssurance>policeAssurances, boolean lazy){
        if (null == policeAssurances){
            return null;
        }
        Set<TmsPoliceInsurance> tmsPoliceInsurances = new HashSet<>();
        for (PoliceAssurance policeAssurance:policeAssurances) {
            tmsPoliceInsurances.add(toEntity(policeAssurance,lazy));
        }
        return tmsPoliceInsurances;
    }
    public static Set<PoliceAssurance>toDtos(Set<TmsPoliceInsurance> tmsPoliceInsurances, boolean lazy){
        if (null == tmsPoliceInsurances){
            return null;
        }
        Set<PoliceAssurance>policeAssurances = new HashSet<>();
        for (TmsPoliceInsurance tmsPoliceInsurance : tmsPoliceInsurances) {
            policeAssurances.add(toDto(tmsPoliceInsurance,lazy));

        }
        return policeAssurances;
    }



}
