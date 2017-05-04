package com.sinno.ems.controller;

import com.sinno.ems.dto.InvoiceRules;
import com.sinno.ems.exception.AttributesNotFound;
import com.sinno.ems.exception.ErrorType;
import com.sinno.ems.exception.IdNotFound;
import com.sinno.ems.service.InvoiceRulesService;
import com.sinno.ems.service.UserDetailsServiceWarehouse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.MediaType;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping(value = "/invoiceRuless/")
public class InvoiceRulesController {

    @Autowired
    private InvoiceRulesService invoiceRulesService;
    @Autowired
    private UserDetailsServiceWarehouse userDetailsService;

    @PreAuthorize("hasRole('INVOICE_RULES_VIEW')")
    @RequestMapping(method = RequestMethod.GET, value = "/list")
    @ResponseBody
    public List<InvoiceRules> getInvoiceRuless() throws AttributesNotFound, ErrorType {

        if (null == userDetailsService.getOwners()) {
            return null;
        }
        return invoiceRulesService.find(userDetailsService.getOwners().toString());
    }

    @PreAuthorize("hasRole('INVOICE_RULES_VIEW')")
    @RequestMapping(method = RequestMethod.GET, value = "/listPage")
    @ResponseBody
    public List<InvoiceRules> getInvoiceRuless(@RequestParam int page, @RequestParam int size) throws AttributesNotFound, ErrorType {
        Pageable pageable = new PageRequest(page, size);
        if (null == userDetailsService.getOwners()) {
            return null;
        }
        return invoiceRulesService.find(userDetailsService.getOwners().toString(), pageable);
    }

    @PreAuthorize("hasRole('INVOICE_RULES_VIEW')")
    @RequestMapping(method = RequestMethod.GET, value = "/size")
    @ResponseBody
    public Long size() throws AttributesNotFound, ErrorType {
        if (null == userDetailsService.getOwners()) {
            return null;
        }
        return invoiceRulesService.size(userDetailsService.getOwners().toString());
    }

    @PreAuthorize("hasRole('INVOICE_RULES_VIEW')")
    @RequestMapping(method = RequestMethod.GET, value = "/sizeSearch")
    @ResponseBody
    public Long size(@RequestParam String search) throws AttributesNotFound, ErrorType {
        if (null == userDetailsService.getOwners()) {
            return null;
        }
        if (!search.endsWith(",")) {
            search += ",";
        }
        return invoiceRulesService.size(search+userDetailsService.getOwners().toString());
    }

    @PreAuthorize("hasRole('INVOICE_RULES_VIEW')")
    @RequestMapping(method = RequestMethod.GET, value = "/exist")
    @ResponseBody
    public Boolean exist(@RequestParam Long id) throws AttributesNotFound, ErrorType {
        return invoiceRulesService.isExist(id);
    }

    @PreAuthorize("hasRole('INVOICE_RULES_VIEW')")
    @RequestMapping(method = RequestMethod.GET, value = "/{id}")
    @ResponseBody
    public InvoiceRules getInvoiceRules(@PathVariable("id") Long id) throws IdNotFound {
        return invoiceRulesService.findById(id);
    }

    @PreAuthorize("hasRole('INVOICE_RULES_VIEW')")
    @RequestMapping(method = RequestMethod.GET, value = "/search")
    @ResponseBody
    public List<InvoiceRules> search(@RequestParam(value = "search") String search) throws AttributesNotFound, ErrorType {
        if (null == userDetailsService.getOwners()) {
            return null;
        }
        if (!search.endsWith(",")) {
            search += ",";
        }
        return invoiceRulesService.find(search+userDetailsService.getOwners().toString());
    }

    @PreAuthorize("hasRole('INVOICE_RULES_VIEW')")
    @RequestMapping(method = RequestMethod.GET, value = "/searchPage")
    @ResponseBody
    public List<InvoiceRules> search(@RequestParam(value = "search") String search, @RequestParam int page, @RequestParam int size) throws AttributesNotFound, ErrorType {
        Pageable pageable = new PageRequest(page, size);
        if (null == userDetailsService.getOwners()) {
            return null;
        }
        if (!search.endsWith(",")) {
            search += ",";
        }
        return invoiceRulesService.find(search+userDetailsService.getOwners().toString(), pageable);
    }

    @PreAuthorize("hasRole('INVOICE_RULES_CREATE')")
    @RequestMapping(value = "/save", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public InvoiceRules add(@RequestBody InvoiceRules invoiceRules) {
        return invoiceRulesService.save(invoiceRules);
    }

    @PreAuthorize("hasRole('INVOICE_RULES_EDIT')")
    @RequestMapping(value = "/save", method = RequestMethod.PUT, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public InvoiceRules set(@RequestBody InvoiceRules invoiceRules) {
        return invoiceRulesService.save(invoiceRules);
    }

    @PreAuthorize("hasRole('INVOICE_RULES_DELETE')")
    @RequestMapping(value = "/delete", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public void delete(@RequestBody InvoiceRules invoiceRules) {

        invoiceRulesService.delete(invoiceRules);
    }

    @PreAuthorize("hasRole('INVOICE_RULES_DELETE')")
    @RequestMapping(value = "/delete/{id}", method = RequestMethod.DELETE, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public void delete(@PathVariable Long id) {
        invoiceRulesService.delete(id);
    }
}