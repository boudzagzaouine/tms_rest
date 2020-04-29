package com.bagile.tms.services.impl;

import com.bagile.tms.dto.CommissionType;
import com.bagile.tms.entities.TmsCommissionType;
import com.bagile.tms.exceptions.AttributesNotFound;
import com.bagile.tms.exceptions.ErrorType;
import com.bagile.tms.exceptions.IdNotFound;
import com.bagile.tms.mapper.CommissionTypeMapper;
import com.bagile.tms.repositories.CommissionTypeRepository;
import com.bagile.tms.services.CommissionTypeService;
import com.bagile.tms.util.Search;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


@Service
@Transactional
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
        return CommissionTypeMapper.toDtos(commissionTypeRepository.findAll(Search.expression(search, TmsCommissionType.class)), false);
    }

    @Override
    public List<CommissionType> find(String search, int page, int size) throws AttributesNotFound, ErrorType {
        if (search.equals("")){
            return findAll (page, size);
        }
        Sort sort = Sort.by(Sort.Direction.DESC, "updateDate");
        Pageable pageable = PageRequest.of(page, size, sort);
        return CommissionTypeMapper.toDtos(commissionTypeRepository.findAll(Search.expression(search, TmsCommissionType.class), pageable), false);
    }

    @Override
    public CommissionType findOne(String search) throws AttributesNotFound, ErrorType {
        return CommissionTypeMapper.toDto (commissionTypeRepository.findOne (Search.expression (search, TmsCommissionType.class)).orElseThrow (() -> new AttributesNotFound (search)), false);

    }

    @Override
    public Long size(String search) throws AttributesNotFound, ErrorType {
        if (search.equals("")){
            return size ();
        }
        return commissionTypeRepository.count(Search.expression(search, TmsCommissionType.class));
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

