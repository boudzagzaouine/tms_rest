package com.bagile.tms.services.impl;

import com.bagile.gmo.dto.CommissionDriver;
import com.bagile.gmo.entities.TmsCommissionDriver;
import com.bagile.gmo.mapper.CommissionDriverMapper;
import com.bagile.tms.exceptions.AttributesNotFound;
import com.bagile.tms.exceptions.ErrorType;
import com.bagile.tms.exceptions.IdNotFound;
import com.bagile.tms.repositories.CommissionDriverRepository;
import com.bagile.tms.services.CommissionDriverService;
import com.bagile.tms.util.Search;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


@Service
@Transactional
public class CommissionDriverServiceImpl implements CommissionDriverService {
    
    private final CommissionDriverRepository commissionRepository;
    public CommissionDriverServiceImpl(CommissionDriverRepository commissionRepository) {
        this.commissionRepository = commissionRepository;
    }

    @Override
    public CommissionDriver save(CommissionDriver commission) {
        return CommissionDriverMapper.toDto(commissionRepository.saveAndFlush(CommissionDriverMapper.toEntity(commission, false)), false);
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
    public CommissionDriver findById(Long id) throws IdNotFound {
        return CommissionDriverMapper.toDto(commissionRepository.findById(id).orElseThrow(() -> new IdNotFound(id)), false);
    }

    @Override
    public List<CommissionDriver> find(String search) throws AttributesNotFound, ErrorType {
        if (search.equals("")){
            return findAll ();
        }
        return CommissionDriverMapper.toDtos(commissionRepository.findAll(Search.expression(search, TmsCommissionDriver.class)), false);
    }

    @Override
    public List<CommissionDriver> find(String search, int page, int size) throws AttributesNotFound, ErrorType {
        if (search.equals("")){
            return findAll (page, size);
        }
        Sort sort = Sort.by(Sort.Direction.DESC, "updateDate");
        Pageable pageable = PageRequest.of(page, size, sort);
        return CommissionDriverMapper.toDtos(commissionRepository.findAll(Search.expression(search, TmsCommissionDriver.class), pageable), false);
    }

    @Override
    public CommissionDriver findOne(String search) throws AttributesNotFound, ErrorType {
        return CommissionDriverMapper.toDto (commissionRepository.findOne (Search.expression (search, TmsCommissionDriver.class)).orElseThrow (() -> new AttributesNotFound (search)), false);

    }

    @Override
    public Long size(String search) throws AttributesNotFound, ErrorType {
        if (search.equals("")){
            return size ();
        }
        return commissionRepository.count(Search.expression(search, TmsCommissionDriver.class));
    }

    @Override
    public void delete(Long id) {
        commissionRepository.deleteById(id);
    }

    @Override
    public void delete(CommissionDriver commission) {
        commissionRepository.delete(CommissionDriverMapper.toEntity(commission, false));
    }

    @Override
    public void deleteAll(List<Long> ids) {

        for (Long id : ids) {
            commissionRepository.deleteById(id);        }
    }


    @Override
    public List<CommissionDriver> findAll() {
        return CommissionDriverMapper.toDtos(commissionRepository.findAll(), false);
    }

    @Override
    public List<CommissionDriver> findAll(int page, int size) {
        Sort sort = Sort.by(Sort.Direction.DESC, "updateDate");
        Pageable pageable = PageRequest.of(page, size, sort);
        return CommissionDriverMapper.toDtos(commissionRepository.findAll(pageable), false);
    }



}

