/**
 * 
 */
package com.sinno.ems.repositories;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;

/**
 * @author Sinno
 *
 */
@Repository
public class CalculInvoiceRepository {

	@PersistenceContext(unitName="entityManagerFactory")
	EntityManager em;
    public List<BigDecimal> receptionMovement(Long ownerId, Date startDate, Date endDate) {
		Query query = em.createNativeQuery("SELECT * FROM schema_ems.receptionMovement(?, ?, ?)");
		query.setParameter(1, ownerId);
		query.setParameter(2, startDate);
		query.setParameter(3, endDate);
		List<BigDecimal> list = query.getResultList();
		return list;
    }

    public List<BigDecimal> expeditionMovement(Long ownerId, Date startDate, Date endDate) {
		Query query = em.createNativeQuery("SELECT * FROM schema_ems.expeditionMovement(?, ?, ?)");
		query.setParameter(1, ownerId);
		query.setParameter(2, startDate);
		query.setParameter(3, endDate);
		List<BigDecimal> list = query.getResultList();
		return list;
    }

    public List<Double> stockageMovement(Long ownerId, Date startDate, Date endDate) {
		Query query = em.createNativeQuery("SELECT * FROM schema_ems.stockageMovement(?, ?, ?)");
		query.setParameter(1, ownerId);
		query.setParameter(2, endDate);
		query.setParameter(3,startDate );
		List<Double> list = query.getResultList();
		return list;
    }

    public List<BigDecimal> administrativeCostsForReception( Date startDate, Date endDate,Long ownerId) {
		Query query = em.createNativeQuery("SELECT * FROM schema_ems.administrativeCostsForReception(?, ?, ?)");
		query.setParameter(1, ownerId);
		query.setParameter(2, startDate);
		query.setParameter(3, endDate);
		List<BigDecimal> list = query.getResultList();
		return list;
    }

    public List<BigDecimal> administrativeCostsForDelivery( Date startDate, Date endDate,Long ownerId) {
		Query query = em.createNativeQuery("SELECT * FROM schema_ems.administrativeCostsForDelivery(?, ?, ?)");
		query.setParameter(1, ownerId);
		query.setParameter(2, startDate);
		query.setParameter(3, endDate);
		List<BigDecimal> list = query.getResultList();
		return list;
    }

}
