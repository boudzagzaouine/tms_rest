package com.sinno.ems.repositories;

import com.sinno.ems.entities.PrmMsgReceive;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QueryDslPredicateExecutor;

/**
 * Created by ASMAE on 03/05/2016.
 */
public interface MsgReceiveRepository extends JpaRepository<PrmMsgReceive, Long>,
        QueryDslPredicateExecutor<PrmMsgReceive> {

}
