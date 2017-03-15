package com.sinno.ems.util;

/**
 * Created by adadi on 6/7/2016.
 */
public class Capital {
    private Capital() {
    }

    public static String toCapital(String str) {
        return str.substring(0, 1).toUpperCase() + str.substring(1);
    }

}
