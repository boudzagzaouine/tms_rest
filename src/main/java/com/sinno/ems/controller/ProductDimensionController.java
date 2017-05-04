package com.sinno.ems.controller;

import com.sinno.ems.dto.ProductDimension;
import com.sinno.ems.exception.AttributesNotFound;
import com.sinno.ems.exception.ErrorType;
import com.sinno.ems.exception.IdNotFound;
import com.sinno.ems.service.ProductDimensionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.MediaType;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by Enissay on 13/03/2017.
 */
@Controller
@RequestMapping(value = "/productDimensions/")
public class ProductDimensionController {

    @Autowired
    private ProductDimensionService productDimensionService;

    @PreAuthorize("hasAnyRole('PRODUCTDIMENSION_VIEW','PRODUCT_VIEW')")
    @RequestMapping(method = RequestMethod.GET,value = "/list")
    @ResponseBody
    public List<ProductDimension> getProductDimensions() {
        return productDimensionService.findAll();
    }

    @PreAuthorize("hasAnyRole('PRODUCTDIMENSION_VIEW','PRODUCT_VIEW')")
    @RequestMapping(method = RequestMethod.GET, value = "/listPage")
    @ResponseBody
    public List<ProductDimension> getProductDimensions(@RequestParam int page, @RequestParam int size) {
        Sort sort = new Sort(Sort.Direction.DESC, "prmProductDimensionUpdateDate");
        Pageable pageable = new PageRequest(page, size,sort);
        return productDimensionService.findAll(pageable);
    }

    @PreAuthorize("hasAnyRole('PRODUCTDIMENSION_VIEW','PRODUCT_VIEW')")
    @RequestMapping(method = RequestMethod.GET, value = "/size")
    @ResponseBody
    public Long size() {
        return productDimensionService.size();
    }

    @PreAuthorize("hasAnyRole('PRODUCTDIMENSION_VIEW','PRODUCT_VIEW')")
    @RequestMapping(method = RequestMethod.GET, value = "/sizeSearch")
    @ResponseBody
    public Long size(@RequestParam String search) throws AttributesNotFound, ErrorType {
        return productDimensionService.size(search);
    }


    @PreAuthorize("hasAnyRole('PRODUCTDIMENSION_VIEW','PRODUCT_VIEW')")
    @RequestMapping(method = RequestMethod.GET, value = "/exist")

    @ResponseBody
    public Boolean exist(@RequestParam Long id) throws AttributesNotFound, ErrorType {
        return productDimensionService.isExist(id);
    }
    @PreAuthorize("hasAnyRole('PRODUCTDIMENSION_VIEW','PRODUCT_VIEW')")
    @RequestMapping(method = RequestMethod.GET, value = "/{id}")
    @ResponseBody
    public ProductDimension getProductDimension(@PathVariable("id") Long id) throws IdNotFound {
        return productDimensionService.findById(id);
    }

    @PreAuthorize("hasAnyRole('PRODUCTDIMENSION_VIEW','PRODUCT_VIEW')")
    @RequestMapping(method = RequestMethod.GET, value = "/search")
    @ResponseBody
    public List<ProductDimension> search(@RequestParam(value = "search") String search) throws AttributesNotFound, ErrorType {
        return productDimensionService.find(search);
    }

    @PreAuthorize("hasAnyRole('PRODUCTDIMENSION_VIEW','PRODUCT_VIEW')")
    @RequestMapping(method = RequestMethod.GET, value = "/searchPage")
    @ResponseBody
    public List<ProductDimension> search(@RequestParam(value = "search") String search, @RequestParam int page, @RequestParam int size) throws AttributesNotFound, ErrorType {
        return productDimensionService.find(search, page,size);
    }

    @PreAuthorize("hasRole('PRODUCTDIMENSION_CREATE')")
    @RequestMapping(value = "/save", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public ProductDimension add(@RequestBody ProductDimension productDimension) {
        return productDimensionService.save(productDimension);
    }

    @PreAuthorize("hasRole('PRODUCTDIMENSION_EDIT')")
    @RequestMapping(value = "/save", method = RequestMethod.PUT, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public ProductDimension set(@RequestBody ProductDimension productDimension) {
        return productDimensionService.save(productDimension);
    }

    @PreAuthorize("hasRole('PRODUCTDIMENSION_DELETE')")
    @RequestMapping(value = "/delete", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public void delete(@RequestBody ProductDimension productDimension) {

        productDimensionService.delete(productDimension);
    }

    @PreAuthorize("hasRole('PRODUCTDIMENSION_DELETE')")
    @RequestMapping(value = "/delete/{id}", method = RequestMethod.DELETE, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public void delete(@PathVariable Long id) {
        productDimensionService.delete(id);
    }
}
