package com.bagile.tms.services.impl;

import com.bagile.tms.dto.DriverZone;
import com.bagile.tms.entities.TmsDriverZone;
import com.bagile.tms.exceptions.AttributesNotFound;
import com.bagile.tms.exceptions.ErrorType;
import com.bagile.tms.exceptions.IdNotFound;
import com.bagile.tms.mapper.DriverZoneMapper;
import com.bagile.tms.repositories.DriverZoneRepository;
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
public class DriverZoneServiceImpl implements DriverZoneService{

    @Autowired
    private DriverZoneRepository driverzoneRepository;
    private final static Logger LOGGER = LoggerFactory
            .getLogger(DriverZoneService.class);



    @Override
    public DriverZone save(DriverZone driverzone) {
        LOGGER.info("save Driver");

       // if (0 <= driverzone.getId()) {
            //driverzone.setCreationDate(EmsDate.getDateNow());
       // }
        return DriverZoneMapper.toDto(driverzoneRepository.saveAndFlush(DriverZoneMapper.toEntity(driverzone, false)), false);

    }

    @Override
    public Long size() {
        return driverzoneRepository.count();
    }

    @Override
    public Boolean isExist(Long id) {
        return driverzoneRepository.existsById(id);
    }

    @Override
    public DriverZone findById(Long id) throws IdNotFound {
        DriverZone driverzone = DriverZoneMapper.toDto(driverzoneRepository.findById(id).get(), false);
        if (null != driverzone) {
            return driverzone;
        } else {
            throw new IdNotFound(id);
        }
    }

    @Override
    public List<DriverZone> find(String search) throws AttributesNotFound, ErrorType {
        return DriverZoneMapper.toDtos(driverzoneRepository.findAll(Search.expression(search, TmsDriverZone.class)), false);

    }

    @Override
    public List<DriverZone> find(String search, Pageable pageable) throws AttributesNotFound, ErrorType {
        return DriverZoneMapper.toDtos(driverzoneRepository.findAll(Search.expression(search, TmsDriverZone.class), pageable), false);

    }

    @Override
    public Long size(String search) throws AttributesNotFound, ErrorType {
        if("".equals(search))
        {
            size();
        }
        return driverzoneRepository.count(Search.expression(search, TmsDriverZone.class));
    }

    @Override
    public void delete(Long id) {
        LOGGER.info("Delete DriverZone");
        driverzoneRepository.deleteById(id);
    }

    @Override
    public void delete(DriverZone driverzone) {
        LOGGER.info("delete DriverZone");
        driverzoneRepository.delete(DriverZoneMapper.toEntity(driverzone, false));
    }

    @Override
    public List<DriverZone> findAll() {
        return DriverZoneMapper.toDtos(driverzoneRepository.findAll(), false);
    }

    @Override
    public List<DriverZone> findAll(Pageable pageable) {
        return DriverZoneMapper.toDtos(driverzoneRepository.findAll(pageable), false);
    }
}
