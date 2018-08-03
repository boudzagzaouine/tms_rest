package com.bagile.tms.services.impl;


import com.bagile.tms.exceptions.AttributesNotFound;
import com.bagile.tms.exceptions.ErrorType;
import com.bagile.tms.exceptions.IdNotFound;
import com.bagile.tms.mapper.NatureIncidentMapper;
import com.bagile.tms.repositories.NatureIncidentRepository;
import com.bagile.tms.services.NatureIncidentService;
import com.bagile.tms.util.Search;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by bouzi on 4/3/2017.
 */
@Service
public class NatureIncidentServiceImpl implements NatureIncidentService {
    @Autowired
    private NatureIncidentRepository natureIncidentRepository;
    private final static org.slf4j.Logger LOGGER = LoggerFactory.getLogger(NatureIncidentService.class);

    @Override
    public NatureIncident save(NatureIncident natureIncident){
        LOGGER.info("save NatureIncident");
        return NatureIncidentMapper.toDto(natureIncidentRepository.saveAndFlush(NatureIncidentMapper.toEntity(natureIncident,false)),false);
    }
    @Override
    public Long size(){
        return natureIncidentRepository.count();
    }
    @Override
    public Boolean isExist(Long id){
        return natureIncidentRepository.existsById(id);
    }
    @Override
    public NatureIncident findById(Long id)throws IdNotFound {
        NatureIncident natureIncident = NatureIncidentMapper.toDto(natureIncidentRepository.findById(id).get(),false);
        if(null != natureIncident){
            return natureIncident;
        }else {
            throw new IdNotFound(id);
        }
    }
    @Override
    public List<NatureIncident> find(String search)throws AttributesNotFound,ErrorType {
        return NatureIncidentMapper.toDtos(natureIncidentRepository.findAll(Search.expression(search,TmsNatureIncident.class)), false);
    }
    @Override
    public List<NatureIncident>find(String search, Pageable pageable)throws AttributesNotFound,ErrorType {
        return NatureIncidentMapper.toDtos(natureIncidentRepository.findAll(Search.expression(search,TmsNatureIncident.class),pageable),false);
    }
    @Override
    public Long size(String search)throws AttributesNotFound,ErrorType {
        return natureIncidentRepository.count(Search.expression(search , TmsNatureIncident.class));
    }
    @Override
    public void delete(Long id){
        LOGGER.info("save NatureIncident");
        natureIncidentRepository.deleteById(id);
    }
    @Override
    public void delete(NatureIncident natureIncident){
        LOGGER.info("delete NatureIncident");
        natureIncidentRepository.delete(NatureIncidentMapper.toEntity(natureIncident,false));
    }
    @Override
    public List<NatureIncident>findAll(){
        return NatureIncidentMapper.toDtos(natureIncidentRepository.findAll(),false);

    }
    @Override
    public List<NatureIncident>findAll(Pageable pageable){
        return NatureIncidentMapper.toDtos(natureIncidentRepository.findAll(pageable),false);
    }

}
