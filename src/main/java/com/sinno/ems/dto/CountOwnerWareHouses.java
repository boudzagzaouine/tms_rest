package com.sinno.ems.dto;

/**
 * Created by Enissay on 14/04/2016.
 */
public class CountOwnerWareHouses {
    private String ownerCode;
    private String count;

    public CountOwnerWareHouses() {
    }

    public CountOwnerWareHouses(String ownerCode, String count) {
        this.ownerCode = ownerCode;
        this.count = count;
    }

    public String getOwnerCode() {
        return ownerCode;
    }

    public void setOwnerCode(String ownerCode) {
        this.ownerCode = ownerCode;
    }

    public String getCount() {
        return count;
    }

    public void setCount(String count) {
        this.count = count;
    }


}
