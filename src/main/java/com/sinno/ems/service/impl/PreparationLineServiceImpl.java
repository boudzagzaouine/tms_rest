package com.sinno.ems.service.impl;

import com.sinno.ems.exception.AttributesNotFound;
import com.sinno.ems.exception.ErrorType;
import com.sinno.ems.exception.IdNotFound;
import com.sinno.ems.mapper.PreparationLineMapper;
import com.sinno.ems.repositories.PreparationLineRepository;
import com.sinno.ems.service.PreparationLineService;
import com.sinno.ems.util.Search;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Enissay on 03/12/2016.
 */
@Service
public class PreparationLineServiceImpl implements PreparationLineService {
    @Autowired
    private PreparationLineRepository preparationLineRepository;
    private final static Logger LOGGER = LoggerFactory
            .getLogger(PreparationLineServiceImpl.class);

    @Override
    public PreparationLine save(PreparationLine preparationLine) {
        LOGGER.info("save PreparationLine");
        return PreparationLineMapper.toDto(preparationLineRepository.saveAndFlush(PreparationLineMapper.toEntity(preparationLine, false)), false);
    }

    @Override
    public Long size() {
        return preparationLineRepository.count();
    }

    @Override
    public Boolean isExist(Long id) {
        return preparationLineRepository.exists(id);
    }

    @Override
    public PreparationLine findById(Long id) throws IdNotFound {
        PreparationLine preparationLine = PreparationLineMapper.toDto(preparationLineRepository.findOne(id), false);
        if (null != preparationLine) {
            return preparationLine;
        } else {
            throw new IdNotFound(id);
        }
    }

    @Override
    public List<PreparationLine> find(String search) throws AttributesNotFound, ErrorType {

        return PreparationLineMapper.toDtos(preparationLineRepository.findAll(Search.expression(search, CmdPreparationLine.class)), false);
    }

    @Override
    public List<PreparationLine> find(String search, Pageable pageable) throws AttributesNotFound, ErrorType {
        return PreparationLineMapper.toDtos(preparationLineRepository.findAll(Search.expression(search, CmdPreparationLine.class), pageable), false);
    }

    @Override
    public Long size(String search) throws AttributesNotFound, ErrorType {
        return preparationLineRepository.count(Search.expression(search, CmdPreparationLine.class));
    }

    @Override
    public void delete(Long id) {
        LOGGER.info("delete PreparationLine");
        preparationLineRepository.delete(id);
    }

    @Override
    public void delete(PreparationLine preparationLine) {
        LOGGER.info("delete PreparationLine");
        preparationLineRepository.delete(PreparationLineMapper.toEntity(preparationLine, false));
    }

    @Override
    public List<PreparationLine> findAll() {
        return PreparationLineMapper.toDtos(preparationLineRepository.findAll(), false);
    }

    @Override
    public List<PreparationLine> findAll(Pageable pageable) {
        return PreparationLineMapper.toDtos(preparationLineRepository.findAll(pageable), false);
    }
}
