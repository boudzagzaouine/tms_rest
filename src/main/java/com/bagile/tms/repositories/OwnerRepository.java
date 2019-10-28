package com.bagile.tms.repositories;

import com.bagile.tms.entities.OwnOwner;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;

public interface OwnerRepository extends JpaRepository<OwnOwner, Long>,
		QuerydslPredicateExecutor<OwnOwner> {
	OwnOwner findByOwnOwnerCode(String ownOwnerCode);

}