package com.bagile.gmo.repositories;

import com.bagile.gmo.entities.GmoActionType;
import com.bagile.gmo.entities.TmsPackagingType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface PackagingTypeRepository extends JpaRepository<TmsPackagingType,Long>,
        QuerydslPredicateExecutor<TmsPackagingType>{

}
