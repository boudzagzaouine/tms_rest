package com.bagile.tms.services;

import com.bagile.tms.dto.Road;
import com.bagile.tms.exceptions.AttributesNotFound;
import com.bagile.tms.exceptions.ErrorType;
import com.bagile.tms.exceptions.IdNotFound;
import org.springframework.data.domain.Pageable;

import java.util.List;

/**
 * Created by bouzi on 4/3/2017.
 */
public interface RoadService {
    Road save(Road road);

    Long size();

    Boolean isExist(Long id);

    Road findById(Long id) throws IdNotFound;

    List<Road> find(String search) throws AttributesNotFound, ErrorType;

    List<Road> find(String search, Pageable pageable) throws AttributesNotFound, ErrorType;

    Long size(String search) throws AttributesNotFound, ErrorType;

    void delete(Long id);

    void delete(Road road);

    List<Road> findAll();

    List<Road> findAll(Pageable pageable);
}
