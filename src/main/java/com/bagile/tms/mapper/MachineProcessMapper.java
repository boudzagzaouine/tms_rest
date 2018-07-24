package com.bagile.tms.mapper;

import java.util.*;

/**
 * Created by Enissay on 28/03/2017.
 */
public class MachineProcessMapper {
    private static Map<String, String> map;

    private MachineProcessMapper() {
    }

    static {
        map = new HashMap<>();

        map.put("id", "pdtProcessMachine");
        map.put("machine", "pdtMachine");
        map.put("process", "pdtProcess");
    }

    public static String getField(String key) {
        return map.get(key);
    }

    public static Map<String, String> getMap() {
        return map;
    }

    public static MachineProcess toDto(PdtMachineProcess pdtMachineProcess, boolean lazy) {
        if (null == pdtMachineProcess) {
            return null;
        }
        MachineProcess machineProcess = new MachineProcess();
        machineProcess.setId(pdtMachineProcess.getPdtMachineProcessId());
        if (!lazy) {
            machineProcess.setMachine(MachineMapper.toDto(pdtMachineProcess.getPdtMachine(), true));
            machineProcess.setProcess(ProcessMapper.toDto(pdtMachineProcess.getPdtProcess(), true));
        }
        return machineProcess;
    }

    public static PdtMachineProcess toEntity(MachineProcess machineProcess, boolean lazy) {
        if (null == machineProcess) {
            return null;
        }
        PdtMachineProcess pdtMachineProcess = new PdtMachineProcess();
        pdtMachineProcess.setPdtMachineProcessId(machineProcess.getId());
        if (!lazy) {
            pdtMachineProcess.setPdtMachine(MachineMapper.toEntity(machineProcess.getMachine(), true));
            pdtMachineProcess.setPdtProcess(ProcessMapper.toEntity(machineProcess.getProcess(), true));
        }
        return pdtMachineProcess;
    }

    public static List<MachineProcess> toDtos(List<PdtMachineProcess> machineProcesss, boolean lazy) {
        if (null == machineProcesss) {
            return null;
        }
        List<MachineProcess> processMachines = new ArrayList<>();
        for (PdtMachineProcess pdtMachineProcess : machineProcesss) {
            processMachines.add(toDto(pdtMachineProcess, lazy));
        }
        return processMachines;
    }

    public static List<MachineProcess> toDtos(Iterable<PdtMachineProcess> machineProcesss, boolean lazy) {
        if (null == machineProcesss) {
            return null;
        }
        List<MachineProcess> processMachines = new ArrayList<>();
        for (PdtMachineProcess pdtMachineProcess : machineProcesss) {
            processMachines.add(toDto(pdtMachineProcess, lazy));
        }
        return processMachines;
    }

    public static Set<PdtMachineProcess> toEntities(Set<MachineProcess> processMachines, boolean lazy) {
        if (null == processMachines) {
            return null;
        }
        Set<PdtMachineProcess> machineProcesss = new HashSet<>();
        for (MachineProcess machineProcess : processMachines) {
            machineProcesss.add(toEntity(machineProcess, lazy));
        }
        return machineProcesss;
    }

    public static Set<MachineProcess> toDtos(Set<PdtMachineProcess> machineProcesss, boolean lazy) {
        if (null == machineProcesss) {
            return null;
        }
        Set<MachineProcess> processMachines = new HashSet<>();
        for (PdtMachineProcess pdtMachineProcess : machineProcesss) {
            processMachines.add(toDto(pdtMachineProcess, lazy));
        }
        return processMachines;
    }
}
