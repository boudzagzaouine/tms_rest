package com.bagile.tms.services.impl;

import com.bagile.tms.dto.TurnLine;
import com.bagile.tms.dto.TurnLine;
import com.bagile.tms.entities.TmsTurnLine;
import com.bagile.tms.exceptions.AttributesNotFound;
import com.bagile.tms.exceptions.CustomException;
import com.bagile.tms.exceptions.ErrorType;
import com.bagile.tms.exceptions.IdNotFound;
import com.bagile.tms.mapper.TurnLineMapper;
import com.bagile.tms.repositories.TurnLineRepository;
import com.bagile.tms.services.TurnLineService;
import com.bagile.tms.util.Search;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;


@Service
@Transactional
public class TurnLineServiceImpl implements TurnLineService {
    private final TurnLineRepository turnLineRepository;
    
    public TurnLineServiceImpl(TurnLineRepository turnLineRepository) {
        this.turnLineRepository = turnLineRepository;
    }

    @Override
    public TurnLine save(TurnLine turnLine) {
        return TurnLineMapper.toDto(turnLineRepository.saveAndFlush(TurnLineMapper.toEntity(turnLine, false)), false);
    }

    @Override
    public List<TurnLine> saveAll(List<TurnLine> turnLines) {

          List<TurnLine> turnLines1 = new ArrayList<>();
         for (TurnLine turnLine : turnLines)
        {
            turnLines1.add(save(turnLine));
        }

         return turnLines1;

    }

    @Override
    public Long size() {
        return turnLineRepository.count();
    }

    @Override
    public Boolean isExist(Long id) {
        return turnLineRepository.existsById(id);
    }

    @Override
    public TurnLine findById(Long id) throws IdNotFound {
        return TurnLineMapper.toDto(turnLineRepository.findById(id).orElseThrow(() -> new IdNotFound(id)), false);
    }

    @Override
    public TurnLine findOne(String search) throws AttributesNotFound, ErrorType {
        return null;
    }

    @Override
    public List<TurnLine> find(String search) throws AttributesNotFound, ErrorType {
        if (search.equals("")){
            return findAll ();
        }
        return TurnLineMapper.toDtos(turnLineRepository.findAll(Search.expression(search, TmsTurnLine.class)), false);
    }

    @Override
    public List<TurnLine> find(String search, int page, int size) throws AttributesNotFound, ErrorType {
        if (search.equals("")){
            return findAll (page, size);
        }
        Sort sort = Sort.by(Sort.Direction.DESC, "updateDate");
        Pageable pageable = PageRequest.of(page, size, sort);
        return TurnLineMapper.toDtos(turnLineRepository.findAll(Search.expression(search, TmsTurnLine.class), pageable), false);
    }

    @Override
    public Long size(String search) throws AttributesNotFound, ErrorType {
        if (search.equals("")){
            return size ();
        }
        return turnLineRepository.count(Search.expression(search, TmsTurnLine.class));
    }

    @Override
    public void delete(Long id) {
        turnLineRepository.deleteById(id);
    }

    @Override
    public void delete(TurnLine turnLine) {
        turnLineRepository.delete(TurnLineMapper.toEntity(turnLine, false));
    }

    @Override
    public List<TurnLine> findAll() {
        return TurnLineMapper.toDtos(turnLineRepository.findAll(), false);
    }


    @Override
    public String getNextVal() {
        return null;
    }


    @Override
    public List<TurnLine> findAll(int page, int size) {
        Sort sort = Sort.by(Sort.Direction.DESC, "updateDate");
        Pageable pageable = PageRequest.of(page, size, sort);
        return TurnLineMapper.toDtos(turnLineRepository.findAll(pageable), false);
    }

}

