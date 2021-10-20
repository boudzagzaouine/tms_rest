package com.bagile.gmo.services.impl;

import com.bagile.gmo.dto.Responsability;
import com.bagile.gmo.entities.GmoResponsability;
import com.bagile.gmo.exceptions.AttributesNotFound;
import com.bagile.gmo.exceptions.ErrorType;
import com.bagile.gmo.exceptions.IdNotFound;
import com.bagile.gmo.mapper.ResponsabilityMapper;
import com.bagile.gmo.repositories.ResponsabilityRepository;
import com.bagile.gmo.services.ResponsabilityService;
import com.bagile.gmo.util.Search;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


@Service
public class ResponsabilityServiceImpl implements ResponsabilityService {
    private final ResponsabilityRepository responsabilityRepository;

    public ResponsabilityServiceImpl(ResponsabilityRepository responsabilityRepository) {
        this.responsabilityRepository = responsabilityRepository;
    }

    @Override
    public Responsability save(Responsability responsability) {
        return ResponsabilityMapper.toDto(responsabilityRepository.saveAndFlush(ResponsabilityMapper.toEntity(responsability, false)), false);
    }

    @Override
    public Long size() {
        return responsabilityRepository.count();
    }

    @Override
    public Boolean isExist(Long id) {
        return responsabilityRepository.existsById(id);
    }

    @Override
    public Responsability findById(Long id) throws IdNotFound {
        return ResponsabilityMapper.toDto(responsabilityRepository.findById(id).orElseThrow(() -> new IdNotFound(id)), false);
    }

    @Override
    public List<Responsability> find(String search) throws AttributesNotFound, ErrorType {
        if (search.equals("")){
            return findAll ();
        }
        return ResponsabilityMapper.toDtos(responsabilityRepository.findAll(Search.expression(search, GmoResponsability.class)), false);
    }

    @Override
    public List<Responsability> find(String search, int page, int size) throws AttributesNotFound, ErrorType {
        if (search.equals("")){
            return findAll (page, size);
        }
        Sort sort = Sort.by(Sort.Direction.DESC, "updateDate");
        Pageable pageable = PageRequest.of(page, size, sort);
        return ResponsabilityMapper.toDtos(responsabilityRepository.findAll(Search.expression(search, GmoResponsability.class), pageable), false);
    }

    @Override
    public Long size(String search) throws AttributesNotFound, ErrorType {
        if (search.equals("")){
            return size ();
        }
        return responsabilityRepository.count(Search.expression(search, GmoResponsability.class));
    }

    @Override
    public void delete(Long id) {
        responsabilityRepository.deleteById(id);
    }

    @Override
    public void delete(Responsability responsability) {
        responsabilityRepository.delete(ResponsabilityMapper.toEntity(responsability, false));
    }


    @Override
    public void deleteAll(List<Long> ids) {

        for (Long id : ids) {
            responsabilityRepository.deleteById(id);        }
    }


    @Override
    public List<Responsability> findAll() {
        return ResponsabilityMapper.toDtos(responsabilityRepository.findAll(), false);
    }

    @Override
    public List<Responsability> findAll(int page, int size) {
        Sort sort = Sort.by(Sort.Direction.DESC, "updateDate");
        Pageable pageable = PageRequest.of(page, size, sort);
        return ResponsabilityMapper.toDtos(responsabilityRepository.findAll(pageable), false);
    }

}

