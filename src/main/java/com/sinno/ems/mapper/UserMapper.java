package com.sinno.ems.mapper;

import com.sinno.ems.dto.User;
import com.sinno.ems.entities.UsrUser;

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

        return usrUser;
    }

    public static User toDto(UsrUser usrUser, boolean lazy) {
        if (null == usrUser) {
            return null;
        }
        User user = new User();
       
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
