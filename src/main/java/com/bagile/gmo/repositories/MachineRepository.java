package com.bagile.gmo.repositories;

import com.bagile.gmo.entities.GmoMachine;
import com.bagile.gmo.entities.GmoVehicle;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;


public interface MachineRepository extends JpaRepository<GmoMachine,Long>,
        QuerydslPredicateExecutor<GmoMachine> {
}
