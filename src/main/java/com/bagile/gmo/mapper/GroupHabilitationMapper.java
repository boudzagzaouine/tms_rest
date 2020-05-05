package com.bagile.gmo.mapper;

import com.bagile.gmo.dto.GroupHabilitation;
import com.bagile.gmo.entities.UsrGroupHabilitation;

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

        map.put("creationDate", "creationDate");
        map.put("updateDate", "updateDate");
        map.put("createdBy", "createdByUser");
        map.put("updatedBy", "updatedByUser");
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

        usrGroupHabilitation.setCreatedBy(groupHabilitation.getCreatedBy());
        usrGroupHabilitation.setUpdatedBy(groupHabilitation.getUpdatedBy());
        usrGroupHabilitation.setCreationDate(groupHabilitation.getCreationDate());
        usrGroupHabilitation.setUpdateDate(groupHabilitation.getUpdateDate());

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

        groupHabilitation.setCreatedBy(usrGroupHabilitation.getCreatedBy());
        groupHabilitation.setUpdatedBy(usrGroupHabilitation.getUpdatedBy());
        groupHabilitation.setCreationDate(usrGroupHabilitation.getCreationDate());
        groupHabilitation.setUpdateDate(usrGroupHabilitation.getUpdateDate());
        if (!lazy) {
            groupHabilitation.setHabilitation(HabilitationMapper.toDto(usrGroupHabilitation.getUsrHabilitation(), true));
            groupHabilitation.setUserGroup(UserGroupMapper.toDto(usrGroupHabilitation.getUsrUserGroup(), true));
        }
        return groupHabilitation;
    }



    public static List<GroupHabilitation> toDtos(Iterable<? extends UsrGroupHabilitation> usrGroupHabilitations, boolean lazy) {
        if (null == usrGroupHabilitations) {
            return null;
        }
        List<GroupHabilitation> groupHabilitations = new ArrayList<>();
        for (UsrGroupHabilitation usrGroupHabilitation : usrGroupHabilitations) {
            groupHabilitations.add(toDto(usrGroupHabilitation, lazy));
        }
        return groupHabilitations;
    }

    public static Set<UsrGroupHabilitation> toEntities(Set<? extends GroupHabilitation> groupHabilitations, boolean lazy) {
        if (null == groupHabilitations) {
            return null;
        }
        Set<UsrGroupHabilitation> usrGroupHabilitations = new HashSet<>();
        for (GroupHabilitation groupHabilitation : groupHabilitations) {
            usrGroupHabilitations.add(toEntity(groupHabilitation, lazy));
        }
        return usrGroupHabilitations;
    }

    public static Set<GroupHabilitation> toDtos(Set<? extends UsrGroupHabilitation> usrGroupHabilitations, boolean lazy) {
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
