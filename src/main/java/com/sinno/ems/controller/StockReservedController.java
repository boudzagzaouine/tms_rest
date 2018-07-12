package com.sinno.ems.controller;

import com.sinno.ems.exception.AttributesNotFound;
import com.sinno.ems.exception.ErrorType;
import com.sinno.ems.exception.IdNotFound;
import com.sinno.ems.service.StockReservedService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.MediaType;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping(value = "/stockReserveds/")
public class StockReservedController {

    @Autowired
    private StockReservedService stockReservedService;

    @PreAuthorize("hasRole('STOCK_RESERVED_VIEW')")
    @RequestMapping(method = RequestMethod.GET,value = "/list")
    @ResponseBody
    public List<StockReserved> getStockReserveds() {
        return stockReservedService.findAll();
    }

    @PreAuthorize("hasRole('STOCK_RESERVED_VIEW')")
    @RequestMapping(method = RequestMethod.GET, value = "/listPage")
    @ResponseBody
    public List<StockReserved> getStockReserveds(@RequestParam int page, @RequestParam int size) {
        Pageable pageable = new PageRequest(page, size);
        return stockReservedService.findAll(pageable);
    }

    @PreAuthorize("hasRole('STOCK_RESERVED_VIEW')")
    @RequestMapping(method = RequestMethod.GET, value = "/size")
    @ResponseBody
    public Long size() {
        return stockReservedService.size();
    }

    @PreAuthorize("hasRole('STOCK_RESERVED_VIEW')")
    @RequestMapping(method = RequestMethod.GET, value = "/sizeSearch")
    @ResponseBody
    public Long size(@RequestParam String search) throws AttributesNotFound, ErrorType {
        return stockReservedService.size(search);
    }

    @PreAuthorize("hasRole('STOCK_RESERVED_VIEW')")
    @RequestMapping(method = RequestMethod.GET, value = "/exist")
    @ResponseBody
    public Boolean exist(@RequestParam Long id) throws AttributesNotFound, ErrorType {
        return stockReservedService.isExist(id);
    }    @PreAuthorize("hasRole('STOCK_RESERVED_VIEW')")
    @RequestMapping(method = RequestMethod.GET,value = "/{id}")
    @ResponseBody
    public StockReserved getStockReserved(@PathVariable("id") Long id) throws IdNotFound {
        return stockReservedService.findById(id);
    }

    @PreAuthorize("hasRole('STOCK_RESERVED_VIEW')")
    @RequestMapping(method = RequestMethod.GET, value = "/search")
    @ResponseBody
    public List<StockReserved> search(@RequestParam(value = "search") String search) throws AttributesNotFound, ErrorType {
        return stockReservedService.find(search);
    }

    @PreAuthorize("hasRole('STOCK_RESERVED_VIEW')")
    @RequestMapping(method = RequestMethod.GET, value = "/searchPage")
    @ResponseBody
    public List<StockReserved> search(@RequestParam(value = "search") String search, @RequestParam int page, @RequestParam int size) throws AttributesNotFound, ErrorType {
        Pageable pageable = new PageRequest(page, size);
        return stockReservedService.find(search, pageable);
    }

    @PreAuthorize("hasRole('STOCK_RESERVED_CREATE')")
    @RequestMapping(value = "/save", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public StockReserved add(@RequestBody StockReserved stockReserved) {
        return stockReservedService.save(stockReserved);
    }

    @PreAuthorize("hasRole('STOCK_RESERVED_EDIT')")
    @RequestMapping(value = "/save", method = RequestMethod.PUT, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public StockReserved set(@RequestBody StockReserved stockReserved) {
        return stockReservedService.save(stockReserved);
    }

    @PreAuthorize("hasRole('STOCK_RESERVED_DELETE')")
    @RequestMapping(value = "/delete", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public void delete(@RequestBody StockReserved stockReserved) {

        stockReservedService.delete(stockReserved);
    }

    @PreAuthorize("hasRole('STOCK_RESERVED_DELETE')")
    @RequestMapping(value = "/delete/{id}", method = RequestMethod.DELETE, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public void delete(@PathVariable Long id) {
        stockReservedService.delete(id);
    }
}