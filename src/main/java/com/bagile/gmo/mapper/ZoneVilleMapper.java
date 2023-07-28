package com.bagile.gmo.mapper;

import com.bagile.gmo.dto.Owner;
import com.bagile.gmo.dto.ProductPack;
import com.bagile.gmo.dto.Zone;
import com.bagile.gmo.dto.ZoneVille;
import com.bagile.gmo.entities.GmoZone;
import com.bagile.gmo.entities.OwnOwner;
import com.bagile.gmo.entities.PdtProductPack;
import com.bagile.gmo.entities.TmsZoneVille;

import java.util.*;

public class ZoneVilleMapper {

    public ZoneVilleMapper() {
    }
    private static Map<String, String> map;

    static {
        map = new HashMap<>();

        map.put("id", "zoneVilleId");
        map.put("zone", "tmsZone");
        map.put("ville", "tmsVille");

    }
    public static Map<String, String> getMap() {
        return map;
    }
    public static String getField(String key) {
        return map.get(key);
    }
    public static TmsZoneVille toEntity(ZoneVille zoneVille, boolean lazy) {
        if (null == zoneVille) {
            return null;
        }
        TmsZoneVille tmsZoneVille  = new TmsZoneVille();
        tmsZoneVille.setZoneVilleId(zoneVille.getId());



        if(!lazy) {

            tmsZoneVille.setTmsZone(ZoneMapper.toEntity(zoneVille.getZone(),true));
            tmsZoneVille.setTmsVille(VilleMapper.toEntity(zoneVille.getVille(),true));

        }

        return tmsZoneVille;

    }
    public static ZoneVille toDto(TmsZoneVille tmsZoneVille, boolean lazy) {
        if (null == tmsZoneVille) {
            return null;
        }
        ZoneVille zoneVille = new ZoneVille();
        zoneVille.setId( tmsZoneVille.getZoneVilleId());


        if(!lazy){

            zoneVille.setZone(ZoneMapper.toDto(tmsZoneVille.getTmsZone(),true));
            zoneVille.setVille(VilleMapper.toDto(tmsZoneVille.getTmsVille(),true));

        }

        return zoneVille;

    }
    public static List<ZoneVille> toDtos(Iterable<? extends TmsZoneVille> tmsZoneVilles, boolean lazy) {
        if (null == tmsZoneVilles) {
            return null;
        }
        List<ZoneVille> zoneVilles = new ArrayList<>();
        for (TmsZoneVille tmsZoneVille : tmsZoneVilles) {
            zoneVilles.add(toDto(tmsZoneVille, lazy));
        }
        return zoneVilles;
    }
    public static Set<TmsZoneVille> toEntities(Set<ZoneVille> zoneVilles, boolean lazy) {
        if (null == zoneVilles) {
            return null;
        }
        Set<TmsZoneVille> tmsZoneVilles = new HashSet<>();
        for (ZoneVille zoneVille : zoneVilles) {
            tmsZoneVilles.add(toEntity(zoneVille, lazy));
        }
        return tmsZoneVilles;
    }
    public static Set<ZoneVille> toDtos(Set<TmsZoneVille> tmsZoneVilles, boolean lazy) {
        if (null == tmsZoneVilles) {
            return null;
        }
        Set<ZoneVille> zoneVilles = new HashSet<>();
        for (TmsZoneVille tmsZoneVille : tmsZoneVilles) {
            zoneVilles.add(toDto(tmsZoneVille, lazy));
        }
        return zoneVilles;
    }
}
