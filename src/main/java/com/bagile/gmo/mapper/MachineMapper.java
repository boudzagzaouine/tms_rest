package com.bagile.gmo.mapper;

import com.bagile.gmo.dto.Machine;
import com.bagile.gmo.entities.GmoMachine;

import java.util.*;

public class MachineMapper {
    public MachineMapper() {
    }

    private static Map<String, String> map;

    static {
        map = new HashMap<>();

        map.put("id", "gmoPatrimonyId");
        map.put("code", "gmoMachineCode");
        map.put("ref", "gmoMachineRef");

        map.put("contractType", "gmoContractType");
        map.put("consumptiontype", "gmoConsumptionType");
        map.put("aquisitionDate", "gmoAquisitionDate");
        map.put("amount", "gmoAamount");
        map.put("transport", "trpTransport");

        map.put("creationDate", "creationDate");
        map.put("updateDate", "updateDate");
        map.put("createdBy", "createdBy");
        map.put("updatedBy", "updatedBy");
        map.put("maintenancePlan", "gmoMaintenancePlan");
    }

    public static Map<String, String> getMap() {
        return map;
    }

    public static String getField(String key) {
        return map.get(key);
    }

    public static GmoMachine toEntity(Machine machine, boolean lazy) {
        if (null == machine) {
            return null;
        }
        GmoMachine gmoMachine = new GmoMachine();
        gmoMachine.setGmoPatrimonyId(machine.getId());
        gmoMachine.setGmoPatrimonyCode(machine.getCode() != null ? machine.getCode().toUpperCase() : null);
        gmoMachine.setGmoMachineAquisitionDate(machine.getAquisitionDate());
        gmoMachine.setGmoMachineAamount(machine.getAmount());
        gmoMachine.setGmoMachineRef(machine.getRef());



        if (!lazy) {

            gmoMachine.setGmoContractType (ContractTypeMapper.toEntity (machine.getContractType (), true));
            gmoMachine.setGmoConsumptionType (ConsumptionTypeMapper.toEntity (machine.getConsumptionType (), true));
            gmoMachine.setTrpTransport (TransportMapper.toEntity (machine.getTransport (), false));
            gmoMachine.setGmoMaintenancePlan (MaintenancePlanMapper.toEntity (machine.getMaintenancePlan (), false));

        }
        return gmoMachine;

    }

    public static Machine toDto(GmoMachine gmoMachine, boolean lazy) {
        if (null == gmoMachine) {
            return null;
        }
        Machine machine = new Machine();
        machine.setId(gmoMachine.getGmoPatrimonyId());
        machine.setCode(gmoMachine.getGmoPatrimonyCode());
        machine.setAquisitionDate(gmoMachine.getGmoMachineAquisitionDate());
        machine.setAmount(gmoMachine.getGmoMachineAamount());
        machine.setRef(gmoMachine.getGmoMachineRef());

        machine.setCreatedBy(gmoMachine.getCreatedBy());
        machine.setUpdatedBy(gmoMachine.getUpdatedBy());
        machine.setCreationDate(gmoMachine.getCreationDate());
        machine.setUpdateDate(gmoMachine.getUpdateDate());




        if (!lazy) {

            machine.setContractType (ContractTypeMapper.toDto (gmoMachine.getGmoContractType (), true));
            machine.setConsumptionType (ConsumptionTypeMapper.toDto (gmoMachine.getGmoConsumptionType (), true));
            machine.setTransport (TransportMapper.toDto (gmoMachine.getTrpTransport (), false));
            machine.setMaintenancePlan (MaintenancePlanMapper.toDto (gmoMachine.getGmoMaintenancePlan (), false));

        }
        return machine;

    }



    public static List<Machine> toDtos(Iterable<? extends GmoMachine> gmoMachines, boolean lazy) {
        if (null == gmoMachines) {
            return null;
        }
        List<Machine> machines = new ArrayList<>();

        for (GmoMachine gmoMachine : gmoMachines) {
            machines.add(toDto(gmoMachine, lazy));
        }
        return machines;
    }

    public static Set<GmoMachine> toEntities(Set<Machine> machines, boolean lazy) {
        if (null == machines) {
            return null;
        }
        Set<GmoMachine> gmoMachines = new HashSet<>();
        for (Machine machine : machines) {
            gmoMachines.add(toEntity(machine, lazy));
        }
        return gmoMachines;
    }

    public static Set<Machine> toDtos(Set<GmoMachine> gmoMachines, boolean lazy) {
        if (null == gmoMachines) {
            return null;
        }
        Set<Machine> machines = new HashSet<>();
        for (GmoMachine gmoMachine : gmoMachines) {
            machines.add(toDto(gmoMachine, lazy));
        }
        return machines;
    }
}
