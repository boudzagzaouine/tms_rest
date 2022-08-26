package com.bagile.gmo.services.impl;


import com.bagile.gmo.dto.SupplierInvoiceLine;
import com.bagile.gmo.entities.InvSupplierInvoiceLine;
import com.bagile.gmo.exceptions.AttributesNotFound;
import com.bagile.gmo.exceptions.ErrorType;
import com.bagile.gmo.exceptions.IdNotFound;
import com.bagile.gmo.mapper.SupplierInvoiceLineMapper;
import com.bagile.gmo.repositories.SupplierInvoiceLineRepository;
import com.bagile.gmo.services.SupplierInvoiceLineService;
import com.bagile.gmo.util.EmsDate;
import com.bagile.gmo.util.Search;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Enissay on 03/12/2016.
 */
@Service
public class SupplierInvoiceLineServiceImpl implements SupplierInvoiceLineService {
    @Autowired
    private SupplierInvoiceLineRepository supplierInvoiceLineRepository;
    private final static Logger LOGGER = LoggerFactory
            .getLogger(SupplierInvoiceLineService.class);

    @Override
    public SupplierInvoiceLine save(SupplierInvoiceLine supplierInvoiceLine) {
        LOGGER.info("save SupplierInvoiceLine");
        supplierInvoiceLine.setUpdateDate(EmsDate.getDateNow());
        if (0 >= supplierInvoiceLine.getId()) {
            supplierInvoiceLine.setCreationDate(EmsDate.getDateNow());
        }
        return SupplierInvoiceLineMapper.toDto(supplierInvoiceLineRepository.saveAndFlush(SupplierInvoiceLineMapper.toEntity(supplierInvoiceLine, false)), false);
    }

    @Override
    public Long size() {
        return supplierInvoiceLineRepository.count();
    }

    @Override
    public Boolean isExist(Long id) {
        return supplierInvoiceLineRepository.existsById(id);
    }

    @Override
    public SupplierInvoiceLine findById(Long id) throws IdNotFound {
        SupplierInvoiceLine supplierInvoiceLine = SupplierInvoiceLineMapper.toDto(supplierInvoiceLineRepository.findById(id).orElseThrow(()-> new IdNotFound(id)), false);
        if (null != supplierInvoiceLine) {
            return supplierInvoiceLine;
        } else {
            throw new IdNotFound(id);
        }
    }

    @Override
    public List<SupplierInvoiceLine> find(String search) throws AttributesNotFound, ErrorType {
        return SupplierInvoiceLineMapper.toDtos(supplierInvoiceLineRepository.findAll(Search.expression(search, InvSupplierInvoiceLine.class)), false);
    }  @Override
    public SupplierInvoiceLine findOne(String search) throws AttributesNotFound, ErrorType {
        return SupplierInvoiceLineMapper.toDto(supplierInvoiceLineRepository.findOne(Search.expression(search, InvSupplierInvoiceLine.class)).orElseThrow(()-> new AttributesNotFound(search)), false);
    }

    @Override
    public List<SupplierInvoiceLine> find(String search, int page, int size) throws AttributesNotFound, ErrorType {
        Sort sort =  Sort.by(Sort.Direction.DESC, "InvSupplierInvoiceLineUpdateDate");
        Pageable pageable =  PageRequest.of(page, size, sort);
        return SupplierInvoiceLineMapper.toDtos(supplierInvoiceLineRepository.findAll(Search.expression(search, InvSupplierInvoiceLine.class), pageable), false);
    }

    @Override
    public Long size(String search) throws AttributesNotFound, ErrorType {
        return supplierInvoiceLineRepository.count(Search.expression(search, InvSupplierInvoiceLine.class));
    }

    @Override
    public void delete(Long id) {
        LOGGER.info("delete SupplierInvoiceLine");
        supplierInvoiceLineRepository.deleteById(id);
    }

    @Override
    public void delete(SupplierInvoiceLine supplierInvoiceLine) {
        LOGGER.info("delete SupplierInvoiceLine");
        supplierInvoiceLineRepository.delete(SupplierInvoiceLineMapper.toEntity(supplierInvoiceLine, false));
    }

    @Override
    public List<SupplierInvoiceLine> findAll() {
        return SupplierInvoiceLineMapper.toDtos(supplierInvoiceLineRepository.findAll(), false);
    }

    @Override
    public List<SupplierInvoiceLine> findAll(Pageable pageable) {
        return SupplierInvoiceLineMapper.toDtos(supplierInvoiceLineRepository.findAll(pageable), false);
    }

}
