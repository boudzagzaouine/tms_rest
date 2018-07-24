package com.bagile.tms.mapper;

import com.sinno.ems.dto.UserGroup;
import com.sinno.ems.entities.UsrUserGroup;

import java.util.*;

public class UserGroupMapper {
    private UserGroupMapper() {
    }

    private static Map<String, String> map;

    static {
        map = new HashMap<>();
        map.put("id", "usrUserGroupId");
        map.put("code", "usrUserGroupCode");
        map.put("description", "usrUserGroupDescription");
        map.put("type", "userUserGroupType");

    }

    public static Map<String, String> getMap() {
        return map;
    }

    public static String getField(String key) {
        return map.get(key);
    }

    public static UserGroup toDto(UsrUserGroup usrUserGroup, boolean lazy) {
        if (null == usrUserGroup) {
            return null;
        }
        UserGroup userGroup = new UserGroup();
        userGroup.setId(usrUserGroup.getUsrUserGroupId());
        userGroup.setCode(usrUserGroup.getUsrUserGroupCode());
        userGroup.setDescription(usrUserGroup.getUsrUserGroupDescription());
        userGroup.setType(usrUserGroup.getUserUserGroupType());
        if (!lazy) {
            userGroup.setGroupHabilitations(GroupHabilitationMapper.toDtos(usrUserGroup.getUsrGroupHabilitations(), false));
            userGroup.setUserGroupOwners(UserGroupOwnerMapper.toDtos(usrUserGroup.getUsrUserGroupOwnOwners(), false));
            userGroup.setUserGroupWarehouses(UserGroupWarehouseMapper.toDtos(usrUserGroup.getUsrUserGroupWrhWarehouses(), false));
            userGroup.setUsers(UserMapper.toDtos(usrUserGroup.getUsrUsers(), true));
        }
        return userGroup;
    }

    public static UsrUserGroup toEntity(UserGroup userGroup, boolean lazy) {
        if (null == userGroup) {
            return null;
        }
        UsrUserGroup usrUserGroup = new UsrUserGroup();
        usrUserGroup.setUsrUserGroupId(userGroup.getId());
        usrUserGroup.setUsrUserGroupCode(userGroup.getCode() != null ? userGroup.getCode().toUpperCase() : null);
        usrUserGroup.setUsrUserGroupDescription(userGroup.getDescription());
        usrUserGroup.setUserUserGroupType(userGroup.getType());
        if (!lazy) {
            usrUserGroup.setUsrGroupHabilitations(GroupHabilitationMapper.toEntities(userGroup.getGroupHabilitations(), false));
            usrUserGroup.setUsrUserGroupOwnOwners(UserGroupOwnerMapper.toEntities(userGroup.getUserGroupOwners(), false));
            usrUserGroup.setUsrUserGroupWrhWarehouses(UserGroupWarehouseMapper.toEntities(userGroup.getUserGroupWarehouses(), false));
            usrUserGroup.setUsrUsers(UserMapper.toEntities(userGroup.getUsers(), true));
        }
        return usrUserGroup;
    }

    public static List<UserGroup> toDtos(List<UsrUserGroup> usrUserGroups, boolean lazy) {
        if (null == usrUserGroups) {
            return null;
        }
        List<UserGroup> userGroups = new ArrayList<>();
        for (UsrUserGroup usrUserGroup : usrUserGroups) {
            userGroups.add(toDto(usrUserGroup, lazy));
        }
        return userGroups;
    }

    public static List<UserGroup> toDtos(Iterable<UsrUserGroup> usrUserGroups, boolean lazy) {
        if (null == usrUserGroups) {
            return null;
        }
        List<UserGroup> userGroups = new ArrayList<>();
        for (UsrUserGroup usrUserGroup : usrUserGroups) {
            userGroups.add(toDto(usrUserGroup, lazy));
        }
        return userGroups;
    }

    public static Set<UserGroup> toDtos(Set<UsrUserGroup> usrUserGroups, boolean lazy) {
        if (null == usrUserGroups) {
            return null;
        }
        Set<UserGroup> userGroups = new HashSet<>();
        for (UsrUserGroup usrUserGroup : usrUserGroups) {
            userGroups.add(toDto(usrUserGroup, lazy));
        }
        return userGroups;
    }

    public static Set<UsrUserGroup> toEntities(Set<UserGroup> userGroups, boolean lazy) {
        if (null == userGroups) {
            return null;
        }
        Set<UsrUserGroup> usrUserGroups = new HashSet<>();
        for (UserGroup userGroup : userGroups) {
            usrUserGroups.add(toEntity(userGroup, lazy));
        }
        return usrUserGroups;
    }
}
