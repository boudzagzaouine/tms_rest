package com.bagile.gmo.entities;

import com.bagile.gmo.dto.ConsumptionType;
import com.bagile.gmo.dto.ContractType;
import com.bagile.gmo.dto.Insurance;
import com.bagile.gmo.dto.Transport;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;


@Entity
@Table(name = "gmo_machine")
public class GmoMachine extends GmoPatrimony {

	private static final long serialVersionUID = 612360418697069780L;

	private long gmoMachineId;
    private String gmoRegistrationNumber;
    private String gmoMachineCode;
    private Insurance insurance;
    private ContractType contractType;
    private Date aquisitionDate;
    private BigDecimal amount;
    private ConsumptionType consumptionType;
    private Transport transport;




    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq")
    @SequenceGenerator(name = "seq", sequenceName = "seq_gmo_machine_id", allocationSize = 1)
    @Column(name = "gmo_machineid", unique = true, nullable = false, precision = 10, scale = 0)
    public long getGmoMachineId() {
        return gmoMachineId;
    }

    public void setGmoMachineId(long gmoMachineId) {
        this.gmoMachineId = gmoMachineId;
    }

    @Column(name = "gmo_machineregistrationnumber")
    public String getGmoRegistrationNumber() {
        return gmoRegistrationNumber;
    }

    public void setGmoRegistrationNumber(String gmoRegistrationNumber) {
        this.gmoRegistrationNumber = gmoRegistrationNumber;
    }

    @Column(name = "gmo_machinecode", unique = true, nullable = false, length = 90)
    public String getGmoMachineCode() {
        return gmoMachineCode;
    }

    public void setGmoMachineCode(String gmoMachineCode) {
        this.gmoMachineCode = gmoMachineCode;
    }

  
}
