package com.bagile.tms.controllers;

import com.bagile.tms.dto.Image;
import com.bagile.tms.exceptions.AttributesNotFound;
import com.bagile.tms.exceptions.ErrorType;
import com.bagile.tms.exceptions.IdNotFound;
import com.bagile.tms.services.ImageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.MediaType;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping(value = "/images/")
public class ImageController {

    @Autowired
    private ImageService imageService;

    @PreAuthorize("hasRole('IMAGE_VIEW')")
    @RequestMapping(method = RequestMethod.GET,value = "/list")
    @ResponseBody
    public List<Image> getImages() {
        return imageService.findAll();
    }

    @PreAuthorize("hasRole('IMAGE_VIEW')")
    @RequestMapping(method = RequestMethod.GET, value = "/listPage")
    @ResponseBody
    public List<Image> getImages(@RequestParam int page, @RequestParam int size) {
        Pageable pageable = PageRequest.of(page, size);
        return imageService.findAll(pageable);
    }

    @PreAuthorize("hasRole('IMAGE_VIEW')")
    @RequestMapping(method = RequestMethod.GET, value = "/size")
    @ResponseBody
    public Long size() {
        return imageService.size();
    }

    @PreAuthorize("hasRole('IMAGE_VIEW')")
    @RequestMapping(method = RequestMethod.GET, value = "/sizeSearch")
    @ResponseBody
    public Long size(@RequestParam String search) throws AttributesNotFound, ErrorType {
        return imageService.size(search);
    }

    @PreAuthorize("hasRole('IMAGE_VIEW')")
    @RequestMapping(method = RequestMethod.GET, value = "/exist")
    @ResponseBody
    public Boolean exist(@RequestParam Long id) throws AttributesNotFound, ErrorType {
        return imageService.isExist(id);
    }    @PreAuthorize("hasRole('IMAGE_VIEW')")
    @RequestMapping(method = RequestMethod.GET,value = "/{id}")
    @ResponseBody
    public Image getImage(@PathVariable("id") Long id) throws IdNotFound {
        return imageService.findById(id);
    }

    @PreAuthorize("hasRole('IMAGE_VIEW')")
    @RequestMapping(method = RequestMethod.GET, value = "/search")
    @ResponseBody
    public List<Image> search(@RequestParam(value = "search") String search) throws AttributesNotFound, ErrorType {
        return imageService.find(search);
    }

    @PreAuthorize("hasRole('IMAGE_VIEW')")
    @RequestMapping(method = RequestMethod.GET, value = "/searchPage")
    @ResponseBody
    public List<Image> search(@RequestParam(value = "search") String search, @RequestParam int page, @RequestParam int size) throws AttributesNotFound, ErrorType {
        Pageable pageable = PageRequest.of(page, size);
        return imageService.find(search, pageable);
    }

    @PreAuthorize("hasRole('IMAGE_CREATE')")
    @RequestMapping(value = "/save", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public Image add(@RequestBody Image image) {
        return imageService.save(image);
    }

    @PreAuthorize("hasRole('IMAGE_EDIT')")
    @RequestMapping(value = "/save", method = RequestMethod.PUT, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public Image set(@RequestBody Image image) {
        return imageService.save(image);
    }

    @PreAuthorize("hasRole('IMAGE_DELETE')")
    @RequestMapping(value = "/delete", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public void delete(@RequestBody Image image) {

        imageService.delete(image);
    }

    @PreAuthorize("hasRole('IMAGE_DELETE')")
    @RequestMapping(value = "/delete/{id}", method = RequestMethod.DELETE, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public void delete(@PathVariable Long id) {
        imageService.delete(id);
    }
}