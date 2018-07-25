package com.bagile.tms.repositories;

import com.bagile.tms.entities.UsrUserGroupWarehouse;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;

public interface UserGroupWarehouseRepository extends JpaRepository<UsrUserGroupWarehouse, Long>,
        QuerydslPredicateExecutor<UsrUserGroupWarehouse> {
}