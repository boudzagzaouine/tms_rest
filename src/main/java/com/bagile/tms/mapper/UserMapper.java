package com.bagile.tms.mapper;

import com.bagile.tms.dto.User;
import com.bagile.tms.entities.UsrUser;

import java.util.*;

public class UserMapper {
    private UserMapper() {
    }

    private static Map<String, String> map;

    static {
        map = new HashMap<>();
        map.put("id", "usrUserId");
        map.put("owner", "ownOwner");
        map.put("userGroup", "usrUserGroup");
        map.put("code", "usrUserCode");
        map.put("password", "usrUserPassword");
        map.put("name", "usrUserName");
        map.put("surname", "usrUserSurname");
        map.put("dateOfBirth", "usrUserDateOfBirth");
        map.put("tel", "usrUserTel");
        map.put("passport", "usrUserPassport");
        map.put("comment", "usrUserComment");
        map.put("active", "usrUserIsActive");
        map.put("creationDate", "usrUserCreationDate");
        map.put("updateDate", "usrUserUpdateDate");
        map.put("email", "usrUserEmail");
        map.put("type", "usrUserType");
        map.put("agency", "usrAgency");
    }

    public static String getField(String key) {
        return map.get(key);
    }


    public static Map<String, String> getMap() {
        return map;
    }

    public static UsrUser toEntity(User user, boolean lazy) {
        if (null == user) {
            return null;
        }
        UsrUser usrUser = new UsrUser();
        usrUser.setUsrUserId(user.getId());
        usrUser.setUsrUserCode(user.getCode() != null ? user.getCode().toUpperCase() : null);
        usrUser.setUsrUserPassword(user.getPassword());
        usrUser.setUsrUserName(user.getName());
        usrUser.setUsrUserSurname(user.getSurname());
        usrUser.setUsrUserDateOfBirth(user.getDateOfBirth());
        usrUser.setUsrUserTel(user.getTel());
        usrUser.setUsrUserPassport(user.getPassport());
        usrUser.setUsrUserComment(user.getComment());
        usrUser.setUsrUserIsActive(user.isActive());
        usrUser.setUsrUserCreationDate(user.getCreationDate());
        usrUser.setUsrUserUpdateDate(user.getUpdateDate());
        usrUser.setUsrUserEmail(user.getEmail());
        usrUser.setUsrUserType(user.getType());
        if (!lazy) {
            usrUser.setUsrUserGroup(UserGroupMapper.toEntity(user.getUserGroup(), false));
            usrUser.setOwnOwner(OwnerMapper.toEntity(user.getOwner(), true));
        }
        return usrUser;
    }

    public static User toDto(UsrUser usrUser, boolean lazy) {
        if (null == usrUser) {
            return null;
        }
        User user = new User();
        user.setId(usrUser.getUsrUserId());
        user.setCode(usrUser.getUsrUserCode());
        user.setPassword(usrUser.getUsrUserPassword());
        user.setName(usrUser.getUsrUserName());
        user.setSurname(usrUser.getUsrUserSurname());
        user.setDateOfBirth(usrUser.getUsrUserDateOfBirth());
        user.setTel(usrUser.getUsrUserTel());
        user.setPassport(usrUser.getUsrUserPassport());
        user.setComment(usrUser.getUsrUserComment());
        user.setActive(usrUser.getUsrUserIsActive());
        user.setCreationDate(usrUser.getUsrUserCreationDate());
        user.setUpdateDate(usrUser.getUsrUserUpdateDate());
        user.setEmail(usrUser.getUsrUserEmail());
        user.setType(usrUser.getUsrUserType());
        if (!lazy) {
            user.setUserGroup(UserGroupMapper.toDto(usrUser.getUsrUserGroup(), false));
            user.setOwner(OwnerMapper.toDto(usrUser.getOwnOwner(), true));
        }
        return user;
    }

    public static List<User> toDtos(List<UsrUser> usrUsers, boolean lazy) {
        if (null == usrUsers) {
            return null;
        }
        List<User> users = new ArrayList<>();
        for (UsrUser usrUser : usrUsers) {
            users.add(toDto(usrUser, lazy));
        }
        return users;
    }

    public static List<User> toDtos(Iterable<UsrUser> usrUsers, boolean lazy) {
        if (null == usrUsers) {
            return null;
        }
        List<User> users = new ArrayList<>();
        for (UsrUser usrUser : usrUsers) {
            users.add(toDto(usrUser, lazy));
        }
        return users;
    }

    public static Set<UsrUser> toEntities(Set<User> users, boolean lazy) {
        if (null == users) {
            return null;
        }
        Set<UsrUser> usrUsers = new HashSet<>();
        for (User user : users) {
            usrUsers.add(toEntity(user, lazy));
        }
        return usrUsers;
    }

    public static Set<User> toDtos(Set<UsrUser> usrUsers, boolean lazy) {
        if (null == usrUsers) {
            return null;
        }
        Set<User> users = new HashSet<>();
        for (UsrUser usrUser : usrUsers) {
            users.add(toDto(usrUser, lazy));
        }
        return users;
    }
}
