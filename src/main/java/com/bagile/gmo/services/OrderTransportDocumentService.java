package com.bagile.gmo.services;

import com.bagile.gmo.dto.OrderTransportDocument;
import com.bagile.gmo.exceptions.AttributesNotFound;
import com.bagile.gmo.exceptions.ErrorType;
import com.bagile.gmo.exceptions.IdNotFound;

import java.util.List;

public interface OrderTransportDocumentService {
    OrderTransportDocument save(OrderTransportDocument orderDocument );

    Long size();

    Boolean isExist(Long id);

    OrderTransportDocument findById(Long id) throws IdNotFound;

    List<OrderTransportDocument> find(String search) throws AttributesNotFound, ErrorType;

    List<OrderTransportDocument> find(String search, int page, int size) throws AttributesNotFound, ErrorType;

    Long size(String search) throws AttributesNotFound, ErrorType;
     String saveImage(OrderTransportDocument orderTransportDocument) ;
    void delete(Long id);
    List<OrderTransportDocument> saveAll(List<OrderTransportDocument> orderTransportDocuments)throws ErrorType, IdNotFound, AttributesNotFound;
    void delete(OrderTransportDocument orderDocument);
    void deleteAll(List<Long> ids);
    List<OrderTransportDocument> findAll();

    List<OrderTransportDocument> findAll(int page, int size);
}
