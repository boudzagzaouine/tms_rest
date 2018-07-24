package com.sinno.ems.dto;

import java.io.Serializable;
import java.util.Set;

public class Image implements Serializable {

    /**
     *
     */
    private static final long serialVersionUID = -8106311533352683811L;

    private long id;
    private String code;
    private String description;
    private byte[] bytes;
    private Product product;

    public long getId() {
        return this.id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public byte[] getBytes() {
        return bytes;
    }

    public void setBytes(byte[] bytes) {
        this.bytes = bytes;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }


}