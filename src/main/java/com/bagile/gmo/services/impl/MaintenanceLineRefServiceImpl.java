package com.bagile.gmo.services.impl;

import com.bagile.gmo.dto.MaintenanceLineRef;
import com.bagile.gmo.entities.GmoMaintenanceLineRef;
import com.bagile.gmo.exceptions.AttributesNotFound;
import com.bagile.gmo.exceptions.ErrorType;
import com.bagile.gmo.exceptions.IdNotFound;
import com.bagile.gmo.mapper.MaintenanceLineRefMapper;
import com.bagile.gmo.repositories.MaintenanceLineRefRepository;
import com.bagile.gmo.services.MaintenanceLineRefService;
import com.bagile.gmo.util.Search;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


@Service
@Transactional
public class MaintenanceLineRefServiceImpl implements MaintenanceLineRefService {

    private final MaintenanceLineRefRepository maintenanceLineRefRepository;

    public MaintenanceLineRefServiceImpl(MaintenanceLineRefRepository maintenanceLineRefRepository) {
        this.maintenanceLineRefRepository = maintenanceLineRefRepository;
    }

    @Override
    public MaintenanceLineRef save(MaintenanceLineRef maintenanceLineRef) {
        return MaintenanceLineRefMapper.toDto(maintenanceLineRefRepository.save(MaintenanceLineRefMapper.toEntity(maintenanceLineRef, false)), false);
    }

    @Override
    public Long size() {
        return maintenanceLineRefRepository.count();
    }

    @Override
    public Boolean isExist(Long id) {
        return maintenanceLineRefRepository.existsById(id);
    }

    @Override
    public MaintenanceLineRef findById(Long id) throws IdNotFound {
        return MaintenanceLineRefMapper.toDto(maintenanceLineRefRepository.findById(id).orElseThrow(() -> new IdNotFound(id)), false);

    }


    @Override
    public List<MaintenanceLineRef> find(String search) throws AttributesNotFound, ErrorType {
        if (search.equals("")){
            return findAll ();
        }
        return MaintenanceLineRefMapper.toDtos(maintenanceLineRefRepository.findAll(Search.expression(search, GmoMaintenanceLineRef.class)), false);
    }

    @Override
    public List<MaintenanceLineRef> find(String search, int page, int size) throws AttributesNotFound, ErrorType {
        if (search.equals("")){
            return findAll (page, size);
        }
        Sort sort = Sort.by(Sort.Direction.DESC, "updateDate");
        Pageable pageable = PageRequest.of(page, size, sort);
        return MaintenanceLineRefMapper.toDtos(maintenanceLineRefRepository.findAll(Search.expression(search, GmoMaintenanceLineRef.class), pageable), false);
    }

    @Override
    public MaintenanceLineRef findOne(String search) throws AttributesNotFound, ErrorType {
        return MaintenanceLineRefMapper.toDto (maintenanceLineRefRepository.findOne (Search.expression (search, GmoMaintenanceLineRef.class)).orElseThrow (() -> new AttributesNotFound (search)), false);

    }

    @Override
    public Long size(String search) throws AttributesNotFound, ErrorType {
        if (search.equals("")){
            return size ();
        }
        return maintenanceLineRefRepository.count(Search.expression(search, GmoMaintenanceLineRef.class));
    }

    @Override
    public void delete(Long id) {
        maintenanceLineRefRepository.deleteById(id);
    }

    @Override
    public void delete(MaintenanceLineRef maintenanceLineRef) {
        maintenanceLineRefRepository.delete(MaintenanceLineRefMapper.toEntity(maintenanceLineRef, false));
    }

    @Override
    public List<MaintenanceLineRef> findAll() {
        return MaintenanceLineRefMapper.toDtos(maintenanceLineRefRepository.findAll(), false);
    }

    @Override
    public List<MaintenanceLineRef> findAll(int page, int size) {
        Sort sort = Sort.by(Sort.Direction.DESC, "updateDate");
        Pageable pageable = PageRequest.of(page, size, sort);
        return MaintenanceLineRefMapper.toDtos(maintenanceLineRefRepository.findAll(pageable), false);
    }



}

