package com.sinno.ems.controller;

import com.sinno.ems.dto.Owner;
import com.sinno.ems.exception.AttributesNotFound;
import com.sinno.ems.exception.ErrorType;
import com.sinno.ems.exception.IdNotFound;
import com.sinno.ems.service.InvoiceService;
import com.sinno.ems.service.OwnerService;
import com.sinno.ems.service.UserDetailsServiceWarehouse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@Controller
@RequestMapping(value = "/invoices/")
public class InvoiceController {

    @Autowired
    private InvoiceService invoiceService;
    @Autowired
    private UserDetailsServiceWarehouse userDetailsService;
    @Autowired
    private OwnerService ownerService;


    @PreAuthorize("hasRole('INVOICE_VIEW')")
    @RequestMapping(method = RequestMethod.GET, value = "/list")
    @ResponseBody
    public List<Invoice> getInvoices() throws AttributesNotFound, ErrorType {
        if (null == userDetailsService.getOwners()) {
            return null;
        }
        return invoiceService.find(userDetailsService.getOwners().toString());
    }

    @PreAuthorize("hasRole('INVOICE_VIEW')")
    @RequestMapping(method = RequestMethod.GET, value = "/listPage")
    @ResponseBody
    public List<Invoice> getInvoices(@RequestParam int page, @RequestParam int size) throws AttributesNotFound, ErrorType {
        if (null == userDetailsService.getOwners()) {
            return null;
        }
        return invoiceService.find(userDetailsService.getOwners().toString(), page, size);
    }

    @PreAuthorize("hasRole('INVOICE_VIEW')")
    @RequestMapping(method = RequestMethod.GET, value = "/size")
    @ResponseBody
    public Long size() throws AttributesNotFound, ErrorType {
        if (null == userDetailsService.getOwners()) {
            return null;
        }
        return invoiceService.size(userDetailsService.getOwners().toString());
    }

    @PreAuthorize("hasRole('INVOICE_VIEW')")
    @RequestMapping(method = RequestMethod.GET, value = "/sizeSearch")
    @ResponseBody
    public Long size(@RequestParam String search) throws AttributesNotFound, ErrorType {
        if (null == userDetailsService.getOwners()) {
            return null;
        }
        if (!search.endsWith(",")) {
            search += ",";
        }
        return invoiceService.size(search + userDetailsService.getOwners().toString());
    }

    @PreAuthorize("hasRole('INVOICE_VIEW')")
    @RequestMapping(method = RequestMethod.GET, value = "/exist")
    @ResponseBody
    public Boolean exist(@RequestParam Long id) throws AttributesNotFound, ErrorType {
        return invoiceService.isExist(id);
    }

    @PreAuthorize("hasRole('INVOICE_VIEW')")
    @RequestMapping(method = RequestMethod.GET, value = "/{id}")
    @ResponseBody
    public Invoice getInvoice(@PathVariable("id") Long id) throws IdNotFound {
        return invoiceService.findById(id);
    }

    @PreAuthorize("hasRole('INVOICE_VIEW')")
    @RequestMapping(method = RequestMethod.GET, value = "/search")
    @ResponseBody
    public List<Invoice> search(@RequestParam(value = "search") String search) throws AttributesNotFound, ErrorType {
        if (null == userDetailsService.getOwners()) {
            return null;
        }
        if (!search.endsWith(",")) {
            search += ",";
        }
        return invoiceService.find(search + userDetailsService.getOwners().toString());
    }

    @PreAuthorize("hasRole('INVOICE_VIEW')")
    @RequestMapping(method = RequestMethod.GET, value = "/searchPage")
    @ResponseBody
    public List<Invoice> search(@RequestParam(value = "search") String search, @RequestParam int page, @RequestParam int size) throws AttributesNotFound, ErrorType {
        if (null == userDetailsService.getOwners()) {
            return null;
        }
        if (!search.endsWith(",")) {
            search += ",";
        }
        return invoiceService.find(search + userDetailsService.getOwners().toString(), page, size);
    }

    @PreAuthorize("hasRole('INVOICE_CREATE')")
    @RequestMapping(value = "/save", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public Invoice add(@RequestBody Invoice invoice) {
        return invoiceService.save(invoice);
    }

    @PreAuthorize("hasRole('INVOICE_EDIT')")
    @RequestMapping(value = "/save", method = RequestMethod.PUT, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public Invoice set(@RequestBody Invoice invoice) {
        return invoiceService.save(invoice);
    }

    @PreAuthorize("hasRole('INVOICE_DELETE')")
    @RequestMapping(value = "/delete", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public void delete(@RequestBody Invoice invoice) {

        invoiceService.delete(invoice);
    }

    @PreAuthorize("hasRole('INVOICE_DELETE')")
    @RequestMapping(value = "/delete/{id}", method = RequestMethod.DELETE, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public void delete(@PathVariable Long id) {
        invoiceService.delete(id);
    }

    @PreAuthorize("hasRole('INVOICE_CREATE')")
    @RequestMapping(method = RequestMethod.GET, value = "/nextval")
    @ResponseBody
    public String nextVal() {
        return "IVC" + invoiceService.getNextVal().toString();
    }

    @RequestMapping(value = "/genereteInvoice", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public Invoice generateInvoice(@RequestBody GenerateInvoice generateInvoice) {
        Owner owner = generateInvoice.getOwner();
        Date dateStart = generateInvoice.getStartDate();
        Date dateEnd = generateInvoice.getEndDate();
        Invoice invoice = null;

        try {
            invoice = invoiceService.createInvoice(dateStart, dateEnd, owner);
        } catch (AttributesNotFound attributesNotFound) {
            attributesNotFound.printStackTrace();
        } catch (ErrorType errorType) {
            errorType.printStackTrace();
        }

        return invoice;
    }

    @RequestMapping(value = "/genereteInvoiceFromInvoice", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public Invoice generateInvoiceFromOwner(@RequestBody GenerateInvoice generateInvoice) throws AttributesNotFound, ErrorType {
        return invoiceService.generateInvoiceFromOwner(generateInvoice);
    }
}