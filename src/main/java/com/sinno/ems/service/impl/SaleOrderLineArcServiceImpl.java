package com.sinno.ems.service.impl;

import com.sinno.ems.dto.SaleOrderLineArc;
import com.sinno.ems.entities.CmdSaleOrderLineArc;
import com.sinno.ems.exception.AttributesNotFound;
import com.sinno.ems.exception.ErrorType;
import com.sinno.ems.exception.IdNotFound;
import com.sinno.ems.mapper.SaleOrderLineArcMapper;
import com.sinno.ems.repositories.SaleOrderLineArcRepository;
import com.sinno.ems.service.ProductService;
import com.sinno.ems.service.SaleOrderLineArcService;
import com.sinno.ems.util.Search;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SaleOrderLineArcServiceImpl implements SaleOrderLineArcService {

    @Autowired
    private SaleOrderLineArcRepository saleOrderLineArcRepository;
    private final static Logger LOGGER = LoggerFactory
            .getLogger(SaleOrderLineArcService.class);

    @Override
    public SaleOrderLineArc save(SaleOrderLineArc saleOrderLineArc) {
        LOGGER.info("save SaleOrderLineArc");
        return SaleOrderLineArcMapper.toDto(saleOrderLineArcRepository.saveAndFlush(SaleOrderLineArcMapper.toEntity(saleOrderLineArc, false)), false);
    }

    @Override
    public Long size() {
        return saleOrderLineArcRepository.count();
    }

    @Override
    public Boolean isExist(Long id) {
        return saleOrderLineArcRepository.exists(id);
    }

    @Override
    public SaleOrderLineArc findById(Long id) throws IdNotFound {
        SaleOrderLineArc saleOrderLineArc = SaleOrderLineArcMapper.toDto(saleOrderLineArcRepository.findOne(id), false);
        if (null != saleOrderLineArc) {
            return saleOrderLineArc;
        } else {
            throw new IdNotFound(id);
        }
    }

    @Override
    public List<SaleOrderLineArc> find(String search) throws AttributesNotFound, ErrorType {
        return SaleOrderLineArcMapper.toDtos(saleOrderLineArcRepository.findAll(Search.expression(search, CmdSaleOrderLineArc.class)), false);
    }

    @Override
    public List<SaleOrderLineArc> find(String search, Pageable pageable) throws AttributesNotFound, ErrorType {
        return SaleOrderLineArcMapper.toDtos(saleOrderLineArcRepository.findAll(Search.expression(search, CmdSaleOrderLineArc.class), pageable), false);
    }

    @Override
    public Long size(String search) throws AttributesNotFound, ErrorType {
        return saleOrderLineArcRepository.count(Search.expression(search, CmdSaleOrderLineArc.class));
    }

    @Override
    public void delete(Long id) {
        LOGGER.info("delete SaleOrderLineArc");
        saleOrderLineArcRepository.delete(id);
    }

    @Override
    public void delete(SaleOrderLineArc saleOrderLineArc) {
        LOGGER.info("delete SaleOrderLineArc");
        saleOrderLineArcRepository.delete(SaleOrderLineArcMapper.toEntity(saleOrderLineArc, false));
    }

    @Override
    public List<SaleOrderLineArc> findAll() {
        return SaleOrderLineArcMapper.toDtos(saleOrderLineArcRepository.findAll(), false);
    }

    @Override
    public List<SaleOrderLineArc> findAll(Pageable pageable) {
        return SaleOrderLineArcMapper.toDtos(saleOrderLineArcRepository.findAll(pageable), false);
    }
}