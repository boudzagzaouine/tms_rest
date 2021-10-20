package com.bagile.gmo.services.impl;

import com.bagile.gmo.dto.CommissionType;
import com.bagile.gmo.entities.GmoCommissionType;
import com.bagile.gmo.exceptions.AttributesNotFound;
import com.bagile.gmo.exceptions.ErrorType;
import com.bagile.gmo.exceptions.IdNotFound;
import com.bagile.gmo.mapper.CommissionTypeMapper;
import com.bagile.gmo.repositories.CommissionTypeRepository;
import com.bagile.gmo.services.CommissionTypeService;
import com.bagile.gmo.util.Search;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


@Service
public class CommissionTypeServiceImpl implements CommissionTypeService {
    
    private final CommissionTypeRepository commissionTypeRepository;
    public CommissionTypeServiceImpl(CommissionTypeRepository commissionTypeRepository) {
        this.commissionTypeRepository = commissionTypeRepository;
    }

    @Override
    public CommissionType save(CommissionType commissionType) {
        return CommissionTypeMapper.toDto(commissionTypeRepository.saveAndFlush(CommissionTypeMapper.toEntity(commissionType, false)), false);
    }

    @Override
    public Long size() {
        return commissionTypeRepository.count();
    }

    @Override
    public Boolean isExist(Long id) {
        return commissionTypeRepository.existsById(id);
    }

    @Override
    public CommissionType findById(Long id) throws IdNotFound {
        return CommissionTypeMapper.toDto(commissionTypeRepository.findById(id).orElseThrow(() -> new IdNotFound(id)), false);
    }

    @Override
    public List<CommissionType> find(String search) throws AttributesNotFound, ErrorType {
        if (search.equals("")){
            return findAll ();
        }
        return CommissionTypeMapper.toDtos(commissionTypeRepository.findAll(Search.expression(search, GmoCommissionType.class)), false);
    }

    @Override
    public List<CommissionType> find(String search, int page, int size) throws AttributesNotFound, ErrorType {
        if (search.equals("")){
            return findAll (page, size);
        }
        Sort sort = Sort.by(Sort.Direction.DESC, "updateDate");
        Pageable pageable = PageRequest.of(page, size, sort);
        return CommissionTypeMapper.toDtos(commissionTypeRepository.findAll(Search.expression(search, GmoCommissionType.class), pageable), false);
    }

    @Override
    public CommissionType findOne(String search) throws AttributesNotFound, ErrorType {
        return CommissionTypeMapper.toDto (commissionTypeRepository.findOne (Search.expression (search, GmoCommissionType.class)).orElseThrow (() -> new AttributesNotFound (search)), false);

    }

    @Override
    public Long size(String search) throws AttributesNotFound, ErrorType {
        if (search.equals("")){
            return size ();
        }
        return commissionTypeRepository.count(Search.expression(search, GmoCommissionType.class));
    }

    @Override
    public void delete(Long id) {
        commissionTypeRepository.deleteById(id);
    }

    @Override
    public void delete(CommissionType commissionType) {
        commissionTypeRepository.delete(CommissionTypeMapper.toEntity(commissionType, false));
    }

    @Override
    public void deleteAll(List<Long> ids) {

        for (Long id : ids) {
            commissionTypeRepository.deleteById(id);        }
    }


    @Override
    public List<CommissionType> findAll() {
        return CommissionTypeMapper.toDtos(commissionTypeRepository.findAll(), false);
    }

    @Override
    public List<CommissionType> findAll(int page, int size) {
        Sort sort = Sort.by(Sort.Direction.DESC, "updateDate");
        Pageable pageable = PageRequest.of(page, size, sort);
        return CommissionTypeMapper.toDtos(commissionTypeRepository.findAll(pageable), false);
    }



}

