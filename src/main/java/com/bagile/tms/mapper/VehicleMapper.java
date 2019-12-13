package com.bagile.tms.mapper;

import com.bagile.tms.dto.Vehicle;
import com.bagile.tms.entities.TmsVehicle;

import java.util.*;

public class VehicleMapper {
    public VehicleMapper() {
    }

    private static Map<String, String> map;

    static {
        map = new HashMap<>();

        map.put("id", "tmsVehicleId");
        map.put("registrationNumber", "tmsRegistrationNumber");
        map.put("code", "tmsVehicleCode");
        map.put("technicalVisit", "tmsVehicleTechnicalVisit");
        map.put("creationDate", "creationDate");
        map.put("updateDate", "updateDate");
        map.put("createdBy", "createdBy");
        map.put("updatedBy", "updatedBy");
        map.put("vehicleCategory", "tmsVehicleCategory");
        map.put("badgeType", "tmsBadgeType");
        map.put("insurance", "TmsInsurance");
        map.put("contractType", "TmsContractType");

        map.put("engineOil", "tmsVehicleEngineOil");
        map.put("rearDeck", "tmsVehicleRearDeck");
        map.put("direction", "tmsVehicleDirection");
        map.put("airFilter", "tmsVehicleAirFilter");
        map.put("radiator", "tmsVehicleRadiator");
        map.put("gearBox", "tmsVehicleGearBox");
        map.put("desiccantFilter", "tmsVehicleDesiccantFilter");
        map.put("grayCard", "tmsVehicleGrayCard");
        map.put("numberCylinder", "tmsVehicleNumberCylinder");
        map.put("fiscalPower", "tmsVehicleFiscalPower");
        map.put("body", "tmsVehicleBody");
        map.put("chassisNumber", "tmsVehicleChassisNumber");
        map.put("Energy", "tmsVehicleEnergy");

    }

    public static Map<String, String> getMap() {
        return map;
    }

    public static String getField(String key) {
        return map.get(key);
    }

    public static TmsVehicle toEntity(Vehicle vehicle, boolean lazy) {
        if (null == vehicle) {
            return null;
        }
        TmsVehicle tmsVehicle = new TmsVehicle();
        tmsVehicle.setTmsVehicleId(vehicle.getId());
        tmsVehicle.setTmsRegistrationNumber(vehicle.getRegistrationNumber());
        tmsVehicle.setTmsVehicleCode(vehicle.getCode() != null ? vehicle.getCode().toUpperCase() : null);
        tmsVehicle.setTmsVehicleTechnicalVisit(vehicle.getTechnicalVisit());


        tmsVehicle.setTmsVehicleEngineOil(vehicle.getEngineOil());
        tmsVehicle.setTmsVehicleRearDeck(vehicle.getRearDeck());
        tmsVehicle.setTmsVehicleDirection(vehicle.getDirection());
        tmsVehicle.setTmsVehicleAirFilter(vehicle.getAirFilter());
        tmsVehicle.setTmsVehicleRadiator(vehicle.getRadiator());
        tmsVehicle.setTmsVehicleGearBox(vehicle.getGearBox());
        tmsVehicle.setTmsVehicleDesiccantFilter(vehicle.getDesiccantFilter());
        tmsVehicle.setTmsVehicleGrayCard(vehicle.getGrayCard());
        tmsVehicle.setTmsVehicleNumberCylinder (vehicle.getNumberCylinder());
        tmsVehicle.setTmsVehicleFiscalPower(vehicle.getFiscalPower());
        tmsVehicle.setTmsVehicleBody(vehicle.getBody());
        tmsVehicle.setTmsVehicleChassisNumber(vehicle.getChassisNumber());
        tmsVehicle.setTmsVehicleEnergy (vehicle.getenergy());



        if (!lazy) {
            tmsVehicle.setTmsVehicleCategory(VehicleCategoryMapper.toEntity(vehicle.getVehicleCategory(), false));
            tmsVehicle.setTmsBadgeType(BadgeTypeMapper.toEntity(vehicle.getBadgeType(), false));
            tmsVehicle.setTmsInsurance(InsuranceMapper.toEntity(vehicle.getInsurance(), false));
            tmsVehicle.setTmsContractType (ContractTypeMapper.toEntity (vehicle.getContractType (), false));

        }
        return tmsVehicle;

    }

