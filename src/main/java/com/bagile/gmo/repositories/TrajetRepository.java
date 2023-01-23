package com.bagile.gmo.repositories;

import com.bagile.gmo.entities.CmdAccount;
import com.bagile.gmo.entities.TmsTrajet;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;

import java.math.BigInteger;
import java.util.List;

public interface TrajetRepository extends JpaRepository<TmsTrajet, Long>,
		QuerydslPredicateExecutor<TmsTrajet> {


}