package com.sinno.ems.repositories;

import com.sinno.ems.entities.IncNatureIncident;
import com.sinno.ems.entities.PrmIncident;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QueryDslPredicateExecutor;
import org.springframework.security.access.method.P;

/**
 * Created by bouzi on 3/27/2017.
 */
public interface NatureIncidentRepository extends JpaRepository <IncNatureIncident,Long>,
    QueryDslPredicateExecutor<IncNatureIncident>{

}
