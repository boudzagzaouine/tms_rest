package com.bagile.gmo.services.impl;

import com.bagile.gmo.dto.SaleOrderLine;
import com.bagile.gmo.entities.CmdSaleOrder;
import com.bagile.gmo.exceptions.AttributesNotFound;
import com.bagile.gmo.exceptions.ErrorType;
import com.bagile.gmo.exceptions.IdNotFound;
import com.bagile.gmo.mapper.SaleOrderLineMapper;
import com.bagile.gmo.repositories.SaleOrderLineRepository;
import com.bagile.gmo.services.SaleOrderLineService;
import com.bagile.gmo.util.Search;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
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
    public List<SaleOrderLine> updateAll(List<SaleOrderLine> saleOrderLines) {
        List<SaleOrderLine> saleOrderLines1= new ArrayList<>();
        for (SaleOrderLine orderline : saleOrderLines)
        {
            saleOrderLines1.add(save(orderline));
        }

        return saleOrderLines1;
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
        return SaleOrderLineMapper.toDtos(saleOrderLineRepository.findAll(Search.expression(search, CmdSaleOrder.class)), false);
    }

    @Override
    public List<SaleOrderLine> find(String search, int page, int size) throws AttributesNotFound, ErrorType {
        if (search.equals("")){
            return findAll (page, size);
        }
        Sort sort = Sort.by(Sort.Direction.DESC, "updateDate");
        Pageable pageable = PageRequest.of(page, size, sort);
        return SaleOrderLineMapper.toDtos(saleOrderLineRepository.findAll(Search.expression(search, CmdSaleOrder.class), pageable), false);
    }

    @Override
    public Long size(String search) throws AttributesNotFound, ErrorType {
        if (search.equals("")){
            return size ();
        }
        return saleOrderLineRepository.count(Search.expression(search, CmdSaleOrder.class));
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
    public String getNextVal() {
        return null;
    }
    

    @Override
    public List<SaleOrderLine> findAll(int page, int size) {
        Sort sort = Sort.by(Sort.Direction.DESC, "updateDate");
        Pageable pageable = PageRequest.of(page, size, sort);
        return SaleOrderLineMapper.toDtos(saleOrderLineRepository.findAll(pageable), false);
    }

}

