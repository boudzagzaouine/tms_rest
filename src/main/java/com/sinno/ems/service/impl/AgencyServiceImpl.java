package com.sinno.ems.service.impl;

import com.sinno.ems.dto.Agency;
import com.sinno.ems.entities.UsrAgency;
import com.sinno.ems.exception.AttributesNotFound;
import com.sinno.ems.exception.ErrorType;
import com.sinno.ems.exception.IdNotFound;
import com.sinno.ems.mapper.AgencyMapper;
import com.sinno.ems.repositories.AgencyRepository;
import com.sinno.ems.service.AgencyService;
import com.sinno.ems.util.EmsDate;
import com.sinno.ems.util.Search;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Enissay on 02/01/2017.
 */
@Service
public class AgencyServiceImpl implements AgencyService{
    @Autowired
    private AgencyRepository agencyRepository;
    private final static Logger LOGGER = LoggerFactory
            .getLogger(AgencyService.class);
    @Override
    public Agency save(Agency agency) {
        LOGGER.info("save Agency");
        agency.setUpdateDate(EmsDate.getDateNow());
        if (0 >= agency.getId()) {
            agency.setCreationDate(EmsDate.getDateNow());
        }
        return AgencyMapper.toDto(agencyRepository.saveAndFlush(AgencyMapper.toEntity(agency, false)), false);
    }

    @Override
    public Long size() {
        return agencyRepository.count();
    }

    @Override
    public Boolean isExist(Long id) {
        return agencyRepository.exists(id);
    }

    @Override
    public Agency findById(Long id) throws IdNotFound {
        Agency agency = AgencyMapper.toDto(agencyRepository.findOne(id), false);
        if (null != agency) {
            return agency;
        } else {
            throw new IdNotFound(id);
        }
    }

    @Override
    public List<Agency> find(String search) throws AttributesNotFound, ErrorType {
        return AgencyMapper.toDtos(agencyRepository.findAll(Search.expression(search, UsrAgency.class)), false);
    }

    @Override
    public List<Agency> find(String search, int page, int size) throws AttributesNotFound, ErrorType {
        Sort sort = new Sort(Sort.Direction.DESC, "usrAgencyUpdateDate");
        Pageable pageable = new PageRequest(page, size,sort);
        return AgencyMapper.toDtos(agencyRepository.findAll(Search.expression(search, UsrAgency.class), pageable), false);
    }

    @Override
    public Long size(String search) throws AttributesNotFound, ErrorType {
        return agencyRepository.count(Search.expression(search, UsrAgency.class));
    }

    @Override
    public void delete(Long id) {
        LOGGER.info("delete Agency");
        agencyRepository.delete(id);
    }

    @Override
    public void delete(Agency agency) {
        LOGGER.info("delete Agency");
        agencyRepository.delete(AgencyMapper.toEntity(agency, false));
    }

    @Override
    public List<Agency> findAll() {
        return AgencyMapper.toDtos(agencyRepository.findAll(), false);
    }

    @Override
    public List<Agency> findAll(Pageable pageable) {
        return AgencyMapper.toDtos(agencyRepository.findAll(pageable), false);
    }
}
