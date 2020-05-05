package com.bagile.gmo.util;

/**
 * Created by Enissay on 17/11/2017.
 */
public interface AddActive {
    default String addActiveToSearch(String search) {
        if (!search.trim().contains("active:false")) {
            if (!search.endsWith(",")) {
                search += ",";
            }
            search += "active:true";
        }
        return search;
    }
}
