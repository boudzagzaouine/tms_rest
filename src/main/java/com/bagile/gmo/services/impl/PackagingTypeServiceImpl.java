package com.bagile.gmo.services.impl;

import com.bagile.gmo.dto.PackagingType;
import com.bagile.gmo.entities.TmsPackagingType;
import com.bagile.gmo.exceptions.AttributesNotFound;
import com.bagile.gmo.exceptions.ErrorType;
import com.bagile.gmo.exceptions.IdNotFound;
import com.bagile.gmo.mapper.PackagingTypeMapper;
import com.bagile.gmo.repositories.PackagingTypeRepository;
import com.bagile.gmo.services.PackagingTypeService;
import com.bagile.gmo.util.Search;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class PackagingTypeServiceImpl implements PackagingTypeService {
    
    private final PackagingTypeRepository packagingTypeRepository;

    public PackagingTypeServiceImpl(PackagingTypeRepository packagingTypeRepository) {
        this.packagingTypeRepository = packagingTypeRepository;
    }

    @Override
    public PackagingType save(PackagingType packagingType) {
        return PackagingTypeMapper.toDto(packagingTypeRepository.saveAndFlush(PackagingTypeMapper.toEntity(packagingType, false)), false);
    }

    @Override
    public Long size() {
        return packagingTypeRepository.count();
    }

    @Override
    public Boolean isExist(Long id) {
        return packagingTypeRepository.existsById(id);
    }

    @Override
    public PackagingType findById(Long id) throws IdNotFound {
        return PackagingTypeMapper.toDto(packagingTypeRepository.findById(id).orElseThrow(() -> new IdNotFound(id)), false);
    }

    @Override
    public List<PackagingType> find(String search) throws AttributesNotFound, ErrorType {
        if (search.equals("")){
            return findAll ();
        }
        return PackagingTypeMapper.toDtos(packagingTypeRepository.findAll(Search.expression(search, TmsPackagingType.class)), false);
    }

    @Override
    public List<PackagingType> find(String search, int page, int size) throws AttributesNotFound, ErrorType {
        if (search.equals("")){
            return findAll (page, size);
        }
        Sort sort = Sort.by(Sort.Direction.DESC, "updateDate");
        Pageable pageable = PageRequest.of(page, size, sort);
        return PackagingTypeMapper.toDtos(packagingTypeRepository.findAll(Search.expression(search, TmsPackagingType.class), pageable), false);
    }

    @Override
    public Long size(String search) throws AttributesNotFound, ErrorType {
        if (search.equals("")){
            return size ();
        }
        return packagingTypeRepository.count(Search.expression(search, TmsPackagingType.class));
    }

    @Override
    public void delete(Long id) {
        packagingTypeRepository.deleteById(id);
    }

    @Override
    public void delete(PackagingType packagingType) {
        packagingTypeRepository.delete(PackagingTypeMapper.toEntity(packagingType, false));
    }


    @Override
    public void deleteAll(List<Long> ids) {

        for (Long id : ids) {
            packagingTypeRepository.deleteById(id);        }
    }


    @Override
    public List<PackagingType> findAll() {
        return PackagingTypeMapper.toDtos(packagingTypeRepository.findAll(), false);
    }

    @Override
    public List<PackagingType> findAll(int page, int size) {
        Sort sort = Sort.by(Sort.Direction.DESC, "updateDate");
        Pageable pageable = PageRequest.of(page, size, sort);
        return PackagingTypeMapper.toDtos(packagingTypeRepository.findAll(pageable), false);
    }

    @Override
    public PackagingType findOne(String search) throws AttributesNotFound, ErrorType {
        return null;
    }

}

