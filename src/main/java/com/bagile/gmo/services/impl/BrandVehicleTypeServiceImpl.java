package com.bagile.gmo.services.impl;

import com.bagile.gmo.dto.BrandVehicleType;
import com.bagile.gmo.entities.GmoBrandVehicleType;
import com.bagile.gmo.exceptions.AttributesNotFound;
import com.bagile.gmo.exceptions.ErrorType;
import com.bagile.gmo.exceptions.IdNotFound;
import com.bagile.gmo.mapper.BrandVehicleTypeMapper;
import com.bagile.gmo.repositories.BrandVehicleTypeRepository;
import com.bagile.gmo.services.BrandVehicleTypeService;
import com.bagile.gmo.util.Search;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class BrandVehicleTypeServiceImpl implements BrandVehicleTypeService {
    
    private final BrandVehicleTypeRepository brandVehicleTypeRepository;

    public BrandVehicleTypeServiceImpl(BrandVehicleTypeRepository brandVehicleTypeRepository) {
        this.brandVehicleTypeRepository = brandVehicleTypeRepository;
    }

    @Override
    public BrandVehicleType save(BrandVehicleType BrandVehicleType) {
        return BrandVehicleTypeMapper.toDto(brandVehicleTypeRepository.saveAndFlush(BrandVehicleTypeMapper.toEntity(BrandVehicleType, false)), false);
    }

    @Override
    public Long size() {
        return brandVehicleTypeRepository.count();
    }

    @Override
    public Boolean isExist(Long id) {
        return brandVehicleTypeRepository.existsById(id);
    }

    @Override
    public BrandVehicleType findById(Long id) throws IdNotFound {
        return BrandVehicleTypeMapper.toDto(brandVehicleTypeRepository.findById(id).orElseThrow(() -> new IdNotFound(id)), false);
    }

    @Override
    public List<BrandVehicleType> find(String search) throws AttributesNotFound, ErrorType {
        if (search.equals("")){
            return findAll ();
        }
        return BrandVehicleTypeMapper.toDtos(brandVehicleTypeRepository.findAll(Search.expression(search, GmoBrandVehicleType.class)), false);
    }

    @Override
    public List<BrandVehicleType> find(String search, int page, int size) throws AttributesNotFound, ErrorType {
        if (search.equals("")){
            return findAll (page, size);
        }
        Sort sort = Sort.by(Sort.Direction.DESC, "updateDate");
        Pageable pageable = PageRequest.of(page, size, sort);
        return BrandVehicleTypeMapper.toDtos(brandVehicleTypeRepository.findAll(Search.expression(search, GmoBrandVehicleType.class), pageable), false);
    }

    @Override
    public Long size(String search) throws AttributesNotFound, ErrorType {
        if (search.equals("")){
            return size ();
        }
        return brandVehicleTypeRepository.count(Search.expression(search, GmoBrandVehicleType.class));
    }

    @Override
    public void delete(Long id) {
        brandVehicleTypeRepository.deleteById(id);
    }

    @Override
    public void delete(BrandVehicleType BrandVehicleType) {
        brandVehicleTypeRepository.delete(BrandVehicleTypeMapper.toEntity(BrandVehicleType, false));
    }


    @Override
    public void deleteAll(List<Long> ids) {

        for (Long id : ids) {
            brandVehicleTypeRepository.deleteById(id);        }
    }


    @Override
    public List<BrandVehicleType> findAll() {
        return BrandVehicleTypeMapper.toDtos(brandVehicleTypeRepository.findAll(), false);
    }

    @Override
    public List<BrandVehicleType> findAll(int page, int size) {
        Sort sort = Sort.by(Sort.Direction.DESC, "updateDate");
        Pageable pageable = PageRequest.of(page, size, sort);
        return BrandVehicleTypeMapper.toDtos(brandVehicleTypeRepository.findAll(pageable), false);
    }

    @Override
    public BrandVehicleType findOne(String search) throws AttributesNotFound, ErrorType {
        return null;
    }

}

