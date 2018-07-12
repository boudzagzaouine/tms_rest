package com.sinno.ems.service.impl;

import com.sinno.ems.exception.AttributesNotFound;
import com.sinno.ems.exception.ErrorType;
import com.sinno.ems.exception.IdNotFound;
import com.sinno.ems.mapper.ReceptionArcMapper;
import com.sinno.ems.service.ReceptionArcService;
import com.sinno.ems.util.Search;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReceptionArcServiceImpl implements ReceptionArcService {

    @Autowired
    private ReceptionArcRepository receptionArcRepository;
    private final static Logger LOGGER = LoggerFactory
            .getLogger(ReceptionArcService.class);

    @Override
    public ReceptionArc save(ReceptionArc receptionArc) {
        LOGGER.info("save ReceptionArc");
        return ReceptionArcMapper.toDto(receptionArcRepository.saveAndFlush(ReceptionArcMapper.toEntity(receptionArc, false)), false);
    }

    @Override
    public Long size() {
        return receptionArcRepository.count();
    }

    @Override
    public Boolean isExist(Long id) {
        return receptionArcRepository.exists(id);
    }

    @Override
    public ReceptionArc findById(Long id) throws IdNotFound {
        ReceptionArc receptionArc = ReceptionArcMapper.toDto(receptionArcRepository.findOne(id), false);
        if (null != receptionArc) {
            return receptionArc;
        } else {
            throw new IdNotFound(id);
        }
    }

    @Override
    public List<ReceptionArc> find(String search) throws AttributesNotFound, ErrorType {
        return ReceptionArcMapper.toDtos(receptionArcRepository.findAll(Search.expression(search, RcpReceptionArc.class)), false);
    }

    @Override
    public List<ReceptionArc> find(String search, Pageable pageable) throws AttributesNotFound, ErrorType {
        return ReceptionArcMapper.toDtos(receptionArcRepository.findAll(Search.expression(search, RcpReceptionArc.class), pageable), false);
    }

    @Override
    public Long size(String search) throws AttributesNotFound, ErrorType {
        return receptionArcRepository.count(Search.expression(search, RcpReceptionArc.class));
    }

    @Override
    public void delete(Long id) {
        LOGGER.info("delete ReceptionArc");
        receptionArcRepository.delete(id);
    }

    @Override
    public void delete(ReceptionArc receptionArc) {
        LOGGER.info("delete ReceptionArc");
        receptionArcRepository.delete(ReceptionArcMapper.toEntity(receptionArc, false));
    }

    @Override
    public List<ReceptionArc> findAll() {
        return ReceptionArcMapper.toDtos(receptionArcRepository.findAll(), false);
    }

    @Override
    public List<ReceptionArc> findAll(Pageable pageable) {
        return ReceptionArcMapper.toDtos(receptionArcRepository.findAll(pageable), false);
    }
}