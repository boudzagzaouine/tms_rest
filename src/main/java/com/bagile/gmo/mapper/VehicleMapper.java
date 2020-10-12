package com.bagile.gmo.mapper;

import com.bagile.gmo.dto.Vehicle;
import com.bagile.gmo.entities.GmoVehicle;

import java.util.*;

public class VehicleMapper {
    public VehicleMapper() {
    }

    private static Map<String, String> map;

    static {
        map = new HashMap<>();

        map.put("id", "gmoPatrimonyId");
        map.put("registrationNumber", "gmoRegistrationNumber");
        map.put("code", "gmoPatrimonyCode");
        map.put("technicalVisit", "gmoVehicleTechnicalVisit");
        map.put("valueTechnicalVisit", "gmoVehicleValueTechnicalvisit");
        map.put("creationDate", "creationDate");
        map.put("updateDate", "updateDate");
        map.put("createdBy", "createdBy");
        map.put("updatedBy", "updatedBy");
        map.put("vehicleCategory", "gmoVehicleCategory");
        map.put("badgeType", "gmoBadgeType");
        map.put("insurance", "gmoInsurance");
        map.put("contractType", "gmoContractType");
        map.put("consumptiontype", "gmoConsumptionType");
        map.put("vignette", "gmoVehicleVignette");
        map.put("valueVignette", "gmoVehicleValueVignete");
        map.put("aquisitionDate", "gmoAquisitionDate");
        map.put("amount", "gmoAamount");
        map.put("engineOil", "gmoVehicleEngineOil");
        map.put("rearDeck", "gmoVehicleRearDeck");
        map.put("direction", "gmoVehicleDirection");
        map.put("airFilter", "gmoVehicleAirFilter");
        map.put("radiator", "gmoVehicleRadiator");
        map.put("gearBox", "gmoVehicleGearBox");
        map.put("desiccantFilter", "gmoVehicleDesiccantFilter");
        map.put("grayCard", "gmoVehicleGrayCard");
        map.put("numberCylinder", "gmoVehicleNumberCylinder");
        map.put("fiscalPower", "gmoVehicleFiscalPower");
        map.put("body", "gmoVehicleBody");
        map.put("chassisNumber", "gmoVehicleChassisNumber");
        map.put("Energy", "gmoVehicleEnergy");
        map.put("transport", "trpTransport");
        map.put("maintenancePlan", "gmoMaintenancePlan");

        //  map.put("insuranceTermVehicles", "gmoInsuranceTermsVehicules");

    }

    public static Map<String, String> getMap() {
        return map;
    }

    public static String getField(String key) {
        return map.get(key);
    }

    public static GmoVehicle toEntity(Vehicle vehicle, boolean lazy) {
        if (null == vehicle) {
            return null;
        }
        GmoVehicle gmoVehicle = new GmoVehicle();
        gmoVehicle.setGmoPatrimonyId(vehicle.getId());
        gmoVehicle.setGmoRegistrationNumber(vehicle.getRegistrationNumber());
        gmoVehicle.setGmoPatrimonyCode(vehicle.getCode() != null ? vehicle.getCode().toUpperCase() : null);
        gmoVehicle.setGmoVehicleTechnicalVisit(vehicle.getTechnicalVisit());
        gmoVehicle.setGmoVehicleValueTechnicalvisit(vehicle.getValueTechnicalVisit());
        gmoVehicle.setGmoAquisitionDate(vehicle.getAquisitionDate());
        gmoVehicle.setGmoAamount(vehicle.getAmount());

        gmoVehicle.setGmoVehicleEngineOil(vehicle.getEngineOil());
        gmoVehicle.setGmoVehicleRearDeck(vehicle.getRearDeck());
        gmoVehicle.setGmoVehicleDirection(vehicle.getDirection());
        gmoVehicle.setGmoVehicleAirFilter(vehicle.getAirFilter());
        gmoVehicle.setGmoVehicleRadiator(vehicle.getRadiator());
        gmoVehicle.setGmoVehicleGearBox(vehicle.getGearBox());
        gmoVehicle.setGmoVehicleDesiccantFilter(vehicle.getDesiccantFilter());
        gmoVehicle.setGmoVehicleGrayCard(vehicle.getGrayCard());
        gmoVehicle.setGmoVehicleNumberCylinder (vehicle.getNumberCylinder());
        gmoVehicle.setGmoVehicleFiscalPower(vehicle.getFiscalPower());
        gmoVehicle.setGmoVehicleBody(vehicle.getBody());
        gmoVehicle.setGmoVehicleChassisNumber(vehicle.getChassisNumber());
        gmoVehicle.setGmoVehicleEnergy (vehicle.getEnergy());

        gmoVehicle.setGmoVehicleVignette (vehicle.getVignette());
        gmoVehicle.setGmoVehicleValueVignete(vehicle.getValueVignette());

        if (!lazy) {
            gmoVehicle.setGmoVehicleCategory(VehicleCategoryMapper.toEntity(vehicle.getVehicleCategory(), true));
            gmoVehicle.setGmoBadgeType(BadgeTypeMapper.toEntity(vehicle.getBadgeType(), true));
            ///gmoVehicle.setGmoInsurance(InsuranceMapper.toEntity(vehicle.getInsurance(), false));
            gmoVehicle.setGmoContractType (ContractTypeMapper.toEntity (vehicle.getContractType (), true));
            gmoVehicle.setGmoConsumptionType (ConsumptionTypeMapper.toEntity (vehicle.getConsumptionType (), true));
           // gmoVehicle.setGmoInsuranceTermsVehicules (InsuranceTermsVehicleMapper.toEntities (vehicle.getInsuranceTermVehicles (), false));
            gmoVehicle.setTrpTransport (TransportMapper.toEntity (vehicle.getTransport (), false));
            gmoVehicle.setGmoMaintenancePlan (MaintenancePlanMapper.toEntity (vehicle.getMaintenancePlan (), false));

            //oneToOne(gmoVehicle);
           // oneToMany(gmoVehicle);
        }
        return gmoVehicle;

    }

