package com.bagile.tms.services;

import com.bagile.tms.dto.DeliveryLine;
import com.bagile.tms.exceptions.AttributesNotFound;
import com.bagile.tms.exceptions.CustomException;
import com.bagile.tms.exceptions.ErrorType;
import com.bagile.tms.exceptions.IdNotFound;

import org.springframework.data.domain.Pageable;

import java.math.BigDecimal;
import java.util.List;


public interface DeliveryLineService {
    DeliveryLine save(DeliveryLine deliveryLine) ;

    Long size();

    Boolean isExist(Long id);

    DeliveryLine findById(Long id) throws IdNotFound;

    List<DeliveryLine> find(String search) throws AttributesNotFound, ErrorType;

    List<DeliveryLine> find(String search, int page, int size) throws AttributesNotFound, ErrorType;

    Long size(String search) throws AttributesNotFound, ErrorType;

    void delete(Long id);

    void delete(DeliveryLine deliveryLine);

    List<DeliveryLine> findAll();

    List<DeliveryLine> findAll(int page, int size);


    void updateDeliveryLine(DeliveryLine deliveryLine, BigDecimal quantiyServed);

    void cancel(DeliveryLine deliveryLine) throws IdNotFound, CustomException, AttributesNotFound, ErrorType;
}
