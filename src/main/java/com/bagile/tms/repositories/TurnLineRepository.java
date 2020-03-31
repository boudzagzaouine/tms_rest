package com.bagile.tms.repositories;

import com.bagile.tms.entities.CmdSaleOrder;
import com.bagile.tms.entities.TmsTurnLine;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;

import java.math.BigInteger;
import java.util.List;

public interface TurnLineRepository extends JpaRepository<TmsTurnLine, Long>,
		QuerydslPredicateExecutor<TmsTurnLine> {

}