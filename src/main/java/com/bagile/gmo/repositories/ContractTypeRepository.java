package com.bagile.gmo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;

import com.bagile.gmo.entities.GmoContractType;

public interface ContractTypeRepository extends JpaRepository<GmoContractType,Long>,

        QuerydslPredicateExecutor<GmoContractType> {
}
