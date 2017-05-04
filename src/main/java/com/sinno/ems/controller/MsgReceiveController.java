package com.sinno.ems.controller;

import com.sinno.ems.dto.MsgReceive;
import com.sinno.ems.exception.AttributesNotFound;
import com.sinno.ems.exception.ErrorType;
import com.sinno.ems.exception.IdNotFound;
import com.sinno.ems.service.MsgReceiveService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.MediaType;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by ASMAE on 04/05/2016.
 */

@Controller
@RequestMapping(value = "/msgsReceives/")

public class MsgReceiveController {
    @Autowired
    private MsgReceiveService msgReceiveService;


    @PreAuthorize("hasRole('MESSAGE_RECEIVE_VIEW')")
    @RequestMapping(method = RequestMethod.GET, value = "/list")
    @ResponseBody
    public List<MsgReceive> getMsgReceives() throws AttributesNotFound, ErrorType {

        return msgReceiveService.findAll();
    }

    @PreAuthorize("hasRole('MESSAGE_RECEIVE_VIEW')")
    @RequestMapping(method = RequestMethod.GET, value = "/listPage")
    @ResponseBody
    public List<MsgReceive> getMsgReceives(@RequestParam int page, @RequestParam int size) throws AttributesNotFound, ErrorType {

        Pageable pageable = new PageRequest(page, size);
        return msgReceiveService.findAll( pageable);
    }

    @PreAuthorize("hasRole('MESSAGE_RECEIVE_VIEW')")
    @RequestMapping(method = RequestMethod.GET, value = "/size")
    @ResponseBody
    public Long size() throws AttributesNotFound, ErrorType {

        return msgReceiveService.size();
    }

    @PreAuthorize("hasRole('MESSAGE_RECEIVE_VIEW')")
    @RequestMapping(method = RequestMethod.GET, value = "/sizeSearch")
    @ResponseBody
    public Long size(@RequestParam String search) throws AttributesNotFound, ErrorType {
       return msgReceiveService.size();
    }

    @PreAuthorize("hasRole('MESSAGE_RECEIVE_VIEW')")
    @RequestMapping(method = RequestMethod.GET, value = "/exist")
    @ResponseBody
    public Boolean exist(@RequestParam Long id) throws AttributesNotFound, ErrorType {
        return msgReceiveService.isExist(id);
    }

    @PreAuthorize("hasRole('MESSAGE_RECEIVE_VIEW')")
    @RequestMapping(method = RequestMethod.GET, value = "/{id}")
    @ResponseBody
    public MsgReceive getMsgReceive(@PathVariable("id") Long id) throws IdNotFound {
        return msgReceiveService.findById(id);
    }

    @PreAuthorize("hasRole('MESSAGE_RECEIVE_VIEW')")
    @RequestMapping(method = RequestMethod.GET, value = "/search")
    @ResponseBody
    public List<MsgReceive> search(@RequestParam(value = "search") String search) throws AttributesNotFound, ErrorType {
       return msgReceiveService.find(search);
    }

    @PreAuthorize("hasRole('MESSAGE_RECEIVE_VIEW')")
    @RequestMapping(method = RequestMethod.GET, value = "/searchPage")
    @ResponseBody
    public List<MsgReceive> search(@RequestParam(value = "search") String search, @RequestParam int page, @RequestParam int size) throws AttributesNotFound, ErrorType {

        Pageable pageable = new PageRequest(page, size);
        return msgReceiveService.find(search, pageable);
    }

    @PreAuthorize("hasRole('MESSAGE_RECEIVE_CREATE')")
    @RequestMapping(value = "/save", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public MsgReceive add(@RequestBody MsgReceive msgReceive) {
        return msgReceiveService.save(msgReceive);
    }

    @PreAuthorize("hasRole('MESSAGE_RECEIVE_EDIT')")
    @RequestMapping(value = "/save", method = RequestMethod.PUT, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public MsgReceive set(@RequestBody MsgReceive msgReceive) {
        return msgReceiveService.save(msgReceive);
    }

    @PreAuthorize("hasRole('MESSAGE_RECEIVE_DELETE')")
    @RequestMapping(value = "/delete", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public void delete(@RequestBody MsgReceive msgReceive) {

        msgReceiveService.delete(msgReceive);
    }

    @PreAuthorize("hasRole('MESSAGE_RECEIVE_DELETE')")
    @RequestMapping(value = "/delete/{id}", method = RequestMethod.DELETE, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public void delete(@PathVariable Long id) {
        msgReceiveService.delete(id);
    }

}
