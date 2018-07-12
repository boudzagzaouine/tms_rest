package com.sinno.ems.service;

import com.sinno.ems.exception.AttributesNotFound;
import com.sinno.ems.exception.ErrorType;
import com.sinno.ems.exception.IdNotFound;
import org.springframework.data.domain.Pageable;

import java.util.List;

/**
 * Created by Enissay on 21/06/2016.
 */
public interface ZoneWarehouseService {
    ZoneWarehouse save(ZoneWarehouse zoneWarehouse);

    Long size();

    Boolean isExist(Long id);

    ZoneWarehouse findById(Long id) throws IdNotFound;

    List<ZoneWarehouse> find(String search) throws AttributesNotFound, ErrorType;

    List<ZoneWarehouse> find(String search, Pageable pageable) throws AttributesNotFound, ErrorType;

    Long size(String search) throws AttributesNotFound, ErrorType;

    void delete(Long id);

    void delete(ZoneWarehouse zoneWarehouse);

    List<ZoneWarehouse> findAll();

    List<ZoneWarehouse> findAll(Pageable pageable);
}
