package com.bagile.tms.mapper;

import com.bagile.tms.dto.DoorType;
import com.bagile.tms.entities.TmsDoorType;

import java.util.*;

public class DoorTypeMapper {
    private DoorTypeMapper() {

    }

    private static Map<String, String> map;

    static {
        map = new HashMap<>();
        map.put("id", "tmsDoorTypeId");
        map.put("side", "tmsDoorTypeSide");
        map.put("back", "tmsDoorTypeBack");
    }

    public static Map<String, String> getMap() {
        return map;
    }


    public static String getField(String key) {
        return map.get(key);
    }

    public static TmsDoorType toEntity(DoorType doorType, boolean lazy) {
        if (null == doorType) {
            return null;
        }
        TmsDoorType tmsDoorType = new TmsDoorType();

        tmsDoorType.setTmsDoorTypeId(doorType.getId());
        tmsDoorType.setTmsDoorTypeBack(doorType.isBack());
        tmsDoorType.setTmsDoorTypeSide(doorType.isSide());
        return tmsDoorType;
    }

    public static DoorType toDto(TmsDoorType tmsDoorType, boolean lazy) {
        if (null == tmsDoorType) {
            return null;
        }

        DoorType doorType = new DoorType();

        doorType.setId(tmsDoorType.getTmsDoorTypeId());
        doorType.setBack(tmsDoorType.getTmsDoorTypeBack());
        doorType.setSide(tmsDoorType.getTmsDoorTypeSide());

        return doorType;
    }
}

