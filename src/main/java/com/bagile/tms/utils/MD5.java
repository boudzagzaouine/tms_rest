package com.bagile.tms.utils;

import org.apache.tomcat.util.security.MD5Encoder;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class MD5 {
    private MD5() {
    }

    public static String toMD5(String val) {
        MessageDigest digest;
        try {
            digest = MessageDigest.getInstance("MD5");
        } catch (NoSuchAlgorithmException e) {
            throw new IllegalStateException("No MD5 algorithm available!");
        }
        return MD5Encoder.encode(digest.digest(val
                .getBytes()));
    }
}
