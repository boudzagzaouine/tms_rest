package com.bagile.tms.mapper;

import com.bagile.tms.dto.VacationType;

import com.bagile.tms.entities.TmsVacationType;

import java.util.*;
public class VacationTypeMapper {

    public VacationTypeMapper() {
    }


    private static Map<String, String> map;

    static {
        map = new HashMap<>();
        map.put("id", "tmsVacationId");
        map.put("type", "tmsVacationbegin");
    }
    public static Map<String, String> getMap() {
        return map;
    }

    public String getField(String key) {
        return map.get(key);
    }

    public static TmsVacationType toEntity(VacationType vacationtype, boolean lazy) {
        if (null == vacationtype) {
            return null;
        }
        TmsVacationType tmsVacationtype = new TmsVacationType();
        tmsVacationtype.setId(vacationtype.getId());
        tmsVacationtype.setType(vacationtype.getType());

        if (!lazy) {
           // tmsVacation.setTmsDriver(DriverMapper.toEntity(vacation.getDriver(), true));
        }
        return tmsVacationtype;
    }

    public static VacationType toDto(TmsVacationType tmsVacationtype, boolean lazy) {
        if (null == tmsVacationtype) {
            return null;
        }
        VacationType vacationtype = new VacationType();

        vacationtype.setId(tmsVacationtype.getId());
        vacationtype.setType(tmsVacationtype.getType());

        if (!lazy) {

        }
        return vacationtype;
    }

    public static List<VacationType> toDtos(List<TmsVacationType> tmsVacationstype, boolean lazy) {
        if (null == tmsVacationstype) {
            return null;
        }
        List<VacationType> vacationstype = new ArrayList<>();
        for (TmsVacationType tmsVacationtype : tmsVacationstype) {
            vacationstype.add(toDto(tmsVacationtype, lazy));

        }
        return vacationstype;
    }

    public static List<VacationType> toDtos(Iterable<TmsVacationType> tmsVacationsType, boolean lazy) {
        if (null == tmsVacationsType) {
            return null;
        }
        List<VacationType> vacationstype = new ArrayList<>();
        for (TmsVacationType tmsVacationtype : tmsVacationsType) {
            vacationstype.add(toDto(tmsVacationtype, lazy));
        }
        return vacationstype;
    }

    public static Set<TmsVacationType> toEntities(Set<VacationType> vacationsType, boolean lazy) {
        if (null == vacationsType) {
            return null;
        }
        Set<TmsVacationType> tmsVacationstype = new HashSet<>();
        for (VacationType vacationtype : vacationsType) {
            tmsVacationstype.add(toEntity(vacationtype, lazy));
        }
        return tmsVacationstype;
    }

    public static Set<VacationType> toDtos(Set<TmsVacationType> tmsVacationsType, boolean lazy) {
        if (null == tmsVacationsType) {
            return null;
        }
        Set<VacationType> vacationsType = new HashSet<>();
        for (TmsVacationType tmsVacation : tmsVacationsType) {
            vacationsType.add(toDto(tmsVacation, lazy));
        }
        return vacationsType;
    }

}
