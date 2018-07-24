package com.bagile.tms.repositories;

import com.sinno.ems.entities.PrmImage;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QueryDslPredicateExecutor;

public interface ImageRepository extends JpaRepository<PrmImage, Long>,
		QueryDslPredicateExecutor<PrmImage> {
}