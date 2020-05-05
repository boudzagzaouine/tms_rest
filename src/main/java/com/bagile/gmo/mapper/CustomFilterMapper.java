package com.bagile.gmo.mapper;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import com.bagile.gmo.dto.CustomFilter;
import com.bagile.gmo.entities.FltrCustomFilter;

public class CustomFilterMapper {
    private CustomFilterMapper() {
    }

    private static Map<String, String> map;

    static {
        map = new HashMap<>();
        map.put("id", "fltrId");
        map.put("queryName", "fltrQueryName");
        map.put("user", "fltrUser");
    }

    public static String getField(String key) {
        return map.get(key);
    }


    public static Map<String, String> getMap() {
        return map;
    }

    public static FltrCustomFilter toEntity(CustomFilter customFilter, boolean lazy) {
        if (null == customFilter) {
            return null;
        }
        FltrCustomFilter fltrCustomFilter = new FltrCustomFilter();
        fltrCustomFilter.setFltrId(customFilter.getId());
        fltrCustomFilter.setFltrQuery(customFilter.getQuery());
        fltrCustomFilter.setFltrName(customFilter.getName());
        if(!lazy)
        	fltrCustomFilter.setFltrUser(UserMapper.toEntity(customFilter.getUser(), lazy));
        	
        return fltrCustomFilter;
    }

    public static CustomFilter toDto(FltrCustomFilter fltrCustomFilter, boolean lazy) {
        if (null == fltrCustomFilter) {
            return null;
        }
        CustomFilter customFilter = new CustomFilter();
        customFilter.setId(fltrCustomFilter.getFltrId());
        customFilter.setQuery(fltrCustomFilter.getFltrQuery());
        customFilter.setName(fltrCustomFilter.getFltrName());
        if(!lazy)
        	customFilter.setUser(UserMapper.toDto(fltrCustomFilter.getFltrUser(), true));

        return customFilter;
    }

    public static List<CustomFilter> toDtos(Iterable<? extends FltrCustomFilter> fltrCustomFilters, boolean lazy) {
        if (null == fltrCustomFilters) {
            return null;
        }
        List<CustomFilter> customFilters = new ArrayList<>();
        for (FltrCustomFilter fltrCustomFilter : fltrCustomFilters) {
        	customFilters.add(toDto(fltrCustomFilter, lazy));
        }
        return customFilters;
    }

    public static Set<FltrCustomFilter> toEntities(Set<CustomFilter> customFilters, boolean lazy) {
        if (null == customFilters) {
            return null;
        }
        Set<FltrCustomFilter> fltrCustomFilters = new HashSet<>();
        for (CustomFilter customFilter : customFilters) {
        	fltrCustomFilters.add(toEntity(customFilter, lazy));
        }
        return fltrCustomFilters;
    }

    public static Set<CustomFilter> toDtos(Set<FltrCustomFilter> fltrCustomFilters, boolean lazy) {
        if (null == fltrCustomFilters) {
            return null;
        }
        Set<CustomFilter> customFilters = new HashSet<>();
        for (FltrCustomFilter fltrCustomFilter : fltrCustomFilters) {
        	customFilters.add(toDto(fltrCustomFilter, lazy));
        }
        return customFilters;
    }
}
