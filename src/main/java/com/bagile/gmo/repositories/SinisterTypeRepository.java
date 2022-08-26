package com.bagile.gmo.repositories;

import com.bagile.gmo.entities.CmdAccount;
import com.bagile.gmo.entities.GmoSinisterType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;

import java.math.BigInteger;
import java.util.List;

public interface SinisterTypeRepository extends JpaRepository<GmoSinisterType, Long>,
		QuerydslPredicateExecutor<GmoSinisterType> {


	@Query(value = "select nextVal('schema_crm.seq_sinister_type_code')", nativeQuery = true)
	public List<BigInteger> getNextVal();

}