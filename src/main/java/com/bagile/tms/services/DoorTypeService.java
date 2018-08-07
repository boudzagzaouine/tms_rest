package com.bagile.tms.services;

import com.bagile.tms.dto.DoorType;
import com.bagile.tms.exceptions.AttributesNotFound;
import com.bagile.tms.exceptions.ErrorType;
import com.bagile.tms.exceptions.IdNotFound;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface DoorTypeService {
    DoorType save(DoorType doorType);

    Long size();

    Boolean isExist(Long id);

    DoorType findById(Long id) throws IdNotFound;

    List<DoorType> find(String search) throws AttributesNotFound, ErrorType;

    List<DoorType> find(String search, Pageable pageable) throws AttributesNotFound, ErrorType;

    Long size(String search) throws AttributesNotFound, ErrorType;

    void delete(Long id);

    void delete(DoorType doorType);

    List<DoorType> findAll();

    List<DoorType> findAll(Pageable pageable);
}
