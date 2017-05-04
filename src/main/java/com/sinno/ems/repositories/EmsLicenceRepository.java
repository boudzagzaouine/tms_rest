package com.sinno.ems.repositories;

import com.sinno.ems.entities.EmsLicenceId;
import com.sinno.ems.entities.EmsLicense;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by Enissay on 28/11/2016.
 */
public interface EmsLicenceRepository extends JpaRepository<EmsLicense,EmsLicenceId> {
}
