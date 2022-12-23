package com.bagile.gmo.mapper;



import com.bagile.gmo.dto.ActivityArea;
import com.bagile.gmo.entities.CmdActivityArea;

import java.util.*;

/**
 * Created by fama on 06/03/2017.
 */
public class ActivityAreaMapper {
    private static Map<String, String> map;

    static {
        map = new HashMap<>();
        map.put("id", "cmdActivityAreaId");
        map.put("code", "cmdActivityAreaCode");
        map.put("description", "cmdActivityAreaDescription");
        map.put("creationDate", "cmdActivityAreaCreationDate");
        map.put("updateDate", "cmdActivityAreaUpdateDate");
        map.put("organisation","orgOrganisation");
    }

    public static String getField(String key) {
        return map.get(key);
    }


    public static Map<String, String> getMap() {
        return map;
    }

    public static CmdActivityArea toEntity(ActivityArea activityArea, boolean lazy) {
        if (null == activityArea) {
            return null;
        }
        CmdActivityArea cmdActivityArea = new CmdActivityArea();
        cmdActivityArea.setCmdActivityAreaId(activityArea.getId());
        cmdActivityArea.setCmdActivityAreaCode(activityArea.getCode());
        cmdActivityArea.setCmdActivityAreaDescription(activityArea.getDescription());
        cmdActivityArea.setCmdActivityAreaCreationDate(activityArea.getCreationDate());
        cmdActivityArea.setCmdActivityAreaUpdateDate(activityArea.getUpdateDate());
        cmdActivityArea.setCreatedBy(activityArea.getCreatedBy());
        cmdActivityArea.setUpdatedBy(activityArea.getUpdatedBy());
        if(!lazy) {
        }
        return cmdActivityArea;
    }

    public static ActivityArea toDto(CmdActivityArea cmdActivityArea, boolean lazy) {
        if (null == cmdActivityArea) {
            return null;
        }
        ActivityArea activityArea = new ActivityArea();
        activityArea.setId(cmdActivityArea.getCmdActivityAreaId());
        activityArea.setCode(cmdActivityArea.getCmdActivityAreaCode() != null ? cmdActivityArea.getCmdActivityAreaCode().toUpperCase() : null);
        activityArea.setDescription(cmdActivityArea.getCmdActivityAreaDescription());
        activityArea.setCreationDate(cmdActivityArea.getCmdActivityAreaCreationDate());
        activityArea.setUpdateDate(cmdActivityArea.getCmdActivityAreaUpdateDate());
        activityArea.setCreatedBy(cmdActivityArea.getCreatedBy());
        activityArea.setUpdatedBy(cmdActivityArea.getUpdatedBy());
        return activityArea;
    }

    public static List<ActivityArea> toDtos(List<CmdActivityArea> cmdActivityAreas, boolean lazy) {
        if (null == cmdActivityAreas) {
            return null;
        }
        List<ActivityArea> activityAreas = new ArrayList<>();
        for (CmdActivityArea cmdActivityArea : cmdActivityAreas) {
            activityAreas.add(toDto(cmdActivityArea, lazy));
        }
        return activityAreas;
    }

    public static List<ActivityArea> toDtos(Iterable<CmdActivityArea> cmdActivityAreas, boolean lazy) {
        if (null == cmdActivityAreas) {
            return null;
        }
        List<ActivityArea> activityAreas = new ArrayList<>();
        for (CmdActivityArea cmdActivityArea : cmdActivityAreas) {
            activityAreas.add(toDto(cmdActivityArea, lazy));
        }
        return activityAreas;
    }

    public static Set<CmdActivityArea> toEntities(Set<ActivityArea> activityAreas, boolean lazy) {
        if (null == activityAreas) {
            return null;
        }
        Set<CmdActivityArea> cmdActivityAreas = new HashSet<>();
        for (ActivityArea activityArea : activityAreas) {
            cmdActivityAreas.add(toEntity(activityArea, lazy));
        }
        return cmdActivityAreas;
    }

    public static Set<ActivityArea> toDtos(Set<CmdActivityArea> cmdActivityAreas, boolean lazy) {
        if (null == cmdActivityAreas) {
            return null;
        }
        Set<ActivityArea> activityAreas = new HashSet<>();
        for (CmdActivityArea cmdActivityArea : cmdActivityAreas) {
            activityAreas.add(toDto(cmdActivityArea, lazy));
        }
        return activityAreas;
    }
}
