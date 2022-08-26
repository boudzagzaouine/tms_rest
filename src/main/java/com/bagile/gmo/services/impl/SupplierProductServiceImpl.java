package com.bagile.gmo.services.impl;

import com.bagile.gmo.dto.SupplierProduct;
import com.bagile.gmo.entities.TmsSupplierProduct;
import com.bagile.gmo.exceptions.AttributesNotFound;
import com.bagile.gmo.exceptions.ErrorType;
import com.bagile.gmo.exceptions.IdNotFound;
import com.bagile.gmo.mapper.SupplierProductMapper;
import com.bagile.gmo.repositories.SupplierProductRepository;
import com.bagile.gmo.services.SupplierProductService;
import com.bagile.gmo.util.Search;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class SupplierProductServiceImpl implements SupplierProductService {

    private final SupplierProductRepository supplierProductRepository;

    public SupplierProductServiceImpl(SupplierProductRepository supplierProductRepository) {
        this.supplierProductRepository = supplierProductRepository;
    }

    @Override
    public SupplierProduct save(SupplierProduct supplierProduct) {
        return SupplierProductMapper.toDto(supplierProductRepository.saveAndFlush(SupplierProductMapper.toEntity(supplierProduct, false)), false);
    }

    @Override
    public Long size() {
        return supplierProductRepository.count();
    }

    @Override
    public Boolean isExist(Long id) {
        return supplierProductRepository.existsById(id);
    }

    @Override
    public SupplierProduct findById(Long id) throws IdNotFound {
        return SupplierProductMapper.toDto(supplierProductRepository.findById(id).orElseThrow(() -> new IdNotFound(id)), false);
    }

    @Override
    public List<SupplierProduct> find(String search) throws AttributesNotFound, ErrorType {
        if (search.equals("")){
            return findAll ();
        }
        return SupplierProductMapper.toDtos(supplierProductRepository.findAll(Search.expression(search, TmsSupplierProduct.class)), false);
    }

    @Override
    public List<SupplierProduct> find(String search, int page, int size) throws AttributesNotFound, ErrorType {
        if (search.equals("")){
            return findAll (page, size);
        }
        Sort sort = Sort.by(Sort.Direction.DESC, "updateDate");
        Pageable pageable = PageRequest.of(page, size, sort);
        return SupplierProductMapper.toDtos(supplierProductRepository.findAll(Search.expression(search, TmsSupplierProduct.class), pageable), false);
    }

    @Override
    public Long size(String search) throws AttributesNotFound, ErrorType {
        if (search.equals("")){
            return size ();
        }
        return supplierProductRepository.count(Search.expression(search, TmsSupplierProduct.class));
    }

    @Override
    public void delete(Long id) {
        supplierProductRepository.deleteById(id);
    }

    @Override
    public void delete(SupplierProduct supplierProduct) {
        supplierProductRepository.delete(SupplierProductMapper.toEntity(supplierProduct, false));
    }


    @Override
    public void deleteAll(List<Long> ids) {

        for (Long id : ids) {
            supplierProductRepository.deleteById(id);        }
    }


    @Override
    public List<SupplierProduct> findAll()
    {
        return SupplierProductMapper.toDtos(supplierProductRepository.findAll(), false);
    }

    @Override
    public List<SupplierProduct> findAll(int page, int size) {
        Sort sort = Sort.by(Sort.Direction.DESC, "updateDate");
        Pageable pageable = PageRequest.of(page, size, sort);
        return SupplierProductMapper.toDtos(supplierProductRepository.findAll(pageable), false);
    }

}

