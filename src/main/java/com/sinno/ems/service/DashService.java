/**
 * 
 */
package com.sinno.ems.service;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import com.sinno.ems.dto.BarCode;
import com.sinno.ems.entities.DashCommercial;
import com.sinno.ems.entities.DashContainer;
import com.sinno.ems.entities.DashInvoice;
import com.sinno.ems.entities.DashResult;

/**
 * @author Sinno
 *
 */
public interface DashService {

	public List<DashResult> saleOrders(String owners, String warehouses, String status);

	public List<DashResult> saleOrdersLines(String owners, String warehouses, String status);

	public List<DashResult> purshaseOrders(String owners, String warehouses, String status);

	public List<DashResult> purshaseOrdersLines(String owners, String warehouses, String status);

	public List<DashContainer> containerByWarehouseAndOwner(String warehouse, String startDate, String endDate);

	public List<DashInvoice> invoiceByOwner(String warehouse, String startDate, String endDate);

	List<DashCommercial> salesPerCommercial(Date startDate, Date endDate);

	BigDecimal salesRevenues(Date startDate, Date endDate);

	BigDecimal invoiceRevenues(Date startDate, Date endDate);

	BigDecimal paymentRevenues(Date startDate, Date endDate);

	BigDecimal nonpaymentRevenues(Date startDate, Date endDate);
}
