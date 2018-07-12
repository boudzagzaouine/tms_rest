package com.sinno.ems.service.impl;

import com.sinno.ems.exception.AttributesNotFound;
import com.sinno.ems.exception.ErrorType;
import com.sinno.ems.exception.IdNotFound;
import com.sinno.ems.mapper.LocationStatusMapper;
import com.sinno.ems.repositories.LocationStatusRepository;
import com.sinno.ems.service.LocationStatusService;
import com.sinno.ems.util.Search;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Enissay on 04/05/2016.
 */
@Service
public class LocationStatusServiceImpl implements LocationStatusService {
    @Autowired
    private LocationStatusRepository locationStatusRepository;
    private final static Logger LOGGER = LoggerFactory
            .getLogger(LocationStatusService.class);

    @Override
    public LocationStatus save(LocationStatus locationStatus) {
        LOGGER.info("save LocationStatus");
        return LocationStatusMapper.toDto(locationStatusRepository.saveAndFlush(LocationStatusMapper.toEntity(locationStatus, false)), false);
    }

    @Override
    public Long size() {
        return locationStatusRepository.count();
    }

    @Override
    public Boolean isExist(Long id) {
        return locationStatusRepository.exists(id);
    }

    @Override
    public LocationStatus findById(Long id) throws IdNotFound {
        LocationStatus locationStatus = LocationStatusMapper.toDto(locationStatusRepository.findOne(id), false);
        if (null != locationStatus) {
            return locationStatus;
        } else {
            throw new IdNotFound(id);
        }
    }

    @Override
    public List<LocationStatus> find(String search) throws AttributesNotFound, ErrorType {

        return LocationStatusMapper.toDtos(locationStatusRepository.findAll(Search.expression(search, PrmLocationStatus.class)), false);
    }

    @Override
    public List<LocationStatus> find(String search, Pageable pageable) throws AttributesNotFound, ErrorType {
        return LocationStatusMapper.toDtos(locationStatusRepository.findAll(Search.expression(search, PrmLocationStatus.class), pageable), false);
    }

    @Override
    public Long size(String search) throws AttributesNotFound, ErrorType {
        return locationStatusRepository.count(Search.expression(search, PrmLocationStatus.class));
    }

    @Override
    public void delete(Long id) {
        LOGGER.info("delete LocationStatus");
        locationStatusRepository.delete(id);
    }

    @Override
    public void delete(LocationStatus locationStatus) {
        LOGGER.info("delete LocationStatus");
        locationStatusRepository.delete(LocationStatusMapper.toEntity(locationStatus, false));
    }

    @Override
    public List<LocationStatus> findAll() {
        return LocationStatusMapper.toDtos(locationStatusRepository.findAll(), false);
    }

    @Override
    public List<LocationStatus> findAll(Pageable pageable) {
        return LocationStatusMapper.toDtos(locationStatusRepository.findAll(pageable), false);
    }
}
