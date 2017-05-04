package com.sinno.ems.service.impl;

import com.sinno.ems.dto.MovementType;
import com.sinno.ems.entities.InvMovementType;
import com.sinno.ems.exception.AttributesNotFound;
import com.sinno.ems.exception.ErrorType;
import com.sinno.ems.exception.IdNotFound;
import com.sinno.ems.mapper.MovementTypeMapper;
import com.sinno.ems.repositories.MovementTypeRepository;
import com.sinno.ems.service.AddressService;
import com.sinno.ems.service.MovementTypeService;
import com.sinno.ems.util.Search;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MovementTypeServiceImpl implements MovementTypeService {

    @Autowired
    private MovementTypeRepository movementTypeRepository;
    private final static Logger LOGGER = LoggerFactory
            .getLogger(MovementTypeService.class);

    @Override
    public MovementType save(MovementType movementType) {
        LOGGER.info("save MovementType");
        return MovementTypeMapper.toDto(movementTypeRepository.saveAndFlush(MovementTypeMapper.toEntity(movementType, false)), false);
    }

    @Override
    public Long size() {
        return movementTypeRepository.count();
    }

    @Override
    public Boolean isExist(Long id) {
        return movementTypeRepository.exists(id);
    }

    @Override
    public MovementType findById(Long id) throws IdNotFound {
        MovementType movementType = MovementTypeMapper.toDto(movementTypeRepository.findOne(id), false);
        if (null != movementType) {
            return movementType;
        } else {
            throw new IdNotFound(id);
        }
    }

    @Override
    public List<MovementType> find(String search) throws AttributesNotFound, ErrorType {
        return MovementTypeMapper.toDtos(movementTypeRepository.findAll(Search.expression(search, InvMovementType.class)), false);
    }

    @Override
    public List<MovementType> find(String search, Pageable pageable) throws AttributesNotFound, ErrorType {
        return MovementTypeMapper.toDtos(movementTypeRepository.findAll(Search.expression(search, InvMovementType.class), pageable), false);
    }

    @Override
    public Long size(String search) throws AttributesNotFound, ErrorType {
        return movementTypeRepository.count(Search.expression(search, InvMovementType.class));
    }

    @Override
    public void delete(Long id) {
        LOGGER.info("delete MovementType");
        movementTypeRepository.delete(id);
    }

    @Override
    public void delete(MovementType movementType) {
        LOGGER.info("delete MovementType");
        movementTypeRepository.delete(MovementTypeMapper.toEntity(movementType, false));
    }

    @Override
    public List<MovementType> findAll() {
        return MovementTypeMapper.toDtos(movementTypeRepository.findAll(), false);
    }

    @Override
    public List<MovementType> findAll(Pageable pageable) {
        return MovementTypeMapper.toDtos(movementTypeRepository.findAll(pageable), false);
    }
}