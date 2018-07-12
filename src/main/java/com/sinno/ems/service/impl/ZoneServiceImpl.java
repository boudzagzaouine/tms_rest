package com.sinno.ems.service.impl;

import com.sinno.ems.exception.AttributesNotFound;
import com.sinno.ems.exception.ErrorType;
import com.sinno.ems.exception.IdNotFound;
import com.sinno.ems.mapper.ZoneMapper;
import com.sinno.ems.mapper.ZoneWarehouseMapper;
import com.sinno.ems.service.ZoneService;
import com.sinno.ems.util.EmsDate;
import com.sinno.ems.util.Search;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Iterator;
import java.util.List;
import java.util.Set;

@Service
public class ZoneServiceImpl implements ZoneService {

    @Autowired
    private ZoneRepository zoneRepository;
    @Autowired
    private ZoneWarehouseRepository zoneWarehouseRepository;
    private final static Logger LOGGER = LoggerFactory
            .getLogger(ZoneService.class);

    @Override
    public Zone save(Zone zone) {
        LOGGER.info("save Zone");
        zone.setUpdateDate(EmsDate.getDateNow());
        if (0 >= zone.getId()) {
            zone.setCreationDate(EmsDate.getDateNow());
        }
        return ZoneMapper.toDto(zoneRepository.saveAndFlush(ZoneMapper.toEntity(zone, false)), false);
    }

    @Override
    public Long size() {
        return zoneRepository.count();
    }

    @Override
    public Boolean isExist(Long id) {
        return zoneRepository.exists(id);
    }

    @Override
    public Zone findById(Long id) throws IdNotFound {
        Zone zone = ZoneMapper.toDto(zoneRepository.findOne(id), false);
        if (null != zone) {
            return zone;
        } else {
            throw new IdNotFound(id);
        }
    }

    @Override
    public List<Zone> find(String search) throws AttributesNotFound, ErrorType {
        return ZoneMapper.toDtos(zoneRepository.findAll(Search.expression(search, LocZone.class)), false);
    }

    @Override
    public List<Zone> find(String search, Pageable pageable) throws AttributesNotFound, ErrorType {
        return ZoneMapper.toDtos(zoneRepository.findAll(Search.expression(search, LocZone.class), pageable), false);
    }

    @Override
    public Long size(String search) throws AttributesNotFound, ErrorType {
        return zoneRepository.count(Search.expression(search, LocZone.class));
    }
    @Transactional
    @Override
    public void delete(Long id) {
        LOGGER.info("delete Zone");
        LocZone locZone = zoneRepository.findOne(id);
        Set<LocZoneWarehouse> zoneWarehouses = locZone.getLocZoneWarehouses();
        for (Iterator<LocZoneWarehouse> iterator = zoneWarehouses.iterator(); iterator.hasNext(); ) {
            LocZoneWarehouse zoneWarehouse = (LocZoneWarehouse) iterator.next();
            zoneWarehouseRepository.delete(zoneWarehouse);
        }

        zoneRepository.delete(id);
    }
    @Transactional
    @Override
    public void delete(Zone zone) {
        LOGGER.info("delete Zone");
        if (null != zone) {
            Set<ZoneWarehouse> zoneWarehouses = zone.getZoneWarehouses();
            if (null != zoneWarehouses) {
                if (0 != zoneWarehouses.size()) {
                    for (Iterator<ZoneWarehouse> iterator = zoneWarehouses.iterator(); iterator.hasNext(); ) {
                        ZoneWarehouse zoneWarehouse = (ZoneWarehouse) iterator.next();
                        zoneWarehouseRepository.delete(ZoneWarehouseMapper.toEntity(zoneWarehouse, false));
                    }
                }

                zoneRepository.delete(ZoneMapper.toEntity(zone, false));
            }
        }
    }

    @Override
    public List<Zone> findAll() {
        return ZoneMapper.toDtos(zoneRepository.findAll(), false);
    }

    @Override
    public List<Zone> findAll(Pageable pageable) {
        return ZoneMapper.toDtos(zoneRepository.findAll(pageable), false);
    }
}