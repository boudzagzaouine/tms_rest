package com.bagile.tms.repositories;

import com.sinno.ems.entities.TmsActe;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QueryDslPredicateExecutor;

/**
 * Created by khalil on 27/03/2017.
 */
public interface ActeRepository extends JpaRepository<TmsActe,Long>,

    QueryDslPredicateExecutor<TmsActe>{
}
