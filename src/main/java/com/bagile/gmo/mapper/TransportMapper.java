package com.bagile.gmo.mapper;

import com.bagile.gmo.dto.Transport;
import com.bagile.gmo.entities.TrpTransport;

import java.util.*;

public class TransportMapper {

    public TransportMapper() {
    }

    private static Map<String, String> map;

    static {
        map = new HashMap<> ( );

        map.put ("id", "tmsBadgeId");
        map.put ("comment", "trpTransportComment");
        map.put ("code", "trpTransportCode");
        map.put ("name", "trpTransportName");
        map.put ("address", "adrAddress");
        map.put ("description", "trpTransportDescription");


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

    public static TrpTransport toEntity(Transport transport, boolean lazy) {
        if (null == transport) {
            return null;
        }

        TrpTransport trpTransport = new TrpTransport ( );
        trpTransport.setTrpTransportId (transport.getId ());
        trpTransport.setTrpTransportCode (transport.getCode ( ) != null ? transport.getCode ( ).toUpperCase ( ) : null);
        trpTransport.setTrpTransportDescription (transport.getDescription ( ));
        trpTransport.setTrpTransportComment (transport.getComment ( ));
        trpTransport.setTrpTransportName (transport.getName ( ));

        trpTransport.setCreatedBy (transport.getCreatedBy ( ));
        trpTransport.setUpdatedBy (transport.getUpdatedBy ( ));

        if (!lazy) {
            trpTransport.setAdrAddress (AddressMapper.toEntity (transport.getAddress ( ), true));
            trpTransport.setTmsTransportCategoryVehicles (TransportCategoryVehicleMapper.toEntities (transport.getTransportCategorieVehicules ( ), true));

        }

        return trpTransport;

    }

    public static Transport toDto(TrpTransport trpTransport, boolean lazy) {
        if (null == trpTransport) {
            return null;
        }
        Transport transport = new Transport ( );
        transport.setId ((int) trpTransport.getTrpTransportId ());
        transport.setCode (trpTransport.getTrpTransportCode ());
        transport.setDescription (trpTransport.getTrpTransportDescription ());
        transport.setComment (trpTransport.getTrpTransportComment ());

        transport.setName (trpTransport.getTrpTransportName ());

        transport.setCreatedBy (trpTransport.getCreatedBy ());
        transport.setUpdatedBy (trpTransport.getUpdatedBy ());
        transport.setCreationDate (trpTransport.getCreationDate ());
        transport.setUpdateDate (trpTransport.getUpdateDate ());

        if (!lazy) {
            transport.setAddress (AddressMapper.toDto(trpTransport.getAdrAddress(), true));
            transport.setTransportCategorieVehicules (TransportCategoryVehicleMapper.toDtos(trpTransport.getTmsTransportCategoryVehicles(), true));

        }
        return transport;

    }


    public static List<Transport> toDtos(Iterable<? extends TrpTransport> tmsTransports, boolean lazy) {
        if (null == tmsTransports) {
            return null;
        }
        List<Transport> transports = new ArrayList<> ( );

        for (TrpTransport trpTransport : tmsTransports) {
            transports.add (toDto (trpTransport, lazy));
        }
        return transports;
    }

    public static Set<TrpTransport> toEntities(Set<Transport> badges, boolean lazy) {
        if (null == badges) {
            return null;
        }
        Set<TrpTransport> tmsTransports = new HashSet<> ( );
        for (Transport transport : badges) {
            tmsTransports.add (toEntity (transport, lazy));
        }
        return tmsTransports;
    }

   /* public static Set<Transport> toDtos(Set<TrpTransport> tmsTransports, boolean lazy) {
        if (null == tmsTransports) {
            return null;
        }
        Set<Transport> badges = new HashSet<> ( );
        for (TrpTransport trpTransport : tmsTransports) {
            badges.add (toDto (trpTransport, lazy));
        }
        return badges;
    }*/
}
