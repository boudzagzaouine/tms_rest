package com.sinno.ems.service.impl;

import com.sinno.ems.exception.AttributesNotFound;
import com.sinno.ems.exception.ErrorType;
import com.sinno.ems.exception.IdNotFound;
import com.sinno.ems.mapper.PurshaseOrderLineArcMapper;
import com.sinno.ems.service.PurshaseOrderLineArcService;
import com.sinno.ems.util.Search;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PurshaseOrderLineArcServiceImpl implements PurshaseOrderLineArcService {

    @Autowired
    private PurshaseOrderLineArcRepository purshaseOrderLineArcRepository;
    private final static Logger LOGGER = LoggerFactory
            .getLogger(PurshaseOrderLineArcService.class);

    @Override
    public PurshaseOrderLineArc save(PurshaseOrderLineArc purshaseOrderLineArc) {
        LOGGER.info("save PurchaseOrderLineArc");
        return PurshaseOrderLineArcMapper.toDto(purshaseOrderLineArcRepository.saveAndFlush(PurshaseOrderLineArcMapper.toEntity(purshaseOrderLineArc, false)), false);
    }

    @Override
    public Long size() {
        return purshaseOrderLineArcRepository.count();
    }

    @Override
    public Boolean isExist(Long id) {
        return purshaseOrderLineArcRepository.exists(id);
    }

    @Override
    public PurshaseOrderLineArc findById(Long id) throws IdNotFound {
        PurshaseOrderLineArc purshaseOrderLineArc = PurshaseOrderLineArcMapper.toDto(purshaseOrderLineArcRepository.findOne(id), false);
        if (null != purshaseOrderLineArc) {
            return purshaseOrderLineArc;
        } else {
            throw new IdNotFound(id);
        }
    }

    @Override
    public List<PurshaseOrderLineArc> find(String search) throws AttributesNotFound, ErrorType {
        return PurshaseOrderLineArcMapper.toDtos(purshaseOrderLineArcRepository.findAll(Search.expression(search, RcpPurshaseOrderLineArc.class)), false);
    }

    @Override
    public List<PurshaseOrderLineArc> find(String search, Pageable pageable) throws AttributesNotFound, ErrorType {
        return PurshaseOrderLineArcMapper.toDtos(purshaseOrderLineArcRepository.findAll(Search.expression(search, RcpPurshaseOrderLineArc.class), pageable), false);
    }

    @Override
    public Long size(String search) throws AttributesNotFound, ErrorType {
        return purshaseOrderLineArcRepository.count(Search.expression(search, RcpPurshaseOrderLineArc.class));
    }

    @Override
    public void delete(Long id) {
        LOGGER.info("delete PurchaseOrderLineArc");
        purshaseOrderLineArcRepository.delete(id);
    }

    @Override
    public void delete(PurshaseOrderLineArc purshaseOrderLineArc) {
        LOGGER.info("delete PurchaseOrderLineArc");
        purshaseOrderLineArcRepository.delete(PurshaseOrderLineArcMapper.toEntity(purshaseOrderLineArc, false));
    }

    @Override
    public List<PurshaseOrderLineArc> findAll() {
        return PurshaseOrderLineArcMapper.toDtos(purshaseOrderLineArcRepository.findAll(), false);
    }

    @Override
    public List<PurshaseOrderLineArc> findAll(Pageable pageable) {
        return PurshaseOrderLineArcMapper.toDtos(purshaseOrderLineArcRepository.findAll(pageable), false);
    }
}