package com.sinno.ems.mapper;

import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.sinno.ems.dto.PoliceAssurance;
import com.sinno.ems.entities.AsrPoliceInsurance;

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

    public static AsrPoliceInsurance toEntity(PoliceAssurance policeAssurance , boolean lazy){
        if(null == policeAssurance){
            return null;
        }
        AsrPoliceInsurance asrPoliceInsurance = new AsrPoliceInsurance();
        asrPoliceInsurance.setAsrPoliceInsuranceId(policeAssurance.getId());
        asrPoliceInsurance.setAsrPoliceInsuranceCode(policeAssurance.getCode() != null ? policeAssurance.getCode().toUpperCase(): null  );
        asrPoliceInsurance.setAsrPoliceInsuranceNumber(policeAssurance.getPoliceNumber());
        asrPoliceInsurance.setAsrPoliceInsuranceStartDate(policeAssurance.getStartDate());
        asrPoliceInsurance.setAsrPoliceInsuranceEndDate(policeAssurance.getEndDate());
        asrPoliceInsurance.setAsrPoliceInsuranceType(policeAssurance.getType());
        asrPoliceInsurance.setAsrPoliceInsurancePhoneNumber(policeAssurance.getPhoneNumber());
        if (!lazy){
            asrPoliceInsurance.setVehicules(VehicleMapper.toEntity(policeAssurance.getVehicule(),true));
        }
        return asrPoliceInsurance;
    }
    public static PoliceAssurance toDto(AsrPoliceInsurance asrPoliceInsurance,boolean lazy){
        if (null == asrPoliceInsurance){
            return null;
        }
        PoliceAssurance policeAssurance = new PoliceAssurance();
        policeAssurance.setId(asrPoliceInsurance.getAsrPoliceInsuranceId());
        policeAssurance.setCode(asrPoliceInsurance.getAsrPoliceInsuranceCode());
        policeAssurance.setPhoneNumber(asrPoliceInsurance.getAsrPoliceInsurancePhoneNumber());
        policeAssurance.setStartDate(asrPoliceInsurance.getAsrPoliceInsuranceStartDate());
        policeAssurance.setEndDate(asrPoliceInsurance.getAsrPoliceInsuranceEndDate());
        policeAssurance.setType(asrPoliceInsurance.getAsrPoliceInsuranceType());
        policeAssurance.setPhoneNumber(asrPoliceInsurance.getAsrPoliceInsurancePhoneNumber());
        if (!lazy){
            policeAssurance.setVehicule(VehicleMapper.toDto(asrPoliceInsurance.getVehicules(),true));
        }
    return policeAssurance;
    }
    public static List<PoliceAssurance>toDtos(List<AsrPoliceInsurance>asrPoliceInsurances,boolean lazy){
        if(null == asrPoliceInsurances){
            return null;
        }
        List<PoliceAssurance>policeAssurances = new ArrayList<>();
        for (AsrPoliceInsurance asrPoliceInsurance :asrPoliceInsurances){
            policeAssurances.add(toDto(asrPoliceInsurance,lazy));
        }
        return policeAssurances;
    }
    public static List<PoliceAssurance>toDtos(Iterable<AsrPoliceInsurance>asrPoliceInsurances,boolean lazy){
        if(null == asrPoliceInsurances){
            return null;
        }
        List<PoliceAssurance>policeAssurances = new ArrayList<>();
        for (AsrPoliceInsurance asrPoliceInsurance:asrPoliceInsurances) {
            policeAssurances.add(toDto(asrPoliceInsurance,lazy));
        }
        return policeAssurances;
    }
    public  static Set<AsrPoliceInsurance>toEntities(Set<PoliceAssurance>policeAssurances,boolean lazy){
        if (null == policeAssurances){
            return null;
        }
        Set<AsrPoliceInsurance>asrPoliceInsurances = new HashSet<>();
        for (PoliceAssurance policeAssurance:policeAssurances) {
            asrPoliceInsurances.add(toEntity(policeAssurance,lazy));
        }
        return asrPoliceInsurances;
    }
    public static Set<PoliceAssurance>toDtos(Set<AsrPoliceInsurance>asrPoliceInsurances,boolean lazy){
        if (null == asrPoliceInsurances){
            return null;
        }
        Set<PoliceAssurance>policeAssurances = new HashSet<>();
        for (AsrPoliceInsurance asrPoliceInsurance:asrPoliceInsurances) {
            policeAssurances.add(toDto(asrPoliceInsurance,lazy));

        }
        return policeAssurances;
    }



}
