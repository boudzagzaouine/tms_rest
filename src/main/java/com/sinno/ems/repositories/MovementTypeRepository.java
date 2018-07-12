package com.sinno.ems.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.querydsl.QueryDslPredicateExecutor;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

public interface MovementTypeRepository extends JpaRepository<InvMovementType, Long>,
        QueryDslPredicateExecutor<InvMovementType> {
    @Query(value = "select sum(countC) from (select count(*) as countC " +
            "from schema_ems.stk_container,schema_ems.rcp_receptionstock " +
            "where stk_containerid=rcp_receptionstockcontainerid and rcp_receptionstockownerid=stk_containerownerid and stk_containerownerid=?1 and rcp_receptionstockreceptiondate between ?2 and ?3 group by stk_containerid,rcp_receptionstockreceptionid) as a", nativeQuery = true)
    public List<BigDecimal> receptionMovement(Long ownerId, Date startDate, Date endDate);


    @Query(value = "select sum(countC) from (select count(*) as countC " +
            "from schema_ems.stk_container,schema_ems.cmd_saleorderstock " +
            "where stk_containerid=cmd_saleorderstockcontainerid and cmd_saleorderstockownerid=stk_containerownerid and stk_containerownerid=?1 and cmd_saleorderstockorderdate between ?2 and ?3 group by stk_containerid,cmd_saleorderstockdeliveryid) as a", nativeQuery = true)
    public List<BigDecimal> expeditionMovement(Long ownerId, Date startDate, Date endDate);

    @Query(value = "select sum(countC) from (" +
            "select sum(DATE_PART ('day',cmd_saleorderstockorderdate-rcp_receptionstockreceptiondate)) countC "
            + "from schema_ems.rcp_receptionstock,schema_ems.cmd_saleorderstock,schema_ems.stk_container where stk_containerid=cmd_saleorderstockcontainerid  and " +
            "cmd_saleorderstockcontainerid=rcp_receptionstockcontainerid " +
           "and " +
            "stk_containerid=cmd_saleorderstockcontainerid \n" +
            "and " +
            "stk_containerownerid=cmd_saleorderstockownerid\n" +
           "and " +
            "stk_containerownerid=rcp_receptionstockownerid\n" +
            "and " +
            "stk_containerownerid=?1 " +
            "and rcp_receptionstockreceptiondate>=?2  " +
            "and cmd_saleorderstockorderdate<=?3 group by stk_containerid,rcp_receptionstockreceptionid,cmd_saleorderstockdeliveryid) as a", nativeQuery = true)
    public List<Double> stockageMovement(Long ownerId, Date startDate, Date endDate);

    @Query(value="select sum(countC) from (select count(*) as countC from schema_ems.rcp_reception where rcp_receptionreceptiondate between ?1 and ?2 and rcp_receptionownerid=?3)as a",nativeQuery = true)
    public List<BigDecimal> administrativeCostsForReception( Date startDate, Date endDate,Long ownerId);

    @Query(value="select sum(countC) from (select count(*) as countC from schema_ems.cmd_delivery where cmd_deliveryloaddate between ?1 and ?2 and cmd_deliveryownerid=?3)as a",nativeQuery = true)
    public List<BigDecimal> administrativeCostsForDelivery( Date startDate, Date endDate,Long ownerId);





}