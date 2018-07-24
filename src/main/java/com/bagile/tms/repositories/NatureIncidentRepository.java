package com.bagile.tms.repositories;

import com.sinno.ems.entities.TmsNatureIncident;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QueryDslPredicateExecutor;

/**
 * Created by bouzi on 3/27/2017.
 */
public interface NatureIncidentRepository extends JpaRepository<TmsNatureIncident,Long>,
    QueryDslPredicateExecutor<TmsNatureIncident>{

}
