package com.sinno.ems.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QueryDslPredicateExecutor;

import com.sinno.ems.entities.StkContainerView;

public interface ContainerViewRepository extends JpaRepository<StkContainerView, Long>,
QueryDslPredicateExecutor<StkContainerView> {

}
