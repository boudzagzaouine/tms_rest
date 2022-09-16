package com.bagile.gmo.repositories;

import com.bagile.gmo.entities.GmoActionPlan;
import com.bagile.gmo.entities.GmoDocumentType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;

public interface DocumentTypeRepository extends JpaRepository<GmoDocumentType,Long>,
        QuerydslPredicateExecutor<GmoDocumentType> {

 
}