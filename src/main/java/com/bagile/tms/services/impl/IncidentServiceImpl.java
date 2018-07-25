package com.bagile.tms.services.impl;

import com.bagile.tms.dto.Incident;
import com.bagile.tms.entities.TmsIncident;
import com.bagile.tms.exceptions.AttributesNotFound;
import com.bagile.tms.exceptions.ErrorType;
import com.bagile.tms.exceptions.IdNotFound;
import com.bagile.tms.mapper.IncidentMapper;
import com.bagile.tms.repositories.IncidentRepository;
import com.bagile.tms.services.IncidentService;
import com.bagile.tms.util.EmsDate;
import com.bagile.tms.util.Search;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by khalil on 04/04/2017.
 */
@Service
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
        return incidentRepository.existsById(id);
    }

    @Override
    public Incident findById(Long id) throws IdNotFound {
        Incident incident = IncidentMapper.toDto(incidentRepository.findById(id).get(), false);
        if (null != incident) {
            return incident;
        } else {
            throw new IdNotFound(id);
        }
    }
    @Override
    public List<Incident> find(String search) throws AttributesNotFound, ErrorType {
        return IncidentMapper.toDtos(incidentRepository.findAll(Search.expression(search, TmsIncident.class)), false);
    }
    @Override
    public List<Incident> find(String search, Pageable pageable) throws AttributesNotFound, ErrorType {
        return IncidentMapper.toDtos(incidentRepository.findAll(Search.expression(search, TmsIncident.class), pageable), false);
    }
    @Override
    public Long size(String search) throws AttributesNotFound, ErrorType {
        return incidentRepository.count(Search.expression(search, TmsIncident.class));
    }
    @Override
    public void delete(Long id) {
        LOGGER.info("save Incident");
        incidentRepository.deleteById(id);
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
