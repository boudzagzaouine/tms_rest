package com.sinno.ems.mapper;

import com.sinno.ems.dto.UserActions;
import com.sinno.ems.entities.UsrUserActions;

import java.util.*;

public class UserActionsMapper {
    private UserActionsMapper() {
    }

    private static Map<String, String> map;

    static {
        map = new HashMap<>();
        map.put("id","usrUserActionsId");
        map.put("actions","usrActions");
        map.put("user","usrUser");
        map.put("creationDate","usrUserActionsCreationDate");}

    public static Map<String, String> getMap() {
        return map;
    }

    public static String getField(String key) {
        return map.get(key);
    }

    public static UserActions toDto(UsrUserActions usrUserActions, boolean lazy) {
        if (null == usrUserActions) {
            return null;
        }
        UserActions userActions = new UserActions();
        userActions.setId(usrUserActions.getUsrUserActionsId());
        userActions.setCreationDate(usrUserActions.getUsrUserActionsCreationDate());
        if (!lazy) {
            userActions.setUser(UserMapper.toDto(usrUserActions.getUsrUser(), true));
            userActions.setActions(ActionsMapper.toDto(usrUserActions.getUsrActions(), true));
        }
        return userActions;
    }

    public static UsrUserActions toEntity(UserActions userActions, boolean lazy) {
        if (null == userActions) {
            return null;
        }
        UsrUserActions usrUserActions = new UsrUserActions();
        usrUserActions.setUsrUserActionsId(userActions.getId());
        usrUserActions.setUsrUserActionsCreationDate(userActions.getCreationDate());
        if (!lazy) {
            usrUserActions.setUsrActions(ActionsMapper.toEntity(userActions.getActions(), true));
            usrUserActions.setUsrUser(UserMapper.toEntity(userActions.getUser(), true));
        }
        return usrUserActions;
    }

    public static List<UserActions> toDtos(List<UsrUserActions> usrUserActionss, boolean lazy) {
        if (null == usrUserActionss) {
            return null;
        }
        List<UserActions> userActionss = new ArrayList<>();
        for (UsrUserActions usrUserActions : usrUserActionss) {
            userActionss.add(toDto(usrUserActions, lazy));
        }
        return userActionss;
    }

    public static List<UserActions> toDtos(Iterable<UsrUserActions> usrUserActionss, boolean lazy) {
        if (null == usrUserActionss) {
            return null;
        }
        List<UserActions> userActionss = new ArrayList<>();
        for (UsrUserActions usrUserActions : usrUserActionss) {
            userActionss.add(toDto(usrUserActions, lazy));
        }
        return userActionss;
    }

    public static Set<UserActions> toDtos(Set<UsrUserActions> usrUserActionss, boolean lazy) {
        if (null == usrUserActionss) {
            return null;
        }
        Set<UserActions> userActionss = new HashSet<>();
        for (UsrUserActions usrUserActions : usrUserActionss) {
            userActionss.add(toDto(usrUserActions, lazy));
        }
        return userActionss;
    }

    public static Set<UsrUserActions> toEntities(Set<UserActions> userActionss, boolean lazy) {
        if (null == userActionss) {
            return null;
        }
        Set<UsrUserActions> usrUserActionss = new HashSet<>();
        for (UserActions userActions : userActionss) {
            usrUserActionss.add(toEntity(userActions, lazy));
        }
        return usrUserActionss;
    }
}
