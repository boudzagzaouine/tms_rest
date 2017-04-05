package com.sinno.ems.service;

import com.sinno.ems.dto.Color;
import com.sinno.ems.exception.AttributesNotFound;
import com.sinno.ems.exception.ErrorType;
import com.sinno.ems.exception.IdNotFound;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface ColorService {


    Color save(Color color);

    Long size();

    Boolean isExist(Long id);

    Color findById(Long id) throws IdNotFound;

    List<Color> find(String search) throws AttributesNotFound, ErrorType;

    List<Color> find(String search, Pageable pageable) throws AttributesNotFound, ErrorType;

    Long size(String search) throws AttributesNotFound, ErrorType;

    void delete(Long id);

    void delete(Color color);

    List<Color> findAll();

    List<Color> findAll(Pageable pageable);
}