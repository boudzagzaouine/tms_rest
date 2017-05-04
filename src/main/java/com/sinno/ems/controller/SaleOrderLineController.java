package com.sinno.ems.controller;

import com.sinno.ems.dto.SaleOrderLine;
import com.sinno.ems.exception.AttributesNotFound;
import com.sinno.ems.exception.ErrorType;
import com.sinno.ems.exception.IdNotFound;
import com.sinno.ems.exception.ProductControls;
import com.sinno.ems.service.SaleOrderLineService;
import com.sinno.ems.service.UserDetailsServiceWarehouse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.MediaType;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping(value = "/saleOrderLines/")
public class SaleOrderLineController {

    @Autowired
    private SaleOrderLineService saleOrderLineService;
    @Autowired
    @Qualifier("userDetailsService")
    private UserDetailsServiceWarehouse userDetailsService;

    @PreAuthorize("hasAnyRole('SALE_ORDER_LINE_VIEW','DELIVERY_LINE_VIEW')")
    @RequestMapping(method = RequestMethod.GET,value = "/list")
    @ResponseBody
    public List<SaleOrderLine> getSaleOrderLines() throws AttributesNotFound, ErrorType {
        if (null == userDetailsService.getWarehouses() || null==userDetailsService.getOwners())
        { return null;}
        return saleOrderLineService.find(userDetailsService.getWarehouses().toString()+","+userDetailsService.getOwners().toString());
       // return saleOrderLineService.findAll();
    }

    @PreAuthorize("hasAnyRole('SALE_ORDER_LINE_VIEW','DELIVERY_LINE_VIEW')")
    @RequestMapping(method = RequestMethod.GET, value = "/listPage")
    @ResponseBody
    public List<SaleOrderLine> getSaleOrderLines(@RequestParam int page, @RequestParam int size) throws AttributesNotFound, ErrorType {
        if (null == userDetailsService.getWarehouses() || null==userDetailsService.getOwners()) {
            return null;
        }
        return saleOrderLineService.find(userDetailsService.getWarehouses().toString()+","+userDetailsService.getOwners().toString(), page,size);
       // return saleOrderLineService.findAll(pageable);
    }

    @PreAuthorize("hasAnyRole('SALE_ORDER_LINE_VIEW','DELIVERY_LINE_VIEW')")
    @RequestMapping(method = RequestMethod.GET, value = "/size")
    @ResponseBody
    public Long size() throws AttributesNotFound, ErrorType {
        if (null == userDetailsService.getWarehouses() || null==userDetailsService.getOwners()) {
            return null;
        }
        return saleOrderLineService.size(userDetailsService.getWarehouses().toString()+","+userDetailsService.getOwners().toString());
    }

    @PreAuthorize("hasAnyRole('SALE_ORDER_LINE_VIEW','DELIVERY_LINE_VIEW')")
    @RequestMapping(method = RequestMethod.GET, value = "/sizeSearch")
    @ResponseBody
    public Long size(@RequestParam String search) throws AttributesNotFound, ErrorType {
        if (null == userDetailsService.getWarehouses() || null==userDetailsService.getOwners()) {
            return null;
        }
        if (!search.endsWith(",")) {
            search += ",";
        }
        return saleOrderLineService.size(search + userDetailsService.getWarehouses().toString()+","+userDetailsService.getOwners().toString());
    }

    @PreAuthorize("hasAnyRole('SALE_ORDER_LINE_VIEW','DELIVERY_LINE_VIEW')")
    @RequestMapping(method = RequestMethod.GET, value = "/exist")
    @ResponseBody
    public Boolean exist(@RequestParam Long id) throws AttributesNotFound, ErrorType {
        return saleOrderLineService.isExist(id);
    }    @PreAuthorize("hasRole('SALE_ORDER_LINE_VIEW')")
    @RequestMapping(method = RequestMethod.GET,value = "/{id}")
    @ResponseBody
    public SaleOrderLine getSaleOrderLine(@PathVariable("id") Long id) throws IdNotFound {
        return saleOrderLineService.findById(id);
    }

    @PreAuthorize("hasAnyRole('SALE_ORDER_LINE_VIEW','DELIVERY_LINE_VIEW')")
    @RequestMapping(method = RequestMethod.GET, value = "/search")
    @ResponseBody
    public List<SaleOrderLine> search(@RequestParam(value = "search") String search) throws AttributesNotFound, ErrorType {
        if (null == userDetailsService.getWarehouses() || null==userDetailsService.getOwners())
            return null;
        if (!search.endsWith(",")) {
            search += ",";
        }
        return saleOrderLineService.find(search + userDetailsService.getWarehouses()+","+userDetailsService.getOwners().toString());
    }

    @PreAuthorize("hasAnyRole('SALE_ORDER_LINE_VIEW','DELIVERY_LINE_VIEW')")
    @RequestMapping(method = RequestMethod.GET, value = "/searchPage")
    @ResponseBody
    public List<SaleOrderLine> search(@RequestParam(value = "search") String search, @RequestParam int page, @RequestParam int size) throws AttributesNotFound, ErrorType {
        if (null == userDetailsService.getWarehouses() || null==userDetailsService.getOwners()) {
            return null;
        }
        if (!search.endsWith(",")) {
            search += ",";
        }
        return saleOrderLineService.find(search + userDetailsService.getWarehouses().toString()+","+userDetailsService.getOwners().toString(), page,size);
    }

    @PreAuthorize("hasRole('SALE_ORDER_LINE_CREATE')")
    @RequestMapping(value = "/save", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public SaleOrderLine add(@RequestBody SaleOrderLine saleOrderLine) throws ProductControls {
        return saleOrderLineService.save(saleOrderLine);
    }

    @PreAuthorize("hasRole('SALE_ORDER_LINE_EDIT')")
    @RequestMapping(value = "/save", method = RequestMethod.PUT, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public SaleOrderLine set(@RequestBody SaleOrderLine saleOrderLine) throws ProductControls {
        return saleOrderLineService.save(saleOrderLine);
    }

    @PreAuthorize("hasRole('SALE_ORDER_LINE_DELETE')")
    @RequestMapping(value = "/delete", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public void delete(@RequestBody SaleOrderLine saleOrderLine) {

        saleOrderLineService.delete(saleOrderLine);
    }

    @PreAuthorize("hasRole('SALE_ORDER_LINE_DELETE')")
    @RequestMapping(value = "/delete/{id}", method = RequestMethod.DELETE, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public void delete(@PathVariable Long id) {
        saleOrderLineService.delete(id);
    }
}