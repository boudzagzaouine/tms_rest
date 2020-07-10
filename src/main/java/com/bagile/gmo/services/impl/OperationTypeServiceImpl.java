package com.bagile.gmo.services.impl;

import com.bagile.gmo.dto.Service;
import com.bagile.gmo.entities.GmoService;
import com.bagile.gmo.exceptions.AttributesNotFound;
import com.bagile.gmo.exceptions.ErrorType;
import com.bagile.gmo.exceptions.IdNotFound;
import com.bagile.gmo.mapper.ServiceMapper;
import com.bagile.gmo.repositories.OperationTypeRepository;
import com.bagile.gmo.services.OperationTypeService;
import com.bagile.gmo.util.Search;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


@org.springframework.stereotype.Service
@Transactional
public class OperationTypeServiceImpl implements OperationTypeService {
    private final OperationTypeRepository operationTypeRepository;

    public OperationTypeServiceImpl(OperationTypeRepository operationTypeRepository) {
        this.operationTypeRepository = operationTypeRepository;
    }

    @Override
    public Service save(Service operationType) {
        return ServiceMapper.toDto(operationTypeRepository.saveAndFlush(ServiceMapper.toEntity(operationType, false)), false);
    }

    @Override
    public Long size() {
        return operationTypeRepository.count();
    }

    @Override
    public Boolean isExist(Long id) {
        return operationTypeRepository.existsById(id);
    }

    @Override
    public Service findById(Long id) throws IdNotFound {
        return ServiceMapper.toDto(operationTypeRepository.findById(id).orElseThrow(() -> new IdNotFound(id)), false);
    }

    @Override
    public List<Service> find(String search) throws AttributesNotFound, ErrorType {
        if (search.equals("")){
            return findAll ();
        }
        return ServiceMapper.toDtos(operationTypeRepository.findAll(Search.expression(search, GmoService.class)), false);
    }

    @Override
    public List<Service> find(String search, int page, int size) throws AttributesNotFound, ErrorType {
        if (search.equals("")){
            return findAll (page, size);
        }
        Sort sort = Sort.by(Sort.Direction.DESC, "updateDate");
        Pageable pageable = PageRequest.of(page, size, sort);
        return ServiceMapper.toDtos(operationTypeRepository.findAll(Search.expression(search, GmoService.class), pageable), false);
    }

    @Override
    public Long size(String search) throws AttributesNotFound, ErrorType {
        if (search.equals("")){
            return size ();
        }
        return operationTypeRepository.count(Search.expression(search, GmoService.class));
    }

    @Override
    public void delete(Long id) {
        operationTypeRepository.deleteById(id);
    }

    @Override
    public void delete(Service operationType) {
        operationTypeRepository.delete(ServiceMapper.toEntity(operationType, false));
    }


    @Override
    public void deleteAll(List<Long> ids) {

        for (Long id : ids) {
            operationTypeRepository.deleteById(id);        }
    }


    @Override
    public List<Service> findAll() {
        return ServiceMapper.toDtos(operationTypeRepository.findAll(), false);
    }

    @Override
    public List<Service> findAll(int page, int size) {
        Sort sort = Sort.by(Sort.Direction.DESC, "updateDate");
        Pageable pageable = PageRequest.of(page, size, sort);
        return ServiceMapper.toDtos(operationTypeRepository.findAll(pageable), false);
    }

}