    public static Vehicle toDto(GmoVehicle gmoVehicle, boolean lazy) {
        if (null == gmoVehicle) {
            return null;
        }
        Vehicle vehicle = new Vehicle();
        vehicle.setId(gmoVehicle.getGmoPatrimonyId());
        vehicle.setRegistrationNumber(gmoVehicle.getGmoRegistrationNumber());
        vehicle.setCode(gmoVehicle.getGmoPatrimonyCode());
        vehicle.setTechnicalVisit(gmoVehicle.getGmoVehicleTechnicalVisit());
        vehicle.setValueTechnicalVisit(gmoVehicle.getGmoVehicleValueTechnicalvisit());

        vehicle.setAquisitionDate(gmoVehicle.getGmoAquisitionDate());
        vehicle.setAmount(gmoVehicle.getGmoAamount());

        vehicle.setCreatedBy(gmoVehicle.getCreatedBy());
        vehicle.setUpdatedBy(gmoVehicle.getUpdatedBy());
        vehicle.setCreationDate(gmoVehicle.getCreationDate());
        vehicle.setUpdateDate(gmoVehicle.getUpdateDate());


        vehicle.setEngineOil(gmoVehicle.getGmoVehicleEngineOil());
        vehicle.setRearDeck(gmoVehicle.getGmoVehicleRearDeck());
        vehicle.setDirection(gmoVehicle.getGmoVehicleDirection());
        vehicle.setAirFilter(gmoVehicle.getGmoVehicleAirFilter());
        vehicle.setRadiator(gmoVehicle.getGmoVehicleRadiator());
        vehicle.setGearBox(gmoVehicle.getGmoVehicleGearBox());
        vehicle.setDesiccantFilter(gmoVehicle.getGmoVehicleDesiccantFilter());
        vehicle.setGrayCard(gmoVehicle.getGmoVehicleGrayCard());
        vehicle.setNumberCylinder(gmoVehicle.getGmoVehicleNumberCylinder());
        vehicle.setFiscalPower(gmoVehicle.getGmoVehicleFiscalPower());
        vehicle.setBody(gmoVehicle.getGmoVehicleBody());
        vehicle.setChassisNumber(gmoVehicle.getGmoVehicleChassisNumber());
        vehicle.setEnergy(gmoVehicle.getGmoVehicleEnergy());

        vehicle.setVignette(gmoVehicle.getGmoVehicleVignette());
        vehicle.setValueVignette(gmoVehicle.getGmoVehicleValueVignete());

        if (!lazy) {
            vehicle.setBadgeType(BadgeTypeMapper.toDto(gmoVehicle.getGmoBadgeType(), true));
            vehicle.setVehicleCategory(VehicleCategoryMapper.toDto(gmoVehicle.getGmoVehicleCategory(), false));
            //vehicle.setInsurance(InsuranceMapper.toDto(gmoVehicle.getGmoInsurance(), false));
            vehicle.setContractType (ContractTypeMapper.toDto (gmoVehicle.getGmoContractType (), true));
            vehicle.setConsumptionType (ConsumptionTypeMapper.toDto (gmoVehicle.getGmoConsumptionType (), true));
           // vehicle.setInsuranceTermVehicles (InsuranceTermsVehicleMapper.toDtos(gmoVehicle.getGmoInsuranceTermsVehicules (), false));
            vehicle.setTransport (TransportMapper.toDto (gmoVehicle.getTrpTransport (), false));
            vehicle.setMaintenancePlan (MaintenancePlanMapper.toDto (gmoVehicle.getGmoMaintenancePlan (), false));

        }
        return vehicle;

    }
   /* private static void oneToMany(GmoVehicle vehicle) {
        vehicle.getGmoInsuranceTermsVehicules().forEach(
                e -> {
                    e.setCreationDate(new Date());
                    e.setGmoVehicle(vehicle);
                }
        );
    }*/
  /*private static void oneToOne(GmoVehicle vehicle) {
        vehicle.getGmoInsurance().setGmoVehicle(vehicle);
                }*/


    public static List<Vehicle> toDtos(Iterable<? extends GmoVehicle> gmoVehicles, boolean lazy) {
        if (null == gmoVehicles) {
            return null;
        }
        List<Vehicle> vehicles = new ArrayList<>();

        for (GmoVehicle gmoVehicle : gmoVehicles) {
            vehicles.add(toDto(gmoVehicle, lazy));
        }
        return vehicles;
    }

    public static Set<GmoVehicle> toEntities(Set<Vehicle> vehicles, boolean lazy) {
        if (null == vehicles) {
            return null;
        }
        Set<GmoVehicle> gmoVehicles = new HashSet<>();
        for (Vehicle vehicle : vehicles) {
            gmoVehicles.add(toEntity(vehicle, lazy));
        }
        return gmoVehicles;
    }

    public static Set<Vehicle> toDtos(Set<GmoVehicle> gmoVehicles, boolean lazy) {
        if (null == gmoVehicles) {
            return null;
        }
        Set<Vehicle> vehicles = new HashSet<>();
        for (GmoVehicle gmoVehicle : gmoVehicles) {
            vehicles.add(toDto(gmoVehicle, lazy));
        }
        return vehicles;
    }
}
