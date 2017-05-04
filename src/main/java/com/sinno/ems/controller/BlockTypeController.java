package com.sinno.ems.controller;

import com.sinno.ems.dto.BlockType;
import com.sinno.ems.exception.AttributesNotFound;
import com.sinno.ems.exception.ErrorType;
import com.sinno.ems.exception.IdNotFound;
import com.sinno.ems.service.BlockTypeService;
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
@RequestMapping(value = "/blockTypes/")
public class BlockTypeController {

    @Autowired
    private BlockTypeService blockTypeService;
    @PreAuthorize("hasAnyRole('BLOCK_TYPE_VIEW','CONTAINER_VIEW','DELIVERY_VIEW','RECEPTION_VIEW','SALE_ORDER_VIEW','PURSHASE_ORDER_VIEW','STOCK_VIEW','SALE_ORDER_STOCK','RECEPTION_STOCK_VIEW')")
    @RequestMapping(method = RequestMethod.GET,value = "/list")
    @ResponseBody
    public List<BlockType> getBlockTypes() {
        return blockTypeService.findAll();
    }

    @PreAuthorize("hasAnyRole('BLOCK_TYPE_VIEW','CONTAINER_VIEW','DELIVERY_VIEW','RECEPTION_VIEW','SALE_ORDER_VIEW','PURSHASE_ORDER_VIEW','STOCK_VIEW','SALE_ORDER_STOCK','RECEPTION_STOCK_VIEW')")
    @RequestMapping(method = RequestMethod.GET, value = "/listPage")
    @ResponseBody
    public List<BlockType> getBlockTypes(@RequestParam int page, @RequestParam int size) {
        Sort sort = new Sort(Sort.Direction.DESC, "prmBlockTypeUpdateDate");
        Pageable pageable = new PageRequest(page, size,sort);
        return blockTypeService.findAll(pageable);
    }

    @PreAuthorize("hasAnyRole('BLOCK_TYPE_VIEW','CONTAINER_VIEW','DELIVERY_VIEW','RECEPTION_VIEW','SALE_ORDER_VIEW','PURSHASE_ORDER_VIEW','STOCK_VIEW','SALE_ORDER_STOCK','RECEPTION_STOCK_VIEW')")
    @RequestMapping(method = RequestMethod.GET, value = "/size")
    @ResponseBody
    public Long size() {
        return blockTypeService.size();
    }

    @PreAuthorize("hasAnyRole('BLOCK_TYPE_VIEW','CONTAINER_VIEW','DELIVERY_VIEW','RECEPTION_VIEW','SALE_ORDER_VIEW','PURSHASE_ORDER_VIEW','STOCK_VIEW','SALE_ORDER_STOCK','RECEPTION_STOCK_VIEW')")
    @RequestMapping(method = RequestMethod.GET, value = "/sizeSearch")
    @ResponseBody
    public Long size(@RequestParam String search) throws AttributesNotFound, ErrorType {
        return blockTypeService.size(search);
    }

    @PreAuthorize("hasAnyRole('BLOCK_TYPE_VIEW','CONTAINER_VIEW','DELIVERY_VIEW','RECEPTION_VIEW','SALE_ORDER_VIEW','PURSHASE_ORDER_VIEW','STOCK_VIEW','SALE_ORDER_STOCK','RECEPTION_STOCK_VIEW')")
    @RequestMapping(method = RequestMethod.GET, value = "/exist")
    @ResponseBody
    public Boolean exist(@RequestParam Long id) throws AttributesNotFound, ErrorType {
        return blockTypeService.isExist(id);
    }                @PreAuthorize("hasAnyRole('BLOCK_TYPE_VIEW','CONTAINER_VIEW','DELIVERY_VIEW','RECEPTION_VIEW','SALE_ORDER_VIEW','PURSHASE_ORDER_VIEW','STOCK_VIEW','SALE_ORDER_STOCK','RECEPTION_STOCK_VIEW')")
    @RequestMapping(method = RequestMethod.GET,value = "/{id}")
    @ResponseBody
    public BlockType getBlockType(@PathVariable("id") Long id) throws IdNotFound {
        return blockTypeService.findById(id);
    }

    @PreAuthorize("hasAnyRole('BLOCK_TYPE_VIEW','CONTAINER_VIEW','DELIVERY_VIEW','RECEPTION_VIEW','SALE_ORDER_VIEW','PURSHASE_ORDER_VIEW','STOCK_VIEW','SALE_ORDER_STOCK','RECEPTION_STOCK_VIEW')")
    @RequestMapping(method = RequestMethod.GET, value = "/search")
    @ResponseBody
    public List<BlockType> search(@RequestParam(value = "search") String search) throws AttributesNotFound, ErrorType {
        return blockTypeService.find(search);
    }

    @PreAuthorize("hasAnyRole('BLOCK_TYPE_VIEW','CONTAINER_VIEW','DELIVERY_VIEW','RECEPTION_VIEW','SALE_ORDER_VIEW','PURSHASE_ORDER_VIEW','STOCK_VIEW','SALE_ORDER_STOCK','RECEPTION_STOCK_VIEW')")
    @RequestMapping(method = RequestMethod.GET, value = "/searchPage")
    @ResponseBody
    public List<BlockType> search(@RequestParam(value = "search") String search, @RequestParam int page, @RequestParam int size) throws AttributesNotFound, ErrorType {
        Pageable pageable = new PageRequest(page, size);
        return blockTypeService.find(search, pageable);
    }

    @PreAuthorize("hasRole('BLOCK_TYPE_CREATE')")
    @RequestMapping(value = "/save", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public BlockType add(@RequestBody BlockType blockType) {
        return blockTypeService.save(blockType);
    }

    @PreAuthorize("hasRole('BLOCK_TYPE_EDIT')")
    @RequestMapping(value = "/save", method = RequestMethod.PUT, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public BlockType set(@RequestBody BlockType blockType) {
        return blockTypeService.save(blockType);
    }

    @PreAuthorize("hasRole('BLOCK_TYPE_DELETE')")
    @RequestMapping(value = "/delete", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public void delete(@RequestBody BlockType blockType) {

        blockTypeService.delete(blockType);
    }

    @PreAuthorize("hasRole('BLOCK_TYPE_DELETE')")
    @RequestMapping(value = "/delete/{id}", method = RequestMethod.DELETE, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public void delete(@PathVariable Long id) {
        blockTypeService.delete(id);
    }
}