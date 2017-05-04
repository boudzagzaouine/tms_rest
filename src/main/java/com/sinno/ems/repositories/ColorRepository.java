package com.sinno.ems.repositories;

import com.sinno.ems.entities.PrmColor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QueryDslPredicateExecutor;

public interface ColorRepository extends JpaRepository<PrmColor, Long>,
        QueryDslPredicateExecutor<PrmColor> {
    public PrmColor findByPrmColorIdAndPrmColorCode(Long id, String code);

    public PrmColor findByPrmColorId(Long id);
}