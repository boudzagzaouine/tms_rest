package com.bagile.gmo.repositories;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;

import com.bagile.gmo.entities.AdrAddress;

public interface AddressRepository extends JpaRepository<AdrAddress, Long>,
		QuerydslPredicateExecutor<AdrAddress> {
	public AdrAddress findByAdrAddressCode(String adrAddressCode);
}