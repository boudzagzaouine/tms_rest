package com.bagile.gmo.services.impl;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.bagile.gmo.dto.Driver;
import com.bagile.gmo.entities.GmoDriver;
import com.bagile.gmo.mapper.DriverMapper;
import com.bagile.gmo.exceptions.AttributesNotFound;
import com.bagile.gmo.exceptions.ErrorType;
import com.bagile.gmo.exceptions.IdNotFound;
import com.bagile.gmo.repositories.DriverRepository;
import com.bagile.gmo.services.ContactService;
import com.bagile.gmo.services.DriverService;
import com.bagile.gmo.util.EmsDate;
import com.bagile.gmo.util.Search;

@Service
@Transactional
public class DriverServiceImpl implements DriverService {
    private final DriverRepository driverRepository;
    private final ContactService contactService;
    private final static Logger LOGGER = LoggerFactory
            .getLogger(DriverService.class);

    public DriverServiceImpl(DriverRepository driverRepository, ContactService contactService) {
        this.driverRepository = driverRepository;
        this.contactService = contactService;
    }

    @Override
    public Driver save(Driver driver) {
        LOGGER.info("save Driver");
        driver.setUpdateDate(EmsDate.getDateNow());
        if (0 <= driver.getId()) {
            driver.setCreationDate(EmsDate.getDateNow());
        }

        return DriverMapper.toDto(driverRepository.saveAndFlush(DriverMapper.toEntity(driver, false)), false);
    }

    @Override
    public Long size() {
        long count = driverRepository.count();
        return count;
    }

    @Override
    public Boolean isExist(Long id) {
        return driverRepository.existsById(id);
    }

    @Override
    public Driver findById(Long id) throws IdNotFound {
        return DriverMapper.toDto(driverRepository.findById(id).orElseThrow(() -> new IdNotFound(id)),false);
    }

    @Override
    public List<Driver> find(String search) throws AttributesNotFound, ErrorType {
        if (search.equals ("")){
            return findAll ();
        }
        return DriverMapper.toDtos(driverRepository.findAll(Search.expression(search, GmoDriver.class)), false);
    }

    @Override
    public List<Driver> find(String search, int page, int size) throws AttributesNotFound, ErrorType {
        if (search.equals("")){
            return findAll (page, size);
        }
        //Sort sort = Sort.by(Sort.Direction.DESC, "updateDate");
        Pageable pageable = PageRequest.of(page, size);
        List<Driver> drivers = DriverMapper.toDtos(driverRepository.findAll(Search.expression(search, GmoDriver.class), pageable), false);
        return drivers;
    }

    @Override
    public Long size(String search) throws AttributesNotFound, ErrorType {
        if ("".equals(search)) {
            return size();
        }
        return driverRepository.count(Search.expression(search, GmoDriver.class));
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
    public List<Driver> findAll(int page, int size) {
        //Sort sort = Sort.by(Sort.Direction.DESC, "updateDate");
        Pageable pageable = PageRequest.of(page, size);
        return DriverMapper.toDtos(driverRepository.findAll(pageable), false);
    }

    @Override
    public void archive(Long id) throws IdNotFound {
        LOGGER.info("archive Driver");
        Driver driver = DriverMapper.toDto(driverRepository.findById(id).orElseThrow(() -> new IdNotFound(id)), false);
        driver.setWorking(false);
        DriverMapper.toDto(driverRepository.saveAndFlush(DriverMapper.toEntity(driver, false)), false);

    }
}
