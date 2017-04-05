package com.sinno.ems.service.impl;

import com.sinno.ems.dto.Incident;
import com.sinno.ems.entities.PrmIncident;
import com.sinno.ems.exception.AttributesNotFound;
import com.sinno.ems.exception.ErrorType;
import com.sinno.ems.exception.IdNotFound;
import com.sinno.ems.mapper.IncidentMapper;
import com.sinno.ems.repositories.IncidentRepository;
import com.sinno.ems.service.IncidentService;
import com.sinno.ems.util.EmsDate;
import com.sinno.ems.util.Search;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;

import java.util.List;

/**
 * Created by khalil on 04/04/2017.
 */
public class IncidentServiceImpl implements IncidentService {
    @Autowired
    private IncidentRepository incidentRepository;
    private final static Logger LOGGER = LoggerFactory
            .getLogger(IncidentService.class);
    @Override
    public Incident save(Incident incident) {
        LOGGER.info("save Incident");
        incident.setDateTime(EmsDate.getDateNow());
        if(0<=incident.getId())
        {
            incident.setDateTime(EmsDate.getDateNow());
        }
        return IncidentMapper.toDto(incidentRepository.saveAndFlush(IncidentMapper.toEntity(incident, false)), false);
    }
    @Override
    public Long size() {
        return incidentRepository.count();
    }

    @Override
    public Boolean isExist(Long id) {
        return incidentRepository.exists(id);
    }

    @Override
    public Incident findById(Long id) throws IdNotFound {
        Incident incident = IncidentMapper.toDto(incidentRepository.findOne(id), false);
        if (null != incident) {
            return incident;
        } else {
            throw new IdNotFound(id);
        }
    }
    @Override
    public List<Incident> find(String search) throws AttributesNotFound, ErrorType {
        return IncidentMapper.toDtos(incidentRepository.findAll(Search.expression(search, PrmIncident.class)), false);
    }
    @Override
    public List<Incident> find(String search, Pageable pageable) throws AttributesNotFound, ErrorType {
        return IncidentMapper.toDtos(incidentRepository.findAll(Search.expression(search, PrmIncident.class), pageable), false);
    }
    @Override
    public Long size(String search) throws AttributesNotFound, ErrorType {
        return incidentRepository.count(Search.expression(search, PrmIncident.class));
    }
    @Override
    public void delete(Long id) {
        LOGGER.info("save Incident");
        incidentRepository.delete(id);
    }
    @Override
    public void delete(Incident incident) {
        LOGGER.info("delete Incident");
        incidentRepository.delete(IncidentMapper.toEntity(incident, false));

    }
    @Override
    public List<Incident> findAll() {
        return IncidentMapper.toDtos(incidentRepository.findAll(), false);
    }
    @Override
    public List<Incident> findAll(Pageable pageable) {
        return IncidentMapper.toDtos(incidentRepository.findAll(pageable), false);
    }

}
