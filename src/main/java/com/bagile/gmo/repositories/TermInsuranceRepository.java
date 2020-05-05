package com.bagile.gmo.repositories;

import org.hibernate.validator.constraints.EAN;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;

import com.bagile.gmo.entities.GmoInsurance;
import com.bagile.gmo.entities.GmoInsuranceTerm;

import java.util.List;

public interface TermInsuranceRepository extends JpaRepository<GmoInsuranceTerm,Long>,
        QuerydslPredicateExecutor<GmoInsuranceTerm> {


}
