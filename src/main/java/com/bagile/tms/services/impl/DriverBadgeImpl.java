package com.bagile.tms.services.impl;

import com.sinno.ems.dto.DriverBadge;
import com.sinno.ems.entities.TmsDriverBadge;
import com.sinno.ems.exception.AttributesNotFound;
import com.sinno.ems.exception.ErrorType;
import com.sinno.ems.exception.IdNotFound;
import com.sinno.ems.mapper.DriverBadgeMapper;
import com.sinno.ems.repositories.DriverBadgeRepository;
import com.sinno.ems.service.DriverBadgeService;
import com.sinno.ems.util.Search;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by bouzi on 4/26/2017.
 */
@Service
public class DriverBadgeImpl implements DriverBadgeService {
    @Autowired
    private DriverBadgeRepository driverBadgeRepository;
    private final static Logger LOGGER = LoggerFactory
            .getLogger(DriverBadgeService.class);
    @Override
    public DriverBadge save(DriverBadge driverBadge){
        LOGGER.info("save DriverBadge");
        return DriverBadgeMapper.toDto(driverBadgeRepository.saveAndFlush(DriverBadgeMapper.toEntity(driverBadge, false)), false);

    }
    @Override
    public Long size() {
        return driverBadgeRepository.count();
    }
    @Override
    public Boolean isExist(Long id) {
        return driverBadgeRepository.exists(id);
    }
    @Override
    public DriverBadge findById(Long id) throws IdNotFound {
        DriverBadge driverBadge = DriverBadgeMapper.toDto(driverBadgeRepository.findOne(id), false);
        if (null != driverBadge) {
            return driverBadge;
        } else {
            throw new IdNotFound(id);
        }
    }
    @Override
    public List<DriverBadge> find(String search) throws AttributesNotFound, ErrorType {
        return DriverBadgeMapper.toDtos(driverBadgeRepository.findAll(Search.expression(search, TmsDriverBadge.class)), false);
    }
    @Override
    public List<DriverBadge> find(String search, Pageable pageable) throws AttributesNotFound, ErrorType {
        return DriverBadgeMapper.toDtos(driverBadgeRepository.findAll(Search.expression(search,TmsDriverBadge.class), pageable), false);
    }
    @Override
    public Long size(String search) throws AttributesNotFound, ErrorType {
        return driverBadgeRepository.count(Search.expression(search,TmsDriverBadge.class));
    }
    @Override
    public void delete(Long id) {
        LOGGER.info("save Badge");
        driverBadgeRepository.delete(id);
    }
    @Override
    public void delete(DriverBadge driverBadge) {
        LOGGER.info("delete Badge");
       driverBadgeRepository.delete(DriverBadgeMapper.toEntity(driverBadge, false));
    }
    @Override
    public List<DriverBadge> findAll() {
        return DriverBadgeMapper.toDtos(driverBadgeRepository.findAll(), false);
    }
    @Override
    public List<DriverBadge> findAll(Pageable pageable) {
        return DriverBadgeMapper.toDtos(driverBadgeRepository.findAll(pageable), false);
    }
}
