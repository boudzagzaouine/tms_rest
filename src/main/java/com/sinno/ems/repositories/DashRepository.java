
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

import com.sinno.ems.entities.DashCommercial;
import org.springframework.stereotype.Repository;

import com.sinno.ems.entities.DashContainer;
import com.sinno.ems.entities.DashInvoice;
import com.sinno.ems.entities.DashResult;

/**
 * @author aelguezzar
 *
 */
@Repository
public class DashRepository {

	@PersistenceContext(unitName="entityManagerFactory")
	EntityManager em;
	
	public List<DashResult> saleOrders(String owners, String warehouses, String status) {
		Query query = em.createNativeQuery("SELECT * FROM schema_ems.saleorders(?, ?, ?)", DashResult.class);
		query.setParameter(1, warehouses);
		query.setParameter(2, owners);
		query.setParameter(3, status);
		List<DashResult> list = query.getResultList();
		return list;
	}

	public List<DashResult> saleOrdersLines(String owners, String warehouses, String status) {
		Query query = em.createNativeQuery("SELECT * FROM schema_ems.saleorderslines(?, ?, ?)", DashResult.class);
		query.setParameter(1, warehouses);
		query.setParameter(2, owners);
		query.setParameter(3, status);
		List<DashResult> list = query.getResultList();
		return list;
	}

	public List<DashResult> purshaseOrders(String owners, String warehouses, String status) {
		Query query = em.createNativeQuery("SELECT * FROM schema_ems.purshaseorders(?, ?, ?)", DashResult.class);
		query.setParameter(1, warehouses);
		query.setParameter(2, owners);
		query.setParameter(3, status);
		List<DashResult> list = query.getResultList();
		return list;
	}

	public List<DashResult> purshaseOrdersLines(String owners, String warehouses, String status) {
		Query query = em.createNativeQuery("SELECT * FROM schema_ems.purshaseorderslines(?, ?, ?)", DashResult.class);
		query.setParameter(1, warehouses);
		query.setParameter(2, owners);
		query.setParameter(3, status);
		List<DashResult> list = query.getResultList();
		return list;
	}

	public List<DashContainer> containerByWarehouseAndOwner(String warehouse, String startDate, String endDate) {
		Query query = em.createNativeQuery("SELECT * FROM schema_ems.containerByWarehouseAndOwner(?, ?, ?)", DashContainer.class);
		query.setParameter(1, warehouse);
		query.setParameter(2, startDate);
		query.setParameter(3, endDate);
		List<DashContainer> list = query.getResultList();
		return list;
	}

	public List<DashInvoice> invoiceByOwner(String warehouse, String startDate, String endDate) {
		Query query = em.createNativeQuery("SELECT * FROM schema_ems.invoiceByOwner(?, ?, ?)", DashInvoice.class);
		query.setParameter(1, warehouse);
		query.setParameter(2, startDate);
		query.setParameter(3, endDate);
		List<DashInvoice> list = query.getResultList();
		return list;
	}
	public List<DashCommercial> salesPerCommercial(Date startDate, Date endDate)
	{
		Query query = em.createNativeQuery("SELECT * FROM schema_ems.salespercommercial(?, ?)", DashCommercial.class);
		query.setParameter(1,startDate);
		query.setParameter(2,endDate);
		return query.getResultList();
	}
	public BigDecimal salesRevenues(Date startDate, Date endDate)
	{
		Query query = em.createNativeQuery("SELECT * FROM schema_ems.salesrevenues(?, ?)");
		query.setParameter(1,startDate);
		query.setParameter(2,endDate);
		return (BigDecimal) query.getSingleResult();
	}

	public BigDecimal invoiceRevenues(Date startDate, Date endDate)
	{
		Query query = em.createNativeQuery("SELECT * FROM schema_ems.invoicerevenues(?, ?)");
		query.setParameter(1,startDate);
		query.setParameter(2,endDate);
		return (BigDecimal) query.getSingleResult();
	}

	public BigDecimal paymentRevenues(Date startDate, Date endDate)
	{
		Query query = em.createNativeQuery("SELECT * FROM schema_ems.paymentrevenues(?, ?)");
		query.setParameter(1,startDate);
		query.setParameter(2,endDate);
		return (BigDecimal) query.getSingleResult();
	}
	public BigDecimal nonpaymentRevenues(Date startDate, Date endDate)
	{
		Query query = em.createNativeQuery("SELECT * FROM schema_ems.nonpaymentrevenues(?, ?)");
		query.setParameter(1,startDate);
		query.setParameter(2,endDate);
		return (BigDecimal) query.getSingleResult();
	}
}