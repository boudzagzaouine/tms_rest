package com.sinno.ems.controller;

import com.sinno.ems.dto.InvoiceLineArc;
import com.sinno.ems.exception.AttributesNotFound;
import com.sinno.ems.exception.ErrorType;
import com.sinno.ems.exception.IdNotFound;
import com.sinno.ems.service.InvoiceLineArcService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.MediaType;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping(value = "/invoiceLineArcs/")
public class InvoiceLineArcController {

    @Autowired
    private InvoiceLineArcService invoiceLineArcService;

    @PreAuthorize("hasRole('INVOICE_LINE_ARC_VIEW')")
    @RequestMapping(method = RequestMethod.GET,value = "/list")
    @ResponseBody
    public List<InvoiceLineArc> getInvoiceLineArcs() {
        return invoiceLineArcService.findAll();
    }

    @PreAuthorize("hasRole('INVOICE_LINE_ARC_VIEW')")
    @RequestMapping(method = RequestMethod.GET, value = "/listPage")
    @ResponseBody
    public List<InvoiceLineArc> getInvoiceLineArcs(@RequestParam int page, @RequestParam int size) {
        Pageable pageable = new PageRequest(page, size);
        return invoiceLineArcService.findAll(pageable);
    }

    @PreAuthorize("hasRole('INVOICE_LINE_ARC_VIEW')")
    @RequestMapping(method = RequestMethod.GET, value = "/size")
    @ResponseBody
    public Long size() {
        return invoiceLineArcService.size();
    }

    @PreAuthorize("hasRole('INVOICE_LINE_ARC_VIEW')")
    @RequestMapping(method = RequestMethod.GET, value = "/sizeSearch")
    @ResponseBody
    public Long size(@RequestParam String search) throws AttributesNotFound, ErrorType {
        return invoiceLineArcService.size(search);
    }

    @PreAuthorize("hasRole('INVOICE_LINE_ARC_VIEW')")
    @RequestMapping(method = RequestMethod.GET, value = "/exist")
    @ResponseBody
    public Boolean exist(@RequestParam Long id) throws AttributesNotFound, ErrorType {
        return invoiceLineArcService.isExist(id);
    }    @PreAuthorize("hasRole('INVOICE_LINE_ARC_VIEW')")
    @RequestMapping(method = RequestMethod.GET,value = "/{id}")
    @ResponseBody
    public InvoiceLineArc getInvoiceLineArc(@PathVariable("id") Long id) throws IdNotFound {
        return invoiceLineArcService.findById(id);
    }

    @PreAuthorize("hasRole('INVOICE_LINE_ARC_VIEW')")
    @RequestMapping(method = RequestMethod.GET, value = "/search")
    @ResponseBody
    public List<InvoiceLineArc> search(@RequestParam(value = "search") String search) throws AttributesNotFound, ErrorType {
        return invoiceLineArcService.find(search);
    }

    @PreAuthorize("hasRole('INVOICE_LINE_ARC_VIEW')")
    @RequestMapping(method = RequestMethod.GET, value = "/searchPage")
    @ResponseBody
    public List<InvoiceLineArc> search(@RequestParam(value = "search") String search, @RequestParam int page, @RequestParam int size) throws AttributesNotFound, ErrorType {
        Pageable pageable = new PageRequest(page, size);
        return invoiceLineArcService.find(search, pageable);
    }

    @PreAuthorize("hasRole('INVOICE_LINE_ARC_CREATE')")
    @RequestMapping(value = "/save", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public InvoiceLineArc add(@RequestBody InvoiceLineArc invoiceLineArc) {
        return invoiceLineArcService.save(invoiceLineArc);
    }

    @PreAuthorize("hasRole('INVOICE_LINE_ARC_EDIT')")
    @RequestMapping(value = "/save", method = RequestMethod.PUT, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public InvoiceLineArc set(@RequestBody InvoiceLineArc invoiceLineArc) {
        return invoiceLineArcService.save(invoiceLineArc);
    }

    @PreAuthorize("hasRole('INVOICE_LINE_ARC_DELETE')")
    @RequestMapping(value = "/delete", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public void delete(@RequestBody InvoiceLineArc invoiceLineArc) {

        invoiceLineArcService.delete(invoiceLineArc);
    }

    @PreAuthorize("hasRole('INVOICE_LINE_ARC_DELETE')")
    @RequestMapping(value = "/delete/{id}", method = RequestMethod.DELETE, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public void delete(@PathVariable Long id) {
        invoiceLineArcService.delete(id);
    }
}