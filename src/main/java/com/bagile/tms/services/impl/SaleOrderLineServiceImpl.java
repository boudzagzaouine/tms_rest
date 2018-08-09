package com.bagile.tms.services.impl;

import com.bagile.tms.dto.SaleOrderLine;
import com.bagile.tms.entities.CmdSaleOrderLine;
import com.bagile.tms.exceptions.AttributesNotFound;
import com.bagile.tms.exceptions.ErrorType;
import com.bagile.tms.exceptions.IdNotFound;
import com.bagile.tms.mapper.SaleOrderLineMapper;
import com.bagile.tms.repositories.SaleOrderLineRepository;
import com.bagile.tms.services.*;
import com.bagile.tms.util.EmsDate;
import com.bagile.tms.util.Search;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.List;

@Service
@Transactional
public class SaleOrderLineServiceImpl implements SaleOrderLineService {

    @Autowired
    private SaleOrderLineRepository saleOrderLineRepository;
    @Autowired
    private OrderStatusService orderStatusService;
    private final static Logger LOGGER = LoggerFactory
            .getLogger(SaleOrderLineService.class);

    @Override
    public SaleOrderLine save(SaleOrderLine saleOrderLine) {
        LOGGER.info("save SaleOrderLine");
        saleOrderLine.setUpdateDate(EmsDate.getDateNow());
        if (0 >= saleOrderLine.getId()) {
            saleOrderLine.setCreationDate(EmsDate.getDateNow());
        }
        return SaleOrderLineMapper.toDto(saleOrderLineRepository.saveAndFlush(SaleOrderLineMapper.toEntity(saleOrderLine, false)), false);

    }




    @Override
    public Long size() {
        return saleOrderLineRepository.count();
    }

    @Override
    public Boolean isExist(Long id) {
        return saleOrderLineRepository.existsById(id);
    }

    @Override
    public SaleOrderLine findById(Long id) throws IdNotFound {
        SaleOrderLine saleOrderLine = SaleOrderLineMapper.toDto(saleOrderLineRepository.findById(id).get(), false);
        if (null != saleOrderLine) {
            return saleOrderLine;
        } else {
            throw new IdNotFound(id);
        }
    }

    @Override
    public SaleOrderLine findOne(String search) throws AttributesNotFound, ErrorType {
        return SaleOrderLineMapper.toDto(saleOrderLineRepository.findOne(Search.expression(search, CmdSaleOrderLine.class)).get(), false);
    }

    @Override
    public List<SaleOrderLine> find(String search) throws AttributesNotFound, ErrorType {
        return SaleOrderLineMapper.toDtos(saleOrderLineRepository.findAll(Search.expression(search, CmdSaleOrderLine.class)), false);
    }

    @Override
    public List<SaleOrderLine> find(String search, int page, int size) throws AttributesNotFound, ErrorType {
        Sort sort = new Sort(Sort.Direction.DESC, "cmdSaleOrderLineUpdateDate");
        Pageable pageable = new PageRequest(page, size, sort);
        return SaleOrderLineMapper.toDtos(saleOrderLineRepository.findAll(Search.expression(search, CmdSaleOrderLine.class), pageable), false);
    }

    @Override
    public Long size(String search) throws AttributesNotFound, ErrorType {
        return saleOrderLineRepository.count(Search.expression(search, CmdSaleOrderLine.class));
    }

    @Override
    public void delete(Long id) {
        LOGGER.info("delete SaleOrderLine");
        saleOrderLineRepository.deleteById(id);
    }

    @Override
    public void delete(SaleOrderLine saleOrderLine) {
        LOGGER.info("delete SaleOrderLine");
        saleOrderLineRepository.delete(SaleOrderLineMapper.toEntity(saleOrderLine, false));
    }

    @Override
    public List<SaleOrderLine> findAll() {
        return SaleOrderLineMapper.toDtos(saleOrderLineRepository.findAll(), false);
    }

    @Override
    public List<SaleOrderLine> findAll(Pageable pageable) {
        return SaleOrderLineMapper.toDtos(saleOrderLineRepository.findAll(pageable), false);
    }


     @Override
    public void updateSaleOrderLine(SaleOrderLine saleOrderLine, BigDecimal quantiyServed) {
        try {
            saleOrderLine = findById(saleOrderLine.getId());
            saleOrderLine.setQuantityServed(saleOrderLine.getQuantityServed() != null ? saleOrderLine.getQuantityServed() : BigDecimal.ZERO);
            saleOrderLine.setQuantityServed(saleOrderLine.getQuantityServed().add(quantiyServed));
            if (saleOrderLine.getQuantityServed().compareTo(saleOrderLine.getQuantity()) > -1) {
                saleOrderLine.setOrderStatus(orderStatusService.closedStatus());
            } else if (saleOrderLine.getQuantityServed().compareTo(BigDecimal.ZERO) > 0) {
                saleOrderLine.setOrderStatus(orderStatusService.partialStatus());
            }else return;

            save(saleOrderLine);
        } catch (IdNotFound idNotFound) {
            idNotFound.printStackTrace();
        }
    }
}