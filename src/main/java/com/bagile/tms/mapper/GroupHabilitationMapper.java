package com.bagile.tms.mapper;

import com.sinno.ems.dto.GroupHabilitation;
import com.sinno.ems.entities.UsrGroupHabilitation;

import java.util.*;

public class GroupHabilitationMapper {

    private static Map<String, String> map;

    private GroupHabilitationMapper() {
    }

    static {
        map = new HashMap<>();
        map.put("id", "usrGroupHabilitationId");
        map.put("habilitation", "usrHabilitation");
        map.put("userGroup", "usrUserGroup");
    }

    public static String getField(String key) {
        return map.get(key);
    }


    public static Map<String, String> getMap() {
        return map;
    }

    public static UsrGroupHabilitation toEntity(GroupHabilitation groupHabilitation, boolean lazy) {
        if (null == groupHabilitation) {
            return null;
        }
        UsrGroupHabilitation usrGroupHabilitation = new UsrGroupHabilitation();
        usrGroupHabilitation.setUsrGroupHabilitationId(groupHabilitation.getId());
        if (!lazy) {
            usrGroupHabilitation.setUsrHabilitation(HabilitationMapper.toEntity(groupHabilitation.getHabilitation(), true));
            usrGroupHabilitation.setUsrUserGroup(UserGroupMapper.toEntity(groupHabilitation.getUserGroup(), true));
        }
        return usrGroupHabilitation;
    }

    public static GroupHabilitation toDto(UsrGroupHabilitation usrGroupHabilitation, boolean lazy) {
        if (null == usrGroupHabilitation) {
            return null;
        }
        GroupHabilitation groupHabilitation = new GroupHabilitation();
        groupHabilitation.setId(usrGroupHabilitation.getUsrGroupHabilitationId());
        if (!lazy) {
            groupHabilitation.setHabilitation(HabilitationMapper.toDto(usrGroupHabilitation.getUsrHabilitation(), true));
            groupHabilitation.setUserGroup(UserGroupMapper.toDto(usrGroupHabilitation.getUsrUserGroup(), true));
        }
        return groupHabilitation;
    }

    public static List<GroupHabilitation> toDtos(List<UsrGroupHabilitation> usrGroupHabilitations, boolean lazy) {
        if (null == usrGroupHabilitations) {
            return null;
        }
        List<GroupHabilitation> groupHabilitations = new ArrayList<>();
        for (UsrGroupHabilitation usrGroupHabilitation : usrGroupHabilitations) {
            groupHabilitations.add(toDto(usrGroupHabilitation, lazy));
        }
        return groupHabilitations;
    }

    public static List<GroupHabilitation> toDtos(Iterable<UsrGroupHabilitation> usrGroupHabilitations, boolean lazy) {
        if (null == usrGroupHabilitations) {
            return null;
        }
        List<GroupHabilitation> groupHabilitations = new ArrayList<>();
        for (UsrGroupHabilitation usrGroupHabilitation : usrGroupHabilitations) {
            groupHabilitations.add(toDto(usrGroupHabilitation, lazy));
        }
        return groupHabilitations;
    }

    public static Set<UsrGroupHabilitation> toEntities(Set<GroupHabilitation> groupHabilitations, boolean lazy) {
        if (null == groupHabilitations) {
            return null;
        }
        Set<UsrGroupHabilitation> usrGroupHabilitations = new HashSet<>();
        for (GroupHabilitation groupHabilitation : groupHabilitations) {
            usrGroupHabilitations.add(toEntity(groupHabilitation, lazy));
        }
        return usrGroupHabilitations;
    }

    public static Set<GroupHabilitation> toDtos(Set<UsrGroupHabilitation> usrGroupHabilitations, boolean lazy) {
        if (null == usrGroupHabilitations) {
            return null;
        }
        Set<GroupHabilitation> groupHabilitations = new HashSet<>();
        for (UsrGroupHabilitation usrGroupHabilitation : usrGroupHabilitations) {
            groupHabilitations.add(toDto(usrGroupHabilitation, lazy));
        }
        return groupHabilitations;
    }

}
