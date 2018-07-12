package com.sinno.ems.service;

import com.sinno.ems.exception.AttributesNotFound;
import com.sinno.ems.exception.ErrorType;
import com.sinno.ems.exception.IdNotFound;
import org.springframework.data.domain.Pageable;

import java.util.List;

/**
 * Created by ASMAE on 28/04/2016.
 */
public interface BarCodeService {
    public BarCode save(BarCode barCode);

    public Long size();

    public Boolean isExist(Long id);

    public BarCode findById(Long id) throws IdNotFound;

    public List<BarCode> find(String search) throws AttributesNotFound, ErrorType;

    public List<BarCode> find(String search, Pageable pageable) throws AttributesNotFound, ErrorType;

    public Long size(String search) throws AttributesNotFound, ErrorType;

    public void delete(Long id);

    public void delete(BarCode stock);

    public List<BarCode> findAll() throws AttributesNotFound, ErrorType;

    public List<BarCode> findAll(Pageable pageable) throws AttributesNotFound, ErrorType;

}
