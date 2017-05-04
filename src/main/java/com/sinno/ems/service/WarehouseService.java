package com.sinno.ems.service;

import com.sinno.ems.dto.CountOwnerWareHouses;
import com.sinno.ems.dto.Warehouse;
import com.sinno.ems.exception.AttributesNotFound;
import com.sinno.ems.exception.ErrorType;
import com.sinno.ems.exception.IdNotFound;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface WarehouseService {

    public Warehouse save(Warehouse warehouse);

    public Long size();

    public Boolean isExist(Long id);

    public Warehouse findById(Long id) throws IdNotFound;

    public List<Warehouse> find(String search) throws AttributesNotFound, ErrorType;

    public List<Warehouse> find(String search, int page, int size) throws AttributesNotFound, ErrorType;

    public Long size(String search) throws AttributesNotFound, ErrorType;

    public void delete(Long id) throws Exception;

    public void delete(Warehouse warehouse);

    public List<Warehouse> findAll() throws AttributesNotFound, ErrorType;

    public List<Warehouse> findAll(Pageable pageable);
    public List<CountOwnerWareHouses> sizeContainerByOwner();
    public List<CountOwnerWareHouses> sizeContainerByOwner(String code);

    List<Warehouse> findAllForHabilitation()throws AttributesNotFound, ErrorType;
}