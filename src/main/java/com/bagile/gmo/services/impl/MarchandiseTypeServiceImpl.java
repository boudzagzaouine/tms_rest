package com.bagile.gmo.services.impl;

import com.bagile.gmo.dto.MarchandiseType;
import com.bagile.gmo.entities.TmsMarchandiseType;
import com.bagile.gmo.exceptions.AttributesNotFound;
import com.bagile.gmo.exceptions.ErrorType;
import com.bagile.gmo.exceptions.IdNotFound;
import com.bagile.gmo.mapper.MarchandiseTypeMapper;
import com.bagile.gmo.repositories.MarchandiseTypeRepository;
import com.bagile.gmo.services.MarchandiseTypeService;
import com.bagile.gmo.util.Search;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class MarchandiseTypeServiceImpl implements MarchandiseTypeService {
    
    private final MarchandiseTypeRepository marchandiseTypeRepository;

    public MarchandiseTypeServiceImpl(MarchandiseTypeRepository marchandiseTypeRepository) {
        this.marchandiseTypeRepository = marchandiseTypeRepository;
    }

    @Override
    public MarchandiseType save(MarchandiseType marchandiseType) {
        return MarchandiseTypeMapper.toDto(marchandiseTypeRepository.saveAndFlush(MarchandiseTypeMapper.toEntity(marchandiseType, false)), false);
    }

    @Override
    public Long size() {
        return marchandiseTypeRepository.count();
    }

    @Override
    public Boolean isExist(Long id) {
        return marchandiseTypeRepository.existsById(id);
    }

    @Override
    public MarchandiseType findById(Long id) throws IdNotFound {
        return MarchandiseTypeMapper.toDto(marchandiseTypeRepository.findById(id).orElseThrow(() -> new IdNotFound(id)), false);
    }

    @Override
    public List<MarchandiseType> find(String search) throws AttributesNotFound, ErrorType {
        if (search.equals("")){
            return findAll ();
        }
        return MarchandiseTypeMapper.toDtos(marchandiseTypeRepository.findAll(Search.expression(search, TmsMarchandiseType.class)), false);
    }

    @Override
    public List<MarchandiseType> find(String search, int page, int size) throws AttributesNotFound, ErrorType {
        if (search.equals("")){
            return findAll (page, size);
        }
        Sort sort = Sort.by(Sort.Direction.DESC, "updateDate");
        Pageable pageable = PageRequest.of(page, size, sort);
        return MarchandiseTypeMapper.toDtos(marchandiseTypeRepository.findAll(Search.expression(search, TmsMarchandiseType.class), pageable), false);
    }

    @Override
    public Long size(String search) throws AttributesNotFound, ErrorType {
        if (search.equals("")){
            return size ();
        }
        return marchandiseTypeRepository.count(Search.expression(search, TmsMarchandiseType.class));
    }

    @Override
    public void delete(Long id) {
        marchandiseTypeRepository.deleteById(id);
    }

    @Override
    public void delete(MarchandiseType marchandiseType) {
        marchandiseTypeRepository.delete(MarchandiseTypeMapper.toEntity(marchandiseType, false));
    }


    @Override
    public void deleteAll(List<Long> ids) {

        for (Long id : ids) {
            marchandiseTypeRepository.deleteById(id);        }
    }


    @Override
    public List<MarchandiseType> findAll() {
        return MarchandiseTypeMapper.toDtos(marchandiseTypeRepository.findAll(), false);
    }

    @Override
    public List<MarchandiseType> findAll(int page, int size) {
        Sort sort = Sort.by(Sort.Direction.DESC, "updateDate");
        Pageable pageable = PageRequest.of(page, size, sort);
        return MarchandiseTypeMapper.toDtos(marchandiseTypeRepository.findAll(pageable), false);
    }

    @Override
    public MarchandiseType findOne(String search) throws AttributesNotFound, ErrorType {
        return null;
    }

}

