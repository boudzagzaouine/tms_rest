package com.bagile.tms.mapper;

import com.bagile.tms.dto.Badge;
import com.bagile.tms.dto.Vacation;
import com.bagile.tms.entities.TmsBadge;
import com.bagile.tms.entities.TmsVacation;

import java.util.*;

public class VacationMapper {
    private VacationMapper() {

        }
        private static Map<String, String> map;

        static {
            map = new HashMap<>();
            map.put("id", "tmsVacationId");
            map.put("begin", "tmsVacationBegin");
            map.put("end", "tmsVacationEnd");
            map.put("type", "tmsVacationType");
        }

        public static Map<String, String> getMap() {
            return map;
        }

        public String getField(String key) {
            return map.get(key);
        }

        public static TmsVacation toEntity(Vacation vacation, boolean lazy) {
            if (null == vacation) {
                return null;
            }
            TmsVacation tmsVacation = new TmsVacation();
            tmsVacation.setTmsVacationId(vacation.getId());
            tmsVacation.setTmsVacationBegin(vacation.getBegin());
            tmsVacation.setTmsVacationEnd(vacation.getEnd());
            tmsVacation.setTmsVacationType(vacation.getType());

            return tmsVacation;
        }

        public static Vacation toDto(TmsVacation tmsVacation, boolean lazy) {
            if (null == tmsVacation) {
                return null;
            }
            Vacation vacation = new Vacation();

            vacation.setId(tmsVacation.getTmsVacationId());
            vacation.setBegin(tmsVacation.getTmsVacationBegin());
            vacation.setEnd(tmsVacation.getTmsVacationEnd());
            vacation.setType(tmsVacation.getTmsVacationType());

            return vacation;
        }

        public static List<Vacation> toDtos(List<TmsVacation> tmsVacations, boolean lazy) {
            if (null == tmsVacations) {
                return null;
            }
            List<Vacation> vacations = new ArrayList<>();
            for (TmsVacation tmsVacation : tmsVacations) {
                vacations.add(toDto(tmsVacation, lazy));

            }
            return vacations;
        }
        public static List<Vacation> toDtos(Iterable<TmsVacation> tmsVacations, boolean lazy) {
            if (null == tmsVacations) {
                return null;
            }
            List<Vacation> vacations = new ArrayList<>();
            for (TmsVacation tmsVacation : tmsVacations) {
                vacations.add(toDto(tmsVacation, lazy));
            }
            return vacations;
        }
        public static Set<TmsVacation> toEntities(Set<Vacation>vacations, boolean lazy){
            if (null == vacations) {
                return null;
            }
            Set<TmsVacation> tmsVacations = new HashSet<>();
            for(Vacation vacation:vacations){
                tmsVacations.add(toEntity(vacation,lazy));
            }
            return tmsVacations;
        }
        public static Set<Vacation> toDtos(Set<TmsVacation> tmsVacations, boolean lazy){
            if(null == tmsVacations){
                return null;
            }
            Set<Vacation> vacations = new HashSet<>();
            for(TmsVacation tmsVacation : tmsVacations){
                vacations.add(toDto(tmsVacation,lazy));
            }
            return vacations;
        }

    }