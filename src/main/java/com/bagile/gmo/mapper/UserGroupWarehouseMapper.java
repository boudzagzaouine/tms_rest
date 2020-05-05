/**
 *
 */
package com.bagile.gmo.mapper;

import com.bagile.gmo.dto.UserGroupWarehouse;
import com.bagile.gmo.entities.UsrUserGroupWarehouse;

import java.util.*;

/**
 * @author aelguezzar
 */
public class UserGroupWarehouseMapper {
    private UserGroupWarehouseMapper() {
    }

    private static Map<String, String> map;

    static {
        map = new HashMap<>();

        map.put("id", "usrUserGroupOwnOwnerId");
        map.put("warehouse", "wrhWarehouse");
        map.put("userGroup", "usrUserGroup");
        map.put("createdBy", "createdBy");
        map.put("updatedBy", "updatedBy");
        map.put("creationDate", "creationDate");
        map.put("updateDate", "updateDate");
    }

    public static String getField(String key) {
        return map.get(key);
    }

    public static Map<String, String> getMap() {
        return map;
    }

    public static UserGroupWarehouse toDto(UsrUserGroupWarehouse usrUserGroupWarehouse, boolean lazy) {
        if (null == usrUserGroupWarehouse) {
            return null;
        }
        UserGroupWarehouse userGroupWarehouse = new UserGroupWarehouse();
        userGroupWarehouse.setId(usrUserGroupWarehouse.getUsrUserGroupWrhWarehouseId());
        userGroupWarehouse.setCreatedBy(usrUserGroupWarehouse.getCreatedBy());
        userGroupWarehouse.setUpdatedBy(usrUserGroupWarehouse.getUpdatedBy());
        userGroupWarehouse.setCreationDate(usrUserGroupWarehouse.getCreationDate());
        userGroupWarehouse.setUpdateDate(usrUserGroupWarehouse.getUpdateDate());
        if (!lazy) {
            userGroupWarehouse.setWarehouse(WarehouseMapper.toDto(usrUserGroupWarehouse.getWrhWarehouse(), true));
            userGroupWarehouse.setUserGroup(UserGroupMapper.toDto(usrUserGroupWarehouse.getUsrUserGroup(), true));
        }
        return userGroupWarehouse;
    }

    public static UsrUserGroupWarehouse toEntity(UserGroupWarehouse userGroupWarehouse, boolean lazy) {
        if (null == userGroupWarehouse) {
            return null;
        }
        UsrUserGroupWarehouse usrUserGroupWarehouse = new UsrUserGroupWarehouse();
        usrUserGroupWarehouse.setUsrUserGroupWrhWarehouseId(userGroupWarehouse.getId());
        usrUserGroupWarehouse.setCreatedBy(userGroupWarehouse.getCreatedBy());
        usrUserGroupWarehouse.setUpdatedBy(userGroupWarehouse.getUpdatedBy());
        usrUserGroupWarehouse.setCreationDate(userGroupWarehouse.getCreationDate());
        usrUserGroupWarehouse.setUpdateDate(userGroupWarehouse.getUpdateDate());
        if (!lazy) {
            usrUserGroupWarehouse.setUsrUserGroup(UserGroupMapper.toEntity(userGroupWarehouse.getUserGroup(), true));
            usrUserGroupWarehouse.setWrhWarehouse(WarehouseMapper.toEntity(userGroupWarehouse.getWarehouse(), true));
        }
        return usrUserGroupWarehouse;
    }

    public static List<UserGroupWarehouse> toDtos(Iterable<? extends UsrUserGroupWarehouse> usrUserGroupWarehouses, boolean lazy) {
        if (null == usrUserGroupWarehouses) {
            return null;
        }
        List<UserGroupWarehouse> userGroupWarehouses = new ArrayList<>();
        for (UsrUserGroupWarehouse usrUserGroupWarehouse : usrUserGroupWarehouses) {
            userGroupWarehouses.add(toDto(usrUserGroupWarehouse, lazy));
        }
        return userGroupWarehouses;
    }

    public static Set<UsrUserGroupWarehouse> toEntities(Set<? extends UserGroupWarehouse> userGroupWarehouses, boolean lazy) {
        if (null == userGroupWarehouses) {
            return null;
        }
        Set<UsrUserGroupWarehouse> usrUserGroupWarehouses = new HashSet<>();
        for (UserGroupWarehouse userGroupWarehouse : userGroupWarehouses) {
            usrUserGroupWarehouses.add(toEntity(userGroupWarehouse, lazy));
        }
        return usrUserGroupWarehouses;
    }

    public static Set<UserGroupWarehouse> toDtos(Set<? extends UsrUserGroupWarehouse> usrUserGroupWarehouses, boolean lazy) {
        if (null == usrUserGroupWarehouses) {
            return null;
        }
        Set<UserGroupWarehouse> userGroupWarehouses = new HashSet<>();
        for (UsrUserGroupWarehouse usrUserGroupWarehouse : usrUserGroupWarehouses) {
            userGroupWarehouses.add(toDto(usrUserGroupWarehouse, lazy));
        }
        return userGroupWarehouses;
    }

}
