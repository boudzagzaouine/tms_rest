package com.sinno.ems.repositories;

import com.sinno.ems.entities.PrmBadge;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QueryDslPredicateExecutor;

/**
 * Created by khalil on 27/03/2017.
 */
public interface BadgeRepository extends JpaRepository<PrmBadge,Long>,

        QueryDslPredicateExecutor<PrmBadge> {

}

