package com.sinno.ems.mapper;

import com.sinno.ems.dto.Acte;
import com.sinno.ems.entities.TmsActe;

import java.util.*;

/**
 * Created by khalil on 16/03/2017.
 */
public class ActeMapper {
    private ActeMapper() {

    }

    private static Map<String, String> map;

    static {
        map = new HashMap<>();
        map.put("id", "prmActeId");
        map.put("code", "prmActeCode");
        map.put("nature", "prmActeNature");
        map.put("description", "prmActeDescription");
        map.put("periodecity", "prmActePeriodecity");
        map.put("duration", "prmActeDuration");
        map.put("dateLastAct", "prmActeDateLastAct");
        map.put("duration", "prmActeDuration");
        map.put("maintenancePlans", "prmMaintenancePlans");

    }

    public static Map<String, String> getMap() {
        return map;
    }

    public static String getField(String key) {
        return map.get(key);
    }

    public static TmsActe toEntity(Acte acte, boolean lazy) {
        if (null == acte) {
            return null;
        }
        TmsActe tmsActe = new TmsActe();
        tmsActe.setPrmActeId(acte.getId());
        tmsActe.setPrmActeCode(acte.getCode());
        tmsActe.setPrmActeNature(acte.getNature());
        tmsActe.setPrmActeDescription(acte.getDescription());
        tmsActe.setprmActedateLastAct(acte.getDateLastAct());
        tmsActe.setPrmActePeriodicity(acte.getPeriodicity());
        if (!lazy) {

        }
        return tmsActe;

    }

    public static Acte toDto(TmsActe tmsActe, boolean lazy) {
        if (null == tmsActe) {
            return null;
        }
        Acte acte = new Acte();
        acte.setId(tmsActe.getPrmActeId());
        acte.setCode(tmsActe.getPrmActeCode());
        acte.setNature(tmsActe.getPrmActeNature());
        acte.setDescription(tmsActe.getPrmActeNature());
        acte.setDateLastAct(acte.getDateLastAct());
        acte.setPeriodicity(acte.getPeriodicity());
        if(!lazy){

        }
        return acte;
    }
    public static List<Acte> toDtos(List<TmsActe> tmsActes, boolean lazy) {
        if (null == tmsActes) {
            return null;
        }
        List<Acte> actes = new ArrayList<>();
        for (TmsActe tmsActe : tmsActes) {
            actes.add(toDto(tmsActe, lazy));

        }
        return actes;
    }
    public static List<Acte> toDtos(Iterable<TmsActe> prmActes, boolean lazy) {
        if (null == prmActes) {
            return null;
        }
        List<Acte> actes = new ArrayList<>();
        for (TmsActe tmsActe : prmActes) {
            actes.add(toDto(tmsActe, lazy));
        }
        return actes;
    }
    public static Set<TmsActe> toEntities(Set<Acte>actes, boolean lazy){
        if (null == actes) {
            return null;
        }
        Set<TmsActe> tmsActes = new HashSet<>();
        for(Acte acte:actes){
            tmsActes.add(toEntity(acte,lazy));
        }
        return tmsActes;
    }
    public static Set<Acte> toDtos(Set<TmsActe> tmsActes, boolean lazy){
        if(null == tmsActes){
            return null;
        }
        Set<Acte> actes = new HashSet<>();
        for(TmsActe prmDriver: tmsActes){
            actes.add(toDto(prmDriver,lazy));
        }
        return actes;
    }
}































