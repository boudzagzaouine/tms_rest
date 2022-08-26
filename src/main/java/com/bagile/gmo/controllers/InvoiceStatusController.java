package com.bagile.gmo.controllers;


import com.bagile.gmo.dto.InvoiceStatus;
import com.bagile.gmo.exceptions.AttributesNotFound;
import com.bagile.gmo.exceptions.ErrorType;
import com.bagile.gmo.exceptions.IdNotFound;
import com.bagile.gmo.services.InvoiceStatusService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.MediaType;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping(value = "/invoiceStatuses/")
public class InvoiceStatusController {

    @Autowired
    private InvoiceStatusService invoiceStatusService;

          @PreAuthorize("isAuthenticated()")
    @RequestMapping(method = RequestMethod.GET, value = "/list")
    @ResponseBody
    public List<InvoiceStatus> getInvoiceStatuses() throws AttributesNotFound, ErrorType {
          return invoiceStatusService.findAll();
    }

          @PreAuthorize("isAuthenticated()")
    @RequestMapping(method = RequestMethod.GET, value = "/listPage")
    @ResponseBody
    public List<InvoiceStatus> getInvoiceStatuses(@RequestParam int page, @RequestParam int size) throws AttributesNotFound, ErrorType {
        Pageable pageable =  PageRequest.of(page, size);
        return invoiceStatusService.findAll(pageable);
    }

       @PreAuthorize("isAuthenticated()")@RequestMapping(method = RequestMethod.GET, value = "/size")
    @ResponseBody
    public Long size() throws AttributesNotFound, ErrorType {

      return invoiceStatusService.size();
    }

       @PreAuthorize("isAuthenticated()")@RequestMapping(method = RequestMethod.GET, value = "/sizeSearch")
    @ResponseBody
    public Long size(@RequestParam String search) throws AttributesNotFound, ErrorType {
        return invoiceStatusService.size(search);
    }

       @PreAuthorize("isAuthenticated()")@RequestMapping(method = RequestMethod.GET, value = "/exist")
    @ResponseBody
    public Boolean exist(@RequestParam Long id) throws AttributesNotFound, ErrorType {
        return invoiceStatusService.isExist(id);
    }

       @PreAuthorize("isAuthenticated()")@RequestMapping(method = RequestMethod.GET, value = "/{id}")
    @ResponseBody
    public InvoiceStatus getInvoiceStatus(@PathVariable("id") Long id) throws  IdNotFound {
        return invoiceStatusService.findById(id);
    }

       @PreAuthorize("isAuthenticated()")@RequestMapping(method = RequestMethod.GET, value = "/search")
    @ResponseBody
    public List<InvoiceStatus> search(@RequestParam(value = "search") String search) throws AttributesNotFound, ErrorType {
        return invoiceStatusService.find(search);
    }

       @PreAuthorize("isAuthenticated()")@RequestMapping(method = RequestMethod.GET, value = "/searchPage")
    @ResponseBody
    public List<InvoiceStatus> search(@RequestParam(value = "search") String search, @RequestParam int page, @RequestParam int size) throws AttributesNotFound, ErrorType {

        if (!search.endsWith(",")) {
            search += ",";
        }

        return invoiceStatusService.find(search, page,size);
    }

    @PreAuthorize("hasRole('INVOICE_STATUS_CREATE')")
    @RequestMapping(value = "/save", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public InvoiceStatus add(@RequestBody InvoiceStatus invoiceStatus) {
        return invoiceStatusService.save(invoiceStatus);
    }

    @PreAuthorize("hasRole('INVOICE_STATUS_EDIT')")
    @RequestMapping(value = "/save", method = RequestMethod.PUT, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public InvoiceStatus set(@RequestBody InvoiceStatus invoiceStatus) {
        return invoiceStatusService.save(invoiceStatus);
    }

    @PreAuthorize("hasRole('INVOICE_STATUS_DELETE')")
    @RequestMapping(value = "/delete", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public void delete(@RequestBody InvoiceStatus invoiceStatus) {

        invoiceStatusService.delete(invoiceStatus);
    }

    @PreAuthorize("hasRole('INVOICE_STATUS_DELETE')")
    @RequestMapping(value = "/delete/{id}", method = RequestMethod.DELETE, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public void delete(@PathVariable Long id) {
        invoiceStatusService.delete(id);
    }

}