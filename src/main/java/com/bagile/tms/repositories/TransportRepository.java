package com.bagile.tms.repositories;

import com.bagile.tms.entities.TrpTransport;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;

public interface TransportRepository extends JpaRepository<TrpTransport, Long>,
		QuerydslPredicateExecutor<TrpTransport> {

	public TrpTransport findByTrpTransportCode(String trpTransportCode);
}