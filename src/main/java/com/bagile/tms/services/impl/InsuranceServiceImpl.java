package com.bagile.tms.services.impl;

import com.bagile.tms.dto.Insurance;
import com.bagile.tms.entities.TmsInsurance;
import com.bagile.tms.exceptions.AttributesNotFound;
import com.bagile.tms.exceptions.ErrorType;
import com.bagile.tms.exceptions.IdNotFound;
import com.bagile.tms.mapper.InsuranceMapper;
import com.bagile.tms.repositories.InsuranceRepository;
import com.bagile.tms.services.InsuranceService;
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
public class InsuranceServiceImpl implements InsuranceService {

    @Autowired
    private InsuranceRepository insuranceRepository;
    private final static Logger LOGGER = LoggerFactory
            .getLogger(InsuranceService.class);


    @Override
    public Insurance save(Insurance insurance) {
        LOGGER.info("save Insurance");


        return InsuranceMapper.toDto(insuranceRepository.saveAndFlush(InsuranceMapper.toEntity(insurance, false)), false);

    }

    @Override
    public Long size() {
        return insuranceRepository.count();
    }

    @Override
    public Boolean isExist(Long id) {
        return insuranceRepository.existsById(id);
    }

    @Override
    public Insurance findById(Long id) throws IdNotFound {
        Insurance contractType = InsuranceMapper.toDto(insuranceRepository.findById(id).get(), false);
        if (null != contractType) {
            return contractType;
        } else {
            throw new IdNotFound(id);
        }    }

    @Override
    public List<Insurance> find(String search) throws AttributesNotFound, ErrorType {
        return InsuranceMapper.toDtos(insuranceRepository.findAll(Search.expression(search, TmsInsurance.class)), false);
    }

    @Override
    public List<Insurance> find(String search, Pageable pageable) throws AttributesNotFound, ErrorType {
        return InsuranceMapper.toDtos(insuranceRepository.findAll(Search.expression(search, TmsInsurance.class), pageable), false);
    }

    @Override
    public Insurance findOne(String search) throws AttributesNotFound, ErrorType {
        return InsuranceMapper.toDto(insuranceRepository.findOne(Search.expression(search, TmsInsurance.class)).get(), false);
    }

    @Override
    public Long size(String search) throws AttributesNotFound, ErrorType {
        return insuranceRepository.count(Search.expression(search, TmsInsurance.class));
    }

    @Override
    public void delete(Long id) {
        LOGGER.info("delete Insurance");
        insuranceRepository.deleteById(id);
    }

    @Override
    public void delete(Insurance insurance) {
        LOGGER.info("delete Insurance");
        insuranceRepository.delete(InsuranceMapper.toEntity(insurance, false));

    }

    @Override
    public List<Insurance> findAll() throws AttributesNotFound, ErrorType {
        return InsuranceMapper.toDtos(insuranceRepository.findAll(), false);
    }

    @Override
    public List<Insurance> findAll(Pageable pageable) throws AttributesNotFound, ErrorType {
        return InsuranceMapper.toDtos(insuranceRepository.findAll(pageable), false);
    }
}
