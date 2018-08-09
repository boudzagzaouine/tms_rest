package com.bagile.tms.services.impl;

import com.bagile.tms.dto.Driver;
import com.bagile.tms.entities.TmsDriver;
import com.bagile.tms.exceptions.AttributesNotFound;
import com.bagile.tms.exceptions.ErrorType;
import com.bagile.tms.exceptions.IdNotFound;
import com.bagile.tms.mapper.DriverMapper;
import com.bagile.tms.repositories.DriverRepository;
import com.bagile.tms.services.DriverService;
import com.bagile.tms.util.EmsDate;
import com.bagile.tms.util.Search;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class DriverServiceImpl implements DriverService {
    @Autowired
    private DriverRepository driverRepository;
    private final static Logger LOGGER = LoggerFactory
            .getLogger(DriverService.class);

    @Override
    public Driver save(Driver driver) {
        LOGGER.info("save Driver");
        driver.setUpDateDate(EmsDate.getDateNow());
        if (0 <= driver.getId()) {
            driver.setCreationDate(EmsDate.getDateNow());
        }
        return DriverMapper.toDto(driverRepository.saveAndFlush(DriverMapper.toEntity(driver, false)), false);
    }

    @Override
    public Long size() {
        return driverRepository.count();
    }

    @Override
    public Boolean isExist(Long id) {
        return driverRepository.existsById(id);
    }

    @Override
    public Driver findById(Long id) throws IdNotFound {
        Driver driver = DriverMapper.toDto(driverRepository.findById(id).get(), false);
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
        driverRepository.deleteById(id);
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

    @Override
    public void archive(Long id) {
        LOGGER.info("archive Driver");
        Driver driver = DriverMapper.toDto(driverRepository.findById(id).get(), false);
        if (null != driver) {
            driver.setWorking(false);
        }
        DriverMapper.toDto(driverRepository.saveAndFlush(DriverMapper.toEntity(driver, false)), false);

    }
}
