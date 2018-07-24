package com.bagile.tms.services;

import com.sinno.ems.dto.Organisation;
import com.sinno.ems.exception.IdNotFound;

/**
 * Created by Enissay on 14/04/2016.
 */
public interface OrganisationService {
    public Organisation findById(Long id) throws IdNotFound;
    public Organisation save(Organisation organisation);
}
