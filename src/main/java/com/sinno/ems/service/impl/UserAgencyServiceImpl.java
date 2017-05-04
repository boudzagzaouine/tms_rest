package com.sinno.ems.service.impl;

import com.sinno.ems.dto.UserAgency;
import com.sinno.ems.entities.UsrUserAgency;
import com.sinno.ems.exception.AttributesNotFound;
import com.sinno.ems.exception.ErrorType;
import com.sinno.ems.exception.IdNotFound;
import com.sinno.ems.mapper.UserAgencyMapper;
import com.sinno.ems.repositories.UserAgencyRepository;
import com.sinno.ems.service.UserAgencyService;
import com.sinno.ems.util.Search;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Enissay on 03/01/2017.
 */
@Service
public class UserAgencyServiceImpl implements UserAgencyService {
    @Autowired
    private UserAgencyRepository userAgencyRepository;
    private final static Logger LOGGER = LoggerFactory
            .getLogger(UserAgencyService.class);

    @Override
    public UserAgency save(UserAgency zoneWarehouse) {
        LOGGER.info("save UserAgency");
        return UserAgencyMapper.toDto(userAgencyRepository.saveAndFlush(UserAgencyMapper.toEntity(zoneWarehouse, false)), false);
    }

    @Override
    public Long size() {
        return userAgencyRepository.count();
    }

    @Override
    public Boolean isExist(Long id) {
        return userAgencyRepository.exists(id);
    }

    @Override
    public UserAgency findById(Long id) throws IdNotFound {
        UserAgency zoneWarehouse = UserAgencyMapper.toDto(userAgencyRepository.findOne(id), false);
        if (null != zoneWarehouse) {
            return zoneWarehouse;
        } else {
            throw new IdNotFound(id);
        }
    }

    @Override
    public List<UserAgency> find(String search) throws AttributesNotFound, ErrorType {
        return UserAgencyMapper.toDtos(userAgencyRepository.findAll(Search.expression(search, UsrUserAgency.class)), false);
    }

    @Override
    public List<UserAgency> find(String search, Pageable pageable) throws AttributesNotFound, ErrorType {
        return UserAgencyMapper.toDtos(userAgencyRepository.findAll(Search.expression(search, UsrUserAgency.class), pageable), false);
    }

    @Override
    public Long size(String search) throws AttributesNotFound, ErrorType {
        return userAgencyRepository.count(Search.expression(search, UsrUserAgency.class));
    }

    @Override
    public void delete(Long id) {
        LOGGER.info("delete UserAgency");
        userAgencyRepository.delete(id);
    }

    @Override
    public void delete(UserAgency zoneWarehouse) {
        LOGGER.info("delete User agencies");
        userAgencyRepository.delete(UserAgencyMapper.toEntity(zoneWarehouse, false));
    }

    @Override
    public List<UserAgency> findAll() {
        return UserAgencyMapper.toDtos(userAgencyRepository.findAll(), false);
    }

    @Override
    public List<UserAgency> findAll(Pageable pageable) {
        return UserAgencyMapper.toDtos(userAgencyRepository.findAll(pageable), false);
    }
}
