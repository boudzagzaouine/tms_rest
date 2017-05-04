package com.sinno.ems.controller;

import com.sinno.ems.dto.InvoiceArc;
import com.sinno.ems.exception.AttributesNotFound;
import com.sinno.ems.exception.ErrorType;
import com.sinno.ems.exception.IdNotFound;
import com.sinno.ems.service.InvoiceArcService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.MediaType;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping(value = "/invoiceArcs/")
public class InvoiceArcController {

    @Autowired
    private InvoiceArcService invoiceArcService;

    @PreAuthorize("hasRole('INVOICE_ARC_VIEW')")
    @RequestMapping(method = RequestMethod.GET,value = "/list")
    @ResponseBody
    public List<InvoiceArc> getInvoiceArcs() {
        return invoiceArcService.findAll();
    }

    @PreAuthorize("hasRole('INVOICE_ARC_VIEW')")
    @RequestMapping(method = RequestMethod.GET, value = "/listPage")
    @ResponseBody
    public List<InvoiceArc> getInvoiceArcs(@RequestParam int page, @RequestParam int size) {
        Pageable pageable = new PageRequest(page, size);
        return invoiceArcService.findAll(pageable);
    }

    @PreAuthorize("hasRole('INVOICE_ARC_VIEW')")
    @RequestMapping(method = RequestMethod.GET, value = "/size")
    @ResponseBody
    public Long size() {
        return invoiceArcService.size();
    }

    @PreAuthorize("hasRole('INVOICE_ARC_VIEW')")
    @RequestMapping(method = RequestMethod.GET, value = "/sizeSearch")
    @ResponseBody
    public Long size(@RequestParam String search) throws AttributesNotFound, ErrorType {
        return invoiceArcService.size(search);
    }

    @PreAuthorize("hasRole('INVOICE_ARC_VIEW')")
    @RequestMapping(method = RequestMethod.GET, value = "/exist")
    @ResponseBody
    public Boolean exist(@RequestParam Long id) throws AttributesNotFound, ErrorType {
        return invoiceArcService.isExist(id);
    }    @PreAuthorize("hasRole('INVOICE_ARC_VIEW')")
    @RequestMapping(method = RequestMethod.GET,value = "/{id}")
    @ResponseBody
    public InvoiceArc getInvoiceArc(@PathVariable("id") Long id) throws IdNotFound {
        return invoiceArcService.findById(id);
    }

    @PreAuthorize("hasRole('INVOICE_ARC_VIEW')")
    @RequestMapping(method = RequestMethod.GET, value = "/search")
    @ResponseBody
    public List<InvoiceArc> search(@RequestParam(value = "search") String search) throws AttributesNotFound, ErrorType {
        return invoiceArcService.find(search);
    }

    @PreAuthorize("hasRole('INVOICE_ARC_VIEW')")
    @RequestMapping(method = RequestMethod.GET, value = "/searchPage")
    @ResponseBody
    public List<InvoiceArc> search(@RequestParam(value = "search") String search, @RequestParam int page, @RequestParam int size) throws AttributesNotFound, ErrorType {
        Pageable pageable = new PageRequest(page, size);
        return invoiceArcService.find(search, pageable);
    }

    @PreAuthorize("hasRole('INVOICE_ARC_CREATE')")
    @RequestMapping(value = "/save", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public InvoiceArc add(@RequestBody InvoiceArc invoiceArc) {
        return invoiceArcService.save(invoiceArc);
    }

    @PreAuthorize("hasRole('INVOICE_ARC_EDIT')")
    @RequestMapping(value = "/save", method = RequestMethod.PUT, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public InvoiceArc set(@RequestBody InvoiceArc invoiceArc) {
        return invoiceArcService.save(invoiceArc);
    }

    @PreAuthorize("hasRole('INVOICE_ARC_DELETE')")
    @RequestMapping(value = "/delete", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public void delete(@RequestBody InvoiceArc invoiceArc) {

        invoiceArcService.delete(invoiceArc);
    }

    @PreAuthorize("hasRole('INVOICE_ARC_DELETE')")
    @RequestMapping(value = "/delete/{id}", method = RequestMethod.DELETE, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public void delete(@PathVariable Long id) {
        invoiceArcService.delete(id);
    }
}