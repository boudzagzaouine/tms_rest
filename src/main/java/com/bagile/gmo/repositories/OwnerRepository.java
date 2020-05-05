package com.bagile.gmo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;

import com.bagile.gmo.entities.OwnOwner;

public interface OwnerRepository extends JpaRepository<OwnOwner, Long>,
		QuerydslPredicateExecutor<OwnOwner> {
	OwnOwner findByOwnOwnerCode(String ownOwnerCode);

}