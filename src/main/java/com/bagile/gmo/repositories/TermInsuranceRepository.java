package com.bagile.tms.repositories;

import org.hibernate.validator.constraints.EAN;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;

import com.bagile.gmo.entities.GmoInsurance;
import com.bagile.gmo.entities.TmsInsuranceTerm;

import java.util.List;

public interface TermInsuranceRepository extends JpaRepository<TmsInsuranceTerm,Long>,
        QuerydslPredicateExecutor<TmsInsuranceTerm> {


}
