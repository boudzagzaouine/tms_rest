package com.sinno.ems.service.impl;

import com.sinno.ems.dto.Driver;
import com.sinno.ems.entities.TmsDriver;
import com.sinno.ems.exception.AttributesNotFound;
import com.sinno.ems.exception.ErrorType;
import com.sinno.ems.exception.IdNotFound;
import com.sinno.ems.mapper.DriverMapper;
import com.sinno.ems.repositories.DriverRepository;
import com.sinno.ems.service.DriverService;
import com.sinno.ems.util.EmsDate;
import com.sinno.ems.util.Search;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;


import java.util.List;

/**
 * Created by khalil on 28/03/2017.
 */
@Service
public class DriverServiceImpl implements DriverService {
    @Autowired
    private DriverRepository driverRepository;
    private final static Logger LOGGER = LoggerFactory
            .getLogger(DriverService.class);

    @Override
    public Driver save(Driver driver) {
        LOGGER.info("save Driver");
        driver.setBirthDay(EmsDate.getDateNow());
        if(0<=driver.getId())
        {
            driver.setBirthDay(EmsDate.getDateNow());
        }
        return DriverMapper.toDto(driverRepository.saveAndFlush(DriverMapper.toEntity(driver, false)), false);
    }
    @Override
    public Long size() {
        return driverRepository.count();
    }

    @Override
    public Boolean isExist(Long id) {
        return driverRepository.exists(id);
    }

    @Override
    public Driver findById(Long id) throws IdNotFound {
        Driver driver = DriverMapper.toDto(driverRepository.findOne(id), false);
        if (null != driver) {
            return driver;
        } else {
            throw new IdNotFound(id);
        }
    }

    @Override
    public List<Driver> find(String search) throws AttributesNotFound, ErrorType {
        return DriverMapper.toDtos(driverRepository.findAll(Search.expression(search, TmsDriver.class)), false);
    }
    @Override
    public List<Driver> find(String search, Pageable pageable) throws AttributesNotFound, ErrorType {
        return DriverMapper.toDtos(driverRepository.findAll(Search.expression(search, TmsDriver.class), pageable), false);
    }

    @Override
    public Long size(String search) throws AttributesNotFound, ErrorType {
        return driverRepository.count(Search.expression(search, TmsDriver.class));
    }
    @Override
    public void delete(Long id) {
        LOGGER.info("save Driver");
        driverRepository.delete(id);
    }

    @Override
    public void delete(Driver driver) {
        LOGGER.info("delete Driver");
        driverRepository.delete(DriverMapper.toEntity(driver, false));
    }

    @Override
    public List<Driver> findAll() {
        return DriverMapper.toDtos(driverRepository.findAll(), false);
    }
    @Override
    public List<Driver> findAll(Pageable pageable) {
        return DriverMapper.toDtos(driverRepository.findAll(pageable), false);
    }



}
