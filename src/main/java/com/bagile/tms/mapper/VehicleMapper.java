package com.bagile.tms.mapper;

import com.bagile.tms.dto.Vehicule;
import com.bagile.tms.entities.TmsVehicle;

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

        map.put("id", "tmsVehicleId");
        map.put("code", "tmsVehicleCode");
        map.put("nbreEssieux", "tmsVehicleNbreEssieux");
        map.put("emptyWeight", "tmsVehicleEmptyWeight");
        map.put("dateOfRegistration", "tmsVehicleDateOfRegistration");
        map.put("brand", "tmsVehicleBrand");
        map.put("model", "tmsVehicleModel");
        map.put("status", "tmsVehicleStatus");
        map.put("type", "tmsVehicleType");
        map.put("policeAssurance", "tmsVehiclePoliceAssurance");
        map.put("maintenancePlan", "tmsVehicleMaintenancePlan");

        map.put("matricule", "tmsVehicleMatricule");
        map.put("dateCreation", "tmsVehicleDateCreation");
        map.put("dateUpDate", "tmsVehicleDateUpDate");
        map.put("creationUser", "tmsVehicleCreationUser");
        map.put("upDateUser", "tmsVehicleUpDateUser");



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
        tmsVehicle.setTmsVehicleId(vehicule.getId());
        tmsVehicle.setTmsVehicleCode(vehicule.getCode() != null ? vehicule.getCode().toUpperCase() : null);
        tmsVehicle.setTmsVehicleNbreEssieux(vehicule.getNbreEssieux());
        tmsVehicle.setTmsVehicleEmptyWeight(vehicule.getEmptyWeight());
        tmsVehicle.setTmsVehicleDateOfRegistration(vehicule.getDateOfRegistration());
        tmsVehicle.setTmsVehicleBrand(vehicule.getBrand());
        tmsVehicle.setTmsVehicleModel(vehicule.getModel());
        tmsVehicle.setTmsVehicleMatricule(vehicule.getMatricule());
        tmsVehicle.setTmsVehicleDateCreation(vehicule.getDateCreation());
        tmsVehicle.setTmsVehicleDateUpDate(vehicule.getDateUpDate());

        if (!lazy) {

            tmsVehicle.setTmsBadge((BadgeMapper.toEntity(vehicule.getBadge(),true)));
            tmsVehicle.setTmsVehiclePoliceAssurance(PoliceInsuranceMapper.toEntity(vehicule.getPoliceAssurance(),true));
            tmsVehicle.setTmsVehicleMaintenancePlan(MaintenancePlanMapper.toEntity(vehicule.getMaintenancePlan(),true));
            tmsVehicle.setTmsVehicleCreationUser(UserMapper.toEntity(vehicule.getCreationUser(),true));
            tmsVehicle.setTmsVehicleUpDateUser(UserMapper.toEntity(vehicule.getUpDateUser(),true));
//
        }
        return tmsVehicle;

    }

    public static Vehicule toDto(TmsVehicle tmsVehicle, boolean lazy){
        if (null == tmsVehicle) {
            return null;
        }
        Vehicule vehicule = new Vehicule();
        vehicule.setId(tmsVehicle.getTmsVehicleId());
        vehicule.setCode(tmsVehicle.getTmsVehicleCode() );
        vehicule.setNbreEssieux(tmsVehicle.getTmsVehicleNbreEssieux());
        vehicule.setEmptyWeight(tmsVehicle.getTmsVehicleEmptyWeight());
        vehicule.setDateOfRegistration(tmsVehicle.getTmsVehicleDateOfRegistration());
        vehicule.setBrand(tmsVehicle.getTmsVehicleBrand());
        vehicule.setModel(tmsVehicle.getTmsVehicleModel());
        vehicule.setMatricule(tmsVehicle.getTmsVehicleMatricule());
        vehicule.setDateCreation(tmsVehicle.getTmsVehicleDateCreation());
        vehicule.setDateUpDate(tmsVehicle.getTmsVehicleDateUpDate());

        if (!lazy) {
           vehicule.setBadge(BadgeMapper.toDto(tmsVehicle.getTmsBadge(),true));
           vehicule.setPoliceAssurance(PoliceInsuranceMapper.toDto(tmsVehicle.getTmsVehiclePoliceAssurance(),true));
           vehicule.setMaintenancePlan(MaintenancePlanMapper.toDto(tmsVehicle.getTmsVehicleMaintenancePlan(),true));
           vehicule.setCreationUser(UserMapper.toDto(tmsVehicle.getTmsVehicleCreationUser(),true));
           vehicule.setUpDateUser(UserMapper.toDto(tmsVehicle.getTmsVehicleUpDateUser(),true));
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
    public static List<Vehicule>toDtos(Iterable<TmsVehicle>tmsVehicles , boolean lazy){
        if (null == tmsVehicles) {
            return null;
        }
        List<Vehicule>vehicules = new ArrayList<>();

        for (TmsVehicle tmsVehicle : tmsVehicles) {
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
