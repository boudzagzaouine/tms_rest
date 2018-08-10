package com.bagile.tms.controllers;

import com.bagile.tms.dto.Warehouse;
import com.bagile.tms.exceptions.AttributesNotFound;
import com.bagile.tms.exceptions.ErrorType;
import com.bagile.tms.exceptions.IdNotFound;
import com.bagile.tms.services.UserDetailsServiceWarehouse;
import com.bagile.tms.services.WarehouseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.MediaType;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping(value = "/warehouses/")
public class WarehouseController {

    @Autowired
    private WarehouseService warehouseService;
    @Autowired
    @Qualifier("userDetailsService")
    private UserDetailsServiceWarehouse userDetailsService;

    //@PreAuthorize("isAuthenticated()")
    @RequestMapping(method = RequestMethod.GET, value = "/list")
    @ResponseBody
    public List<Warehouse> getWarehouses() throws AttributesNotFound, ErrorType {
        if (null == userDetailsService.getCodeWarehouses()) {
            return null;
        }
        return warehouseService.find(userDetailsService.getCodeWarehouses().toString());

        //return warehouseService.findAll();
    }

    //@PreAuthorize("isAuthenticated()")
    @RequestMapping(method = RequestMethod.GET, value = "/listPage")
    @ResponseBody
    public List<Warehouse> getWarehouses(@RequestParam int page, @RequestParam int size) throws AttributesNotFound, ErrorType {
        // Pageable pageable = PageRequest.of(page, size);
        if (null == userDetailsService.getCodeWarehouses()) {
            return null;
        }
        return warehouseService.find(userDetailsService.getCodeWarehouses().toString(), page, size);

        //return warehouseService.findAll(pageable);
    }

    //@PreAuthorize("isAuthenticated()")
    @RequestMapping(method = RequestMethod.GET, value = "/size")
    @ResponseBody
    public Long size() throws AttributesNotFound, ErrorType {
        if (null == userDetailsService.getCodeWarehouses()) {
            return null;
        }
        return warehouseService.size(userDetailsService.getCodeWarehouses().toString());
    }

    //@PreAuthorize("isAuthenticated()")
    @RequestMapping(method = RequestMethod.GET, value = "/sizeSearch")
    @ResponseBody
    public Long size(@RequestParam String search) throws AttributesNotFound, ErrorType {
        if (null == userDetailsService.getCodeWarehouses()) {
            return null;
        }
        if (!search.endsWith(",")) {
            search += ",";
        }
        search += userDetailsService.getCodeWarehouses();


        return warehouseService.size(search);
    }

    //@PreAuthorize("isAuthenticated()")
    @RequestMapping(method = RequestMethod.GET, value = "/exist")
    @ResponseBody
    public Boolean exist(@RequestParam Long id) throws AttributesNotFound, ErrorType {
        return warehouseService.isExist(id);
    }

    //@PreAuthorize("isAuthenticated()")
    @RequestMapping(method = RequestMethod.GET, value = "/{id}")
    @ResponseBody
    public Warehouse getWarehouse(@PathVariable("id") Long id) throws IdNotFound {
        return warehouseService.findById(id);
    }

    //@PreAuthorize("isAuthenticated()")
    @RequestMapping(method = RequestMethod.GET, value = "/search")
    @ResponseBody
    public List<Warehouse> search(@RequestParam(value = "search") String search) throws AttributesNotFound, ErrorType {
        if (null == userDetailsService.getCodeWarehouses()) {
            return null;
        }
        if (!search.endsWith(",")) {
            search += ",";
        }
        search += userDetailsService.getCodeWarehouses();

        return warehouseService.find(search);
    }

    //@PreAuthorize("isAuthenticated()")
    @RequestMapping(method = RequestMethod.GET, value = "/searchPage")
    @ResponseBody
    public List<Warehouse> search(@RequestParam(value = "search") String search, @RequestParam int page, @RequestParam int size) throws AttributesNotFound, ErrorType {
        if (null == userDetailsService.getCodeWarehouses()) {
            return null;
        }
        if (!search.endsWith(",")) {
            search += ",";
        }
        search += userDetailsService.getCodeWarehouses();
        return warehouseService.find(search, page, size);
    }

    //@PreAuthorize("hasRole('WAREHOUSE_CREATE')")
    @RequestMapping(value = "/save", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public Warehouse add(@RequestBody Warehouse warehouse) throws IdNotFound {
        return warehouseService.save(warehouse);
    }

    //@PreAuthorize("hasRole('WAREHOUSE_EDIT')")
    @RequestMapping(value = "/save", method = RequestMethod.PUT, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public Warehouse set(@RequestBody Warehouse warehouse) throws IdNotFound {
        return warehouseService.save(warehouse);
    }

    //@PreAuthorize("hasRole('WAREHOUSE_DELETE')")
    @RequestMapping(value = "/delete", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public void delete(@RequestBody Warehouse warehouse) {

        warehouseService.delete(warehouse);
    }

    //@PreAuthorize("hasRole('WAREHOUSE_DELETE')")
    @RequestMapping(value = "/delete/{id}", method = RequestMethod.DELETE, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public void delete(@PathVariable Long id) throws Exception {
        warehouseService.delete(id);
    }

}