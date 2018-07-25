package com.bagile.tms.services;

import com.bagile.tms.dto.Organisation;
import com.bagile.tms.exceptions.IdNotFound;

/**
 * Created by Enissay on 14/04/2016.
 */
public interface OrganisationService {
    public Organisation findById(Long id) throws IdNotFound;
    public Organisation save(Organisation organisation);
}