    public static Vehicle toDto(TmsVehicle tmsVehicle, boolean lazy) {
        if (null == tmsVehicle) {
            return null;
        }
        Vehicle vehicle = new Vehicle();
        vehicle.setId((int) tmsVehicle.getTmsVehicleId());
        vehicle.setRegistrationNumber(tmsVehicle.getTmsRegistrationNumber());
        vehicle.setCode(tmsVehicle.getTmsVehicleCode());
        vehicle.setTechnicalVisit(tmsVehicle.getTmsVehicleTechnicalVisit());

        vehicle.setCreatedBy(tmsVehicle.getCreatedBy());
        vehicle.setUpdatedBy(tmsVehicle.getUpdatedBy());
        vehicle.setCreationDate(tmsVehicle.getCreationDate());
        vehicle.setUpdateDate(tmsVehicle.getUpdateDate());


        vehicle.setEngineOil(tmsVehicle.getTmsVehicleEngineOil());
        vehicle.setRearDeck(tmsVehicle.getTmsVehicleRearDeck());
        vehicle.setDirection(tmsVehicle.getTmsVehicleDirection());
        vehicle.setAirFilter(tmsVehicle.getTmsVehicleAirFilter());
        vehicle.setRadiator(tmsVehicle.getTmsVehicleRadiator());
        vehicle.setGearBox(tmsVehicle.getTmsVehicleGearBox());
        vehicle.setDesiccantFilter(tmsVehicle.getTmsVehicleDesiccantFilter());
        vehicle.setGrayCard(tmsVehicle.getTmsVehicleGrayCard());
        vehicle.setNumberCylinder(tmsVehicle.getTmsVehicleNumberCylinder());
        vehicle.setFiscalPower(tmsVehicle.getTmsVehicleFiscalPower());
        vehicle.setBody(tmsVehicle.getTmsVehicleBody());
        vehicle.setChassisNumber(tmsVehicle.getTmsVehicleChassisNumber());
        vehicle.setEnergy(tmsVehicle.getTmsVehicleEnergy());


        if (!lazy) {
            vehicle.setBadgeType(BadgeTypeMapper.toDto(tmsVehicle.getTmsBadgeType(), true));
            vehicle.setVehicleCategory(VehicleCategoryMapper.toDto(tmsVehicle.getTmsVehicleCategory(), true));
            vehicle.setInsurance(InsuranceMapper.toDto(tmsVehicle.getTmsInsurance(), false));
            vehicle.setContractType (ContractTypeMapper.toDto (tmsVehicle.getTmsContractType (), true));
        }
        return vehicle;

    }


    public static List<Vehicle> toDtos(Iterable<? extends TmsVehicle> tmsVehicles, boolean lazy) {
        if (null == tmsVehicles) {
            return null;
        }
        List<Vehicle> vehicles = new ArrayList<>();

        for (TmsVehicle tmsVehicle : tmsVehicles) {
            vehicles.add(toDto(tmsVehicle, lazy));
        }
        return vehicles;
    }

    public static Set<TmsVehicle> toEntities(Set<Vehicle> vehicles, boolean lazy) {
        if (null == vehicles) {
            return null;
        }
        Set<TmsVehicle> tmsVehicles = new HashSet<>();
        for (Vehicle vehicle : vehicles) {
            tmsVehicles.add(toEntity(vehicle, lazy));
        }
        return tmsVehicles;
    }

    public static Set<Vehicle> toDtos(Set<TmsVehicle> tmsVehicles, boolean lazy) {
        if (null == tmsVehicles) {
            return null;
        }
        Set<Vehicle> vehicles = new HashSet<>();
        for (TmsVehicle tmsVehicle : tmsVehicles) {
            vehicles.add(toDto(tmsVehicle, lazy));
        }
        return vehicles;
    }
}
