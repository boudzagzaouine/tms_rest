package com.bagile.gmo.repositories;

import com.bagile.gmo.entities.RcpReception;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;

import java.math.BigInteger;
import java.util.List;

public interface ReceptionRepository extends JpaRepository<RcpReception, Long>,
		QuerydslPredicateExecutor<RcpReception> {

}