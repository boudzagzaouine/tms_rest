package com.bagile.gmo.services;

import com.bagile.gmo.dto.TransportPlanLocation;
import com.bagile.gmo.exceptions.AttributesNotFound;
import com.bagile.gmo.exceptions.ErrorType;
import com.bagile.gmo.exceptions.IdNotFound;

import java.io.IOException;
import java.util.List;

public interface TransportPlanLocationService {
    TransportPlanLocation save(TransportPlanLocation transportPlanLocation) throws IdNotFound, ErrorType, IOException, AttributesNotFound;

    Long size();

    Boolean isExist(Long id);

    TransportPlanLocation findById(Long id) throws IdNotFound;

    List<TransportPlanLocation> find(String search) throws AttributesNotFound, ErrorType;

    List<TransportPlanLocation> find(String search, int page, int size) throws AttributesNotFound, ErrorType;

    Long size(String search) throws AttributesNotFound, ErrorType;

    void delete(Long id);

    void delete(TransportPlanLocation transportPlanLocation);
    void deleteAll (List<Long> ids);

    List<TransportPlanLocation> findAll();

    List<TransportPlanLocation> findAll(int page, int size);


}
