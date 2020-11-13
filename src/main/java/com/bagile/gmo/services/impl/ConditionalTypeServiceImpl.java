package com.bagile.gmo.services.impl;

import com.bagile.gmo.dto.ConditionalType;
import com.bagile.gmo.entities.GmoConditionalType;
import com.bagile.gmo.exceptions.AttributesNotFound;
import com.bagile.gmo.exceptions.ErrorType;
import com.bagile.gmo.exceptions.IdNotFound;
import com.bagile.gmo.mapper.ConditionalTypeMapper;
import com.bagile.gmo.repositories.ConditionalTypeRepository;
import com.bagile.gmo.services.ConditionalTypeService;
import com.bagile.gmo.util.Search;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


@Service
@Transactional
public class ConditionalTypeServiceImpl implements ConditionalTypeService {
    private final ConditionalTypeRepository conditionalTypeRepository;

    public ConditionalTypeServiceImpl(ConditionalTypeRepository conditionalTypeRepository) {
        this.conditionalTypeRepository = conditionalTypeRepository;
    }

    @Override
    public ConditionalType save(ConditionalType conditionalType) {
        return ConditionalTypeMapper.toDto(conditionalTypeRepository.saveAndFlush(ConditionalTypeMapper.toEntity(conditionalType, false)), false);
    }

    @Override
    public Long size() {
        return conditionalTypeRepository.count();
    }

    @Override
    public Boolean isExist(Long id) {
        return conditionalTypeRepository.existsById(id);
    }

    @Override
    public ConditionalType findById(Long id) throws IdNotFound {
        return ConditionalTypeMapper.toDto(conditionalTypeRepository.findById(id).orElseThrow(() -> new IdNotFound(id)), false);
    }

    @Override
    public List<ConditionalType> find(String search) throws AttributesNotFound, ErrorType {
        if (search.equals("")){
            return findAll ();
        }
        return ConditionalTypeMapper.toDtos(conditionalTypeRepository.findAll(Search.expression(search, GmoConditionalType.class)), false);
    }

    @Override
    public List<ConditionalType> find(String search, int page, int size) throws AttributesNotFound, ErrorType {
        if (search.equals("")){
            return findAll (page, size);
        }
        Sort sort = Sort.by(Sort.Direction.DESC, "updateDate");
        Pageable pageable = PageRequest.of(page, size, sort);
        return ConditionalTypeMapper.toDtos(conditionalTypeRepository.findAll(Search.expression(search, GmoConditionalType.class), pageable), false);
    }

    @Override
    public Long size(String search) throws AttributesNotFound, ErrorType {
        if (search.equals("")){
            return size ();
        }
        return conditionalTypeRepository.count(Search.expression(search, GmoConditionalType.class));
    }

    @Override
    public void delete(Long id) {
        conditionalTypeRepository.deleteById(id);
    }

    @Override
    public void delete(ConditionalType conditionalType) {
        conditionalTypeRepository.delete(ConditionalTypeMapper.toEntity(conditionalType, false));
    }


    @Override
    public void deleteAll(List<Long> ids) {

        for (Long id : ids) {
            conditionalTypeRepository.deleteById(id);        }
    }


    @Override
    public List<ConditionalType> findAll() {
        return ConditionalTypeMapper.toDtos(conditionalTypeRepository.findAll(), false);
    }

    @Override
    public List<ConditionalType> findAll(int page, int size) {
        Sort sort = Sort.by(Sort.Direction.DESC, "updateDate");
        Pageable pageable = PageRequest.of(page, size, sort);
        return ConditionalTypeMapper.toDtos(conditionalTypeRepository.findAll(pageable), false);
    }

}

