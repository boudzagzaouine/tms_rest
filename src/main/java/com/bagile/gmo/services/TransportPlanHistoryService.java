package com.bagile.gmo.services;

import com.bagile.gmo.dto.TransportPlanHistory;
import com.bagile.gmo.exceptions.AttributesNotFound;
import com.bagile.gmo.exceptions.ErrorType;
import com.bagile.gmo.exceptions.IdNotFound;

import java.util.List;

public interface TransportPlanHistoryService {
    TransportPlanHistory save(TransportPlanHistory transportPlanHistory);

    Long size();

    Boolean isExist(Long id);

    TransportPlanHistory findById(Long id) throws IdNotFound;

    List<TransportPlanHistory> find(String search) throws AttributesNotFound, ErrorType;

    List<TransportPlanHistory> find(String search, int page, int size) throws AttributesNotFound, ErrorType;

    Long size(String search) throws AttributesNotFound, ErrorType;

    void delete(Long id);

    void delete(TransportPlanHistory transportPlanHistory);
    void deleteAll (List<Long> ids);

    List<TransportPlanHistory> findAll();

    List<TransportPlanHistory> findAll(int page, int size);

	TransportPlanHistory findOne(String search) throws AttributesNotFound, ErrorType;

    String getNextVal();


}
