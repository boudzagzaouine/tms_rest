package com.bagile.tms.repositories;

import com.bagile.tms.entities.AdrAddress;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;


public interface AddressRepository extends JpaRepository<AdrAddress, Long>,
		QuerydslPredicateExecutor<AdrAddress> {
	public AdrAddress findByAdrAddressCode(String adrAddressCode);
}