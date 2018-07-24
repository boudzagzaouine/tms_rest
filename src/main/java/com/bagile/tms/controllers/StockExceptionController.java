package com.bagile.tms.controllers;

import com.sinno.ems.exception.AttributesNotFound;
import com.sinno.ems.exception.ErrorType;
import com.sinno.ems.exception.IdNotFound;
import com.sinno.ems.service.StockExceptionService;
import com.sinno.ems.service.UserDetailsServiceWarehouse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.MediaType;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by ASMAE on 28/04/2016.
 */

@Controller
@RequestMapping(value = "/stockExceptions/")
public class StockExceptionController {

    @Autowired
    private StockExceptionService stockExceptionService;
    @Autowired
    @Qualifier("userDetailsService")
    private UserDetailsServiceWarehouse userDetailsService;

    @PreAuthorize("hasRole('STOCK_VIEW')")
    @RequestMapping(method = RequestMethod.GET, value = "/list")
    @ResponseBody
    public List<StockException> getStocks() throws AttributesNotFound, ErrorType {
        if (null == userDetailsService.getOwners()) {
            return null;
        }
        return stockExceptionService.find( userDetailsService.getOwners().toString());
        //return stockService.findAll();
    }

    @PreAuthorize("hasRole('STOCK_VIEW')")
    @RequestMapping(method = RequestMethod.GET, value = "/listPage")
    @ResponseBody
    public List<StockException> getStocks(@RequestParam int page, @RequestParam int size) throws AttributesNotFound, ErrorType {
        if ( null == userDetailsService.getOwners()) {
            return null;
        }
        Sort sort = new Sort(Sort.Direction.DESC, "stkStockExceptionCreationDateNew");
        Pageable pageable = new PageRequest(page, size, sort);
        return stockExceptionService.find(userDetailsService.getOwners().toString(), pageable);
        //return stockService.findAll(pageable);
    }

    @PreAuthorize("hasRole('STOCK_VIEW')")
    @RequestMapping(method = RequestMethod.GET, value = "/size")
    @ResponseBody
    public Long size() throws AttributesNotFound, ErrorType {
        if ( null == userDetailsService.getOwners()) {
            return null;
        }
        return stockExceptionService.size( userDetailsService.getOwners().toString());
    }

    @PreAuthorize("hasRole('STOCK_VIEW')")
    @RequestMapping(method = RequestMethod.GET, value = "/sizeSearch")
    @ResponseBody
    public Long size(@RequestParam String search) throws AttributesNotFound, ErrorType {
        if ( null == userDetailsService.getOwners()) {
            return null;
        }
        if (!search.endsWith(",")) {
            search += ",";
        }
        return stockExceptionService.size(search + userDetailsService.getOwners().toString());
    }

    @PreAuthorize("hasRole('STOCK_VIEW')")
    @RequestMapping(method = RequestMethod.GET, value = "/exist")
    @ResponseBody
    public Boolean exist(@RequestParam Long id) throws AttributesNotFound, ErrorType {
        return stockExceptionService.isExist(id);
    }

    @PreAuthorize("hasRole('STOCK_VIEW')")
    @RequestMapping(method = RequestMethod.GET, value = "/{id}")
    @ResponseBody
    public StockException getStock(@PathVariable("id") Long id) throws IdNotFound {
        return stockExceptionService.findById(id);
    }

    @PreAuthorize("hasRole('STOCK_VIEW')")
    @RequestMapping(method = RequestMethod.GET, value = "/search")
    @ResponseBody
    public List<StockException> search(@RequestParam(value = "search") String search) throws AttributesNotFound, ErrorType {
        if (null == userDetailsService.getOwners()) {
            return null;
        }
        if (!search.endsWith(",")) {
            search += ",";
        }
        return stockExceptionService.find(search + userDetailsService.getOwners().toString());
    }

    @PreAuthorize("hasRole('STOCK_VIEW')")
    @RequestMapping(method = RequestMethod.GET, value = "/searchPage")
    @ResponseBody
    public List<StockException> search(@RequestParam(value = "search") String search, @RequestParam int page, @RequestParam int size) throws AttributesNotFound, ErrorType {
        if (null == userDetailsService.getOwners()) {
            return null;
        }
        if (!search.endsWith(",")) {
            search += ",";
        }
        Sort sort = new Sort(Sort.Direction.DESC, "stkStockExceptionCreationDateNew");
        Pageable pageable = new PageRequest(page, size, sort);
        return stockExceptionService.find(search + userDetailsService.getOwners().toString(), pageable);
    }

    @PreAuthorize("hasRole('STOCK_CREATE')")
    @RequestMapping(value = "/save", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public StockException add(@RequestBody StockException stock) {
        return stockExceptionService.save(stock);
    }

    @PreAuthorize("hasRole('STOCK_EDIT')")
    @RequestMapping(value = "/save", method = RequestMethod.PUT, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public StockException set(@RequestBody StockException stock) {
        return stockExceptionService.save(stock);
    }

    @PreAuthorize("hasRole('STOCK_DELETE')")
    @RequestMapping(value = "/delete", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public void delete(@RequestBody StockException stock) {

        stockExceptionService.delete(stock);
    }

    @PreAuthorize("hasRole('STOCK_DELETE')")
    @RequestMapping(value = "/delete/{id}", method = RequestMethod.DELETE, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public void delete(@PathVariable Long id) {
        stockExceptionService.delete(id);
    }
}
