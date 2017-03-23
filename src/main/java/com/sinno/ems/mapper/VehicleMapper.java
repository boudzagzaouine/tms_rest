package com.sinno.ems.mapper;

import com.sinno.ems.dto.Vehicule;
import com.sinno.ems.entities.PrmVehicle;

import java.util.*;

/**
 * Created by bouzi on 3/23/2017.
 */

public class VehicleMapper {
    public VehicleMapper() {
    }
    private static Map<String, String> map;

    static {
        map = new HashMap<>();

        map.put("id", "prmVehicleId");
        map.put("code", "prmVehiclerCode");
        map.put("nbreEssieux", "prmVehicleNbreEssieux");
        map.put("emptyWeight", "prmVehicleEmtyWeight");
        map.put("dateOfRegistration", "prmVehicleDateOfRegistration");
        map.put("brand", "prmVehicleBrand");
        map.put("model", "prmVehicleModel");
        map.put("status", "prmVehicleStatus");
        map.put("type", "prmVehicleType");
        map.put("badges", "prmVehicleBadges");
        map.put("policeAssurance", "prmVehiclePoliceInsurance");
        map.put("maintenancePlan", "prmVehicleMaintenancePlan");

    }
    public static Map<String, String> getMap() {
        return map;
    }

    public static String getField(String key) {
        return map.get(key);
    }

    public static PrmVehicle toEntity(Vehicule vehicule , boolean lazy){
        if (null == vehicule) {
            return null;
        }
        PrmVehicle prmVehicle = new PrmVehicle();
        prmVehicle.setPrmVehicleId(vehicule.getId());
        prmVehicle.setPrmVehicleCode(vehicule.getCode() != null ? vehicule.getCode().toUpperCase() : null);
        prmVehicle.setPrmVehicleNbreEssieux(vehicule.getNbreEssieux());
        prmVehicle.setPrmVehicleEmptyWeight(vehicule.getEmptyWeight());
        prmVehicle.setPrmVehicleDateOfRegistration(vehicule.getDateOfRegistration());
        prmVehicle.setPrmVehicleBrand(vehicule.getBrand());
        prmVehicle.setPrmVehicleModel(vehicule.getModel());
        prmVehicle.setPrmVehicleStatus(vehicule.getStatus());
        prmVehicle.setPrmVehicleType(vehicule.getType());
        if (!lazy) {
           //
            //
            //
//
        }
        return prmVehicle;

    }

    public static Vehicule toDto(PrmVehicle prmVehicle , boolean lazy){
        if (null == prmVehicle) {
            return null;
        }
        Vehicule vehicule = new Vehicule();
        vehicule.setId(prmVehicle.getPrmVehicleId());
        vehicule.setCode(prmVehicle.getPrmVehicleCode() );
        vehicule.setNbreEssieux(prmVehicle.getPrmVehicleNbreEssieux());
        vehicule.setEmptyWeight(prmVehicle.getPrmVehicleEmptyWeight());
        vehicule.setDateOfRegistration(prmVehicle.getPrmVehicleDateOfRegistration());
        vehicule.setBrand(prmVehicle.getPrmVehicleBrand());
        vehicule.setModel(prmVehicle.getPrmVehicleModel());
        vehicule.setStatus(prmVehicle.getPrmVehicleStatus());
        prmVehicle.setPrmVehicleType(prmVehicle.getPrmVehicleType());
        if (!lazy) {
            //
            //
            //
//
        }
        return  vehicule;

    }

    public static List<Vehicule>toDtos(List<PrmVehicle> prmVehicles , boolean lazy){
        if (null == prmVehicles) {
            return null;
        }
        List<Vehicule>vehicules = new ArrayList<>();

        for (PrmVehicle prmVehicle : prmVehicles) {
            vehicules.add(toDto(prmVehicle,lazy));
        }
        return  vehicules;
    }
    public static List<Vehicule>toDtos(Iterable<PrmVehicle>prmVehicles , boolean lazy){
        if (null == prmVehicles) {
            return null;
        }
        List<Vehicule>vehicules = new ArrayList<>();

        for (PrmVehicle prmVehicle : prmVehicles) {
            vehicules.add(toDto(prmVehicle,lazy));
        }
        return  vehicules;
    }

    public static Set<PrmVehicle>toEntities(Set<Vehicule>vehicules , boolean lazy){
        if (null == vehicules) {
            return null;
        }
        Set<PrmVehicle> prmVehicles = new HashSet<>();
        for (Vehicule vehicule:vehicules) {
            prmVehicles.add(toEntity(vehicule,lazy));
        }
        return prmVehicles;
    }
    public static Set<Vehicule>toDtos(Set<PrmVehicle>prmVehicles , boolean lazy){
        if (null == prmVehicles) {
            return null;
        }
        Set<Vehicule>vehicules = new HashSet<>();
        for (PrmVehicle prmVehicle:prmVehicles) {
            vehicules.add(toDto(prmVehicle,lazy));
        }
        return vehicules;
    }

}
