/**
 * 
 */
package com.sinno.ems.controller;

import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import com.sinno.ems.entities.DashCommercial;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.sinno.ems.entities.DashContainer;
import com.sinno.ems.entities.DashInvoice;
import com.sinno.ems.entities.DashResult;
import com.sinno.ems.exception.AttributesNotFound;
import com.sinno.ems.exception.ErrorType;
import com.sinno.ems.service.DashService;
import com.sinno.ems.service.UserDetailsServiceWarehouse;

/**
 * @author Sinno
 *
 */
@Controller
@RequestMapping(value = "/dash/")
public class DashController {

	@Autowired
	private DashService dashService;

    @Autowired
    @Qualifier("userDetailsService")
    private UserDetailsServiceWarehouse userDetailsService;

	@RequestMapping(method = RequestMethod.GET, value = "/SaleOrders")
    @ResponseBody
    public List<DashResult> getSaleOrders() throws AttributesNotFound, ErrorType {
		StringBuffer owners = userDetailsService.getIdOwners();
		StringBuffer warehouses = userDetailsService.getIdWarehouses();
        return dashService.saleOrders(owners.toString(), warehouses.toString(), "1,2,3,4,5,6,7");
    }

	@RequestMapping(method = RequestMethod.GET, value = "/SaleOrdersLines")
    @ResponseBody
    public List<DashResult> getSaleOrdersLines() throws AttributesNotFound, ErrorType {
		StringBuffer owners = userDetailsService.getIdOwners();
		StringBuffer warehouses = userDetailsService.getIdWarehouses();
        return dashService.saleOrdersLines(owners.toString(), warehouses.toString(), "1,2,3,4,5,6,7");
    }

	@RequestMapping(method = RequestMethod.GET, value = "/PurshaseOrders")
    @ResponseBody
    public List<DashResult> getOrderStatus() throws AttributesNotFound, ErrorType {
		StringBuffer owners = userDetailsService.getIdOwners();
		StringBuffer warehouses = userDetailsService.getIdWarehouses();
        return dashService.purshaseOrders(owners.toString(), warehouses.toString(), "1,2,3,4,5,6,7");
    }

	@RequestMapping(method = RequestMethod.GET, value = "/PurshaseOrdersLines")
    @ResponseBody
    public List<DashResult> getOrderStatusLine() throws AttributesNotFound, ErrorType {
		StringBuffer owners = userDetailsService.getIdOwners();
		StringBuffer warehouses = userDetailsService.getIdWarehouses();
        return dashService.purshaseOrdersLines(owners.toString(), warehouses.toString(), "1,2,3,4,5,6,7");
    }

	@RequestMapping(method = RequestMethod.GET, value = "/ContainerByWarehouseAndOwner")
    @ResponseBody
    public List<DashContainer> getContainerByWarehouseAndOwner(@RequestParam(value = "warehouse") String warehouse, @RequestParam(value = "StartDate") String startDate, @RequestParam(value = "EndDate") String enDate) throws AttributesNotFound, ErrorType {
        return dashService.containerByWarehouseAndOwner(warehouse, startDate, enDate);
    }

	@RequestMapping(method = RequestMethod.GET, value = "/InvoiceByOwner")
    @ResponseBody
    public List<DashInvoice> getInvoiceByOwner(@RequestParam(value = "warehouse") String warehouse, @RequestParam(value = "StartDate") String startDate, @RequestParam(value = "EndDate") String enDate) throws AttributesNotFound, ErrorType {
        return dashService.invoiceByOwner(warehouse, startDate, enDate);
    }
    @RequestMapping(method = RequestMethod.GET, value = "/salesPerCommercial")
    @ResponseBody
    public List<DashCommercial> salesPerCommercial(@RequestParam(value = "StartDate") String startDate, @RequestParam(value = "EndDate") String enDate) throws AttributesNotFound, ErrorType {
        SimpleDateFormat format=new SimpleDateFormat("dd/mm/yyyy");
        Date enddate=null;
        Date starDate=null;
        try {
             starDate =format.parse(startDate);
            enddate= format.parse(enDate);

        } catch (ParseException e) {
            e.printStackTrace();
        }
        return dashService.salesPerCommercial(starDate, enddate);
    }

    @RequestMapping(method = RequestMethod.GET, value = "/salesRevenues")
    @ResponseBody
    public BigDecimal salesRevenues(@RequestParam(value = "StartDate") String startDate, @RequestParam(value = "EndDate") String enDate) throws AttributesNotFound, ErrorType {
        SimpleDateFormat format=new SimpleDateFormat("dd/mm/yyyy");
        Date enddate=null;
        Date starDate=null;
        try {
            starDate =format.parse(startDate);
            enddate= format.parse(enDate);

        } catch (ParseException e) {
            e.printStackTrace();
        }
        return dashService.salesRevenues(starDate, enddate);
    }
    @RequestMapping(method = RequestMethod.GET, value = "/invoiceRevenues")
    @ResponseBody
    public BigDecimal invoiceRevenues(@RequestParam(value = "StartDate") String startDate, @RequestParam(value = "EndDate") String enDate) throws AttributesNotFound, ErrorType {
        SimpleDateFormat format=new SimpleDateFormat("dd/mm/yyyy");
        Date enddate=null;
        Date starDate=null;
        try {
            starDate =format.parse(startDate);
            enddate= format.parse(enDate);

        } catch (ParseException e) {
            e.printStackTrace();
        }
        return dashService.invoiceRevenues(starDate, enddate);
    }
    @RequestMapping(method = RequestMethod.GET, value = "/paymentRevenues")
    @ResponseBody
    public BigDecimal paymentRevenues(@RequestParam(value = "StartDate") String startDate, @RequestParam(value = "EndDate") String enDate) throws AttributesNotFound, ErrorType {
        SimpleDateFormat format=new SimpleDateFormat("dd/mm/yyyy");
        Date enddate=null;
        Date starDate=null;
        try {
            starDate =format.parse(startDate);
            enddate= format.parse(enDate);

        } catch (ParseException e) {
            e.printStackTrace();
        }
        return dashService.paymentRevenues(starDate, enddate);
    }
    @RequestMapping(method = RequestMethod.GET, value = "/nonpaymentRevenues")
    @ResponseBody
    public BigDecimal nonpaymentRevenues(@RequestParam(value = "StartDate") String startDate, @RequestParam(value = "EndDate") String enDate) throws AttributesNotFound, ErrorType {
        SimpleDateFormat format=new SimpleDateFormat("dd/mm/yyyy");
        Date enddate=null;
        Date starDate=null;
        try {
            starDate =format.parse(startDate);
            enddate= format.parse(enDate);

        } catch (ParseException e) {
            e.printStackTrace();
        }
        return dashService.nonpaymentRevenues(starDate, enddate);
    }
}
