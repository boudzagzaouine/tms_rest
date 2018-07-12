package com.sinno.ems.service.impl;

import com.sinno.ems.exception.AttributesNotFound;
import com.sinno.ems.exception.ErrorType;
import com.sinno.ems.exception.IdNotFound;
import com.sinno.ems.mapper.MsgReceiveMapper;
import com.sinno.ems.service.MsgReceiveService;
import com.sinno.ems.util.EmsDate;
import com.sinno.ems.util.Search;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by ASMAE on 04/05/2016.
 */
@Service
public class MsgReceiveServiceImpl implements MsgReceiveService{
    @Autowired
    private MsgReceiveRepository msgRecieveRepository;
    private final static Logger LOGGER = LoggerFactory
            .getLogger(MsgReceiveService.class);

    @Override
    public MsgReceive save(MsgReceive msgReceive) {
        LOGGER.info("save MsgReceive");
        msgReceive.setUpdateDate(EmsDate.getDateNow());
        if (0 >= msgReceive.getId()) {
            msgReceive.setCreationDate(EmsDate.getDateNow());
        }
        return MsgReceiveMapper.toDto(msgRecieveRepository.saveAndFlush(MsgReceiveMapper.toEntity(msgReceive, false)), false);
    }

    @Override
    public Long size() {
        try {
            return size("");
        } catch (AttributesNotFound attributesNotFound) {
            //attributesNotFound.printStackTrace();
        } catch (ErrorType errorType) {
            //e.printStackTrace();
        }
        return 0L;
    }

    @Override
    public Boolean isExist(Long id) {
        return msgRecieveRepository.exists(id);
    }

    @Override
    public MsgReceive findById(Long id) throws IdNotFound {
        MsgReceive msgReceive = MsgReceiveMapper.toDto(msgRecieveRepository.findOne(id), false);
        if (null != msgReceive) {
            return msgReceive;
        } else {
            throw new IdNotFound(id);
        }
    }

    @Override
    public List<MsgReceive> find(String search) throws AttributesNotFound, ErrorType {
        if (!search.trim().contains("active:false")) {
            if (!search.endsWith(",") ) {
                search += ",";
            }
            search += "active:true";
        }
        return MsgReceiveMapper.toDtos(msgRecieveRepository.findAll(Search.expression(search, PrmMsgReceive.class)), false);
    }

    @Override
    public List<MsgReceive> find(String search, Pageable pageable) throws AttributesNotFound, ErrorType {
        if (!search.trim().contains("active:false")) {
            if (!search.endsWith(",") ) {
                search += ",";
            }
            search += "active:true";
        }
        return MsgReceiveMapper.toDtos(msgRecieveRepository.findAll(Search.expression(search, PrmMsgReceive.class), pageable), false);
    }

    @Override
    public Long size(String search) throws AttributesNotFound, ErrorType {
        if (!search.trim().contains("active:false")) {
            if (!search.endsWith(",") ) {
                search += ",";
            }
            search += "active:true";
        }
        return msgRecieveRepository.count(Search.expression(search, PrmMsgReceive.class));
    }

    @Override
    public void delete(Long id) {
        LOGGER.info("delete MsgReceive");
        msgRecieveRepository.delete(id);
    }

    @Override
    public void delete(MsgReceive msgReceive) {
        LOGGER.info("delete MsgReceive");
        msgRecieveRepository.delete(MsgReceiveMapper.toEntity(msgReceive, false));
    }

    @Override
    public List<MsgReceive> findAll() throws AttributesNotFound, ErrorType {
        return find("");
    }

    @Override
    public List<MsgReceive> findAll(Pageable pageable) throws AttributesNotFound, ErrorType {
        return find("",pageable);
    }

}
