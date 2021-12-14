package com.bagile.gmo.repositories;

import com.bagile.gmo.entities.PrmContainerType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;


public interface ContainerTypeRepository extends JpaRepository<PrmContainerType, Long>,
        QuerydslPredicateExecutor<PrmContainerType> {
    PrmContainerType findByPrmContainerTypeCode(String code);
}