package com.sinno.ems.service.impl;

import com.sinno.ems.exception.AttributesNotFound;
import com.sinno.ems.exception.ErrorType;
import com.sinno.ems.exception.IdNotFound;
import com.sinno.ems.mapper.SaleOrderStockArcMapper;
import com.sinno.ems.repositories.SaleOrderStockArcRepository;
import com.sinno.ems.service.SaleOrderStockArcService;
import com.sinno.ems.util.Search;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SaleOrderStockArcServiceImpl implements SaleOrderStockArcService {

    @Autowired
    private SaleOrderStockArcRepository saleOrderStockArcRepository;
    private final static Logger LOGGER = LoggerFactory
            .getLogger(SaleOrderStockArcService.class);

    @Override
    public SaleOrderStockArc save(SaleOrderStockArc saleOrderStockArc) {
        LOGGER.info("save SaleOrderStockArc");
        return SaleOrderStockArcMapper.toDto(saleOrderStockArcRepository.saveAndFlush(SaleOrderStockArcMapper.toEntity(saleOrderStockArc, false)), false);
    }

    @Override
    public Long size() {
        return saleOrderStockArcRepository.count();
    }

    @Override
    public Boolean isExist(Long id) {
        return saleOrderStockArcRepository.exists(id);
    }

    @Override
    public SaleOrderStockArc findById(Long id) throws IdNotFound {
        SaleOrderStockArc saleOrderStockArc = SaleOrderStockArcMapper.toDto(saleOrderStockArcRepository.findOne(id), false);
        if (null != saleOrderStockArc) {
            return saleOrderStockArc;
        } else {
            throw new IdNotFound(id);
        }
    }

    @Override
    public List<SaleOrderStockArc> find(String search) throws AttributesNotFound, ErrorType {
        return SaleOrderStockArcMapper.toDtos(saleOrderStockArcRepository.findAll(Search.expression(search, CmdSaleOrderStockArc.class)), false);
    }

    @Override
    public List<SaleOrderStockArc> find(String search, Pageable pageable) throws AttributesNotFound, ErrorType {
        return SaleOrderStockArcMapper.toDtos(saleOrderStockArcRepository.findAll(Search.expression(search, CmdSaleOrderStockArc.class), pageable), false);
    }

    @Override
    public Long size(String search) throws AttributesNotFound, ErrorType {
        return saleOrderStockArcRepository.count(Search.expression(search, CmdSaleOrderStockArc.class));
    }

    @Override
    public void delete(Long id) {
        LOGGER.info("delete SaleOrderStockArc");
        saleOrderStockArcRepository.delete(id);
    }

    @Override
    public void delete(SaleOrderStockArc saleOrderStockArc) {
        LOGGER.info("delete SaleOrderStockArc");
        saleOrderStockArcRepository.delete(SaleOrderStockArcMapper.toEntity(saleOrderStockArc, false));
    }

    @Override
    public List<SaleOrderStockArc> findAll() {
        return SaleOrderStockArcMapper.toDtos(saleOrderStockArcRepository.findAll(), false);
    }

    @Override
    public List<SaleOrderStockArc> findAll(Pageable pageable) {
        return SaleOrderStockArcMapper.toDtos(saleOrderStockArcRepository.findAll(pageable), false);
    }
}