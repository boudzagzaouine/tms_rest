package com.bagile.tms.dto;

import java.io.Serializable;

public class Warehouse extends EmsDto implements Serializable {

    /**
     *
     */
    private static final long serialVersionUID = -5756625495799597845L;

    private long id;
    private String code;

   // private Address address;
    private String description;

    private String telephone;
    private Boolean active;
    private String email;


    public long getId() {
        return this.id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getCode() {
        return this.code;
    }

    public void setCode(String code) {
        this.code = code;
    }


   /* public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }*/

    /**
     * @return the description
     */
    public String getDescription() {
        return description;
    }

    /**
     * @param description the description to set
     */
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * @return the creationDate
     */




    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public Boolean getActive() {
        return active;
    }

    public void setActive(Boolean active) {
        this.active = active;
    }

//    public Set<ZoneWarehouse> getZoneWarehouses() {
    //    return zoneWarehouses;
  //  }

 //   public void setZoneWarehouses(Set<ZoneWarehouse> zoneWarehouses) {
    //    this.zoneWarehouses = zoneWarehouses;
  //  }



    @Override
    public boolean equals(Object object) {
        boolean result = false;
        if (object == null || object.getClass() != getClass()) {
            result = false;
        } else {
            Warehouse obj = (Warehouse) object;
            if (this.id == obj.getId()) {
                result = true;
            }
        }
        return result;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 7 * hash + (int) this.id;
        hash = 7 * hash + (int) this.id;
        return hash;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getEmail() {
        return email;
    }
}