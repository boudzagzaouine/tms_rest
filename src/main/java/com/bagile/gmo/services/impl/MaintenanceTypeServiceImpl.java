package com.bagile.gmo.services.impl;

import com.bagile.gmo.dto.MaintenanceType;
import com.bagile.gmo.entities.GmoMaintenanceType;
import com.bagile.gmo.exceptions.AttributesNotFound;
import com.bagile.gmo.exceptions.ErrorType;
import com.bagile.gmo.exceptions.IdNotFound;
import com.bagile.gmo.mapper.MaintenanceTypeMapper;
import com.bagile.gmo.repositories.MaintenanceTypeRepository;
import com.bagile.gmo.services.MaintenanceTypeService;
import com.bagile.gmo.util.Search;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class MaintenanceTypeServiceImpl implements MaintenanceTypeService {

    private final MaintenanceTypeRepository MaintenancetypeRepository;

    public MaintenanceTypeServiceImpl(MaintenanceTypeRepository MaintenancetypeRepository) {
        this.MaintenancetypeRepository = MaintenancetypeRepository;
    }

    @Override
    public MaintenanceType save(MaintenanceType maintenancetype) {
        return MaintenanceTypeMapper.toDto(MaintenancetypeRepository.saveAndFlush(MaintenanceTypeMapper.toEntity(maintenancetype, false)), false);
    }

    @Override
    public Long size() {
        return MaintenancetypeRepository.count();
    }

    @Override
    public Boolean isExist(Long id) {
        return MaintenancetypeRepository.existsById(id);
    }

    @Override
    public MaintenanceType findById(Long id) throws IdNotFound {
        return MaintenanceTypeMapper.toDto(MaintenancetypeRepository.findById(id).orElseThrow(() -> new IdNotFound(id)), false);
    }

    @Override
    public List<MaintenanceType> find(String search) throws AttributesNotFound, ErrorType {
        if (search.equals("")){
            return findAll ();
        }
        return MaintenanceTypeMapper.toDtos(MaintenancetypeRepository.findAll(Search.expression(search, GmoMaintenanceType.class)));
    }

    @Override
    public List<MaintenanceType> find(String search, int page, int size) throws AttributesNotFound, ErrorType {
        if (search.equals("")){
            return findAll (page, size);
        }
        Sort sort = Sort.by(Sort.Direction.DESC, "updateDate");
        Pageable pageable = PageRequest.of(page, size, sort);
        return MaintenanceTypeMapper.toDtos(MaintenancetypeRepository.findAll(Search.expression(search, GmoMaintenanceType.class), pageable));
    }

    @Override
    public Long size(String search) throws AttributesNotFound, ErrorType {
        if (search.equals("")){
            return size ();
        }
        return MaintenancetypeRepository.count(Search.expression(search, GmoMaintenanceType.class));
    }

    @Override
    public void delete(long id) {
        MaintenancetypeRepository.deleteById(id);
    }

    @Override
    public void delete(MaintenanceType maintenancetype) {
        MaintenancetypeRepository.delete(MaintenanceTypeMapper.toEntity(maintenancetype, true));
    }
    @Override
    public void deleteAll(List<Long> ids) {

        for (Long id : ids) {
            MaintenancetypeRepository.deleteById(id);        }
    }

    @Override
    public List<MaintenanceType> findAll() {
        return MaintenanceTypeMapper.toDtos(MaintenancetypeRepository.findAll());
    }

    @Override
    public List<MaintenanceType> findAll(int page, int size) {
        Sort sort = Sort.by(Sort.Direction.DESC, "updateDate");
        Pageable pageable = PageRequest.of(page, size, sort);
        return MaintenanceTypeMapper.toDtos(MaintenancetypeRepository.findAll(pageable));
    }
}
