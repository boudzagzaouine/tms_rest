package com.sinno.ems.service;

import com.sinno.ems.entities.EmsLicenceId;
import com.sinno.ems.entities.EmsLicense;
import com.sinno.ems.exception.AttributesNotFound;
import com.sinno.ems.exception.ErrorType;
import com.sinno.ems.exception.IdNotFound;
import org.springframework.data.domain.Pageable;

import java.util.List;

/**
 * Created by Enissay on 28/11/2016.
 */
public interface EmsLicenceService {
    public EmsLicense save(EmsLicense EmsLicense);

    public Long size();
    public void delete(EmsLicense EmsLicense);

    public List<EmsLicense> findAll();

    public List<EmsLicense> findAll(Pageable pageable);

    EmsLicense findById(EmsLicenceId id) throws IdNotFound;
}
