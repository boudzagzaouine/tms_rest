package com.sinno.ems.service.impl;


import com.google.common.collect.Lists;
import com.sinno.ems.entities.EmsLicenceId;
import com.sinno.ems.entities.EmsLicense;
import com.sinno.ems.entities.PrmEdi;
import com.sinno.ems.exception.AttributesNotFound;
import com.sinno.ems.exception.ErrorType;
import com.sinno.ems.exception.IdNotFound;
import com.sinno.ems.mapper.EdiMapper;
import com.sinno.ems.repositories.EdiRepository;
import com.sinno.ems.repositories.EmsLicenceRepository;
import com.sinno.ems.service.AddressService;
import com.sinno.ems.service.EmsLicenceService;
import com.sinno.ems.util.Search;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Enissay on 28/11/2016.
 */
@Service
public class EmsLicenceServiceImpl implements EmsLicenceService {
    @Autowired
    private EmsLicenceRepository emsLicenseRepository;
    private final static Logger LOGGER = LoggerFactory
            .getLogger(EmsLicenceService.class);

    @Override
    public EmsLicense save(EmsLicense emsLicense) {
        LOGGER.info("save EmsLicense");
        return emsLicenseRepository.saveAndFlush(emsLicense);
    }

    @Override
    public Long size() {
        return emsLicenseRepository.count();
    }


    @Override
    public void delete(EmsLicense edi) {
        LOGGER.info("delete EmsLicense");
        emsLicenseRepository.delete(edi);
    }

    @Override
    public List<EmsLicense> findAll() {
        return emsLicenseRepository.findAll();
    }

    @Override
    public List<EmsLicense> findAll(Pageable pageable) {
        return Lists.newArrayList(emsLicenseRepository.findAll(pageable));
    }
    @Override
    public EmsLicense findById(EmsLicenceId id) throws IdNotFound {
        EmsLicense emsLicense = emsLicenseRepository.findOne(id);
            return emsLicense;
    }


}
