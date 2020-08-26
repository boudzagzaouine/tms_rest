package com.bagile.gmo.services.impl;

import com.bagile.gmo.dto.Reception;
import com.bagile.gmo.entities.RcpReception;
import com.bagile.gmo.exceptions.AttributesNotFound;
import com.bagile.gmo.exceptions.ErrorType;
import com.bagile.gmo.exceptions.IdNotFound;
import com.bagile.gmo.mapper.ReceptionMapper;
import com.bagile.gmo.repositories.ReceptionRepository;
import com.bagile.gmo.services.ReceptionService;
import com.bagile.gmo.util.Search;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


@Service
@Transactional
public class ReceptionServiceImpl implements ReceptionService {
    
    private final ReceptionRepository receptionRepository;

    public ReceptionServiceImpl(ReceptionRepository receptionRepository) {
        this.receptionRepository = receptionRepository;
    }

    @Override
    public Reception save(Reception Reception) {
        return ReceptionMapper.toDto(receptionRepository.saveAndFlush(ReceptionMapper.toEntity(Reception, false)), false);
    }

    @Override
    public Long size() {
        return receptionRepository.count();
    }

    @Override
    public Boolean isExist(Long id) {
        return receptionRepository.existsById(id);
    }

    @Override
    public Reception findById(Long id) throws IdNotFound {
        return ReceptionMapper.toDto(receptionRepository.findById(id).orElseThrow(() -> new IdNotFound(id)), false);
    }

    @Override
    public List<Reception> find(String search) throws AttributesNotFound, ErrorType {
        if (search.equals("")){
            return findAll ();
        }
        return ReceptionMapper.toDtos(receptionRepository.findAll(Search.expression(search, RcpReception.class)), false);
    }

    @Override
    public List<Reception> find(String search, int page, int size) throws AttributesNotFound, ErrorType {
        if (search.equals("")){
            return findAll (page, size);
        }
        Sort sort = Sort.by(Sort.Direction.DESC, "updateDate");
        Pageable pageable = PageRequest.of(page, size, sort);
        return ReceptionMapper.toDtos(receptionRepository.findAll(Search.expression(search, RcpReception.class), pageable), false);
    }

    @Override
    public Reception findOne(String search) throws AttributesNotFound, ErrorType {
        return ReceptionMapper.toDto (receptionRepository.findOne (Search.expression (search, RcpReception.class)).orElseThrow (() -> new AttributesNotFound (search)), false);

    }

    @Override
    public Long size(String search) throws AttributesNotFound, ErrorType {
        if (search.equals("")){
            return size ();
        }
        return receptionRepository.count(Search.expression(search, RcpReception.class));
    }

    @Override
    public void delete(Long id) {
        receptionRepository.deleteById(id);
    }

    @Override
    public void delete(Reception Reception) {
        receptionRepository.delete(ReceptionMapper.toEntity(Reception, false));
    }
    @Override
    public void deleteAll(List<Long> ids) {

        for (Long id : ids) {
            receptionRepository.deleteById(id);        }
    }

    @Override
    public List<Reception> findAll() {
        return ReceptionMapper.toDtos(receptionRepository.findAll(), false);
    }

    @Override
    public List<Reception> findAll(int page, int size) {
        Sort sort = Sort.by(Sort.Direction.DESC, "updateDate");
        Pageable pageable = PageRequest.of(page, size, sort);
        return ReceptionMapper.toDtos(receptionRepository.findAll(pageable), false);
    }



}

