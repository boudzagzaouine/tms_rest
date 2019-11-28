package com.bagile.tms.repositories;

import com.bagile.tms.entities.TmsInsurance;
import com.bagile.tms.entities.TmsInsuranceTerm;
import org.hibernate.validator.constraints.EAN;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;

import java.util.List;

public interface TermInsuranceRepository extends JpaRepository<TmsInsuranceTerm,Long>,
        QuerydslPredicateExecutor<TmsInsuranceTerm> {


}
