package com.bagile.tms.services.impl;

import com.bagile.tms.dto.Acte;
import com.bagile.tms.exceptions.AttributesNotFound;
import com.bagile.tms.exceptions.ErrorType;
import com.bagile.tms.exceptions.IdNotFound;
import com.bagile.tms.mapper.ActeMapper;
import com.bagile.tms.repositories.ActeRepository;
import com.bagile.tms.services.ActeService;
import com.bagile.tms.util.EmsDate;
import com.bagile.tms.util.Search;
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
        return acteRepository.existsById(id);
    }
    @Override
    public Acte findById(Long id) throws IdNotFound {
       Acte acte = ActeMapper.toDto(acteRepository.findById(id).get(), false);
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
        acteRepository.deleteById(id);
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
