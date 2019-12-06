package com.bagile.tms.controllers;

import com.bagile.tms.dto.ProductPack;
import com.bagile.tms.exceptions.AttributesNotFound;
import com.bagile.tms.exceptions.ErrorType;
import com.bagile.tms.exceptions.IdNotFound;
import com.bagile.tms.services.ProductPackService;
import com.bagile.tms.services.UserDetailsServiceWarehouse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.MediaType;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping(value = "/productPacks/")
public class ProductPackController {

    @Autowired
    private ProductPackService productPackService;
    @Autowired
    @Qualifier("userDetailsService")
    private UserDetailsServiceWarehouse userDetailsService;


    @PreAuthorize("hasRole('PRODUCT_PACK_VIEW')")
    @RequestMapping(method = RequestMethod.GET,value = "/list")
    @ResponseBody
    public List<ProductPack> getProductPacks() throws AttributesNotFound, ErrorType {
        if (null == userDetailsService.getOwners()){
            return null;
        }
        return productPackService.find(userDetailsService.getOwners().toString());


        //return productPackService.findAll();
    }
    @PreAuthorize("hasRole('PRODUCT_PACK_VIEW')")
    @RequestMapping(method = RequestMethod.GET, value = "/findOne")
    @ResponseBody
    public ProductPack findOne(@RequestParam(value = "search") String search) throws AttributesNotFound, ErrorType {
        if (null == userDetailsService.getOwners()) {
            return null;
        }
        if (!search.endsWith(",")) {
            search += ",";
        }
        return productPackService.findOne(search + userDetailsService.getOwners().toString());

    }
    @PreAuthorize("hasRole('PRODUCT_PACK_VIEW')")
    @RequestMapping(method = RequestMethod.GET, value = "/listPage")
    @ResponseBody
    public List<ProductPack> getProductPacks(@RequestParam int page, @RequestParam int size) throws AttributesNotFound, ErrorType {
        //Pageable pageable = new PageRequest(page, size);
        if (null == userDetailsService.getCodeWarehouses()){
            return null;
        }
        return productPackService.find(userDetailsService.getOwners().toString(), page, size);

        //return productPackService.findAll(pageable);
    }

    @PreAuthorize("hasRole('PRODUCT_PACK_VIEW')")
    @RequestMapping(method = RequestMethod.GET, value = "/size")
    @ResponseBody
    public Long size() {
        return productPackService.size();
    }

    @PreAuthorize("hasRole('PRODUCT_PACK_VIEW')")
    @RequestMapping(method = RequestMethod.GET, value = "/sizeSearch")
    @ResponseBody
    public Long size(@RequestParam String search) throws AttributesNotFound, ErrorType {
        return productPackService.size(search);
    }

    @PreAuthorize("hasRole('PRODUCT_PACK_VIEW')")
    @RequestMapping(method = RequestMethod.GET, value = "/exist")
    @ResponseBody
    public Boolean exist(@RequestParam Long id) throws AttributesNotFound, ErrorType {
        return productPackService.isExist(id);
    }    @PreAuthorize("hasRole('PRODUCT_PACK_VIEW')")
    @RequestMapping(method = RequestMethod.GET,value = "/{id}")
    @ResponseBody
    public ProductPack getProductPack(@PathVariable("id") Long id) throws IdNotFound {
        return productPackService.findById(id);
    }

    @PreAuthorize("hasRole('PRODUCT_PACK_VIEW')")
    @RequestMapping(method = RequestMethod.GET, value = "/search")
    @ResponseBody
    public List<ProductPack> search(@RequestParam(value = "search") String search) throws AttributesNotFound, ErrorType {
        return productPackService.find(search);
    }

    @PreAuthorize("hasRole('PRODUCT_PACK_VIEW')")
    @RequestMapping(method = RequestMethod.GET, value = "/searchPage")
    @ResponseBody
    public List<ProductPack> search(@RequestParam(value = "search") String search, @RequestParam int page, @RequestParam int size) throws AttributesNotFound, ErrorType {
        //Pageable pageable = new PageRequest(page, size);
        return productPackService.find(search, page, size);
    }

    @PreAuthorize("hasRole('PRODUCT_PACK_CREATE')")
    @RequestMapping(value = "/save", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public ProductPack add(@RequestBody ProductPack productPack) throws IdNotFound {
        return productPackService.save(productPack);
    }

    @PreAuthorize("hasRole('PRODUCT_PACK_EDIT')")
    @RequestMapping(value = "/save", method = RequestMethod.PUT, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public ProductPack set(@RequestBody ProductPack productPack) throws IdNotFound {
        return productPackService.save(productPack);
    }

    @PreAuthorize("hasRole('PRODUCT_PACK_DELETE')")
    @RequestMapping(value = "/delete", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public void delete(@RequestBody ProductPack productPack) {

        productPackService.delete(productPack);
    }

    @PreAuthorize("hasRole('PRODUCT_PACK_DELETE')")
    @RequestMapping(value = "/delete/{id}", method = RequestMethod.DELETE, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public void delete(@PathVariable Long id) {
        productPackService.delete(id);
    }
}