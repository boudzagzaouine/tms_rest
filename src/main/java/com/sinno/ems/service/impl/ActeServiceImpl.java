package com.sinno.ems.service.impl;

import com.sinno.ems.dto.Acte;
import com.sinno.ems.entities.TmsActe;
import com.sinno.ems.exception.AttributesNotFound;
import com.sinno.ems.exception.ErrorType;
import com.sinno.ems.exception.IdNotFound;
import com.sinno.ems.mapper.ActeMapper;
import com.sinno.ems.repositories.ActeRepository;
import com.sinno.ems.service.ActeService;
import com.sinno.ems.util.EmsDate;
import com.sinno.ems.util.Search;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;


import java.util.List;


/**
 * Created by khalil on 27/03/2017.
 */
@Service
public class ActeServiceImpl implements ActeService{
    @Autowired
    private ActeRepository acteRepository;
    private final static Logger LOGGER = LoggerFactory
                .getLogger(ActeService.class);
    @Override
    public Acte save(Acte acte) {
        LOGGER.info("save Acte");
        acte.setDateLastAct(EmsDate.getDateNow());
        if(0<=acte.getId())
        {
            acte.setDateLastAct(EmsDate.getDateNow());
        }
        return ActeMapper.toDto(acteRepository.saveAndFlush(ActeMapper.toEntity(acte, false)), false);

    }
    @Override
    public Long size() {
        return acteRepository.count();
    }
    @Override
    public Boolean isExist(Long id) {
        return acteRepository.exists(id);
    }
    @Override
    public Acte findById(Long id) throws IdNotFound {
       Acte acte = ActeMapper.toDto(acteRepository.findOne(id), false);
        if (null != acte) {
            return acte;
        } else {
            throw new IdNotFound(id);
        }
    }

    @Override
    public List<Acte> find(String search) throws AttributesNotFound, ErrorType {
        return ActeMapper.toDtos(acteRepository.findAll(Search.expression(search, TmsActe.class)), false);
    }
    @Override
    public List<Acte> find(String search, Pageable pageable) throws AttributesNotFound, ErrorType {
        return ActeMapper.toDtos(acteRepository.findAll(Search.expression(search, TmsActe.class), pageable), false);
    }
    @Override
    public Long size(String search) throws AttributesNotFound, ErrorType {
        return acteRepository.count(Search.expression(search, TmsActe.class));
    }
    @Override
    public void delete(Long id) {
        LOGGER.info("save Acte");
        acteRepository.delete(id);
    }

    @Override
    public void delete(Acte acte) {
        LOGGER.info("delete Acte");
        acteRepository.delete(ActeMapper.toEntity(acte, false));
    }
    @Override
    public List<Acte> findAll() {
        return ActeMapper.toDtos(acteRepository.findAll(), false);
    }
    @Override
        public List<Acte> findAll(Pageable pageable) {
        return ActeMapper.toDtos(acteRepository.findAll(pageable), false);
    }


}
