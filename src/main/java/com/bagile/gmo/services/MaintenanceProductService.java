package com.bagile.gmo.services;


import java.util.List;

import com.bagile.gmo.dto.MaintenanceProduct;
import com.bagile.gmo.exceptions.AttributesNotFound;
import com.bagile.gmo.exceptions.ErrorType;
import com.bagile.gmo.exceptions.IdNotFound;

public interface MaintenanceProductService {

    MaintenanceProduct save(MaintenanceProduct product) throws IdNotFound;

    Long size();

    Boolean isExist(Long id);

    MaintenanceProduct findById(Long id) throws IdNotFound;

    MaintenanceProduct findOne(String search) throws AttributesNotFound, ErrorType;

    List<MaintenanceProduct> find(String search) throws AttributesNotFound, ErrorType;

    List<MaintenanceProduct> find(String search, int page, int size) throws AttributesNotFound, ErrorType;

    Long size(String search) throws AttributesNotFound, ErrorType;

    List<MaintenanceProduct> findAll() throws AttributesNotFound, ErrorType;

    List<MaintenanceProduct> findAll(int page, int size) throws AttributesNotFound, ErrorType;

	void delete(Long id);

	void delete(MaintenanceProduct maintenanceProduct);
}