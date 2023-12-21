package com.bagile.gmo.controllers;

import com.bagile.gmo.dto.OrderTransportInfoLineDocument;
import com.bagile.gmo.exceptions.AttributesNotFound;
import com.bagile.gmo.exceptions.ErrorType;
import com.bagile.gmo.exceptions.IdNotFound;
import com.bagile.gmo.services.OrderTransportInfoLineDocumentService;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;

@Controller
@RequestMapping(value = "/orderTransportInfoLineDocuments")
public class OrderTransportInfoLineDocumentController {

    private final OrderTransportInfoLineDocumentService orderTransportInfoLineDocumentService;

    public OrderTransportInfoLineDocumentController(OrderTransportInfoLineDocumentService orderTransportInfoLineDocumentService) {
        this.orderTransportInfoLineDocumentService = orderTransportInfoLineDocumentService;
    }

    //@PreAuthorize("hasAnyRole('BADGETYPE_VIEW')")
    @RequestMapping(method = RequestMethod.GET, value = "/list")
    @ResponseBody
    public List<OrderTransportInfoLineDocument> getOrderTransportInfoLineDocuments() {return orderTransportInfoLineDocumentService.findAll();}
   //@PreAuthorize("hasAnyRole('BADGETYPE_VIEW')")
    @RequestMapping(method = RequestMethod.GET, value = "/listPage")
    @ResponseBody
    public List<OrderTransportInfoLineDocument> getOrderTransportInfoLineDocument(@RequestParam int page, @RequestParam int size) {
        return orderTransportInfoLineDocumentService.findAll(page, size);

    }
    //@PreAuthorize("hasAnyRole('BADGETYPE_VIEW')")
    @RequestMapping(method = RequestMethod.GET, value = "/size")
    @ResponseBody
    public Long size() {
        return orderTransportInfoLineDocumentService.size();
    }
    //@PreAuthorize("hasAnyRole('BADGETYPE_VIEW')")
    @RequestMapping(method = RequestMethod.GET, value = "/sizeSearch")
    @ResponseBody
    public Long size(@RequestParam String search) throws AttributesNotFound, ErrorType {
        return orderTransportInfoLineDocumentService.size(search);
    }
    //@PreAuthorize("hasAnyRole('BADGETYPE_VIEW')")
    @RequestMapping(method = RequestMethod.GET, value = "/exist")
    @ResponseBody
    public Boolean exist(@RequestParam Long id) throws AttributesNotFound, ErrorType {
        return orderTransportInfoLineDocumentService.isExist(id);
    }
    //@PreAuthorize("hasAnyRole('BADGETYPE_VIEW')")
    @RequestMapping(method = RequestMethod.GET, value = "/{id}")
    @ResponseBody
    public OrderTransportInfoLineDocument getOrderTransportInfoLineDocument(@PathVariable("id") Long id) throws IdNotFound {
        return orderTransportInfoLineDocumentService.findById(id);
    }
    //@PreAuthorize("hasAnyRole('BADGETYPE_VIEW')")
    @RequestMapping(method = RequestMethod.GET, value = "/search")
    @ResponseBody
    public List<OrderTransportInfoLineDocument> search(@RequestParam(value = "search") String search) throws AttributesNotFound, ErrorType {
        return orderTransportInfoLineDocumentService.find(search);
    }
    //@PreAuthorize("hasAnyRole('BADGETYPE_VIEW')")
    @RequestMapping(method = RequestMethod.GET, value = "/searchPage")
    @ResponseBody
    public List<OrderTransportInfoLineDocument> search(@RequestParam(value = "search") String search, @RequestParam int page, @RequestParam int size) throws AttributesNotFound, ErrorType {
        return orderTransportInfoLineDocumentService.find(search, page, size);

    }
    //@PreAuthorize("hasRole('BADGETYPE_CREATE')")
    @RequestMapping(value = "/save", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public OrderTransportInfoLineDocument add(@RequestBody OrderTransportInfoLineDocument orderTransportInfoLineDocument ){return orderTransportInfoLineDocumentService.save(orderTransportInfoLineDocument);}
    //@PreAuthorize("hasRole('BADGETYPE_EDIT')")
    @RequestMapping(value = "/save", method = RequestMethod.PUT, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public OrderTransportInfoLineDocument set(@RequestBody OrderTransportInfoLineDocument orderTransportInfoLineDocument) {
        return orderTransportInfoLineDocumentService.save(orderTransportInfoLineDocument);
    }
    //@PreAuthorize("hasRole('BADGETYPE_DELETE')")
    @RequestMapping(value = "/delete", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public void delete(@RequestBody OrderTransportInfoLineDocument orderTransportInfoLineDocument) throws ErrorType, AttributesNotFound {

        orderTransportInfoLineDocumentService.delete(orderTransportInfoLineDocument);
    }

    //@PreAuthorize("hasRole('BADGETYPE_DELETE')")
    @RequestMapping(value = "/delete/{id}", method = RequestMethod.DELETE, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public void delete(@PathVariable Long id) throws ErrorType, AttributesNotFound {
        orderTransportInfoLineDocumentService.delete(id);
    }


    @RequestMapping(value = "/deleteAll", method = RequestMethod.DELETE)
    @ResponseBody
    public void deleteAll(@RequestParam(value = "ids") Long[] ids) {
        orderTransportInfoLineDocumentService.deleteAll (Arrays.asList(ids));
    }
}