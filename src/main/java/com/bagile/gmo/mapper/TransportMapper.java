package com.bagile.gmo.mapper;

import com.bagile.gmo.dto.Transport;
import com.bagile.gmo.entities.AdrAddress;
import com.bagile.gmo.entities.PrmContact;
import com.bagile.gmo.entities.TrpTransport;

import java.util.*;

public class TransportMapper {

    public TransportMapper() {
    }

    private static Map<String, String> map;

    static {
        map = new HashMap<> ( );

        map.put ("id", "trpTransportId");
        map.put ("comment", "trpTransportComment");
        map.put ("code", "trpTransportCode");
        map.put ("name", "trpTransportName");
        map.put ("address", "adrAddress");
        map.put ("description", "trpTransportDescription");
        map.put ("active", "trpTransportIsActive");
        map.put ("gmao", "trpTransportGmao");
        map.put ("interneOrExterne", "trpTransportInterneOrExterne");
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
        trpTransport.setTrpTransportIsActive (transport.getActive ( ));
        trpTransport.setTrpTransportGmao (transport.getGmao ( ));
        trpTransport.setTrpTransportInterneOrExterne (transport.getInterneOrExterne ( ));

        trpTransport.setTrpTransportFactureTransport(transport.getFactureTransport ( ));
        trpTransport.setTrpTransportFactureService (transport.getFactureService ( ));

        trpTransport.setCreatedBy (transport.getCreatedBy ( ));
        trpTransport.setUpdatedBy (transport.getUpdatedBy ( ));

        if (!lazy) {
            AdrAddress adrAddress = AddressMapper.toEntity(transport.getAddress(), false);
            trpTransport.setAdrAddress(adrAddress);

            PrmContact prmContact = ContactMapper.toEntity(transport.getContact(), false);
            trpTransport.setPrmContact(prmContact);

            trpTransport.setGmoTransportCategoryVehicles (TransportCategoryVehicleMapper.toEntities (transport.getTransportCategorieVehicules ( ), true));
            trpTransport.setOwnOwner (OwnerMapper.toEntity (transport.getOwner ( ), true));



        }

        return trpTransport;

    }



    public static Transport toDto(TrpTransport trpTransport, boolean lazy) {
        if (null == trpTransport) {
            return null;
        }
        Transport transport = new Transport ( );
        transport.setId (trpTransport.getTrpTransportId ());
        transport.setCode (trpTransport.getTrpTransportCode ());
        transport.setDescription (trpTransport.getTrpTransportDescription ());
        transport.setComment (trpTransport.getTrpTransportComment ());
        transport.setName (trpTransport.getTrpTransportName ());

        transport.setActive (trpTransport.getTrpTransportIsActive ());
        transport.setGmao (trpTransport.getTrpTransportGmao ());
        transport.setInterneOrExterne (trpTransport.getTrpTransportInterneOrExterne ());

        transport.setFactureTransport (trpTransport.getTrpTransportFactureTransport ());
        transport.setFactureService (trpTransport.getTrpTransportFactureService ());

        transport.setCreatedBy (trpTransport.getCreatedBy ());
        transport.setUpdatedBy (trpTransport.getUpdatedBy ());
        transport.setCreationDate (trpTransport.getCreationDate ());
        transport.setUpdateDate (trpTransport.getUpdateDate ());

        if (!lazy) {
            transport.setAddress(AddressMapper.toDto(trpTransport.getAdrAddress(), false));

            transport.setTransportCategorieVehicules (TransportCategoryVehicleMapper.toDtos(trpTransport.getGmoTransportCategoryVehicles(), true));
            transport.setOwner (OwnerMapper.toDto(trpTransport.getOwnOwner(), true));
            transport.setContact (ContactMapper.toDto(trpTransport.getPrmContact(), true));

        }
        return transport;

    }


    public static List<Transport> toDtos(Iterable<? extends TrpTransport> gmoTransports, boolean lazy) {
        if (null == gmoTransports) {
            return null;
        }
        List<Transport> transports = new ArrayList<> ( );

        for (TrpTransport trpTransport : gmoTransports) {
            transports.add (toDto (trpTransport, lazy));
        }
        return transports;
    }

    public static Set<TrpTransport> toEntities(Set<Transport> badges, boolean lazy) {
        if (null == badges) {
            return null;
        }
        Set<TrpTransport> gmoTransports = new HashSet<> ( );
        for (Transport transport : badges) {
            gmoTransports.add (toEntity (transport, lazy));
        }
        return gmoTransports;
    }

   /* public static Set<Transport> toDtos(Set<TrpTransport> gmoTransports, boolean lazy) {
        if (null == gmoTransports) {
            return null;
        }
        Set<Transport> badges = new HashSet<> ( );
        for (TrpTransport trpTransport : gmoTransports) {
            badges.add (toDto (trpTransport, lazy));
        }
        return badges;
    }*/
}
