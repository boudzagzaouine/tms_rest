package com.bagile.gmo.services.impl;

import com.bagile.gmo.dto.TurnSoPo;
import com.bagile.gmo.entities.TmsTurnSoPo;
import com.bagile.gmo.exceptions.AttributesNotFound;
import com.bagile.gmo.exceptions.ErrorType;
import com.bagile.gmo.exceptions.IdNotFound;
import com.bagile.gmo.mapper.TurnSoPoMapper;
import com.bagile.gmo.repositories.TurnSoPoRepository;
import com.bagile.gmo.services.TurnSoPoService;
import com.bagile.gmo.util.Search;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;


@Service
public class TurnSoPoServiceImpl implements TurnSoPoService {

    private final TurnSoPoRepository turnSoPoRepository;

    public TurnSoPoServiceImpl(TurnSoPoRepository turnSoPoRepository) {
        this.turnSoPoRepository = turnSoPoRepository;
    }

    @Override
    public TurnSoPo save(TurnSoPo turnSoPo) {
        return TurnSoPoMapper.toDto(turnSoPoRepository.saveAndFlush(TurnSoPoMapper.toEntity(turnSoPo, false)), false);
    }

    @Override
    public List<TurnSoPo> saveAll(List<TurnSoPo> turnSoPos) throws AttributesNotFound, ErrorType {

        List<TurnSoPo> turnSoPoList = new ArrayList<>();

        for (TurnSoPo turnSoPo : turnSoPos) {
            turnSoPoList.add(save(turnSoPo));
        }

        return turnSoPoList;

    }

    @Override
    public Long size() {
        return turnSoPoRepository.count();
    }

    @Override
    public Boolean isExist(Long id) {
        return turnSoPoRepository.existsById(id);
    }

    @Override
    public TurnSoPo findById(Long id) throws IdNotFound {
        return TurnSoPoMapper.toDto(turnSoPoRepository.findById(id).orElseThrow(() -> new IdNotFound(id)), false);
    }

    @Override
    public List<TurnSoPo> find(String search) throws AttributesNotFound, ErrorType {
        if (search.equals("")){
            return findAll ();
        }
        return TurnSoPoMapper.toDtos(turnSoPoRepository.findAll(Search.expression(search, TmsTurnSoPo.class)), false);
    }

    @Override
    public List<TurnSoPo> find(String search, int page, int size) throws AttributesNotFound, ErrorType {
        if (search.equals("")){
            return findAll (page, size);
        }
        Sort sort = Sort.by(Sort.Direction.DESC, "updateDate");
        Pageable pageable = PageRequest.of(page, size, sort);
        return TurnSoPoMapper.toDtos(turnSoPoRepository.findAll(Search.expression(search, TmsTurnSoPo.class), pageable), false);
    }

    @Override
    public Long size(String search) throws AttributesNotFound, ErrorType {
        if (search.equals("")){
            return size ();
        }
        return turnSoPoRepository.count(Search.expression(search, TmsTurnSoPo.class));
    }

    @Override
    public void delete(Long id) {
        turnSoPoRepository.deleteById(id);
    }

    @Override
    public void delete(TurnSoPo turnSoPo) {
        turnSoPoRepository.delete(TurnSoPoMapper.toEntity(turnSoPo, false));
    }


    @Override
    public void deleteAll(List<Long> ids) {

        for (Long id : ids) {
            turnSoPoRepository.deleteById(id);        }
    }


    @Override
    public List<TurnSoPo> findAll()
    {
        return TurnSoPoMapper.toDtos(turnSoPoRepository.findAll(), false);
    }

    @Override
    public List<TurnSoPo> findAll(int page, int size) {
        Sort sort = Sort.by(Sort.Direction.DESC, "updateDate");
        Pageable pageable = PageRequest.of(page, size, sort);
        return TurnSoPoMapper.toDtos(turnSoPoRepository.findAll(pageable), false);
    }

}

