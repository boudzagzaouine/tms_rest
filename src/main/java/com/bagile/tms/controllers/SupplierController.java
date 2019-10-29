package com.bagile.tms.controllers;

import com.bagile.tms.dto.Supplier;
import com.bagile.tms.exceptions.AttributesNotFound;
import com.bagile.tms.exceptions.ErrorType;
import com.bagile.tms.exceptions.IdNotFound;
import com.bagile.tms.services.SupplierService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping(value="/suppliers")
public class SupplierController {
    private final SupplierService supplierService;

    public SupplierController(SupplierService supplierService) {
        this.supplierService = supplierService;
    }

    //@PreAuthorize("hasAnyRole('BADGE_VIEW')")
    @RequestMapping(method = RequestMethod.GET, value = "/list")
    @ResponseBody
    public List<Supplier> getSuppliers() {
        return supplierService.findAll();
    }
    //@PreAuthorize("hasAnyRole('BADGE_VIEW')")
    @RequestMapping(method = RequestMethod.GET, value = "/listPage")
    @ResponseBody
    public List<Supplier> getSuppliers(@RequestParam int page, @RequestParam int size) {
        return supplierService.findAll(page, size);

    }
    //@PreAuthorize("hasAnyRole('BADGE_VIEW')")
    @RequestMapping(method = RequestMethod.GET, value = "/size")
    @ResponseBody
    public Long size() {
        return supplierService.size();
    }
    //@PreAuthorize("hasAnyRole('BADGE_VIEW')")
    @RequestMapping(method = RequestMethod.GET, value = "/sizeSearch")
    @ResponseBody
    public Long size(@RequestParam String search) throws AttributesNotFound, ErrorType {
        return supplierService.size(search);
    }
    //@PreAuthorize("hasAnyRole('BADGE_VIEW')")
    @RequestMapping(method = RequestMethod.GET, value = "/exist")
    @ResponseBody
    public Boolean exist(@RequestParam Long id) throws AttributesNotFound, ErrorType {
        return supplierService.isExist(id);
    }
    //@PreAuthorize("hasAnyRole('BADGE_VIEW')")
    @RequestMapping(method = RequestMethod.GET, value = "/{id}")
    @ResponseBody
    public Supplier getSupplier(@PathVariable("id") Long id) throws IdNotFound {
        return supplierService.findById(id);
    }
    //@PreAuthorize("hasAnyRole('BADGE_VIEW')")
    @RequestMapping(method = RequestMethod.GET, value = "/search")
    @ResponseBody
    public List<Supplier> search(@RequestParam(value = "search") String search) throws AttributesNotFound, ErrorType {
        return supplierService.find(search);
    }

    //@PreAuthorize("hasAnyRole('BADGE_VIEW')")
    @RequestMapping(method = RequestMethod.GET, value = "/searchPage")
    @ResponseBody
    public List<Supplier> search(@RequestParam(value = "search") String search, @RequestParam int page, @RequestParam int size) throws AttributesNotFound, ErrorType {
        return supplierService.find(search, page, size);
    }
    //@PreAuthorize("hasRole('BADGE_CREATE')")
    @RequestMapping(value = "/save", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public Supplier add(@RequestBody Supplier supplier) {
        return supplierService.save(supplier);
    }
    //@PreAuthorize("hasRole('BADGE_EDIT')")
    @RequestMapping(value = "/save", method = RequestMethod.PUT, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public Supplier set(@RequestBody Supplier supplier) {
        return supplierService.save(supplier);
    }
    //@PreAuthorize("hasRole('BADGE_DELETE')")
    @RequestMapping(value = "/delete", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public void delete(@RequestBody Supplier supplier) {
        supplierService.delete(supplier);
    }
    //@PreAuthorize("hasRole('BADGE_DELETE')")
    @RequestMapping(value = "/delete/{id}", method = RequestMethod.DELETE, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public void delete(@PathVariable Long id) {
        supplierService.delete(id);
    }

}
