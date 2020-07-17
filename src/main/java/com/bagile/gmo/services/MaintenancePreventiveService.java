package com.bagile.gmo.services;

import com.bagile.gmo.dto.MaintenancePreventive;
import com.bagile.gmo.exceptions.AttributesNotFound;
import com.bagile.gmo.exceptions.ErrorType;
import com.bagile.gmo.exceptions.IdNotFound;

import java.util.List;

public interface MaintenancePreventiveService {

    MaintenancePreventive save(MaintenancePreventive maintenancePreventive);

    List<MaintenancePreventive> saveAll(List<MaintenancePreventive> maintenancePreventives);

    Long size();

    Boolean isExist(Long id);

    MaintenancePreventive findById(Long id) throws IdNotFound;

    List<MaintenancePreventive> find(String search) throws AttributesNotFound, ErrorType;

    List<MaintenancePreventive> find(String search, int page, int size) throws AttributesNotFound, ErrorType;

    Long size(String search) throws AttributesNotFound, ErrorType;

    void delete(Long id);

    void delete(MaintenancePreventive maintenancePreventive);

    void deleteAll(List<Long> ids);

    List<MaintenancePreventive> findAll();

    List<MaintenancePreventive> findAll(int page, int size);

	MaintenancePreventive findOne(String search) throws AttributesNotFound, ErrorType;

}
