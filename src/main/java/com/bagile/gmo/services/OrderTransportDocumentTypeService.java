package com.bagile.gmo.services;

import com.bagile.gmo.dto.OrderTransportDocumentType;
import com.bagile.gmo.exceptions.AttributesNotFound;
import com.bagile.gmo.exceptions.ErrorType;
import com.bagile.gmo.exceptions.IdNotFound;

import java.util.List;

public interface OrderTransportDocumentTypeService {
    OrderTransportDocumentType save(OrderTransportDocumentType orderTransportDocumentType );

    Long size();

    Boolean isExist(Long id);

    OrderTransportDocumentType findById(Long id) throws IdNotFound;

    List<OrderTransportDocumentType> find(String search) throws AttributesNotFound, ErrorType;

    List<OrderTransportDocumentType> find(String search, int page, int size) throws AttributesNotFound, ErrorType;

    Long size(String search) throws AttributesNotFound, ErrorType;

    void delete(Long id);

    void delete(OrderTransportDocumentType orderTransportDocumentType);
    void deleteAll(List<Long> ids);
    List<OrderTransportDocumentType> findAll();

    List<OrderTransportDocumentType> findAll(int page, int size);
}
