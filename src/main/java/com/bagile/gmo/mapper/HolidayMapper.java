package com.bagile.gmo.mapper;

import com.bagile.gmo.dto.Holiday;
import com.bagile.gmo.entities.TmsHoliday;

import java.util.*;

public class HolidayMapper {
    public HolidayMapper() {
    }

    private static Map<String, String> map;

    static {
        map = new HashMap<> ( );

        map.put ("id", "tmsHolidayId");
        map.put ("code", "tmsHolidayCode");
        map.put ("holidayDate", "tmsHolidayDate");
        map.put ("description", "tmsHolidayDescription");
        map.put ("holidayDay", "tmsHolidayDay");
        map.put ("holidayMonth", "tmsHolidayMonth");
        map.put ("creationDate", "creationDate");
        map.put ("updateDate", "updateDate");
        map.put ("createdBy", "createdBy");
        map.put ("updatedBy", "updatedBy");
    }

    public static Map<String, String> getMap() {
        return map;
    }

    public static String getField(String key) {
        return map.get (key);
    }

    public static TmsHoliday toEntity(Holiday holiday, boolean lazy) {
        if (null == holiday) {
            return null;
        }

        TmsHoliday tmsHoliday = new TmsHoliday( );
        tmsHoliday.setTmsHolidayId(holiday.getId ( ));
        tmsHoliday.setTmsHolidayCode(holiday.getCode ( ));
 
        tmsHoliday.setTmsHolidayDescription(holiday.getDescription ( ));
        tmsHoliday.setTmsHolidayDay(holiday.getHolidayDay ( ));
        tmsHoliday.setTmsHolidayMonth(holiday.getHolidayMonth ( ));
        tmsHoliday.setTmsHolidayDate(holiday.getHolidayDate ( ));

        tmsHoliday.setCreatedBy (holiday.getCreatedBy ( ));
        tmsHoliday.setUpdatedBy (holiday.getUpdatedBy ( ));

        if (!lazy) {
           // tmsHoliday.setCmdAccount (AccountMapper.toEntity (holiday.getAccount ( ), true));
        }

        return tmsHoliday;

    }

    public static Holiday toDto(TmsHoliday tmsHoliday, boolean lazy) {
        if (null == tmsHoliday) {
            return null;
        }
        Holiday holiday = new Holiday( );
        holiday.setId (tmsHoliday.getTmsHolidayId());
        holiday.setCode (tmsHoliday.getTmsHolidayCode());

        holiday.setDescription (tmsHoliday.getTmsHolidayDescription());
        holiday.setHolidayDay (tmsHoliday.getTmsHolidayDay());
        holiday.setHolidayMonth (tmsHoliday.getTmsHolidayMonth());

        holiday.setHolidayDate (tmsHoliday.getTmsHolidayDate());

        holiday.setCreatedBy (tmsHoliday.getCreatedBy ());
        holiday.setUpdatedBy (tmsHoliday.getUpdatedBy ());
        holiday.setCreationDate (tmsHoliday.getCreationDate ());
        holiday.setUpdateDate (tmsHoliday.getUpdateDate ());

        if (!lazy) {
           // holiday.setAccount (AccountMapper.toDto (tmsHoliday.getCmdAccount(), true));
        }
        return holiday;

    }


    public static List<Holiday> toDtos(Iterable<? extends TmsHoliday> tmsHolidays, boolean lazy) {
        if (null == tmsHolidays) {
            return null;
        }
        List<Holiday> vehicules = new ArrayList<> ( );

        for (TmsHoliday tmsHoliday : tmsHolidays) {
            vehicules.add (toDto (tmsHoliday, lazy));
        }
        return vehicules;
    }

    public static Set<TmsHoliday> toEntities(Set<Holiday> holidays, boolean lazy) {
        if (null == holidays) {
            return null;
        }
        Set<TmsHoliday> tmsHolidays = new HashSet<> ( );
        for (Holiday holiday : holidays) {
            tmsHolidays.add (toEntity (holiday, lazy));
        }
        return tmsHolidays;
    }

    public static Set<Holiday> toDtos(Set<TmsHoliday> tmsHolidays, boolean lazy) {
        if (null == tmsHolidays) {
            return null;
        }
        Set<Holiday> holidays = new HashSet<> ( );
        for (TmsHoliday tmsHoliday : tmsHolidays) {
            holidays.add (toDto (tmsHoliday, lazy));
        }
        return holidays;
    }
}
