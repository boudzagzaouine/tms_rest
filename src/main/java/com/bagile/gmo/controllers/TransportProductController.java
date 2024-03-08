package com.bagile.gmo.controllers;

import com.bagile.gmo.dto.TransportProduct;
import com.bagile.gmo.exceptions.AttributesNotFound;
import com.bagile.gmo.exceptions.ErrorType;
import com.bagile.gmo.exceptions.IdNotFound;
import com.bagile.gmo.services.TransportProductService;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;

@Controller
@RequestMapping(value = "/transportProducts")
public class TransportProductController {

    private final TransportProductService transportProductService;

    public TransportProductController(TransportProductService transportProductService) {
        this.transportProductService = transportProductService;
    }

    @RequestMapping(method = RequestMethod.GET, value = "/list")
    @ResponseBody
    public List<TransportProduct> getTransportProducts() {return transportProductService.findAll();}
    @RequestMapping(method = RequestMethod.GET, value = "/listPage")
    @ResponseBody
    public List<TransportProduct> getTransportProduct(@RequestParam int page, @RequestParam int size) {
        return transportProductService.findAll(page, size);

    }
    @RequestMapping(method = RequestMethod.GET, value = "/size")
    @ResponseBody
    public Long size() {
        return transportProductService.size();
    }
    @RequestMapping(method = RequestMethod.GET, value = "/sizeSearch")
    @ResponseBody
    public Long size(@RequestParam String search) throws AttributesNotFound, ErrorType {
        return transportProductService.size(search);
    }
    @RequestMapping(method = RequestMethod.GET, value = "/exist")
    @ResponseBody
    public Boolean exist(@RequestParam Long id) throws AttributesNotFound, ErrorType {
        return transportProductService.isExist(id);
    }
    @RequestMapping(method = RequestMethod.GET, value = "/{id}")
    @ResponseBody
    public TransportProduct getTransportProduct(@PathVariable("id") Long id) throws IdNotFound {
        return transportProductService.findById(id);
    }
    @RequestMapping(method = RequestMethod.GET, value = "/search")
    @ResponseBody
    public List<TransportProduct> search(@RequestParam(value = "search") String search) throws AttributesNotFound, ErrorType {
        return transportProductService.find(search);
    }
    @RequestMapping(method = RequestMethod.GET, value = "/searchPage")
    @ResponseBody
    public List<TransportProduct> search(@RequestParam(value = "search") String search, @RequestParam int page, @RequestParam int size) throws AttributesNotFound, ErrorType {
        return transportProductService.find(search, page, size);

    }
    @RequestMapping(value = "/save", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public TransportProduct add(@RequestBody TransportProduct transportProduct ){return transportProductService.save(transportProduct);}
    @RequestMapping(value = "/save", method = RequestMethod.PUT, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public TransportProduct set(@RequestBody TransportProduct transportProduct) {
        return transportProductService.save(transportProduct);
    }
    @RequestMapping(value = "/delete", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public void delete(@RequestBody TransportProduct transportProduct) {

        transportProductService.delete(transportProduct);
    }

    @RequestMapping(value = "/delete/{id}", method = RequestMethod.DELETE, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public void delete(@PathVariable Long id) {
        transportProductService.delete(id);
    }


    @RequestMapping(value = "/deleteAll", method = RequestMethod.DELETE)
    @ResponseBody
    public void deleteAll(@RequestParam(value = "ids") Long[] ids) {
        transportProductService.deleteAll (Arrays.asList(ids));
    }
}