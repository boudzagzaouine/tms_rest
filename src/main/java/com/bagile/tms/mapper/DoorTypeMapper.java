package com.bagile.tms.mapper;

import com.bagile.tms.dto.DoorType;
import com.bagile.tms.entities.TmsDoorType;
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

    public static List<DoorType> toDtos(List<TmsDoorType> tmsDoorTypes, boolean lazy) {
        if (null == tmsDoorTypes) {
            return null;
        }
        List<DoorType> doorTypes = new ArrayList<>();
        for (TmsDoorType tmsDoorType : tmsDoorTypes) {
            doorTypes.add(toDto(tmsDoorType, lazy));
        }
        return doorTypes;
    }

    public static List<DoorType> toDtos(Iterable<TmsDoorType> TmsDoorTypes, boolean lazy) {
        if (null == TmsDoorTypes) {
            return null;
        }
        List<DoorType> doorTypes = new ArrayList<>();
        for (TmsDoorType tmsDoorType : TmsDoorTypes) {
            doorTypes.add(toDto(tmsDoorType, lazy));
        }
        return doorTypes;
    }

    public static Set<TmsDoorType> toEntities(Set<DoorType> doorTypes, boolean lazy) {
        if (null == doorTypes) {
            return null;
        }
        Set<TmsDoorType> TmsDoorTypes = new HashSet<>();
        for (DoorType doorType : doorTypes) {
            TmsDoorTypes.add(toEntity(doorType, lazy));
        }
        return TmsDoorTypes;
    }

    public static Set<DoorType> toDtos(Set<TmsDoorType> TmsDoorTypes, boolean lazy) {
        if (null == TmsDoorTypes) {
            return null;
        }
        Set<DoorType> doorTypess = new HashSet<>();
        for (TmsDoorType TmsDoorType : TmsDoorTypes) {
            doorTypess.add(toDto(TmsDoorType, lazy));
        }
        return doorTypess;
    }
}

