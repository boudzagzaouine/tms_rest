package com.bagile.gmo.services.impl;

import com.bagile.gmo.dto.InsuranceType;
import com.bagile.gmo.entities.GmoInsuranceType;
import com.bagile.gmo.exceptions.AttributesNotFound;
import com.bagile.gmo.exceptions.ErrorType;
import com.bagile.gmo.exceptions.IdNotFound;
import com.bagile.gmo.mapper.InsuranceTypeMapper;
import com.bagile.gmo.repositories.InsuranceTypeRepository;
import com.bagile.gmo.services.InsuranceTypeService;
import com.bagile.gmo.util.Search;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


@Service
public class InsuranceTypeServiceImpl implements InsuranceTypeService {

    private final InsuranceTypeRepository insuranceTypeRepository;
    public InsuranceTypeServiceImpl(InsuranceTypeRepository insuranceTypeRepository) {
        this.insuranceTypeRepository = insuranceTypeRepository;
    }

    @Override
    public InsuranceType save(InsuranceType insuranceType) {
        return InsuranceTypeMapper.toDto(insuranceTypeRepository.saveAndFlush(InsuranceTypeMapper.toEntity(insuranceType, false)), false);
    }

    @Override
    public Long size() {
        return insuranceTypeRepository.count();
    }

    @Override
    public Boolean isExist(Long id) {
        return insuranceTypeRepository.existsById(id);
    }

    @Override
    public InsuranceType findById(Long id) throws IdNotFound {
        return InsuranceTypeMapper.toDto(insuranceTypeRepository.findById(id).orElseThrow(() -> new IdNotFound(id)), false);
    }

    @Override
    public List<InsuranceType> find(String search) throws AttributesNotFound, ErrorType {
       /* if (search.equals("")){
            return findAll ();
        }*/
        return InsuranceTypeMapper.toDtos(insuranceTypeRepository.findAll(Search.expression(search, GmoInsuranceType.class)), false);
    }

    @Override
    public List<InsuranceType> find(String search, int page, int size) throws AttributesNotFound, ErrorType {
        if (search.equals("")){
            return findAll (page, size);
        }
        Sort sort = Sort.by(Sort.Direction.DESC, "updateDate");
        Pageable pageable = PageRequest.of(page, size, sort);
        return InsuranceTypeMapper.toDtos(insuranceTypeRepository.findAll(Search.expression(search, GmoInsuranceType.class), pageable), false);
    }

    @Override
    public InsuranceType findOne(String search) throws AttributesNotFound, ErrorType {
        return InsuranceTypeMapper.toDto (insuranceTypeRepository.findOne (Search.expression (search, GmoInsuranceType.class)).orElseThrow (() -> new AttributesNotFound (search)), false);

    }

    @Override
    public Long size(String search) throws AttributesNotFound, ErrorType {
        if (search.equals("")){
            return size ();
        }
        return insuranceTypeRepository.count(Search.expression(search, GmoInsuranceType.class));
    }

    @Override
    public void delete(Long id) {
        insuranceTypeRepository.deleteById(id);
    }

    @Override
    public void delete(InsuranceType insuranceType) {
        insuranceTypeRepository.delete(InsuranceTypeMapper.toEntity(insuranceType, false));
    }
    @Override
    public void deleteAll(List<Long> ids) {

        for (Long id : ids) {
            insuranceTypeRepository.deleteById(id);        }
    }

    @Override
    public List<InsuranceType> findAll() {
        return InsuranceTypeMapper.toDtos(insuranceTypeRepository.findAll(), false);
    }

    @Override
    public List<InsuranceType> findAll(int page, int size) {
        Sort sort = Sort.by(Sort.Direction.DESC, "updateDate");
        Pageable pageable = PageRequest.of(page, size, sort);
        return InsuranceTypeMapper.toDtos(insuranceTypeRepository.findAll(pageable), false);
    }



}

