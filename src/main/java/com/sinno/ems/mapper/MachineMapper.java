package com.sinno.ems.mapper;

import java.util.*;

/**
 * Created by Enissay on 28/03/2017.
 */
public class MachineMapper {
    private MachineMapper(){

    }
    private static Map<String, String> map;

    static {
        map = new HashMap<>();

        map.put("id","pdtMachineId");
        map.put("code","pdtMachineCode");
        map.put("description","pdtMachineDescription");
        map.put("creationDate","pdtMachineCreationDate");
        map.put("updateDate","pdtMachineUpdateDate");
    }

    public static Map<String, String> getMap() {
        return map;
    }
    public static String getField(String key) {
        return map.get(key);
    }

    public static PdtMachine toEntity(Machine machine, boolean lazy) {
        PdtMachine pdtMachine = new PdtMachine();
        pdtMachine.setPdtMachineId(machine.getId());
        pdtMachine.setPdtMachineCode(machine.getCode());
        pdtMachine.setPdtMachineDescription(machine.getDescription());
        pdtMachine.setPdtMachineCreationDate(machine.getCreationDate());
        pdtMachine.setPdtMachineUpdateDate(machine.getUpdateDate());
        if(!lazy){
        }
        return pdtMachine;
    }

    public static Machine toDto(PdtMachine pdtMachine, boolean lazy){
        Machine machine = new Machine();
        machine.setId(pdtMachine.getPdtMachineId());
        machine.setCode(pdtMachine.getPdtMachineCode());
        machine.setDescription(pdtMachine.getPdtMachineDescription());
        machine.setCreationDate(pdtMachine.getPdtMachineCreationDate());
        machine.setUpdateDate(pdtMachine.getPdtMachineUpdateDate());

        if (!lazy){
        }

        return machine;
    }

    public static List<Machine> toDtos(List<PdtMachine> pdtMachines, boolean lazy) {
        if (null == pdtMachines) {
            return null;
        }
        List<Machine> machines = new ArrayList<>();
        for (PdtMachine pdtMachine : pdtMachines) {
            machines.add(toDto(pdtMachine, lazy));
        }
        return machines;
    }

    public static List<Machine> toDtos(Iterable<PdtMachine> pdtMachines, boolean lazy) {
        if (null == pdtMachines) {
            return null;
        }
        List<Machine> machines = new ArrayList<>();
        for (PdtMachine pdtMachine : pdtMachines) {
            machines.add(toDto(pdtMachine, lazy));
        }
        return machines;
    }

    public static Set<PdtMachine> toEntities(Set<Machine> machines, boolean lazy) {
        if (null == machines) {
            return null;
        }
        Set<PdtMachine> pdtMachines = new HashSet<>();
        for (Machine machine : machines) {
            pdtMachines.add(toEntity(machine, lazy));
        }
        return pdtMachines;
    }

    public static Set<Machine> toDtos(Set<PdtMachine> pdtMachines, boolean lazy) {
        if (null == pdtMachines) {
            return null;
        }
        Set<Machine> machines = new HashSet<>();
        for (PdtMachine pdtMachine : pdtMachines) {
            machines.add(toDto(pdtMachine, lazy));
        }
        return machines;
    }
}
