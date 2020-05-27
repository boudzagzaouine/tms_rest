package com.bagile.gmo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;

import com.bagile.gmo.entities.GmoInsurance;
import org.springframework.data.repository.query.Param;

public interface InsuranceRepository extends JpaRepository<GmoInsurance,Long>,

        QuerydslPredicateExecutor<GmoInsurance> {
    @Query(value="SELECT  i FROM GmoInsurance i WHERE  (i.gmoPatrimony.gmoPatrimonyId = :id)" +
            "and (current_timestamp  BETWEEN  i.gmoInsuranceStartDate and i.gmoInsuranceEndDate) ")
    GmoInsurance findByPatrimony( @Param("id") Long id);

}
