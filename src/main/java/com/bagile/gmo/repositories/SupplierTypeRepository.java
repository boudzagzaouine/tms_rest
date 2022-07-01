package com.bagile.gmo.repositories;

import com.bagile.gmo.entities.GmoActionType;
import com.bagile.gmo.entities.GmoSupplierType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface SupplierTypeRepository extends JpaRepository<GmoSupplierType,Long>,
        QuerydslPredicateExecutor<GmoSupplierType>{

}
