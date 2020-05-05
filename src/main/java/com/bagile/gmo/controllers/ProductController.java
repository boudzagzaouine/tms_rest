package com.bagile.gmo.controllers;

import com.bagile.gmo.dto.Product;
import com.bagile.gmo.exceptions.AttributesNotFound;
import com.bagile.gmo.exceptions.ErrorType;
import com.bagile.gmo.exceptions.IdNotFound;
import com.bagile.gmo.services.ProductService;
import com.bagile.gmo.services.UserDetailsServiceWarehouse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping(value = "/products/")
public class ProductController {

    @Autowired
    private ProductService productService;
    @Autowired
    @Qualifier("userDetailsService")
    private UserDetailsServiceWarehouse userDetailsService;

   //  @PreAuthorize("hasAnyRole('PRODUCT_VIEW','KIT_VIEW','RECEPTION_LINE_VIEW','DELIVERY_LINE_VIEW','STOCK','SALE_ORDER_STOCK_VIEW','RECEPTION_STOCK_VIEW','SALE_ORDER_LINE_VIEW','PURSHASE_ORDER_LINE_VIEW')")
    @RequestMapping(method = RequestMethod.GET, value = "/list")
    @ResponseBody
    public List<Product> getProducts() throws AttributesNotFound, ErrorType {
        if (null == userDetailsService.getWarehouses() || null == userDetailsService.getOwners()) {
            return null;
        }
        return productService.find(userDetailsService.getOwners().toString());
        // return productService.findAll();
    }

   //  @PreAuthorize("hasAnyRole('PRODUCT_VIEW','KIT_VIEW','RECEPTION_LINE_VIEW','DELIVERY_LINE_VIEW','STOCK','SALE_ORDER_STOCK_VIEW','RECEPTION_STOCK_VIEW','SALE_ORDER_LINE_VIEW','PURSHASE_ORDER_LINE_VIEW')")
    @RequestMapping(method = RequestMethod.GET, value = "/listPage")
    @ResponseBody
    public List<Product> getProducts(@RequestParam int page, @RequestParam int size) throws AttributesNotFound, ErrorType {
        if (null == userDetailsService.getOwners()) {
            return null;
        }
        return productService.find(userDetailsService.getOwners().toString(), page, size);
        //  return productService.findAll(pageable);
    }

   //  @PreAuthorize("hasAnyRole('PRODUCT_VIEW','KIT_VIEW','RECEPTION_LINE_VIEW','DELIVERY_LINE_VIEW','STOCK','SALE_ORDER_STOCK_VIEW','RECEPTION_STOCK_VIEW','SALE_ORDER_LINE_VIEW','PURSHASE_ORDER_LINE_VIEW')")
    @RequestMapping(method = RequestMethod.GET, value = "/size")
    @ResponseBody
    public Long size() throws AttributesNotFound, ErrorType {
        if ( null == userDetailsService.getOwners()) {
            return null;
        }
        return productService.size(userDetailsService.getOwners().toString());
    }
   //  @PreAuthorize("hasAnyRole('PRODUCT_VIEW','KIT_VIEW','RECEPTION_LINE_VIEW','DELIVERY_LINE_VIEW','STOCK','SALE_ORDER_STOCK_VIEW','RECEPTION_STOCK_VIEW','SALE_ORDER_LINE_VIEW','PURSHASE_ORDER_LINE_VIEW')")
    @RequestMapping(method = RequestMethod.GET, value = "/findOne")
    @ResponseBody
    public Product findOne(@RequestParam(value = "search") String search) throws AttributesNotFound, ErrorType {
        if (null == userDetailsService.getOwners()) {
            return null;
        }
        if (!search.endsWith(",")) {
            search += ",";
        }
        return productService.findOne(search + userDetailsService.getOwners().toString());

    }
   //  @PreAuthorize("hasAnyRole('PRODUCT_VIEW','KIT_VIEW','RECEPTION_LINE_VIEW','DELIVERY_LINE_VIEW','STOCK','SALE_ORDER_STOCK_VIEW','RECEPTION_STOCK_VIEW','SALE_ORDER_LINE_VIEW','PURSHASE_ORDER_LINE_VIEW')")
    @RequestMapping(method = RequestMethod.GET, value = "/sizeSearch")
    @ResponseBody
    public Long size(@RequestParam String search) throws AttributesNotFound, ErrorType {
        if ( null == userDetailsService.getOwners()) {
            return null;
        }
        if (!search.endsWith(",")) {
            search += ",";
        }
        return productService.size(search + userDetailsService.getOwners().toString());
    }

