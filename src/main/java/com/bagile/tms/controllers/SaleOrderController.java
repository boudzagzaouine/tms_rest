package com.bagile.tms.controllers;

import com.bagile.tms.dto.SaleOrder;
import com.bagile.tms.exceptions.AttributesNotFound;
import com.bagile.tms.exceptions.ErrorType;
import com.bagile.tms.exceptions.IdNotFound;
import com.bagile.tms.services.SaleOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.MediaType;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping(value = "/saleOrders/")
public class SaleOrderController {

    @Autowired
    private SaleOrderService saleOrderService;
    @Autowired

    //@PreAuthorize("hasAnyRole('SALE_ORDER_VIEW','DELIVERY_VIEW')")
    @RequestMapping(method = RequestMethod.GET, value = "/list")
    @ResponseBody
    public List<SaleOrder> getSaleOrders() throws AttributesNotFound, ErrorType {
       
        return saleOrderService.findAll();
        //return saleOrderService.findAll();
    }

    //@PreAuthorize("hasAnyRole('SALE_ORDER_VIEW','DELIVERY_VIEW')")
    @RequestMapping(method = RequestMethod.GET, value = "/listPage")
    @ResponseBody
    public List<SaleOrder> getSaleOrders(@RequestParam int page, @RequestParam int size) throws AttributesNotFound, ErrorType {

        return saleOrderService.findAll(PageRequest.of(page,size));
        //return saleOrderService.findAll(pageable);
    }

    //@PreAuthorize("hasAnyRole('SALE_ORDER_VIEW','DELIVERY_VIEW')")
    @RequestMapping(method = RequestMethod.GET, value = "/size")
    @ResponseBody
    public Long size() throws AttributesNotFound, ErrorType {
        
        return saleOrderService.size();
    }

    //@PreAuthorize("hasAnyRole('SALE_ORDER_VIEW','DELIVERY_VIEW')")
    @RequestMapping(method = RequestMethod.GET, value = "/sizeSearch")
    @ResponseBody
    public Long size(@RequestParam String search) throws AttributesNotFound, ErrorType {

        return saleOrderService.size(search );
    }

    //@PreAuthorize("hasAnyRole('SALE_ORDER_VIEW','DELIVERY_VIEW')")
    @RequestMapping(method = RequestMethod.GET, value = "/exist")
    @ResponseBody
    public Boolean exist(@RequestParam Long id) throws AttributesNotFound, ErrorType {
        return saleOrderService.isExist(id);
    }

    //@PreAuthorize("hasAnyRole('SALE_ORDER_VIEW','DELIVERY_VIEW')")
    @RequestMapping(method = RequestMethod.GET, value = "/{id}")
    @ResponseBody
    public SaleOrder getSaleOrder(@PathVariable("id") Long id) throws IdNotFound {
        return saleOrderService.findById(id);
    }

    //@PreAuthorize("hasAnyRole('SALE_ORDER_VIEW','DELIVERY_VIEW')")
    @RequestMapping(method = RequestMethod.GET, value = "/search")
    @ResponseBody
    public List<SaleOrder> search(@RequestParam(value = "search") String search) throws AttributesNotFound, ErrorType {

        if (!search.endsWith(",")) {
            search += ",";
        }
        try {
            return saleOrderService.find(search  );
        } catch (Exception e) {
            System.err.println(e.getMessage());
            return null;
        }
    }

    //@PreAuthorize("hasAnyRole('SALE_ORDER_VIEW','DELIVERY_VIEW')")
    @RequestMapping(method = RequestMethod.GET, value = "/searchPage")
    @ResponseBody
    public List<SaleOrder> search(@RequestParam(value = "search") String search, @RequestParam int page, @RequestParam int size) throws AttributesNotFound, ErrorType {

        if (!search.endsWith(",")) {
            search += ",";
        }
        return saleOrderService.find(search  , page, size);
    }

    //@PreAuthorize("hasRole('SALE_ORDER_CREATE')")
    @RequestMapping(value = "/save", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public SaleOrder add(@RequestBody SaleOrder saleOrder) throws IdNotFound {
        return saleOrderService.save(saleOrder);
    }

    //@PreAuthorize("hasRole('SALE_ORDER_EDIT')")
    @RequestMapping(value = "/save", method = RequestMethod.PUT, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public SaleOrder set(@RequestBody SaleOrder saleOrder) throws IdNotFound {
        return saleOrderService.save(saleOrder);
    }

    //@PreAuthorize("hasRole('SALE_ORDER_DELETE')")
    @RequestMapping(value = "/delete", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public void delete(@RequestBody SaleOrder saleOrder) {

        saleOrderService.delete(saleOrder);
    }

    //@PreAuthorize("hasRole('SALE_ORDER_DELETE')")
    @RequestMapping(value = "/delete/{id}", method = RequestMethod.DELETE, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public void delete(@PathVariable Long id) {
        saleOrderService.delete(id);
    }

    //@PreAuthorize("hasRole('SALE_ORDER_CREATE')")
    @RequestMapping(method = RequestMethod.GET, value = "/nextval")
    @ResponseBody
    public String nextVal() {
        System.out.println("saleOrder nextVal : " + saleOrderService.getNextVal());
        return saleOrderService.getNextVal();
    }


}