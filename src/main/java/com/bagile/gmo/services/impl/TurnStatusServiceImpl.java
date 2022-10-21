package com.bagile.gmo.services.impl;

import com.bagile.gmo.dto.TurnStatus;
import com.bagile.gmo.entities.TmsTurnStatus;
import com.bagile.gmo.exceptions.AttributesNotFound;
import com.bagile.gmo.exceptions.ErrorType;
import com.bagile.gmo.exceptions.IdNotFound;
import com.bagile.gmo.mapper.TurnStatusMapper;
import com.bagile.gmo.repositories.TurnStatusRepository;
import com.bagile.gmo.services.TurnStatusService;
import com.bagile.gmo.util.Search;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class TurnStatusServiceImpl implements TurnStatusService {
    
    private final TurnStatusRepository turnStatusRepository;

    public TurnStatusServiceImpl(TurnStatusRepository turnStatusRepository) {
        this.turnStatusRepository = turnStatusRepository;
    }

    @Override
    public TurnStatus save(TurnStatus turnStatus) {
        return TurnStatusMapper.toDto(turnStatusRepository.saveAndFlush(TurnStatusMapper.toEntity(turnStatus, false)), false);
    }

    @Override
    public Long size() {
        return turnStatusRepository.count();
    }

    @Override
    public Boolean isExist(Long id) {
        return turnStatusRepository.existsById(id);
    }

    @Override
    public TurnStatus findById(Long id) throws IdNotFound {
        return TurnStatusMapper.toDto(turnStatusRepository.findById(id).orElseThrow(() -> new IdNotFound(id)), false);
    }

    @Override
    public List<TurnStatus> find(String search) throws AttributesNotFound, ErrorType {
        if (search.equals("")){
            return findAll ();
        }
        return TurnStatusMapper.toDtos(turnStatusRepository.findAll(Search.expression(search, TmsTurnStatus.class)), false);
    }

    @Override
    public List<TurnStatus> find(String search, int page, int size) throws AttributesNotFound, ErrorType {
        if (search.equals("")){
            return findAll (page, size);
        }
        Sort sort = Sort.by(Sort.Direction.DESC, "updateDate");
        Pageable pageable = PageRequest.of(page, size, sort);
        return TurnStatusMapper.toDtos(turnStatusRepository.findAll(Search.expression(search, TmsTurnStatus.class), pageable), false);
    }

    @Override
    public Long size(String search) throws AttributesNotFound, ErrorType {
        if (search.equals("")){
            return size ();
        }
        return turnStatusRepository.count(Search.expression(search, TmsTurnStatus.class));
    }

    @Override
    public void delete(Long id) {
        turnStatusRepository.deleteById(id);
    }

    @Override
    public void delete(TurnStatus turnStatus) {
        turnStatusRepository.delete(TurnStatusMapper.toEntity(turnStatus, false));
    }


    @Override
    public void deleteAll(List<Long> ids) {

        for (Long id : ids) {
            turnStatusRepository.deleteById(id);        }
    }


    @Override
    public List<TurnStatus> findAll() {
        return TurnStatusMapper.toDtos(turnStatusRepository.findAll(), false);
    }

    @Override
    public List<TurnStatus> findAll(int page, int size) {
        Sort sort = Sort.by(Sort.Direction.DESC, "updateDate");
        Pageable pageable = PageRequest.of(page, size, sort);
        return TurnStatusMapper.toDtos(turnStatusRepository.findAll(pageable), false);
    }

    @Override
    public TurnStatus findOne(String search) throws AttributesNotFound, ErrorType {
        return null;
    }

}

