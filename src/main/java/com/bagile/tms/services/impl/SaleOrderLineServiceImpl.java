package com.bagile.tms.services.impl;
import com.bagile.tms.dto.SaleOrder;
import com.bagile.tms.dto.SaleOrderLine;
import com.bagile.tms.entities.CmdSaleOrderLine;
import com.bagile.tms.exceptions.AttributesNotFound;
import com.bagile.tms.exceptions.CustomException;
import com.bagile.tms.exceptions.ErrorType;
import com.bagile.tms.exceptions.IdNotFound;
import com.bagile.tms.mapper.SaleOrderLineMapper;
import com.bagile.tms.repositories.SaleOrderLineRepository;
import com.bagile.tms.services.SaleOrderLineService;
import com.bagile.tms.util.Search;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.io.IOException;
import java.math.BigDecimal;
import java.util.Collection;
import java.util.List;


@Service
@Transactional
public class SaleOrderLineServiceImpl implements SaleOrderLineService {

    private final SaleOrderLineRepository saleOrderLineRepository;
    public SaleOrderLineServiceImpl(SaleOrderLineRepository saleOrderLineRepository) {
        this.saleOrderLineRepository = saleOrderLineRepository;
    }

    @Override
    public SaleOrderLine save(SaleOrderLine saleOrderLine) {
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
        return SaleOrderLineMapper.toDto(saleOrderLineRepository.findById(id).orElseThrow(() -> new IdNotFound(id)), false);
    }

    @Override
    public SaleOrderLine findOne(String search) throws AttributesNotFound, ErrorType {
        return null;
    }

    @Override
    public List<SaleOrderLine> find(String search) throws AttributesNotFound, ErrorType {
        if (search.equals("")){
            return findAll ();
        }
        return SaleOrderLineMapper.toDtos(saleOrderLineRepository.findAll(Search.expression(search, CmdSaleOrderLine.class)), false);
    }

    @Override
    public List<SaleOrderLine> find(String search, int page, int size) throws AttributesNotFound, ErrorType {
        if (search.equals("")){
            return findAll (page, size);
        }
        Sort sort = Sort.by(Sort.Direction.DESC, "updateDate");
        Pageable pageable = PageRequest.of(page, size, sort);
        return SaleOrderLineMapper.toDtos(saleOrderLineRepository.findAll(Search.expression(search, CmdSaleOrderLine.class), pageable), false);
    }

    @Override
    public Long size(String search) throws AttributesNotFound, ErrorType {
        if (search.equals("")){
            return size ();
        }
        return saleOrderLineRepository.count(Search.expression(search, CmdSaleOrderLine.class));
    }

    @Override
    public void delete(Long id) {
        saleOrderLineRepository.deleteById(id);
    }

    @Override
    public void delete(SaleOrderLine saleOrderLine) {
        saleOrderLineRepository.delete(SaleOrderLineMapper.toEntity(saleOrderLine, false));
    }

    @Override
    public List<SaleOrderLine> findAll() {
        return SaleOrderLineMapper.toDtos(saleOrderLineRepository.findAll(), false);
    }



    @Override
    public SaleOrderLine loadWmsSaleOrderLine(SaleOrderLine saleOrderLine) throws IdNotFound {
        return null;
    }

    @Override
    public void updateSaleOrderLine(SaleOrderLine saleOrderLine, BigDecimal quantiyServed) {

    }


    @Override
    public SaleOrderLine cancelSaleOrderLine(SaleOrderLine saleOrderLine) throws AttributesNotFound, ErrorType, IdNotFound, CustomException{
        return null;
    }

    @Override
    public void cancelSaleOrderLine(SaleOrder saleOrder, SaleOrderLine saleOrderLine) throws AttributesNotFound, ErrorType {

    }

    @Override
    public List<SaleOrderLine> findAll(int page, int size) {
        Sort sort = Sort.by(Sort.Direction.DESC, "updateDate");
        Pageable pageable = PageRequest.of(page, size, sort);
        return SaleOrderLineMapper.toDtos(saleOrderLineRepository.findAll(pageable), false);
    }

}

