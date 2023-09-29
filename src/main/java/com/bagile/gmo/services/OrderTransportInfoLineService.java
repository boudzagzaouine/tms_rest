package com.bagile.gmo.services;

import com.bagile.gmo.dto.OrderTransportInfo;
import com.bagile.gmo.dto.OrderTransportInfoLine;
import com.bagile.gmo.exceptions.AttributesNotFound;
import com.bagile.gmo.exceptions.ErrorType;
import com.bagile.gmo.exceptions.IdNotFound;

import java.util.List;

public interface OrderTransportInfoLineService {
    OrderTransportInfoLine save(OrderTransportInfoLine orderTransportInfoLine);
    List<OrderTransportInfoLine> saveAll(List<OrderTransportInfoLine> orderTransportInfoLines) throws AttributesNotFound, ErrorType;

    Long size();

    Boolean isExist(Long id);

    OrderTransportInfoLine findById(Long id) throws IdNotFound;

    List<OrderTransportInfoLine> find(String search) throws AttributesNotFound, ErrorType;

    List<OrderTransportInfoLine> find(String search, int page, int size) throws AttributesNotFound, ErrorType;

    Long size(String search) throws AttributesNotFound, ErrorType;

    void delete(Long id);

    void delete(OrderTransportInfoLine orderTransportInfoLine);
    void deleteAll (List<Long> ids);

    List<OrderTransportInfoLine> findAll();

    List<OrderTransportInfoLine> findAll(int page, int size);

	OrderTransportInfoLine findOne(String search) throws AttributesNotFound, ErrorType;

}
