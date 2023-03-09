package com.bagile.gmo.mapper;

import com.bagile.gmo.dto.OrderTransportDocument;
import com.bagile.gmo.entities.TmsOrderTransportDocument;

import java.util.*;

public class OrderTransportDocumentMapper {
    private static Map<String, String> map;

    static {
        map = new HashMap<>();

        map.put("id", "tmsOrderTransportDocumentId");

        map.put("fileType", "tmsOrderTransportDocumentFileType");
        map.put("fileName", "tmsOrderTransportDocumentFileName");
        map.put("file", "tmsOrderTransportDocumentFile");

    }

    public static Map<String, String> getMap() {
        return map;
    }

    public static String getField(String key) {
        return map.get(key);
    }

    public static TmsOrderTransportDocument toEntity(OrderTransportDocument orderDocument, boolean lazy) {
        if (null == orderDocument) {
            return null;
        }
        TmsOrderTransportDocument tmsOrderTransportDocument = new TmsOrderTransportDocument();
        tmsOrderTransportDocument.setTmsOrderDocumentFile(orderDocument.getFile());
        tmsOrderTransportDocument.setTmsOrderDocumentId(orderDocument.getId());
        tmsOrderTransportDocument.setTmsOrderDocumentFileName(orderDocument.getFileName());
        tmsOrderTransportDocument.setTmsOrderDocumentFileType(orderDocument.getFileType());

        if(!lazy){
            tmsOrderTransportDocument.setTmsOrderTransportInfoLineDocument(OrderTransportInfoLineDocumentMapper.toEntity(orderDocument.getOrderTransportInfoLineDocument(),true));

        }
        return tmsOrderTransportDocument;
    }

    public static OrderTransportDocument toDto(TmsOrderTransportDocument tmsOrderTransportDocument, boolean lazy) {
        if (null == tmsOrderTransportDocument) {
            return null;
        }
        OrderTransportDocument orderDocument = new OrderTransportDocument();
        orderDocument.setId(tmsOrderTransportDocument.getTmsOrderDocumentId());
        orderDocument.setFile(tmsOrderTransportDocument.getTmsOrderDocumentFile());
        orderDocument.setFileName(tmsOrderTransportDocument.getTmsOrderDocumentFileName());
        orderDocument.setFileType(tmsOrderTransportDocument.getTmsOrderDocumentFileType());

        if(!lazy){
            orderDocument.setOrderTransportInfoLineDocument(OrderTransportInfoLineDocumentMapper.toDto(tmsOrderTransportDocument.getTmsOrderTransportInfoLineDocument(),true));

        }
        return orderDocument;

    }

    public static List<OrderTransportDocument> toDtos(Iterable<? extends TmsOrderTransportDocument> tmsOrderTransportDocuments, boolean lazy) {
        if (null == tmsOrderTransportDocuments) {
            return null;
        }
        List<OrderTransportDocument> orderDocuments = new ArrayList<>();

        for (TmsOrderTransportDocument tmsOrderTransportDocument : tmsOrderTransportDocuments) {
            orderDocuments.add(toDto(tmsOrderTransportDocument, lazy));
        }
        return orderDocuments;
    }

    public static Set<TmsOrderTransportDocument> toEntities(List<OrderTransportDocument> list, boolean lazy) {
        if (null == list) {
            return null;
        }
        Set<TmsOrderTransportDocument> tmsOrderTransportDocuments = new HashSet<>();
        for (OrderTransportDocument orderDocument : list) {
            tmsOrderTransportDocuments.add(toEntity(orderDocument, lazy));
        }
        return tmsOrderTransportDocuments;
    }

    public static List<OrderTransportDocument> toDtos(List<TmsOrderTransportDocument> tmsOrderTransportDocuments, boolean lazy) {
        if (null == tmsOrderTransportDocuments) {
            return null;
        }
        List<OrderTransportDocument> orderDocuments = new ArrayList<>();
        for (TmsOrderTransportDocument tmsOrderTransportDocument : tmsOrderTransportDocuments) {
            orderDocuments.add(toDto(tmsOrderTransportDocument, lazy));
        }
        return orderDocuments;
    }
}
