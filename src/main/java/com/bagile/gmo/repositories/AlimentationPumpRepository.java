package com.bagile.gmo.repositories;

import com.bagile.gmo.entities.GmoAlimentationPump;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;


public interface AlimentationPumpRepository extends JpaRepository<GmoAlimentationPump, Long>,
        QuerydslPredicateExecutor<GmoAlimentationPump> {
}
