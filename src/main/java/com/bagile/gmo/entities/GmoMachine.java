package com.bagile.gmo.entities;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;

@Entity
@Table(name = "gmo_machine")
@DiscriminatorValue("machine")
public class GmoMachine extends GmoPatrimony {

	private static final long serialVersionUID = 612360418697069780L;

   // private String gmoPatrimonyCode;
    private GmoContractType gmoContractType;
    private GmoConsumptionType gmoConsumptionType;
    private Date gmoMachineAquisitionDate;
    private BigDecimal gmoMachineAamount;
    private TrpTransport trpTransport;


   /* @Column(name = "gmo_machinecode", unique = true, nullable = false, length = 90)
    public String getGmoPatrimonyCode() {
        return gmoPatrimonyCode;
    }

    public void setGmoPatrimonyCode(String gmoMachineCode) {
        this.gmoPatrimonyCode = gmoMachineCode;
    }
*/


    @Column(name = "gmo_machineaquisitiondate")
    public Date getGmoMachineAquisitionDate() {
        return gmoMachineAquisitionDate;
    }

    public void setGmoMachineAquisitionDate(Date gmoMachineAquisitionDate) {
        this.gmoMachineAquisitionDate = gmoMachineAquisitionDate;
    }

    @Column(name = "gmo_machineamount")
    public BigDecimal getGmoMachineAamount() {
        return gmoMachineAamount;
    }

    public void setGmoMachineAamount(BigDecimal gmoMachineAamount) {
        this.gmoMachineAamount = gmoMachineAamount;
    }


    @ManyToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name = "gmo_contracttypeid")
    public GmoContractType getGmoContractType() {
        return gmoContractType;
    }

    public void setGmoContractType(GmoContractType gmoContractType) {
        this.gmoContractType = gmoContractType;
    }

    @ManyToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name = "gmo_conummptiontypeid")
    public GmoConsumptionType getGmoConsumptionType() {
        return gmoConsumptionType;
    }

    public void setGmoConsumptionType(GmoConsumptionType gmoConsumptionType) {
        this.gmoConsumptionType = gmoConsumptionType;
    }

    @ManyToOne()
    @JoinColumn(name = "trp_transportid")
    public TrpTransport getTrpTransport() {
        return trpTransport;
    }

    public void setTrpTransport(TrpTransport trpTransport) {
        this.trpTransport = trpTransport;
    }


 }
