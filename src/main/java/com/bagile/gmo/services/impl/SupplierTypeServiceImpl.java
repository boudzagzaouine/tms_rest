package com.bagile.gmo.services.impl;

import com.bagile.gmo.dto.SupplierType;
import com.bagile.gmo.entities.GmoSupplierType;
import com.bagile.gmo.exceptions.AttributesNotFound;
import com.bagile.gmo.exceptions.ErrorType;
import com.bagile.gmo.exceptions.IdNotFound;
import com.bagile.gmo.mapper.SupplierTypeMapper;
import com.bagile.gmo.repositories.SupplierTypeRepository;
import com.bagile.gmo.services.SupplierTypeService;
import com.bagile.gmo.util.Search;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class SupplierTypeServiceImpl implements SupplierTypeService {
    
    private final SupplierTypeRepository supplierTypeRepository;

    public SupplierTypeServiceImpl(SupplierTypeRepository supplierTypeRepository) {
        this.supplierTypeRepository = supplierTypeRepository;
    }

    @Override
    public SupplierType save(SupplierType supplierType) {
        return SupplierTypeMapper.toDto(supplierTypeRepository.saveAndFlush(SupplierTypeMapper.toEntity(supplierType, false)), false);
    }

    @Override
    public Long size() {
        return supplierTypeRepository.count();
    }

    @Override
    public Boolean isExist(Long id) {
        return supplierTypeRepository.existsById(id);
    }

    @Override
    public SupplierType findById(Long id) throws IdNotFound {
        return SupplierTypeMapper.toDto(supplierTypeRepository.findById(id).orElseThrow(() -> new IdNotFound(id)), false);
    }

    @Override
    public List<SupplierType> find(String search) throws AttributesNotFound, ErrorType {
        if (search.equals("")){
            return findAll ();
        }
        return SupplierTypeMapper.toDtos(supplierTypeRepository.findAll(Search.expression(search, GmoSupplierType.class)), false);
    }

    @Override
    public List<SupplierType> find(String search, int page, int size) throws AttributesNotFound, ErrorType {
        if (search.equals("")){
            return findAll (page, size);
        }
        Sort sort = Sort.by(Sort.Direction.DESC, "updateDate");
        Pageable pageable = PageRequest.of(page, size, sort);
        return SupplierTypeMapper.toDtos(supplierTypeRepository.findAll(Search.expression(search, GmoSupplierType.class), pageable), false);
    }

    @Override
    public Long size(String search) throws AttributesNotFound, ErrorType {
        if (search.equals("")){
            return size ();
        }
        return supplierTypeRepository.count(Search.expression(search, GmoSupplierType.class));
    }

    @Override
    public void delete(Long id) {
        supplierTypeRepository.deleteById(id);
    }

    @Override
    public void delete(SupplierType supplierType) {
        supplierTypeRepository.delete(SupplierTypeMapper.toEntity(supplierType, false));
    }


    @Override
    public void deleteAll(List<Long> ids) {

        for (Long id : ids) {
            supplierTypeRepository.deleteById(id);        }
    }


    @Override
    public List<SupplierType> findAll() {
        return SupplierTypeMapper.toDtos(supplierTypeRepository.findAll(), false);
    }

    @Override
    public List<SupplierType> findAll(int page, int size) {
        Sort sort = Sort.by(Sort.Direction.DESC, "updateDate");
        Pageable pageable = PageRequest.of(page, size, sort);
        return SupplierTypeMapper.toDtos(supplierTypeRepository.findAll(pageable), false);
    }

    @Override
    public SupplierType findOne(String search) throws AttributesNotFound, ErrorType {
        return null;
    }

}

