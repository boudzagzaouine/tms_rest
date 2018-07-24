package com.bagile.tms.mapper;

import java.util.*;

/**
 * Created by Enissay on 28/03/2017.
 */
public class ProcessMapper {
    private ProcessMapper() {

    }

    private static Map<String, String> map;

    static {
        map = new HashMap<>();

        map.put("id", "pdtProcessId");
        map.put("code", "pdtProcessCode");
        map.put("description", "pdtProcessDescription");
        map.put("creationDate", "pdtProcessCreationDate");
        map.put("updateDate", "pdtProcessUpdateDate");
    }

    public static Map<String, String> getMap() {
        return map;
    }

    public static String getField(String key) {
        return map.get(key);
    }

    public static PdtProcess toEntity(Process process, boolean lazy) {
        if(null==process){
            return null;
        }
        PdtProcess pdtProcess = new PdtProcess();
        pdtProcess.setPdtProcessId(process.getId());
        pdtProcess.setPdtProcessCode(process.getCode());
        pdtProcess.setPdtProcessDescription(process.getDescription());
        pdtProcess.setPdtProcessCreationDate(process.getCreationDate());
        pdtProcess.setPdtProcessUpdateDate(process.getUpdateDate());

        if (!lazy) {
            pdtProcess.setPdtMachineProcesses(MachineProcessMapper.toEntities(process.getMachineProcesses(), false));
            oneToMany(pdtProcess);
        }
        return pdtProcess;
    }

    public static void oneToMany(PdtProcess pdtProcess) {
        if (null != pdtProcess.getPdtMachineProcesses()) {
            pdtProcess.getPdtMachineProcesses().stream().forEach(sl -> {
                sl.setPdtProcess(pdtProcess);
            });
        }
    }

    public static Process toDto(PdtProcess pdtProcess, boolean lazy) {
        if(null==pdtProcess){
            return null;
        }
        Process process = new Process();
        process.setId(pdtProcess.getPdtProcessId());
        process.setCode(pdtProcess.getPdtProcessCode());
        process.setDescription(pdtProcess.getPdtProcessDescription());
        process.setCreationDate(pdtProcess.getPdtProcessCreationDate());
        process.setUpdateDate(pdtProcess.getPdtProcessUpdateDate());

        if (!lazy) {
            process.setMachineProcesses(MachineProcessMapper.toDtos(pdtProcess.getPdtMachineProcesses(), false));
        }

        return process;
    }

    public static List<Process> toDtos(List<PdtProcess> pdtProcesss, boolean lazy) {
        if (null == pdtProcesss) {
            return null;
        }
        List<Process> machines = new ArrayList<>();
        for (PdtProcess pdtProcess : pdtProcesss) {
            machines.add(toDto(pdtProcess, lazy));
        }
        return machines;
    }

    public static List<Process> toDtos(Iterable<PdtProcess> pdtProcesss, boolean lazy) {
        if (null == pdtProcesss) {
            return null;
        }
        List<Process> machines = new ArrayList<>();
        for (PdtProcess pdtProcess : pdtProcesss) {
            machines.add(toDto(pdtProcess, lazy));
        }
        return machines;
    }

    public static Set<PdtProcess> toEntities(Set<Process> machines, boolean lazy) {
        if (null == machines) {
            return null;
        }
        Set<PdtProcess> pdtProcesss = new HashSet<>();
        for (Process machine : machines) {
            pdtProcesss.add(toEntity(machine, lazy));
        }
        return pdtProcesss;
    }

    public static Set<Process> toDtos(Set<PdtProcess> pdtProcesss, boolean lazy) {
        if (null == pdtProcesss) {
            return null;
        }
        Set<Process> machines = new HashSet<>();
        for (PdtProcess pdtProcess : pdtProcesss) {
            machines.add(toDto(pdtProcess, lazy));
        }
        return machines;
    }
}
