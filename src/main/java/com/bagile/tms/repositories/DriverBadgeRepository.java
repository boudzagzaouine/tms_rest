package com.bagile.tms.repositories;

import com.bagile.tms.entities.TmsBadge;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;

/**
 * Created by bouzi on 4/26/2017.
 */
public interface DriverBadgeRepository extends JpaRepository<TmsBadge, Long>,
        QuerydslPredicateExecutor<TmsBadge> {

}
