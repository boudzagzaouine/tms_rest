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
        prmVehicle.setPrmVehicleMatricule(vehicule.getMatricule());
        prmVehicle.setPrmVehicleDateCreation(vehicule.getDateCreation());
        prmVehicle.setPrmVehicleDateUpDate(vehicule.getDateUpDate());

        if (!lazy) {

            prmVehicle.setPrmVehicleBadges((BadgeMapper.toEntities(vehicule.getBadges(),true)));
            prmVehicle.setPrmVehiclePoliceAssurance(PoliceInsuranceMapper.toEntity(vehicule.getPoliceAssurance(),true));
            prmVehicle.setPrmVehicleMaintenancePlan(MaintenancePlanMapper.toEntity(vehicule.getMaintenancePlan(),true));
            prmVehicle.setPrmVehicleCreationUser(UserMapper.toEntity(vehicule.getCreationUser(),true));
            prmVehicle.setPrmVehicleUpDateUser(UserMapper.toEntity(vehicule.getUpDateUser(),true));
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
        vehicule.setMatricule(prmVehicle.getPrmVehicleMatricule());
        vehicule.setDateCreation(prmVehicle.getPrmVehicleDateCreation());
        vehicule.setDateUpDate(prmVehicle.getPrmVehicleDateUpDate());

        if (!lazy) {
           vehicule.setBadges(BadgeMapper.toDtos(prmVehicle.getPrmVehicleBadges(),true));
           vehicule.setPoliceAssurance(PoliceInsuranceMapper.toDto(prmVehicle.getPrmVehiclePoliceAssurance(),true));
           vehicule.setMaintenancePlan(MaintenancePlanMapper.toDto(prmVehicle.getPrmVehicleMaintenancePlan(),true));
           vehicule.setCreationUser(UserMapper.toDto(prmVehicle.getPrmVehicleCreationUser(),true));
           vehicule.setUpDateUser(UserMapper.toDto(prmVehicle.getPrmVehicleUpDateUser(),true));
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
