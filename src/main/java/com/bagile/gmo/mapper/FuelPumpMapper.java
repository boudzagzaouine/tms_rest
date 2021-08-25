package com.bagile.gmo.mapper;

import com.bagile.gmo.dto.FuelPump;
import com.bagile.gmo.entities.GmoFuelPump;

import java.util.*;

public class FuelPumpMapper {
    public FuelPumpMapper() {
    }

    private static Map<String, String> map;

    static {
        map = new HashMap<> ( );

        map.put ("id", "gmoFuelPumpId");
        map.put ("code", "gmoFuelPumpCode");

        map.put ("product", "pdtProduct");
        map.put ("pump", "gmoPump");


        map.put ("quantity", "gmoFuelPumpQuantity");

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

    public static GmoFuelPump toEntity(FuelPump fuelPump, boolean lazy) {
        if (null == fuelPump) {
            return null;
        }

        GmoFuelPump gmoFuelPump = new GmoFuelPump ( );
        gmoFuelPump.setGmoFuelPumpId (fuelPump.getId ( ));
        gmoFuelPump.setGmoFuelPumpCode (fuelPump.getCode ( ) != null ? fuelPump.getCode ( ).toUpperCase ( ) : null);
        gmoFuelPump.setGmoFuelPumpQuantity (fuelPump.getQuantity ( ));

        gmoFuelPump.setCreatedBy (fuelPump.getCreatedBy ( ));
        gmoFuelPump.setUpdatedBy (fuelPump.getUpdatedBy ( ));

        if (!lazy) {
           gmoFuelPump.setPdtProduct (ProductMapper.toEntity (fuelPump.getProduct ( ), false));
            gmoFuelPump.setGmoPump(PumpMapper.toEntity (fuelPump.getPump ( ), true));
            gmoFuelPump.setLocLocation(LocationMapper.toEntity (fuelPump.getLocation ( ), true));

        }

        return gmoFuelPump;

    }

    public static FuelPump toDto(GmoFuelPump gmoFuelPump, boolean lazy) {
        if (null == gmoFuelPump) {
            return null;
        }
        FuelPump fuelPump = new FuelPump ( );
        fuelPump.setId (gmoFuelPump.getGmoFuelPumpId ());
        fuelPump.setCode (gmoFuelPump.getGmoFuelPumpCode ());
        fuelPump.setQuantity (gmoFuelPump.getGmoFuelPumpQuantity ());


        fuelPump.setCreatedBy (gmoFuelPump.getCreatedBy ());
        fuelPump.setUpdatedBy (gmoFuelPump.getUpdatedBy ());
        fuelPump.setCreationDate (gmoFuelPump.getCreationDate ());
        fuelPump.setUpdateDate (gmoFuelPump.getUpdateDate ());

        if (!lazy) {
            fuelPump.setProduct (ProductMapper.toDto (gmoFuelPump.getPdtProduct(), false));
            fuelPump.setPump(PumpMapper.toDto (gmoFuelPump.getGmoPump(), true));
            fuelPump.setLocation(LocationMapper.toDto (gmoFuelPump.getLocLocation(), true));

        }
        return fuelPump;

    }


    public static List<FuelPump> toDtos(Iterable<? extends GmoFuelPump> gmoFuelPumps, boolean lazy) {
        if (null == gmoFuelPumps) {
            return null;
        }
        List<FuelPump> fuelPumps = new ArrayList<> ( );

        for (GmoFuelPump gmoFuelPump : gmoFuelPumps) {
            fuelPumps.add (toDto (gmoFuelPump, lazy));
        }
        return fuelPumps;
    }

    public static Set<GmoFuelPump> toEntities(Set<FuelPump> fuelPumps, boolean lazy) {
        if (null == fuelPumps) {
            return null;
        }
        Set<GmoFuelPump> gmoFuelPumps = new HashSet<> ( );
        for (FuelPump fuelPump : fuelPumps) {
            gmoFuelPumps.add (toEntity (fuelPump, lazy));
        }
        return gmoFuelPumps;
    }

    public static Set<FuelPump> toDtos(Set<GmoFuelPump> gmoFuelPumps, boolean lazy) {
        if (null == gmoFuelPumps) {
            return null;
        }
        Set<FuelPump> fuelPumps = new HashSet<> ( );
        for (GmoFuelPump gmoFuelPump : gmoFuelPumps) {
            fuelPumps.add (toDto (gmoFuelPump, lazy));
        }
        return fuelPumps;
    }
}
