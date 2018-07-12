package com.sinno.ems.service.impl;

import com.sinno.ems.exception.AttributesNotFound;
import com.sinno.ems.exception.ErrorType;
import com.sinno.ems.exception.IdNotFound;
import com.sinno.ems.mapper.ExceptionMapper;
import com.sinno.ems.repositories.ExceptionRepository;
import com.sinno.ems.service.ExceptionService;
import com.sinno.ems.util.Search;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ExceptionServiceImpl implements ExceptionService {

    @Autowired
    private ExceptionRepository exceptionRepository;
    private final static Logger LOGGER = LoggerFactory
            .getLogger(ExceptionService.class);

    @Override
    public Exception save(Exception exception) {
        LOGGER.info("save Exception");
        return ExceptionMapper.toDto(exceptionRepository.saveAndFlush(ExceptionMapper.toEntity(exception, false)), false);
    }

    @Override
    public Long size() {
        return exceptionRepository.count();
    }

    @Override
    public Boolean isExist(Long id) {
        return exceptionRepository.exists(id);
    }

    @Override
    public Exception findById(Long id) throws IdNotFound {
        Exception exception = ExceptionMapper.toDto(exceptionRepository.findOne(id), false);
        if (null != exception) {
            return exception;
        } else {
            throw new IdNotFound(id);
        }
    }

    @Override
    public List<Exception> find(String search) throws AttributesNotFound, ErrorType {
        return ExceptionMapper.toDtos(exceptionRepository.findAll(Search.expression(search, StkException.class)), false);
    }

    @Override
    public List<Exception> find(String search, int page, int size) throws AttributesNotFound, ErrorType {
        Pageable pageable = new PageRequest(page, size);
        return ExceptionMapper.toDtos(exceptionRepository.findAll(Search.expression(search, StkException.class), pageable), false);
    }

    @Override
    public Long size(String search) throws AttributesNotFound, ErrorType {
        return exceptionRepository.count(Search.expression(search, StkException.class));
    }

    @Override
    public void delete(Long id) {
        LOGGER.info("delete Exception");
        exceptionRepository.delete(id);
    }

    @Override
    public void delete(Exception exception) {
        LOGGER.info("delete Exception");
        exceptionRepository.delete(ExceptionMapper.toEntity(exception, false));
    }

    @Override
    public List<Exception> findAll() {
        return ExceptionMapper.toDtos(exceptionRepository.findAll(), false);
    }

    @Override
    public List<Exception> findAll(int page, int size) {
        Pageable pageable = new PageRequest(page, size);
        return ExceptionMapper.toDtos(exceptionRepository.findAll(pageable), false);
    }
}