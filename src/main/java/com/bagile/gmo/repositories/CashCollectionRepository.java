package com.bagile.gmo.repositories;

import com.bagile.gmo.entities.TmsCashCollection;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CashCollectionRepository extends JpaRepository<TmsCashCollection, Long> {

    List<TmsCashCollection> findByTransportPlanId(Long transportPlanId);

    List<TmsCashCollection> findByOrderTransportId(Long orderTransportId);
}
