package com.sinno.ems.repositories;

import com.sinno.ems.entities.PrmSetting;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QueryDslPredicateExecutor;

public interface SettingRepository extends JpaRepository<PrmSetting, Long>,
        QueryDslPredicateExecutor<PrmSetting> {

}