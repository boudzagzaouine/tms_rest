package com.sinno.ems.repositories;

import com.sinno.ems.entities.TmsColor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QueryDslPredicateExecutor;

public interface ColorRepository extends JpaRepository<TmsColor, Long>,
        QueryDslPredicateExecutor<TmsColor> {

}