package com.bagile.tms.mapper;

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
        map.put("id", "tmsActeId");
        map.put("code", "tmsActeCode");
        map.put("nature", "tmsActeNature");
        map.put("description", "tmsActeDescription");
        map.put("periodecity", "tmsActePeriodecity");
        map.put("duration", "tmsActeDuration");
        map.put("dateLastAct", "tmsActedateLastAct");

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
        tmsActe.setTmsActeId(acte.getId());
        tmsActe.setTmsActeCode(acte.getCode());
        tmsActe.setTmsActeNature(acte.getNature());
        tmsActe.setTmsActeDescription(acte.getDescription());
        tmsActe.setTmsActedateLastAct(acte.getDateLastAct());
        tmsActe.setTmsActePeriodicity(acte.getPeriodicity());
        tmsActe.setTmsActeDuration(acte.getDuration());
        if (!lazy) {
           // tmsActe.setTmsActeMaintenancePlan(MaintenancePlanMapper.toEntities(acte.getMaintenancePlans(), true));
        }
        return tmsActe;

    }

    public static Acte toDto(TmsActe tmsActe, boolean lazy) {
        if (null == tmsActe) {
            return null;
        }
        Acte acte = new Acte();
        acte.setId(tmsActe.getTmsActeId());
        acte.setCode(tmsActe.getTmsActeCode());
        acte.setNature(tmsActe.getTmsActeNature());
        acte.setDescription(tmsActe.getTmsActeNature());
        acte.setDateLastAct(tmsActe.getTmsActedateLastAct());
        acte.setPeriodicity(tmsActe.getTmsActePeriodicity());
        acte.setDuration(tmsActe.getTmsActeDuration());
        if (!lazy) {
           // acte.setMaintenancePlans(MaintenancePlanMapper.toDtos(tmsActe.getTmsActeMaintenancePlan(), true));
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

    public static List<Acte> toDtos(Iterable<TmsActe> tmsActes, boolean lazy) {
        if (null == tmsActes) {
            return null;
        }
        List<Acte> actes = new ArrayList<>();
        for (TmsActe tmsActe : tmsActes) {
            actes.add(toDto(tmsActe, lazy));
        }
        return actes;
    }

    public static Set<TmsActe> toEntities(Set<Acte> actes, boolean lazy) {
        if (null == actes) {
            return null;
        }
        Set<TmsActe> tmsActes = new HashSet<>();
        for (Acte acte : actes) {
            tmsActes.add(toEntity(acte, lazy));
        }
        return tmsActes;
    }

    public static Set<Acte> toDtos(Set<TmsActe> tmsActes, boolean lazy) {
        if (null == tmsActes) {
            return null;
        }
        Set<Acte> actes = new HashSet<>();
        for (TmsActe tmsDriver : tmsActes) {
            actes.add(toDto(tmsDriver, lazy));
        }
        return actes;
    }
}































