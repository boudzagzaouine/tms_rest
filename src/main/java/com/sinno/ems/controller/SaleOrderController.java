package com.sinno.ems.controller;

import com.sinno.ems.dto.SaleOrder;
import com.sinno.ems.exception.AttributesNotFound;
import com.sinno.ems.exception.ErrorType;
import com.sinno.ems.exception.IdNotFound;
import com.sinno.ems.service.SaleOrderService;
import com.sinno.ems.service.UserDetailsServiceWarehouse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.MediaType;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping(value = "/saleOrders/")
public class SaleOrderController {

    @Autowired
    private SaleOrderService saleOrderService;
    @Autowired
    @Qualifier("userDetailsService")
    private UserDetailsServiceWarehouse userDetailsService;

    @PreAuthorize("hasAnyRole('SALE_ORDER_VIEW','DELIVERY_VIEW')")
    @RequestMapping(method = RequestMethod.GET, value = "/list")
    @ResponseBody
    public List<SaleOrder> getSaleOrders() throws AttributesNotFound, ErrorType {
        if ( null == userDetailsService.getOwners()) {
            return null;
        }
        return saleOrderService.find( userDetailsService.getOwners().toString());
        //return saleOrderService.findAll();
    }

    @PreAuthorize("hasAnyRole('SALE_ORDER_VIEW','DELIVERY_VIEW')")
    @RequestMapping(method = RequestMethod.GET, value = "/listPage")
    @ResponseBody
    public List<SaleOrder> getSaleOrders(@RequestParam int page, @RequestParam int size) throws AttributesNotFound, ErrorType {
        if ( null == userDetailsService.getOwners()) {
            return null;
        }
        return saleOrderService.find( userDetailsService.getOwners().toString(), page, size);
        //return saleOrderService.findAll(pageable);
    }

    @PreAuthorize("hasAnyRole('SALE_ORDER_VIEW','DELIVERY_VIEW')")
    @RequestMapping(method = RequestMethod.GET, value = "/size")
    @ResponseBody
    public Long size() throws AttributesNotFound, ErrorType {
        if ( null == userDetailsService.getOwners()) {
            return null;
        }
        return saleOrderService.size( userDetailsService.getOwners().toString());
    }

    @PreAuthorize("hasAnyRole('SALE_ORDER_VIEW','DELIVERY_VIEW')")
    @RequestMapping(method = RequestMethod.GET, value = "/sizeSearch")
    @ResponseBody
    public Long size(@RequestParam String search) throws AttributesNotFound, ErrorType {
        if ( null == userDetailsService.getOwners()) {
            return null;
        }
        if (!search.endsWith(",")) {
            search += ",";
        }
        return saleOrderService.size(search +  userDetailsService.getOwners().toString());
    }

    @PreAuthorize("hasAnyRole('SALE_ORDER_VIEW','DELIVERY_VIEW')")
    @RequestMapping(method = RequestMethod.GET, value = "/exist")
    @ResponseBody
    public Boolean exist(@RequestParam Long id) throws AttributesNotFound, ErrorType {
        return saleOrderService.isExist(id);
    }

    @PreAuthorize("hasAnyRole('SALE_ORDER_VIEW','DELIVERY_VIEW')")
    @RequestMapping(method = RequestMethod.GET, value = "/{id}")
    @ResponseBody
    public SaleOrder getSaleOrder(@PathVariable("id") Long id) throws IdNotFound {
        return saleOrderService.findById(id);
    }

    @PreAuthorize("hasAnyRole('SALE_ORDER_VIEW','DELIVERY_VIEW')")
    @RequestMapping(method = RequestMethod.GET, value = "/search")
    @ResponseBody
    public List<SaleOrder> search(@RequestParam(value = "search") String search) throws AttributesNotFound, ErrorType {
        if ( null == userDetailsService.getOwners()) {
            return null;
        }
        if (!search.endsWith(",")) {
            search += ",";
        }
        try{
            return saleOrderService.find(search  + userDetailsService.getOwners().toString());
        }catch (Exception e){
            System.err.println(e.getMessage());
            return null;
        }

    }

    @PreAuthorize("hasAnyRole('SALE_ORDER_VIEW','DELIVERY_VIEW')")
    @RequestMapping(method = RequestMethod.GET, value = "/searchPage")
    @ResponseBody
    public List<SaleOrder> search(@RequestParam(value = "search") String search, @RequestParam int page, @RequestParam int size) throws AttributesNotFound, ErrorType {
        if ( null == userDetailsService.getOwners()) {
            return null;
        }
        if (!search.endsWith(",")) {
            search += ",";
        }
        return saleOrderService.find(search +  userDetailsService.getOwners().toString(), page, size);
    }

    @PreAuthorize("hasRole('SALE_ORDER_CREATE')")
    @RequestMapping(value = "/save", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public SaleOrder add(@RequestBody SaleOrder saleOrder) {
        return saleOrderService.save(saleOrder);
    }

    @PreAuthorize("hasRole('SALE_ORDER_EDIT')")
    @RequestMapping(value = "/save", method = RequestMethod.PUT, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public SaleOrder set(@RequestBody SaleOrder saleOrder) {
        return saleOrderService.save(saleOrder);
    }

    @PreAuthorize("hasRole('SALE_ORDER_DELETE')")
    @RequestMapping(value = "/delete", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public void delete(@RequestBody SaleOrder saleOrder) {

        saleOrderService.delete(saleOrder);
    }

    @PreAuthorize("hasRole('SALE_ORDER_DELETE')")
    @RequestMapping(value = "/delete/{id}", method = RequestMethod.DELETE, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public void delete(@PathVariable Long id) {
        saleOrderService.delete(id);
    }

    @PreAuthorize("hasRole('SALE_ORDER_CREATE')")
    @RequestMapping(method = RequestMethod.GET, value = "/nextval")
    @ResponseBody
    public String nextVal() {
        return "SO" + saleOrderService.getNextVal().toString();
    }


}