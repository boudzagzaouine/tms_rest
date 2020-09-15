package com.bagile.gmo.controllers;

import com.bagile.gmo.dto.MaintenanceStock;
import com.bagile.gmo.exceptions.*;
import com.bagile.gmo.services.MaintenanceStockService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping(value = "/maintenanceStocks/")
public class MaintenanceStockController {

    @Autowired
    private MaintenanceStockService maintenanceStockService;

    @RequestMapping(method = RequestMethod.GET,value = "/list")
    @ResponseBody
    public List<MaintenanceStock> getMaintenanceStocks() {
        return maintenanceStockService.findAll();
    }

@RequestMapping(method = RequestMethod.GET, value = "/listPage")
    @ResponseBody
    public List<MaintenanceStock> getMaintenanceStocks(@RequestParam int page, @RequestParam int size) {
        Pageable pageable =  PageRequest.of(page, size);
        return maintenanceStockService.findAll(pageable);
    }

@RequestMapping(method = RequestMethod.GET, value = "/size")
    @ResponseBody
    public Long size() {
        return maintenanceStockService.size();
    }

@RequestMapping(method = RequestMethod.GET, value = "/sizeSearch")
    @ResponseBody
    public Long size(@RequestParam String search) throws AttributesNotFound, ErrorType {
        return maintenanceStockService.size(search);
    }

@RequestMapping(method = RequestMethod.GET, value = "/exist")
    @ResponseBody
    public Boolean exist(@RequestParam Long id) throws AttributesNotFound, ErrorType {
        return maintenanceStockService.isExist(id);
    }@RequestMapping(method = RequestMethod.GET,value = "/{id}")
    @ResponseBody
    public MaintenanceStock getMaintenanceStock(@PathVariable("id") Long id) throws IdNotFound {
        return maintenanceStockService.findById(id);
    }

@RequestMapping(method = RequestMethod.GET, value = "/search")
    @ResponseBody
    public List<MaintenanceStock> search(@RequestParam(value = "search") String search) throws AttributesNotFound, ErrorType {
        return maintenanceStockService.find(search);
    }

@RequestMapping(method = RequestMethod.GET, value = "/searchPage")
    @ResponseBody
    public List<MaintenanceStock> search(@RequestParam(value = "search") String search, @RequestParam int page, @RequestParam int size) throws AttributesNotFound, ErrorType {
        Pageable pageable =  PageRequest.of(page, size);
        return maintenanceStockService.find(search, pageable);
    }

    @RequestMapping(value = "/save", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public MaintenanceStock add(@RequestBody MaintenanceStock MaintenanceStock) throws ProductControls, IdNotFound, CustomException, AttributesNotFound, ErrorType, CustomException {
        return maintenanceStockService.save(MaintenanceStock);
    }

    @RequestMapping(value = "/posSave", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public MaintenanceStock addPos(@RequestBody MaintenanceStock MaintenanceStock) throws ProductControls, IdNotFound, CustomException, AttributesNotFound, ErrorType {
        return maintenanceStockService.save(MaintenanceStock);
    }
    @RequestMapping(value = "/save", method = RequestMethod.PUT, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public MaintenanceStock set(@RequestBody MaintenanceStock MaintenanceStock) throws ProductControls, IdNotFound, CustomException, AttributesNotFound, ErrorType {
        return maintenanceStockService.save(MaintenanceStock);
    }

    @RequestMapping(value = "/delete", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public void delete(@RequestBody MaintenanceStock MaintenanceStock) {

        maintenanceStockService.delete(MaintenanceStock);
    }

    @RequestMapping(value = "/delete/{id}", method = RequestMethod.DELETE, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public void delete(@PathVariable Long id) {
        maintenanceStockService.delete(id);
    }

    @RequestMapping(value = "/saveALL", method = RequestMethod.POST)
    @ResponseBody
    public List<MaintenanceStock> saveAll(@RequestBody List<MaintenanceStock> MaintenanceStockList) {
        return maintenanceStockService.saveAll(MaintenanceStockList);
    }
}