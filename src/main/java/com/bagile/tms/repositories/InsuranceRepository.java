package com.bagile.tms.repositories;

import com.bagile.tms.entities.TmsInsurance;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;

import java.util.List;

public interface InsuranceRepository extends JpaRepository<TmsInsurance,Long>,

        QuerydslPredicateExecutor<TmsInsurance> {
    List<TmsInsurance> findByTmsVehicleIsNull();
}
