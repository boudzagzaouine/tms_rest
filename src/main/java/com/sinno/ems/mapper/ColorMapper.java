package com.sinno.ems.mapper;

import com.sinno.ems.dto.Color;
import com.sinno.ems.entities.TmsColor;

import java.util.*;

public class ColorMapper {
    private ColorMapper() {

    }

    private static Map<String, String> map;

    static {
        map = new HashMap<>();

        map.put("id", "prmColorId");
        map.put("owner", "ownOwner");
        map.put("code", "prmColorCode");
        map.put("description", "prmColorDescription");
        map.put("updateDate", "prmColorUpdateDate");
        map.put("creationDate", "prmColorCreationDate");

    }
    public static Map<String, String> getMap() {
        return map;
    }


    public static String getField(String key) {
        return map.get(key);
    }

    public static TmsColor toEntity(Color color, boolean lazy) {
        if (null == color) {
            return null;
        }
        TmsColor tmsColor = new TmsColor();
        tmsColor.setPrmColorId(color.getId());
        tmsColor.setPrmColorCode(color.getCode() != null ? color.getCode().toUpperCase() : null);
        tmsColor.setPrmColorDescription(color.getDescription());
        tmsColor.setPrmColorCreationDate(color.getCreationDate());
        tmsColor.setPrmColorUpdateDate(color.getUpdateDate());
        if (!lazy) {
            tmsColor.setOwnOwner(OwnerMapper.toEntity(color.getOwner(), true));
//
        }
        return tmsColor;
    }

    public static Color toDto(TmsColor tmsColor, boolean lazy) {
        if (null == tmsColor) {
            return null;
        }
        Color color = new Color();
        color.setId(tmsColor.getPrmColorId());
        color.setCode(tmsColor.getPrmColorCode());
        color.setDescription(tmsColor.getPrmColorDescription());
        color.setCreationDate(tmsColor.getPrmColorCreationDate());
        color.setUpdateDate(tmsColor.getPrmColorUpdateDate());
        if (!lazy) {
            color.setOwner(OwnerMapper.toDto(tmsColor.getOwnOwner(), true));
        }
        return color;

    }

    public static List<Color> toDtos(List<TmsColor> tmsColors, boolean lazy) {
        if (null == tmsColors) {
            return null;
        }
        List<Color> colors = new ArrayList<>();
        for (TmsColor tmsColor : tmsColors) {
            colors.add(toDto(tmsColor, lazy));
        }
        return colors;
    }

    public static List<Color> toDtos(Iterable<TmsColor> prmColors, boolean lazy) {
        if (null == prmColors) {
            return null;
        }
        List<Color> colors = new ArrayList<>();
        for (TmsColor tmsColor : prmColors) {
            colors.add(toDto(tmsColor, lazy));
        }
        return colors;
    }

    public static Set<TmsColor> toEntities(Set<Color> colors, boolean lazy) {
        if (null == colors) {
            return null;
        }
        Set<TmsColor> tmsColors = new HashSet<>();
        for (Color color : colors) {
            tmsColors.add(toEntity(color, lazy));
        }
        return tmsColors;
    }

    public static Set<Color> toDtos(Set<TmsColor> tmsColors, boolean lazy) {
        if (null == tmsColors) {
            return null;
        }
        Set<Color> colors = new HashSet<>();
        for (TmsColor tmsColor : tmsColors) {
            colors.add(toDto(tmsColor, lazy));
        }
        return colors;
    }

}
