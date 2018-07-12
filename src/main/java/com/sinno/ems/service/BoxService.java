package com.sinno.ems.service;

import com.sinno.ems.exception.AttributesNotFound;
import com.sinno.ems.exception.ErrorType;
import com.sinno.ems.exception.IdNotFound;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface BoxService {

    Box save(Box box);

    Long size();

    Boolean isExist(Long id);

    Box findById(Long id) throws IdNotFound;

    List<Box> find(String search) throws AttributesNotFound, ErrorType;

    List<Box> find(String search, Pageable pageable) throws AttributesNotFound, ErrorType;

    Long size(String search) throws AttributesNotFound, ErrorType;

    void delete(Long id);

    void delete(Box box);

    List<Box> findAll();

    List<Box> findAll(Pageable pageable);
}