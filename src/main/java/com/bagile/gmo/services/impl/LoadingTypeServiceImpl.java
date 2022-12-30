package com.bagile.gmo.services.impl;

import com.bagile.gmo.dto.LoadingType;
import com.bagile.gmo.entities.TmsLoadingType;
import com.bagile.gmo.exceptions.AttributesNotFound;
import com.bagile.gmo.exceptions.ErrorType;
import com.bagile.gmo.exceptions.IdNotFound;
import com.bagile.gmo.mapper.LoadingTypeMapper;
import com.bagile.gmo.repositories.LoadingTypeRepository;
import com.bagile.gmo.services.LoadingTypeService;
import com.bagile.gmo.util.Search;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class LoadingTypeServiceImpl implements LoadingTypeService {

    private final LoadingTypeRepository loadingTypeRepository;

    public LoadingTypeServiceImpl(LoadingTypeRepository loadingTypeRepository) {
        this.loadingTypeRepository = loadingTypeRepository;
    }

    @Override
    public LoadingType save(LoadingType loadingType) {
        return LoadingTypeMapper.toDto(loadingTypeRepository.saveAndFlush(LoadingTypeMapper.toEntity(loadingType, false)), false);
    }

    @Override
    public Long size() {
        return loadingTypeRepository.count();
    }

    @Override
    public Boolean isExist(Long id) {
        return loadingTypeRepository.existsById(id);
    }

    @Override
    public LoadingType findById(Long id) throws IdNotFound {
        return LoadingTypeMapper.toDto(loadingTypeRepository.findById(id).orElseThrow(() -> new IdNotFound(id)), false);
    }

    @Override
    public List<LoadingType> find(String search) throws AttributesNotFound, ErrorType {
        if (search.equals("")){
            return findAll ();
        }
        return LoadingTypeMapper.toDtos(loadingTypeRepository.findAll(Search.expression(search, TmsLoadingType.class)), false);
    }

    @Override
    public List<LoadingType> find(String search, int page, int size) throws AttributesNotFound, ErrorType {
        if (search.equals("")){
            return findAll (page, size);
        }
        Sort sort = Sort.by(Sort.Direction.DESC, "updateDate");
        Pageable pageable = PageRequest.of(page, size, sort);
        return LoadingTypeMapper.toDtos(loadingTypeRepository.findAll(Search.expression(search, TmsLoadingType.class), pageable), false);
    }

    @Override
    public Long size(String search) throws AttributesNotFound, ErrorType {
        if (search.equals("")){
            return size ();
        }
        return loadingTypeRepository.count(Search.expression(search, TmsLoadingType.class));
    }

    @Override
    public void delete(Long id) {
        loadingTypeRepository.deleteById(id);
    }

    @Override
    public void delete(LoadingType loadingType) {
        loadingTypeRepository.delete(LoadingTypeMapper.toEntity(loadingType, false));
    }


    @Override
    public void deleteAll(List<Long> ids) {

        for (Long id : ids) {
            loadingTypeRepository.deleteById(id);        }
    }


    @Override
    public List<LoadingType> findAll()
    {
        return LoadingTypeMapper.toDtos(loadingTypeRepository.findAll(), false);
    }

    @Override
    public List<LoadingType> findAll(int page, int size) {
        Sort sort = Sort.by(Sort.Direction.DESC, "updateDate");
        Pageable pageable = PageRequest.of(page, size, sort);
        return LoadingTypeMapper.toDtos(loadingTypeRepository.findAll(pageable), false);
    }

}

