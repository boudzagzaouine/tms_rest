package com.sinno.ems.service;

import com.sinno.ems.dto.MovementType;
import com.sinno.ems.exception.AttributesNotFound;
import com.sinno.ems.exception.ErrorType;
import com.sinno.ems.exception.IdNotFound;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface MovementTypeService {

    public MovementType save(MovementType movementType);

    public Long size();

    public Boolean isExist(Long id);

    public MovementType findById(Long id) throws IdNotFound;

    public List<MovementType> find(String search) throws AttributesNotFound, ErrorType;

    public List<MovementType> find(String search, Pageable pageable) throws AttributesNotFound, ErrorType;

    public Long size(String search) throws AttributesNotFound, ErrorType;

    public void delete(Long id);

    public void delete(MovementType movementType);

    public List<MovementType> findAll();

    public List<MovementType> findAll(Pageable pageable);
}