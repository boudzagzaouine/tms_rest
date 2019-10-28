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
        map.put("startDate", "tmsVacationStartDate");
        map.put("endDate", "tmsVacationEndDate");
        map.put("vacationType", "tmsVacationType");
        map.put("driver", "tmsDriver");
        map.put("createdBy", "createdBy");
        map.put("updatedBy", "updatedBy");
        map.put("creationDate", "creationDate");
        map.put("updateDate","updateDate");
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
        tmsVacation.setTmsVacationId(vacation.getId());
        tmsVacation.setTmsVacationStartDate(vacation.getStartDate());
        tmsVacation.setTmsVacationEndDate(vacation.getEndDate());
        tmsVacation.setCreatedBy(vacation.getCreatedBy());
        tmsVacation.setUpdatedBy(vacation.getUpdatedBy());
        tmsVacation.setCreationDate(vacation.getCreationDate());
        tmsVacation.setUpdateDate(vacation.getUpdateDate());

        if (!lazy) {
            tmsVacation.setTmsVacationType(VacationTypeMapper.toEntity(vacation.getVacationtype(), true));
            tmsVacation.setTmsDriver(DriverMapper.toEntity(vacation.getDriver(), true));
        }
        return tmsVacation;
    }

    public static Vacation toDto(TmsVacation tmsVacation, boolean lazy) {
        if (null == tmsVacation) {
            return null;
        }
        Vacation vacation = new Vacation();

        vacation.setId(tmsVacation.getTmsVacationId());
        vacation.setStartDate(tmsVacation.getTmsVacationStartDate());
        vacation.setEndDate(tmsVacation.getTmsVacationEndDate());
        vacation.setCreatedBy(tmsVacation.getCreatedBy());
        vacation.setUpdatedBy(tmsVacation.getUpdatedBy());
        vacation.setCreationDate(tmsVacation.getCreationDate());
        vacation.setUpdateDate(tmsVacation.getUpdateDate());

        if (!lazy) {
            vacation.setDriver(DriverMapper.toDto(tmsVacation.getTmsDriver(), true));
            vacation.setDriver(DriverMapper.toDto(tmsVacation.getTmsDriver(), true));
        }
        return vacation;
    }

    public static List<Vacation> toDtos(Iterable<? extends TmsVacation> tmsVacations, boolean lazy) {
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