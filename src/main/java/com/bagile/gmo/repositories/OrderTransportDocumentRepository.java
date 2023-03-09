package com.bagile.gmo.repositories;

import com.bagile.gmo.entities.TmsOrderTransportDocument;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;


public interface OrderTransportDocumentRepository extends JpaRepository<TmsOrderTransportDocument,Long>, QuerydslPredicateExecutor<TmsOrderTransportDocument> {
}
