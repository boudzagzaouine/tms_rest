package com.sinno.ems.controller;

import com.sinno.ems.dto.ProductForm;
import com.sinno.ems.exception.AttributesNotFound;
import com.sinno.ems.exception.ErrorType;
import com.sinno.ems.exception.IdNotFound;
import com.sinno.ems.service.ProductFormService;
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
@RequestMapping(value = "/productForms/")
public class ProductFormController {

    @Autowired
    private ProductFormService productFormService;

    @PreAuthorize("hasAnyRole('PRODUCTFORM_VIEW','PRODUCT_VIEW')")
    @RequestMapping(method = RequestMethod.GET,value = "/list")
    @ResponseBody
    public List<ProductForm> getProductForms() {
        return productFormService.findAll();
    }

    @PreAuthorize("hasAnyRole('PRODUCTFORM_VIEW','PRODUCT_VIEW')")
    @RequestMapping(method = RequestMethod.GET, value = "/listPage")
    @ResponseBody
    public List<ProductForm> getProductForms(@RequestParam int page, @RequestParam int size) {
        Sort sort = new Sort(Sort.Direction.DESC, "prmProductFormUpdateDate");
        Pageable pageable = new PageRequest(page, size,sort);
        return productFormService.findAll(pageable);
    }

    @PreAuthorize("hasAnyRole('PRODUCTFORM_VIEW','PRODUCT_VIEW')")
    @RequestMapping(method = RequestMethod.GET, value = "/size")
    @ResponseBody
    public Long size() {
        return productFormService.size();
    }

    @PreAuthorize("hasAnyRole('PRODUCTFORM_VIEW','PRODUCT_VIEW')")
    @RequestMapping(method = RequestMethod.GET, value = "/sizeSearch")
    @ResponseBody
    public Long size(@RequestParam String search) throws AttributesNotFound, ErrorType {
        return productFormService.size(search);
    }


    @PreAuthorize("hasAnyRole('PRODUCTFORM_VIEW','PRODUCT_VIEW')")
    @RequestMapping(method = RequestMethod.GET, value = "/exist")

    @ResponseBody
    public Boolean exist(@RequestParam Long id) throws AttributesNotFound, ErrorType {
        return productFormService.isExist(id);
    }
    @PreAuthorize("hasAnyRole('PRODUCTFORM_VIEW','PRODUCT_VIEW')")
    @RequestMapping(method = RequestMethod.GET, value = "/{id}")
    @ResponseBody
    public ProductForm getProductForm(@PathVariable("id") Long id) throws IdNotFound {
        return productFormService.findById(id);
    }

    @PreAuthorize("hasAnyRole('PRODUCTFORM_VIEW','PRODUCT_VIEW')")
    @RequestMapping(method = RequestMethod.GET, value = "/search")
    @ResponseBody
    public List<ProductForm> search(@RequestParam(value = "search") String search) throws AttributesNotFound, ErrorType {
        return productFormService.find(search);
    }

    @PreAuthorize("hasAnyRole('PRODUCTFORM_VIEW','PRODUCT_VIEW')")
    @RequestMapping(method = RequestMethod.GET, value = "/searchPage")
    @ResponseBody
    public List<ProductForm> search(@RequestParam(value = "search") String search, @RequestParam int page, @RequestParam int size) throws AttributesNotFound, ErrorType {
        return productFormService.find(search, page,size);
    }

    @PreAuthorize("hasRole('PRODUCTFORM_CREATE')")
    @RequestMapping(value = "/save", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public ProductForm add(@RequestBody ProductForm productForm) {
        return productFormService.save(productForm);
    }

    @PreAuthorize("hasRole('PRODUCTFORM_EDIT')")
    @RequestMapping(value = "/save", method = RequestMethod.PUT, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public ProductForm set(@RequestBody ProductForm productForm) {
        return productFormService.save(productForm);
    }

    @PreAuthorize("hasRole('PRODUCTFORM_DELETE')")
    @RequestMapping(value = "/delete", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public void delete(@RequestBody ProductForm productForm) {

        productFormService.delete(productForm);
    }

    @PreAuthorize("hasRole('PRODUCTFORM_DELETE')")
    @RequestMapping(value = "/delete/{id}", method = RequestMethod.DELETE, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public void delete(@PathVariable Long id) {
        productFormService.delete(id);
    }
}
