package com.bagile.tms.services.impl;

import com.bagile.tms.dto.InsuranceTermsVehicle;
import com.bagile.tms.entities.TmsBadgeTypeDriver;
import com.bagile.tms.exceptions.AttributesNotFound;
import com.bagile.tms.exceptions.ErrorType;
import com.bagile.tms.exceptions.IdNotFound;
import com.bagile.tms.mapper.InsuranceTermsVehicleMapper;
import com.bagile.tms.repositories.InsuranceTermsVehicleRepository;
import com.bagile.tms.services.BadgeTypeDriverService;
import com.bagile.tms.services.InsuranceTermsVehicleService;
import com.bagile.tms.util.Search;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


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
        return InsuranceTermsVehicleMapper.toDtos(insuranceTermsVehicleRepository.findAll(Search.expression(search, TmsBadgeTypeDriver.class)), false);
    }

    @Override
    public List<InsuranceTermsVehicle> find(String search, int page, int size) throws AttributesNotFound, ErrorType {
        if (search.equals("")){
            return findAll (page, size);
        }
        Sort sort = Sort.by(Sort.Direction.DESC, "updateDate");
        Pageable pageable = PageRequest.of(page, size, sort);
        return InsuranceTermsVehicleMapper.toDtos(insuranceTermsVehicleRepository.findAll(Search.expression(search, TmsBadgeTypeDriver.class), pageable), false);
    }

    @Override
    public InsuranceTermsVehicle findOne(String search) throws AttributesNotFound, ErrorType {
        return InsuranceTermsVehicleMapper.toDto (insuranceTermsVehicleRepository.findOne (Search.expression (search, TmsBadgeTypeDriver.class)).orElseThrow (() -> new AttributesNotFound (search)), false);

    }

    @Override
    public Long size(String search) throws AttributesNotFound, ErrorType {
        if (search.equals("")){
            return size ();
        }
        return insuranceTermsVehicleRepository.count(Search.expression(search, TmsBadgeTypeDriver.class));
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

