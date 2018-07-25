package com.bagile.tms.repositories;

import com.bagile.tms.entities.PrmImage;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;

public interface ImageRepository extends JpaRepository<PrmImage, Long>,
		QuerydslPredicateExecutor<PrmImage> {
}