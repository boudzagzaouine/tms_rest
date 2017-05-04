package com.sinno.ems.repositories;

import com.sinno.ems.entities.PrmMsgSend;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QueryDslPredicateExecutor;

/**
 * Created by ASMAE on 04/05/2016.
 */
public interface MsgSendRepository extends JpaRepository<PrmMsgSend, Long>,
        QueryDslPredicateExecutor<PrmMsgSend> {
}
