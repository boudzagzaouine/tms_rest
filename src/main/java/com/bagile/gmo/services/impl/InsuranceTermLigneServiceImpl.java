package com.bagile.gmo.services.impl;

import com.bagile.gmo.dto.InsuranceTermLigne;
import com.bagile.gmo.entities.GmoInsuranceTermLigne;
import com.bagile.gmo.exceptions.AttributesNotFound;
import com.bagile.gmo.exceptions.ErrorType;
import com.bagile.gmo.exceptions.IdNotFound;
import com.bagile.gmo.mapper.InsuranceTermLigneMapper;
import com.bagile.gmo.repositories.InsuranceTermLigneRepository;
import com.bagile.gmo.services.InsuranceTermLigneService;
import com.bagile.gmo.util.Search;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


@Service
@Transactional
public class InsuranceTermLigneServiceImpl implements InsuranceTermLigneService {

    private final InsuranceTermLigneRepository insuranceTermLigneRepository;
    public InsuranceTermLigneServiceImpl(InsuranceTermLigneRepository insuranceTermLigneRepository) {
        this.insuranceTermLigneRepository = insuranceTermLigneRepository;
    }

    @Override
    public InsuranceTermLigne save(InsuranceTermLigne insuranceTermInsurance) {
        return InsuranceTermLigneMapper.toDto(insuranceTermLigneRepository.saveAndFlush(InsuranceTermLigneMapper.toEntity(insuranceTermInsurance, false)), false);
    }

    @Override
    public Long size() {
        return insuranceTermLigneRepository.count();
    }

    @Override
    public Boolean isExist(Long id) {
        return insuranceTermLigneRepository.existsById(id);
    }

    @Override
    public InsuranceTermLigne findById(Long id) throws IdNotFound {
        return InsuranceTermLigneMapper.toDto(insuranceTermLigneRepository.findById(id).orElseThrow(() -> new IdNotFound(id)), false);

    }


    @Override
    public List<InsuranceTermLigne> find(String search) throws AttributesNotFound, ErrorType {
        if (search.equals("")){
            return findAll ();
        }
        return InsuranceTermLigneMapper.toDtos(insuranceTermLigneRepository.findAll(Search.expression(search, GmoInsuranceTermLigne.class)), false);
    }

    @Override
    public List<InsuranceTermLigne> find(String search, int page, int size) throws AttributesNotFound, ErrorType {
        if (search.equals("")){
            return findAll (page, size);
        }
        Sort sort = Sort.by(Sort.Direction.DESC, "updateDate");
        Pageable pageable = PageRequest.of(page, size, sort);
        return InsuranceTermLigneMapper.toDtos(insuranceTermLigneRepository.findAll(Search.expression(search, GmoInsuranceTermLigne.class), pageable), false);
    }

    @Override
    public InsuranceTermLigne findOne(String search) throws AttributesNotFound, ErrorType {
        return InsuranceTermLigneMapper.toDto (insuranceTermLigneRepository.findOne (Search.expression (search, GmoInsuranceTermLigne.class)).orElseThrow (() -> new AttributesNotFound (search)), false);

    }

    @Override
    public Long size(String search) throws AttributesNotFound, ErrorType {
        if (search.equals("")){
            return size ();
        }
        return insuranceTermLigneRepository.count(Search.expression(search, GmoInsuranceTermLigne.class));
    }

    @Override
    public void delete(Long id) {
        insuranceTermLigneRepository.deleteById(id);
    }

    @Override
    public void delete(InsuranceTermLigne insuranceTermInsurance) {
        insuranceTermLigneRepository.delete(InsuranceTermLigneMapper.toEntity(insuranceTermInsurance, false));
    }
    @Override
    public void deleteAll(List<Long> ids) {

        for (Long id : ids) {
            insuranceTermLigneRepository.deleteById(id);        }
    }

    @Override
    public List<InsuranceTermLigne> findAll() {
        return InsuranceTermLigneMapper.toDtos(insuranceTermLigneRepository.findAll(), false);
    }

    @Override
    public List<InsuranceTermLigne> findAll(int page, int size) {
        Sort sort = Sort.by(Sort.Direction.DESC, "updateDate");
        Pageable pageable = PageRequest.of(page, size, sort);
        return InsuranceTermLigneMapper.toDtos(insuranceTermLigneRepository.findAll(pageable), false);
    }



}

