package com.bagile.gmo.repositories;

import com.bagile.gmo.entities.GmoSinister;
import com.bagile.gmo.entities.GmoSinisterType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;

import java.math.BigInteger;
import java.util.List;

public interface SinisterRepository extends JpaRepository<GmoSinister, Long>,
		QuerydslPredicateExecutor<GmoSinister> {


	@Query(value = "select nextVal('schema_crmexpress.seq_sinister_code')", nativeQuery = true)
	public List<BigInteger> getNextVal();

}