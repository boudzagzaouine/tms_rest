package com.sinno.ems.service.impl;

import com.sinno.ems.dto.Variable;
import com.sinno.ems.entities.PrmVariable;
import com.sinno.ems.exception.AttributesNotFound;
import com.sinno.ems.exception.ErrorType;
import com.sinno.ems.exception.IdNotFound;
import com.sinno.ems.mapper.VariableMapper;
import com.sinno.ems.repositories.VariableRepository;
import com.sinno.ems.service.VariableService;
import com.sinno.ems.util.Search;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VariableServiceImpl implements VariableService {

    @Autowired
    private VariableRepository variableRepository;
    private final static Logger LOGGER = LoggerFactory
            .getLogger(VariableService.class);
    @Override
    public Variable save(Variable variable) {
        LOGGER.info("save Variable");
        return VariableMapper.toDto(variableRepository.saveAndFlush(VariableMapper.toEntity(variable, false)), false);
    }

    @Override
    public Long size() {
        return variableRepository.count();
    }

    @Override
    public Boolean isExist(Long id) {
        return variableRepository.exists(id);
    }

    @Override
    public Variable findById(Long id) throws IdNotFound {
        Variable variable = VariableMapper.toDto(variableRepository.findOne(id), false);
        if (null != variable) {
            return variable;
        } else {
            throw new IdNotFound(id);
        }
    }

    @Override
    public List<Variable> find(String search) throws AttributesNotFound, ErrorType {
        return VariableMapper.toDtos(variableRepository.findAll(Search.expression(search, PrmVariable.class)), false);
    }

    @Override
    public List<Variable> find(String search, Pageable pageable) throws AttributesNotFound, ErrorType {
        return VariableMapper.toDtos(variableRepository.findAll(Search.expression(search, PrmVariable.class), pageable), false);
    }

    @Override
    public Long size(String search) throws AttributesNotFound, ErrorType {
        return variableRepository.count(Search.expression(search, PrmVariable.class));
    }

    @Override
    public void delete(Long id) {
        LOGGER.info("delete Variable");
        variableRepository.delete(id);
    }

    @Override
    public void delete(Variable variable) {
        LOGGER.info("delete Variable");
        variableRepository.delete(VariableMapper.toEntity(variable, false));
    }

    @Override
    public List<Variable> findAll() {
        return VariableMapper.toDtos(variableRepository.findAll(), false);
    }

    @Override
    public List<Variable> findAll(Pageable pageable) {
        return VariableMapper.toDtos(variableRepository.findAll(pageable), false);
    }
}