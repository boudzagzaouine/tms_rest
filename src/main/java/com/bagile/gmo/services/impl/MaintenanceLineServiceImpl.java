package com.bagile.gmo.services.impl;

import java.util.List;

import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.bagile.gmo.dto.MaintenanceLine;
import com.bagile.gmo.entities.GmoMaintenanceLine;
import com.bagile.gmo.exceptions.AttributesNotFound;
import com.bagile.gmo.exceptions.ErrorType;
import com.bagile.gmo.exceptions.IdNotFound;
import com.bagile.gmo.mapper.MaintenanceLineMapper;
import com.bagile.gmo.repositories.MaintenanceLineRepository;
import com.bagile.gmo.services.MaintenanceLineService;
import com.bagile.gmo.util.Search;


@Service
@Transactional
public class MaintenanceLineServiceImpl implements MaintenanceLineService {

    private final MaintenanceLineRepository maintenanceLineRepository;

    public MaintenanceLineServiceImpl(MaintenanceLineRepository maintenanceLineRepository) {
        this.maintenanceLineRepository = maintenanceLineRepository;
    }

    @Override
    public MaintenanceLine save(MaintenanceLine maintenanceLine) {
    	GmoMaintenanceLine gmoMaintenanceLine = maintenanceLineRepository.save(MaintenanceLineMapper.toEntity(maintenanceLine, false));
        return MaintenanceLineMapper.toDto(gmoMaintenanceLine, false);
    }

    @Override
    public Long size() {
        return maintenanceLineRepository.count();
    }

    @Override
    public Boolean isExist(Long id) {
        return maintenanceLineRepository.existsById(id);
    }

    @Override
    public MaintenanceLine findById(Long id) throws IdNotFound {
        return MaintenanceLineMapper.toDto(maintenanceLineRepository.findById(id).orElseThrow(() -> new IdNotFound(id)), false);

    }


    @Override
    public List<MaintenanceLine> find(String search) throws AttributesNotFound, ErrorType {
        if (search.equals("")){
            return findAll ();
        }
        return MaintenanceLineMapper.toDtos(maintenanceLineRepository.findAll(Search.expression(search, GmoMaintenanceLine.class)), false);
    }

    @Override
    public List<MaintenanceLine> find(String search, int page, int size) throws AttributesNotFound, ErrorType {
        if (search.equals("")){
            return findAll (page, size);
        }
        Sort sort = Sort.by(Sort.Direction.DESC, "updateDate");
        Pageable pageable = PageRequest.of(page, size, sort);
        return MaintenanceLineMapper.toDtos(maintenanceLineRepository.findAll(Search.expression(search, GmoMaintenanceLine.class), pageable), false);
    }

    @Override
    public MaintenanceLine findOne(String search) throws AttributesNotFound, ErrorType {
        return MaintenanceLineMapper.toDto (maintenanceLineRepository.findOne (Search.expression (search, GmoMaintenanceLine.class)).orElseThrow (() -> new AttributesNotFound (search)), false);

    }

    @Override
    public Long size(String search) throws AttributesNotFound, ErrorType {
        if (search.equals("")){
            return size ();
        }
        return maintenanceLineRepository.count(Search.expression(search, GmoMaintenanceLine.class));
    }

    @Override
    public void delete(Long id) {
        maintenanceLineRepository.deleteById(id);
    }

    @Override
    public void delete(MaintenanceLine maintenanceLine) {
        maintenanceLineRepository.delete(MaintenanceLineMapper.toEntity(maintenanceLine, false));
    }

    @Override
    public List<MaintenanceLine> findAll() {
        return MaintenanceLineMapper.toDtos(maintenanceLineRepository.findAll(), false);
    }

    @Override
    public List<MaintenanceLine> findAll(int page, int size) {
        Sort sort = Sort.by(Sort.Direction.DESC, "updateDate");
        Pageable pageable = PageRequest.of(page, size, sort);
        return MaintenanceLineMapper.toDtos(maintenanceLineRepository.findAll(pageable), false);
    }



}

