package com.bagile.gmo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.data.querydsl.QuerydslPredicateExecutor;

import com.bagile.gmo.entities.TrpTransport;

public interface TransportRepository extends JpaRepository<TrpTransport, Long>,
		QuerydslPredicateExecutor<TrpTransport> {


}