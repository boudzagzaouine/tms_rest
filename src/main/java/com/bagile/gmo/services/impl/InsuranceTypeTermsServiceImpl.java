package com.bagile.gmo.services.impl;

import com.bagile.gmo.dto.InsuranceTypeTerms;
import com.bagile.gmo.entities.GmoInsuranceTypeTerms;
import com.bagile.gmo.exceptions.AttributesNotFound;
import com.bagile.gmo.exceptions.ErrorType;
import com.bagile.gmo.exceptions.IdNotFound;
import com.bagile.gmo.mapper.InsuranceTypeTermsMapper;
import com.bagile.gmo.repositories.InsuranceTypeTermsRepository;
import com.bagile.gmo.services.InsuranceTypeTermsService;
import com.bagile.gmo.util.Search;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


@Service
@Transactional
public class InsuranceTypeTermsServiceImpl implements InsuranceTypeTermsService {

    private final InsuranceTypeTermsRepository insuranceTypeTermsRepository;
    public InsuranceTypeTermsServiceImpl(InsuranceTypeTermsRepository insuranceTypeTermsRepository) {
        this.insuranceTypeTermsRepository = insuranceTypeTermsRepository;
    }

    @Override
    public InsuranceTypeTerms save(InsuranceTypeTerms insuranceTypeTerms) {
        return InsuranceTypeTermsMapper.toDto(insuranceTypeTermsRepository.saveAndFlush(InsuranceTypeTermsMapper.toEntity(insuranceTypeTerms, false)), false);
    }

    @Override
    public Long size() {
        return insuranceTypeTermsRepository.count();
    }

    @Override
    public Boolean isExist(Long id) {
        return insuranceTypeTermsRepository.existsById(id);
    }

    @Override
    public InsuranceTypeTerms findById(Long id) throws IdNotFound {
        return InsuranceTypeTermsMapper.toDto(insuranceTypeTermsRepository.findById(id).orElseThrow(() -> new IdNotFound(id)), false);

    }


    @Override
    public List<InsuranceTypeTerms> find(String search) throws AttributesNotFound, ErrorType {
        if (search.equals("")){
            return findAll ();
        }
        return InsuranceTypeTermsMapper.toDtos(insuranceTypeTermsRepository.findAll(Search.expression(search, GmoInsuranceTypeTerms.class)), false);
    }

    @Override
    public List<InsuranceTypeTerms> find(String search, int page, int size) throws AttributesNotFound, ErrorType {
        if (search.equals("")){
            return findAll (page, size);
        }
        Sort sort = Sort.by(Sort.Direction.DESC, "updateDate");
        Pageable pageable = PageRequest.of(page, size, sort);
        return InsuranceTypeTermsMapper.toDtos(insuranceTypeTermsRepository.findAll(Search.expression(search, GmoInsuranceTypeTerms.class), pageable), false);
    }

    @Override
    public InsuranceTypeTerms findOne(String search) throws AttributesNotFound, ErrorType {
        return InsuranceTypeTermsMapper.toDto (insuranceTypeTermsRepository.findOne (Search.expression (search, GmoInsuranceTypeTerms.class)).orElseThrow (() -> new AttributesNotFound (search)), false);

    }

    @Override
    public Long size(String search) throws AttributesNotFound, ErrorType {
        if (search.equals("")){
            return size ();
        }
        return insuranceTypeTermsRepository.count(Search.expression(search, GmoInsuranceTypeTerms.class));
    }

    @Override
    public void delete(Long id) {
        insuranceTypeTermsRepository.deleteById(id);
    }

    @Override
    public void delete(InsuranceTypeTerms insuranceTypeTerms) {
        insuranceTypeTermsRepository.delete(InsuranceTypeTermsMapper.toEntity(insuranceTypeTerms, false));
    }

    @Override
    public List<InsuranceTypeTerms> findAll() {
        return InsuranceTypeTermsMapper.toDtos(insuranceTypeTermsRepository.findAll(), false);
    }

    @Override
    public List<InsuranceTypeTerms> findAll(int page, int size) {
        Sort sort = Sort.by(Sort.Direction.DESC, "updateDate");
        Pageable pageable = PageRequest.of(page, size, sort);
        return InsuranceTypeTermsMapper.toDtos(insuranceTypeTermsRepository.findAll(pageable), false);
    }



}

