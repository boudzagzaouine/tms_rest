package com.sinno.ems.mapper;

import com.sinno.ems.dto.PoliceAssurance;
import com.sinno.ems.entities.TmsPoliceInsurance;

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
        map.put("id","asrPoliceInsuranceId;");
        map.put("code","asrPoliceInsuranceCode;");
        map.put("policeNumber","asrPoliceInsuranceNumber;");
        map.put("startDate","asrPoliceInsuranceStartDate;");
        map.put("endDate","asrPoliceInsuranceEndDate;");
        map.put("type","asrPoliceInsuranceType;");
        map.put("phoneNumber","asrPoliceInsurancePhoneNumber;");
        map.put("vehicul","asrPoliceInsurancevehicle;");
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
        tmsPoliceInsurance.setAsrPoliceInsuranceId(policeAssurance.getId());
        tmsPoliceInsurance.setAsrPoliceInsuranceCode(policeAssurance.getCode() != null ? policeAssurance.getCode().toUpperCase(): null  );
        tmsPoliceInsurance.setAsrPoliceInsuranceNumber(policeAssurance.getPoliceNumber());
        tmsPoliceInsurance.setAsrPoliceInsuranceStartDate(policeAssurance.getStartDate());
        tmsPoliceInsurance.setAsrPoliceInsuranceEndDate(policeAssurance.getEndDate());
        tmsPoliceInsurance.setAsrPoliceInsuranceType(policeAssurance.getType());
        tmsPoliceInsurance.setAsrPoliceInsurancePhoneNumber(policeAssurance.getPhoneNumber());
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
        policeAssurance.setId(tmsPoliceInsurance.getAsrPoliceInsuranceId());
        policeAssurance.setCode(tmsPoliceInsurance.getAsrPoliceInsuranceCode());
        policeAssurance.setPhoneNumber(tmsPoliceInsurance.getAsrPoliceInsurancePhoneNumber());
        policeAssurance.setStartDate(tmsPoliceInsurance.getAsrPoliceInsuranceStartDate());
        policeAssurance.setEndDate(tmsPoliceInsurance.getAsrPoliceInsuranceEndDate());
        policeAssurance.setType(tmsPoliceInsurance.getAsrPoliceInsuranceType());
        policeAssurance.setPhoneNumber(tmsPoliceInsurance.getAsrPoliceInsurancePhoneNumber());
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
    public static List<PoliceAssurance>toDtos(Iterable<TmsPoliceInsurance>asrPoliceInsurances, boolean lazy){
        if(null == asrPoliceInsurances){
            return null;
        }
        List<PoliceAssurance>policeAssurances = new ArrayList<>();
        for (TmsPoliceInsurance tmsPoliceInsurance :asrPoliceInsurances) {
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
