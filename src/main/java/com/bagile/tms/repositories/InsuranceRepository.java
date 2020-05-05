package com.bagile.tms.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;

import com.bagile.gmo.entities.GmoInsurance;

import java.util.List;

public interface InsuranceRepository extends JpaRepository<GmoInsurance,Long>,

        QuerydslPredicateExecutor<GmoInsurance> {
    List<GmoInsurance> findByTmsVehicleIsNull();
}
