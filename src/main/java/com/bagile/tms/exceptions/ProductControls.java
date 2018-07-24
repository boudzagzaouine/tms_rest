package com.bagile.tms.exceptions;

/**
 * Created by Enissay on 11/05/2016.
 */
public class ProductControls extends Exception {
    public ProductControls(String message){
        super(message+"  ne peut pas �tre nul");
    }
}
