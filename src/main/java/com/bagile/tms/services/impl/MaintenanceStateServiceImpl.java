package com.bagile.tms.services.impl;

import com.bagile.tms.dto.MaintenanceState;
import com.bagile.tms.entities.TmsMaintenanceState;
import com.bagile.tms.entities.TmsVehicle;
import com.bagile.tms.exceptions.AttributesNotFound;
import com.bagile.tms.exceptions.ErrorType;
import com.bagile.tms.exceptions.IdNotFound;
import com.bagile.tms.mapper.MaintenanceStateMapper;
import com.bagile.tms.repositories.MaintenanceStateRepository;
import com.bagile.tms.services.MaintenanceStateService;
import com.bagile.tms.util.Search;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class MaintenanceStateServiceImpl implements MaintenanceStateService {

    private final MaintenanceStateRepository maintenanceStateRepository;

    public MaintenanceStateServiceImpl(MaintenanceStateRepository maintenanceStateRepository) {
        this.maintenanceStateRepository = maintenanceStateRepository;
    }

    @Override
    public MaintenanceState save(MaintenanceState maintenanceState) {
        return MaintenanceStateMapper.toDto(maintenanceStateRepository.saveAndFlush(MaintenanceStateMapper.toEntity(maintenanceState, false)), false);
    }

    @Override
    public Long size() {
        return maintenanceStateRepository.count();
    }

    @Override
    public Boolean isExist(Long id) {
        return maintenanceStateRepository.existsById(id);
    }

    @Override
    public MaintenanceState findById(Long id) throws IdNotFound {
        return MaintenanceStateMapper.toDto(maintenanceStateRepository.findById(id).orElseThrow(() -> new IdNotFound(id)), false);
    }

    @Override
    public List<MaintenanceState> find(String search) throws AttributesNotFound, ErrorType {
        if (search.equals("")){
            return findAll ();
        }
        return MaintenanceStateMapper.toDtos(maintenanceStateRepository.findAll(Search.expression(search, TmsMaintenanceState.class)), false);
    }

    @Override
    public List<MaintenanceState> find(String search, int page, int size) throws AttributesNotFound, ErrorType {
        if (search.equals("")){
            return findAll (page, size);
        }
        Pageable pageable = PageRequest.of(page, size);
        return MaintenanceStateMapper.toDtos(maintenanceStateRepository.findAll(Search.expression(search, TmsMaintenanceState.class), pageable), false);
    }

    @Override
    public Long size(String search) throws AttributesNotFound, ErrorType {
        if (search.equals("")){
            return size ();
        }
        return maintenanceStateRepository.count(Search.expression(search, TmsMaintenanceState.class));
    }

    @Override
    public void delete(long id) {
        maintenanceStateRepository.deleteById(id);
    }

    @Override
    public void delete(MaintenanceState maintenanceState) {
        maintenanceStateRepository.delete(MaintenanceStateMapper.toEntity(maintenanceState, false));
    }

    @Override
    public List<MaintenanceState> findAll() {
        return MaintenanceStateMapper.toDtos(maintenanceStateRepository.findAll(), false);
    }

    @Override
    public List<MaintenanceState> findAll(int page, int size) {
        Pageable pageable = PageRequest.of(page, size);
        return MaintenanceStateMapper.toDtos(maintenanceStateRepository.findAll(pageable), false);
    }
}
