package com.sinno.ems.service.impl;

import com.sinno.ems.exception.AttributesNotFound;
import com.sinno.ems.exception.ErrorType;
import com.sinno.ems.exception.IdNotFound;
import com.sinno.ems.mapper.PurshaseOrderArcMapper;
import com.sinno.ems.service.PurshaseOrderArcService;
import com.sinno.ems.util.Search;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PurshaseOrderArcServiceImpl implements PurshaseOrderArcService {

    @Autowired
    private PurshaseOrderArcRepository purshaseOrderArcRepository;
    private final static Logger LOGGER = LoggerFactory
            .getLogger(PurshaseOrderArcService.class);

    @Override
    public PurshaseOrderArc save(PurshaseOrderArc purshaseOrderArc) {
        LOGGER.info("save PurchaseOrderArc");
        return PurshaseOrderArcMapper.toDto(purshaseOrderArcRepository.saveAndFlush(PurshaseOrderArcMapper.toEntity(purshaseOrderArc, false)), false);
    }

    @Override
    public Long size() {
        return purshaseOrderArcRepository.count();
    }

    @Override
    public Boolean isExist(Long id) {
        return purshaseOrderArcRepository.exists(id);
    }

    @Override
    public PurshaseOrderArc findById(Long id) throws IdNotFound {
        PurshaseOrderArc purshaseOrderArc = PurshaseOrderArcMapper.toDto(purshaseOrderArcRepository.findOne(id), false);
        if (null != purshaseOrderArc) {
            return purshaseOrderArc;
        } else {
            throw new IdNotFound(id);
        }
    }

    @Override
    public List<PurshaseOrderArc> find(String search) throws AttributesNotFound, ErrorType {
        return PurshaseOrderArcMapper.toDtos(purshaseOrderArcRepository.findAll(Search.expression(search, RcpPurshaseOrderArc.class)), false);
    }

    @Override
    public List<PurshaseOrderArc> find(String search, Pageable pageable) throws AttributesNotFound, ErrorType {
        return PurshaseOrderArcMapper.toDtos(purshaseOrderArcRepository.findAll(Search.expression(search, RcpPurshaseOrderArc.class), pageable), false);
    }

    @Override
    public Long size(String search) throws AttributesNotFound, ErrorType {
        return purshaseOrderArcRepository.count(Search.expression(search, RcpPurshaseOrderArc.class));
    }

    @Override
    public void delete(Long id) {
        LOGGER.info("delete PurchaseOrderArc");
        purshaseOrderArcRepository.delete(id);
    }

    @Override
    public void delete(PurshaseOrderArc purshaseOrderArc) {
        LOGGER.info("delete PurchaseOrderArc");
        purshaseOrderArcRepository.delete(PurshaseOrderArcMapper.toEntity(purshaseOrderArc, false));
    }

    @Override
    public List<PurshaseOrderArc> findAll() {
        return PurshaseOrderArcMapper.toDtos(purshaseOrderArcRepository.findAll(), false);
    }

    @Override
    public List<PurshaseOrderArc> findAll(Pageable pageable) {
        return PurshaseOrderArcMapper.toDtos(purshaseOrderArcRepository.findAll(pageable), false);
    }
}