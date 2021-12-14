package com.bagile.gmo.services.impl;

import com.bagile.gmo.dto.Holiday;
import com.bagile.gmo.entities.TmsHoliday;
import com.bagile.gmo.exceptions.AttributesNotFound;
import com.bagile.gmo.exceptions.ErrorType;
import com.bagile.gmo.exceptions.IdNotFound;
import com.bagile.gmo.mapper.HolidayMapper;
import com.bagile.gmo.repositories.HolidayRepository;
import com.bagile.gmo.services.HolidayService;
import com.bagile.gmo.util.Search;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class HolidayServiceImpl implements HolidayService {

    private final HolidayRepository accountHolidayRepository;

    public HolidayServiceImpl(HolidayRepository accountHolidayRepository) {
        this.accountHolidayRepository = accountHolidayRepository;
    }

    @Override
    public Holiday save(Holiday accountHoliday) {
        return HolidayMapper.toDto(accountHolidayRepository.saveAndFlush(HolidayMapper.toEntity(accountHoliday, false)), false);
    }

    @Override
    public Long size() {
        return accountHolidayRepository.count();
    }

    @Override
    public Boolean isExist(Long id) {
        return accountHolidayRepository.existsById(id);
    }

    @Override
    public Holiday findById(Long id) throws IdNotFound {
        return HolidayMapper.toDto(accountHolidayRepository.findById(id).orElseThrow(() -> new IdNotFound(id)), false);
    }

    @Override
    public List<Holiday> find(String search) throws AttributesNotFound, ErrorType {
        if (search.equals("")){
            return findAll ();
        }
        return HolidayMapper.toDtos(accountHolidayRepository.findAll(Search.expression(search, TmsHoliday.class)), false);
    }

    @Override
    public List<Holiday> find(String search, int page, int size) throws AttributesNotFound, ErrorType {
        if (search.equals("")){
            return findAll (page, size);
        }
        Sort sort = Sort.by(Sort.Direction.DESC, "updateDate");
        Pageable pageable = PageRequest.of(page, size, sort);
        return HolidayMapper.toDtos(accountHolidayRepository.findAll(Search.expression(search, TmsHoliday.class), pageable), false);
    }

    @Override
    public Long size(String search) throws AttributesNotFound, ErrorType {
        if (search.equals("")){
            return size ();
        }
        return accountHolidayRepository.count(Search.expression(search, TmsHoliday.class));
    }

    @Override
    public void delete(Long id) {
        accountHolidayRepository.deleteById(id);
    }

    @Override
    public void delete(Holiday accountHoliday) {
        accountHolidayRepository.delete(HolidayMapper.toEntity(accountHoliday, false));
    }


    @Override
    public void deleteAll(List<Long> ids) {

        for (Long id : ids) {
            accountHolidayRepository.deleteById(id);        }
    }


    @Override
    public List<Holiday> findAll()
    {
        return HolidayMapper.toDtos(accountHolidayRepository.findAll(), false);
    }

    @Override
    public List<Holiday> findAll(int page, int size) {
        Sort sort = Sort.by(Sort.Direction.DESC, "updateDate");
        Pageable pageable = PageRequest.of(page, size, sort);
        return HolidayMapper.toDtos(accountHolidayRepository.findAll(pageable), false);
    }

}

