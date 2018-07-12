package com.sinno.ems.controller;

import com.sinno.ems.exception.AttributesNotFound;
import com.sinno.ems.exception.ErrorType;
import com.sinno.ems.exception.IdNotFound;
import com.sinno.ems.service.WarrantyPeriodService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.MediaType;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by Enissay on 15/12/2016.
 */

@Controller
@RequestMapping(value = "/warrantyPeriods/")
public class WarrantyPeriodController {

    @Autowired
    private WarrantyPeriodService warrantyPeriodService;


    @PreAuthorize("hasAnyRole('ZONE_VIEW','PRODUCT_VIEW')")
    @RequestMapping(method = RequestMethod.GET, value = "/list")
    @ResponseBody
    public List<WarrantyPeriod> getWarrantyPeriods() throws AttributesNotFound, ErrorType {

        return warrantyPeriodService.findAll();
    }

    @PreAuthorize("hasAnyRole('ZONE_VIEW','PRODUCT_VIEW')")
    @RequestMapping(method = RequestMethod.GET, value = "/listPage")
    @ResponseBody
    public List<WarrantyPeriod> getWarrantyPeriods(@RequestParam int page, @RequestParam int size) throws AttributesNotFound, ErrorType {
        Sort sort = new Sort(Sort.Direction.DESC, "prmWarrantyPeriodUpdateDate");
        Pageable pageable = new PageRequest(page, size, sort);

        return warrantyPeriodService.findAll(pageable);
    }

    @PreAuthorize("hasAnyRole('ZONE_VIEW','PRODUCT_VIEW')")
    @RequestMapping(method = RequestMethod.GET, value = "/size")
    @ResponseBody
    public Long size() throws AttributesNotFound, ErrorType {
        return warrantyPeriodService.size();
    }

    @PreAuthorize("hasAnyRole('ZONE_VIEW','PRODUCT_VIEW')")
    @RequestMapping(method = RequestMethod.GET, value = "/sizeSearch")
    @ResponseBody
    public Long size(@RequestParam String search) throws AttributesNotFound, ErrorType {

        return warrantyPeriodService.size(search);
    }

    @PreAuthorize("hasAnyRole('ZONE_VIEW','PRODUCT_VIEW')")
    @RequestMapping(method = RequestMethod.GET, value = "/exist")
    @ResponseBody
    public Boolean exist(@RequestParam Long id) throws AttributesNotFound, ErrorType {
        return warrantyPeriodService.isExist(id);
    }

    @PreAuthorize("hasAnyRole('ZONE_VIEW','PRODUCT_VIEW')")
    @RequestMapping(method = RequestMethod.GET, value = "/{id}")
    @ResponseBody
    public WarrantyPeriod getWarrantyPeriod(@PathVariable("id") Long id) throws IdNotFound {
        return warrantyPeriodService.findById(id);
    }

    @PreAuthorize("hasAnyRole('ZONE_VIEW','PRODUCT_VIEW')")
    @RequestMapping(method = RequestMethod.GET, value = "/search")
    @ResponseBody
    public List<WarrantyPeriod> search(@RequestParam(value = "search") String search) throws AttributesNotFound, ErrorType {

        return warrantyPeriodService.find(search);
    }

    @PreAuthorize("hasAnyRole('ZONE_VIEW','PRODUCT_VIEW')")
    @RequestMapping(method = RequestMethod.GET, value = "/searchPage")
    @ResponseBody
    public List<WarrantyPeriod> search(@RequestParam(value = "search") String search, @RequestParam int page, @RequestParam int size) throws AttributesNotFound, ErrorType {
        return warrantyPeriodService.find(search, page,size);
    }

    @PreAuthorize("hasRole('ZONE_CREATE')")
    @RequestMapping(value = "/save", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public WarrantyPeriod add(@RequestBody WarrantyPeriod zone) {
        return warrantyPeriodService.save(zone);
    }

    @PreAuthorize("hasRole('ZONE_EDIT')")
    @RequestMapping(value = "/save", method = RequestMethod.PUT, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public WarrantyPeriod set(@RequestBody WarrantyPeriod zone) {
        return warrantyPeriodService.save(zone);
    }

    @PreAuthorize("hasRole('ZONE_DELETE')")
    @RequestMapping(value = "/delete", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public void delete(@RequestBody WarrantyPeriod zone) {

        warrantyPeriodService.delete(zone);
    }

    @PreAuthorize("hasRole('WARRANTY_PERIOD_DELETE')")
    @RequestMapping(value = "/delete/{id}", method = RequestMethod.DELETE, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public void delete(@PathVariable Long id) {
        warrantyPeriodService.delete(id);
    }
}