package com.sinno.ems.mapper;

import com.sinno.ems.dto.Color;
import com.sinno.ems.entities.PrmColor;

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

    public static PrmColor toEntity(Color color, boolean lazy) {
        if (null == color) {
            return null;
        }
        PrmColor prmColor = new PrmColor();
        prmColor.setPrmColorId(color.getId());
        prmColor.setPrmColorCode(color.getCode() != null ? color.getCode().toUpperCase() : null);
        prmColor.setPrmColorDescription(color.getDescription());
        prmColor.setPrmColorCreationDate(color.getCreationDate());
        prmColor.setPrmColorUpdateDate(color.getUpdateDate());
        if (!lazy) {
            prmColor.setOwnOwner(OwnerMapper.toEntity(color.getOwner(), true));
//
        }
        return prmColor;
    }

    public static Color toDto(PrmColor prmColor, boolean lazy) {
        if (null == prmColor) {
            return null;
        }
        Color color = new Color();
        color.setId(prmColor.getPrmColorId());
        color.setCode(prmColor.getPrmColorCode());
        color.setDescription(prmColor.getPrmColorDescription());
        color.setCreationDate(prmColor.getPrmColorCreationDate());
        color.setUpdateDate(prmColor.getPrmColorUpdateDate());
        if (!lazy) {
            color.setOwner(OwnerMapper.toDto(prmColor.getOwnOwner(), true));
        }
        return color;

    }

    public static List<Color> toDtos(List<PrmColor> prmColors, boolean lazy) {
        if (null == prmColors) {
            return null;
        }
        List<Color> colors = new ArrayList<>();
        for (PrmColor prmColor : prmColors) {
            colors.add(toDto(prmColor, lazy));
        }
        return colors;
    }

    public static List<Color> toDtos(Iterable<PrmColor> prmColors, boolean lazy) {
        if (null == prmColors) {
            return null;
        }
        List<Color> colors = new ArrayList<>();
        for (PrmColor prmColor : prmColors) {
            colors.add(toDto(prmColor, lazy));
        }
        return colors;
    }

    public static Set<PrmColor> toEntities(Set<Color> colors, boolean lazy) {
        if (null == colors) {
            return null;
        }
        Set<PrmColor> prmColors = new HashSet<>();
        for (Color color : colors) {
            prmColors.add(toEntity(color, lazy));
        }
        return prmColors;
    }

    public static Set<Color> toDtos(Set<PrmColor> prmColors, boolean lazy) {
        if (null == prmColors) {
            return null;
        }
        Set<Color> colors = new HashSet<>();
        for (PrmColor prmColor : prmColors) {
            colors.add(toDto(prmColor, lazy));
        }
        return colors;
    }
}
