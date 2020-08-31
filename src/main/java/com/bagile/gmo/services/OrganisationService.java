package com.bagile.gmo.services;

import com.bagile.gmo.dto.Organisation;
import com.bagile.gmo.exceptions.IdNotFound;


/**
 * Created by Enissay on 14/04/2016.
 */
public interface OrganisationService {
    Organisation findById(Long id) throws IdNotFound;
    Organisation save(Organisation organisation);
}
