package com.bagile.tms.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;

import com.bagile.gmo.entities.UsrUserGroupWarehouse;

public interface UserGroupWarehouseRepository extends JpaRepository<UsrUserGroupWarehouse, Long>,
        QuerydslPredicateExecutor<UsrUserGroupWarehouse> {
}