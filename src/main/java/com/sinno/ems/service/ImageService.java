package com.sinno.ems.service;

import com.sinno.ems.dto.Image;
import com.sinno.ems.exception.AttributesNotFound;
import com.sinno.ems.exception.ErrorType;
import com.sinno.ems.exception.IdNotFound;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface ImageService {

    public Image save(Image image);

    public Long size();

    public Boolean isExist(Long id);

    public Image findById(Long id) throws IdNotFound;

    public List<Image> find(String search) throws AttributesNotFound, ErrorType;

    public List<Image> find(String search, Pageable pageable) throws AttributesNotFound, ErrorType;

    public Long size(String search) throws AttributesNotFound, ErrorType;

    public void delete(Long id);

    public void delete(Image image);

    public List<Image> findAll();

    public List<Image> findAll(Pageable pageable);
}