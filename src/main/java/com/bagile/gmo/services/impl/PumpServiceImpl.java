package com.bagile.gmo.services.impl;

import com.bagile.gmo.dto.Pump;
import com.bagile.gmo.entities.GmoPump;
import com.bagile.gmo.exceptions.AttributesNotFound;
import com.bagile.gmo.exceptions.ErrorType;
import com.bagile.gmo.exceptions.IdNotFound;
import com.bagile.gmo.mapper.PumpMapper;
import com.bagile.gmo.repositories.PumpRepository;
import com.bagile.gmo.services.PumpService;
import com.bagile.gmo.util.Search;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


@Service
@Transactional
public class PumpServiceImpl implements PumpService {

    private final PumpRepository pumpRepository;
    public PumpServiceImpl(PumpRepository pumpRepository) {
        this.pumpRepository = pumpRepository;
    }

    @Override
    public Pump save(Pump pump) {
        return PumpMapper.toDto(pumpRepository.saveAndFlush(PumpMapper.toEntity(pump, false)), false);
    }

    @Override
    public Long size() {
        return pumpRepository.count();
    }

    @Override
    public Boolean isExist(Long id) {
        return pumpRepository.existsById(id);
    }

    @Override
    public Pump findById(Long id) throws IdNotFound {
        return PumpMapper.toDto(pumpRepository.findById(id).orElseThrow(() -> new IdNotFound(id)), false);
    }

    @Override
    public List<Pump> find(String search) throws AttributesNotFound, ErrorType {
        if (search.equals("")){
            return findAll ();
        }
        return PumpMapper.toDtos(pumpRepository.findAll(Search.expression(search, GmoPump.class)), false);
    }

    @Override
    public List<Pump> find(String search, int page, int size) throws AttributesNotFound, ErrorType {
        if (search.equals("")){
            return findAll (page, size);
        }
        Sort sort = Sort.by(Sort.Direction.DESC, "updateDate");
        Pageable pageable = PageRequest.of(page, size, sort);
        return PumpMapper.toDtos(pumpRepository.findAll(Search.expression(search, GmoPump.class), pageable), false);
    }

    @Override
    public Long size(String search) throws AttributesNotFound, ErrorType {
        if (search.equals("")){
            return size ();
        }
        return pumpRepository.count(Search.expression(search, GmoPump.class));
    }

    @Override
    public void delete(Long id) {
        pumpRepository.deleteById(id);
    }

    @Override
    public void delete(Pump pump) {
        pumpRepository.delete(PumpMapper.toEntity(pump, false));
    }

    @Override
    public List<Pump> findAll() {
        return PumpMapper.toDtos(pumpRepository.findAll(), false);
    }

    @Override
    public List<Pump> findAll(int page, int size) {
        Sort sort = Sort.by(Sort.Direction.DESC, "updateDate");
        Pageable pageable = PageRequest.of(page, size, sort);
        return PumpMapper.toDtos(pumpRepository.findAll(pageable), false);
    }

}

