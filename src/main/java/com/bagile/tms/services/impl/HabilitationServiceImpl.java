package com.bagile.tms.services.impl;

import com.sinno.ems.dto.Habilitation;
import com.sinno.ems.entities.UsrHabilitation;
import com.sinno.ems.exception.AttributesNotFound;
import com.sinno.ems.exception.ErrorType;
import com.sinno.ems.exception.IdNotFound;
import com.sinno.ems.mapper.HabilitationMapper;
import com.sinno.ems.repositories.HabilitationRepository;
import com.sinno.ems.service.AddressService;
import com.sinno.ems.service.HabilitationService;
import com.sinno.ems.util.EmsDate;
import com.sinno.ems.util.Search;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HabilitationServiceImpl implements HabilitationService {

    @Autowired
    private HabilitationRepository habilitationRepository;
    private final static Logger LOGGER = LoggerFactory
            .getLogger(HabilitationService.class);

    @Override
    public Habilitation save(Habilitation habilitation) {
        LOGGER.info("save Habilitation");
        habilitation.setUpdateDate(EmsDate.getDateNow());
        if (0 >= habilitation.getId()) {
            habilitation.setCreationDate(EmsDate.getDateNow());
        }
        return HabilitationMapper.toDto(habilitationRepository.saveAndFlush(HabilitationMapper.toEntity(habilitation, false)), false);
    }

    @Override
    public Long size() {
        return habilitationRepository.count();
    }

    @Override
    public Boolean isExist(Long id) {
        return habilitationRepository.exists(id);
    }

    @Override
    public Habilitation findById(Long id) throws IdNotFound {
        Habilitation habilitation = HabilitationMapper.toDto(habilitationRepository.findOne(id), false);
        if (null != habilitation) {
            return habilitation;
        } else {
            throw new IdNotFound(id);
        }
    }

    @Override
    public List<Habilitation> find(String search) throws AttributesNotFound, ErrorType {
        return HabilitationMapper.toDtos(habilitationRepository.findAll(Search.expression(search, UsrHabilitation.class)), false);
    }

    @Override
    public List<Habilitation> find(String search, Pageable pageable) throws AttributesNotFound, ErrorType {
        return HabilitationMapper.toDtos(habilitationRepository.findAll(Search.expression(search, UsrHabilitation.class), pageable), false);
    }

    @Override
    public Long size(String search) throws AttributesNotFound, ErrorType {
        return habilitationRepository.count(Search.expression(search, UsrHabilitation.class));
    }

    @Override
    public void delete(Long id) {
        LOGGER.info("delete Habilitation");
        habilitationRepository.delete(id);
    }

    @Override
    public void delete(Habilitation habilitation) {
        LOGGER.info("delete Habilitation");
        habilitationRepository.delete(HabilitationMapper.toEntity(habilitation, false));
    }

    @Override
    public List<Habilitation> findAll() {
        return HabilitationMapper.toDtos(habilitationRepository.findAll(), false);
    }

    @Override
    public List<Habilitation> findAll(Pageable pageable) {
        return HabilitationMapper.toDtos(habilitationRepository.findAll(pageable), false);
    }
}