package com.bagile.tms.services.impl;

import com.bagile.tms.dto.SaleOrder;
import com.bagile.tms.dto.SaleOrderLine;
import com.bagile.tms.entities.CmdSaleOrder;
import com.bagile.tms.exceptions.AttributesNotFound;
import com.bagile.tms.exceptions.CustomException;
import com.bagile.tms.exceptions.ErrorType;
import com.bagile.tms.exceptions.IdNotFound;
import com.bagile.tms.mapper.SaleOrderMapper;
import com.bagile.tms.repositories.SaleOrderRepository;
import com.bagile.tms.services.SaleOrderService;
import com.bagile.tms.util.Search;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.io.IOException;
import java.util.Collection;
import java.util.List;


@Service
@Transactional
public class SaleOrderServiceImpl implements SaleOrderService {
    private final SaleOrderRepository saleOrderRepository;
    public SaleOrderServiceImpl(SaleOrderRepository saleOrderRepository) {
        this.saleOrderRepository = saleOrderRepository;
    }

    @Override
    public SaleOrder save(SaleOrder saleOrder) {
        return SaleOrderMapper.toDto(saleOrderRepository.saveAndFlush(SaleOrderMapper.toEntity(saleOrder, false)), false);
    }

    @Override
    public Long size() {
        return saleOrderRepository.count();
    }

    @Override
    public Boolean isExist(Long id) {
        return saleOrderRepository.existsById(id);
    }

    @Override
    public SaleOrder findById(Long id) throws IdNotFound {
        return SaleOrderMapper.toDto(saleOrderRepository.findById(id).orElseThrow(() -> new IdNotFound(id)), false);
    }

    @Override
    public SaleOrder findOne(String search) throws AttributesNotFound, ErrorType {
        return null;
    }

    @Override
    public List<SaleOrder> find(String search) throws AttributesNotFound, ErrorType {
        if (search.equals("")){
            return findAll ();
        }
        return SaleOrderMapper.toDtos(saleOrderRepository.findAll(Search.expression(search, CmdSaleOrder.class)), false);
    }

    @Override
    public List<SaleOrder> find(String search, int page, int size) throws AttributesNotFound, ErrorType {
        if (search.equals("")){
            return findAll (page, size);
        }
        Sort sort = Sort.by(Sort.Direction.DESC, "updateDate");
        Pageable pageable = PageRequest.of(page, size, sort);
        return SaleOrderMapper.toDtos(saleOrderRepository.findAll(Search.expression(search, CmdSaleOrder.class), pageable), false);
    }

    @Override
    public Long size(String search) throws AttributesNotFound, ErrorType {
        if (search.equals("")){
            return size ();
        }
        return saleOrderRepository.count(Search.expression(search, CmdSaleOrder.class));
    }

    @Override
    public void delete(Long id) {
        saleOrderRepository.deleteById(id);
    }

    @Override
    public void delete(SaleOrder saleOrder) {
        saleOrderRepository.delete(SaleOrderMapper.toEntity(saleOrder, false));
    }

    @Override
    public List<SaleOrder> findAll() {
        return SaleOrderMapper.toDtos(saleOrderRepository.findAll(), false);
    }



    @Override
    public String getNextVal() {
        return null;
    }

    @Override
    public String getTransfertCode() {
        return null;
    }

    @Override
    public SaleOrder loadWmsSaleOrder(SaleOrder saleOrder) throws IdNotFound, CustomException {
        return null;
    }

    @Override
    public void calculateAllLines(SaleOrder saleOrder, Collection<SaleOrderLine> lines) {

    }

    @Override
    public SaleOrder findByCode(String code) {
        return null;
    }

    @Override
    public SaleOrder updateSaleOrder(SaleOrder saleOrder) throws IdNotFound, CustomException {
        return null;
    }

    @Override
    public void updatePaymentStatus(SaleOrder saleOrder) throws IdNotFound, CustomException {

    }

    @Override
    public SaleOrder duplicate(SaleOrder saleOrder) throws IdNotFound, AttributesNotFound, ErrorType, CustomException {
        return null;
    }

    @Override
    public SaleOrder cancelSaleOrder(SaleOrder saleOrder) throws AttributesNotFound, ErrorType, IdNotFound, CustomException, IOException {
        return null;
    }

    @Override
    public SaleOrder close(SaleOrder saleOrder) throws AttributesNotFound, ErrorType, IdNotFound, CustomException {
        return null;
    }


    @Override
    public List<SaleOrder> findAll(int page, int size) {
        Sort sort = Sort.by(Sort.Direction.DESC, "updateDate");
        Pageable pageable = PageRequest.of(page, size, sort);
        return SaleOrderMapper.toDtos(saleOrderRepository.findAll(pageable), false);
    }

}

