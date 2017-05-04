package com.sinno.ems.entities;

import com.sinno.ems.dto.MachineProcess;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "pdt_machine", uniqueConstraints = {
        @UniqueConstraint(columnNames = {"pdt_machinecode"})})
public class PdtMachine implements Serializable {
    private Long pdtMachineId;
    @Size(max = 30)
    private String pdtMachineCode;
    @Size(max = 255)
    private String pdtMachineDescription;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date pdtMachineCreationDate;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date pdtMachineUpdateDate;
    private Set<PdtMachineProcess> pdtMachineProcesses = new HashSet<PdtMachineProcess>(0);

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq")
    @SequenceGenerator(name = "seq", sequenceName = "seq_pdt_machine", allocationSize = 1)
    @Column(name = "pdt_machineid", unique = true, nullable = false, precision = 10, scale = 0)
    public Long getPdtMachineId() {
        return pdtMachineId;
    }

    public void setPdtMachineId(Long pdtMachineId) {
        this.pdtMachineId = pdtMachineId;
    }

    @Column(name = "pdt_machinecode", nullable = false)
    public String getPdtMachineCode() {
        return pdtMachineCode;
    }

    public void setPdtMachineCode(String pdtMachineCode) {
        this.pdtMachineCode = pdtMachineCode;
    }


    @Column(name = "prm_bandescription")
    public String getPdtMachineDescription() {
        return pdtMachineDescription;
    }

    public void setPdtMachineDescription(String description) {
        pdtMachineDescription = description;
    }

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "pdt_machinecreationdate")
    public Date getPdtMachineCreationDate() {
        return pdtMachineCreationDate;
    }

    public void setPdtMachineCreationDate(Date pdtMachineCreationDate) {
        this.pdtMachineCreationDate = pdtMachineCreationDate;
    }

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "pdt_machineupdatedate")
    public Date getPdtMachineUpdateDate() {
        return pdtMachineUpdateDate;
    }

    public void setPdtMachineUpdateDate(Date pdtMachineUpdateDate) {
        this.pdtMachineUpdateDate = pdtMachineUpdateDate;
    }

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "pdtMachine")

    public Set<PdtMachineProcess> getPdtMachineProcesses() {
        return pdtMachineProcesses;
    }

    public void setPdtMachineProcesses(Set<PdtMachineProcess> pdtMachineProcesses) {
        this.pdtMachineProcesses = pdtMachineProcesses;
    }
}
