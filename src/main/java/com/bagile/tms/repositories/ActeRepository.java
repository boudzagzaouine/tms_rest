package com.bagile.tms.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;

/**
 * Created by khalil on 27/03/2017.
 */
public interface ActeRepository extends JpaRepository<TmsActe,Long>,

    QuerydslPredicateExecutor<TmsActe>{
}
