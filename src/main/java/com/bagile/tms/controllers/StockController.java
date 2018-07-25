package com.bagile.tms.controllers;

import com.bagile.tms.dto.Stock;
import com.bagile.tms.exceptions.AttributesNotFound;
import com.bagile.tms.exceptions.ErrorType;
import com.bagile.tms.exceptions.IdNotFound;
import com.bagile.tms.exceptions.ProductControls;
import com.bagile.tms.services.StockService;
import com.bagile.tms.services.UserDetailsServiceWarehouse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.MediaType;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping(value = "/stocks/")
public class StockController {

    @Autowired
    private StockService stockService;
    @Autowired
    @Qualifier("userDetailsService")
    private UserDetailsServiceWarehouse userDetailsService;

    @PreAuthorize("hasRole('STOCK_VIEW')")
    @RequestMapping(method = RequestMethod.GET, value = "/list")
    @ResponseBody
    public List<Stock> getStocks() throws AttributesNotFound, ErrorType {
        if (null == userDetailsService.getOwners()) {
            return null;
        }
        return stockService.find(userDetailsService.getOwners().toString());
        //return stockService.findAll();
    }

    @PreAuthorize("hasRole('STOCK_VIEW')")
    @RequestMapping(method = RequestMethod.GET, value = "/listPage")
    @ResponseBody
    public List<Stock> getStocks(@RequestParam int page, @RequestParam int size) throws AttributesNotFound, ErrorType {
        if (null == userDetailsService.getOwners()) {
            return null;
        }
        return stockService.find(userDetailsService.getOwners().toString(), page, size);
        //return stockService.findAll(pageable);
    }

    @PreAuthorize("hasRole('STOCK_VIEW')")
    @RequestMapping(method = RequestMethod.GET, value = "/size")
    @ResponseBody
    public Long size() throws AttributesNotFound, ErrorType {
        if (null == userDetailsService.getOwners()) {
            return null;
        }
        return stockService.size(userDetailsService.getOwners().toString());
    }

    @PreAuthorize("hasRole('STOCK_VIEW')")
    @RequestMapping(method = RequestMethod.GET, value = "/sizeSearch")
    @ResponseBody
    public Long size(@RequestParam String search) throws AttributesNotFound, ErrorType {
        if (null == userDetailsService.getWarehouses() || null == userDetailsService.getOwners()) {
            return null;
        }
        if (!search.endsWith(",")) {
            search += ",";
        }
        return stockService.size(search + userDetailsService.getOwners().toString());
    }

    @PreAuthorize("hasRole('STOCK_VIEW')")
    @RequestMapping(method = RequestMethod.GET, value = "/exist")
    @ResponseBody
    public Boolean exist(@RequestParam Long id) throws AttributesNotFound, ErrorType {
        return stockService.isExist(id);
    }

    @PreAuthorize("hasRole('STOCK_VIEW')")
    @RequestMapping(method = RequestMethod.GET, value = "/{id}")
    @ResponseBody
    public Stock getStock(@PathVariable("id") Long id) throws IdNotFound {
        return stockService.findById(id);
    }

    @PreAuthorize("hasRole('STOCK_VIEW')")
    @RequestMapping(method = RequestMethod.GET, value = "/search")
    @ResponseBody
    public List<Stock> search(@RequestParam(value = "search") String search) throws AttributesNotFound, ErrorType {
        if (null == userDetailsService.getOwners()) {
            return null;
        }
        if (!search.endsWith(",")) {
            search += ",";
        }
        return stockService.find(search + userDetailsService.getOwners().toString());
    }

    @PreAuthorize("hasRole('STOCK_VIEW')")
    @RequestMapping(method = RequestMethod.GET, value = "/searchPage")
    @ResponseBody
    public List<Stock> search(@RequestParam(value = "search") String search, @RequestParam int page, @RequestParam int size) throws AttributesNotFound, ErrorType {
        if (null == userDetailsService.getOwners()) {
            return null;
        }
        if (!search.endsWith(",")) {
            search += ",";
        }
        return stockService.find(search + userDetailsService.getOwners().toString(), page, size);
    }

    @PreAuthorize("hasRole('STOCK_CREATE')")
    @RequestMapping(value = "/save", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public Stock add(@RequestBody Stock stock) throws ProductControls {
        return stockService.save(stock);
    }

    @PreAuthorize("hasRole('STOCK_EDIT')")
    @RequestMapping(value = "/save", method = RequestMethod.PUT, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public Stock set(@RequestBody Stock stock) throws ProductControls {
        return stockService.save(stock);
    }

    @PreAuthorize("hasRole('STOCK_DELETE')")
    @RequestMapping(value = "/delete", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public void delete(@RequestBody Stock stock) {

        stockService.delete(stock);
    }

    @PreAuthorize("hasRole('STOCK_DELETE')")
    @RequestMapping(value = "/delete/{id}", method = RequestMethod.DELETE, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public void delete(@PathVariable Long id) {
        stockService.delete(id);
    }
}