package com.sinno.ems.service.impl;

import com.sinno.ems.entities.PrmColumn;
import com.sinno.ems.exception.AttributesNotFound;
import com.sinno.ems.exception.ErrorType;
import com.sinno.ems.exception.IdNotFound;
import com.sinno.ems.mapper.ColumnMapper;
import com.sinno.ems.repositories.ColumnRepository;
import com.sinno.ems.service.ColumnService;
import com.sinno.ems.util.Search;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ColumnServiceImpl implements ColumnService {

    @Autowired
    private ColumnRepository columnRepository;
    private final static Logger LOGGER = LoggerFactory
            .getLogger(ColumnService.class);

    @Override
    public Column save(Column column) {
        LOGGER.info("save COLUMN");
        return ColumnMapper.toDto(columnRepository.saveAndFlush(ColumnMapper.toEntity(column, false)), false);
    }

    @Override
    public Long size() {
        return columnRepository.count();
    }

    @Override
    public Boolean isExist(Long id) {
        return columnRepository.exists(id);
    }

    @Override
    public Column findById(Long id) throws IdNotFound {
        Column column = ColumnMapper.toDto(columnRepository.findOne(id), false);
        if (null != column) {
            return column;
        } else {
            throw new IdNotFound(id);
        }
    }

    @Override
    public List<Column> find(String search) throws AttributesNotFound, ErrorType {
        return ColumnMapper.toDtos(columnRepository.findAll(Search.expression(search, PrmColumn.class)), false);
    }

    @Override
    public List<Column> find(String search, Pageable pageable) throws AttributesNotFound, ErrorType {
        return ColumnMapper.toDtos(columnRepository.findAll(Search.expression(search, PrmColumn.class), pageable), false);
    }

    @Override
    public Long size(String search) throws AttributesNotFound, ErrorType {
        return columnRepository.count(Search.expression(search, PrmColumn.class));
    }

    @Override
    public void delete(Long id) {
        LOGGER.info("delete COLUMN");
        columnRepository.delete(id);
    }

    @Override
    public void delete(Column column) {
        LOGGER.info("delete COLUMN");
        columnRepository.delete(ColumnMapper.toEntity(column, false));
    }

    @Override
    public List<Column> findAll() {
        return ColumnMapper.toDtos(columnRepository.findAll(), false);
    }

    @Override
    public List<Column> findAll(Pageable pageable) {
        return ColumnMapper.toDtos(columnRepository.findAll(pageable), false);
    }
}