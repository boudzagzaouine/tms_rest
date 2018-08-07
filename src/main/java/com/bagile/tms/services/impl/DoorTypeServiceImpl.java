package com.bagile.tms.services.impl;

import com.bagile.tms.dto.DoorType;
import com.bagile.tms.entities.TmsRoad;
import com.bagile.tms.exceptions.AttributesNotFound;
import com.bagile.tms.exceptions.ErrorType;
import com.bagile.tms.exceptions.IdNotFound;
import com.bagile.tms.mapper.DoorTypeMapper;
import com.bagile.tms.repositories.DoorTypeRepository;
import com.bagile.tms.services.DoorTypeService;
import com.bagile.tms.services.RoadService;
import com.bagile.tms.util.Search;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;

import java.util.List;

public class DoorTypeServiceImpl implements DoorTypeService {
    @Autowired
    private DoorTypeRepository doorTypeRepository;
    private final static Logger LOGGER = LoggerFactory
            .getLogger(RoadService.class);

    @Override
    public DoorType save(DoorType doorType) {
        LOGGER.info("save DoorType");
        return DoorTypeMapper.toDto(doorTypeRepository.saveAndFlush(DoorTypeMapper.toEntity(doorType, false)), false);
    }

    @Override
    public Long size() {
        return doorTypeRepository.count();
    }

    @Override
    public Boolean isExist(Long id) {
        return doorTypeRepository.existsById(id);
    }

    @Override
    public DoorType findById(Long id) throws IdNotFound {
        DoorType doorType = DoorTypeMapper.toDto(doorTypeRepository.findById(id).get(), false);
        if (null != doorType) {
            return doorType;
        } else {
            throw new IdNotFound(id);
        }
    }

    @Override
    public List<DoorType> find(String search) throws AttributesNotFound, ErrorType {
        return DoorTypeMapper.toDtos(doorTypeRepository.findAll(Search.expression(search, TmsRoad.class)), false);
    }

    @Override
    public List<DoorType> find(String search, Pageable pageable) throws AttributesNotFound, ErrorType {
        return DoorTypeMapper.toDtos(doorTypeRepository.findAll(Search.expression(search, TmsRoad.class),pageable ), false);
    }

    @Override
    public Long size(String search) throws AttributesNotFound, ErrorType {
        return doorTypeRepository.count(Search.expression(search, TmsRoad.class));
    }

    @Override
    public void delete(Long id) {
        LOGGER.info("save DoorType");
        doorTypeRepository.deleteById(id);
    }

    @Override
    public void delete(DoorType doorType) {
        LOGGER.info("delete DoorType");
        doorTypeRepository.delete(DoorTypeMapper.toEntity(doorType, false));
    }

    @Override
    public List<DoorType> findAll() {
        return DoorTypeMapper.toDtos(doorTypeRepository.findAll(), false);
    }

    @Override
    public List<DoorType> findAll(Pageable pageable) {
        return DoorTypeMapper.toDtos(doorTypeRepository.findAll(pageable), false);
    }

}
