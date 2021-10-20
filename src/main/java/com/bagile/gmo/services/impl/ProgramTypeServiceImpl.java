package com.bagile.gmo.services.impl;

import com.bagile.gmo.dto.ProgramType;
import com.bagile.gmo.entities.GmoProgramType;
import com.bagile.gmo.exceptions.AttributesNotFound;
import com.bagile.gmo.exceptions.ErrorType;
import com.bagile.gmo.exceptions.IdNotFound;
import com.bagile.gmo.mapper.ProgramTypeMapper;
import com.bagile.gmo.repositories.ProgramTypeRepository;
import com.bagile.gmo.services.ProgramTypeService;
import com.bagile.gmo.util.Search;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


@Service
public class ProgramTypeServiceImpl implements ProgramTypeService {
    private final ProgramTypeRepository programTypeRepository;

    public ProgramTypeServiceImpl(ProgramTypeRepository programTypeRepository) {
        this.programTypeRepository = programTypeRepository;
    }

    @Override
    public ProgramType save(ProgramType programType) {
        return ProgramTypeMapper.toDto(programTypeRepository.saveAndFlush(ProgramTypeMapper.toEntity(programType, false)), false);
    }

    @Override
    public Long size() {
        return programTypeRepository.count();
    }

    @Override
    public Boolean isExist(Long id) {
        return programTypeRepository.existsById(id);
    }

    @Override
    public ProgramType findById(Long id) throws IdNotFound {
        return ProgramTypeMapper.toDto(programTypeRepository.findById(id).orElseThrow(() -> new IdNotFound(id)), false);
    }

    @Override
    public List<ProgramType> find(String search) throws AttributesNotFound, ErrorType {
        if (search.equals("")){
            return findAll ();
        }
        return ProgramTypeMapper.toDtos(programTypeRepository.findAll(Search.expression(search, GmoProgramType.class)), false);
    }

    @Override
    public List<ProgramType> find(String search, int page, int size) throws AttributesNotFound, ErrorType {
        if (search.equals("")){
            return findAll (page, size);
        }
        Sort sort = Sort.by(Sort.Direction.DESC, "updateDate");
        Pageable pageable = PageRequest.of(page, size, sort);
        return ProgramTypeMapper.toDtos(programTypeRepository.findAll(Search.expression(search, GmoProgramType.class), pageable), false);
    }

    @Override
    public Long size(String search) throws AttributesNotFound, ErrorType {
        if (search.equals("")){
            return size ();
        }
        return programTypeRepository.count(Search.expression(search, GmoProgramType.class));
    }

    @Override
    public void delete(Long id) {
        programTypeRepository.deleteById(id);
    }

    @Override
    public void delete(ProgramType programType) {
        programTypeRepository.delete(ProgramTypeMapper.toEntity(programType, false));
    }


    @Override
    public void deleteAll(List<Long> ids) {

        for (Long id : ids) {
            programTypeRepository.deleteById(id);        }
    }


    @Override
    public List<ProgramType> findAll() {
        return ProgramTypeMapper.toDtos(programTypeRepository.findAll(), false);
    }

    @Override
    public List<ProgramType> findAll(int page, int size) {
        Sort sort = Sort.by(Sort.Direction.DESC, "updateDate");
        Pageable pageable = PageRequest.of(page, size, sort);
        return ProgramTypeMapper.toDtos(programTypeRepository.findAll(pageable), false);
    }

}

