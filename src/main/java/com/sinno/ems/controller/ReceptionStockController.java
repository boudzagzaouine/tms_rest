package com.sinno.ems.controller;

import com.sinno.ems.dto.ReceptionStock;
import com.sinno.ems.exception.*;
import com.sinno.ems.service.ReceptionStockService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.MediaType;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping(value = "/receptionStocks/")
public class ReceptionStockController {

    @Autowired
    private ReceptionStockService receptionStockService;

    @PreAuthorize("hasRole('RECEPTION_STOCK_VIEW')")
    @RequestMapping(method = RequestMethod.GET,value = "/list")
    @ResponseBody
    public List<ReceptionStock> getReceptionStocks() {
        return receptionStockService.findAll();
    }

    @PreAuthorize("hasRole('RECEPTION_STOCK_VIEW')")
    @RequestMapping(method = RequestMethod.GET, value = "/listPage")
    @ResponseBody
    public List<ReceptionStock> getReceptionStocks(@RequestParam int page, @RequestParam int size) {
        Pageable pageable = new PageRequest(page, size);
        return receptionStockService.findAll(pageable);
    }

    @PreAuthorize("hasRole('RECEPTION_STOCK_VIEW')")
    @RequestMapping(method = RequestMethod.GET, value = "/size")
    @ResponseBody
    public Long size() {
        return receptionStockService.size();
    }

    @PreAuthorize("hasRole('RECEPTION_STOCK_VIEW')")
    @RequestMapping(method = RequestMethod.GET, value = "/sizeSearch")
    @ResponseBody
    public Long size(@RequestParam String search) throws AttributesNotFound, ErrorType {
        return receptionStockService.size(search);
    }

    @PreAuthorize("hasRole('RECEPTION_STOCK_VIEW')")
    @RequestMapping(method = RequestMethod.GET, value = "/exist")
    @ResponseBody
    public Boolean exist(@RequestParam Long id) throws AttributesNotFound, ErrorType {
        return receptionStockService.isExist(id);
    }    @PreAuthorize("hasRole('RECEPTION_STOCK_VIEW')")
    @RequestMapping(method = RequestMethod.GET,value = "/{id}")
    @ResponseBody
    public ReceptionStock getReceptionStock(@PathVariable("id") Long id) throws IdNotFound {
        return receptionStockService.findById(id);
    }

    @PreAuthorize("hasRole('RECEPTION_STOCK_VIEW')")
    @RequestMapping(method = RequestMethod.GET, value = "/search")
    @ResponseBody
    public List<ReceptionStock> search(@RequestParam(value = "search") String search) throws AttributesNotFound, ErrorType {
        return receptionStockService.find(search);
    }

    @PreAuthorize("hasRole('RECEPTION_STOCK_VIEW')")
    @RequestMapping(method = RequestMethod.GET, value = "/searchPage")
    @ResponseBody
    public List<ReceptionStock> search(@RequestParam(value = "search") String search, @RequestParam int page, @RequestParam int size) throws AttributesNotFound, ErrorType {
        Pageable pageable = new PageRequest(page, size);
        return receptionStockService.find(search, pageable);
    }

    @PreAuthorize("hasRole('RECEPTION_STOCK_CREATE')")
    @RequestMapping(value = "/save", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public ReceptionStock add(@RequestBody ReceptionStock receptionStock) throws AttributesNotFound, ErrorType, ContainerException, ProductControls {
        return receptionStockService.save(receptionStock);
    }

    @PreAuthorize("hasRole('RECEPTION_STOCK_EDIT')")
    @RequestMapping(value = "/save", method = RequestMethod.PUT, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public ReceptionStock set(@RequestBody ReceptionStock receptionStock) throws AttributesNotFound, ErrorType, ContainerException, ProductControls {
        return receptionStockService.save(receptionStock);
    }

    @PreAuthorize("hasRole('RECEPTION_STOCK_DELETE')")
    @RequestMapping(value = "/delete", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public void delete(@RequestBody ReceptionStock receptionStock) {

        receptionStockService.delete(receptionStock);
    }

    @PreAuthorize("hasRole('RECEPTION_STOCK_DELETE')")
    @RequestMapping(value = "/delete/{id}", method = RequestMethod.DELETE, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public void delete(@PathVariable Long id) {
        receptionStockService.delete(id);
    }





}