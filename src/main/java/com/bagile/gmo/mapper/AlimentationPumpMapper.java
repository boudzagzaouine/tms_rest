package com.bagile.gmo.mapper;

import com.bagile.gmo.dto.AlimentationPump;
import com.bagile.gmo.entities.GmoAlimentationPump;

import java.util.*;

public class AlimentationPumpMapper {
    public AlimentationPumpMapper() {
    }

    private static Map<String, String> map;

    static {
        map = new HashMap<> ( );

        map.put ("id", "gmoAlimentationPumpId");
        map.put ("code", "gmoAlimentationPumpCode");
        map.put ("fuelPump", "gmoFuelPump");

        map.put ("quantity", "gmoAlimentationPumpQuantity");
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

    public static GmoAlimentationPump toEntity(AlimentationPump alimentationPump, boolean lazy) {
        if (null == alimentationPump) {
            return null;
        }

        GmoAlimentationPump gmoAlimentationPump = new GmoAlimentationPump ( );
        gmoAlimentationPump.setGmoAlimentationPumpId (alimentationPump.getId ( ));
      //  gmoAlimentationPump.setGmoAlimentationPumpCode (alimentationPump.getCode ( ) != null ? alimentationPump.getCode ( ).toUpperCase ( ) : null);
        gmoAlimentationPump.setGmoAlimentationQuantity(alimentationPump.getQuantity ( ));
        gmoAlimentationPump.setGmoAlimentationPumpdate(alimentationPump.getDateAlimentation ( ));

        gmoAlimentationPump.setCreatedBy (alimentationPump.getCreatedBy ( ));
        gmoAlimentationPump.setUpdatedBy (alimentationPump.getUpdatedBy ( ));

        if (!lazy) {
           gmoAlimentationPump.setGmoFuelPump (FuelPumpMapper.toEntity (alimentationPump.getFuelPump ( ), false));
          //  gmoAlimentationPump.setRcpReceptionLine (ReceptionLineMapper.toEntity (alimentationPump.getReceptionLine ( ), true));
            //gmoAlimentationPump.setRcpReception (ReceptionMapper.toEntity (alimentationPump.getReception ( ), true));

        }

        return gmoAlimentationPump;

    }

    public static AlimentationPump toDto(GmoAlimentationPump gmoAlimentationPump, boolean lazy) {
        if (null == gmoAlimentationPump) {
            return null;
        }
        AlimentationPump alimentationPump = new AlimentationPump ( );
        alimentationPump.setId (gmoAlimentationPump.getGmoAlimentationPumpId ());
       // alimentationPump.setCode (gmoAlimentationPump.getGmoAlimentationPumpCode ());
        alimentationPump.setQuantity (gmoAlimentationPump.getGmoAlimentationQuantity ());
        alimentationPump.setDateAlimentation (gmoAlimentationPump.getGmoAlimentationPumpdate ());


        alimentationPump.setCreatedBy (gmoAlimentationPump.getCreatedBy ());
        alimentationPump.setUpdatedBy (gmoAlimentationPump.getUpdatedBy ());
        alimentationPump.setCreationDate (gmoAlimentationPump.getCreationDate ());
        alimentationPump.setUpdateDate (gmoAlimentationPump.getUpdateDate ());

        if (!lazy) {
            alimentationPump.setFuelPump (FuelPumpMapper.toDto (gmoAlimentationPump.getGmoFuelPump(), false));
          //  alimentationPump.setReceptionLine (ReceptionLineMapper.toDto (gmoAlimentationPump.getRcpReceptionLine(), true));
           // alimentationPump.setReception (ReceptionMapper.toDto (gmoAlimentationPump.getRcpReception(), true));

        }
        return alimentationPump;

    }


    public static List<AlimentationPump> toDtos(Iterable<? extends GmoAlimentationPump> gmoAlimentationPumps, boolean lazy) {
        if (null == gmoAlimentationPumps) {
            return null;
        }
        List<AlimentationPump> alimentationPumps = new ArrayList<> ( );

        for (GmoAlimentationPump gmoAlimentationPump : gmoAlimentationPumps) {
            alimentationPumps.add (toDto (gmoAlimentationPump, lazy));
        }
        return alimentationPumps;
    }

    public static Set<GmoAlimentationPump> toEntities(Set<AlimentationPump> alimentationPumps, boolean lazy) {
        if (null == alimentationPumps) {
            return null;
        }
        Set<GmoAlimentationPump> gmoAlimentationPumps = new HashSet<> ( );
        for (AlimentationPump alimentationPump : alimentationPumps) {
            gmoAlimentationPumps.add (toEntity (alimentationPump, lazy));
        }
        return gmoAlimentationPumps;
    }

    public static Set<AlimentationPump> toDtos(Set<GmoAlimentationPump> gmoAlimentationPumps, boolean lazy) {
        if (null == gmoAlimentationPumps) {
            return null;
        }
        Set<AlimentationPump> alimentationPumps = new HashSet<> ( );
        for (GmoAlimentationPump gmoAlimentationPump : gmoAlimentationPumps) {
            alimentationPumps.add (toDto (gmoAlimentationPump, lazy));
        }
        return alimentationPumps;
    }
}
