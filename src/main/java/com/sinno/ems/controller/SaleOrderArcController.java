package com.sinno.ems.controller;

import com.sinno.ems.dto.SaleOrderArc;
import com.sinno.ems.exception.AttributesNotFound;
import com.sinno.ems.exception.ErrorType;
import com.sinno.ems.exception.IdNotFound;
import com.sinno.ems.service.SaleOrderArcService;
import com.sinno.ems.service.UserDetailsServiceWarehouse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.MediaType;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping(value = "/saleOrderArcs/")
public class SaleOrderArcController {

    @Autowired
    private SaleOrderArcService saleOrderArcService;
    @Autowired
    @Qualifier("userDetailsService")
    private UserDetailsServiceWarehouse userDetailsService;

    @PreAuthorize("hasRole('SALE_ORDER_ARC_VIEW')")
    @RequestMapping(method = RequestMethod.GET,value = "/list")
    @ResponseBody
    public List<SaleOrderArc> getSaleOrderArcs() throws AttributesNotFound, ErrorType {
        if (null == userDetailsService.getWarehouses() || null ==userDetailsService.getOwners()){
            return null;
        }
        return saleOrderArcService.find(userDetailsService.getWarehouses().toString()+","+userDetailsService.getOwners().toString());
    }

    @PreAuthorize("hasRole('SALE_ORDER_ARC_VIEW')")
    @RequestMapping(method = RequestMethod.GET, value = "/listPage")
    @ResponseBody
    public List<SaleOrderArc> getSaleOrderArcs(@RequestParam int page, @RequestParam int size) throws AttributesNotFound, ErrorType {
        Pageable pageable = new PageRequest(page, size);
        if (null == userDetailsService.getWarehouses() || null== userDetailsService.getOwners()){
            return null;
        }
        return saleOrderArcService.find(userDetailsService.getWarehouses().toString()+","+userDetailsService.getOwners().toString(),pageable);
    }

    @PreAuthorize("hasRole('SALE_ORDER_ARC_VIEW')")
    @RequestMapping(method = RequestMethod.GET, value = "/size")
    @ResponseBody
    public Long size() throws AttributesNotFound, ErrorType {
        if (null == userDetailsService.getWarehouses() || null==userDetailsService.getOwners()){
            return null;
        }
        return saleOrderArcService.size(userDetailsService.getWarehouses().toString()+","+userDetailsService.getOwners().toString());
    }

    @PreAuthorize("hasRole('SALE_ORDER_ARC_VIEW')")
    @RequestMapping(method = RequestMethod.GET, value = "/sizeSearch")
    @ResponseBody
    public Long size(@RequestParam String search) throws AttributesNotFound, ErrorType {
        if (null == userDetailsService.getWarehouses() || null==userDetailsService.getOwners()){
            return null;
        }
        if (!search.endsWith(",")) {
            search += ",";
        }
        return saleOrderArcService.size(search+userDetailsService.getWarehouses().toString()+","+userDetailsService.getOwners().toString());
    }

    @PreAuthorize("hasRole('SALE_ORDER_ARC_VIEW')")
    @RequestMapping(method = RequestMethod.GET, value = "/exist")
    @ResponseBody
    public Boolean exist(@RequestParam Long id) throws AttributesNotFound, ErrorType {
        return saleOrderArcService.isExist(id);
    }    @PreAuthorize("hasRole('SALE_ORDER_ARC_VIEW')")
    @RequestMapping(method = RequestMethod.GET,value = "/{id}")
    @ResponseBody
    public SaleOrderArc getSaleOrderArc(@PathVariable("id") Long id) throws IdNotFound {
        return saleOrderArcService.findById(id);
    }

    @PreAuthorize("hasRole('SALE_ORDER_ARC_VIEW')")
    @RequestMapping(method = RequestMethod.GET, value = "/search")
    @ResponseBody
    public List<SaleOrderArc> search(@RequestParam(value = "search") String search) throws AttributesNotFound, ErrorType {
        if (null == userDetailsService.getWarehouses() || null==userDetailsService.getOwners()){
            return null;
        }
        if (!search.endsWith(",")) {
            search += ",";
        }
        return saleOrderArcService.find(search+userDetailsService.getWarehouses().toString()+","+userDetailsService.getOwners().toString());
    }

    @PreAuthorize("hasRole('SALE_ORDER_ARC_VIEW')")
    @RequestMapping(method = RequestMethod.GET, value = "/searchPage")
    @ResponseBody
    public List<SaleOrderArc> search(@RequestParam(value = "search") String search, @RequestParam int page, @RequestParam int size) throws AttributesNotFound, ErrorType {
        Pageable pageable = new PageRequest(page, size);
        if (null == userDetailsService.getWarehouses() || null==userDetailsService.getOwners()){
            return null;
        }
        if (!search.endsWith(",")) {
            search += ",";
        }
        return saleOrderArcService.find(search+userDetailsService.getWarehouses().toString()+","+userDetailsService.getOwners().toString(), pageable);
    }

    @PreAuthorize("hasRole('SALE_ORDER_ARC_CREATE')")
    @RequestMapping(value = "/save", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public SaleOrderArc add(@RequestBody SaleOrderArc saleOrderArc) {
        return saleOrderArcService.save(saleOrderArc);
    }

    @PreAuthorize("hasRole('SALE_ORDER_ARC_EDIT')")
    @RequestMapping(value = "/save", method = RequestMethod.PUT, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public SaleOrderArc set(@RequestBody SaleOrderArc saleOrderArc) {
        return saleOrderArcService.save(saleOrderArc);
    }

    @PreAuthorize("hasRole('SALE_ORDER_ARC_DELETE')")
    @RequestMapping(value = "/delete", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public void delete(@RequestBody SaleOrderArc saleOrderArc) {

        saleOrderArcService.delete(saleOrderArc);
    }

    @PreAuthorize("hasRole('SALE_ORDER_ARC_DELETE')")
    @RequestMapping(value = "/delete/{id}", method = RequestMethod.DELETE, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public void delete(@PathVariable Long id) {
        saleOrderArcService.delete(id);
    }
}