package com.sinno.ems.util;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by Enissay on 23/05/2016.
 */
public class EmsComprator {
    private EmsComprator() {
    }

    public static <T> boolean compare(T ob1, T ob2) {
        if (ob1 instanceof String || ob2 instanceof String) {
            if (null != ob2) {
                if ((null == ob1 && "".equals(ob2.toString().trim()))) {
                    return true;
                }
            }
            if (null != ob1) {
                if ((null == ob2 && "".equals(ob1.toString().trim()))) {
                    return true;
                }
            }
        }
        if (ob1 instanceof Date || ob2 instanceof Date) {
            if (null != ob2 && null != ob1) {
                SimpleDateFormat fmt = new SimpleDateFormat("yyyyMMdd");
                 return fmt.format(ob1).equals(fmt.format(ob2));
            }
        }


        if ((null == ob1 && null == ob2) || (ob1 != null && ob1.equals(ob2))) {
            return true;
        }
        return false;
    }

}
