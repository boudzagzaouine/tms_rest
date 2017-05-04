package com.sinno.ems.service;

import com.sinno.ems.dto.Promotion;
import com.sinno.ems.exception.AttributesNotFound;
import com.sinno.ems.exception.ErrorType;
import com.sinno.ems.exception.IdNotFound;
import org.springframework.data.domain.Pageable;

import java.util.List;

/**
 * Created by Enissay on 24/01/2017.
 */
public interface PromotionService {
    public Promotion save(Promotion orderType);

    public Long size();

    public Boolean isExist(Long id);

    public Promotion findById(Long id) throws IdNotFound;

    public List<Promotion> find(String search) throws AttributesNotFound, ErrorType;

    public List<Promotion> find(String search, int page, int size) throws AttributesNotFound, ErrorType;

    public Long size(String search) throws AttributesNotFound, ErrorType;

    public void delete(Long id);

    public void delete(Promotion orderType);

    public List<Promotion> findAll();

    public List<Promotion> findAll(Pageable pageable);
}
