package com.bagile.tms.repositories;

import com.bagile.tms.entities.TmsIncident;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;

/**
 * Created by khalil on 04/04/2017.
 */
public interface IncidentRepository extends JpaRepository<TmsIncident,Long>,
    QuerydslPredicateExecutor<TmsIncident>{

    }

