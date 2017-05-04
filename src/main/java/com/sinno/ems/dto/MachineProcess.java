package com.sinno.ems.dto;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by Enissay on 28/03/2017.
 */
public class MachineProcess {
    private long id;
    private Process process;
    private Machine machine;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Process getProcess() {
        return process;
    }

    public void setProcess(Process process) {
        this.process = process;
    }

    public Machine getMachine() {
        return machine;
    }

    public void setMachine(Machine machine) {
        this.machine = machine;
    }

}
