package com.sinno.ems.controller;

import com.sinno.ems.exception.AttributesNotFound;
import com.sinno.ems.exception.ErrorType;
import com.sinno.ems.exception.IdNotFound;
import com.sinno.ems.service.InvoiceTermService;
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
 * Created by Enissay on 03/12/2016.
 */
@Controller
@RequestMapping(value = "/invoiceTerms/")
public class InvoiceTermController {

    @Autowired
    private InvoiceTermService invoiceTermService;

    @PreAuthorize("hasRole('INVOICE_TERM_VIEW')")
    @RequestMapping(method = RequestMethod.GET, value = "/list")
    @ResponseBody
    public List<InvoiceTerm> getInvoiceTerms() {
        return invoiceTermService.findAll();
    }

    @PreAuthorize("hasRole('INVOICE_TERM_VIEW')")
    @RequestMapping(method = RequestMethod.GET, value = "/listPage")
    @ResponseBody
    public List<InvoiceTerm> getInvoiceTerms(@RequestParam int page, @RequestParam int size) {
        Sort sort = new Sort(Sort.Direction.DESC, "invInvoiceTermUpdateDate");
        Pageable pageable = new PageRequest(page, size, sort);
        return invoiceTermService.findAll(pageable);
    }

    @PreAuthorize("hasRole('INVOICE_TERM_VIEW')")
    @RequestMapping(method = RequestMethod.GET, value = "/size")
    @ResponseBody
    public Long size() {
        return invoiceTermService.size();
    }

    @PreAuthorize("hasRole('INVOICE_TERM_VIEW')")
    @RequestMapping(method = RequestMethod.GET, value = "/sizeSearch")
    @ResponseBody
    public Long size(@RequestParam String search) throws AttributesNotFound, ErrorType {
        return invoiceTermService.size(search);
    }

    @PreAuthorize("hasRole('INVOICE_TERM_VIEW')")
    @RequestMapping(method = RequestMethod.GET, value = "/exist")
    @ResponseBody
    public Boolean exist(@RequestParam Long id) throws AttributesNotFound, ErrorType {
        return invoiceTermService.isExist(id);
    }

    @PreAuthorize("hasRole('INVOICE_TERM_VIEW')")
    @RequestMapping(method = RequestMethod.GET, value = "/{id}")
    @ResponseBody
    public InvoiceTerm getInvoiceTerm(@PathVariable("id") Long id) throws IdNotFound {
        return invoiceTermService.findById(id);
    }

    @PreAuthorize("hasRole('INVOICE_TERM_VIEW')")
    @RequestMapping(method = RequestMethod.GET, value = "/search")
    @ResponseBody
    public List<InvoiceTerm> search(@RequestParam(value = "search") String search) throws AttributesNotFound, ErrorType {
        return invoiceTermService.find(search);
    }

    @PreAuthorize("hasRole('INVOICE_TERM_VIEW')")
    @RequestMapping(method = RequestMethod.GET, value = "/searchPage")
    @ResponseBody
    public List<InvoiceTerm> search(@RequestParam(value = "search") String search, @RequestParam int page, @RequestParam int size) throws AttributesNotFound, ErrorType {
        return invoiceTermService.find(search, page, size);
    }

    @PreAuthorize("hasRole('INVOICE_TERM_CREATE')")
    @RequestMapping(value = "/save", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public InvoiceTerm add(@RequestBody InvoiceTerm invoiceTerm) {
        return invoiceTermService.save(invoiceTerm);
    }

    @PreAuthorize("hasRole('INVOICE_TERM_EDIT')")
    @RequestMapping(value = "/save", method = RequestMethod.PUT, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public InvoiceTerm set(@RequestBody InvoiceTerm invoiceTerm) {
        return invoiceTermService.save(invoiceTerm);
    }

    @PreAuthorize("hasRole('INVOICE_TERM_DELETE')")
    @RequestMapping(value = "/delete", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public void delete(@RequestBody InvoiceTerm invoiceTerm) {

        invoiceTermService.delete(invoiceTerm);
    }

    @PreAuthorize("hasRole('INVOICE_TERM_DELETE')")
    @RequestMapping(value = "/delete/{id}", method = RequestMethod.DELETE, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public void delete(@PathVariable Long id) {
        invoiceTermService.delete(id);
    }
}