package com.bagile.gmo.dto;

import java.io.Serializable;
import java.util.Set;

public class Alias extends EmsDto implements Serializable {

    private static final long serialVersionUID = 3377528822520543137L;

    private long id;
    private Owner owner;
    private Set<ProductPack> productPacks;
    private Product product;
    private Uom uom;
    private String eanCode;
    private Boolean syncWms=false;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Owner getOwner() {
        return owner;
    }

    public void setOwner(Owner owner) {
        this.owner = owner;
    }


    public Set<ProductPack> getProductPacks() {
        return productPacks;
    }

    public void setProductPacks(Set<ProductPack> productPacks) {
        this.productPacks = productPacks;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public Uom getUom() {
        return uom;
    }

    public void setUom(Uom uom) {
        this.uom = uom;
    }

    public String getEanCode() {
        return eanCode;
    }

    public void setEanCode(String eanCode) {
        this.eanCode = eanCode;
    }

    public Boolean getSyncWms() {
        return syncWms;
    }

    public void setSyncWms(Boolean syncWms) {
        this.syncWms = syncWms;
    }

    @Override
    public boolean equals(Object object) {
        boolean result = false;
        if (object == null || object.getClass() != getClass()) {
            result = false;
        } else {
            Alias obj = (Alias) object;
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