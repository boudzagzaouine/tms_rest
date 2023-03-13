package com.bagile.gmo.repositories;

import com.bagile.gmo.entities.TmsOrderTransportDocument;
import com.bagile.gmo.entities.TmsOrderTransportDocumentType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;


public interface OrderTransportDocumentTypeRepository extends JpaRepository<TmsOrderTransportDocumentType,Long>, QuerydslPredicateExecutor<TmsOrderTransportDocumentType> {
}
