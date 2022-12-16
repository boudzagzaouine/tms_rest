package com.bagile.gmo.controllers;

import com.bagile.gmo.dto.Product;
import com.bagile.gmo.exceptions.AttributesNotFound;
import com.bagile.gmo.exceptions.ErrorType;
import com.bagile.gmo.exceptions.IdNotFound;
import com.bagile.gmo.services.ProductServiceService;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;

@Controller
@RequestMapping(value = "/productServiceServices")
public class ProductServiceController {

    private final ProductServiceService productServiceService;

    public ProductServiceController(ProductServiceService productServiceService) {
        this.productServiceService = productServiceService;
    }

    @RequestMapping(method = RequestMethod.GET, value = "/list")
    @ResponseBody
    public List<Product> getProducts() throws AttributesNotFound, ErrorType {return productServiceService.findAll();}
    @RequestMapping(method = RequestMethod.GET, value = "/listPage")
    @ResponseBody
    public List<Product> getProduct(@RequestParam int page, @RequestParam int size) throws AttributesNotFound, ErrorType {

        Sort sort = Sort.by (Sort.Direction.DESC, "updateDate");
        Pageable pageable = PageRequest.of (page, size, sort);
        return productServiceService.findAll (pageable);

    }
    @RequestMapping(method = RequestMethod.GET, value = "/size")
    @ResponseBody
    public Long size() throws AttributesNotFound, ErrorType {
        return productServiceService.size();
    }
    @RequestMapping(method = RequestMethod.GET, value = "/sizeSearch")
    @ResponseBody
    public Long size(@RequestParam String search) throws AttributesNotFound, ErrorType {
        return productServiceService.size(search);
    }
    @RequestMapping(method = RequestMethod.GET, value = "/exist")
    @ResponseBody
    public Boolean exist(@RequestParam Long id) throws AttributesNotFound, ErrorType {
        return productServiceService.isExist(id);
    }
    @RequestMapping(method = RequestMethod.GET, value = "/{id}")
    @ResponseBody
    public Product getProduct(@PathVariable("id") Long id) throws IdNotFound {
        return productServiceService.findById(id);
    }
    @RequestMapping(method = RequestMethod.GET, value = "/search")
    @ResponseBody
    public List<Product> search(@RequestParam(value = "search") String search) throws AttributesNotFound, ErrorType {
        return productServiceService.find(search);
    }
    @RequestMapping(method = RequestMethod.GET, value = "/searchPage")
    @ResponseBody
    public List<Product> search(@RequestParam(value = "search") String search, @RequestParam int page, @RequestParam int size) throws AttributesNotFound, ErrorType {
        Pageable pageable = PageRequest.of (page, size);
        return productServiceService.find (search, pageable);


    }
    @RequestMapping(value = "/save", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public Product add(@RequestBody Product product ) throws IdNotFound, AttributesNotFound, ErrorType {return productServiceService.save(product);}
    @RequestMapping(value = "/save", method = RequestMethod.PUT, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public Product set(@RequestBody Product product) throws IdNotFound, AttributesNotFound, ErrorType {
        return productServiceService.save(product);
    }
    @RequestMapping(value = "/delete", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public void delete(@RequestBody Product product) {

        productServiceService.delete(product);
    }

    @RequestMapping(value = "/delete/{id}", method = RequestMethod.DELETE, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public void delete(@PathVariable Long id) {
        productServiceService.delete(id);
    }


    @RequestMapping(value = "/deleteAll", method = RequestMethod.DELETE)
    @ResponseBody
    public void deleteAll(@RequestParam(value = "ids") Long[] ids) throws AttributesNotFound, ErrorType {
        productServiceService.deleteAll (Arrays.asList(ids));
    }
}