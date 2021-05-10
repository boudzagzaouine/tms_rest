package com.bagile.gmo.mapper;

import com.bagile.gmo.dto.Pump;
import com.bagile.gmo.entities.GmoPump;

import java.util.*;

public class PumpMapper {
    public PumpMapper() {
    }

    private static Map<String, String> map;

    static {
        map = new HashMap<> ( );

        map.put ("id", "gmoPumpId");
        map.put ("code", "gmoPumpCode");
        map.put ("description", "gmoPumpDescription");

        map.put ("quantity", "gmoPumpQuantity");
        map.put ("creationDate", "creationDate");
        map.put ("updateDate", "updateDate");
        map.put ("createdBy", "createdBy");
        map.put ("updatedBy", "updatedBy");
    }

    public static Map<String, String> getMap() {
        return map;
    }

    public static String getField(String key) {
        return map.get (key);
    }

    public static GmoPump toEntity(Pump pump, boolean lazy) {
        if (null == pump) {
            return null;
        }

        GmoPump gmoPump = new GmoPump ( );
        gmoPump.setGmoPumpId (pump.getId ( ));
        gmoPump.setGmoPumpCode (pump.getCode ( ) != null ? pump.getCode ( ).toUpperCase ( ) : null);
        gmoPump.setGmoPumpDescription (pump.getDescription ( ));

        gmoPump.setGmoPumpCapacity(pump.getCapacity( ));
        gmoPump.setCreatedBy (pump.getCreatedBy ( ));
        gmoPump.setUpdatedBy (pump.getUpdatedBy ( ));

        if (!lazy) {
           // gmoPump.setGmoPumpType (PumpTypeMapper.toEntity (pump.getPumpType ( ), true));
        }

        return gmoPump;

    }

    public static Pump toDto(GmoPump gmoPump, boolean lazy) {
        if (null == gmoPump) {
            return null;
        }
        Pump pump = new Pump ( );
        pump.setId (gmoPump.getGmoPumpId ());
        pump.setCode (gmoPump.getGmoPumpCode ());
        pump.setDescription (gmoPump.getGmoPumpDescription ());

        pump.setCapacity(gmoPump.getGmoPumpCapacity());

        pump.setCreatedBy (gmoPump.getCreatedBy ());
        pump.setUpdatedBy (gmoPump.getUpdatedBy ());
        pump.setCreationDate (gmoPump.getCreationDate ());
        pump.setUpdateDate (gmoPump.getUpdateDate ());

        if (!lazy) {
           // pump.setPumpType (PumpTypeMapper.toDto (gmoPump.getGmoPumpType(), true));
        }
        return pump;

    }


    public static List<Pump> toDtos(Iterable<? extends GmoPump> gmoPumps, boolean lazy) {
        if (null == gmoPumps) {
            return null;
        }
        List<Pump> pumps = new ArrayList<> ( );

        for (GmoPump gmoPump : gmoPumps) {
            pumps.add (toDto (gmoPump, lazy));
        }
        return pumps;
    }

    public static Set<GmoPump> toEntities(Set<Pump> pumps, boolean lazy) {
        if (null == pumps) {
            return null;
        }
        Set<GmoPump> gmoPumps = new HashSet<> ( );
        for (Pump pump : pumps) {
            gmoPumps.add (toEntity (pump, lazy));
        }
        return gmoPumps;
    }

    public static Set<Pump> toDtos(Set<GmoPump> gmoPumps, boolean lazy) {
        if (null == gmoPumps) {
            return null;
        }
        Set<Pump> pumps = new HashSet<> ( );
        for (GmoPump gmoPump : gmoPumps) {
            pumps.add (toDto (gmoPump, lazy));
        }
        return pumps;
    }
}
