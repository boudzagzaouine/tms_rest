/**
 *
 */
package com.bagile.tms.mapper;

import com.bagile.tms.dto.UserGroupOwner;
import com.bagile.tms.entities.UsrUserGroupOwner;

import java.util.*;

/**
 * @author aelguezzar
 */
public class UserGroupOwnerMapper {
    private UserGroupOwnerMapper() {
    }

    private static Map<String, String> map;

    static {
        map = new HashMap<>();

        map.put("id", "usrUserGroupOwnOwnerId");
        map.put("owner", "ownOwner");
        map.put("userGroup", "usrUserGroup");
    }

    public static String getField(String key) {
        return map.get(key);
    }

    public static Map<String, String> getMap() {
        return map;
    }

    public static UserGroupOwner toDto(UsrUserGroupOwner usrUserGroupOwner, boolean lazy) {
        if (null == usrUserGroupOwner) {
            return null;
        }
        UserGroupOwner userGroupOwner = new UserGroupOwner();
        userGroupOwner.setId(usrUserGroupOwner.getUsrUserGroupOwnOwnerId());
        if (!lazy) {
            userGroupOwner.setOwner(OwnerMapper.toDto(usrUserGroupOwner.getOwnOwner(), true));
            userGroupOwner.setUserGroup(UserGroupMapper.toDto(usrUserGroupOwner.getUsrUserGroup(), true));
        }
        return userGroupOwner;
    }

    public static UsrUserGroupOwner toEntity(UserGroupOwner userGroupOwner, boolean lazy) {
        if (null == userGroupOwner) {
            return null;
        }
        UsrUserGroupOwner usrUserGroupOwner = new UsrUserGroupOwner();
        usrUserGroupOwner.setUsrUserGroupOwnOwnerId(userGroupOwner.getId());
        if (!lazy) {
            usrUserGroupOwner.setUsrUserGroup(UserGroupMapper.toEntity(userGroupOwner.getUserGroup(), true));
            usrUserGroupOwner.setOwnOwner(OwnerMapper.toEntity(userGroupOwner.getOwner(), true));
        }
        return usrUserGroupOwner;
    }

    public static List<UserGroupOwner> toDtos(List<UsrUserGroupOwner> usrUserGroupOwners, boolean lazy) {
        if (null == usrUserGroupOwners) {
            return null;
        }
        List<UserGroupOwner> userGroupOwners = new ArrayList<>();
        for (UsrUserGroupOwner usrUserGroupOwner : usrUserGroupOwners) {
            userGroupOwners.add(toDto(usrUserGroupOwner, lazy));
        }
        return userGroupOwners;
    }

    public static List<UserGroupOwner> toDtos(Iterable<UsrUserGroupOwner> usrUserGroupOwners, boolean lazy) {
        if (null == usrUserGroupOwners) {
            return null;
        }
        List<UserGroupOwner> userGroupOwners = new ArrayList<>();
        for (UsrUserGroupOwner usrUserGroupOwner : usrUserGroupOwners) {
            userGroupOwners.add(toDto(usrUserGroupOwner, lazy));
        }
        return userGroupOwners;
    }

    public static Set<UsrUserGroupOwner> toEntities(Set<UserGroupOwner> userGroupOwners, boolean lazy) {
        if (null == userGroupOwners) {
            return null;
        }
        Set<UsrUserGroupOwner> usrUserGroupOwners = new HashSet<>();
        for (UserGroupOwner userGroupOwner : userGroupOwners) {
            usrUserGroupOwners.add(toEntity(userGroupOwner, lazy));
        }
        return usrUserGroupOwners;
    }

    public static Set<UserGroupOwner> toDtos(Set<UsrUserGroupOwner> usrUserGroupOwners, boolean lazy) {
        if (null == usrUserGroupOwners) {
            return null;
        }
        Set<UserGroupOwner> userGroupOwners = new HashSet<>();
        for (UsrUserGroupOwner usrUserGroupOwner : usrUserGroupOwners) {
            userGroupOwners.add(toDto(usrUserGroupOwner, lazy));
        }
        return userGroupOwners;
    }

}
