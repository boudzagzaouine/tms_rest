package com.bagile.gmo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;
import org.springframework.data.repository.query.Param;

import com.bagile.gmo.entities.WrhWarehouse;

import java.util.List;

public interface WarehouseRepository extends JpaRepository<WrhWarehouse, Long>,
        QuerydslPredicateExecutor<WrhWarehouse> {
    @Query(value = "select o.own_ownercode,count(c.stk_containerid) from schema_crm.own_owner o join schema_crm.stk_container c on o.own_ownerid=c.stk_containerownerid join schema_crm.wrh_warehouse w on c.stk_containerwarehouseid=w.wrh_warehouseid group by o.own_ownercode", nativeQuery = true)
    public List<Object[]> sizeContainerByOwner();
    @Query(value = "select o.own_ownercode,count(c.stk_containerid) from schema_crm.own_owner o join schema_crm.stk_container c on o.own_ownerid=c.stk_containerownerid join schema_crm.wrh_warehouse w on c.stk_containerwarehouseid=w.wrh_warehouseid where w.wrh_warehousecode=:code  group by o.own_ownercode", nativeQuery = true)
        public List<Object[]> sizeContainerByOwnerByCode(@Param("code") String code);
    public WrhWarehouse findByWrhWarehouseCode(String wrhWarehouseCode);

    @Query(value = "select nextVal('schema_crm.seq_warehouse_code')", nativeQuery = true)
    Long getNextVal();
}