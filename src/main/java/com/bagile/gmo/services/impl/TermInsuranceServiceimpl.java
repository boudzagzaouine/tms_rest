package com.bagile.gmo.services.impl;

import com.bagile.gmo.dto.InsuranceTerm;
import com.bagile.gmo.entities.GmoInsuranceTerm;
import com.bagile.gmo.exceptions.AttributesNotFound;
import com.bagile.gmo.exceptions.ErrorType;
import com.bagile.gmo.exceptions.IdNotFound;
import com.bagile.gmo.mapper.InsuranceTermMapper;
import com.bagile.gmo.repositories.TermInsuranceRepository;
import com.bagile.gmo.services.TermInsuranceService;
import com.bagile.gmo.util.Search;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class TermInsuranceServiceimpl implements TermInsuranceService {


    @Autowired
    private TermInsuranceRepository termInsuranceRepository;
    private final static Logger LOGGER = LoggerFactory
            .getLogger(TermInsuranceService.class);


    @Override
    public InsuranceTerm save(InsuranceTerm insuranceTerm) {
        LOGGER.info("save Term Insurance");


        return InsuranceTermMapper.toDto(termInsuranceRepository.saveAndFlush(InsuranceTermMapper.toEntity(insuranceTerm, false)), false);

    }

    @Override
    public Long size() {
        return termInsuranceRepository.count();
    }

    @Override
    public Boolean isExist(Long id) {
        return termInsuranceRepository.existsById(id);

    }

    @Override
    public InsuranceTerm findById(Long id) throws IdNotFound {
        InsuranceTerm contractType = InsuranceTermMapper.toDto(termInsuranceRepository.findById(id).get(), false);
        if (null != contractType) {
            return contractType;
        } else {
            throw new IdNotFound(id);
        }
    }

    @Override
    public List<InsuranceTerm> find(String search) throws AttributesNotFound, ErrorType {
        if (search.equals("")){
            return findAll ();
        }
        return InsuranceTermMapper.toDtos(termInsuranceRepository.findAll
                (Search.expression(search, GmoInsuranceTerm.class)), false);
    }

    @Override
    public List<InsuranceTerm> find(String search, Pageable pageable) throws AttributesNotFound, ErrorType {
        if (search.equals("")){
            return findAll (pageable);
        }
        return InsuranceTermMapper.toDtos(termInsuranceRepository.findAll(Search.expression(search, GmoInsuranceTerm.class), pageable), false);
    }

    @Override
    public InsuranceTerm findOne(String search) throws AttributesNotFound, ErrorType {
        return InsuranceTermMapper.toDto(termInsuranceRepository.findOne(Search.expression(search, GmoInsuranceTerm.class)).get(), false);
    }

    @Override
    public Long size(String search) throws AttributesNotFound, ErrorType {
        if (search.equals("")){
            return size ();
        }
        return termInsuranceRepository.count(Search.expression(search, GmoInsuranceTerm.class));
    }

    @Override
    public void delete(Long id) {
        LOGGER.info("delete Term Insurance");
        termInsuranceRepository.deleteById(id);
    }

    @Override
    public void delete(InsuranceTerm insuranceTerm) {
        LOGGER.info("delete Term Insurance");
        termInsuranceRepository.delete(InsuranceTermMapper.toEntity(insuranceTerm, false));

    }

    @Override
    public void deleteAll(List<Long> ids) {
        LOGGER.info("delete Term Insurance");
        for (Long id : ids) {
            termInsuranceRepository.deleteById(id);        }
    }


    @Override
    public List<InsuranceTerm> findAll() throws AttributesNotFound, ErrorType {
        return InsuranceTermMapper.toDtos(termInsuranceRepository.findAll(), false);
    }

    @Override
    public List<InsuranceTerm> findAll(Pageable pageable) throws AttributesNotFound, ErrorType {
        return InsuranceTermMapper.toDtos(termInsuranceRepository.findAll(pageable), false);
    }
}
