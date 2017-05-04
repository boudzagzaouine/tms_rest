/**
 * 
 */
package com.sinno.ems.service.impl;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import com.sinno.ems.entities.DashCommercial;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sinno.ems.entities.DashContainer;
import com.sinno.ems.entities.DashInvoice;
import com.sinno.ems.entities.DashResult;
import com.sinno.ems.repositories.DashRepository;
import com.sinno.ems.service.DashService;

/**
 * @author Sinno
 *
 */
@Service
public class DashServiceImpl implements DashService {

	@Autowired
	DashRepository dashRepo;

	@Override
	public List<DashResult> saleOrders(String owners, String warehouses, String status) {
    	return dashRepo.saleOrders(owners, warehouses, status);
	}

	@Override
	public List<DashResult> saleOrdersLines(String owners, String warehouses, String status) {
    	return dashRepo.saleOrdersLines(owners, warehouses, status);
	}

	@Override
	public List<DashResult> purshaseOrders(String owners, String warehouses, String status) {
    	return dashRepo.purshaseOrders(owners, warehouses, status);
	}

	@Override
	public List<DashResult> purshaseOrdersLines(String owners, String warehouses, String status) {
    	return dashRepo.purshaseOrdersLines(owners, warehouses, status);
	}

	@Override
	public List<DashContainer> containerByWarehouseAndOwner(String warehouse, String startDate, String endDate) {
		return dashRepo.containerByWarehouseAndOwner(warehouse, startDate, endDate);
	}

	@Override
	public List<DashInvoice> invoiceByOwner(String warehouse, String startDate, String endDate) {
		return dashRepo.invoiceByOwner(warehouse, startDate, endDate);
	}
	@Override
	public List<DashCommercial> salesPerCommercial(Date startDate, Date endDate)
	{
		return dashRepo.salesPerCommercial(startDate,endDate);
	}
	@Override
	public BigDecimal salesRevenues(Date startDate, Date endDate)
	{
		return dashRepo.salesRevenues(startDate,endDate);
	}
	@Override
	public BigDecimal invoiceRevenues(Date startDate, Date endDate)
	{
		return dashRepo.invoiceRevenues(startDate,endDate);
	}
	@Override
	public BigDecimal paymentRevenues(Date startDate, Date endDate)
	{
		return dashRepo.paymentRevenues(startDate,endDate);
	}
	@Override
	public BigDecimal nonpaymentRevenues(Date startDate,Date endDate)
	{
		return dashRepo.nonpaymentRevenues(startDate,endDate);
	}
}
