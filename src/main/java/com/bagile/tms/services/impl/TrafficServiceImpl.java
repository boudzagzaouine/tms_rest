package com.bagile.tms.services.impl;

import com.bagile.tms.dto.Traffic;
import com.bagile.tms.entities.TmsVehicle;
import com.bagile.tms.exceptions.AttributesNotFound;
import com.bagile.tms.exceptions.ErrorType;
import com.bagile.tms.exceptions.IdNotFound;
import com.bagile.tms.mapper.TrafficMapper;
import com.bagile.tms.repositories.TrafficRepository;
import com.bagile.tms.services.TrafficService;
import com.bagile.tms.services.VehicleService;
import com.bagile.tms.util.Search;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;

import java.util.List;

public class TrafficServiceImpl implements TrafficService {

    @Autowired
    private TrafficRepository trafficRepository;
    private final static Logger LOGGER = LoggerFactory
            .getLogger(VehicleService.class);

    @Override
    public Traffic save(Traffic traffic) {
        LOGGER.info("save Traffic");

        return TrafficMapper.toDto(trafficRepository.saveAndFlush(TrafficMapper.toEntity(traffic, false)), false);
    }

    @Override
    public Long size() {
        return trafficRepository.count();
    }

    @Override
    public Boolean isExist(Long id) {
        return trafficRepository.existsById(id);
    }

    @Override
    public Traffic findById(Long id) throws IdNotFound {
        Traffic traffic = TrafficMapper.toDto(trafficRepository.findById(id).get(), false);
        if (null != traffic) {
            return traffic;
        } else {
            throw new IdNotFound(id);
        }
    }

    @Override
    public List<Traffic> find(String search) throws AttributesNotFound, ErrorType {
        return TrafficMapper.toDtos(trafficRepository.findAll(Search.expression(search, TmsVehicle.class)), false);
    }

    @Override
    public List<Traffic> find(String search, Pageable pageable) throws AttributesNotFound, ErrorType {
        return TrafficMapper.toDtos(trafficRepository.findAll(Search.expression(search, TmsVehicle.class),pageable), false);
    }

    @Override
    public Long size(String search) throws AttributesNotFound, ErrorType {
        return trafficRepository.count(Search.expression(search, TmsVehicle.class));
    }

    @Override
    public void delete(Long id) {
        LOGGER.info("delete Traffic");
        trafficRepository.deleteById(id);
    }

    @Override
    public void delete(Traffic traffic) {
        LOGGER.info("delete Traffic");
        trafficRepository.delete(TrafficMapper.toEntity(traffic, false));
    }

    @Override
    public List<Traffic> findAll() {
        return TrafficMapper.toDtos(trafficRepository.findAll(), false);
    }

    @Override
    public List<Traffic> findAll(Pageable pageable) {
        return TrafficMapper.toDtos(trafficRepository.findAll(pageable), false);
    }
}
