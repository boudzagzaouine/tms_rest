package com.sinno.ems.service;

import com.sinno.ems.dto.MsgReceive;
import com.sinno.ems.exception.AttributesNotFound;
import com.sinno.ems.exception.ErrorType;
import com.sinno.ems.exception.IdNotFound;
import org.springframework.data.domain.Pageable;

import java.util.List;

/**
 * Created by ASMAE on 04/05/2016.
 */
public interface MsgReceiveService {
    public MsgReceive save(MsgReceive msgReceive);

    public Long size();

    public Boolean isExist(Long id);

    public MsgReceive findById(Long id) throws IdNotFound;

    public List<MsgReceive> find(String search) throws AttributesNotFound, ErrorType;

    public List<MsgReceive> find(String search, Pageable pageable) throws AttributesNotFound, ErrorType;

    public Long size(String search) throws AttributesNotFound, ErrorType;

    public void delete(Long id);

    public void delete(MsgReceive msgReceive);

    public List<MsgReceive> findAll() throws AttributesNotFound, ErrorType;

    public List<MsgReceive> findAll(Pageable pageable) throws AttributesNotFound, ErrorType;
}
