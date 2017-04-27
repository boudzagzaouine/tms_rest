package com.sinno.ems.mapper;

import com.sinno.ems.dto.VehiculeType;
import com.sinno.ems.entities.TmsVehicleType;

import java.util.*;

/**
 * Created by bouzi on 3/23/2017.
 */
public class VehicleTypeMapper {
    public VehicleTypeMapper() {
    }
    private static Map<String, String> map;

    static {
        map = new HashMap<>();

        map.put("id", "prmVehicleTypeId");
        map.put("code", "prmVehicleTypeCode");
        map.put("type", "prmVehicleTypeType");
        map.put("vehicule", "vehicules");


    }

    public static Map<String, String> getMap() {
        return map;
    }

    public static String getField(String key) {
        return map.get(key);
    }

    public static TmsVehicleType toEntity(VehiculeType vehiculeType , boolean lazy){
        if (null == vehiculeType) {
            return null;
        }
        TmsVehicleType tmsVehicleType = new TmsVehicleType();

        tmsVehicleType.setPrmVehicleTypeId(vehiculeType.getId());
        tmsVehicleType.setPrmVehicleTypeCode(vehiculeType.getCode() != null ? vehiculeType.getCode().toUpperCase():null );
        tmsVehicleType.setPrmVehicleTypeType(vehiculeType.getType());
        if (!lazy) {
           tmsVehicleType.setTmsVehicleTypeVehicules(VehicleMapper.toEntities(vehiculeType.getVehicules(),true));
//
        }
        return tmsVehicleType;
    }
    public static VehiculeType toDto(TmsVehicleType tmsVehicleType, boolean lazy){
        if (null == tmsVehicleType) {
            return null;
        }
        VehiculeType vehiculeType = new VehiculeType();

        vehiculeType.setId(tmsVehicleType.getPrmVehicleTypeId());
        vehiculeType.setCode(tmsVehicleType.getPrmVehicleTypeCode());
        vehiculeType.setType(tmsVehicleType.getPrmVehicleTypeType());
        if (!lazy) {
            vehiculeType.setVehicules(VehicleMapper.toDtos(tmsVehicleType.getTmsVehicleTypeVehicules(),true));
//
        }
        return vehiculeType;
    }

    public static List<VehiculeType> toDtos(List<TmsVehicleType> tmsVehicleTypes, boolean lazy){
        if (null == tmsVehicleTypes) {
            return null;
        }
        List<VehiculeType>vehiculeTypes = new ArrayList<>();
        for (TmsVehicleType tmsVehicleType : tmsVehicleTypes) {
            vehiculeTypes.add(toDto(tmsVehicleType,lazy));
        }
        return vehiculeTypes;
    }

    public static List<VehiculeType> toDtos(Iterable<TmsVehicleType>prmVehicleTypes , boolean lazy){
        if (null == prmVehicleTypes) {
            return null;
        }
        List<VehiculeType>vehiculeTypes = new ArrayList<>();
        for (TmsVehicleType tmsVehicleType :prmVehicleTypes) {
            vehiculeTypes.add(toDto(tmsVehicleType,lazy));
        }
        return vehiculeTypes;
    }

    public static Set<TmsVehicleType>toEntities(Set<VehiculeType>vehiculeTypes , boolean lazy){
        if (null == vehiculeTypes) {
            return null;
        }
        Set<TmsVehicleType> tmsVehicleTypes = new HashSet<>();
        for (VehiculeType vehiculeType:vehiculeTypes) {
            tmsVehicleTypes.add(toEntity(vehiculeType , lazy));
        }
        return tmsVehicleTypes;
    }

    public static Set<VehiculeType>toDtos(Set<TmsVehicleType> tmsVehicleTypes, boolean lazy){
        if (null == tmsVehicleTypes) {
            return null;
        }
        Set<VehiculeType>vehiculeTypes = new HashSet<>();
        for ( TmsVehicleType tmsVehicleType : tmsVehicleTypes) {
            vehiculeTypes .add(toDto(tmsVehicleType,lazy));
        }
        return vehiculeTypes;
    }




}
