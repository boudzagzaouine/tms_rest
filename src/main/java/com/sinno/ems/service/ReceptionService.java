package com.sinno.ems.service;

import com.sinno.ems.exception.AttributesNotFound;
import com.sinno.ems.exception.ErrorType;
import com.sinno.ems.exception.IdNotFound;
import com.sinno.ems.exception.WarehouseException;
import org.springframework.data.domain.Pageable;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigInteger;
import java.util.List;

public interface ReceptionService {

    Reception save(Reception reception) throws WarehouseException;

    Long size();

    Boolean isExist(Long id);

    Reception findById(Long id) throws IdNotFound;

    List<Reception> find(String search) throws AttributesNotFound, ErrorType;

    List<Reception> find(String search, int page, int size) throws AttributesNotFound, ErrorType;

    Long size(String search) throws AttributesNotFound, ErrorType;

    void delete(Long id);

    void delete(Reception reception);

    List<Reception> findAll();

    List<Reception> findAll(Pageable pageable);

    BigInteger getNextVal();

    @Transactional
    Reception loadWmsReception(com.sinno.wms.crud.modelbasic.receptions.Reception reception);

    List<Reception> exportWmsReception(List<Reception> receptions);
}