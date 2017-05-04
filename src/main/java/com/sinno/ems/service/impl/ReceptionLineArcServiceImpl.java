package com.sinno.ems.service.impl;

import com.sinno.ems.dto.ReceptionLineArc;
import com.sinno.ems.entities.RcpReceptionLineArc;
import com.sinno.ems.exception.AttributesNotFound;
import com.sinno.ems.exception.ErrorType;
import com.sinno.ems.exception.IdNotFound;
import com.sinno.ems.mapper.ReceptionLineArcMapper;
import com.sinno.ems.repositories.ReceptionLineArcRepository;
import com.sinno.ems.service.ProductService;
import com.sinno.ems.service.ReceptionLineArcService;
import com.sinno.ems.util.Search;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReceptionLineArcServiceImpl implements ReceptionLineArcService {

    @Autowired
    private ReceptionLineArcRepository receptionLineArcRepository;
    private final static Logger LOGGER = LoggerFactory
            .getLogger(ReceptionLineArcService.class);

    @Override
    public ReceptionLineArc save(ReceptionLineArc receptionLineArc) {
        LOGGER.info("save ReceptionLineArc");
        return ReceptionLineArcMapper.toDto(receptionLineArcRepository.saveAndFlush(ReceptionLineArcMapper.toEntity(receptionLineArc, false)), false);
    }

    @Override
    public Long size() {
        return receptionLineArcRepository.count();
    }

    @Override
    public Boolean isExist(Long id) {
        return receptionLineArcRepository.exists(id);
    }

    @Override
    public ReceptionLineArc findById(Long id) throws IdNotFound {
        ReceptionLineArc receptionLineArc = ReceptionLineArcMapper.toDto(receptionLineArcRepository.findOne(id), false);
        if (null != receptionLineArc) {
            return receptionLineArc;
        } else {
            throw new IdNotFound(id);
        }
    }

    @Override
    public List<ReceptionLineArc> find(String search) throws AttributesNotFound, ErrorType {
        return ReceptionLineArcMapper.toDtos(receptionLineArcRepository.findAll(Search.expression(search, RcpReceptionLineArc.class)), false);
    }

    @Override
    public List<ReceptionLineArc> find(String search, Pageable pageable) throws AttributesNotFound, ErrorType {
        return ReceptionLineArcMapper.toDtos(receptionLineArcRepository.findAll(Search.expression(search, RcpReceptionLineArc.class), pageable), false);
    }

    @Override
    public Long size(String search) throws AttributesNotFound, ErrorType {
        return receptionLineArcRepository.count(Search.expression(search, RcpReceptionLineArc.class));
    }

    @Override
    public void delete(Long id) {
        LOGGER.info("delete ReceptionLineArc");
        receptionLineArcRepository.delete(id);
    }

    @Override
    public void delete(ReceptionLineArc receptionLineArc) {
        LOGGER.info("delete ReceptionLineArc");
        receptionLineArcRepository.delete(ReceptionLineArcMapper.toEntity(receptionLineArc, false));
    }

    @Override
    public List<ReceptionLineArc> findAll() {
        return ReceptionLineArcMapper.toDtos(receptionLineArcRepository.findAll(), false);
    }

    @Override
    public List<ReceptionLineArc> findAll(Pageable pageable) {
        return ReceptionLineArcMapper.toDtos(receptionLineArcRepository.findAll(pageable), false);
    }
}