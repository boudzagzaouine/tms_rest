package com.sinno.ems.mapper;

import com.sinno.ems.dto.Vehicule;
import com.sinno.ems.dto.VehiculeType;
import com.sinno.ems.entities.PrmVehicleType;
import org.springframework.security.access.method.P;

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

    public static PrmVehicleType toEntity(VehiculeType vehiculeType , boolean lazy){
        if (null == vehiculeType) {
            return null;
        }
        PrmVehicleType prmVehicleType = new PrmVehicleType();

        prmVehicleType.setPrmVehicleTypeId(vehiculeType.getId());
        prmVehicleType.setPrmVehicleTypeCode(vehiculeType.getCode() != null ? vehiculeType.getCode().toUpperCase():null );
        prmVehicleType.setPrmVehicleTypeType(vehiculeType.getType());
        if (!lazy) {
           prmVehicleType.setPrmVehicleTypeVehicules(VehicleMapper.toEntities(vehiculeType.getVehicules(),true));
//
        }
        return prmVehicleType;
    }
    public static VehiculeType toDto(PrmVehicleType prmVehicleType , boolean lazy){
        if (null == prmVehicleType) {
            return null;
        }
        VehiculeType vehiculeType = new VehiculeType();

        vehiculeType.setId(prmVehicleType.getPrmVehicleTypeId());
        vehiculeType.setCode(prmVehicleType.getPrmVehicleTypeCode());
        vehiculeType.setType(prmVehicleType.getPrmVehicleTypeType());
        if (!lazy) {
            vehiculeType.setVehicules(VehicleMapper.toDtos(prmVehicleType.getPrmVehicleTypeVehicules(),true));
//
        }
        return vehiculeType;
    }

    public static List<VehiculeType> toDtos(List<PrmVehicleType> prmVehicleTypes , boolean lazy){
        if (null == prmVehicleTypes) {
            return null;
        }
        List<VehiculeType>vehiculeTypes = new ArrayList<>();
        for (PrmVehicleType prmVehicleType:prmVehicleTypes) {
            vehiculeTypes.add(toDto(prmVehicleType,lazy));
        }
        return vehiculeTypes;
    }

    public static List<VehiculeType> toDtos(Iterable<PrmVehicleType>prmVehicleTypes , boolean lazy){
        if (null == prmVehicleTypes) {
            return null;
        }
        List<VehiculeType>vehiculeTypes = new ArrayList<>();
        for (PrmVehicleType prmVehicleType:prmVehicleTypes) {
            vehiculeTypes.add(toDto(prmVehicleType,lazy));
        }
        return vehiculeTypes;
    }

    public static Set<PrmVehicleType>toEntities(Set<VehiculeType>vehiculeTypes , boolean lazy){
        if (null == vehiculeTypes) {
            return null;
        }
        Set<PrmVehicleType> prmVehicleTypes = new HashSet<>();
        for (VehiculeType vehiculeType:vehiculeTypes) {
            prmVehicleTypes.add(toEntity(vehiculeType , lazy));
        }
        return prmVehicleTypes;
    }

    public static Set<VehiculeType>toDtos(Set<PrmVehicleType>prmVehicleTypes , boolean lazy){
        if (null == prmVehicleTypes) {
            return null;
        }
        Set<VehiculeType>vehiculeTypes = new HashSet<>();
        for ( PrmVehicleType prmVehicleType:prmVehicleTypes) {
            vehiculeTypes .add(toDto(prmVehicleType,lazy));
        }
        return vehiculeTypes;
    }




}
