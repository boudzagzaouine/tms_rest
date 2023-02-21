package com.bagile.gmo.services;

import com.bagile.gmo.dto.TransportPlan;
import com.bagile.gmo.exceptions.AttributesNotFound;
import com.bagile.gmo.exceptions.ErrorType;
import com.bagile.gmo.exceptions.IdNotFound;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface TransportPlanService {
    TransportPlan save(TransportPlan transportPlan);

    Long size();

    Boolean isExist(Long id);

    TransportPlan findById(Long id) throws IdNotFound;

    List<TransportPlan> find(String search) throws AttributesNotFound, ErrorType;

    List<TransportPlan> find(String search, int page, int size) throws AttributesNotFound, ErrorType;

    Long size(String search) throws AttributesNotFound, ErrorType;

    void delete(Long id);

    void delete(TransportPlan transportPlan);
    void deleteAll (List<Long> ids);

    List<TransportPlan> findAll();

    List<TransportPlan> findAll(int page, int size);

	TransportPlan findOne(String search) throws AttributesNotFound, ErrorType;

    String getNextVal();

    TransportPlan getLastPriceTransport(String search)  throws ErrorType, AttributesNotFound;
    List<TransportPlan> getLastPriceTransports(String search)  throws ErrorType, AttributesNotFound;

    byte[] exportInvoiceState(String search)  throws ErrorType, AttributesNotFound;


}
