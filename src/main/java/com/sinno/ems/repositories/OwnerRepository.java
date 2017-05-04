package com.sinno.ems.repositories;

import com.sinno.ems.entities.OwnOwner;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QueryDslPredicateExecutor;

public interface OwnerRepository extends JpaRepository<OwnOwner, Long>,
		QueryDslPredicateExecutor<OwnOwner> {
	OwnOwner findByOwnOwnerCode(String ownOwnerCode);

}