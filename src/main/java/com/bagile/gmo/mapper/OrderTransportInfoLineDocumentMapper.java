package com.bagile.gmo.mapper;

import com.bagile.gmo.dto.OrderTransportInfoLineDocument;
import com.bagile.gmo.entities.TmsOrderTransportInfoLine;
import com.bagile.gmo.entities.TmsOrderTransportInfoLineDocument;

import java.util.*;

public class OrderTransportInfoLineDocumentMapper {
    public OrderTransportInfoLineDocumentMapper() {
    }

    private static Map<String, String> map;

    static {
        map = new HashMap<>();

        map.put("id", "tmsOrderTransportInfoLineDocumentId");
        map.put("orderTransportInfoLine", "tmsOrderTransportInfoLine");

        map.put("documentStatus", "tmsDocumentStatus");
        map.put("contreType", "tmsOrderTransportInfoLineDocumentContreType");
        map.put("type", "tmsOrderTransportInfoLineDocumentType");

    }

    public static Map<String, String> getMap() {
        return map;
    }

    public static String getField(String key) {
        return map.get(key);
    }

    public static TmsOrderTransportInfoLineDocument toEntity(OrderTransportInfoLineDocument orderTransportInfoLineDocument, boolean lazy) {
        if (null == orderTransportInfoLineDocument) {
            return null;
        }
        TmsOrderTransportInfoLineDocument gmoOrderTransportInfoLineDocument = new TmsOrderTransportInfoLineDocument();
        gmoOrderTransportInfoLineDocument.setTmsOrderTransportInfoLineDocumentId(orderTransportInfoLineDocument.getId());
        gmoOrderTransportInfoLineDocument.setTmsOrderTransportInfoLineDocumentDate(orderTransportInfoLineDocument.getDate());
        gmoOrderTransportInfoLineDocument.setTmsDocumentStatus(orderTransportInfoLineDocument.getDocumentStatus());

        gmoOrderTransportInfoLineDocument.setTmsOrderTransportInfoLineDocumentContreType(orderTransportInfoLineDocument.getContreType());
        gmoOrderTransportInfoLineDocument.setTmsOrderTransportInfoLineDocumentType(orderTransportInfoLineDocument.getType());
        gmoOrderTransportInfoLineDocument.setTmsOrderTransportInfoLineDocumentNumero(orderTransportInfoLineDocument.getNumero());


        if (!lazy) {
            gmoOrderTransportInfoLineDocument.setOwnOwner(OwnerMapper.toEntity(orderTransportInfoLineDocument.getOwner(), true));
            gmoOrderTransportInfoLineDocument.setTmsOrderTransportInfoLine(OrderTransportInfoLineMapper.toEntity(orderTransportInfoLineDocument.getOrderTransportInfoLine(), true));
            gmoOrderTransportInfoLineDocument.setTmsOrderTransportInfoLineDocumentDocumentType(OrderTransportDocumentTypeMapper.toEntity(orderTransportInfoLineDocument.getOrderTransportDocumentType(), true));

            oneToMany(gmoOrderTransportInfoLineDocument);

        }
        return gmoOrderTransportInfoLineDocument;
    }

    private static void oneToMany(TmsOrderTransportInfoLineDocument tmsOrderTransportInfoLineDocument) {
        //tmsOrderTransportInfoLineDocument.getTmsOrderTransportDocumentSet().forEach(
        //	e->{
        //		if(0>=e.getTmsOrderDocumentId())
        //			e.setTmsOrderDocumentId(0L);
        //			e.setCreationDate(new Date());
        //			e.setTmsOrderTransportInfoLineDocument(tmsOrderTransportInfoLineDocument);
        //		}
        //);
    }

    public static OrderTransportInfoLineDocument toDto(TmsOrderTransportInfoLineDocument gmoOrderTransportInfoLineDocument, boolean lazy) {
        if (null == gmoOrderTransportInfoLineDocument) {
            return null;
        }
        OrderTransportInfoLineDocument orderTransportInfoLineDocument = new OrderTransportInfoLineDocument();
        orderTransportInfoLineDocument.setId(gmoOrderTransportInfoLineDocument.getTmsOrderTransportInfoLineDocumentId());
        orderTransportInfoLineDocument.setDate(gmoOrderTransportInfoLineDocument.getTmsOrderTransportInfoLineDocumentDate());
        orderTransportInfoLineDocument.setDocumentStatus(gmoOrderTransportInfoLineDocument.getTmsDocumentStatus());
        orderTransportInfoLineDocument.setContreType(gmoOrderTransportInfoLineDocument.getTmsOrderTransportInfoLineDocumentContreType());
        orderTransportInfoLineDocument.setType(gmoOrderTransportInfoLineDocument.getTmsOrderTransportInfoLineDocumentType());
        orderTransportInfoLineDocument.setNumero(gmoOrderTransportInfoLineDocument.getTmsOrderTransportInfoLineDocumentNumero());

        if (!lazy) {
            orderTransportInfoLineDocument.setOrderTransportInfoLine(OrderTransportInfoLineMapper.toDto(gmoOrderTransportInfoLineDocument.getTmsOrderTransportInfoLine(), true));
            orderTransportInfoLineDocument.setOrderTransportDocumentType(OrderTransportDocumentTypeMapper.toDto(gmoOrderTransportInfoLineDocument.getTmsOrderTransportInfoLineDocumentDocumentType(), true));

            orderTransportInfoLineDocument.setOwner(OwnerMapper.toDto(gmoOrderTransportInfoLineDocument.getOwnOwner(), true));

        }
        return orderTransportInfoLineDocument;

    }


    public static List<OrderTransportInfoLineDocument> toDtos(Iterable<? extends TmsOrderTransportInfoLineDocument> gmoOrderTransportInfoLineDocuments, boolean lazy) {
        if (null == gmoOrderTransportInfoLineDocuments) {
            return null;
        }
        List<OrderTransportInfoLineDocument> orderTransportInfoLineDocuments = new ArrayList<>();

        for (TmsOrderTransportInfoLineDocument gmoOrderTransportInfoLineDocument : gmoOrderTransportInfoLineDocuments) {
            orderTransportInfoLineDocuments.add(toDto(gmoOrderTransportInfoLineDocument, lazy));
        }
        return orderTransportInfoLineDocuments;
    }

    public static Set<TmsOrderTransportInfoLineDocument> toEntities(List<OrderTransportInfoLineDocument> list, boolean lazy) {
        if (null == list) {
            return null;
        }
        Set<TmsOrderTransportInfoLineDocument> gmoOrderTransportInfoLineDocuments = new HashSet<>();
        for (OrderTransportInfoLineDocument orderTransportInfoLineDocument : list) {
            gmoOrderTransportInfoLineDocuments.add(toEntity(orderTransportInfoLineDocument, lazy));
        }
        return gmoOrderTransportInfoLineDocuments;
    }

    public static List<OrderTransportInfoLineDocument> toDtos(List<TmsOrderTransportInfoLineDocument> gmoOrderTransportInfoLineDocuments, boolean lazy) {
        if (null == gmoOrderTransportInfoLineDocuments) {
            return null;
        }
        List<OrderTransportInfoLineDocument> orderTransportInfoLineDocuments = new ArrayList<>();
        for (TmsOrderTransportInfoLineDocument gmoOrderTransportInfoLineDocument : gmoOrderTransportInfoLineDocuments) {
            orderTransportInfoLineDocuments.add(toDto(gmoOrderTransportInfoLineDocument, lazy));
        }
        return orderTransportInfoLineDocuments;
    }
}
