package com.sinno.ems.dto;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by Enissay on 03/01/2017.
 */
public class UserAgency {
    private long id;
    private User user;
    private Agency agency;
    private Set<UserAgency> userAgencies = new HashSet<>(0);

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Agency getAgency() {
        return agency;
    }

    public void setAgency(Agency agency) {
        this.agency = agency;
    }

    public Set<UserAgency> getUserAgencies() {
        return userAgencies;
    }

    public void setUserAgencies(Set<UserAgency> userAgencies) {
        this.userAgencies = userAgencies;
    }
}
