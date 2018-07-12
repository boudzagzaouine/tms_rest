package com.sinno.ems.service.impl;

import com.sinno.ems.exception.AttributesNotFound;
import com.sinno.ems.exception.ErrorType;
import com.sinno.ems.exception.IdNotFound;
import com.sinno.ems.mapper.ZoneWarehouseMapper;
import com.sinno.ems.service.ZoneWarehouseService;
import com.sinno.ems.util.Search;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Enissay on 21/06/2016.
 */
@Service
public class ZoneWarehouseServiceImpl implements ZoneWarehouseService {
    @Autowired
    private ZoneWarehouseRepository zoneWarehouseRepository;
    private final static Logger LOGGER = LoggerFactory
            .getLogger(ZoneWarehouseService.class);

    @Override
    public ZoneWarehouse save(ZoneWarehouse zoneWarehouse) {
        LOGGER.info("save ZoneWarehouse");
        return ZoneWarehouseMapper.toDto(zoneWarehouseRepository.saveAndFlush(ZoneWarehouseMapper.toEntity(zoneWarehouse, false)), false);
    }

    @Override
    public Long size() {
        return zoneWarehouseRepository.count();
    }

    @Override
    public Boolean isExist(Long id) {
        return zoneWarehouseRepository.exists(id);
    }

    @Override
    public ZoneWarehouse findById(Long id) throws IdNotFound {
        ZoneWarehouse zoneWarehouse = ZoneWarehouseMapper.toDto(zoneWarehouseRepository.findOne(id), false);
        if (null != zoneWarehouse) {
            return zoneWarehouse;
        } else {
            throw new IdNotFound(id);
        }
    }

    @Override
    public List<ZoneWarehouse> find(String search) throws AttributesNotFound, ErrorType {
        return ZoneWarehouseMapper.toDtos(zoneWarehouseRepository.findAll(Search.expression(search, LocZoneWarehouse.class)), false);
    }

    @Override
    public List<ZoneWarehouse> find(String search, Pageable pageable) throws AttributesNotFound, ErrorType {
        return ZoneWarehouseMapper.toDtos(zoneWarehouseRepository.findAll(Search.expression(search, LocZoneWarehouse.class), pageable), false);
    }

    @Override
    public Long size(String search) throws AttributesNotFound, ErrorType {
        return zoneWarehouseRepository.count(Search.expression(search, LocZoneWarehouse.class));
    }

    @Override
    public void delete(Long id) {
        LOGGER.info("delete ZoneWarehouse");
        zoneWarehouseRepository.delete(id);
    }

    @Override
    public void delete(ZoneWarehouse zoneWarehouse) {
        LOGGER.info("delete ZoneWarehouase");
        zoneWarehouseRepository.delete(ZoneWarehouseMapper.toEntity(zoneWarehouse, false));
    }

    @Override
    public List<ZoneWarehouse> findAll() {
        return ZoneWarehouseMapper.toDtos(zoneWarehouseRepository.findAll(), false);
    }

    @Override
    public List<ZoneWarehouse> findAll(Pageable pageable) {
        return ZoneWarehouseMapper.toDtos(zoneWarehouseRepository.findAll(pageable), false);
    }
}

