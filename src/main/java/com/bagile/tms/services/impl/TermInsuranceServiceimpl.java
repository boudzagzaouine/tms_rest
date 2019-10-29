package com.bagile.tms.services.impl;

import com.bagile.tms.dto.TermInsurance;
import com.bagile.tms.entities.TmsTermInsurance;
import com.bagile.tms.exceptions.AttributesNotFound;
import com.bagile.tms.exceptions.ErrorType;
import com.bagile.tms.exceptions.IdNotFound;
import com.bagile.tms.mapper.TermInsuranceMapper;
import com.bagile.tms.repositories.TermInsuranceRepository;
import com.bagile.tms.services.TermInsuranceService;
import com.bagile.tms.util.Search;
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
    public TermInsurance save(TermInsurance termInsurance) {
        LOGGER.info("save Term Insurance");


        return TermInsuranceMapper.toDto(termInsuranceRepository.saveAndFlush(TermInsuranceMapper.toEntity(termInsurance, false)), false);

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
    public TermInsurance findById(Long id) throws IdNotFound {
        TermInsurance contractType = TermInsuranceMapper.toDto(termInsuranceRepository.findById(id).get(), false);
        if (null != contractType) {
            return contractType;
        } else {
            throw new IdNotFound(id);
        }
    }

    @Override
    public List<TermInsurance> find(String search) throws AttributesNotFound, ErrorType {
        return TermInsuranceMapper.toDtos(termInsuranceRepository.findAll(Search.expression(search, TmsTermInsurance.class)), false);
    }

    @Override
    public List<TermInsurance> find(String search, Pageable pageable) throws AttributesNotFound, ErrorType {
        return TermInsuranceMapper.toDtos(termInsuranceRepository.findAll(Search.expression(search, TmsTermInsurance.class), pageable), false);
    }

    @Override
    public TermInsurance findOne(String search) throws AttributesNotFound, ErrorType {
        return TermInsuranceMapper.toDto(termInsuranceRepository.findOne(Search.expression(search, TmsTermInsurance.class)).get(), false);
    }

    @Override
    public Long size(String search) throws AttributesNotFound, ErrorType {
        return termInsuranceRepository.count(Search.expression(search, TmsTermInsurance.class));
    }

    @Override
    public void delete(Long id) {
        LOGGER.info("delete Term Insurance");
        termInsuranceRepository.deleteById(id);
    }

    @Override
    public void delete(TermInsurance termInsurance) {
        LOGGER.info("delete Term Insurance");
        termInsuranceRepository.delete(TermInsuranceMapper.toEntity(termInsurance, false));

    }

    @Override
    public List<TermInsurance> findAll() throws AttributesNotFound, ErrorType {
        return TermInsuranceMapper.toDtos(termInsuranceRepository.findAll(), false);
    }

    @Override
    public List<TermInsurance> findAll(Pageable pageable) throws AttributesNotFound, ErrorType {
        return TermInsuranceMapper.toDtos(termInsuranceRepository.findAll(pageable), false);
    }
}
