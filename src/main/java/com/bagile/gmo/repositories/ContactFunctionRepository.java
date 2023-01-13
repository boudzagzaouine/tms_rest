package com.bagile.gmo.repositories;

import com.bagile.gmo.entities.GmoAgent;
import com.bagile.gmo.entities.TmsContactFunction;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;

import java.math.BigInteger;
import java.util.List;


public interface ContactFunctionRepository extends JpaRepository<TmsContactFunction, Long>,
        QuerydslPredicateExecutor<TmsContactFunction> {



}
