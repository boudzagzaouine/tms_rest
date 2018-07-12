package com.sinno.ems.controller;

import com.sinno.ems.exception.AttributesNotFound;
import com.sinno.ems.exception.ErrorType;
import com.sinno.ems.exception.IdNotFound;
import com.sinno.ems.service.SaleOrderStockArcService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.MediaType;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping(value = "/saleOrderStockArcs/")
public class SaleOrderStockArcController {

    @Autowired
    private SaleOrderStockArcService saleOrderStockArcService;

    @PreAuthorize("hasRole('SALE_ORDER_STOCK_ARC_VIEW')")
    @RequestMapping(method = RequestMethod.GET,value = "/list")
    @ResponseBody
    public List<SaleOrderStockArc> getSaleOrderStockArcs() {
        return saleOrderStockArcService.findAll();
    }

    @PreAuthorize("hasRole('SALE_ORDER_STOCK_ARC_VIEW')")
    @RequestMapping(method = RequestMethod.GET, value = "/listPage")
    @ResponseBody
    public List<SaleOrderStockArc> getSaleOrderStockArcs(@RequestParam int page, @RequestParam int size) {
        Pageable pageable = new PageRequest(page, size);
        return saleOrderStockArcService.findAll(pageable);
    }

    @PreAuthorize("hasRole('SALE_ORDER_STOCK_ARC_VIEW')")
    @RequestMapping(method = RequestMethod.GET, value = "/size")
    @ResponseBody
    public Long size() {
        return saleOrderStockArcService.size();
    }

    @PreAuthorize("hasRole('SALE_ORDER_STOCK_ARC_VIEW')")
    @RequestMapping(method = RequestMethod.GET, value = "/sizeSearch")
    @ResponseBody
    public Long size(@RequestParam String search) throws AttributesNotFound, ErrorType {
        return saleOrderStockArcService.size(search);
    }

    @PreAuthorize("hasRole('SALE_ORDER_STOCK_ARC_VIEW')")
    @RequestMapping(method = RequestMethod.GET, value = "/exist")
    @ResponseBody
    public Boolean exist(@RequestParam Long id) throws AttributesNotFound, ErrorType {
        return saleOrderStockArcService.isExist(id);
    }    @PreAuthorize("hasRole('SALE_ORDER_STOCK_ARC_VIEW')")
    @RequestMapping(method = RequestMethod.GET,value = "/{id}")
    @ResponseBody
    public SaleOrderStockArc getSaleOrderStockArc(@PathVariable("id") Long id) throws IdNotFound {
        return saleOrderStockArcService.findById(id);
    }

    @PreAuthorize("hasRole('SALE_ORDER_STOCK_ARC_VIEW')")
    @RequestMapping(method = RequestMethod.GET, value = "/search")
    @ResponseBody
    public List<SaleOrderStockArc> search(@RequestParam(value = "search") String search) throws AttributesNotFound, ErrorType {
        return saleOrderStockArcService.find(search);
    }

    @PreAuthorize("hasRole('SALE_ORDER_STOCK_ARC_VIEW')")
    @RequestMapping(method = RequestMethod.GET, value = "/searchPage")
    @ResponseBody
    public List<SaleOrderStockArc> search(@RequestParam(value = "search") String search, @RequestParam int page, @RequestParam int size) throws AttributesNotFound, ErrorType {
        Pageable pageable = new PageRequest(page, size);
        return saleOrderStockArcService.find(search, pageable);
    }

    @PreAuthorize("hasRole('SALE_ORDER_STOCK_ARC_CREATE')")
    @RequestMapping(value = "/save", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public SaleOrderStockArc add(@RequestBody SaleOrderStockArc saleOrderStockArc) {
        return saleOrderStockArcService.save(saleOrderStockArc);
    }

    @PreAuthorize("hasRole('SALE_ORDER_STOCK_ARC_EDIT')")
    @RequestMapping(value = "/save", method = RequestMethod.PUT, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public SaleOrderStockArc set(@RequestBody SaleOrderStockArc saleOrderStockArc) {
        return saleOrderStockArcService.save(saleOrderStockArc);
    }

    @PreAuthorize("hasRole('SALE_ORDER_STOCK_ARC_DELETE')")
    @RequestMapping(value = "/delete", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public void delete(@RequestBody SaleOrderStockArc saleOrderStockArc) {

        saleOrderStockArcService.delete(saleOrderStockArc);
    }

    @PreAuthorize("hasRole('SALE_ORDER_STOCK_ARC_DELETE')")
    @RequestMapping(value = "/delete/{id}", method = RequestMethod.DELETE, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public void delete(@PathVariable Long id) {
        saleOrderStockArcService.delete(id);
    }
}