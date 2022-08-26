package com.bagile.gmo.controllers;

import com.bagile.gmo.dto.SupplierInvoice;
import com.bagile.gmo.dto.SupplierInvoiceLine;
import com.bagile.gmo.exceptions.*;
import com.bagile.gmo.services.PaymentStatusService;
import com.bagile.gmo.services.SupplierInvoiceLineService;
import com.bagile.gmo.services.SupplierInvoiceService;
import com.bagile.gmo.services.UserDetailsServiceWarehouse;
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
@RequestMapping(value = "/supplierInvoiceLines/")
public class SupplierInvoiceLineController {

    @Autowired
    private SupplierInvoiceLineService supplierInvoiceLineService;

    //@PreAuthorize("hasyRole('SUPPLIER_INVOICE_LINE_VIEW')")
    @RequestMapping(method = RequestMethod.GET, value = "/list")
    @ResponseBody
    public List<SupplierInvoiceLine> getSupplierInvoiceLines() throws AttributesNotFound, ErrorType {

        return supplierInvoiceLineService.findAll();

        //  return supplierInvoiceLineService.findAll();
    }

    //@PreAuthorize("hasyRole('SUPPLIER_INVOICE_LINE_VIEW')")
    @RequestMapping(method = RequestMethod.GET, value = "/listPage")
    @ResponseBody
    public List<SupplierInvoiceLine> getSupplierInvoiceLines(@RequestParam int page, @RequestParam int size) throws AttributesNotFound, ErrorType {

        Pageable pageable=  PageRequest.of(page,size);

        return supplierInvoiceLineService.findAll(pageable);
        // return supplierInvoiceLineService.findAll(pageable);
    }

    //@PreAuthorize("hasyRole('SUPPLIER_INVOICE_LINE_VIEW')")
    @RequestMapping(method = RequestMethod.GET, value = "/size")
    @ResponseBody
    public Long size() throws AttributesNotFound, ErrorType {

        return supplierInvoiceLineService.size();
        //return supplierInvoiceLineService.size();
    }

    //@PreAuthorize("hasyRole('SUPPLIER_INVOICE_LINE_VIEW')")
    @RequestMapping(method = RequestMethod.GET, value = "/sizeSearch")
    @ResponseBody
    public Long size(@RequestParam String search) throws AttributesNotFound, ErrorType {

        return supplierInvoiceLineService.size(search );

        // return supplierInvoiceLineService.size(EncoderDecoder.decode(search));
    }

    //@PreAuthorize("hasyRole('SUPPLIER_INVOICE_LINE_VIEW')")
    @RequestMapping(method = RequestMethod.GET, value = "/exist")
    @ResponseBody
    public Boolean exist(@RequestParam Long id) throws AttributesNotFound, ErrorType {
        return supplierInvoiceLineService.isExist(id);
    }

    //@PreAuthorize("hasyRole('SUPPLIER_INVOICE_LINE_VIEW')")
    @RequestMapping(method = RequestMethod.GET, value = "/{id}")
    @ResponseBody
    public SupplierInvoiceLine getSupplierInvoiceLine(@PathVariable("id") Long id) throws IdNotFound {
        return supplierInvoiceLineService.findById(id);
    }

    //@PreAuthorize("hasyRole('SUPPLIER_INVOICE_LINE_VIEW')")
    @RequestMapping(method = RequestMethod.GET, value = "/search")
    @ResponseBody
    public List<SupplierInvoiceLine> search(@RequestParam(value = "search") String search) throws AttributesNotFound, ErrorType {

        return supplierInvoiceLineService.find(search);

        // return supplierInvoiceLineService.find(EncoderDecoder.decode(search));
    }

    //@PreAuthorize("hasyRole('SUPPLIER_INVOICE_LINE_VIEW')")
    @RequestMapping(method = RequestMethod.GET, value = "/searchPage")
    @ResponseBody
    public List<SupplierInvoiceLine> search(@RequestParam(value = "search") String search, @RequestParam int page, @RequestParam int size) throws AttributesNotFound, ErrorType {
        return supplierInvoiceLineService.find(search  , page, size);

        //  return supplierInvoiceLineService.find(EncoderDecoder.decode(search), pageable);
    }

    //@PreAuthorize("hasRole('SUPPLIER_INVOICE_LINE_CREATE')")
    @RequestMapping(value = "/save", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public SupplierInvoiceLine add(@RequestBody SupplierInvoiceLine supplierInvoiceLine) {
        return supplierInvoiceLineService.save(supplierInvoiceLine);
    }

    //@PreAuthorize("hasRole('SUPPLIER_INVOICE_LINE_EDIT')")
    @RequestMapping(value = "/save", method = RequestMethod.PUT, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public SupplierInvoiceLine set(@RequestBody SupplierInvoiceLine supplierInvoiceLine) {
        return supplierInvoiceLineService.save(supplierInvoiceLine);
    }

    //@PreAuthorize("hasRole('SUPPLIER_INVOICE_LINE_DELETE')")
    @RequestMapping(value = "/delete", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public void delete(@RequestBody SupplierInvoiceLine supplierInvoiceLine) {

        supplierInvoiceLineService.delete(supplierInvoiceLine);
    }

    //@PreAuthorize("hasRole('SUPPLIER_INVOICE_LINE_DELETE')")
    @RequestMapping(value = "/delete/{id}", method = RequestMethod.DELETE, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public void delete(@PathVariable Long id) {
        supplierInvoiceLineService.delete(id);
    }

}