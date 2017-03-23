package com.sinno.ems.mapper;

import com.sinno.ems.dto.Acte;
import com.sinno.ems.entities.PrmActe;

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

    public static PrmActe toEntity(Acte acte, boolean lazy) {
        if (null == acte) {
            return null;
        }
        PrmActe prmActe = new PrmActe();
        prmActe.setPrmActeId(acte.getId());
        prmActe.setPrmActeCode(acte.getCode());
        prmActe.setPrmActeNature(acte.getNature());
        prmActe.setPrmActeDescription(acte.getDescription());
        prmActe.setprmActedateLastAct(acte.getDateLastAct());
        prmActe.setPrmActePeriodicity(acte.getPeriodicity());
        if (!lazy) {

        }
        return prmActe;

    }

    public static Acte toDto(PrmActe prmActe, boolean lazy) {
        if (null == prmActe) {
            return null;
        }
        Acte acte = new Acte();
        acte.setId(prmActe.getPrmActeId());
        acte.setCode(prmActe.getPrmActeCode());
        acte.setNature(prmActe.getPrmActeNature());
        acte.setDescription(prmActe.getPrmActeNature());
        acte.setDateLastAct(acte.getDateLastAct());
        acte.setPeriodicity(acte.getPeriodicity());
        if(!lazy){

        }
        return acte;
    }
    public static List<Acte> toDtos(List<PrmActe> prmActes, boolean lazy) {
        if (null == prmActes) {
            return null;
        }
        List<Acte> actes = new ArrayList<>();
        for (PrmActe prmActe : prmActes) {
            actes.add(toDto(prmActe, lazy));

        }
        return actes;
    }
    public static List<Acte> toDtos(Iterable<PrmActe> prmActes, boolean lazy) {
        if (null == prmActes) {
            return null;
        }
        List<Acte> actes = new ArrayList<>();
        for (PrmActe prmActe : prmActes) {
            actes.add(toDto(prmActe, lazy));
        }
        return actes;
    }
    public static Set<PrmActe> toEntities(Set<Acte>actes,boolean lazy){
        if (null == actes) {
            return null;
        }
        Set<PrmActe> prmActes = new HashSet<>();
        for(Acte acte:actes){
            prmActes.add(toEntity(acte,lazy));
        }
        return prmActes;
    }
    public static Set<Acte> toDtos(Set<PrmActe> prmActes,boolean lazy){
        if(null ==prmActes){
            return null;
        }
        Set<Acte> actes = new HashSet<>();
        for(PrmActe prmDriver:prmActes){
            actes.add(toDto(prmDriver,lazy));
        }
        return actes;
    }
}































