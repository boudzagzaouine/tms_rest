package com.sinno.ems.controller;

import com.sinno.ems.exception.AttributesNotFound;
import com.sinno.ems.exception.ErrorType;
import com.sinno.ems.exception.IdNotFound;
import com.sinno.ems.service.BarCodeService;
import com.sinno.ems.service.UserDetailsServiceWarehouse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.MediaType;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by ASMAE on 29/04/2016.
 */
@Controller
@RequestMapping(value = "/barCodes/")
public class BarCodeController {
    @Autowired
    private BarCodeService barCodeService;
    @Autowired
    @Qualifier("userDetailsService")
    private UserDetailsServiceWarehouse userDetailsService;

    @PreAuthorize("hasRole('BARCODE_VIEW')")
    @RequestMapping(method = RequestMethod.GET, value = "/list")
    @ResponseBody
    public List<BarCode> getBarCodes() throws AttributesNotFound, ErrorType {
        return barCodeService.findAll();
    }

    @PreAuthorize("hasRole('BARCODE_VIEW')")
    @RequestMapping(method = RequestMethod.GET, value = "/listPage")
    @ResponseBody
    public List<BarCode> getBarCodes(@RequestParam int page, @RequestParam int size) throws AttributesNotFound, ErrorType {
        Pageable pageable = new PageRequest(page, size);
        return barCodeService.findAll(pageable);
        }

    @PreAuthorize("hasRole('BARCODE_VIEW')")
    @RequestMapping(method = RequestMethod.GET, value = "/size")
    @ResponseBody
    public Long size() throws AttributesNotFound, ErrorType {
        return barCodeService.size();
    }

    @PreAuthorize("hasRole('BARCODE_VIEW')")
    @RequestMapping(method = RequestMethod.GET, value = "/sizeSearch")
    @ResponseBody
    public Long size(@RequestParam String search) throws AttributesNotFound, ErrorType {
        return barCodeService.size(search);
    }

    @PreAuthorize("hasRole('BARCODE_VIEW')")
    @RequestMapping(method = RequestMethod.GET, value = "/exist")
    @ResponseBody
    public Boolean exist(@RequestParam Long id) throws AttributesNotFound, ErrorType {
        return barCodeService.isExist(id);
    }

    @PreAuthorize("hasRole('BARCODE_VIEW')")
    @RequestMapping(method = RequestMethod.GET, value = "/{id}")
    @ResponseBody
    public BarCode getBarCode(@PathVariable("id") Long id) throws IdNotFound {
        return barCodeService.findById(id);
    }

    @PreAuthorize("hasRole('BARCODE_VIEW')")
    @RequestMapping(method = RequestMethod.GET, value = "/search")
    @ResponseBody
    public List<BarCode> search(@RequestParam(value = "search") String search) throws AttributesNotFound, ErrorType {
        return barCodeService.find(search + userDetailsService.getWarehouses()+","+userDetailsService.getOwners().toString());
    }

    @PreAuthorize("hasRole('BARCODE_VIEW')")
    @RequestMapping(method = RequestMethod.GET, value = "/searchPage")
    @ResponseBody
    public List<BarCode> search(@RequestParam(value = "search") String search, @RequestParam int page, @RequestParam int size) throws AttributesNotFound, ErrorType {
        return barCodeService.find(search);
    }

    @PreAuthorize("hasRole('BARCODE_CREATE')")
    @RequestMapping(value = "/save", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public BarCode add(@RequestBody BarCode barCode) {
        return barCodeService.save(barCode);
    }

    @PreAuthorize("hasRole('BARCODE_EDIT')")
    @RequestMapping(value = "/save", method = RequestMethod.PUT, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public BarCode set(@RequestBody BarCode barCode) {
        return barCodeService.save(barCode);
    }

    @PreAuthorize("hasRole('BARCODE_DELETE')")
    @RequestMapping(value = "/delete", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public void delete(@RequestBody BarCode barCode) {

        barCodeService.delete(barCode);
    }

    @PreAuthorize("hasRole('BARCODE_DELETE')")
    @RequestMapping(value = "/delete/{id}", method = RequestMethod.DELETE, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public void delete(@PathVariable Long id) {
        barCodeService.delete(id);
    }
}
