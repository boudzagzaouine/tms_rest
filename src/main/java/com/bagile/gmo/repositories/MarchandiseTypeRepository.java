package com.bagile.gmo.repositories;

import com.bagile.gmo.entities.TmsAccountPricingService;
import com.bagile.gmo.entities.TmsMarchandiseType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;

public interface MarchandiseTypeRepository extends JpaRepository<TmsMarchandiseType,Long>,
        QuerydslPredicateExecutor<TmsMarchandiseType> {

 
}