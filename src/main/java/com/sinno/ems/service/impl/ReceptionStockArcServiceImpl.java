package com.sinno.ems.service.impl;

import com.sinno.ems.exception.AttributesNotFound;
import com.sinno.ems.exception.ErrorType;
import com.sinno.ems.exception.IdNotFound;
import com.sinno.ems.mapper.ReceptionStockArcMapper;
import com.sinno.ems.service.ReceptionStockArcService;
import com.sinno.ems.util.Search;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReceptionStockArcServiceImpl implements ReceptionStockArcService {

    @Autowired
    private ReceptionStockArcRepository receptionStockArcRepository;
    private final static Logger LOGGER = LoggerFactory
            .getLogger(ReceptionStockArcService.class);

    @Override
    public ReceptionStockArc save(ReceptionStockArc receptionStockArc) {
        LOGGER.info("save ReceptionStockArc");
        return ReceptionStockArcMapper.toDto(receptionStockArcRepository.saveAndFlush(ReceptionStockArcMapper.toEntity(receptionStockArc, false)), false);
    }

    @Override
    public Long size() {
        return receptionStockArcRepository.count();
    }

    @Override
    public Boolean isExist(Long id) {
        return receptionStockArcRepository.exists(id);
    }

    @Override
    public ReceptionStockArc findById(Long id) throws IdNotFound {
        ReceptionStockArc receptionStockArc = ReceptionStockArcMapper.toDto(receptionStockArcRepository.findOne(id), false);
        if (null != receptionStockArc) {
            return receptionStockArc;
        } else {
            throw new IdNotFound(id);
        }
    }

    @Override
    public List<ReceptionStockArc> find(String search) throws AttributesNotFound, ErrorType {
        return ReceptionStockArcMapper.toDtos(receptionStockArcRepository.findAll(Search.expression(search, RcpReceptionStockArc.class)), false);
    }

    @Override
    public List<ReceptionStockArc> find(String search, Pageable pageable) throws AttributesNotFound, ErrorType {
        return ReceptionStockArcMapper.toDtos(receptionStockArcRepository.findAll(Search.expression(search, RcpReceptionStockArc.class), pageable), false);
    }

    @Override
    public Long size(String search) throws AttributesNotFound, ErrorType {
        return receptionStockArcRepository.count(Search.expression(search, RcpReceptionStockArc.class));
    }

    @Override
    public void delete(Long id) {
        LOGGER.info("delete ReceptionStockArc");
        receptionStockArcRepository.delete(id);
    }

    @Override
    public void delete(ReceptionStockArc receptionStockArc) {
        LOGGER.info("delete ReceptionStockArc");
        receptionStockArcRepository.delete(ReceptionStockArcMapper.toEntity(receptionStockArc, false));
    }

    @Override
    public List<ReceptionStockArc> findAll() {
        return ReceptionStockArcMapper.toDtos(receptionStockArcRepository.findAll(), false);
    }

    @Override
    public List<ReceptionStockArc> findAll(Pageable pageable) {
        return ReceptionStockArcMapper.toDtos(receptionStockArcRepository.findAll(pageable), false);
    }
}