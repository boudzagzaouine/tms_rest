package com.bagile.gmo.services.impl;

import com.bagile.gmo.dto.TurnType;
import com.bagile.gmo.entities.TmsTurnType;
import com.bagile.gmo.exceptions.AttributesNotFound;
import com.bagile.gmo.exceptions.ErrorType;
import com.bagile.gmo.exceptions.IdNotFound;
import com.bagile.gmo.mapper.TurnTypeMapper;
import com.bagile.gmo.repositories.TurnTypeRepository;
import com.bagile.gmo.services.TurnTypeService;
import com.bagile.gmo.util.Search;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class TurnTypeServiceImpl implements TurnTypeService {

    private final TurnTypeRepository turnTypeRepository;

    public TurnTypeServiceImpl(TurnTypeRepository turnTypeRepository) {
        this.turnTypeRepository = turnTypeRepository;
    }

    @Override
    public TurnType save(TurnType turnType) {
        return TurnTypeMapper.toDto(turnTypeRepository.saveAndFlush(TurnTypeMapper.toEntity(turnType, false)), false);
    }

    @Override
    public Long size() {
        return turnTypeRepository.count();
    }

    @Override
    public Boolean isExist(Long id) {
        return turnTypeRepository.existsById(id);
    }

    @Override
    public TurnType findById(Long id) throws IdNotFound {
        return TurnTypeMapper.toDto(turnTypeRepository.findById(id).orElseThrow(() -> new IdNotFound(id)), false);
    }

    @Override
    public List<TurnType> find(String search) throws AttributesNotFound, ErrorType {
        if (search.equals("")){
            return findAll ();
        }
        return TurnTypeMapper.toDtos(turnTypeRepository.findAll(Search.expression(search, TmsTurnType.class)), false);
    }

    @Override
    public List<TurnType> find(String search, int page, int size) throws AttributesNotFound, ErrorType {
        if (search.equals("")){
            return findAll (page, size);
        }
        Sort sort = Sort.by(Sort.Direction.DESC, "updateDate");
        Pageable pageable = PageRequest.of(page, size, sort);
        return TurnTypeMapper.toDtos(turnTypeRepository.findAll(Search.expression(search, TmsTurnType.class), pageable), false);
    }

    @Override
    public Long size(String search) throws AttributesNotFound, ErrorType {
        if (search.equals("")){
            return size ();
        }
        return turnTypeRepository.count(Search.expression(search, TmsTurnType.class));
    }

    @Override
    public void delete(Long id) {
        turnTypeRepository.deleteById(id);
    }

    @Override
    public void delete(TurnType turnType) {
        turnTypeRepository.delete(TurnTypeMapper.toEntity(turnType, false));
    }


    @Override
    public void deleteAll(List<Long> ids) {

        for (Long id : ids) {
            turnTypeRepository.deleteById(id);        }
    }


    @Override
    public List<TurnType> findAll()
    {
        return TurnTypeMapper.toDtos(turnTypeRepository.findAll(), false);
    }

    @Override
    public List<TurnType> findAll(int page, int size) {
        Sort sort = Sort.by(Sort.Direction.DESC, "updateDate");
        Pageable pageable = PageRequest.of(page, size, sort);
        return TurnTypeMapper.toDtos(turnTypeRepository.findAll(pageable), false);
    }

}

