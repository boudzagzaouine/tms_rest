package com.bagile.gmo.repositories;

import com.bagile.gmo.entities.CmdCompany;
import com.bagile.gmo.entities.GmoActionTypeRepair;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface ActionTypeRepairRepository extends JpaRepository<GmoActionTypeRepair,Long>,
        QuerydslPredicateExecutor<GmoActionTypeRepair>{

}
