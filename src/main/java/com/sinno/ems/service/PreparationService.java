package com.sinno.ems.service;

import com.sinno.ems.dto.Preparation;
import com.sinno.ems.dto.PreparationLine;
import com.sinno.ems.dto.SaleOrder;
import com.sinno.ems.dto.StockReserved;
import com.sinno.ems.exception.AttributesNotFound;
import com.sinno.ems.exception.ErrorType;
import com.sinno.ems.exception.IdNotFound;
import org.springframework.data.domain.Pageable;

import java.math.BigInteger;
import java.util.List;

/**
 * Created by Enissay on 02/12/2016.
 */
public interface PreparationService {

    Preparation generatePreparation(SaleOrder saleOrder);

    Preparation save(Preparation preparation);

    Long size();

    Boolean isExist(Long id);

    Preparation findById(Long id) throws IdNotFound;

    List<Preparation> find(String search) throws AttributesNotFound, ErrorType;

    List<Preparation> find(String search, Pageable pageable) throws AttributesNotFound, ErrorType;

    Long size(String search) throws AttributesNotFound, ErrorType;

    void delete(Long id);

    void delete(Preparation preparation);

    List<Preparation> findAll();

    List<Preparation> findAll(Pageable pageable);

    BigInteger getNextVal();
}
