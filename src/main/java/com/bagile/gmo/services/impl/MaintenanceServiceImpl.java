package com.bagile.gmo.services.impl;

import java.util.ArrayList;
import java.util.List;

import com.bagile.gmo.entities.GmoMaintenance;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.bagile.gmo.dto.Maintenance;
import com.bagile.gmo.exceptions.AttributesNotFound;
import com.bagile.gmo.exceptions.ErrorType;
import com.bagile.gmo.exceptions.IdNotFound;
import com.bagile.gmo.mapper.MaintenanceMapper;
import com.bagile.gmo.repositories.MaintenanceRepository;
import com.bagile.gmo.services.MaintenanceService;
import com.bagile.gmo.util.Search;


@Service
@Transactional
public class MaintenanceServiceImpl implements MaintenanceService {

    private final MaintenanceRepository maintenanceRepository;
    public MaintenanceServiceImpl(MaintenanceRepository maintenanceRepository) {
        this.maintenanceRepository = maintenanceRepository;
    }

    @Override
    public Maintenance save(Maintenance maintenance) {
        return MaintenanceMapper.toDto(maintenanceRepository.save(MaintenanceMapper.toEntity(maintenance, false)), false);
    }

    @Override
    public List<Maintenance> saveAll(List<Maintenance> maintenances) {

        List<Maintenance> maintenanceList = new ArrayList<>( );
        for (Maintenance action : maintenances) {
            maintenanceList.add (save (action));
        }

        return maintenanceList;

    }

    @Override
    public Long size() {
        return maintenanceRepository.count();
    }

    @Override
    public Boolean isExist(Long id) {
        return maintenanceRepository.existsById(id);
    }

    @Override
    public Maintenance findById(Long id) throws IdNotFound {
        return MaintenanceMapper.toDto(maintenanceRepository.findById(id).orElseThrow(() -> new IdNotFound(id)), false);

    }


    @Override
    public List<Maintenance> find(String search) throws AttributesNotFound, ErrorType {
        if (search.equals("")){
            return findAll ();
        }
        return MaintenanceMapper.toDtos(maintenanceRepository.findAll(Search.expression(search, GmoMaintenance.class)), false);
    }

    @Override
    public List<Maintenance> find(String search, int page, int size) throws AttributesNotFound, ErrorType {
        if (search.equals("")){
            return findAll (page, size);
        }
        Sort sort = Sort.by(Sort.Direction.DESC, "updateDate");
        Pageable pageable = PageRequest.of(page, size, sort);
        return MaintenanceMapper.toDtos(maintenanceRepository.findAll(Search.expression(search, GmoMaintenance.class), pageable), false);
    }

    @Override
    public Maintenance findOne(String search) throws AttributesNotFound, ErrorType {
        return MaintenanceMapper.toDto (maintenanceRepository.findOne (Search.expression (search, GmoMaintenance.class)).orElseThrow (() -> new AttributesNotFound (search)), false);

    }

    @Override
    public Long size(String search) throws AttributesNotFound, ErrorType {
        if (search.equals("")){
            return size ();
        }
        return maintenanceRepository.count(Search.expression(search, GmoMaintenance.class));
    }

    @Override
    public void delete(Long id) {
        maintenanceRepository.deleteById(id);
    }

    @Override
    public void delete(Maintenance maintenancePlan) {
        maintenanceRepository.delete(MaintenanceMapper.toEntity(maintenancePlan, false));
    }

    @Override
    public void deleteAll(List<Long> ids) {

        for (Long id : ids) {
            maintenanceRepository.deleteById(id);        }
    }
    @Override
    public List<Maintenance> findAll() {
        return MaintenanceMapper.toDtos(maintenanceRepository.findAll(), false);
    }

    @Override
    public List<Maintenance> findAll(int page, int size) {
        Sort sort = Sort.by(Sort.Direction.DESC, "updateDate");
        Pageable pageable = PageRequest.of(page, size, sort);
        return MaintenanceMapper.toDtos(maintenanceRepository.findAll(pageable), false);
    }



}

