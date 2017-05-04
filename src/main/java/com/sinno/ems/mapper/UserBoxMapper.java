package com.sinno.ems.mapper;

import com.sinno.ems.dto.UserBox;
import com.sinno.ems.entities.UsrUserBox;

import java.util.*;

/**
 * Created by Adil on 3/1/2017.
 */
public class UserBoxMapper {
    private static Map<String, String> map;

    static {
        map = new HashMap<>();

        map.put("userBoxId", "usrUserBoxID");
        map.put("userBoxUser", "usrUserBoxBox");
        map.put("userBoxBox", "usrUserBoxUser");
        map.put("userBoxCreationDate", "usrUserBoxCreationDate");

    }

    public static Map<String, String> getMap() {
        return map;
    }

    public static String getField(String key) {
        return map.get(key);
    }

    public static UsrUserBox toEntity(UserBox userBox, boolean lazy) {
        if (null == userBox) {
            return null;
        }
        UsrUserBox usrUserBox = new UsrUserBox();
        usrUserBox.setUsrUserBoxID(userBox.getId());
        usrUserBox.setUsrUserBoxCreationDate(userBox.getCreationDate());
        if(!lazy){
            usrUserBox.setUsrUserBoxBox(BoxMapper.toEntity(userBox.getBox(),false));
            usrUserBox.setUsrUserBoxUser(UserMapper.toEntity(userBox.getUser(), false));
        }


        
        return usrUserBox;
    }

    public static UserBox toDto(UsrUserBox usrUserBox, boolean lazy) {
        if (null == usrUserBox) {
            return null;
        }
        UserBox userBox = new UserBox();
        userBox.setId(usrUserBox.getUsrUserBoxID());
        if(!lazy){
            userBox.setUser(UserMapper.toDto(usrUserBox.getUsrUserBoxUser(), false));
            userBox.setBox(BoxMapper.toDto(usrUserBox.getUsrUserBoxBox(), false));
        }

        userBox.setCreationDate(usrUserBox.getUsrUserBoxCreationDate());
        return userBox;

    }

    public static List<UserBox> toDtos(List<UsrUserBox> usrUserBoxs, boolean lazy) {
        if (null == usrUserBoxs) {
            return null;
        }
        List<UserBox> userBoxs = new ArrayList<>();
        for (UsrUserBox usrUserBox : usrUserBoxs) {
            userBoxs.add(toDto(usrUserBox, lazy));
        }
        return userBoxs;
    }

    public static List<UserBox> toDtos(Iterable<UsrUserBox> usrUserBoxs, boolean lazy) {
        if (null == usrUserBoxs) {
            return null;
        }
        List<UserBox> userBoxs = new ArrayList<>();
        for (UsrUserBox usrUserBox : usrUserBoxs) {
            userBoxs.add(toDto(usrUserBox, lazy));
        }
        return userBoxs;
    }

    public static Set<UsrUserBox> toEntities(Set<UserBox> userBoxs, boolean lazy) {
        if (null == userBoxs) {
            return null;
        }
        Set<UsrUserBox> usrUserBoxs = new HashSet<>();
        for (UserBox userBox : userBoxs) {
            usrUserBoxs.add(toEntity(userBox, lazy));
        }
        return usrUserBoxs;
    }

    public static Set<UserBox> toDtos(Set<UsrUserBox> usrUserBoxs, boolean lazy) {
        if (null == usrUserBoxs) {
            return null;
        }
        Set<UserBox> userBoxs = new HashSet<>();
        for (UsrUserBox usrUserBox : usrUserBoxs) {
            userBoxs.add(toDto(usrUserBox, lazy));
        }
        return userBoxs;
    }
}
