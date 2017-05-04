package com.sinno.ems.mapper;

import com.sinno.ems.dto.UserAgency;
import com.sinno.ems.dto.UserAgency;
import com.sinno.ems.entities.UsrUserAgency;

import java.util.*;

/**
 * Created by Enissay on 03/01/2017.
 */
public class UserAgencyMapper {
    private UserAgencyMapper() {
    }

    private static Map<String, String> map;

    static {
        map = new HashMap<>();
        map.put("id","usrUserAgencyId");
        map.put("agency","usrAgency");
        map.put("user","usrUser");

    }

    public static Map<String, String> getMap() {
        return map;
    }

    public static String getField(String key) {
        return map.get(key);
    }

    public static UserAgency toDto(UsrUserAgency usrUserAgency, boolean lazy) {
        if (null == usrUserAgency) {
            return null;
        }
        UserAgency userAgency = new UserAgency();
        userAgency.setId(usrUserAgency.getUsrUserAgencyId());
        if (!lazy) {
            userAgency.setAgency(AgencyMapper.toDto(usrUserAgency.getUsrAgency(), true));
            userAgency.setUser(UserMapper.toDto(usrUserAgency.getUsrUser(), true));
        }
        return userAgency;
    }

    public static UsrUserAgency toEntity(UserAgency userAgency, boolean lazy) {
        if (null == userAgency) {
            return null;
        }
        UsrUserAgency usrUserAgency = new UsrUserAgency();
        usrUserAgency.setUsrUserAgencyId(userAgency.getId());
        if (!lazy) {
            usrUserAgency.setUsrAgency(AgencyMapper.toEntity(userAgency.getAgency(), true));
            usrUserAgency.setUsrUser(UserMapper.toEntity(userAgency.getUser(), true));
        }
        return usrUserAgency;
    }

    public static List<UserAgency> toDtos(List<UsrUserAgency> usrUserAgencies, boolean lazy) {
        if (null == usrUserAgencies) {
            return null;
        }
        List<UserAgency> userAgencies = new ArrayList<>();
        for (UsrUserAgency usrUserAgency : usrUserAgencies) {
            userAgencies.add(toDto(usrUserAgency, lazy));
        }
        return userAgencies;
    }

    public static List<UserAgency> toDtos(Iterable<UsrUserAgency> usrUserAgencies, boolean lazy) {
        if (null == usrUserAgencies) {
            return null;
        }
        List<UserAgency> userAgencies = new ArrayList<>();
        for (UsrUserAgency usrUserAgency : usrUserAgencies) {
            userAgencies.add(toDto(usrUserAgency, lazy));
        }
        return userAgencies;
    }

    public static Set<UsrUserAgency> toEntities(Set<UserAgency> userAgencies, boolean lazy) {
        if (null == userAgencies) {
            return null;
        }
        Set<UsrUserAgency> usrUserAgencies = new HashSet<>();
        for (UserAgency userAgency : userAgencies) {
            usrUserAgencies.add(toEntity(userAgency, lazy));
        }
        return usrUserAgencies;
    }

    public static Set<UserAgency> toDtos(Set<UsrUserAgency> usrUserAgencies, boolean lazy) {
        if (null == usrUserAgencies) {
            return null;
        }
        Set<UserAgency> userAgencies = new HashSet<>();
        for (UsrUserAgency usrUserAgency : usrUserAgencies) {
            userAgencies.add(toDto(usrUserAgency, lazy));
        }
        return userAgencies;
    }
}
