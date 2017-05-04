package com.sinno.ems.controller;

import com.sinno.ems.dto.AccountInvoiceLine;
import com.sinno.ems.exception.AttributesNotFound;
import com.sinno.ems.exception.ErrorType;
import com.sinno.ems.exception.IdNotFound;
import com.sinno.ems.service.AccountInvoiceLineService;
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
@RequestMapping(value = "/accountInvoiceLines/")
public class AccountInvoiceLineController {

    @Autowired
    private AccountInvoiceLineService accountInvoiceLineService;

    //@PreAuthorize("hasyRole('ACCOUNT_INVOICE_LINE_VIEW')")
    @RequestMapping(method = RequestMethod.GET, value = "/list")
    @ResponseBody
    public List<AccountInvoiceLine> getAccountInvoiceLines() throws AttributesNotFound, ErrorType {

        return accountInvoiceLineService.findAll();

        //  return accountInvoiceLineService.findAll();
    }

    //@PreAuthorize("hasyRole('ACCOUNT_INVOICE_LINE_VIEW')")
    @RequestMapping(method = RequestMethod.GET, value = "/listPage")
    @ResponseBody
    public List<AccountInvoiceLine> getAccountInvoiceLines(@RequestParam int page, @RequestParam int size) throws AttributesNotFound, ErrorType {

        Pageable pageable= new PageRequest(page,size);

        return accountInvoiceLineService.findAll(pageable);
        // return accountInvoiceLineService.findAll(pageable);
    }

    //@PreAuthorize("hasyRole('ACCOUNT_INVOICE_LINE_VIEW')")
    @RequestMapping(method = RequestMethod.GET, value = "/size")
    @ResponseBody
    public Long size() throws AttributesNotFound, ErrorType {

        return accountInvoiceLineService.size();
        //return accountInvoiceLineService.size();
    }

    //@PreAuthorize("hasyRole('ACCOUNT_INVOICE_LINE_VIEW')")
    @RequestMapping(method = RequestMethod.GET, value = "/sizeSearch")
    @ResponseBody
    public Long size(@RequestParam String search) throws AttributesNotFound, ErrorType {

        return accountInvoiceLineService.size(search );

        // return accountInvoiceLineService.size(search);
    }

    //@PreAuthorize("hasyRole('ACCOUNT_INVOICE_LINE_VIEW')")
    @RequestMapping(method = RequestMethod.GET, value = "/exist")
    @ResponseBody
    public Boolean exist(@RequestParam Long id) throws AttributesNotFound, ErrorType {
        return accountInvoiceLineService.isExist(id);
    }

    //@PreAuthorize("hasyRole('ACCOUNT_INVOICE_LINE_VIEW')")
    @RequestMapping(method = RequestMethod.GET, value = "/{id}")
    @ResponseBody
    public AccountInvoiceLine getAccountInvoiceLine(@PathVariable("id") Long id) throws IdNotFound {
        return accountInvoiceLineService.findById(id);
    }

    //@PreAuthorize("hasyRole('ACCOUNT_INVOICE_LINE_VIEW')")
    @RequestMapping(method = RequestMethod.GET, value = "/search")
    @ResponseBody
    public List<AccountInvoiceLine> search(@RequestParam(value = "search") String search) throws AttributesNotFound, ErrorType {

        return accountInvoiceLineService.find(search);

        // return accountInvoiceLineService.find(search);
    }

    //@PreAuthorize("hasyRole('ACCOUNT_INVOICE_LINE_VIEW')")
    @RequestMapping(method = RequestMethod.GET, value = "/searchPage")
    @ResponseBody
    public List<AccountInvoiceLine> search(@RequestParam(value = "search") String search, @RequestParam int page, @RequestParam int size) throws AttributesNotFound, ErrorType {
        return accountInvoiceLineService.find(search  , page, size);

        //  return accountInvoiceLineService.find(search, pageable);
    }

    //@PreAuthorize("hasRole('ACCOUNT_INVOICE_LINE_CREATE')")
    @RequestMapping(value = "/save", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public AccountInvoiceLine add(@RequestBody AccountInvoiceLine accountInvoiceLine) {
        return accountInvoiceLineService.save(accountInvoiceLine);
    }

    //@PreAuthorize("hasRole('ACCOUNT_INVOICE_LINE_EDIT')")
    @RequestMapping(value = "/save", method = RequestMethod.PUT, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public AccountInvoiceLine set(@RequestBody AccountInvoiceLine accountInvoiceLine) {
        return accountInvoiceLineService.save(accountInvoiceLine);
    }

    //@PreAuthorize("hasRole('ACCOUNT_INVOICE_LINE_DELETE')")
    @RequestMapping(value = "/delete", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public void delete(@RequestBody AccountInvoiceLine accountInvoiceLine) {

        accountInvoiceLineService.delete(accountInvoiceLine);
    }

    //@PreAuthorize("hasRole('ACCOUNT_INVOICE_LINE_DELETE')")
    @RequestMapping(value = "/delete/{id}", method = RequestMethod.DELETE, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public void delete(@PathVariable Long id) {
        accountInvoiceLineService.delete(id);
    }
   
}