package com.sinno.ems.service;

import com.sinno.ems.dto.Variable;
import com.sinno.ems.exception.AttributesNotFound;
import com.sinno.ems.exception.ErrorType;
import com.sinno.ems.exception.IdNotFound;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface VariableService {

    Variable save(Variable variable);

    Long size();

    Boolean isExist(Long id);

    Variable findById(Long id) throws IdNotFound;

    List<Variable> find(String search) throws AttributesNotFound, ErrorType;

    List<Variable> find(String search, Pageable pageable) throws AttributesNotFound, ErrorType;

    Long size(String search) throws AttributesNotFound, ErrorType;

    void delete(Long id);

    void delete(Variable variable);

    List<Variable> findAll();

    List<Variable> findAll(Pageable pageable);
}