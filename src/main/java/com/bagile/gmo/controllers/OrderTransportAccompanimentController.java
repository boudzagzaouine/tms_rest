package com.bagile.gmo.controllers;

import com.bagile.gmo.dto.OrderTransportAccompaniment;
import com.bagile.gmo.exceptions.AttributesNotFound;
import com.bagile.gmo.exceptions.ErrorType;
import com.bagile.gmo.exceptions.IdNotFound;
import com.bagile.gmo.services.OrderTransportAccompanimentService;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping(value="/orderTransportAccompaniments")
public class OrderTransportAccompanimentController {
    private final OrderTransportAccompanimentService orderTransportAccompanimentService;

    public OrderTransportAccompanimentController(OrderTransportAccompanimentService orderTransportAccompanimentService) {
        this.orderTransportAccompanimentService = orderTransportAccompanimentService;
    }

    //@PreAuthorize("hasAnyRole('BADGE_VIEW')")
    @RequestMapping(method = RequestMethod.GET, value = "/list")
    @ResponseBody
    public List<OrderTransportAccompaniment> getOrderTransportAccompaniments() {
        return orderTransportAccompanimentService.findAll();
    }
    //@PreAuthorize("hasAnyRole('BADGE_VIEW')")
    @RequestMapping(method = RequestMethod.GET, value = "/listPage")
    @ResponseBody
    public List<OrderTransportAccompaniment> getOrderTransportAccompaniments(@RequestParam int page, @RequestParam int size) {
        return orderTransportAccompanimentService.findAll(page, size);

    }
    //@PreAuthorize("hasAnyRole('BADGE_VIEW')")
    @RequestMapping(method = RequestMethod.GET, value = "/size")
    @ResponseBody
    public Long size() {
        return orderTransportAccompanimentService.size();
    }

    //@PreAuthorize("hasAnyRole('BADGE_VIEW')")
    @RequestMapping(method = RequestMethod.GET, value = "/sizeSearch")
    @ResponseBody
    public Long size(@RequestParam String search) throws AttributesNotFound, ErrorType {
        return orderTransportAccompanimentService.size(search);
    }

    //@PreAuthorize("hasAnyRole('BADGE_VIEW')")
    @RequestMapping(method = RequestMethod.GET, value = "/exist")
    @ResponseBody
    public Boolean exist(@RequestParam Long id) throws AttributesNotFound, ErrorType {
        return orderTransportAccompanimentService.isExist(id);
    }

    //@PreAuthorize("hasAnyRole('BADGE_VIEW')")
    @RequestMapping(method = RequestMethod.GET, value = "/{id}")
    @ResponseBody
    public OrderTransportAccompaniment getOrderTransportAccompaniment(@PathVariable("id") Long id) throws IdNotFound {
        return orderTransportAccompanimentService.findById(id);
    }

    //@PreAuthorize("hasAnyRole('BADGE_VIEW')")
    @RequestMapping(method = RequestMethod.GET, value = "/search")
    @ResponseBody
    public List<OrderTransportAccompaniment> search(@RequestParam(value = "search") String search) throws AttributesNotFound, ErrorType {
        return orderTransportAccompanimentService.find(search);
    }

    //@PreAuthorize("hasAnyRole('BADGE_VIEW')")
    @RequestMapping(method = RequestMethod.GET, value = "/searchPage")
    @ResponseBody
    public List<OrderTransportAccompaniment> search(@RequestParam(value = "search") String search, @RequestParam int page, @RequestParam int size) throws AttributesNotFound, ErrorType {
        return orderTransportAccompanimentService.find(search, page, size);
    }

    //@PreAuthorize("hasRole('BADGE_CREATE')")
    @RequestMapping(value = "/save", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public OrderTransportAccompaniment add(@RequestBody OrderTransportAccompaniment orderTransportAccompaniment) throws ErrorType, AttributesNotFound {
        return orderTransportAccompanimentService.save(orderTransportAccompaniment);
    }

    //@PreAuthorize("hasRole('BADGE_EDIT')")
    @RequestMapping(value = "/save", method = RequestMethod.PUT, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public OrderTransportAccompaniment set(@RequestBody OrderTransportAccompaniment orderTransportAccompaniment) throws ErrorType, AttributesNotFound {
        return orderTransportAccompanimentService.save(orderTransportAccompaniment);
    }

    //@PreAuthorize("hasRole('BADGE_DELETE')")
    @RequestMapping(value = "/delete", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public void delete(@RequestBody OrderTransportAccompaniment orderTransportAccompaniment) {
        orderTransportAccompanimentService.delete(orderTransportAccompaniment);
    }

    //@PreAuthorize("hasRole('BADGE_DELETE')")
    @RequestMapping(value = "/delete/{id}", method = RequestMethod.DELETE, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public void delete(@PathVariable Long id) {
        orderTransportAccompanimentService.delete(id);
    }

}
