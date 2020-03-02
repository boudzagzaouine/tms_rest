package com.bagile.tms.dto;

import java.io.Serializable;
import java.util.Date;
import java.util.Set;

public class ProductType  extends EmsDto implements Serializable {

    private static final long serialVersionUID = 1404056929988728822L;

    private long id;
    private Owner owner;
    private String code;
    private Date updateDate;
    private Date creationDate;
    private String description;
    private Vat vat;
    private byte[] image;
    private Set<ProductType> productTypes;
    private ProductType productType;
    private Set<Product> productsForProductType;
    private Set<Product> productsForProductSubType;

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

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public Date getUpdateDate() {
        return updateDate;
    }

    public void setUpdateDate(Date updateDate) {
        this.updateDate = updateDate;
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

    public Set<ProductType> getProductTypes() {
        return productTypes;
    }

    public void setProductTypes(Set<ProductType> productTypes) {
        this.productTypes = productTypes;
    }

    public ProductType getProductType() {
        return productType;
    }

    public void setProductType(ProductType productType) {
        this.productType = productType;
    }

    public Set<Product> getProductsForProductType() {
        return productsForProductType;
    }

    public void setProductsForProductType(Set<Product> productsForProductType) {
        this.productsForProductType = productsForProductType;
    }

    public Set<Product> getProductsForProductSubType() {
        return productsForProductSubType;
    }

    public void setProductsForProductSubType(Set<Product> productsForProductSubType) {
        this.productsForProductSubType = productsForProductSubType;
    }

    public Vat getVat() {
        return vat;
    }

    public void setVat(Vat vat) {
        this.vat = vat;
    }

    public byte[] getImage() {
        return image;
    }

    public void setImage(byte[] image) {
        this.image = image;
    }

    @Override
    public boolean equals(Object object) {
        boolean result = false;
        if (object == null || object.getClass() != getClass()) {
            result = false;
        } else {
            ProductType obj = (ProductType) object;
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