package com.bagile.tms.mapper;

import com.bagile.tms.dto.Vacation;
import com.bagile.tms.entities.TmsVacation;

import java.util.*;

public class VacationMapper {
    private VacationMapper() {

    }

    private static Map<String, String> map;

    static {
        map = new HashMap<>();
        map.put("id", "tmsVacationId");
        map.put("begin", "tmsVacationbegin");
        map.put("end", "tmsVacationend");
        map.put("vacationtype", "tmsVacationType");
        map.put("driver", "tmsdriver");
    }

    public static Map<String, String> getMap() {
        return map;
    }

    public String getField(String key) {
        return map.get(key);
    }

    public static TmsVacation toEntity(Vacation vacation, boolean lazy) {
        if (null == vacation) {
            return null;
        }
        TmsVacation tmsVacation = new TmsVacation();
        tmsVacation.setTmsVacationid(vacation.getId());
        tmsVacation.setTmsVacationbegin(vacation.getBegin());
        tmsVacation.setTmsVacationend(vacation.getEnd());

        if (!lazy) {
            tmsVacation.setTmsVacationType(VacationTypeMapper.toEntity(vacation.getVacationtype(), true));
            tmsVacation.setTmsdriver(DriverMapper.toEntity(vacation.getDriver(), true));
        }
        return tmsVacation;
    }

    public static Vacation toDto(TmsVacation tmsVacation, boolean lazy) {
        if (null == tmsVacation) {
            return null;
        }
        Vacation vacation = new Vacation();

        vacation.setId(tmsVacation.getTmsVacationid());
        vacation.setBegin(tmsVacation.getTmsVacationbegin());
        vacation.setEnd(tmsVacation.getTmsVacationend());
        if (!lazy) {
            vacation.setDriver(DriverMapper.toDto(tmsVacation.getTmsdriver(), true));
            vacation.setDriver(DriverMapper.toDto(tmsVacation.getTmsdriver(), true));
        }
        return vacation;
    }

    public static List<Vacation> toDtos(List<TmsVacation> tmsVacations, boolean lazy) {
        if (null == tmsVacations) {
            return null;
        }
        List<Vacation> vacations = new ArrayList<>();
        for (TmsVacation tmsVacation : tmsVacations) {
            vacations.add(toDto(tmsVacation, lazy));

        }
        return vacations;
    }

    public static List<Vacation> toDtos(Iterable<TmsVacation> tmsVacations, boolean lazy) {
        if (null == tmsVacations) {
            return null;
        }
        List<Vacation> vacations = new ArrayList<>();
        for (TmsVacation tmsVacation : tmsVacations) {
            vacations.add(toDto(tmsVacation, lazy));
        }
        return vacations;
    }

    public static Set<TmsVacation> toEntities(Set<Vacation> vacations, boolean lazy) {
        if (null == vacations) {
            return null;
        }
        Set<TmsVacation> tmsVacations = new HashSet<>();
        for (Vacation vacation : vacations) {
            tmsVacations.add(toEntity(vacation, lazy));
        }
        return tmsVacations;
    }

    public static Set<Vacation> toDtos(Set<TmsVacation> tmsVacations, boolean lazy) {
        if (null == tmsVacations) {
            return null;
        }
        Set<Vacation> vacations = new HashSet<>();
        for (TmsVacation tmsVacation : tmsVacations) {
            vacations.add(toDto(tmsVacation, lazy));
        }
        return vacations;
    }

}