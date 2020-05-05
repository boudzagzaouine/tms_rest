package com.bagile.gmo.mapper;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import com.bagile.gmo.dto.Vacation;
import com.bagile.gmo.entities.GmoVacation;

public class VacationMapper {
    private VacationMapper() {

    }

    private static Map<String, String> map;

    static {
        map = new HashMap<>();
        map.put("id", "gmoVacationId");
        map.put("startDate", "gmoVacationStartDate");
        map.put("endDate", "gmoVacationEndDate");
        map.put("vacationType", "gmoVacationType");
        map.put("driver", "gmoDriver");
        map.put("createdBy", "createdBy");
        map.put("updatedBy", "updatedBy");
        map.put("creationDate", "creationDate");
        map.put("updateDate", "updateDate");
    }

    public static Map<String, String> getMap() {
        return map;
    }

    public String getField(String key) {
        return map.get(key);
    }

    public static GmoVacation toEntity(Vacation vacation, boolean lazy) {
        if (null == vacation) {
            return null;
        }
        GmoVacation gmoVacation = new GmoVacation();
        gmoVacation.setGmoVacationId(vacation.getId());
        gmoVacation.setGmoVacationStartDate(vacation.getStartDate());
        gmoVacation.setGmoVacationEndDate(vacation.getEndDate());
        gmoVacation.setCreatedBy(vacation.getCreatedBy());
        gmoVacation.setUpdatedBy(vacation.getUpdatedBy());
        gmoVacation.setCreationDate(vacation.getCreationDate());
        gmoVacation.setUpdateDate(vacation.getUpdateDate());

        if (!lazy) {
            gmoVacation.setGmoVacationType(VacationTypeMapper.toEntity(vacation.getVacationtype(), true));
            gmoVacation.setGmoDriver(DriverMapper.toEntity(vacation.getDriver(), true));
        }
        return gmoVacation;
    }

    public static Vacation toDto(GmoVacation gmoVacation, boolean lazy) {
        if (null == gmoVacation) {
            return null;
        }
        Vacation vacation = new Vacation();

        vacation.setId(gmoVacation.getGmoVacationId());
        vacation.setStartDate(gmoVacation.getGmoVacationStartDate());
        vacation.setEndDate(gmoVacation.getGmoVacationEndDate());
        vacation.setCreatedBy(gmoVacation.getCreatedBy());
        vacation.setUpdatedBy(gmoVacation.getUpdatedBy());
        vacation.setCreationDate(gmoVacation.getCreationDate());
        vacation.setUpdateDate(gmoVacation.getUpdateDate());

        if (!lazy) {
            vacation.setDriver(DriverMapper.toDto(gmoVacation.getGmoDriver(), true));
            vacation.setVacationtype(VacationTypeMapper.toDto(gmoVacation.getGmoVacationType(), true));
        }
        return vacation;
    }

    public static List<Vacation> toDtos(Iterable<? extends GmoVacation> gmoVacations, boolean lazy) {
        if (null == gmoVacations) {
            return null;
        }
        List<Vacation> vacations = new ArrayList<>();
        for (GmoVacation gmoVacation : gmoVacations) {
            vacations.add(toDto(gmoVacation, lazy));
        }
        return vacations;
    }

    public static Set<GmoVacation> toEntities(Set<Vacation> vacations, boolean lazy) {
        if (null == vacations) {
            return null;
        }
        Set<GmoVacation> gmoVacations = new HashSet<>();
        for (Vacation vacation : vacations) {
            gmoVacations.add(toEntity(vacation, lazy));
        }
        return gmoVacations;
    }

    public static Set<Vacation> toDtos(Set<GmoVacation> gmoVacations, boolean lazy) {
        if (null == gmoVacations) {
            return null;
        }
        Set<Vacation> vacations = new HashSet<>();
        for (GmoVacation gmoVacation : gmoVacations) {
            vacations.add(toDto(gmoVacation, lazy));
        }
        return vacations;
    }

}