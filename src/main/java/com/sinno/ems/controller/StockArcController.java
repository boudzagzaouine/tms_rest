package com.sinno.ems.controller;

import com.sinno.ems.exception.AttributesNotFound;
import com.sinno.ems.exception.ErrorType;
import com.sinno.ems.exception.IdNotFound;
import com.sinno.ems.service.StockArcService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.MediaType;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping(value = "/stockArcs/")
public class StockArcController {

    @Autowired
    private StockArcService stockArcService;

    @PreAuthorize("hasRole('STOCK_ARC_VIEW')")
    @RequestMapping(method = RequestMethod.GET,value = "/list")
    @ResponseBody
    public List<StockArc> getStockArcs() {
        return stockArcService.findAll();
    }

    @PreAuthorize("hasRole('STOCK_ARC_VIEW')")
    @RequestMapping(method = RequestMethod.GET, value = "/listPage")
    @ResponseBody
    public List<StockArc> getStockArcs(@RequestParam int page, @RequestParam int size) {
        Pageable pageable = new PageRequest(page, size);
        return stockArcService.findAll(pageable);
    }

    @PreAuthorize("hasRole('STOCK_ARC_VIEW')")
    @RequestMapping(method = RequestMethod.GET, value = "/size")
    @ResponseBody
    public Long size() {
        return stockArcService.size();
    }

    @PreAuthorize("hasRole('STOCK_ARC_VIEW')")
    @RequestMapping(method = RequestMethod.GET, value = "/sizeSearch")
    @ResponseBody
    public Long size(@RequestParam String search) throws AttributesNotFound, ErrorType {
        return stockArcService.size(search);
    }

    @PreAuthorize("hasRole('STOCK_ARC_VIEW')")
    @RequestMapping(method = RequestMethod.GET, value = "/exist")
    @ResponseBody
    public Boolean exist(@RequestParam Long id) throws AttributesNotFound, ErrorType {
        return stockArcService.isExist(id);
    }    @PreAuthorize("hasRole('STOCK_ARC_VIEW')")
    @RequestMapping(method = RequestMethod.GET,value = "/{id}")
    @ResponseBody
    public StockArc getStockArc(@PathVariable("id") Long id) throws IdNotFound {
        return stockArcService.findById(id);
    }

    @PreAuthorize("hasRole('STOCK_ARC_VIEW')")
    @RequestMapping(method = RequestMethod.GET, value = "/search")
    @ResponseBody
    public List<StockArc> search(@RequestParam(value = "search") String search) throws AttributesNotFound, ErrorType {
        return stockArcService.find(search);
    }

    @PreAuthorize("hasRole('STOCK_ARC_VIEW')")
    @RequestMapping(method = RequestMethod.GET, value = "/searchPage")
    @ResponseBody
    public List<StockArc> search(@RequestParam(value = "search") String search, @RequestParam int page, @RequestParam int size) throws AttributesNotFound, ErrorType {
        Pageable pageable = new PageRequest(page, size);
        return stockArcService.find(search, pageable);
    }

    @PreAuthorize("hasRole('STOCK_ARC_CREATE')")
    @RequestMapping(value = "/save", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public StockArc add(@RequestBody StockArc stockArc) {
        return stockArcService.save(stockArc);
    }

    @PreAuthorize("hasRole('STOCK_ARC_EDIT')")
    @RequestMapping(value = "/save", method = RequestMethod.PUT, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public StockArc set(@RequestBody StockArc stockArc) {
        return stockArcService.save(stockArc);
    }

    @PreAuthorize("hasRole('STOCK_ARC_DELETE')")
    @RequestMapping(value = "/delete", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public void delete(@RequestBody StockArc stockArc) {

        stockArcService.delete(stockArc);
    }

    @PreAuthorize("hasRole('STOCK_ARC_DELETE')")
    @RequestMapping(value = "/delete/{id}", method = RequestMethod.DELETE, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public void delete(@PathVariable Long id) {
        stockArcService.delete(id);
    }
}