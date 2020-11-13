package com.bagile.gmo.services.impl;

import com.bagile.gmo.dto.Maintenance;
import com.bagile.gmo.dto.Vehicle;
import com.bagile.gmo.entities.GmoVehicle;
import com.bagile.gmo.exceptions.AttributesNotFound;
import com.bagile.gmo.exceptions.ErrorType;
import com.bagile.gmo.exceptions.IdNotFound;
import com.bagile.gmo.mapper.VehicleMapper;
import com.bagile.gmo.repositories.VehicleRepository;
import com.bagile.gmo.services.MaintenancePlanService;
import com.bagile.gmo.services.MaintenanceService;
import com.bagile.gmo.services.SettingService;
import com.bagile.gmo.services.VehicleService;
import com.bagile.gmo.util.Search;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.io.IOException;
import java.util.List;

@Service
@Transactional
public class VehicleServiceImpl implements VehicleService {

    private final VehicleRepository vehicleRepository;
    @Autowired
    private SettingService settingService;
    @Autowired
    private MaintenanceService maintenanceService;

    @Autowired
    private MaintenancePlanService maintenancePlanService;

    public VehicleServiceImpl(VehicleRepository vehicleRepository) {
        this.vehicleRepository = vehicleRepository;
    }

    @Override
    public Vehicle save(Vehicle vehicle) throws AttributesNotFound, ErrorType, IdNotFound, IOException {
       Vehicle vehicle1=  VehicleMapper.toDto
                (vehicleRepository.saveAndFlush(VehicleMapper.toEntity(vehicle, false)), false);


    if (vehicle1.getMaintenancePlan() != null) {
        List<Maintenance> maintenance =maintenanceService.find("patrimony.id:"+vehicle1.getId()+",maintenancePlan.id:"+vehicle1.getMaintenancePlan().getId());
       if(maintenance.size()==0) {
        this.maintenanceService.generateMaintenance(vehicle1);
               }
}
        return vehicle1;
    }

    @Override
    public Long size() {
        return vehicleRepository.count();
    }

    @Override
    public Boolean isExist(Long id) {
        return vehicleRepository.existsById(id);
    }

    @Override
    public Vehicle findById(Long id) throws IdNotFound {
        return VehicleMapper.toDto(vehicleRepository.findById(id).orElseThrow(() -> new IdNotFound(id)), false);
    }

    @Override
    public List<Vehicle> find(String search) throws AttributesNotFound, ErrorType {
        if (search.equals("")){
            return findAll ();
        }
        return VehicleMapper.toDtos(vehicleRepository.findAll(Search.expression(search, GmoVehicle.class)), false);
    }

    @Override
    public List<Vehicle> find(String search, int page, int size) throws AttributesNotFound, ErrorType {
        if (search.equals("")){
            return findAll (page, size);
        }
        Pageable pageable = PageRequest.of(page, size);
        return VehicleMapper.toDtos(vehicleRepository.findAll(Search.expression(search, GmoVehicle.class), pageable), false);
    }

    @Override
    public Long size(String search) throws AttributesNotFound, ErrorType {
        if (search.equals("")){
            return size ();
        }
        return vehicleRepository.count(Search.expression(search, GmoVehicle.class));
    }

    @Override
    public void delete(Long id) {
        vehicleRepository.deleteById(id);
    }

    @Override
    public void delete(Vehicle vehicle) {
        vehicleRepository.delete(VehicleMapper.toEntity(vehicle, false));
    }
    @Override
    public void deleteAll(List<Long> ids) {

        for (Long id : ids) {
            vehicleRepository.deleteById(id);        }
    }
    @Override
    public List<Vehicle> findAll() {

        return VehicleMapper.toDtos(vehicleRepository.findAll(), false);
    }

    @Override
    public List<Vehicle> findAll(int page, int size) {
        Sort sort = Sort.by (Sort.Direction.DESC, "updateDate");
        Pageable pageable = PageRequest.of(page, size, sort);

        return VehicleMapper.toDtos(vehicleRepository.findAll(pageable), false);
    }
    @Override
    public String getNextVal() {
        String value=settingService.generateCodeVehicle() + vehicleRepository.getNextVal().get(0);
        return value;


    }
}
