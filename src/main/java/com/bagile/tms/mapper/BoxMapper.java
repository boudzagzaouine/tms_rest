package com.bagile.tms.mapper;

import java.util.*;

/**
 * Created by Adil on 3/1/2017.
 */
public class BoxMapper {
    private static Map<String, String> map;

    static {
        map = new HashMap<>();

        map.put("id", "usrBoxId");
        map.put("agency", "usrAgency");
        map.put("code", "usrBoxCode");
        map.put("description", "usrBoxDescription");
        map.put("balance", "usrBoxBalance");
        map.put("updateDate", "usrBoxUpdateDate");
        map.put("creationDate", "usrBoxCreationDate");

    }

    public static Map<String, String> getMap() {
        return map;
    }

    public static String getField(String key) {
        return map.get(key);
    }

    public static UsrBox toEntity(Box box, boolean lazy) {
        if (null == box) {
            return null;
        }
        UsrBox usrBox = new UsrBox();
        usrBox.setUsrBoxId(box.getId());
        usrBox.setUsrBoxCode(box.getCode() != null ? box.getCode().toUpperCase() : null);
        usrBox.setUsrBoxDescription(box.getDescription());
        usrBox.setUsrBoxCreationDate(box.getCreationDate());
        usrBox.setUsrBoxUpdateDate(box.getUpdateDate());
        if (!lazy) {
            usrBox.setUsrAgency(AgencyMapper.toEntity(box.getAgency(), true));
        }
        return usrBox;
    }

    public static Box toDto(UsrBox usrBox, boolean lazy) {
        if (null == usrBox) {
            return null;
        }
        Box box = new Box();
        box.setId(usrBox.getUsrBoxId());
        box.setCode(usrBox.getUsrBoxCode());
        box.setDescription(usrBox.getUsrBoxDescription());
        box.setCreationDate(usrBox.getUsrBoxCreationDate());
        box.setUpdateDate(usrBox.getUsrBoxUpdateDate());
        if (!lazy) {
            box.setAgency(AgencyMapper.toDto(usrBox.getUsrAgency(), true));
        }
        return box;

    }

    public static List<Box> toDtos(List<UsrBox> usrBoxs, boolean lazy) {
        if (null == usrBoxs) {
            return null;
        }
        List<Box> boxs = new ArrayList<>();
        for (UsrBox usrBox : usrBoxs) {
            boxs.add(toDto(usrBox, lazy));
        }
        return boxs;
    }

    public static List<Box> toDtos(Iterable<UsrBox> usrBoxs, boolean lazy) {
        if (null == usrBoxs) {
            return null;
        }
        List<Box> boxs = new ArrayList<>();
        for (UsrBox usrBox : usrBoxs) {
            boxs.add(toDto(usrBox, lazy));
        }
        return boxs;
    }

    public static Set<UsrBox> toEntities(Set<Box> boxs, boolean lazy) {
        if (null == boxs) {
            return null;
        }
        Set<UsrBox> usrBoxs = new HashSet<>();
        for (Box box : boxs) {
            usrBoxs.add(toEntity(box, lazy));
        }
        return usrBoxs;
    }

    public static Set<Box> toDtos(Set<UsrBox> usrBoxs, boolean lazy) {
        if (null == usrBoxs) {
            return null;
        }
        Set<Box> boxs = new HashSet<>();
        for (UsrBox usrBox : usrBoxs) {
            boxs.add(toDto(usrBox, lazy));
        }
        return boxs;
    }
}
