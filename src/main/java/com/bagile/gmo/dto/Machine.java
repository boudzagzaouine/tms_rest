package com.bagile.gmo.dto;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import java.util.Objects;

public class Machine extends Patrimony implements Serializable {


    /**
     *
     */
    private static final long serialVersionUID = 6072929769333595397L;
   // private long id;
    //private String code;
      private String ref;
      private ContractType contractType;
      private ConsumptionType consumptionType;
      private Date aquisitionDate;
      private BigDecimal amount;
      private Transport transport;
      private Owner owner;
      private Machine resource;
      private String name;


    public Machine() {
    }

  /*  public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }
*/

  /*  public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

*/

    public String getRef() {
        return ref;
    }

    public void setRef(String ref) {
        this.ref = ref;
    }

    public Date getAquisitionDate() {
        return aquisitionDate;
    }

    public void setAquisitionDate(Date aquisitionDate) {
        this.aquisitionDate = aquisitionDate;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public Date getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(Date creationDate) {
        this.creationDate = creationDate;
    }

    public ContractType getContractType() {
        return contractType;
    }

    public void setContractType(ContractType contractType) {
        this.contractType = contractType;
    }


    public Owner getOwner() {
        return owner;
    }

    public void setOwner(Owner owner) {
        this.owner = owner;
    }

    public ConsumptionType getConsumptionType() {
        return consumptionType;
    }

    public void setConsumptionType(ConsumptionType consumptionType) {
        this.consumptionType = consumptionType;
    }


    public Transport getTransport() {
        return transport;
    }

    public void setTransport(Transport transport) {
        this.transport = transport;
    }

    public Machine getResource() {
        return resource;
    }

    public void setResource(Machine resource) {
        this.resource = resource;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Machine vehicle = (Machine) o;
        return getId() == vehicle.getId();
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId());
    }


}
