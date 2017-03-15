package com.sinno.ems.util;

import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;

/**
 * Created by adadi on 2/10/2016.
 */
public class EmsDate {
    private EmsDate() {
    }

    public static Date getDateNow() {
        Date in = new Date();
        LocalDateTime ldt = LocalDateTime.ofInstant(in.toInstant(), ZoneId.systemDefault());
        return Date.from(ldt.atZone(ZoneId.systemDefault()).toInstant());

    }


    public static String getDateconcatenated() {

        SimpleDateFormat simpleDateFormat =
                new SimpleDateFormat("yyyyMMddhhmmss");
        String dateAsString = simpleDateFormat.format(new Date());

        return dateAsString;
    }


}
