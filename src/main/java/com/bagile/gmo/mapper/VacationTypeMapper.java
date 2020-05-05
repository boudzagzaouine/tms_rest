package com.bagile.gmo.mapper;

import com.bagile.gmo.dto.VacationType;
import com.bagile.gmo.entities.GmoVacationType;

import java.util.*;
public class VacationTypeMapper {

    public VacationTypeMapper() {
    }


    private static Map<String, String> map;

    static {
        map = new HashMap<>();
        map.put("id", "gmoVacationId");
        map.put("code", "gmoVacationTypeCode");
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

    public static GmoVacationType toEntity(VacationType vacationtype, boolean lazy) {
        if (null == vacationtype) {
            return null;
        }
        GmoVacationType gmoVacationtype = new GmoVacationType();
        gmoVacationtype.setGmoVacationTypeId(vacationtype.getId());
        gmoVacationtype.setGmoVacationTypeCode(vacationtype.getCode());
        gmoVacationtype.setGmoVacationDescription(vacationtype.getDescription());
        gmoVacationtype.setCreatedBy(vacationtype.getCreatedBy());
        gmoVacationtype.setUpdatedBy(vacationtype.getUpdatedBy());
        gmoVacationtype.setCreationDate(vacationtype.getCreationDate());
        gmoVacationtype.setUpdateDate(vacationtype.getUpdateDate());

        if (!lazy) {
           // gmoVacation.setGmoDriver(DriverMapper.toEntity(vacation.getDriver(), true));
        }
        return gmoVacationtype;
    }

    public static VacationType toDto(GmoVacationType gmoVacationtype, boolean lazy) {
        if (null == gmoVacationtype) {
            return null;
        }
        VacationType vacationtype = new VacationType();

        vacationtype.setId(gmoVacationtype.getGmoVacationTypeId());
        vacationtype.setCode(gmoVacationtype.getGmoVacationTypeCode());
        vacationtype.setDescription(gmoVacationtype.getGmoVacationDescription());
        vacationtype.setCreatedBy(gmoVacationtype.getCreatedBy());
        vacationtype.setUpdatedBy(gmoVacationtype.getUpdatedBy());
        vacationtype.setCreationDate(gmoVacationtype.getCreationDate());
        vacationtype.setUpdateDate(gmoVacationtype.getUpdateDate());

        if (!lazy) {

        }
        return vacationtype;
    }


    public static List<VacationType> toDtos(Iterable<? extends GmoVacationType> gmoVacationsType, boolean lazy) {
        if (null == gmoVacationsType) {
            return null;
        }
        List<VacationType> vacationTypes = new ArrayList<>();
        for (GmoVacationType gmoVacationtype : gmoVacationsType) {
            vacationTypes.add(toDto(gmoVacationtype, lazy));
        }
        return vacationTypes;
    }

    public static Set<GmoVacationType> toEntities(Set<VacationType> vacationsType, boolean lazy) {
        if (null == vacationsType) {
            return null;
        }
        Set<GmoVacationType> gmoVacationTypes = new HashSet<>();

        for (VacationType vacationtype : vacationsType) {
            gmoVacationTypes.add(toEntity(vacationtype, lazy));
        }
        return gmoVacationTypes;
    }

    public static Set<VacationType> toDtos(Set<GmoVacationType> gmoVacationsType, boolean lazy) {
        if (null == gmoVacationsType) {
            return null;
        }
        Set<VacationType> vacationsType = new HashSet<>();
        for (GmoVacationType gmoVacation : gmoVacationsType) {
            vacationsType.add(toDto(gmoVacation, lazy));
        }
        return vacationsType;
    }

}
