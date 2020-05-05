package com.bagile.tms.services.impl;

import com.bagile.gmo.dto.ConsumptionType;
import com.bagile.gmo.entities.TmsConsumptionType;
import com.bagile.gmo.mapper.ConsumptionTypeMapper;
import com.bagile.tms.exceptions.AttributesNotFound;
import com.bagile.tms.exceptions.ErrorType;
import com.bagile.tms.exceptions.IdNotFound;
import com.bagile.tms.repositories.ConsumptionTypeRepository;
import com.bagile.tms.services.ConsumptionTypeService;
import com.bagile.tms.util.Search;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


@Service
@Transactional
public class ConsumptionTypeServiceImpl implements ConsumptionTypeService {
    private final ConsumptionTypeRepository consumptionTypeRepository;
    public ConsumptionTypeServiceImpl(ConsumptionTypeRepository consumptionTypeRepository) {
        this.consumptionTypeRepository = consumptionTypeRepository;
    }

    @Override
    public ConsumptionType save(ConsumptionType consumptionType) {
        return ConsumptionTypeMapper.toDto(consumptionTypeRepository.saveAndFlush(ConsumptionTypeMapper.toEntity(consumptionType, false)), false);
    }

    @Override
    public Long size() {
        return consumptionTypeRepository.count();
    }

    @Override
    public Boolean isExist(Long id) {
        return consumptionTypeRepository.existsById(id);
    }

    @Override
    public ConsumptionType findById(Long id) throws IdNotFound {
        return ConsumptionTypeMapper.toDto(consumptionTypeRepository.findById(id).orElseThrow(() -> new IdNotFound(id)), false);
    }

    @Override
    public List<ConsumptionType> find(String search) throws AttributesNotFound, ErrorType {
        if (search.equals("")){
            return findAll ();
        }
        return ConsumptionTypeMapper.toDtos(consumptionTypeRepository.findAll(Search.expression(search, TmsConsumptionType.class)), false);
    }

    @Override
    public List<ConsumptionType> find(String search, int page, int size) throws AttributesNotFound, ErrorType {
        if (search.equals("")){
            return findAll (page, size);
        }
        Sort sort = Sort.by(Sort.Direction.DESC, "updateDate");
        Pageable pageable = PageRequest.of(page, size, sort);
        return ConsumptionTypeMapper.toDtos(consumptionTypeRepository.findAll(Search.expression(search, TmsConsumptionType.class), pageable), false);
    }

    @Override
    public Long size(String search) throws AttributesNotFound, ErrorType {
        if (search.equals("")){
            return size ();
        }
        return consumptionTypeRepository.count(Search.expression(search, TmsConsumptionType.class));
    }

    @Override
    public void delete(Long id) {
        consumptionTypeRepository.deleteById(id);
    }

    @Override
    public void delete(ConsumptionType consumptionType) {
        consumptionTypeRepository.delete(ConsumptionTypeMapper.toEntity(consumptionType, false));
    }

    @Override
    public void deleteAll(List<Long> ids) {

        for (Long id : ids) {
            consumptionTypeRepository.deleteById(id);        }
    }
    @Override
    public List<ConsumptionType> findAll() {
        return ConsumptionTypeMapper.toDtos(consumptionTypeRepository.findAll(), false);
    }

    @Override
    public List<ConsumptionType> findAll(int page, int size) {
        Sort sort = Sort.by(Sort.Direction.DESC, "updateDate");
        Pageable pageable = PageRequest.of(page, size, sort);
        return ConsumptionTypeMapper.toDtos(consumptionTypeRepository.findAll(pageable), false);
    }

}

