package com.sinno.ems.mapper;

import com.sinno.ems.dto.Actions;
import com.sinno.ems.entities.UsrActions;

import java.util.*;


public class ActionsMapper {
    private ActionsMapper() {
    }

    private static Map<String, String> map;

    static {
        map = new HashMap<>();
        map.put("id", "usrActionsId");
        map.put("code", "usrActionsCode");
        map.put("creationDate", "usrActionsCreationDate");
    }

    public static Map<String, String> getMap() {
        return map;
    }

    public static String getField(String key) {
        return map.get(key);
    }

    public static UsrActions toEntity(Actions actions, boolean lazy) {
        if (null == actions) {
            return null;
        }
        UsrActions usrActions = new UsrActions();
        usrActions.setUsrActionsId(actions.getId());
        usrActions.setUsrActionsCode(actions.getCode());
        usrActions.setUsrActionsCreationDate(actions.getCreationDate());

        return usrActions;
    }

    public static Actions toDto(UsrActions usrActions, boolean lazy) {
        if (null == usrActions) {
            return null;
        }
        Actions actions = new Actions();
        actions.setId(usrActions.getUsrActionsId());
        actions.setCode(usrActions.getUsrActionsCode());
        actions.setCreationDate(usrActions.getUsrActionsCreationDate());
        return actions;
    }

    public static List<Actions> toDtos(List<UsrActions> usrActionss, boolean lazy) {
        if (null == usrActionss) {
            return null;
        }
        List<Actions> actionss = new ArrayList<>();
        for (UsrActions usrActions : usrActionss) {
            actionss.add(toDto(usrActions, lazy));
        }
        return actionss;
    }

    public static List<Actions> toDtos(Iterable<UsrActions> usrActionss, boolean lazy) {
        if (null == usrActionss) {
            return null;
        }
        List<Actions> actionss = new ArrayList<>();
        for (UsrActions usrActions : usrActionss) {
            actionss.add(toDto(usrActions, lazy));
        }
        return actionss;
    }

    public static Set<UsrActions> toEntities(Set<Actions> actionss, boolean lazy) {
        if (null == actionss) {
            return null;
        }
        Set<UsrActions> usrActionss = new HashSet<>();
        for (Actions actions : actionss) {
            usrActionss.add(toEntity(actions, lazy));
        }
        return usrActionss;
    }

    public static Set<Actions> toDtos(Set<UsrActions> usrActionss, boolean lazy) {
        if (null == usrActionss) {
            return null;
        }
        Set<Actions> actionss = new HashSet<>();
        for (UsrActions usrActions : usrActionss) {
            actionss.add(toDto(usrActions, lazy));
        }
        return actionss;
    }
}
