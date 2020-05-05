package com.bagile.tms.controllers;

import com.bagile.gmo.dto.ProductType;
import com.bagile.tms.exceptions.AttributesNotFound;
import com.bagile.tms.exceptions.ErrorType;
import com.bagile.tms.exceptions.IdNotFound;
import com.bagile.tms.services.ProductTypeService;
import com.bagile.tms.services.UserDetailsServiceWarehouse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping(value = "/productTypes/")
public class ProductTypeController {

    @Autowired
    private ProductTypeService productTypeService;
    @Autowired
    private UserDetailsServiceWarehouse userDetailsService;

   //  @PreAuthorize("hasAnyRole('PRODUCT_TYPE_VIEW','PRODUCT_VIEW')")
    @RequestMapping(method = RequestMethod.GET,value = "/list")
    @ResponseBody
    public List<ProductType> getProductTypes() throws AttributesNotFound, ErrorType {
        if (null == userDetailsService.getOwners())
        {return null;}

        return productTypeService.find(userDetailsService.getOwners().toString());
    }

   //  @PreAuthorize("hasAnyRole('PRODUCT_TYPE_VIEW','PRODUCT_VIEW')")
    @RequestMapping(method = RequestMethod.GET, value = "/listPage")
    @ResponseBody
    public List<ProductType> getProductTypes(@RequestParam int page, @RequestParam int size) throws AttributesNotFound, ErrorType {
        if (null == userDetailsService.getOwners())
        {return null;}
        return productTypeService.find(userDetailsService.getOwners().toString(),page,size);
    }
   //  @PreAuthorize("hasAnyRole('PRODUCT_TYPE_VIEW','PRODUCT_VIEW')")
    @RequestMapping(method = RequestMethod.GET, value = "/findOne")
    @ResponseBody
    public ProductType findOne(@RequestParam(value = "search") String search) throws AttributesNotFound, ErrorType {
        if (null == userDetailsService.getOwners()) {
            return null;
        }
        if (!search.endsWith(",")) {
            search += ",";
        }
        return productTypeService.findOne(search + userDetailsService.getOwners().toString());

    }
   //  @PreAuthorize("hasAnyRole('PRODUCT_TYPE_VIEW','PRODUCT_VIEW')")
    @RequestMapping(method = RequestMethod.GET, value = "/size")
    @ResponseBody
    public Long size() throws AttributesNotFound, ErrorType {
        if (null == userDetailsService.getOwners())
        {return null;}
        return productTypeService.size(userDetailsService.getOwners().toString());
    }

   //  @PreAuthorize("hasAnyRole('PRODUCT_TYPE_VIEW','PRODUCT_VIEW')")
    @RequestMapping(method = RequestMethod.GET, value = "/sizeSearch")
    @ResponseBody
    public Long size(@RequestParam String search) throws AttributesNotFound, ErrorType {
        if (null == userDetailsService.getOwners())
        {return null;}
        if (!search.endsWith(",")) {
            search += ",";
        }
        return productTypeService.size(search+userDetailsService.getOwners().toString());
    }

   //  @PreAuthorize("hasAnyRole('PRODUCT_TYPE_VIEW','PRODUCT_VIEW')")
    @RequestMapping(method = RequestMethod.GET, value = "/exist")
    @ResponseBody
    public Boolean exist(@RequestParam Long id) throws AttributesNotFound, ErrorType {
        return productTypeService.isExist(id);
    }      //  @PreAuthorize("hasAnyRole('PRODUCT_TYPE_VIEW','PRODUCT_VIEW')")
    @RequestMapping(method = RequestMethod.GET,value = "/{id}")
    @ResponseBody
    public ProductType getProductType(@PathVariable("id") Long id) throws IdNotFound {
        return productTypeService.findById(id);
    }

   //  @PreAuthorize("hasAnyRole('PRODUCT_TYPE_VIEW','PRODUCT_VIEW')")
    @RequestMapping(method = RequestMethod.GET, value = "/search")
    @ResponseBody
    public List<ProductType> search(@RequestParam(value = "search") String search) throws AttributesNotFound, ErrorType {
        if (null == userDetailsService.getOwners())
        {return null;}
        if (!search.endsWith(",")) {
            search += ",";
        }

        return productTypeService.find(search+userDetailsService.getOwners().toString());
    }

   //  @PreAuthorize("hasAnyRole('PRODUCT_TYPE_VIEW','PRODUCT_VIEW')")
    @RequestMapping(method = RequestMethod.GET, value = "/searchPage")
    @ResponseBody
    public List<ProductType> search(@RequestParam(value = "search") String search, @RequestParam int page, @RequestParam int size) throws AttributesNotFound, ErrorType {
        if (null == userDetailsService.getOwners())
        {return null;}
        if (!search.endsWith(",")) {
            search += ",";
        }
        return productTypeService.find(search+userDetailsService.getOwners().toString(),page,size);
    }

   //  @PreAuthorize("hasRole('PRODUCT_TYPE_CREATE')")
    @RequestMapping(value = "/save", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public ProductType add(@RequestBody ProductType productType) {
        return productTypeService.save(productType);
    }

   //  @PreAuthorize("hasRole('PRODUCT_TYPE_EDIT')")
    @RequestMapping(value = "/save", method = RequestMethod.PUT, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public ProductType set(@RequestBody ProductType productType) {
        return productTypeService.save(productType);
    }

   //  @PreAuthorize("hasRole('PRODUCT_TYPE_DELETE')")
    @RequestMapping(value = "/delete", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public void delete(@RequestBody ProductType productType) {

        productTypeService.delete(productType);
    }

   //  @PreAuthorize("hasRole('PRODUCT_TYPE_DELETE')")
    @RequestMapping(value = "/delete/{id}", method = RequestMethod.DELETE, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public void delete(@PathVariable Long id) {
        productTypeService.delete(id);
    }
}