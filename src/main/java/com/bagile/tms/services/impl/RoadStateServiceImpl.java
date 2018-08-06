package com.bagile.tms.services.impl;

import com.bagile.tms.dto.RoadState;
import com.bagile.tms.entities.TmsVehicle;
import com.bagile.tms.exceptions.AttributesNotFound;
import com.bagile.tms.exceptions.ErrorType;
import com.bagile.tms.exceptions.IdNotFound;
import com.bagile.tms.mapper.RoadStateMapper;
import com.bagile.tms.repositories.RoadStateRepository;
import com.bagile.tms.services.RoadStateService;
import com.bagile.tms.util.Search;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;

import java.util.List;

public class RoadStateServiceImpl implements RoadStateService {

    @Autowired
    private RoadStateRepository roadStateRepository;
    private final static Logger LOGGER = LoggerFactory
            .getLogger(RoadStateService.class);

    @Override
    public RoadState save(RoadState traffic) {
        LOGGER.info("save RoadState");

        return RoadStateMapper.toDto(roadStateRepository.saveAndFlush(RoadStateMapper.toEntity(traffic, false)), false);
    }

    @Override
    public Long size() {
        return roadStateRepository.count();
    }

    @Override
    public Boolean isExist(Long id) {
        return roadStateRepository.existsById(id);
    }

    @Override
    public RoadState findById(Long id) throws IdNotFound {
        RoadState traffic = RoadStateMapper.toDto(roadStateRepository.findById(id).get(), false);
        if (null != traffic) {
            return traffic;
        } else {
            throw new IdNotFound(id);
        }
    }

    @Override
    public List<RoadState> find(String search) throws AttributesNotFound, ErrorType {
        return RoadStateMapper.toDtos(roadStateRepository.findAll(Search.expression(search, TmsVehicle.class)), false);
    }

    @Override
    public List<RoadState> find(String search, Pageable pageable) throws AttributesNotFound, ErrorType {
        return RoadStateMapper.toDtos(roadStateRepository.findAll(Search.expression(search, TmsVehicle.class),pageable), false);
    }

    @Override
    public Long size(String search) throws AttributesNotFound, ErrorType {
        return roadStateRepository.count(Search.expression(search, TmsVehicle.class));
    }

    @Override
    public void delete(Long id) {
        LOGGER.info("delete RoadState");
        roadStateRepository.deleteById(id);
    }

    @Override
    public void delete(RoadState traffic) {
        LOGGER.info("delete RoadState");
        roadStateRepository.delete(RoadStateMapper.toEntity(traffic, false));
    }

    @Override
    public List<RoadState> findAll() {
        return RoadStateMapper.toDtos(roadStateRepository.findAll(), false);
    }

    @Override
    public List<RoadState> findAll(Pageable pageable) {
        return RoadStateMapper.toDtos(roadStateRepository.findAll(pageable), false);
    }
}
