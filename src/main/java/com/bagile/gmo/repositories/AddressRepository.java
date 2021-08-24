package com.bagile.gmo.repositories;


import com.bagile.gmo.entities.AdrAddress;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;

import java.math.BigInteger;
import java.util.List;

public interface AddressRepository extends JpaRepository<AdrAddress, Long>,
		QuerydslPredicateExecutor<AdrAddress> {

	@Query(value="select nextval('schema_crm.seq_adresse_code')",nativeQuery = true)
	public List<BigInteger> getNextVal();


}