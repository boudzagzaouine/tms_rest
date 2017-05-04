package com.sinno.ems.repositories;

import com.sinno.ems.entities.AdrAddress;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QueryDslPredicateExecutor;

public interface AddressRepository extends JpaRepository<AdrAddress, Long>,
		QueryDslPredicateExecutor<AdrAddress> {
	public AdrAddress findByAdrAddressCode(String adrAddressCode);
}