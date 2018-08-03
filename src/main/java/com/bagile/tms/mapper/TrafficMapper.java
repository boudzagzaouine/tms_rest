package com.bagile.tms.mapper;

import com.bagile.tms.dto.Category;
import com.bagile.tms.dto.Traffic;
import com.bagile.tms.entities.TmsCategory;
import com.bagile.tms.entities.TmsTraffic;

import java.util.*;

public class TrafficMapper  {
        private TrafficMapper() {

        }

        private static Map<String, String> map;

        static {
            map = new HashMap<>();
            map.put("id", "tmsTrafficId");
            map.put("active", "tmsTrafficAcive");
            map.put("date", "tmsTrafficDate");
        }
        public static Map<String, String> getMap() {
            return map;
        }
        public String getField(String key) {
            return map.get(key);
        }

        public static TmsTraffic toEntity(Traffic traffic, boolean lazy) {
            if (null == traffic) {
                return null;
            }
            TmsTraffic tmsTraffic = new TmsTraffic();

            tmsTraffic.setTmsTrafficId(traffic.getId());
            tmsTraffic.setTmsTrafficActive(traffic.isActive());
            tmsTraffic.setTmsTrafficDate(traffic.getDate());

            return tmsTraffic;
        }

        public static Traffic toDto(TmsTraffic tmsTraffic, boolean lazy) {
            if (null == tmsTraffic) {
                return null;
            }
            Traffic traffic = new Traffic();

            traffic.setId(tmsTraffic.getTmsTrafficId());
            traffic.setActive(tmsTraffic.isTmsTrafficActive());
            traffic.setDate(tmsTraffic.getTmsTrafficDate());

            return traffic;
        }

    public static List<Traffic> toDtos(List<TmsTraffic> tmsTraffics, boolean lazy) {
        if (null == tmsTraffics) {
            return null;
        }
        List<Traffic> traffics= new ArrayList<>();
        for (TmsTraffic tmsTraffic : tmsTraffics) {
            traffics.add(toDto(tmsTraffic, lazy));
        }
        return traffics;
    }

    public static List<Traffic> toDtos(Iterable<TmsTraffic> tmsTraffics, boolean lazy) {
        if (null == tmsTraffics) {
            return null;
        }
        List<Traffic> traffics = new ArrayList<>();
        for (TmsTraffic tmsTraffic : tmsTraffics) {
            traffics.add(toDto(tmsTraffic, lazy));
        }
        return traffics;
    }

    public static Set<TmsTraffic> toEntities(Set<Traffic> traffics, boolean lazy) {
        if (null == traffics) {
            return null;
        }
        Set<TmsTraffic> TmsTraffics = new HashSet<>();
        for (Traffic traffic : traffics) {
            TmsTraffics.add(toEntity(traffic, lazy));
        }
        return TmsTraffics;
    }

    public static Set<Traffic> toDtos(Set<TmsTraffic> TmsTraffics, boolean lazy) {
        if (null == TmsTraffics) {
            return null;
        }
        Set<Traffic> traffics = new HashSet<>();
        for (TmsTraffic tmsTraffic : TmsTraffics) {
            traffics.add(toDto(tmsTraffic, lazy));
        }
        return traffics;
    }

    }