   //  @PreAuthorize("hasAnyRole('PRODUCT_VIEW','KIT_VIEW','RECEPTION_LINE_VIEW','DELIVERY_LINE_VIEW','STOCK','SALE_ORDER_STOCK_VIEW','RECEPTION_STOCK_VIEW','SALE_ORDER_LINE_VIEW','PURSHASE_ORDER_LINE_VIEW')")
    @RequestMapping(method = RequestMethod.GET, value = "/exist")
    @ResponseBody
    public Boolean exist(@RequestParam Long id) throws AttributesNotFound, ErrorType {
        return productService.isExist(id);
    }

   //  @PreAuthorize("hasAnyRole('PRODUCT_VIEW','KIT_VIEW','RECEPTION_LINE_VIEW','DELIVERY_LINE_VIEW','STOCK','SALE_ORDER_STOCK_VIEW','RECEPTION_STOCK_VIEW','SALE_ORDER_LINE_VIEW','PURSHASE_ORDER_LINE_VIEW')")
    @RequestMapping(method = RequestMethod.GET, value = "/{id}")
    @ResponseBody
    public Product getProduct(@PathVariable("id") Long id) throws IdNotFound {
        return productService.findById(id);
    }

   //  @PreAuthorize("hasAnyRole('PRODUCT_VIEW','KIT_VIEW','RECEPTION_LINE_VIEW','DELIVERY_LINE_VIEW','STOCK','SALE_ORDER_STOCK_VIEW','RECEPTION_STOCK_VIEW','SALE_ORDER_LINE_VIEW','PURSHASE_ORDER_LINE_VIEW')")
    @RequestMapping(method = RequestMethod.GET, value = "/search")
    @ResponseBody
    public List<Product> search(@RequestParam(value = "search") String search) throws AttributesNotFound, ErrorType {
        if (null == userDetailsService.getOwners()) {
            return null;
        }
        if (!search.endsWith(",")) {
            search += ",";
        }
        return productService.find(search +  userDetailsService.getOwners().toString());
    }

   //  @PreAuthorize("hasAnyRole('PRODUCT_VIEW','KIT_VIEW','RECEPTION_LINE_VIEW','DELIVERY_LINE_VIEW','STOCK','SALE_ORDER_STOCK_VIEW','RECEPTION_STOCK_VIEW','SALE_ORDER_LINE_VIEW','PURSHASE_ORDER_LINE_VIEW')")
    @RequestMapping(method = RequestMethod.GET, value = "/searchPage")
    @ResponseBody
    public List<Product> search(@RequestParam(value = "search") String search, @RequestParam int page, @RequestParam int size) throws AttributesNotFound, ErrorType {
        if (null == userDetailsService.getOwners()) {
            return null;
        }
        if (!search.endsWith(",")) {
            search += ",";
        }
        return productService.find(search + userDetailsService.getOwners().toString(), page, size);
    }

   //  @PreAuthorize("hasRole('PRODUCT_CREATE')")
    @RequestMapping(value = "/save", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public Product add(@RequestBody Product product) throws IdNotFound {
        return productService.save(product);
    }

   //  @PreAuthorize("hasRole('PRODUCT_EDIT')")
    @RequestMapping(value = "/save", method = RequestMethod.PUT, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public Product set(@RequestBody Product product) throws IdNotFound {
        return productService.save(product);
    }
}