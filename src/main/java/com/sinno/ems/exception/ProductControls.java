package com.sinno.ems.exception;

/**
 * Created by Enissay on 11/05/2016.
 */
public class ProductControls extends Exception {
    public ProductControls(String message){
        super(message+"  ne peut pas être nul");
    }
}
