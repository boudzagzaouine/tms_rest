package com.bagile.tms.controllers;

import com.bagile.tms.dto.Address;
import com.bagile.tms.exceptions.AttributesNotFound;
import com.bagile.tms.exceptions.ErrorType;
import com.bagile.tms.exceptions.IdNotFound;
import com.bagile.tms.services.AddressService;
import com.bagile.tms.services.UserDetailsServiceWarehouse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping(value = "/addresss/")
public class AddressController {

    @Autowired
    private AddressService addressService;
    @Autowired
    private UserDetailsServiceWarehouse userDetailsService;

    @PreAuthorize("hasAnyRole('ADDRESS_VIEW','PURSHASE_ORDER_VIEW','SALE_ORDER_VIEW','RECEPTION_VIEW','DELIVERY_VIEW','OWNER_VIEW','TRANSPORT_VIEW','SUPPLIER_VIEW','ACCOUNT_VIEW','WAREHOUSE_VIEW','INVOICE_VIEW')")
    @RequestMapping(method = RequestMethod.GET, value = "/list")
    @ResponseBody
    public List<Address> getAddresss() throws AttributesNotFound, ErrorType {
        if (null == userDetailsService.getOwners()) {
            return null;
        }
        return addressService.find(userDetailsService.getOwners().toString());
    }

    @PreAuthorize("hasAnyRole('ADDRESS_VIEW','PURSHASE_ORDER_VIEW','SALE_ORDER_VIEW','RECEPTION_VIEW','DELIVERY_VIEW','OWNER_VIEW','TRANSPORT_VIEW','SUPPLIER_VIEW','ACCOUNT_VIEW','WAREHOUSE_VIEW','INVOICE_VIEW')")
    @RequestMapping(method = RequestMethod.GET, value = "/listPage")
    @ResponseBody
    public List<Address> getAddresss(@RequestParam int page, @RequestParam int size) throws AttributesNotFound, ErrorType {
        if (null == userDetailsService.getOwners()) {
            return null;
        }
        return addressService.find(userDetailsService.getOwners().toString(), page, size);
    }

    @PreAuthorize("hasAnyRole('ADDRESS_VIEW','PURSHASE_ORDER_VIEW','SALE_ORDER_VIEW','RECEPTION_VIEW','DELIVERY_VIEW','OWNER_VIEW','TRANSPORT_VIEW','SUPPLIER_VIEW','ACCOUNT_VIEW','WAREHOUSE_VIEW','INVOICE_VIEW')")
    @RequestMapping(method = RequestMethod.GET, value = "/size")
    @ResponseBody
    public Long size() throws AttributesNotFound, ErrorType {
        if (null == userDetailsService.getOwners()) {
            return null;
        }
        return addressService.size(userDetailsService.getOwners().toString());
    }

    @PreAuthorize("hasAnyRole('ADDRESS_VIEW','PURSHASE_ORDER_VIEW','SALE_ORDER_VIEW','RECEPTION_VIEW','DELIVERY_VIEW','OWNER_VIEW','TRANSPORT_VIEW','SUPPLIER_VIEW','ACCOUNT_VIEW','WAREHOUSE_VIEW','INVOICE_VIEW')")
    @RequestMapping(method = RequestMethod.GET, value = "/sizeSearch")
    @ResponseBody
    public Long size(@RequestParam String search) throws AttributesNotFound, ErrorType {
        if (null == userDetailsService.getOwners()) {
            return null;
        }
        if (!search.endsWith(",")) {
            search += ",";
        }
        return addressService.size(search + userDetailsService.getOwners().toString());
    }

    @PreAuthorize("hasAnyRole('ADDRESS_VIEW','PURSHASE_ORDER_VIEW','SALE_ORDER_VIEW','RECEPTION_VIEW','DELIVERY_VIEW','OWNER_VIEW','TRANSPORT_VIEW','SUPPLIER_VIEW','ACCOUNT_VIEW','WAREHOUSE_VIEW','INVOICE_VIEW')")
    @RequestMapping(method = RequestMethod.GET, value = "/exist")
    @ResponseBody
    public Boolean exist(@RequestParam Long id) throws AttributesNotFound, ErrorType {
        return addressService.isExist(id);
    }

