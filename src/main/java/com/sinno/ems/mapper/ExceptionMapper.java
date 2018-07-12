/**
 *
 */
package com.sinno.ems.mapper;

import java.util.*;

/**
 * @author aelguezzar
 */
public class ExceptionMapper {
    private ExceptionMapper(){

    }

    private static Map<String, String> map;

    static {
        map = new HashMap<>();
        map.put("id", "stkExceptionId");
        map.put("name", "stkExceptionName");
        map.put("description","stkExceptionDescription");

    }

    public static Map<String, String> getMap() {
        return map;
    }

    public static String getField(String key) {
        return map.get(key);
    }

    public static Exception toDto(StkException stkException, boolean lazy) {
        if (null == stkException) {
            return null;
        }
        Exception exception = new Exception();
        exception.setId(stkException.getStkExceptionId());
        exception.setName(stkException.getStkExceptionName());
        exception.setDescription(stkException.getStkExceptionDescription());
        return exception;
    }

    public static StkException toEntity(Exception exception, boolean lazy) {
        if (null == exception) {
            return null;
        }
        StkException stkException = new StkException();
        stkException.setStkExceptionId(exception.getId());
        stkException.setStkExceptionName(exception.getName());
        stkException.setStkExceptionDescription(exception.getDescription());
        return stkException;
    }

    public static List<Exception> toDtos(List<StkException> stkExceptions, boolean lazy) {
        if (null == stkExceptions) {
            return null;
        }
        List<Exception> exceptions = new ArrayList<>();
        for (StkException stkException : stkExceptions) {
            exceptions.add(toDto(stkException, lazy));
        }
        return exceptions;
    }

    public static List<Exception> toDtos(Iterable<StkException> stkExceptions, boolean lazy) {
        if (null == stkExceptions) {
            return null;
        }
        List<Exception> exceptions = new ArrayList<>();
        for (StkException stkException : stkExceptions) {
            exceptions.add(toDto(stkException, lazy));
        }
        return exceptions;
    }

    public static Set<StkException> toEntities(Set<Exception> exceptions, boolean lazy) {
        if (null == exceptions) {
            return null;
        }
        Set<StkException> stkExceptions = new HashSet<>();
        for (Exception exception : exceptions) {
            stkExceptions.add(toEntity(exception, lazy));
        }
        return stkExceptions;
    }

    public static Set<Exception> toDtos(Set<StkException> stkExceptions, boolean lazy) {
        if (null == stkExceptions) {
            return null;
        }
        Set<Exception> exceptions = new HashSet<>();
        for (StkException stkException : stkExceptions) {
            exceptions.add(toDto(stkException, lazy));
        }
        return exceptions;
    }
}
