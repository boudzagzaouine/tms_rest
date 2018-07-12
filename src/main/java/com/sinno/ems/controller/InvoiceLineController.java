package com.sinno.ems.controller;

import com.sinno.ems.exception.AttributesNotFound;
import com.sinno.ems.exception.ErrorType;
import com.sinno.ems.exception.IdNotFound;
import com.sinno.ems.service.InvoiceLineService;
import com.sinno.ems.service.UserDetailsServiceWarehouse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping(value = "/invoiceLines/")
public class InvoiceLineController {

    @Autowired
    private InvoiceLineService invoiceLineService;
    @Autowired
    private UserDetailsServiceWarehouse userDetailsService;

    @PreAuthorize("hasRole('INVOICE_LINE_VIEW')")
    @RequestMapping(method = RequestMethod.GET, value = "/list")
    @ResponseBody
    public List<InvoiceLine> getInvoiceLines() throws AttributesNotFound, ErrorType {
        if (null == userDetailsService.getOwners()) {
            return null;
        }
        return invoiceLineService.find(userDetailsService.getOwners().toString());
    }

    @PreAuthorize("hasRole('INVOICE_LINE_VIEW')")
    @RequestMapping(method = RequestMethod.GET, value = "/listPage")
    @ResponseBody
    public List<InvoiceLine> getInvoiceLines(@RequestParam int page, @RequestParam int size) throws AttributesNotFound, ErrorType {
        if (null == userDetailsService.getOwners()) {
            return null;
        }
        return invoiceLineService.find(userDetailsService.getOwners().toString(), page,size);
    }

    @PreAuthorize("hasRole('INVOICE_LINE_VIEW')")
    @RequestMapping(method = RequestMethod.GET, value = "/size")
    @ResponseBody
    public Long size() throws AttributesNotFound, ErrorType {
        if (null == userDetailsService.getOwners()) {
            return null;
        }

        return invoiceLineService.size(userDetailsService.getOwners().toString());
    }

    @PreAuthorize("hasRole('INVOICE_LINE_VIEW')")
    @RequestMapping(method = RequestMethod.GET, value = "/sizeSearch")
    @ResponseBody
    public Long size(@RequestParam String search) throws AttributesNotFound, ErrorType {
        if (null == userDetailsService.getOwners()) {
            return null;
        }
        if (!search.endsWith(",")) {
            search += ",";
        }
        return invoiceLineService.size(search + userDetailsService.getOwners().toString());
    }

    @PreAuthorize("hasRole('INVOICE_LINE_VIEW')")
    @RequestMapping(method = RequestMethod.GET, value = "/exist")
    @ResponseBody
    public Boolean exist(@RequestParam Long id) throws AttributesNotFound, ErrorType {
        return invoiceLineService.isExist(id);
    }

    @PreAuthorize("hasRole('INVOICE_LINE_VIEW')")
    @RequestMapping(method = RequestMethod.GET, value = "/{id}")
    @ResponseBody
    public InvoiceLine getInvoiceLine(@PathVariable("id") Long id) throws IdNotFound {
        return invoiceLineService.findById(id);
    }

    @PreAuthorize("hasRole('INVOICE_LINE_VIEW')")
    @RequestMapping(method = RequestMethod.GET, value = "/search")
    @ResponseBody
    public List<InvoiceLine> search(@RequestParam(value = "search") String search) throws AttributesNotFound, ErrorType {
        if (null == userDetailsService.getOwners()) {
            return null;
        }
        if (!search.endsWith(",")) {
            search += ",";
        }
        return invoiceLineService.find(search + userDetailsService.getOwners().toString());
    }

    @PreAuthorize("hasRole('INVOICE_LINE_VIEW')")
    @RequestMapping(method = RequestMethod.GET, value = "/searchPage")
    @ResponseBody
    public List<InvoiceLine> search(@RequestParam(value = "search") String search, @RequestParam int page, @RequestParam int size) throws AttributesNotFound, ErrorType {
        if (null == userDetailsService.getOwners()) {
            return null;
        }
        if (!search.endsWith(",")) {
            search += ",";
        }
        return invoiceLineService.find(search + userDetailsService.getOwners().toString(),page,size);
    }

    @PreAuthorize("hasRole('INVOICE_LINE_CREATE')")
    @RequestMapping(value = "/save", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public InvoiceLine add(@RequestBody InvoiceLine invoiceLine) {
        return invoiceLineService.save(invoiceLine);
    }

    @PreAuthorize("hasRole('INVOICE_LINE_EDIT')")
    @RequestMapping(value = "/save", method = RequestMethod.PUT, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public InvoiceLine set(@RequestBody InvoiceLine invoiceLine) {
        return invoiceLineService.save(invoiceLine);
    }

    @PreAuthorize("hasRole('INVOICE_LINE_DELETE')")
    @RequestMapping(value = "/delete", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public void delete(@RequestBody InvoiceLine invoiceLine) {

        invoiceLineService.delete(invoiceLine);
    }

    @PreAuthorize("hasRole('INVOICE_LINE_DELETE')")
    @RequestMapping(value = "/delete/{id}", method = RequestMethod.DELETE, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public void delete(@PathVariable Long id) {
        invoiceLineService.delete(id);
    }
}