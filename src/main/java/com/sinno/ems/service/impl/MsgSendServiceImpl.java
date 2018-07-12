package com.sinno.ems.service.impl;

import com.sinno.ems.exception.AttributesNotFound;
import com.sinno.ems.exception.ErrorType;
import com.sinno.ems.exception.IdNotFound;
import com.sinno.ems.mapper.MsgSendMapper;
import com.sinno.ems.service.MsgSendService;
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
public class MsgSendServiceImpl implements MsgSendService{

    @Autowired
    private MsgSendRepository msgSendRepository;
    private final static Logger LOGGER = LoggerFactory
            .getLogger(MsgSendService.class);

    @Override
    public MsgSend save(MsgSend msgSend) {
        LOGGER.info("save MsgSend");
        msgSend.setUpdateDate(EmsDate.getDateNow());
        if (0 >= msgSend.getId()) {
            msgSend.setCreationDate(EmsDate.getDateNow());
        }
        return MsgSendMapper.toDto(msgSendRepository.saveAndFlush(MsgSendMapper.toEntity(msgSend, false)), false);
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
        return msgSendRepository.exists(id);
    }

    @Override
    public MsgSend findById(Long id) throws IdNotFound {
        MsgSend msgSend = MsgSendMapper.toDto(msgSendRepository.findOne(id), false);
        if (null != msgSend) {
            return msgSend;
        } else {
            throw new IdNotFound(id);
        }
    }

    @Override
    public List<MsgSend> find(String search) throws AttributesNotFound, ErrorType {
        if (!search.trim().contains("active:false")) {
            if (!search.endsWith(",") ) {
                search += ",";
            }
            search += "active:true";
        }
        return MsgSendMapper.toDtos(msgSendRepository.findAll(Search.expression(search, PrmMsgSend.class)), false);
    }

    @Override
    public List<MsgSend> find(String search, Pageable pageable) throws AttributesNotFound, ErrorType {
        if (!search.trim().contains("active:false")) {
            if (!search.endsWith(",") ) {
                search += ",";
            }
            search += "active:true";
        }
        return MsgSendMapper.toDtos(msgSendRepository.findAll(Search.expression(search, PrmMsgSend.class), pageable), false);
    }

    @Override
    public Long size(String search) throws AttributesNotFound, ErrorType {
        if (!search.trim().contains("active:false")) {
            if (!search.endsWith(",") ) {
                search += ",";
            }
            search += "active:true";
        }
        return msgSendRepository.count(Search.expression(search, PrmMsgSend.class));
    }

    @Override
    public void delete(Long id) {
        LOGGER.info("delete MsgSend");
        msgSendRepository.delete(id);
    }

    @Override
    public void delete(MsgSend msgSend) {
        LOGGER.info("delete MsgSend");
        msgSendRepository.delete(MsgSendMapper.toEntity(msgSend, false));
    }

    @Override
    public List<MsgSend> findAll() throws AttributesNotFound, ErrorType {
        return find("");
    }

    @Override
    public List<MsgSend> findAll(Pageable pageable) throws AttributesNotFound, ErrorType {
        return find("",pageable);
    }

}
