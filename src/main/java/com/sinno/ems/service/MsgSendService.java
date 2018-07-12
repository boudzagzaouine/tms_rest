package com.sinno.ems.service;

import com.sinno.ems.exception.AttributesNotFound;
import com.sinno.ems.exception.ErrorType;
import com.sinno.ems.exception.IdNotFound;
import org.springframework.data.domain.Pageable;

import java.util.List;

/**
 * Created by ASMAE on 04/05/2016.
 */
public interface MsgSendService {
    public MsgSend save(MsgSend msgSend);

    public Long size();

    public Boolean isExist(Long id);

    public MsgSend findById(Long id) throws IdNotFound;

    public List<MsgSend> find(String search) throws AttributesNotFound, ErrorType;

    public List<MsgSend> find(String search, Pageable pageable) throws AttributesNotFound, ErrorType;

    public Long size(String search) throws AttributesNotFound, ErrorType;

    public void delete(Long id);

    public void delete(MsgSend msgSend);

    public List<MsgSend> findAll() throws AttributesNotFound, ErrorType;

    public List<MsgSend> findAll(Pageable pageable) throws AttributesNotFound, ErrorType;

}
