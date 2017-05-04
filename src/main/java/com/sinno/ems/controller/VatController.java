package com.sinno.ems.controller;

import com.sinno.ems.dto.Vat;
import com.sinno.ems.exception.AttributesNotFound;
import com.sinno.ems.exception.ErrorType;
import com.sinno.ems.exception.IdNotFound;
import com.sinno.ems.service.VatService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.MediaType;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by Enissay on 22/12/2016.
 */
@Controller
@RequestMapping(value = "/vats/")
public class VatController {
    @Autowired
    private VatService vatService;

    @PreAuthorize("hasAnyRole('VAT_VIEW','DELIVERY_VIEW','RECEPTION_VIEW','SALE_ORDER_VIEW','PURSHASE_ORDER_VIEW','LOCATION_VIEW')")
    @RequestMapping(method = RequestMethod.GET, value = "/list")
    @ResponseBody
    public List<Vat> getVats() {
        return vatService.findAll();
    }

    @PreAuthorize("hasAnyRole('VAT_VIEW','DELIVERY_VIEW','RECEPTION_VIEW','SALE_ORDER_VIEW','PURSHASE_ORDER_VIEW','LOCATION_VIEW')")
    @RequestMapping(method = RequestMethod.GET, value = "/listPage")
    @ResponseBody
    public List<Vat> getVats(@RequestParam int page, @RequestParam int size) {
        Pageable pageable = new PageRequest(page, size);
        return vatService.findAll(pageable);
    }

    @PreAuthorize("hasAnyRole('VAT_VIEW','DELIVERY_VIEW','RECEPTION_VIEW','SALE_ORDER_VIEW','PURSHASE_ORDER_VIEW','LOCATION_VIEW')")
    @RequestMapping(method = RequestMethod.GET, value = "/size")
    @ResponseBody
    public Long size() {
        return vatService.size();
    }

    @PreAuthorize("hasAnyRole('VAT_VIEW','DELIVERY_VIEW','RECEPTION_VIEW','SALE_ORDER_VIEW','PURSHASE_ORDER_VIEW','LOCATION_VIEW')")
    @RequestMapping(method = RequestMethod.GET, value = "/sizeSearch")
    @ResponseBody
    public Long size(@RequestParam String search) throws AttributesNotFound, ErrorType {
        return vatService.size(search);
    }

    @PreAuthorize("hasAnyRole('VAT_VIEW','DELIVERY_VIEW','RECEPTION_VIEW','SALE_ORDER_VIEW','PURSHASE_ORDER_VIEW','LOCATION_VIEW')")
    @RequestMapping(method = RequestMethod.GET, value = "/exist")
    @ResponseBody
    public Boolean exist(@RequestParam Long id) throws AttributesNotFound, ErrorType {
        return vatService.isExist(id);
    }

    @PreAuthorize("hasAnyRole('VAT_VIEW','DELIVERY_VIEW','RECEPTION_VIEW','SALE_ORDER_VIEW','PURSHASE_ORDER_VIEW','LOCATION_VIEW')")
    @RequestMapping(method = RequestMethod.GET, value = "/{id}")
    @ResponseBody
    public Vat getVat(@PathVariable("id") Long id) throws IdNotFound {
        return vatService.findById(id);
    }

    @PreAuthorize("hasAnyRole('VAT_VIEW','DELIVERY_VIEW','RECEPTION_VIEW','SALE_ORDER_VIEW','PURSHASE_ORDER_VIEW','LOCATION_VIEW')")
    @RequestMapping(method = RequestMethod.GET, value = "/search")
    @ResponseBody
    public List<Vat> search(@RequestParam(value = "search") String search) throws AttributesNotFound, ErrorType {
        return vatService.find(search);
    }

    @PreAuthorize("hasAnyRole('VAT_VIEW','DELIVERY_VIEW','RECEPTION_VIEW','SALE_ORDER_VIEW','PURSHASE_ORDER_VIEW','LOCATION_VIEW')")
    @RequestMapping(method = RequestMethod.GET, value = "/searchPage")
    @ResponseBody
    public List<Vat> search(@RequestParam(value = "search") String search, @RequestParam int page, @RequestParam int size) throws AttributesNotFound, ErrorType {
        Pageable pageable = new PageRequest(page, size);
        return vatService.find(search, pageable);
    }

    @PreAuthorize("hasRole('VAT_CREATE')")
    @RequestMapping(value = "/save", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public Vat add(@RequestBody Vat vat) {
        return vatService.save(vat);
    }

    @PreAuthorize("hasRole('VAT_EDIT')")
    @RequestMapping(value = "/save", method = RequestMethod.PUT, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public Vat set(@RequestBody Vat vat) {
        return vatService.save(vat);
    }

    @PreAuthorize("hasRole('VAT_DELETE')")
    @RequestMapping(value = "/delete", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public void delete(@RequestBody Vat vat) {

        vatService.delete(vat);
    }

    @PreAuthorize("hasRole('VAT_DELETE')")
    @RequestMapping(value = "/delete/{id}", method = RequestMethod.DELETE, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public void delete(@PathVariable Long id) {
        vatService.delete(id);
    }
}
