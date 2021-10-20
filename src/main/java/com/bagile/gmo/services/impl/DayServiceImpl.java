package com.bagile.gmo.services.impl;

import com.bagile.gmo.dto.Day;
import com.bagile.gmo.entities.GmoDay;
import com.bagile.gmo.exceptions.AttributesNotFound;
import com.bagile.gmo.exceptions.ErrorType;
import com.bagile.gmo.exceptions.IdNotFound;
import com.bagile.gmo.mapper.DayMapper;
import com.bagile.gmo.repositories.DayRepository;
import com.bagile.gmo.services.DayService;
import com.bagile.gmo.util.Search;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;


@Service
public class DayServiceImpl implements DayService {

    private final DayRepository dayRepository;
    public DayServiceImpl(DayRepository dayRepository) {
        this.dayRepository = dayRepository;
    }

    @Override
    public Day save(Day day) {
        return DayMapper.toDto(dayRepository.save(DayMapper.toEntity(day, false)), false);
    }

    @Override
    public List<Day> saveAll(List<Day> days) {

        List<Day> DayList = new ArrayList<>( );
        for (Day action : days) {
            DayList.add (save (action));
        }

        return DayList;

    }

    @Override
    public Long size() {
        return dayRepository.count();
    }

    @Override
    public Boolean isExist(Long id) {
        return dayRepository.existsById(id);
    }

    @Override
    public Day findById(Long id) throws IdNotFound {
        return DayMapper.toDto(dayRepository.findById(id).orElseThrow(() -> new IdNotFound(id)), false);

    }


    @Override
    public List<Day> find(String search) throws AttributesNotFound, ErrorType {
        if (search.equals("")){
            return findAll ();
        }
        return DayMapper.toDtos(dayRepository.findAll(Search.expression(search, GmoDay.class)), false);
    }

    @Override
    public List<Day> find(String search, int page, int size) throws AttributesNotFound, ErrorType {
        if (search.equals("")){
            return findAll (page, size);
        }
        Sort sort = Sort.by(Sort.Direction.DESC, "updateDate");
        Pageable pageable = PageRequest.of(page, size, sort);
        return DayMapper.toDtos(dayRepository.findAll(Search.expression(search, GmoDay.class), pageable), false);
    }

    @Override
    public Day findOne(String search) throws AttributesNotFound, ErrorType {
        return DayMapper.toDto (dayRepository.findOne (Search.expression (search, GmoDay.class)).orElseThrow (() -> new AttributesNotFound (search)), false);

    }

    @Override
    public Long size(String search) throws AttributesNotFound, ErrorType {
        if (search.equals("")){
            return size ();
        }
        return dayRepository.count(Search.expression(search, GmoDay.class));
    }

    @Override
    public void delete(Long id) {
        dayRepository.deleteById(id);
    }

    @Override
    public void delete(Day day) {
        dayRepository.delete(DayMapper.toEntity(day, false));
    }

    @Override
    public void deleteAll(List<Long> ids) {

        for (Long id : ids) {
            dayRepository.deleteById(id);        }
    }
    @Override
    public List<Day> findAll() {
        return DayMapper.toDtos(dayRepository.findAll(), false);
    }

    @Override
    public List<Day> findAll(int page, int size) {
        Sort sort = Sort.by(Sort.Direction.DESC, "updateDate");
        Pageable pageable = PageRequest.of(page, size, sort);
        return DayMapper.toDtos(dayRepository.findAll(pageable), false);
    }



}

