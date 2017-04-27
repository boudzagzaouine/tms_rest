package com.sinno.ems.repositories;

import com.sinno.ems.entities.TmsDriverBadge;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QueryDslPredicateExecutor;

/**
 * Created by bouzi on 4/26/2017.
 */
public interface DriverBadgeRepository extends JpaRepository<TmsDriverBadge, Long>,
        QueryDslPredicateExecutor<TmsDriverBadge> {

}
