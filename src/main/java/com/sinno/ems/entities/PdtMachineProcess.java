package com.sinno.ems.entities;

import javax.persistence.*;

/**
 * Created by Enissay on 28/03/2017.
 */
@Entity
@Table(name="pdt_machine_process")
public class PdtMachineProcess {
    private long pdtMachineProcessId;
    private PdtMachine pdtMachine;
    private PdtProcess pdtProcess;
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq")
    @SequenceGenerator(name = "seq", sequenceName = "seq_pdt_machineprocess", allocationSize = 1)
    @Column(name = "pdt_machineprocessid", unique = true, nullable = false, precision = 10, scale = 0)
    public long getPdtMachineProcessId() {
        return pdtMachineProcessId;
    }

    public void setPdtMachineProcessId(long pdtMachineProcessId) {
        this.pdtMachineProcessId = pdtMachineProcessId;
    }
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "pdt_machineprocessprocessid")
    public PdtMachine getPdtMachine() {
        return pdtMachine;
    }

    public void setPdtMachine(PdtMachine pdtMachine) {
        this.pdtMachine = pdtMachine;
    }
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "pdt_machineprocessmachineid")

    public PdtProcess getPdtProcess() {
        return pdtProcess;
    }

    public void setPdtProcess(PdtProcess pdtProcess) {
        this.pdtProcess = pdtProcess;
    }
}
