package com.bagile.gmo.mapper;

import com.bagile.gmo.dto.OrderTransportDocumentType;
import com.bagile.gmo.entities.TmsOrderTransportDocumentType;

import java.util.*;

public class OrderTransportDocumentTypeMapper {
    private static Map<String, String> map;

    static {
        map = new HashMap<>();

        map.put("id", "tmsOrderTransportDocumentTypeId");

        map.put("code", "tmsOrderTransportDocumentTypeFileName");
        map.put("description", "tmsOrderTransportDocumentTypeDescription");

    }

    public static Map<String, String> getMap() {
        return map;
    }

    public static String getField(String key) {
        return map.get(key);
    }

    public static TmsOrderTransportDocumentType toEntity(OrderTransportDocumentType orderDocument, boolean lazy) {
        if (null == orderDocument) {
            return null;
        }
        TmsOrderTransportDocumentType tmsOrderTransportDocumentType = new TmsOrderTransportDocumentType();
        tmsOrderTransportDocumentType.setTmsOrderTransportDocumentTypeId(orderDocument.getId());
        tmsOrderTransportDocumentType.setTmsOrderTransportDocumentTypeCode(orderDocument.getCode());
        tmsOrderTransportDocumentType.setTmsOrderTransportDocumentTypeDescription(orderDocument.getDescription());

        if(!lazy){

        }
        return tmsOrderTransportDocumentType;
    }

    public static OrderTransportDocumentType toDto(TmsOrderTransportDocumentType tmsOrderTransportDocumentType, boolean lazy) {
        if (null == tmsOrderTransportDocumentType) {
            return null;
        }
        OrderTransportDocumentType orderDocument = new OrderTransportDocumentType();
        orderDocument.setId(tmsOrderTransportDocumentType.getTmsOrderTransportDocumentTypeId());
        orderDocument.setCode(tmsOrderTransportDocumentType.getTmsOrderTransportDocumentTypeCode());
        orderDocument.setDescription(tmsOrderTransportDocumentType.getTmsOrderTransportDocumentTypeDescription());

        if(!lazy){

        }
        return orderDocument;

    }

    public static List<OrderTransportDocumentType> toDtos(Iterable<? extends TmsOrderTransportDocumentType> tmsOrderTransportDocumentTypes, boolean lazy) {
        if (null == tmsOrderTransportDocumentTypes) {
            return null;
        }
        List<OrderTransportDocumentType> orderDocuments = new ArrayList<>();

        for (TmsOrderTransportDocumentType tmsOrderTransportDocumentType : tmsOrderTransportDocumentTypes) {
            orderDocuments.add(toDto(tmsOrderTransportDocumentType, lazy));
        }
        return orderDocuments;
    }

    public static Set<TmsOrderTransportDocumentType> toEntities(List<OrderTransportDocumentType> list, boolean lazy) {
        if (null == list) {
            return null;
        }
        Set<TmsOrderTransportDocumentType> tmsOrderTransportDocumentTypes = new HashSet<>();
        for (OrderTransportDocumentType orderDocument : list) {
            tmsOrderTransportDocumentTypes.add(toEntity(orderDocument, lazy));
        }
        return tmsOrderTransportDocumentTypes;
    }

    public static List<OrderTransportDocumentType> toDtos(List<TmsOrderTransportDocumentType> tmsOrderTransportDocumentTypes, boolean lazy) {
        if (null == tmsOrderTransportDocumentTypes) {
            return null;
        }
        List<OrderTransportDocumentType> orderDocuments = new ArrayList<>();
        for (TmsOrderTransportDocumentType tmsOrderTransportDocumentType : tmsOrderTransportDocumentTypes) {
            orderDocuments.add(toDto(tmsOrderTransportDocumentType, lazy));
        }
        return orderDocuments;
    }
}
