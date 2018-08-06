package com.bagile.tms.services;

import com.bagile.tms.dto.RoadState;
import com.bagile.tms.exceptions.AttributesNotFound;
import com.bagile.tms.exceptions.ErrorType;
import com.bagile.tms.exceptions.IdNotFound;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface RoadStateService {
    RoadState save(RoadState road);

    Long size();

    Boolean isExist(Long id);

    RoadState findById(Long id) throws IdNotFound;

    List<RoadState> find(String search) throws AttributesNotFound, ErrorType;

    List<RoadState> find(String search, Pageable pageable) throws AttributesNotFound, ErrorType;

    Long size(String search) throws AttributesNotFound, ErrorType;

    void delete(Long id);

    void delete(RoadState road);

    List<RoadState> findAll();

    List<RoadState> findAll(Pageable pageable);
}
