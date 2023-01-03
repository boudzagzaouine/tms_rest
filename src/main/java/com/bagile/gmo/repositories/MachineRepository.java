package com.bagile.gmo.repositories;

import com.bagile.gmo.entities.GmoMachine;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;

import java.math.BigInteger;
import java.util.List;


public interface MachineRepository extends JpaRepository<GmoMachine,Long>,
        QuerydslPredicateExecutor<GmoMachine> {

    @Query(value="select nextval('schema_tmsvoieexpress.seq_machine_code')",nativeQuery = true)
    public List<BigInteger> getNextVal();
}
