package com.sinno.ems.controller;

import com.sinno.ems.exception.AttributesNotFound;
import com.sinno.ems.exception.ErrorType;
import com.sinno.ems.exception.IdNotFound;
import com.sinno.ems.service.ProductionLineService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.MediaType;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by Enissay on 03/04/2017.
 */
@Controller
@RequestMapping(value = "/productionLines/")
public class ProductionLineController {

    @Autowired
    private ProductionLineService productionLineService;

    @PreAuthorize("hasAnyRole('PRODUCTION_LINE_ORDER_VIEW','RECEPTION_VIEW')")
    @RequestMapping(method = RequestMethod.GET, value = "/list")
    @ResponseBody
    public List<ProductionLine> getProductionLines() throws AttributesNotFound, ErrorType {

        return productionLineService.findAll();
    }

    @PreAuthorize("hasAnyRole('PRODUCTION_LINE_ORDER_VIEW','RECEPTION_VIEW')")
    @RequestMapping(method = RequestMethod.GET, value = "/listPage")
    @ResponseBody
    public List<ProductionLine> getProductionLines(@RequestParam int page, @RequestParam int size) throws AttributesNotFound, ErrorType {
        Pageable pageable = new PageRequest(page, size);
        return productionLineService.findAll(pageable);
    }

    @PreAuthorize("hasAnyRole('PRODUCTION_LINE_ORDER_VIEW','RECEPTION_VIEW')")
    @RequestMapping(method = RequestMethod.GET, value = "/size")
    @ResponseBody
    public Long size() throws AttributesNotFound, ErrorType {
        return productionLineService.size();
    }

    @PreAuthorize("hasAnyRole('PRODUCTION_LINE_ORDER_VIEW','RECEPTION_VIEW')")
    @RequestMapping(method = RequestMethod.GET, value = "/sizeSearch")
    @ResponseBody
    public Long size(@RequestParam String search) throws AttributesNotFound, ErrorType {
        return productionLineService.size(search);
    }

    @PreAuthorize("hasAnyRole('PRODUCTION_LINE_ORDER_VIEW','RECEPTION_VIEW')")
    @RequestMapping(method = RequestMethod.GET, value = "/exist")
    @ResponseBody
    public Boolean exist(@RequestParam Long id) throws AttributesNotFound, ErrorType {
        return productionLineService.isExist(id);
    }

    @PreAuthorize("hasAnyRole('PRODUCTION_LINE_ORDER_VIEW','RECEPTION_VIEW')")
    @RequestMapping(method = RequestMethod.GET, value = "/{id}")
    @ResponseBody
    public ProductionLine getProductionLine(@PathVariable("id") Long id) throws IdNotFound {
        return productionLineService.findById(id);
    }

    @PreAuthorize("hasAnyRole('PRODUCTION_LINE_ORDER_VIEW','RECEPTION_VIEW')")
    @RequestMapping(method = RequestMethod.GET, value = "/search")
    @ResponseBody
    public List<ProductionLine> search(@RequestParam(value = "search") String search) throws AttributesNotFound, ErrorType {
        return productionLineService.find(search);
    }

    @PreAuthorize("hasAnyRole('PRODUCTION_LINE_ORDER_VIEW','RECEPTION_VIEW')")
    @RequestMapping(method = RequestMethod.GET, value = "/searchPage")
    @ResponseBody
    public List<ProductionLine> search(@RequestParam(value = "search") String search, @RequestParam int page, @RequestParam int size) throws AttributesNotFound, ErrorType {
        return productionLineService.find(search, page, size);
    }

    @PreAuthorize("hasRole('PRODUCTION_LINE_ORDER_CREATE')")
    @RequestMapping(value = "/save", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public ProductionLine add(@RequestBody ProductionLine productionLine) {
        return productionLineService.save(productionLine);
    }

    @PreAuthorize("hasRole('PRODUCTION_LINE_ORDER_EDIT')")
    @RequestMapping(value = "/save", method = RequestMethod.PUT, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public ProductionLine set(@RequestBody ProductionLine productionLine) {
        return productionLineService.save(productionLine);
    }

    @PreAuthorize("hasRole('PRODUCTION_LINE_ORDER_DELETE')")
    @RequestMapping(value = "/delete", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public void delete(@RequestBody ProductionLine productionLine) {

        productionLineService.delete(productionLine);
    }

    @PreAuthorize("hasRole('PRODUCTION_LINE_ORDER_DELETE')")
    @RequestMapping(value = "/delete/{id}", method = RequestMethod.DELETE, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public void delete(@PathVariable Long id) {
        productionLineService.delete(id);
    }

}