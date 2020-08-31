package com.bagile.gmo.repositories;

import com.bagile.gmo.entities.OrgOrganisation;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by Enissay on 14/04/2016.
 */
public interface OrganisationRepository extends JpaRepository<OrgOrganisation, Long>
      {
}
