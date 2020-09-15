package com.bagile.gmo.services;

import com.bagile.gmo.dto.MaintenanceStock;
import com.bagile.gmo.exceptions.*;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface MaintenanceStockService {

    MaintenanceStock save(MaintenanceStock MaintenanceStock) throws ProductControls, IdNotFound, CustomException, AttributesNotFound, ErrorType;

    Long size();

    Boolean isExist(Long id);

    MaintenanceStock findById(Long id) throws IdNotFound;

    MaintenanceStock findOne(String search) throws AttributesNotFound, ErrorType;

    List<MaintenanceStock> find(String search) throws AttributesNotFound, ErrorType;

    List<MaintenanceStock> find(String search, Pageable pageable) throws AttributesNotFound, ErrorType;

    Long size(String search) throws AttributesNotFound, ErrorType;

    void delete(Long id);

    void delete(MaintenanceStock MaintenanceStock);

    List<MaintenanceStock> findAll();

    List<MaintenanceStock> findAll(Pageable pageable);

    List<MaintenanceStock> saveAll(List<MaintenanceStock> MaintenanceStockList);
}