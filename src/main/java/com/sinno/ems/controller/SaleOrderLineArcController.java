package com.sinno.ems.controller;

import com.sinno.ems.dto.SaleOrderLineArc;
import com.sinno.ems.exception.AttributesNotFound;
import com.sinno.ems.exception.ErrorType;
import com.sinno.ems.exception.IdNotFound;
import com.sinno.ems.service.SaleOrderLineArcService;
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
@RequestMapping(value = "/saleOrderLineArcs/")
public class SaleOrderLineArcController {

    @Autowired
    private SaleOrderLineArcService saleOrderLineArcService;
    @Autowired
    @Qualifier("userDetailsService")
    private UserDetailsServiceWarehouse userDetailsService;

    @PreAuthorize("hasRole('SALE_ORDER_LINE_ARC_VIEW')")
    @RequestMapping(method = RequestMethod.GET,value = "/list")
    @ResponseBody
    public List<SaleOrderLineArc> getSaleOrderLineArcs() throws AttributesNotFound, ErrorType {

        if (null == userDetailsService.getWarehouses()){
            return null;
        }
        return saleOrderLineArcService.find(userDetailsService.getWarehouses().toString());
    }

    @PreAuthorize("hasRole('SALE_ORDER_LINE_ARC_VIEW')")
    @RequestMapping(method = RequestMethod.GET, value = "/listPage")
    @ResponseBody
    public List<SaleOrderLineArc> getSaleOrderLineArcs(@RequestParam int page, @RequestParam int size) throws AttributesNotFound, ErrorType {
        Pageable pageable = new PageRequest(page, size);
        if (null == userDetailsService.getWarehouses()){
            return null;
        }
        return saleOrderLineArcService.find(userDetailsService.getWarehouses().toString(),pageable);
    }

    @PreAuthorize("hasRole('SALE_ORDER_LINE_ARC_VIEW')")
    @RequestMapping(method = RequestMethod.GET, value = "/size")
    @ResponseBody
    public Long size() throws AttributesNotFound, ErrorType {
        if (null == userDetailsService.getWarehouses()){
            return null;
        }
        return saleOrderLineArcService.size(userDetailsService.getWarehouses().toString());
    }

    @PreAuthorize("hasRole('SALE_ORDER_LINE_ARC_VIEW')")
    @RequestMapping(method = RequestMethod.GET, value = "/sizeSearch")
    @ResponseBody
    public Long size(@RequestParam String search) throws AttributesNotFound, ErrorType {
        if (null == userDetailsService.getWarehouses()){
            return null;
        }
        return saleOrderLineArcService.size(search+userDetailsService.getWarehouses().toString());
    }

    @PreAuthorize("hasRole('SALE_ORDER_LINE_ARC_VIEW')")
    @RequestMapping(method = RequestMethod.GET, value = "/exist")
    @ResponseBody
    public Boolean exist(@RequestParam Long id) throws AttributesNotFound, ErrorType {
        return saleOrderLineArcService.isExist(id);
    }    @PreAuthorize("hasRole('SALE_ORDER_LINE_ARC_VIEW')")
    @RequestMapping(method = RequestMethod.GET,value = "/{id}")
    @ResponseBody
    public SaleOrderLineArc getSaleOrderLineArc(@PathVariable("id") Long id) throws IdNotFound {
        return saleOrderLineArcService.findById(id);
    }

    @PreAuthorize("hasRole('SALE_ORDER_LINE_ARC_VIEW')")
    @RequestMapping(method = RequestMethod.GET, value = "/search")
    @ResponseBody
    public List<SaleOrderLineArc> search(@RequestParam(value = "search") String search) throws AttributesNotFound, ErrorType {
        if (null == userDetailsService.getWarehouses()){
            return null;
        }
        if (!search.endsWith(",")) {
            search += ",";
        }
        return saleOrderLineArcService.find(search+userDetailsService.getWarehouses().toString());
    }

    @PreAuthorize("hasRole('SALE_ORDER_LINE_ARC_VIEW')")
    @RequestMapping(method = RequestMethod.GET, value = "/searchPage")
    @ResponseBody
    public List<SaleOrderLineArc> search(@RequestParam(value = "search") String search, @RequestParam int page, @RequestParam int size) throws AttributesNotFound, ErrorType {
        Pageable pageable = new PageRequest(page, size);
        if (null == userDetailsService.getWarehouses()){
            return null;
        }
        if (!search.endsWith(",")) {
            search += ",";
        }
        return saleOrderLineArcService.find(search+userDetailsService.getWarehouses().toString(), pageable);
    }

    @PreAuthorize("hasRole('SALE_ORDER_LINE_ARC_CREATE')")
    @RequestMapping(value = "/save", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public SaleOrderLineArc add(@RequestBody SaleOrderLineArc saleOrderLineArc) {
        return saleOrderLineArcService.save(saleOrderLineArc);
    }

    @PreAuthorize("hasRole('SALE_ORDER_LINE_ARC_EDIT')")
    @RequestMapping(value = "/save", method = RequestMethod.PUT, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public SaleOrderLineArc set(@RequestBody SaleOrderLineArc saleOrderLineArc) {
        return saleOrderLineArcService.save(saleOrderLineArc);
    }

    @PreAuthorize("hasRole('SALE_ORDER_LINE_ARC_DELETE')")
    @RequestMapping(value = "/delete", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public void delete(@RequestBody SaleOrderLineArc saleOrderLineArc) {

        saleOrderLineArcService.delete(saleOrderLineArc);
    }

    @PreAuthorize("hasRole('SALE_ORDER_LINE_ARC_DELETE')")
    @RequestMapping(value = "/delete/{id}", method = RequestMethod.DELETE, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public void delete(@PathVariable Long id) {
        saleOrderLineArcService.delete(id);
    }
}