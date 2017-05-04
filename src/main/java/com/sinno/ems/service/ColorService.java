package com.sinno.ems.service;

import com.sinno.ems.dto.Color;
import com.sinno.ems.exception.AttributesNotFound;
import com.sinno.ems.exception.ErrorType;
import com.sinno.ems.exception.IdNotFound;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface ColorService {

    public Color save(Color color);

    public Long size();

    public Boolean isExist(Long id);

    public Color findById(Long id) throws IdNotFound;

    public List<Color> find(String search) throws AttributesNotFound, ErrorType;

    public List<Color> find(String search, Pageable pageable) throws AttributesNotFound, ErrorType;

    public Long size(String search) throws AttributesNotFound, ErrorType;

    public void delete(Long id);

    public void delete(Color color);

    public List<Color> findAll();

    public List<Color> findAll(Pageable pageable);
}