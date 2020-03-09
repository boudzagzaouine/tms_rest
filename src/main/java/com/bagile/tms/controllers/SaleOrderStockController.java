package com.bagile.tms.controllers;

import com.bagile.tms.dto.CommissionDriver;
import com.bagile.tms.dto.SaleOrderStock;
import com.bagile.tms.exceptions.*;
import com.bagile.tms.services.SaleOrderStockService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.MediaType;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping(value = "/saleOrderStocks/")
public class SaleOrderStockController {

    private SaleOrderStockService saleOrderStockService;

    @PreAuthorize("hasRole('SALE_ORDER_STOCK_VIEW')")
    @RequestMapping(method = RequestMethod.GET,value = "/list")
    @ResponseBody
    public List<SaleOrderStock> getSaleOrderStocks() {
        return saleOrderStockService.findAll();
    }

    @PreAuthorize("hasRole('SALE_ORDER_STOCK_VIEW')")
    @RequestMapping(method = RequestMethod.GET, value = "/listPage")
    @ResponseBody
    public List<SaleOrderStock> getSaleOrderStocks(@RequestParam int page, @RequestParam int size) {

        return saleOrderStockService.findAll(page,size);
    }

    @PreAuthorize("hasRole('SALE_ORDER_STOCK_VIEW')")
    @RequestMapping(method = RequestMethod.GET, value = "/size")
    @ResponseBody
    public Long size() {
        return saleOrderStockService.size();
    }

    @PreAuthorize("hasRole('SALE_ORDER_STOCK_VIEW')")
    @RequestMapping(method = RequestMethod.GET, value = "/sizeSearch")
    @ResponseBody
    public Long size(@RequestParam String search) throws AttributesNotFound, ErrorType {
        return saleOrderStockService.size(search);
    }

    @PreAuthorize("hasRole('SALE_ORDER_STOCK_VIEW')")
    @RequestMapping(method = RequestMethod.GET, value = "/exist")
    @ResponseBody
    public Boolean exist(@RequestParam Long id) throws AttributesNotFound, ErrorType {
        return saleOrderStockService.isExist(id);
    }    @PreAuthorize("hasRole('SALE_ORDER_STOCK_VIEW')")
    @RequestMapping(method = RequestMethod.GET,value = "/{id}")
    @ResponseBody
    public SaleOrderStock getSaleOrderStock(@PathVariable("id") Long id) throws IdNotFound {
        return saleOrderStockService.findById(id);
    }

    @PreAuthorize("hasRole('SALE_ORDER_STOCK_VIEW')")
    @RequestMapping(method = RequestMethod.GET, value = "/search")
    @ResponseBody
    public List<SaleOrderStock> search(@RequestParam(value = "search") String search) throws AttributesNotFound, ErrorType {
        return saleOrderStockService.find(search);
    }

    @PreAuthorize("hasRole('SALE_ORDER_STOCK_VIEW')")
    @RequestMapping(method = RequestMethod.GET, value = "/searchPage")
    @ResponseBody
    public List<SaleOrderStock> search(@RequestParam(value = "search") String search, @RequestParam int page, @RequestParam int size) throws AttributesNotFound, ErrorType {
        Pageable pageable =  PageRequest.of(page, size);
        return saleOrderStockService.find(search, page,size);

    }

    @PreAuthorize("hasRole('SALE_ORDER_STOCK_CREATE')")
    @RequestMapping(value = "/save", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public SaleOrderStock add(@RequestBody SaleOrderStock saleOrderStock) throws ProductControls, IdNotFound, CustomException, AttributesNotFound, ErrorType {
        return saleOrderStockService.save(saleOrderStock);
    }

    @PreAuthorize("hasRole('SALE_ORDER_STOCK_CREATE')")
    @RequestMapping(value = "/posSave", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public SaleOrderStock addPos(@RequestBody SaleOrderStock saleOrderStock) throws ProductControls, IdNotFound, CustomException, AttributesNotFound, ErrorType {
        return saleOrderStockService.save(saleOrderStock);
    }
    @PreAuthorize("hasRole('SALE_ORDER_STOCK_EDIT')")
    @RequestMapping(value = "/save", method = RequestMethod.PUT, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public SaleOrderStock set(@RequestBody SaleOrderStock saleOrderStock) throws ProductControls, IdNotFound, CustomException, AttributesNotFound, ErrorType {
        return saleOrderStockService.save(saleOrderStock);
    }

    @PreAuthorize("hasRole('SALE_ORDER_STOCK_DELETE')")
    @RequestMapping(value = "/delete", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public void delete(@RequestBody SaleOrderStock saleOrderStock) {

        saleOrderStockService.delete(saleOrderStock);
    }

    @PreAuthorize("hasRole('SALE_ORDER_STOCK_DELETE')")
    @RequestMapping(value = "/delete/{id}", method = RequestMethod.DELETE, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public void delete(@PathVariable Long id) {
        saleOrderStockService.delete(id);
    }

    @RequestMapping(value = "/saveALL", method = RequestMethod.POST)
    @ResponseBody
    public List<SaleOrderStock> saveAll(@RequestBody List<SaleOrderStock> saleOrderStockList) {
        return saleOrderStockService.saveAll(saleOrderStockList, true);
    }
}