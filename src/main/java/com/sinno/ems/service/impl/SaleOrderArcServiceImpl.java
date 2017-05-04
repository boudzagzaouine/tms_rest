package com.sinno.ems.service.impl;

import com.sinno.ems.dto.SaleOrderArc;
import com.sinno.ems.entities.CmdSaleOrderArc;
import com.sinno.ems.exception.AttributesNotFound;
import com.sinno.ems.exception.ErrorType;
import com.sinno.ems.exception.IdNotFound;
import com.sinno.ems.mapper.SaleOrderArcMapper;
import com.sinno.ems.repositories.SaleOrderArcRepository;
import com.sinno.ems.service.ProductService;
import com.sinno.ems.service.SaleOrderArcService;
import com.sinno.ems.util.Search;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SaleOrderArcServiceImpl implements SaleOrderArcService {

    @Autowired
    private SaleOrderArcRepository saleOrderArcRepository;
    private final static Logger LOGGER = LoggerFactory
            .getLogger(SaleOrderArcService.class);

    @Override
    public SaleOrderArc save(SaleOrderArc saleOrderArc) {
        LOGGER.info("save SaleOrderArc");
        return SaleOrderArcMapper.toDto(saleOrderArcRepository.saveAndFlush(SaleOrderArcMapper.toEntity(saleOrderArc, false)), false);
    }

    @Override
    public Long size() {
        return saleOrderArcRepository.count();
    }

    @Override
    public Boolean isExist(Long id) {
        return saleOrderArcRepository.exists(id);
    }

    @Override
    public SaleOrderArc findById(Long id) throws IdNotFound {
        SaleOrderArc saleOrderArc = SaleOrderArcMapper.toDto(saleOrderArcRepository.findOne(id), false);
        if (null != saleOrderArc) {
            return saleOrderArc;
        } else {
            throw new IdNotFound(id);
        }
    }

    @Override
    public List<SaleOrderArc> find(String search) throws AttributesNotFound, ErrorType {
        return SaleOrderArcMapper.toDtos(saleOrderArcRepository.findAll(Search.expression(search, CmdSaleOrderArc.class)), false);
    }

    @Override
    public List<SaleOrderArc> find(String search, Pageable pageable) throws AttributesNotFound, ErrorType {
        return SaleOrderArcMapper.toDtos(saleOrderArcRepository.findAll(Search.expression(search, CmdSaleOrderArc.class), pageable), false);
    }

    @Override
    public Long size(String search) throws AttributesNotFound, ErrorType {
        return saleOrderArcRepository.count(Search.expression(search, CmdSaleOrderArc.class));
    }

    @Override
    public void delete(Long id) {
        LOGGER.info("delete SaleOrderArc");
        saleOrderArcRepository.delete(id);
    }

    @Override
    public void delete(SaleOrderArc saleOrderArc) {
        LOGGER.info("delete SaleOrderArc");
        saleOrderArcRepository.delete(SaleOrderArcMapper.toEntity(saleOrderArc, false));
    }

    @Override
    public List<SaleOrderArc> findAll() {
        return SaleOrderArcMapper.toDtos(saleOrderArcRepository.findAll(), false);
    }

    @Override
    public List<SaleOrderArc> findAll(Pageable pageable) {
        return SaleOrderArcMapper.toDtos(saleOrderArcRepository.findAll(pageable), false);
    }
}