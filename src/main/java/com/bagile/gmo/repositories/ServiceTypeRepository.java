package com.bagile.gmo.repositories;

import com.bagile.gmo.entities.GmoActionType;
import com.bagile.gmo.entities.TmsServiceType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface ServiceTypeRepository extends JpaRepository<TmsServiceType,Long>,
        QuerydslPredicateExecutor<TmsServiceType>{

}
