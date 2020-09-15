package com.bagile.gmo.services.impl;

import com.bagile.gmo.dto.Insurance;
import com.bagile.gmo.entities.GmoInsurance;
import com.bagile.gmo.exceptions.AttributesNotFound;
import com.bagile.gmo.exceptions.ErrorType;
import com.bagile.gmo.exceptions.IdNotFound;
import com.bagile.gmo.mapper.InsuranceMapper;
import com.bagile.gmo.repositories.InsuranceRepository;
import com.bagile.gmo.services.InsuranceService;
import com.bagile.gmo.util.Search;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
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
        return InsuranceMapper.toDto(insuranceRepository.findById(id).orElseThrow(() -> new IdNotFound(id)), false);
       }

    @Override
    public List<Insurance> find(String search) throws AttributesNotFound, ErrorType {
        if (search.equals("")){
            return findAll ();
        }
        return InsuranceMapper.toDtos(insuranceRepository.findAll(Search.expression(search, GmoInsurance.class)), false);
    }

    @Override
    public List<Insurance> find(String search, int page,int size) throws AttributesNotFound, ErrorType {
        if (search.equals("")){
            return findAll (page, size);
        }
        Sort sort = Sort.by(Sort.Direction.DESC, "updateDate");
        Pageable pageable = PageRequest.of(page, size, sort);
        return InsuranceMapper.toDtos(insuranceRepository.findAll(Search.expression(search, GmoInsurance.class), pageable), false);
    }

    @Override
    public Insurance findOne(String search) throws AttributesNotFound, ErrorType {
        return InsuranceMapper.toDto(insuranceRepository.findOne(Search.expression(search, GmoInsurance.class)).get(), false);
    }

    @Override
    public Long size(String search) throws AttributesNotFound, ErrorType {
        if (search.equals("")){
            return size();
        }
        return insuranceRepository.count(Search.expression(search, GmoInsurance.class));
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
    public void deleteAll(List<Long> ids) {

        for (Long id : ids) {
            insuranceRepository.deleteById(id);        }
    }
    @Override
    public List<Insurance> findAll() throws AttributesNotFound, ErrorType {
        return InsuranceMapper.toDtos(insuranceRepository.findAll(), false);
    }

    @Override
    public List<Insurance> findAll(int page, int size) throws AttributesNotFound, ErrorType {
        Sort sort = Sort.by(Sort.Direction.DESC, "updateDate");
        Pageable pageable = PageRequest.of(page, size, sort);
        return InsuranceMapper.toDtos(insuranceRepository.findAll(pageable), false);
    }

    @Override
    public Insurance findByPatrimony(Long idVehicle) {
        return InsuranceMapper.toDto(insuranceRepository.findByPatrimony(idVehicle),false);
    }


  /*  @Override
    public List<Insurance> findAvailableInsurances() {
        return  InsuranceMapper.toDtos(insuranceRepository.findByGmoVehicleIsNull (), true);
    }*/
}
