package com.bagile.tms.repositories;

import com.sinno.ems.entities.UsrUserGroupWarehouse;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QueryDslPredicateExecutor;

public interface UserGroupWarehouseRepository extends JpaRepository<UsrUserGroupWarehouse, Long>,
        QueryDslPredicateExecutor<UsrUserGroupWarehouse> {
}