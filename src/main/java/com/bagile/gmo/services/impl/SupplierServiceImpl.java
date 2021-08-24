package com.bagile.gmo.services.impl;

import com.bagile.gmo.dto.Supplier;
import com.bagile.gmo.entities.RcpSupplier;
import com.bagile.gmo.exceptions.AttributesNotFound;
import com.bagile.gmo.exceptions.ErrorType;
import com.bagile.gmo.exceptions.IdNotFound;
import com.bagile.gmo.mapper.SupplierMapper;
import com.bagile.gmo.repositories.SupplierRepository;
import com.bagile.gmo.services.SettingService;
import com.bagile.gmo.services.SupplierService;
import com.bagile.gmo.util.GmaoSearch;
import com.bagile.gmo.util.Search;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.lang.NonNull;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


@Service
@Transactional
public class SupplierServiceImpl implements SupplierService,GmaoSearch {
    private final SupplierRepository supplierRepository;

    @Autowired
    private SettingService settingService;

    private final static Logger LOGGER = LoggerFactory
            .getLogger(SupplierService.class);

    public SupplierServiceImpl(SupplierRepository supplierRepository) {
        this.supplierRepository = supplierRepository;
    }

    @Override
    public Supplier save(@NonNull Supplier supplier) {
        LOGGER.info("save Supplier");
        supplier.setGmao(true);
        return SupplierMapper.toDto(supplierRepository.saveAndFlush(SupplierMapper.toEntity(supplier, false)), false);
    }

    @Override
    public Long size() throws AttributesNotFound, ErrorType {
        return supplierRepository.count(Search.expression(addGmaoToSearch(""), RcpSupplier.class));
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
        if (search.equals("")){
            return findAll ();
        }
        return SupplierMapper.toDtos(supplierRepository.findAll(Search.expression(addGmaoToSearch(search), RcpSupplier.class)), false);
    }

    @Override
    public List<Supplier> find(String search,int page, int size) throws AttributesNotFound, ErrorType {
        if (search.equals("")){
            return findAll (page, size);
        }

        Sort sort = Sort.by(Sort.Direction.DESC, "updateDate");
        Pageable pageable = PageRequest.of(page, size, sort);
        return SupplierMapper.toDtos(supplierRepository.findAll(Search.expression(addGmaoToSearch(search), RcpSupplier.class), pageable), false);
    }

    @Override
    public Long size(String search) throws AttributesNotFound, ErrorType {
        if (search.equals("")){
            return size ();
        }
        return supplierRepository.count(Search.expression(addGmaoToSearch(search), RcpSupplier.class));
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
    public List<Supplier> findAll(int page, int size) throws AttributesNotFound, ErrorType {
        Sort sort = Sort.by(Sort.Direction.DESC, "updateDate");
        Pageable pageable = PageRequest.of(page, size, sort);
        return SupplierMapper.toDtos(supplierRepository.findAll(Search.expression(addGmaoToSearch(""), RcpSupplier.class), pageable), false);
    }

    @Override
    public void deleteAll(List<Long> ids) {

        for (Long id : ids) {
            supplierRepository.deleteById(id);        }
    }

    @Override
    public String getNextVal() {
        String value=settingService.generateCodeSupplier() + supplierRepository.getNextVal().get(0);
        return value;


    }


}

