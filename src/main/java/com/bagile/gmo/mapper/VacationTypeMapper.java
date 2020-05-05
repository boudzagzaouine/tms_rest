package com.bagile.gmo.mapper;

import com.bagile.gmo.dto.VacationType;
import com.bagile.gmo.entities.TmsVacationType;

import java.util.*;
public class VacationTypeMapper {

    public VacationTypeMapper() {
    }


    private static Map<String, String> map;

    static {
        map = new HashMap<>();
        map.put("id", "tmsVacationId");
        map.put("code", "tmsVacationTypeCode");
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

    public static TmsVacationType toEntity(VacationType vacationtype, boolean lazy) {
        if (null == vacationtype) {
            return null;
        }
        TmsVacationType tmsVacationtype = new TmsVacationType();
        tmsVacationtype.setTmsVacationTypeId(vacationtype.getId());
        tmsVacationtype.setTmsVacationTypeCode(vacationtype.getCode());
        tmsVacationtype.setTmsVacationDescription(vacationtype.getDescription());
        tmsVacationtype.setCreatedBy(vacationtype.getCreatedBy());
        tmsVacationtype.setUpdatedBy(vacationtype.getUpdatedBy());
        tmsVacationtype.setCreationDate(vacationtype.getCreationDate());
        tmsVacationtype.setUpdateDate(vacationtype.getUpdateDate());

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

        vacationtype.setId(tmsVacationtype.getTmsVacationTypeId());
        vacationtype.setCode(tmsVacationtype.getTmsVacationTypeCode());
        vacationtype.setDescription(tmsVacationtype.getTmsVacationDescription());
        vacationtype.setCreatedBy(tmsVacationtype.getCreatedBy());
        vacationtype.setUpdatedBy(tmsVacationtype.getUpdatedBy());
        vacationtype.setCreationDate(tmsVacationtype.getCreationDate());
        vacationtype.setUpdateDate(tmsVacationtype.getUpdateDate());

        if (!lazy) {

        }
        return vacationtype;
    }


    public static List<VacationType> toDtos(Iterable<? extends TmsVacationType> tmsVacationsType, boolean lazy) {
        if (null == tmsVacationsType) {
            return null;
        }
        List<VacationType> vacationTypes = new ArrayList<>();
        for (TmsVacationType tmsVacationtype : tmsVacationsType) {
            vacationTypes.add(toDto(tmsVacationtype, lazy));
        }
        return vacationTypes;
    }

    public static Set<TmsVacationType> toEntities(Set<VacationType> vacationsType, boolean lazy) {
        if (null == vacationsType) {
            return null;
        }
        Set<TmsVacationType> tmsVacationTypes = new HashSet<>();

        for (VacationType vacationtype : vacationsType) {
            tmsVacationTypes.add(toEntity(vacationtype, lazy));
        }
        return tmsVacationTypes;
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
