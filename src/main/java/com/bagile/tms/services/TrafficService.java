package com.bagile.tms.services;

import com.bagile.tms.dto.Traffic;
import com.bagile.tms.exceptions.AttributesNotFound;
import com.bagile.tms.exceptions.ErrorType;
import com.bagile.tms.exceptions.IdNotFound;

import org.springframework.data.domain.Pageable;
import java.util.List;

public interface TrafficService {

    Traffic save(Traffic traffic);

    Long size();

    Boolean isExist(Long id);

    Traffic findById(Long id) throws IdNotFound;

    List<Traffic> find(String search) throws AttributesNotFound, ErrorType;

    List<Traffic> find(String search, Pageable pageable) throws AttributesNotFound, ErrorType;

    Long size(String search) throws AttributesNotFound, ErrorType;

    void delete(Long id);

    void delete(Traffic traffic);

    List<Traffic> findAll();

    List<Traffic> findAll(Pageable pageable) throws AttributesNotFound, ErrorType;
}
