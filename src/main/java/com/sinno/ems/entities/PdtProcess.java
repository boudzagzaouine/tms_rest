package com.sinno.ems.entities;

import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "pdt_process", uniqueConstraints = {
        @UniqueConstraint(columnNames = {"pdt_processcode"})})
public class PdtProcess implements Serializable {
    private Long pdtProcessId;
    @Size(max = 30)
    private String pdtProcessCode;
    @Size(max = 255)
    private String pdtProcessDescription;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date pdtProcessCreationDate;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date pdtProcessUpdateDate;
    private Set<PdtMachineProcess> pdtMachineProcesses = new HashSet<PdtMachineProcess>(0);


    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq")
    @SequenceGenerator(name = "seq", sequenceName = "seq_pdt_process", allocationSize = 1)
    @Column(name = "pdt_processid", unique = true, nullable = false, precision = 10, scale = 0)
    public Long getPdtProcessId() {
        return pdtProcessId;
    }

    public void setPdtProcessId(Long pdtProcessId) {
        this.pdtProcessId = pdtProcessId;
    }

    @Column(name = "pdt_processcode", nullable = false)
    public String getPdtProcessCode() {
        return pdtProcessCode;
    }

    public void setPdtProcessCode(String pdtProcessCode) {
        this.pdtProcessCode = pdtProcessCode;
    }


    @Column(name = "prm_bandescription")
    public String getPdtProcessDescription() {
        return pdtProcessDescription;
    }

    public void setPdtProcessDescription(String description) {
        pdtProcessDescription = description;
    }

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "pdt_processcreationdate")
    public Date getPdtProcessCreationDate() {
        return pdtProcessCreationDate;
    }

    public void setPdtProcessCreationDate(Date pdtProcessCreationDate) {
        this.pdtProcessCreationDate = pdtProcessCreationDate;
    }

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "pdt_processupdatedate")
    public Date getPdtProcessUpdateDate() {
        return pdtProcessUpdateDate;
    }

    public void setPdtProcessUpdateDate(Date pdtProcessUpdateDate) {
        this.pdtProcessUpdateDate = pdtProcessUpdateDate;
    }

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "pdtProcess",orphanRemoval = true,cascade = CascadeType.ALL)

    public Set<PdtMachineProcess> getPdtMachineProcesses() {
        return pdtMachineProcesses;
    }

    public void setPdtMachineProcesses(Set<PdtMachineProcess> pdtMachineProcesses) {
        this.pdtMachineProcesses = pdtMachineProcesses;
    }
}
