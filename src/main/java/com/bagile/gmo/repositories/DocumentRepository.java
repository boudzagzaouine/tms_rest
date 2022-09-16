package com.bagile.gmo.repositories;

import com.bagile.gmo.entities.GmoDocument;
import com.bagile.gmo.entities.GmoDocumentType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;

public interface DocumentRepository extends JpaRepository<GmoDocument,Long>,
        QuerydslPredicateExecutor<GmoDocument> {

 
}