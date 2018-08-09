package com.bagile.tms.services.impl;
import com.bagile.tms.dto.Zone;
import com.bagile.tms.entities.TmsVehicle;
import com.bagile.tms.entities.TmsZone;
import com.bagile.tms.exceptions.AttributesNotFound;
import com.bagile.tms.exceptions.ErrorType;
import com.bagile.tms.exceptions.IdNotFound;
import com.bagile.tms.mapper.VehicleMapper;
import com.bagile.tms.mapper.ZoneMapper;
import com.bagile.tms.repositories.VehicleRepository;
import com.bagile.tms.repositories.ZoneRepository;
import com.bagile.tms.services.VehicleService;
import com.bagile.tms.services.ZoneService;
import com.bagile.tms.util.Search;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional
public class ZoneServiceImpl implements ZoneService {
    @Autowired
    private ZoneRepository zoneRepository;
    private final static Logger LOGGER = LoggerFactory
            .getLogger(VehicleService.class);

    @Override
    public Zone save(Zone zone) {
        LOGGER.info("save Zone");

        return ZoneMapper.toDto(zoneRepository.save(ZoneMapper.toEntity(zone, false)), false);
    }

    @Override
    public Long size() {
        return zoneRepository.count();
    }

    @Override
    public Boolean isExist(Long id) {
        return zoneRepository.existsById(id);
    }

    @Override
    public Zone findById(Long id) throws IdNotFound {
        Zone zone = ZoneMapper.toDto(zoneRepository.findById(id).get(), false);
        if (null != zone) {
            return zone;
        } else {
            throw new IdNotFound(id);
        }
    }

    @Override
    public List<Zone> find(String search) throws AttributesNotFound, ErrorType {
        return ZoneMapper.toDtos(zoneRepository.findAll(Search.expression(search, TmsZone.class)), false);
    }

    @Override
    public List<Zone> find(String search, Pageable pageable) throws AttributesNotFound, ErrorType {
        return ZoneMapper.toDtos(zoneRepository.findAll(Search.expression(search, TmsZone.class),pageable), false);
    }

    @Override
    public Long size(String search) throws AttributesNotFound, ErrorType {
        return zoneRepository.count(Search.expression(search, TmsZone.class));
    }

    @Override
    public void delete(Long id) {
        LOGGER.info("delete Zone");
        zoneRepository.deleteById(id);
    }

    @Override
    public void delete(Zone zone) {
        LOGGER.info("delete Vehicle");
        zoneRepository.delete(ZoneMapper.toEntity(zone, false));
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
