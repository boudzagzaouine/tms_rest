package com.bagile.gmo.services.impl;

import java.util.List;

import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.bagile.gmo.dto.InsuranceTermsVehicle;
import com.bagile.gmo.entities.GmoBadgeTypeDriver;
import com.bagile.gmo.mapper.InsuranceTermsVehicleMapper;
import com.bagile.gmo.exceptions.AttributesNotFound;
import com.bagile.gmo.exceptions.ErrorType;
import com.bagile.gmo.exceptions.IdNotFound;
import com.bagile.gmo.repositories.InsuranceTermsVehicleRepository;
import com.bagile.gmo.services.InsuranceTermsVehicleService;
import com.bagile.gmo.util.Search;


@Service
@Transactional
public class InsuranceTermsVehicleServiceImpl implements InsuranceTermsVehicleService {

    private final InsuranceTermsVehicleRepository insuranceTermsVehicleRepository;
    public InsuranceTermsVehicleServiceImpl(InsuranceTermsVehicleRepository insuranceTermsVehicleRepository) {
        this.insuranceTermsVehicleRepository = insuranceTermsVehicleRepository;
    }

    @Override
    public InsuranceTermsVehicle save(InsuranceTermsVehicle insuranceTermsVehicle) {
        return InsuranceTermsVehicleMapper.toDto(insuranceTermsVehicleRepository.saveAndFlush(InsuranceTermsVehicleMapper.toEntity(insuranceTermsVehicle, false)), false);
    }

    @Override
    public Long size() {
        return insuranceTermsVehicleRepository.count();
    }

    @Override
    public Boolean isExist(Long id) {
        return insuranceTermsVehicleRepository.existsById(id);
    }

    @Override
    public InsuranceTermsVehicle findById(Long id) throws IdNotFound {
        return InsuranceTermsVehicleMapper.toDto(insuranceTermsVehicleRepository.findById(id).orElseThrow(() -> new IdNotFound(id)), false);
    }

    @Override
    public List<InsuranceTermsVehicle> find(String search) throws AttributesNotFound, ErrorType {
        if (search.equals("")){
            return findAll ();
        }
        return InsuranceTermsVehicleMapper.toDtos(insuranceTermsVehicleRepository.findAll(Search.expression(search, GmoBadgeTypeDriver.class)), false);
    }

    @Override
    public List<InsuranceTermsVehicle> find(String search, int page, int size) throws AttributesNotFound, ErrorType {
        if (search.equals("")){
            return findAll (page, size);
        }
        Sort sort = Sort.by(Sort.Direction.DESC, "updateDate");
        Pageable pageable = PageRequest.of(page, size, sort);
        return InsuranceTermsVehicleMapper.toDtos(insuranceTermsVehicleRepository.findAll(Search.expression(search, GmoBadgeTypeDriver.class), pageable), false);
    }

    @Override
    public InsuranceTermsVehicle findOne(String search) throws AttributesNotFound, ErrorType {
        return InsuranceTermsVehicleMapper.toDto (insuranceTermsVehicleRepository.findOne (Search.expression (search, GmoBadgeTypeDriver.class)).orElseThrow (() -> new AttributesNotFound (search)), false);

    }

    @Override
    public Long size(String search) throws AttributesNotFound, ErrorType {
        if (search.equals("")){
            return size ();
        }
        return insuranceTermsVehicleRepository.count(Search.expression(search, GmoBadgeTypeDriver.class));
    }

    @Override
    public void delete(Long id) {
        insuranceTermsVehicleRepository.deleteById(id);
    }

    @Override
    public void delete(InsuranceTermsVehicle insuranceTermsVehicle) {
        insuranceTermsVehicleRepository.delete(InsuranceTermsVehicleMapper.toEntity(insuranceTermsVehicle, false));
    }

    @Override
    public List<InsuranceTermsVehicle> findAll() {
        return InsuranceTermsVehicleMapper.toDtos(insuranceTermsVehicleRepository.findAll(), false);
    }

    @Override
    public List<InsuranceTermsVehicle> findAll(int page, int size) {
        Sort sort = Sort.by(Sort.Direction.DESC, "updateDate");
        Pageable pageable = PageRequest.of(page, size, sort);
        return InsuranceTermsVehicleMapper.toDtos(insuranceTermsVehicleRepository.findAll(pageable), false);
    }



}

