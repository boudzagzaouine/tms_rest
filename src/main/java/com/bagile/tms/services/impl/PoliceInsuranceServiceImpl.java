package com.bagile.tms.services.impl;

import com.bagile.tms.dto.PoliceAssurance;
import com.bagile.tms.exceptions.AttributesNotFound;
import com.bagile.tms.exceptions.ErrorType;
import com.bagile.tms.exceptions.IdNotFound;
import com.bagile.tms.mapper.PoliceInsuranceMapper;
import com.bagile.tms.repositories.PoliceInsuranceRepository;
import com.bagile.tms.services.PoliceInsuranceService;
import com.bagile.tms.util.Search;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by bouzi on 4/3/2017.
 */
@Service
public class PoliceInsuranceServiceImpl implements PoliceInsuranceService {
    @Autowired
    private PoliceInsuranceRepository policeInsuranceRepository;
    private final static Logger LOGGER = LoggerFactory.getLogger(PoliceInsuranceService.class);

    @Override
    public PoliceAssurance save(PoliceAssurance policeAssurance){
        LOGGER.info("save PoliceAssurance");
        return PoliceInsuranceMapper.toDto(policeInsuranceRepository.saveAndFlush(PoliceInsuranceMapper.toEntity(policeAssurance,false)),false);
    }

    @Override
    public Long size(){
        return policeInsuranceRepository.count();
    }
    @Override
    public Boolean isExist(Long id){
        return policeInsuranceRepository.existsById(id);
    }
    @Override
    public PoliceAssurance findById(Long id)throws IdNotFound {
        PoliceAssurance policeAssurance = PoliceInsuranceMapper.toDto(policeInsuranceRepository.findById(id).get(),false);
        if(null != policeAssurance){
            return policeAssurance;
        }else {
            throw new IdNotFound(id);
        }
    }
    @Override
    public List<PoliceAssurance> find(String search)throws AttributesNotFound,ErrorType {
        return PoliceInsuranceMapper.toDtos(policeInsuranceRepository.findAll(Search.expression(search,TmsPoliceInsurance.class)), false);
    }
    @Override
    public List<PoliceAssurance>find(String search, Pageable pageable)throws AttributesNotFound,ErrorType {
        return PoliceInsuranceMapper.toDtos(policeInsuranceRepository.findAll(Search.expression(search,TmsPoliceInsurance.class),pageable),false);
    }
    @Override
    public Long size(String search)throws AttributesNotFound,ErrorType {
        return policeInsuranceRepository.count(Search.expression(search , TmsPoliceInsurance.class));
    }
    @Override
    public void delete(Long id){
        LOGGER.info("save PoliceAssurance");
        policeInsuranceRepository.deleteById(id);
    }
    @Override
    public void delete(PoliceAssurance policeAssurance){
        LOGGER.info("delete PoliceAssurance");
        policeInsuranceRepository.delete(PoliceInsuranceMapper.toEntity(policeAssurance,false));
    }
    @Override
    public List<PoliceAssurance>findAll(){
        return PoliceInsuranceMapper.toDtos(policeInsuranceRepository.findAll(),false);

    }
    @Override
    public List<PoliceAssurance> findAll(Pageable pageable){
        return PoliceInsuranceMapper.toDtos(policeInsuranceRepository.findAll(pageable),false);
    }
}
