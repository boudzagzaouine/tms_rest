package com.bagile.gmo.repositories;

import com.bagile.gmo.entities.TmsOrderTransportInfoLineDocument;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderTransportInfoLineDocumentRepository extends JpaRepository<TmsOrderTransportInfoLineDocument,Long>,
        QuerydslPredicateExecutor<TmsOrderTransportInfoLineDocument>{

}
