package com.sinno.ems.service;

import com.sinno.ems.exception.AttributesNotFound;
import com.sinno.ems.exception.ErrorType;
import com.sinno.ems.exception.IdNotFound;
import org.springframework.data.domain.Pageable;

import java.util.List;

/**
 * Created by Enissay on 20/12/2016.
 */
public interface AssetSupplierService {

    AssetSupplier save(AssetSupplier aisle);

    Long size();

    Boolean isExist(Long id);

    AssetSupplier findById(Long id) throws IdNotFound;

    List<AssetSupplier> find(String search) throws AttributesNotFound, ErrorType;

    List<AssetSupplier> find(String search, Pageable pageable) throws AttributesNotFound, ErrorType;

    Long size(String search) throws AttributesNotFound, ErrorType;

    void delete(Long id);

    void delete(AssetSupplier aisle);

    List<AssetSupplier> findAll();

    List<AssetSupplier> findAll(Pageable pageable);
}
