package com.bagile.gmo.services;

import com.bagile.gmo.dto.CatalogTransportPricing;
import com.bagile.gmo.dto.OrderTransportInfoLineDocument;
import com.bagile.gmo.exceptions.AttributesNotFound;
import com.bagile.gmo.exceptions.ErrorType;
import com.bagile.gmo.exceptions.IdNotFound;

import java.util.List;

public interface OrderTransportInfoLineDocumentService {
    OrderTransportInfoLineDocument save(OrderTransportInfoLineDocument orderTransportInfoLineDocument);
    List<OrderTransportInfoLineDocument> saveAll(List<OrderTransportInfoLineDocument> orderTransportInfoLineDocuments) throws AttributesNotFound, ErrorType;

    Long size();

    Boolean isExist(Long id);

    OrderTransportInfoLineDocument findById(Long id) throws IdNotFound;

    List<OrderTransportInfoLineDocument> find(String search) throws AttributesNotFound, ErrorType;

    List<OrderTransportInfoLineDocument> find(String search, int page, int size) throws AttributesNotFound, ErrorType;

    Long size(String search) throws AttributesNotFound, ErrorType;

    void delete(Long id) throws ErrorType, AttributesNotFound;

    void delete(OrderTransportInfoLineDocument orderTransportInfoLineDocument) throws ErrorType, AttributesNotFound;
    void deleteAll (List<Long> ids);
    List<OrderTransportInfoLineDocument> findAll();

    List<OrderTransportInfoLineDocument> findAll(int page, int size);
}
