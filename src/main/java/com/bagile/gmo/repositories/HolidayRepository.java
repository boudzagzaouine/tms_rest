package com.bagile.gmo.repositories;

import com.bagile.gmo.entities.TmsHoliday;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;

public interface HolidayRepository extends JpaRepository<TmsHoliday,Long>,
        QuerydslPredicateExecutor<TmsHoliday> {
}