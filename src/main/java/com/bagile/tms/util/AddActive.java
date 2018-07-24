package com.bagile.tms.util;

/**
 * Created by Enissay on 17/11/2017.
 */
public interface AddActive {
    default String addActiveToSearch(String search) {
        if (!search.trim().contains("isActive:false")) {
            if (!search.endsWith(",")) {
                search += ",";
            }
            search += "isActive:true";
        }
        return search;
    }
}
