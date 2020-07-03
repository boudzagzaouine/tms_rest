package com.bagile.gmo.services.impl;

import com.bagile.gmo.dto.OperationType;
import com.bagile.gmo.entities.GmoOperationType;
import com.bagile.gmo.exceptions.AttributesNotFound;
import com.bagile.gmo.exceptions.ErrorType;
import com.bagile.gmo.exceptions.IdNotFound;
import com.bagile.gmo.mapper.OperationTypeMapper;
import com.bagile.gmo.repositories.OperationTypeRepository;
import com.bagile.gmo.services.OperationTypeService;
import com.bagile.gmo.util.Search;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


@Service
@Transactional
public class OperationTypeServiceImpl implements OperationTypeService {
    private final OperationTypeRepository operationTypeRepository;

    public OperationTypeServiceImpl(OperationTypeRepository operationTypeRepository) {
        this.operationTypeRepository = operationTypeRepository;
    }

    @Override
    public OperationType save(OperationType operationType) {
        return OperationTypeMapper.toDto(operationTypeRepository.saveAndFlush(OperationTypeMapper.toEntity(operationType, false)), false);
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
    public OperationType findById(Long id) throws IdNotFound {
        return OperationTypeMapper.toDto(operationTypeRepository.findById(id).orElseThrow(() -> new IdNotFound(id)), false);
    }

    @Override
    public List<OperationType> find(String search) throws AttributesNotFound, ErrorType {
        if (search.equals("")){
            return findAll ();
        }
        return OperationTypeMapper.toDtos(operationTypeRepository.findAll(Search.expression(search, GmoOperationType.class)), false);
    }

    @Override
    public List<OperationType> find(String search, int page, int size) throws AttributesNotFound, ErrorType {
        if (search.equals("")){
            return findAll (page, size);
        }
        Sort sort = Sort.by(Sort.Direction.DESC, "updateDate");
        Pageable pageable = PageRequest.of(page, size, sort);
        return OperationTypeMapper.toDtos(operationTypeRepository.findAll(Search.expression(search, GmoOperationType.class), pageable), false);
    }

    @Override
    public Long size(String search) throws AttributesNotFound, ErrorType {
        if (search.equals("")){
            return size ();
        }
        return operationTypeRepository.count(Search.expression(search, GmoOperationType.class));
    }

    @Override
    public void delete(Long id) {
        operationTypeRepository.deleteById(id);
    }

    @Override
    public void delete(OperationType operationType) {
        operationTypeRepository.delete(OperationTypeMapper.toEntity(operationType, false));
    }


    @Override
    public void deleteAll(List<Long> ids) {

        for (Long id : ids) {
            operationTypeRepository.deleteById(id);        }
    }


    @Override
    public List<OperationType> findAll() {
        return OperationTypeMapper.toDtos(operationTypeRepository.findAll(), false);
    }

    @Override
    public List<OperationType> findAll(int page, int size) {
        Sort sort = Sort.by(Sort.Direction.DESC, "updateDate");
        Pageable pageable = PageRequest.of(page, size, sort);
        return OperationTypeMapper.toDtos(operationTypeRepository.findAll(pageable), false);
    }

}

