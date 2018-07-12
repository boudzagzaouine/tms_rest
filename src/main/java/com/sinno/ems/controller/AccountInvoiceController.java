package com.sinno.ems.controller;

import com.sinno.ems.exception.AttributesNotFound;
import com.sinno.ems.exception.ErrorType;
import com.sinno.ems.exception.IdNotFound;
import com.sinno.ems.service.AccountInvoiceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping(value = "/accountInvoices/")
public class AccountInvoiceController {

    @Autowired
    private AccountInvoiceService accountInvoiceService;

    //@PreAuthorize("hasyRole('ACCOUNT_INVOICE_VIEW')")
    @RequestMapping(method = RequestMethod.GET, value = "/list")
    @ResponseBody
    public List<AccountInvoice> getAccountInvoices() throws AttributesNotFound, ErrorType {

        return accountInvoiceService.findAll();

        //  return accountInvoiceService.findAll();
    }

    //@PreAuthorize("hasyRole('ACCOUNT_INVOICE_VIEW')")
    @RequestMapping(method = RequestMethod.GET, value = "/listPage")
    @ResponseBody
    public List<AccountInvoice> getAccountInvoices(@RequestParam int page, @RequestParam int size) throws AttributesNotFound, ErrorType {

        Pageable pageable= new PageRequest(page,size);

        return accountInvoiceService.findAll(pageable);
        // return accountInvoiceService.findAll(pageable);
    }

    //@PreAuthorize("hasyRole('ACCOUNT_INVOICE_VIEW')")
    @RequestMapping(method = RequestMethod.GET, value = "/size")
    @ResponseBody
    public Long size() throws AttributesNotFound, ErrorType {

        return accountInvoiceService.size();
        //return accountInvoiceService.size();
    }

    //@PreAuthorize("hasyRole('ACCOUNT_INVOICE_VIEW')")
    @RequestMapping(method = RequestMethod.GET, value = "/sizeSearch")
    @ResponseBody
    public Long size(@RequestParam String search) throws AttributesNotFound, ErrorType {

        return accountInvoiceService.size(search );

        // return accountInvoiceService.size(search);
    }

    //@PreAuthorize("hasyRole('ACCOUNT_INVOICE_VIEW')")
    @RequestMapping(method = RequestMethod.GET, value = "/exist")
    @ResponseBody
    public Boolean exist(@RequestParam Long id) throws AttributesNotFound, ErrorType {
        return accountInvoiceService.isExist(id);
    }

    //@PreAuthorize("hasyRole('ACCOUNT_INVOICE_VIEW')")
    @RequestMapping(method = RequestMethod.GET, value = "/{id}")
    @ResponseBody
    public AccountInvoice getAccountInvoice(@PathVariable("id") Long id) throws IdNotFound {
        return accountInvoiceService.findById(id);
    }

    //@PreAuthorize("hasyRole('ACCOUNT_INVOICE_VIEW')")
    @RequestMapping(method = RequestMethod.GET, value = "/search")
    @ResponseBody
    public List<AccountInvoice> search(@RequestParam(value = "search") String search) throws AttributesNotFound, ErrorType {

        return accountInvoiceService.find(search);

        // return accountInvoiceService.find(search);
    }

    //@PreAuthorize("hasyRole('ACCOUNT_INVOICE_VIEW')")
    @RequestMapping(method = RequestMethod.GET, value = "/searchPage")
    @ResponseBody
    public List<AccountInvoice> search(@RequestParam(value = "search") String search, @RequestParam int page, @RequestParam int size) throws AttributesNotFound, ErrorType {
        return accountInvoiceService.find(search  , page, size);

        //  return accountInvoiceService.find(search, pageable);
    }

    //@PreAuthorize("hasRole('ACCOUNT_INVOICE_CREATE')")
    @RequestMapping(value = "/save", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public AccountInvoice add(@RequestBody AccountInvoice accountInvoice) {
        return accountInvoiceService.save(accountInvoice);
    }

    //@PreAuthorize("hasRole('ACCOUNT_INVOICE_EDIT')")
    @RequestMapping(value = "/save", method = RequestMethod.PUT, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public AccountInvoice set(@RequestBody AccountInvoice accountInvoice) {
        return accountInvoiceService.save(accountInvoice);
    }

    //@PreAuthorize("hasRole('ACCOUNT_INVOICE_DELETE')")
    @RequestMapping(value = "/delete", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public void delete(@RequestBody AccountInvoice accountInvoice) {

        accountInvoiceService.delete(accountInvoice);
    }

    //@PreAuthorize("hasRole('ACCOUNT_INVOICE_DELETE')")
    @RequestMapping(value = "/delete/{id}", method = RequestMethod.DELETE, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public void delete(@PathVariable Long id) {
        accountInvoiceService.delete(id);
    }
    //@PreAuthorize("hasRole('ACCOUNT_INVOICE__CREATE')")
    @RequestMapping(method = RequestMethod.GET, value = "/nextval")
    @ResponseBody
    public String nextVal() {
        return "FC" + accountInvoiceService.getNextVal().toString();
    }
}