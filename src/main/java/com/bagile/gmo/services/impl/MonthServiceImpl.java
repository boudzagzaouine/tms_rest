package com.bagile.gmo.services.impl;

import com.bagile.gmo.dto.Month;
import com.bagile.gmo.entities.GmoMonth;
import com.bagile.gmo.exceptions.AttributesNotFound;
import com.bagile.gmo.exceptions.ErrorType;
import com.bagile.gmo.exceptions.IdNotFound;
import com.bagile.gmo.mapper.MonthMapper;
import com.bagile.gmo.repositories.MonthRepository;
import com.bagile.gmo.services.MonthService;
import com.bagile.gmo.util.Search;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;


@Service
public class MonthServiceImpl implements MonthService {

    private final MonthRepository monthRepository;
    public MonthServiceImpl(MonthRepository monthRepository) {
        this.monthRepository = monthRepository;
    }

    @Override
    public Month save(Month month) {
        return MonthMapper.toDto(monthRepository.save(MonthMapper.toEntity(month, false)), false);
    }

    @Override
    public List<Month> saveAll(List<Month> months) {

        List<Month> MonthList = new ArrayList<>( );
        for (Month action : months) {
            MonthList.add (save (action));
        }

        return MonthList;

    }

    @Override
    public Long size() {
        return monthRepository.count();
    }

    @Override
    public Boolean isExist(Long id) {
        return monthRepository.existsById(id);
    }

    @Override
    public Month findById(Long id) throws IdNotFound {
        return MonthMapper.toDto(monthRepository.findById(id).orElseThrow(() -> new IdNotFound(id)), false);

    }


    @Override
    public List<Month> find(String search) throws AttributesNotFound, ErrorType {
        if (search.equals("")){
            return findAll ();
        }
        return MonthMapper.toDtos(monthRepository.findAll(Search.expression(search, GmoMonth.class)), false);
    }

    @Override
    public List<Month> find(String search, int page, int size) throws AttributesNotFound, ErrorType {
        if (search.equals("")){
            return findAll (page, size);
        }
        Sort sort = Sort.by(Sort.Direction.DESC, "updateDate");
        Pageable pageable = PageRequest.of(page, size, sort);
        return MonthMapper.toDtos(monthRepository.findAll(Search.expression(search, GmoMonth.class), pageable), false);
    }

    @Override
    public Month findOne(String search) throws AttributesNotFound, ErrorType {
        return MonthMapper.toDto (monthRepository.findOne (Search.expression (search, GmoMonth.class)).orElseThrow (() -> new AttributesNotFound (search)), false);

    }

    @Override
    public Long size(String search) throws AttributesNotFound, ErrorType {
        if (search.equals("")){
            return size ();
        }
        return monthRepository.count(Search.expression(search, GmoMonth.class));
    }

    @Override
    public void delete(Long id) {
        monthRepository.deleteById(id);
    }

    @Override
    public void delete(Month month) {
        monthRepository.delete(MonthMapper.toEntity(month, false));
    }

    @Override
    public void deleteAll(List<Long> ids) {

        for (Long id : ids) {
            monthRepository.deleteById(id);        }
    }
    @Override
    public List<Month> findAll() {
        return MonthMapper.toDtos(monthRepository.findAll(), false);
    }

    @Override
    public List<Month> findAll(int page, int size) {
        Sort sort = Sort.by(Sort.Direction.DESC, "updateDate");
        Pageable pageable = PageRequest.of(page, size, sort);
        return MonthMapper.toDtos(monthRepository.findAll(pageable), false);
    }



}

