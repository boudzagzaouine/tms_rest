package com.bagile.tms.services.impl;

import com.bagile.tms.dto.Supplier;
import com.bagile.tms.entities.RcpSupplier;
import com.bagile.tms.exceptions.AttributesNotFound;
import com.bagile.tms.exceptions.ErrorType;
import com.bagile.tms.exceptions.IdNotFound;
import com.bagile.tms.mapper.SupplierMapper;
import com.bagile.tms.repositories.SupplierRepository;
import com.bagile.tms.services.SupplierService;
import com.bagile.tms.util.Search;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


@Service
@Transactional
public class SupplierServiceImpl implements SupplierService {
    private final SupplierRepository supplierRepository;
    private final static Logger LOGGER = LoggerFactory
            .getLogger(SupplierService.class);

    public SupplierServiceImpl(SupplierRepository supplierRepository) {
        this.supplierRepository = supplierRepository;
    }

    @Override
    public Supplier save(Supplier supplier) {
        LOGGER.info("save Supplier");
        return SupplierMapper.toDto(supplierRepository.saveAndFlush(SupplierMapper.toEntity(supplier, false)), false);
    }

    @Override
    public Long size() {
        return supplierRepository.count();
    }

    @Override
    public Boolean isExist(Long id) {
        return supplierRepository.existsById(id);
    }

    @Override
    public Supplier findById(Long id) throws IdNotFound {
        return SupplierMapper.toDto(supplierRepository.findById(id).orElseThrow(() -> new IdNotFound(id)), false);
    }

    @Override
    public List<Supplier> find(String search) throws AttributesNotFound, ErrorType {
        if (search.isBlank ()){
            return findAll ();
        }
        return SupplierMapper.toDtos(supplierRepository.findAll(Search.expression(search, RcpSupplier.class)), false);
    }

    @Override
    public List<Supplier> find(String search, int page, int size) throws AttributesNotFound, ErrorType {
        if (search.isBlank ()){
            return findAll (page, size);
        }
        Sort sort = Sort.by(Sort.Direction.DESC, "prmSupplierUpdateDate");
        Pageable pageable = PageRequest.of(page, size, sort);
        return SupplierMapper.toDtos(supplierRepository.findAll(Search.expression(search, RcpSupplier.class), pageable), false);
    }

    @Override
    public Long size(String search) throws AttributesNotFound, ErrorType {
        if (search.isBlank ()){
            return size ();
        }
        return supplierRepository.count(Search.expression(search, RcpSupplier.class));
    }

    @Override
    public void delete(Long id) {
        LOGGER.info("save Supplier");
        supplierRepository.deleteById(id);
    }

    @Override
    public void delete(Supplier supplier) {
        LOGGER.info("delete Supplier");
        supplierRepository.delete(SupplierMapper.toEntity(supplier, false));
    }

    @Override
    public List<Supplier> findAll() {
        return SupplierMapper.toDtos(supplierRepository.findAll(), false);
    }

    @Override
    public List<Supplier> findAll(int page, int size) {
        Sort sort = Sort.by(Sort.Direction.DESC, "prmSupplierUpdateDate");
        Pageable pageable = PageRequest.of(page, size, sort);
        return SupplierMapper.toDtos(supplierRepository.findAll(pageable), false);
    }

}

