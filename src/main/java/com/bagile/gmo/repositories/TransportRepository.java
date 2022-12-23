package com.bagile.gmo.repositories;

import com.bagile.gmo.entities.TrpTransport;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;

import java.math.BigInteger;
import java.util.List;

public interface TransportRepository extends JpaRepository<TrpTransport, Long>,
		QuerydslPredicateExecutor<TrpTransport> {
	@Query(value="select nextval('schema_crmexpress.seq_transport_code')",nativeQuery = true)
	public List<BigInteger> getNextVal();

}