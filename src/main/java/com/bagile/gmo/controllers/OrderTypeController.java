package com.bagile.gmo.controllers;

import com.bagile.gmo.dto.OrderType;
import com.bagile.gmo.exceptions.AttributesNotFound;
import com.bagile.gmo.exceptions.ErrorType;
import com.bagile.gmo.exceptions.IdNotFound;
import com.bagile.gmo.services.OrderTypeService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.MediaType;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping(value = "/orderTypes/")
public class OrderTypeController {

    @Autowired
    private OrderTypeService orderTypeService;

   // @PreAuthorize("hasAnyRole('ORDER_TYPE_VIEW','DELIVERY_VIEW','RECEPTION_VIEW','SALE_ORDER_VIEW','PURSHASE_ORDER_VIEW')")
    @RequestMapping(method = RequestMethod.GET,value = "/list")
    @ResponseBody
    public List<OrderType> getOrderTypes() throws AttributesNotFound, ErrorType {
        return orderTypeService.findAll();
    }

    //@PreAuthorize("hasAnyRole('ORDER_TYPE_VIEW','DELIVERY_VIEW','RECEPTION_VIEW','SALE_ORDER_VIEW','PURSHASE_ORDER_VIEW')")
    @RequestMapping(method = RequestMethod.GET, value = "/listPage")
    @ResponseBody
    public List<OrderType> getOrderTypes(@RequestParam int page, @RequestParam int size) throws AttributesNotFound, ErrorType {

        return orderTypeService.findAll(page,size);
    }

   // @PreAuthorize("hasAnyRole('ORDER_TYPE_VIEW','DELIVERY_VIEW','RECEPTION_VIEW','SALE_ORDER_VIEW','PURSHASE_ORDER_VIEW')")
    @RequestMapping(method = RequestMethod.GET, value = "/size")
    @ResponseBody
    public Long size() {
        return orderTypeService.size();
    }

   // @PreAuthorize("hasRole('ORDER_TYPE_VIEW')")
    @RequestMapping(method = RequestMethod.GET, value = "/sizeSearch")
    @ResponseBody
    public Long size(@RequestParam String search) throws AttributesNotFound, ErrorType {
        return orderTypeService.size(search);
    }

    //@PreAuthorize("hasAnyRole('ORDER_TYPE_VIEW','DELIVERY_VIEW','RECEPTION_VIEW','SALE_ORDER_VIEW','PURSHASE_ORDER_VIEW')")     @RequestMapping(method = RequestMethod.GET, value = "/exist")
    @ResponseBody
    public Boolean exist(@RequestParam Long id) throws AttributesNotFound, ErrorType {
        return orderTypeService.isExist(id);
    }
    ///@PreAuthorize("hasAnyRole('ORDER_TYPE_VIEW','DELIVERY_VIEW','RECEPTION_VIEW','SALE_ORDER_VIEW','PURSHASE_ORDER_VIEW')")     @RequestMapping(method = RequestMethod.GET,value = "/{id}")
    @ResponseBody
    public OrderType getOrderType(@PathVariable("id") Long id) throws IdNotFound {
        return orderTypeService.findById(id);
    }

   // @PreAuthorize("hasAnyRole('ORDER_TYPE_VIEW','DELIVERY_VIEW','RECEPTION_VIEW','SALE_ORDER_VIEW','PURSHASE_ORDER_VIEW')")     @RequestMapping(method = RequestMethod.GET, value = "/search")
    @ResponseBody
    public List<OrderType> search(@RequestParam(value = "search") String search) throws AttributesNotFound, ErrorType {
        return orderTypeService.find(search);
    }

   // @PreAuthorize("hasAnyRole('ORDER_TYPE_VIEW','DELIVERY_VIEW','RECEPTION_VIEW','SALE_ORDER_VIEW','PURSHASE_ORDER_VIEW')")     @RequestMapping(method = RequestMethod.GET, value = "/searchPage")
    @ResponseBody
    public List<OrderType> search(@RequestParam(value = "search") String search, @RequestParam int page, @RequestParam int size) throws AttributesNotFound, ErrorType {
        return orderTypeService.find(search, page,size);
    }

   // @PreAuthorize("hasRole('ORDER_TYPE_CREATE')")
    @RequestMapping(value = "/save", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public OrderType add(@RequestBody OrderType orderType) {
        return orderTypeService.save(orderType);
    }

   // @PreAuthorize("hasRole('ORDER_TYPE_EDIT')")
    @RequestMapping(value = "/save", method = RequestMethod.PUT, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public OrderType set(@RequestBody OrderType orderType) {
        return orderTypeService.save(orderType);
    }

   /// @PreAuthorize("hasRole('ORDER_TYPE_DELETE')")
    @RequestMapping(value = "/delete", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public void delete(@RequestBody OrderType orderType) {

        orderTypeService.delete(orderType);
    }

    //@PreAuthorize("hasRole('ORDER_TYPE_DELETE')")
    @RequestMapping(value = "/delete/{id}", method = RequestMethod.DELETE, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public void delete(@PathVariable Long id) {
        orderTypeService.delete(id);
    }
}