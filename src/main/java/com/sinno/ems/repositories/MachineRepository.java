package com.sinno.ems.repositories;

import com.sinno.ems.entities.PdtMachine;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QueryDslPredicateExecutor;

/**
 * Created by Enissay on 28/03/2017.
 */
public interface MachineRepository extends JpaRepository<PdtMachine,Long>,QueryDslPredicateExecutor<PdtMachine> {
}
