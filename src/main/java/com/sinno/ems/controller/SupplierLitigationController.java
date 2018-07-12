package com.sinno.ems.controller;

import com.sinno.ems.exception.AttributesNotFound;
import com.sinno.ems.exception.ErrorType;
import com.sinno.ems.exception.IdNotFound;
import com.sinno.ems.service.SupplierLitigationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping(value = "/supplierLitigations/")
public class SupplierLitigationController {

    @Autowired
    private SupplierLitigationService supplierLitigationService;

    //@PreAuthorize("hasyRole('SUPPLIER_LITIGATION_VIEW')")
    @RequestMapping(method = RequestMethod.GET, value = "/list")
    @ResponseBody
    public List<SupplierLitigation> getSupplierLitigations() throws AttributesNotFound, ErrorType {

        return supplierLitigationService.findAll();

        //  return supplierLitigationService.findAll();
    }

    //@PreAuthorize("hasyRole('SUPPLIER_LITIGATION_VIEW')")
    @RequestMapping(method = RequestMethod.GET, value = "/listPage")
    @ResponseBody
    public List<SupplierLitigation> getSupplierLitigations(@RequestParam int page, @RequestParam int size) throws AttributesNotFound, ErrorType {

        Pageable pageable= new PageRequest(page,size);

        return supplierLitigationService.findAll(pageable);
        // return supplierLitigationService.findAll(pageable);
    }

    //@PreAuthorize("hasyRole('SUPPLIER_LITIGATION_VIEW')")
    @RequestMapping(method = RequestMethod.GET, value = "/size")
    @ResponseBody
    public Long size() throws AttributesNotFound, ErrorType {

        return supplierLitigationService.size();
        //return supplierLitigationService.size();
    }

    //@PreAuthorize("hasyRole('SUPPLIER_LITIGATION_VIEW')")
    @RequestMapping(method = RequestMethod.GET, value = "/sizeSearch")
    @ResponseBody
    public Long size(@RequestParam String search) throws AttributesNotFound, ErrorType {

        return supplierLitigationService.size(search );

        // return supplierLitigationService.size(search);
    }

    //@PreAuthorize("hasyRole('SUPPLIER_LITIGATION_VIEW')")
    @RequestMapping(method = RequestMethod.GET, value = "/exist")
    @ResponseBody
    public Boolean exist(@RequestParam Long id) throws AttributesNotFound, ErrorType {
        return supplierLitigationService.isExist(id);
    }

    //@PreAuthorize("hasyRole('SUPPLIER_LITIGATION_VIEW')")
    @RequestMapping(method = RequestMethod.GET, value = "/{id}")
    @ResponseBody
    public SupplierLitigation getSupplierLitigation(@PathVariable("id") Long id) throws IdNotFound {
        return supplierLitigationService.findById(id);
    }

    //@PreAuthorize("hasyRole('SUPPLIER_LITIGATION_VIEW')")
    @RequestMapping(method = RequestMethod.GET, value = "/search")
    @ResponseBody
    public List<SupplierLitigation> search(@RequestParam(value = "search") String search) throws AttributesNotFound, ErrorType {

        return supplierLitigationService.find(search);

        // return supplierLitigationService.find(search);
    }

    //@PreAuthorize("hasyRole('SUPPLIER_LITIGATION_VIEW')")
    @RequestMapping(method = RequestMethod.GET, value = "/searchPage")
    @ResponseBody
    public List<SupplierLitigation> search(@RequestParam(value = "search") String search, @RequestParam int page, @RequestParam int size) throws AttributesNotFound, ErrorType {
        return supplierLitigationService.find(search  , page, size);

        //  return supplierLitigationService.find(search, pageable);
    }

    //@PreAuthorize("hasRole('SUPPLIER_LITIGATION_CREATE')")
    @RequestMapping(value = "/save", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public SupplierLitigation add(@RequestBody SupplierLitigation supplierLitigation) {
        return supplierLitigationService.save(supplierLitigation);
    }

    //@PreAuthorize("hasRole('SUPPLIER_LITIGATION_EDIT')")
    @RequestMapping(value = "/save", method = RequestMethod.PUT, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public SupplierLitigation set(@RequestBody SupplierLitigation supplierLitigation) {
        return supplierLitigationService.save(supplierLitigation);
    }

    //@PreAuthorize("hasRole('SUPPLIER_LITIGATION_DELETE')")
    @RequestMapping(value = "/delete", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public void delete(@RequestBody SupplierLitigation supplierLitigation) {

        supplierLitigationService.delete(supplierLitigation);
    }

    //@PreAuthorize("hasRole('SUPPLIER_LITIGATION_DELETE')")
    @RequestMapping(value = "/delete/{id}", method = RequestMethod.DELETE, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public void delete(@PathVariable Long id) {
        supplierLitigationService.delete(id);
    }
}