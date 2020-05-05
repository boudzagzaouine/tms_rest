package com.bagile.gmo.services;

import com.bagile.gmo.dto.ConsumptionType;
import com.bagile.gmo.exceptions.AttributesNotFound;
import com.bagile.gmo.exceptions.ErrorType;
import com.bagile.gmo.exceptions.IdNotFound;

import java.util.List;


public interface ConsumptionTypeService {
    ConsumptionType save(ConsumptionType consumptionType);

    Long size();

    Boolean isExist(Long id);

    ConsumptionType findById(Long id) throws IdNotFound;

    List<ConsumptionType> find(String search) throws AttributesNotFound, ErrorType;

    List<ConsumptionType> find(String search, int page, int size) throws AttributesNotFound, ErrorType;

    Long size(String search) throws AttributesNotFound, ErrorType;

    void delete(Long id);

    void delete(ConsumptionType consumptionType);
    void deleteAll (List<Long> ids);

    List<ConsumptionType> findAll();

    List<ConsumptionType> findAll(int page, int size);
}
