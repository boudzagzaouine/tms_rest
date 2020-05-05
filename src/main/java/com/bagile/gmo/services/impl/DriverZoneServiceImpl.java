package com.bagile.gmo.services.impl;

import com.bagile.gmo.dto.DriverZone;
import com.bagile.gmo.entities.GmoDriverZone;
import com.bagile.gmo.mapper.DriverZoneMapper;
import com.bagile.gmo.exceptions.AttributesNotFound;
import com.bagile.gmo.exceptions.ErrorType;
import com.bagile.gmo.exceptions.IdNotFound;
import com.bagile.gmo.repositories.DriverZoneRepository;
import com.bagile.gmo.services.DriverZoneService;
import com.bagile.gmo.util.Search;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class DriverZoneServiceImpl implements DriverZoneService {

    private final DriverZoneRepository driverzoneRepository;
    private final static Logger LOGGER = LoggerFactory
            .getLogger(DriverZoneService.class);

    public DriverZoneServiceImpl(DriverZoneRepository driverzoneRepository) {
        this.driverzoneRepository = driverzoneRepository;
    }

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
        return DriverZoneMapper.toDto(driverzoneRepository.findById(id).orElseThrow(() -> new IdNotFound(id)), false);
    }

    @Override
    public List<DriverZone> find(String search) throws AttributesNotFound, ErrorType {
        if (search.equals("")){
            return findAll ();
        }
        return DriverZoneMapper.toDtos(driverzoneRepository.findAll(Search.expression(search, GmoDriverZone.class)), false);

    }

    @Override
    public List<DriverZone> find(String search, int page, int size) throws AttributesNotFound, ErrorType {
        if (search.equals("")){
            return findAll (page, size);
        }
        Pageable pageable = PageRequest.of(page, size);
        return DriverZoneMapper.toDtos(driverzoneRepository.findAll(Search.expression(search, GmoDriverZone.class), pageable), false);

    }

    @Override
    public Long size(String search) throws AttributesNotFound, ErrorType {
        if ("".equals(search)) {
            size();
        }
        return driverzoneRepository.count(Search.expression(search, GmoDriverZone.class));
    }

    @Override
    public void delete(Long id) {
        LOGGER.info("Delete DriverZone");
        driverzoneRepository.deleteById(id);
    }

    @Override
    public void delete(DriverZone driverzone) {
        LOGGER.info("delete DriverZone");
        delete(driverzone.getId());
    }

    @Override
    public List<DriverZone> findAll() {
        return DriverZoneMapper.toDtos(driverzoneRepository.findAll(), false);
    }

    @Override
    public List<DriverZone> findAll(int page, int size) {
        Pageable pageable = PageRequest.of(page, size);
        return DriverZoneMapper.toDtos(driverzoneRepository.findAll(pageable), false);
    }
}
