package com.bagile.gmo.services.impl;

import com.bagile.gmo.dto.PeriodicityType;
import com.bagile.gmo.entities.GmoPeriodicityType;
import com.bagile.gmo.exceptions.AttributesNotFound;
import com.bagile.gmo.exceptions.ErrorType;
import com.bagile.gmo.exceptions.IdNotFound;
import com.bagile.gmo.mapper.PeriodicityTypeMapper;
import com.bagile.gmo.repositories.PeriodicityTypeRepository;
import com.bagile.gmo.services.PeriodicityTypeService;
import com.bagile.gmo.util.Search;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


@Service
public class PeriodicityTypeServiceImpl implements PeriodicityTypeService {
    private final PeriodicityTypeRepository periodicityTypeRepository;

    public PeriodicityTypeServiceImpl(PeriodicityTypeRepository periodicityTypeRepository) {
        this.periodicityTypeRepository = periodicityTypeRepository;
    }

    @Override
    public PeriodicityType save(PeriodicityType periodicityType) {
        return PeriodicityTypeMapper.toDto(periodicityTypeRepository.saveAndFlush(PeriodicityTypeMapper.toEntity(periodicityType, false)), false);
    }

    @Override
    public Long size() {
        return periodicityTypeRepository.count();
    }

    @Override
    public Boolean isExist(Long id) {
        return periodicityTypeRepository.existsById(id);
    }

    @Override
    public PeriodicityType findById(Long id) throws IdNotFound {
        return PeriodicityTypeMapper.toDto(periodicityTypeRepository.findById(id).orElseThrow(() -> new IdNotFound(id)), false);
    }

    @Override
    public List<PeriodicityType> find(String search) throws AttributesNotFound, ErrorType {
        if (search.equals("")){
            return findAll ();
        }
        return PeriodicityTypeMapper.toDtos(periodicityTypeRepository.findAll(Search.expression(search, GmoPeriodicityType.class)), false);
    }

    @Override
    public List<PeriodicityType> find(String search, int page, int size) throws AttributesNotFound, ErrorType {
        if (search.equals("")){
            return findAll (page, size);
        }
        Sort sort = Sort.by(Sort.Direction.DESC, "updateDate");
        Pageable pageable = PageRequest.of(page, size, sort);
        return PeriodicityTypeMapper.toDtos(periodicityTypeRepository.findAll(Search.expression(search, GmoPeriodicityType.class), pageable), false);
    }

    @Override
    public Long size(String search) throws AttributesNotFound, ErrorType {
        if (search.equals("")){
            return size ();
        }
        return periodicityTypeRepository.count(Search.expression(search, GmoPeriodicityType.class));
    }

    @Override
    public void delete(Long id) {
        periodicityTypeRepository.deleteById(id);
    }

    @Override
    public void delete(PeriodicityType periodicityType) {
        periodicityTypeRepository.delete(PeriodicityTypeMapper.toEntity(periodicityType, false));
    }


    @Override
    public void deleteAll(List<Long> ids) {

        for (Long id : ids) {
            periodicityTypeRepository.deleteById(id);        }
    }


    @Override
    public List<PeriodicityType> findAll() {
        return PeriodicityTypeMapper.toDtos(periodicityTypeRepository.findAll(), false);
    }

    @Override
    public List<PeriodicityType> findAll(int page, int size) {
        Sort sort = Sort.by(Sort.Direction.DESC, "updateDate");
        Pageable pageable = PageRequest.of(page, size, sort);
        return PeriodicityTypeMapper.toDtos(periodicityTypeRepository.findAll(pageable), false);
    }

}

