package com.sinno.ems.util;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;

/**
 * Created by adadi on 2/15/2016.
 */
public class EmsClone {
    private EmsClone() {
    }

    public static <T> T clone(T objet, Class<T> responseType) throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        String json = mapper.writeValueAsString(objet);
        return mapper.readValue(json, responseType);
    }

}
