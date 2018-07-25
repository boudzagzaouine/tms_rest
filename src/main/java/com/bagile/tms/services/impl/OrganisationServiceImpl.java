package com.bagile.tms.services.impl;

import com.bagile.tms.dto.Organisation;
import com.bagile.tms.exceptions.IdNotFound;
import com.bagile.tms.mapper.OrganisationMapper;
import com.bagile.tms.repositories.OrganisationRepository;
import com.bagile.tms.services.AddressService;
import com.bagile.tms.services.OrganisationService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by Enissay on 14/04/2016.
 */
@Service
public class OrganisationServiceImpl implements OrganisationService {
    @Autowired
    private OrganisationRepository organisationRepository;
    private final static Logger LOGGER = LoggerFactory
            .getLogger(OrganisationService.class);

    @Override
    public Organisation findById(Long id) throws IdNotFound {
        Organisation organisation = OrganisationMapper.toDto(organisationRepository.findById(id).get(), false);
        if (null != organisation) {
            return organisation;
        } else {
            throw new IdNotFound(id);
        }
    }

    @Override
    public Organisation save(Organisation organisation) {
        LOGGER.info("save Organisation");
        return OrganisationMapper.toDto(organisationRepository.saveAndFlush(OrganisationMapper.toEntity(organisation, false)), false);
    }


}
