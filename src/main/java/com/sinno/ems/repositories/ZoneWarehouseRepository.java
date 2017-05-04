package com.sinno.ems.repositories;

import com.sinno.ems.entities.LocZoneWarehouse;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QueryDslPredicateExecutor;

/**
 * Created by Enissay on 21/06/2016.
 */
public interface ZoneWarehouseRepository extends JpaRepository<LocZoneWarehouse, Long>,
        QueryDslPredicateExecutor<LocZoneWarehouse> {
}
