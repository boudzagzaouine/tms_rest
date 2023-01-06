package com.bagile.gmo.dto;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.*;

public class Transport  extends EmsDto implements Serializable {

    /**
     *
     */
    private static final long serialVersionUID = 5628117098576510121L;

    private long id;
    private String comment;
    private String code;
    private String name;
    private String variable1;
    private String variable2;
    private String variable3;
    private String variable4;
    private String variable5;
    private String variable6;
    private String variable7;
    private String variable8;
    private String variable9;
    private String variable10;
    private BigDecimal siret;
    private String description;
    private Address address;
    private Contact contact;
    private Boolean active;
    private Boolean gmao;
    private Boolean interneOrExterne;

    private List<CatalogTransportPricing> catalogTransportPricings = new ArrayList<>();
    private List<CatalogTransportAccountPricing> catalogTransportAccountPricings = new ArrayList<>();

    private Owner owner;

    private List<TransportCategoryVehicle> transportCategorieVehicules=new ArrayList<>();
    private List<TransportProduct> transportProducts= new ArrayList<>();

    private List<Turn> turns=new ArrayList<>();


    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public List<TransportProduct> getTransportProducts() {
        return transportProducts;
    }

    public void setTransportProducts(List<TransportProduct> transportProducts) {
        this.transportProducts = transportProducts;
    }

    public List<CatalogTransportPricing> getCatalogTransportPricings() {
        return catalogTransportPricings;
    }

    public void setCatalogTransportPricings(List<CatalogTransportPricing> catalogTransportPricings) {
        this.catalogTransportPricings = catalogTransportPricings;
    }

    public List<CatalogTransportAccountPricing> getCatalogTransportAccountPricings() {
        return catalogTransportAccountPricings;
    }

    public void setCatalogTransportAccountPricings(List<CatalogTransportAccountPricing> catalogTransportAccountPricings) {
        this.catalogTransportAccountPricings = catalogTransportAccountPricings;
    }

    public Contact getContact() {
        return contact;
    }

    public void setContact(Contact contact) {
        this.contact = contact;
    }

    public Date getUpdateDate() {
        return updateDate;
    }

    public void setUpdateDate(Date updateDate) {
        this.updateDate = updateDate;
    }

    public String getVariable1() {
        return variable1;
    }

    public void setVariable1(String variable1) {
        this.variable1 = variable1;
    }

    public String getVariable2() {
        return variable2;
    }

    public void setVariable2(String variable2) {
        this.variable2 = variable2;
    }

    public String getVariable3() {
        return variable3;
    }

    public void setVariable3(String variable3) {
        this.variable3 = variable3;
    }

    public String getVariable4() {
        return variable4;
    }

    public void setVariable4(String variable4) {
        this.variable4 = variable4;
    }

    public String getVariable5() {
        return variable5;
    }

    public void setVariable5(String variable5) {
        this.variable5 = variable5;
    }

    public String getVariable6() {
        return variable6;
    }

    public void setVariable6(String variable6) {
        this.variable6 = variable6;
    }

    public String getVariable7() {
        return variable7;
    }

    public void setVariable7(String variable7) {
        this.variable7 = variable7;
    }

    public String getVariable8() {
        return variable8;
    }

    public void setVariable8(String variable8) {
        this.variable8 = variable8;
    }


    public String getVariable9() {
        return variable9;
    }

    public void setVariable9(String variable9) {
        this.variable9 = variable9;
    }

    public String getVariable10() {
        return variable10;
    }

    public void setVariable10(String variable10) {
        this.variable10 = variable10;
    }


    public Boolean getGmao() {
        return gmao;
    }

    public void setGmao(Boolean gmao) {
        this.gmao = gmao;
    }

    public Owner getOwner() {
        return owner;
    }

    public void setOwner(Owner owner) {
        this.owner = owner;
    }

    public Boolean getInterneOrExterne() {
        return interneOrExterne;
    }

    public void setInterneOrExterne(Boolean interneOrExterne) {
        this.interneOrExterne = interneOrExterne;
    }

    public BigDecimal getSiret() {
        return siret;
    }

    public void setSiret(BigDecimal siret) {
        this.siret = siret;
    }

    public Date getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(Date creationDate) {
        this.creationDate = creationDate;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }





    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }


    public void setActive(Boolean active) {
        this.active = active;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Boolean getActive() {
        return active;
    }

    public List<TransportCategoryVehicle> getTransportCategorieVehicules() {
        return transportCategorieVehicules;
    }

    public void setTransportCategorieVehicules(List<TransportCategoryVehicle> transportCategorieVehicules) {
        this.transportCategorieVehicules = transportCategorieVehicules;
    }


    public List<Turn> getTurns() {
        return turns;
    }

    public void setTurns(List<Turn> turns) {
        this.turns = turns;
    }

    @Override
    public boolean equals(Object object) {
        boolean result = false;
        if (object == null || object.getClass() != getClass()) {
            result = false;
        } else {
            Transport obj = (Transport) object;
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
}