    @PreAuthorize("hasAnyRole('ADDRESS_VIEW','PURSHASE_ORDER_VIEW','SALE_ORDER_VIEW','RECEPTION_VIEW','DELIVERY_VIEW','OWNER_VIEW','TRANSPORT_VIEW','SUPPLIER_VIEW','ACCOUNT_VIEW','WAREHOUSE_VIEW','INVOICE_VIEW')")
    @RequestMapping(method = RequestMethod.GET, value = "/{id}")
    @ResponseBody
    public Address getAddress(@PathVariable("id") Long id) throws IdNotFound {
        return addressService.findById(id);
    }

    @PreAuthorize("hasAnyRole('ADDRESS_VIEW','PURSHASE_ORDER_VIEW','SALE_ORDER_VIEW','RECEPTION_VIEW','DELIVERY_VIEW','OWNER_VIEW','TRANSPORT_VIEW','SUPPLIER_VIEW','ACCOUNT_VIEW','WAREHOUSE_VIEW','INVOICE_VIEW')")
    @RequestMapping(method = RequestMethod.GET, value = "/search")
    @ResponseBody
    public List<Address> search(@RequestParam(value = "search") String search) throws AttributesNotFound, ErrorType {
        if (null == userDetailsService.getOwners()) {
            return null;
        }
        if (!search.endsWith(",")) {
            search += ",";
        }
        return addressService.find(search + userDetailsService.getOwners().toString());
    }

    @PreAuthorize("hasAnyRole('ADDRESS_VIEW','PURSHASE_ORDER_VIEW','SALE_ORDER_VIEW','RECEPTION_VIEW','DELIVERY_VIEW','OWNER_VIEW','TRANSPORT_VIEW','SUPPLIER_VIEW','ACCOUNT_VIEW','WAREHOUSE_VIEW','INVOICE_VIEW')")
    @RequestMapping(method = RequestMethod.GET, value = "/searchPage")
    @ResponseBody
    public List<Address> search(@RequestParam(value = "search") String search, @RequestParam int page, @RequestParam int size) throws AttributesNotFound, ErrorType {
       // Pageable pageable = PageRequest.of(page, size);
        if (null == userDetailsService.getOwners()) {
            return null;
        }
        if (!search.endsWith(",")) {
            search += ",";
        }
        return addressService.find(search + userDetailsService.getOwners().toString(), page, size);
    }

    @PreAuthorize("hasAnyRole('ADDRESS_CREATE','PURSHASE_ORDER_VIEW','SALE_ORDER_VIEW','RECEPTION_VIEW','DELIVERY_VIEW','OWNER_VIEW','TRANSPORT_VIEW','SUPPLIER_VIEW','ACCOUNT_VIEW','WAREHOUSE_VIEW','INVOICE_VIEW')")
    @RequestMapping(value = "/save", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public Address add(@RequestBody Address address) {
        return addressService.save(address);
    }

    @PreAuthorize("hasAnyRole('ADDRESS_EDIT','PURSHASE_ORDER_VIEW','SALE_ORDER_VIEW','RECEPTION_VIEW','DELIVERY_VIEW','OWNER_VIEW','TRANSPORT_VIEW','SUPPLIER_VIEW','ACCOUNT_VIEW','WAREHOUSE_VIEW','INVOICE_VIEW')")
    @RequestMapping(value = "/save", method = RequestMethod.PUT, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public Address set(@RequestBody Address address) {
        return addressService.save(address);
    }

    @PreAuthorize("hasRole('ADDRESS_DELETE')")
    @RequestMapping(value = "/delete", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public void delete(@RequestBody Address address) {

        addressService.delete(address);
    }

    @PreAuthorize("hasRole('ADDRESS_DELETE')")
    @RequestMapping(value = "/delete/{id}", method = RequestMethod.DELETE, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public void delete(@PathVariable Long id) {
        addressService.delete(id);
    }
}