package com.sinno.ems.controller;

import com.sinno.ems.dto.SupplierInvoice;
import com.sinno.ems.exception.AttributesNotFound;
import com.sinno.ems.exception.ErrorType;
import com.sinno.ems.exception.IdNotFound;
import com.sinno.ems.service.SupplierInvoiceService;
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

@Controller
@RequestMapping(value = "/supplierInvoices/")
public class SupplierInvoiceController {

    @Autowired
    private SupplierInvoiceService supplierInvoiceService;

    //@PreAuthorize("hasyRole('SUPPLIER_INVOICE_VIEW')")
    @RequestMapping(method = RequestMethod.GET, value = "/list")
    @ResponseBody
    public List<SupplierInvoice> getSupplierInvoices() throws AttributesNotFound, ErrorType {

        return supplierInvoiceService.findAll();

        //  return supplierInvoiceService.findAll();
    }

    //@PreAuthorize("hasyRole('SUPPLIER_INVOICE_VIEW')")
    @RequestMapping(method = RequestMethod.GET, value = "/listPage")
    @ResponseBody
    public List<SupplierInvoice> getSupplierInvoices(@RequestParam int page, @RequestParam int size) throws AttributesNotFound, ErrorType {

        Pageable pageable= new PageRequest(page,size);

        return supplierInvoiceService.findAll(pageable);
        // return supplierInvoiceService.findAll(pageable);
    }

    //@PreAuthorize("hasyRole('SUPPLIER_INVOICE_VIEW')")
    @RequestMapping(method = RequestMethod.GET, value = "/size")
    @ResponseBody
    public Long size() throws AttributesNotFound, ErrorType {

        return supplierInvoiceService.size();
        //return supplierInvoiceService.size();
    }

    //@PreAuthorize("hasyRole('SUPPLIER_INVOICE_VIEW')")
    @RequestMapping(method = RequestMethod.GET, value = "/sizeSearch")
    @ResponseBody
    public Long size(@RequestParam String search) throws AttributesNotFound, ErrorType {

        return supplierInvoiceService.size(search );

        // return supplierInvoiceService.size(search);
    }

    //@PreAuthorize("hasyRole('SUPPLIER_INVOICE_VIEW')")
    @RequestMapping(method = RequestMethod.GET, value = "/exist")
    @ResponseBody
    public Boolean exist(@RequestParam Long id) throws AttributesNotFound, ErrorType {
        return supplierInvoiceService.isExist(id);
    }

    //@PreAuthorize("hasyRole('SUPPLIER_INVOICE_VIEW')")
    @RequestMapping(method = RequestMethod.GET, value = "/{id}")
    @ResponseBody
    public SupplierInvoice getSupplierInvoice(@PathVariable("id") Long id) throws IdNotFound {
        return supplierInvoiceService.findById(id);
    }

    //@PreAuthorize("hasyRole('SUPPLIER_INVOICE_VIEW')")
    @RequestMapping(method = RequestMethod.GET, value = "/search")
    @ResponseBody
    public List<SupplierInvoice> search(@RequestParam(value = "search") String search) throws AttributesNotFound, ErrorType {

        return supplierInvoiceService.find(search);

        // return supplierInvoiceService.find(search);
    }

    //@PreAuthorize("hasyRole('SUPPLIER_INVOICE_VIEW')")
    @RequestMapping(method = RequestMethod.GET, value = "/searchPage")
    @ResponseBody
    public List<SupplierInvoice> search(@RequestParam(value = "search") String search, @RequestParam int page, @RequestParam int size) throws AttributesNotFound, ErrorType {
        return supplierInvoiceService.find(search  , page, size);

        //  return supplierInvoiceService.find(search, pageable);
    }

    //@PreAuthorize("hasRole('SUPPLIER_INVOICE_CREATE')")
    @RequestMapping(value = "/save", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public SupplierInvoice add(@RequestBody SupplierInvoice supplierInvoice) {
        return supplierInvoiceService.save(supplierInvoice);
    }

    //@PreAuthorize("hasRole('SUPPLIER_INVOICE_EDIT')")
    @RequestMapping(value = "/save", method = RequestMethod.PUT, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public SupplierInvoice set(@RequestBody SupplierInvoice supplierInvoice) {
        return supplierInvoiceService.save(supplierInvoice);
    }

    //@PreAuthorize("hasRole('SUPPLIER_INVOICE_DELETE')")
    @RequestMapping(value = "/delete", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public void delete(@RequestBody SupplierInvoice supplierInvoice) {

        supplierInvoiceService.delete(supplierInvoice);
    }

    //@PreAuthorize("hasRole('SUPPLIER_INVOICE_DELETE')")
    @RequestMapping(value = "/delete/{id}", method = RequestMethod.DELETE, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public void delete(@PathVariable Long id) {
        supplierInvoiceService.delete(id);
    }
    //@PreAuthorize("hasRole('SUPPLIER_INVOICE_CREATE')")
    @RequestMapping(method = RequestMethod.GET, value = "/nextval")
    @ResponseBody
    public String nextVal() {
        return "FF" + supplierInvoiceService.getNextVal().toString();
    }
}