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
    private String gmoMachineRef;
    private GmoContractType gmoContractType;
    private GmoConsumptionType gmoConsumptionType;
    private Date gmoMachineAquisitionDate;
    private BigDecimal gmoMachineAamount;
    private TrpTransport trpTransport;

    private OwnOwner ownOwner;
    private GmoMachine gmoResource;

    private String gmoMachineName ;
   /* @Column(name = "gmo_machinecode", unique = true, nullable = false, length = 90)
    public String getGmoPatrimonyCode() {
        return gmoPatrimonyCode;
    }

    public void setGmoPatrimonyCode(String gmoMachineCode) {
        this.gmoPatrimonyCode = gmoMachineCode;
    }
*/

   @Column(name = "gmo_machineref")
    public String getGmoMachineRef() {
        return gmoMachineRef;
    }

    public void setGmoMachineRef(String gmoMachineRef) {
        this.gmoMachineRef = gmoMachineRef;
    }



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

    @Column(name = "gmo_machinename")
    public String getGmoMachineName() {
        return gmoMachineName;
    }

    public void setGmoMachineName(String gmoMachineName) {
        this.gmoMachineName = gmoMachineName;
    }

    @ManyToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name = "gmo_contracttypeid")
    public GmoContractType getGmoContractType() {
        return gmoContractType;
    }

    public void setGmoContractType(GmoContractType gmoContractType) {
        this.gmoContractType = gmoContractType;
    }


    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "gmo_ressource")
    public GmoMachine getGmoResource() {
        return gmoResource;
    }

    public void setGmoResource(GmoMachine gmoResource) {
        this.gmoResource = gmoResource;
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


    @ManyToOne()
    @JoinColumn(name="gmo_ownerowner")
    public OwnOwner getOwnOwner() {
        return ownOwner;
    }

    public void setOwnOwner(OwnOwner ownOwner) {
        this.ownOwner = ownOwner;
    }
}
