package com.bagile.tms.services.impl;

import com.bagile.tms.dto.Commission;
import com.bagile.tms.entities.PrmContact;
import com.bagile.tms.entities.TmsCommission;
import com.bagile.tms.exceptions.AttributesNotFound;
import com.bagile.tms.exceptions.ErrorType;
import com.bagile.tms.exceptions.IdNotFound;
import com.bagile.tms.mapper.CommissionMapper;
import com.bagile.tms.mapper.ContactMapper;
import com.bagile.tms.repositories.CommissionRepository;
import com.bagile.tms.services.CommissionService;
import com.bagile.tms.util.Search;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


@Service
@Transactional
public class CommissionServiceImpl implements CommissionService {
    
    private final CommissionRepository commissionRepository;
    public CommissionServiceImpl(CommissionRepository commissionRepository) {
        this.commissionRepository = commissionRepository;
    }

    @Override
    public Commission save(Commission commission) {
        return CommissionMapper.toDto(commissionRepository.saveAndFlush(CommissionMapper.toEntity(commission, false)), false);
    }

    @Override
    public Long size() {
        return commissionRepository.count();
    }

    @Override
    public Boolean isExist(Long id) {
        return commissionRepository.existsById(id);
    }

    @Override
    public Commission findById(Long id) throws IdNotFound {
        return CommissionMapper.toDto(commissionRepository.findById(id).orElseThrow(() -> new IdNotFound(id)), false);
    }

    @Override
    public List<Commission> find(String search) throws AttributesNotFound, ErrorType {
        if (search.equals("")){
            return findAll ();
        }
        return CommissionMapper.toDtos(commissionRepository.findAll(Search.expression(search, TmsCommission.class)), false);
    }

    @Override
    public List<Commission> find(String search, int page, int size) throws AttributesNotFound, ErrorType {
        if (search.equals("")){
            return findAll (page, size);
        }
        Sort sort = Sort.by(Sort.Direction.DESC, "updateDate");
        Pageable pageable = PageRequest.of(page, size, sort);
        return CommissionMapper.toDtos(commissionRepository.findAll(Search.expression(search, TmsCommission.class), pageable), false);
    }

    @Override
    public Commission findOne(String search) throws AttributesNotFound, ErrorType {
        return CommissionMapper.toDto (commissionRepository.findOne (Search.expression (search, TmsCommission.class)).orElseThrow (() -> new AttributesNotFound (search)), false);

    }

    @Override
    public Long size(String search) throws AttributesNotFound, ErrorType {
        if (search.equals("")){
            return size ();
        }
        return commissionRepository.count(Search.expression(search, TmsCommission.class));
    }

    @Override
    public void delete(Long id) {
        commissionRepository.deleteById(id);
    }

    @Override
    public void delete(Commission commission) {
        commissionRepository.delete(CommissionMapper.toEntity(commission, false));
    }

    @Override
    public List<Commission> findAll() {
        return CommissionMapper.toDtos(commissionRepository.findAll(), false);
    }

    @Override
    public List<Commission> findAll(int page, int size) {
        Sort sort = Sort.by(Sort.Direction.DESC, "updateDate");
        Pageable pageable = PageRequest.of(page, size, sort);
        return CommissionMapper.toDtos(commissionRepository.findAll(pageable), false);
    }



}

