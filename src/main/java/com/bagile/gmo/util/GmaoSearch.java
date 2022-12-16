package com.bagile.gmo.util;


public interface GmaoSearch {
    default String addGmaoToSearch(String search) {
        if(!search.equalsIgnoreCase("")){
            if ( !search.trim().contains("gmao:false")) {
                if (!search.endsWith(",")) {
                    search += ",";
                }
                search += "gmao:true";
            }
        }else {
            search += "gmao:true";
        }

        return search;
    }

    default String addServiceToSearch(String search) {
        if(!search.equalsIgnoreCase("")){
            if ( !search.trim().contains("service:false")) {
                if (!search.endsWith(",")) {
                    search += ",";
                }
                search += "service:true,gmao:true";
            }
        }else {
            search += "service:true,gmao:true";
        }

        return search;
    }
}