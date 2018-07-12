package com.sinno.ems.service.impl;

import com.sinno.ems.exception.AttributesNotFound;
import com.sinno.ems.exception.ErrorType;
import com.sinno.ems.exception.IdNotFound;
import com.sinno.ems.mapper.AisleMapper;
import com.sinno.ems.service.AisleService;
import com.sinno.ems.util.EmsDate;
import com.sinno.ems.util.Search;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AisleServiceImpl implements AisleService {

    @Autowired
    private AisleRepository aisleRepository;
    private final static Logger LOGGER = LoggerFactory
            .getLogger(AisleService.class);
    @Override
    public Aisle save(Aisle aisle) {
        LOGGER.info("save Aisle");
        aisle.setUpdateDate(EmsDate.getDateNow());
        if (0 >= aisle.getId()) {
            aisle.setCreationDate(EmsDate.getDateNow());
        }
        return AisleMapper.toDto(aisleRepository.saveAndFlush(AisleMapper.toEntity(aisle, false)), false);
    }

    @Override
    public Long size() {
        return aisleRepository.count();
    }

    @Override
    public Boolean isExist(Long id) {
        return aisleRepository.exists(id);
    }

    @Override
    public Aisle findById(Long id) throws IdNotFound {
        Aisle aisle = AisleMapper.toDto(aisleRepository.findOne(id), false);
        if (null != aisle) {
            return aisle;
        } else {
            throw new IdNotFound(id);
        }
    }

    @Override
    public List<Aisle> find(String search) throws AttributesNotFound, ErrorType {
        return AisleMapper.toDtos(aisleRepository.findAll(Search.expression(search, LocAisle.class)), false);
    }

    @Override
    public List<Aisle> find(String search, Pageable pageable) throws AttributesNotFound, ErrorType {
        return AisleMapper.toDtos(aisleRepository.findAll(Search.expression(search, LocAisle.class), pageable), false);
    }

    @Override
    public Long size(String search) throws AttributesNotFound, ErrorType {
        return aisleRepository.count(Search.expression(search, LocAisle.class));
    }

    @Override
    public void delete(Long id) {
        LOGGER.info("delete Aisle");
        aisleRepository.delete(id);
    }

    @Override
    public void delete(Aisle aisle) {
        LOGGER.info("delete Aisle");
        aisleRepository.delete(AisleMapper.toEntity(aisle, false));
    }

    @Override
    public List<Aisle> findAll() {
        return AisleMapper.toDtos(aisleRepository.findAll(), false);
    }

    @Override
    public List<Aisle> findAll(Pageable pageable) {
        return AisleMapper.toDtos(aisleRepository.findAll(pageable), false);
    }
}