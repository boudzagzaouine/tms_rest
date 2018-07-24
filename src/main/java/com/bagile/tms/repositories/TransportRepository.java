package com.bagile.tms.repositories;

import com.sinno.ems.entities.TrpTransport;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QueryDslPredicateExecutor;

public interface TransportRepository extends JpaRepository<TrpTransport, Long>,
		QueryDslPredicateExecutor<TrpTransport> {

	public TrpTransport findByTrpTransportCode(String trpTransportCode);
}