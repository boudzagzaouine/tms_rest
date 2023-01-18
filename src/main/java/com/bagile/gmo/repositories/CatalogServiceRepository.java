package com.bagile.gmo.repositories;

import com.bagile.gmo.entities.GmoActionType;
import com.bagile.gmo.entities.TmsCatalogService;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface CatalogServiceRepository extends JpaRepository<TmsCatalogService,Long>,
        QuerydslPredicateExecutor<TmsCatalogService>{

}
