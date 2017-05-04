package com.sinno.ems.repositories;

import com.sinno.ems.entities.RcpReception;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.querydsl.QueryDslPredicateExecutor;

import java.math.BigInteger;
import java.util.List;

public interface ReceptionRepository extends JpaRepository<RcpReception, Long>,
		QueryDslPredicateExecutor<RcpReception> {
	@Query(value="select nextval('schema_ems.seq_reception_code')",nativeQuery = true)
	public List<BigInteger> getNextVal();
	public RcpReception findByRcpReceptionCode(String rcpReceptionCode);
}