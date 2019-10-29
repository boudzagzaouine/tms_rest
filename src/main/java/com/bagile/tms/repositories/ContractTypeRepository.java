package com.bagile.tms.repositories;

import com.bagile.tms.entities.TmsContractType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;

public interface ContractTypeRepository extends JpaRepository<TmsContractType,Long>,

        QuerydslPredicateExecutor<TmsContractType> {
}
