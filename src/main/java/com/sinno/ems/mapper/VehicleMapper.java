package com.sinno.ems.mapper;

import com.sinno.ems.dto.Vehicule;
import com.sinno.ems.entities.TmsVehicle;

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

        map.put("matricule", "prmVehicleMatricule");
        map.put("dateCreation", "prmVehicleDateCreation");
        map.put("dateUpDate", "prmVehicleDateUpDate");
        map.put("creationUser", "prmVehicleCreationUser");
        map.put("upDateUser", "prmVehicleUpDateUser");



    }
    public static Map<String, String> getMap() {
        return map;
    }

    public static String getField(String key) {
        return map.get(key);
    }

    public static TmsVehicle toEntity(Vehicule vehicule , boolean lazy){
        if (null == vehicule) {
            return null;
        }
        TmsVehicle tmsVehicle = new TmsVehicle();
        tmsVehicle.setPrmVehicleId(vehicule.getId());
        tmsVehicle.setPrmVehicleCode(vehicule.getCode() != null ? vehicule.getCode().toUpperCase() : null);
        tmsVehicle.setPrmVehicleNbreEssieux(vehicule.getNbreEssieux());
        tmsVehicle.setPrmVehicleEmptyWeight(vehicule.getEmptyWeight());
        tmsVehicle.setPrmVehicleDateOfRegistration(vehicule.getDateOfRegistration());
        tmsVehicle.setPrmVehicleBrand(vehicule.getBrand());
        tmsVehicle.setPrmVehicleModel(vehicule.getModel());
        tmsVehicle.setPrmVehicleMatricule(vehicule.getMatricule());
        tmsVehicle.setPrmVehicleDateCreation(vehicule.getDateCreation());
        tmsVehicle.setPrmVehicleDateUpDate(vehicule.getDateUpDate());

        if (!lazy) {

            tmsVehicle.setPrmVehicleBadges((BadgeMapper.toEntities(vehicule.getBadges(),true)));
            tmsVehicle.setPrmVehiclePoliceAssurance(PoliceInsuranceMapper.toEntity(vehicule.getPoliceAssurance(),true));
            tmsVehicle.setPrmVehicleMaintenancePlan(MaintenancePlanMapper.toEntity(vehicule.getMaintenancePlan(),true));
            tmsVehicle.setPrmVehicleCreationUser(UserMapper.toEntity(vehicule.getCreationUser(),true));
            tmsVehicle.setPrmVehicleUpDateUser(UserMapper.toEntity(vehicule.getUpDateUser(),true));
//
        }
        return tmsVehicle;

    }

    public static Vehicule toDto(TmsVehicle tmsVehicle, boolean lazy){
        if (null == tmsVehicle) {
            return null;
        }
        Vehicule vehicule = new Vehicule();
        vehicule.setId(tmsVehicle.getPrmVehicleId());
        vehicule.setCode(tmsVehicle.getPrmVehicleCode() );
        vehicule.setNbreEssieux(tmsVehicle.getPrmVehicleNbreEssieux());
        vehicule.setEmptyWeight(tmsVehicle.getPrmVehicleEmptyWeight());
        vehicule.setDateOfRegistration(tmsVehicle.getPrmVehicleDateOfRegistration());
        vehicule.setBrand(tmsVehicle.getPrmVehicleBrand());
        vehicule.setModel(tmsVehicle.getPrmVehicleModel());
        vehicule.setMatricule(tmsVehicle.getPrmVehicleMatricule());
        vehicule.setDateCreation(tmsVehicle.getPrmVehicleDateCreation());
        vehicule.setDateUpDate(tmsVehicle.getPrmVehicleDateUpDate());

        if (!lazy) {
           vehicule.setBadges(BadgeMapper.toDtos(tmsVehicle.getPrmVehicleBadges(),true));
           vehicule.setPoliceAssurance(PoliceInsuranceMapper.toDto(tmsVehicle.getPrmVehiclePoliceAssurance(),true));
           vehicule.setMaintenancePlan(MaintenancePlanMapper.toDto(tmsVehicle.getPrmVehicleMaintenancePlan(),true));
           vehicule.setCreationUser(UserMapper.toDto(tmsVehicle.getPrmVehicleCreationUser(),true));
           vehicule.setUpDateUser(UserMapper.toDto(tmsVehicle.getPrmVehicleUpDateUser(),true));
//
        }
        return  vehicule;

    }

    public static List<Vehicule>toDtos(List<TmsVehicle> tmsVehicles, boolean lazy){
        if (null == tmsVehicles) {
            return null;
        }
        List<Vehicule>vehicules = new ArrayList<>();

        for (TmsVehicle tmsVehicle : tmsVehicles) {
            vehicules.add(toDto(tmsVehicle,lazy));
        }
        return  vehicules;
    }
    public static List<Vehicule>toDtos(Iterable<TmsVehicle>prmVehicles , boolean lazy){
        if (null == prmVehicles) {
            return null;
        }
        List<Vehicule>vehicules = new ArrayList<>();

        for (TmsVehicle tmsVehicle : prmVehicles) {
            vehicules.add(toDto(tmsVehicle,lazy));
        }
        return  vehicules;
    }

    public static Set<TmsVehicle>toEntities(Set<Vehicule>vehicules , boolean lazy){
        if (null == vehicules) {
            return null;
        }
        Set<TmsVehicle> tmsVehicles = new HashSet<>();
        for (Vehicule vehicule:vehicules) {
            tmsVehicles.add(toEntity(vehicule,lazy));
        }
        return tmsVehicles;
    }
    public static Set<Vehicule>toDtos(Set<TmsVehicle> tmsVehicles, boolean lazy){
        if (null == tmsVehicles) {
            return null;
        }
        Set<Vehicule>vehicules = new HashSet<>();
        for (TmsVehicle tmsVehicle : tmsVehicles) {
            vehicules.add(toDto(tmsVehicle,lazy));
        }
        return vehicules;
    }
}
