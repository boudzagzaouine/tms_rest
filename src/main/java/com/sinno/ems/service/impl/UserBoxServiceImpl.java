package com.sinno.ems.service.impl;

import com.sinno.ems.entities.UsrUserBox;
import com.sinno.ems.exception.AttributesNotFound;
import com.sinno.ems.exception.ErrorType;
import com.sinno.ems.exception.IdNotFound;
import com.sinno.ems.mapper.UserBoxMapper;
import com.sinno.ems.repositories.UserBoxRepository;
import com.sinno.ems.service.UserBoxService;
import com.sinno.ems.util.EmsDate;
import com.sinno.ems.util.Search;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserBoxServiceImpl implements UserBoxService {

    @Autowired
    private UserBoxRepository userBoxRepository;
    private final static Logger LOGGER = LoggerFactory
            .getLogger(UserBoxService.class);

    @Override
    public UserBox save(UserBox userBox) {
        LOGGER.info("save UserBox");
        if(0 <=userBox.getId())
        {
            userBox.setCreationDate(EmsDate.getDateNow());
        }
        return UserBoxMapper.toDto(userBoxRepository.saveAndFlush(UserBoxMapper.toEntity(userBox, false)), false);
    }

    @Override
    public Long size() {
        return userBoxRepository.count();
    }

    @Override
    public Boolean isExist(Long id) {
        return userBoxRepository.exists(id);
    }

    @Override
    public UserBox findById(Long id) throws IdNotFound {
        UserBox userBox = UserBoxMapper.toDto(userBoxRepository.findOne(id), false);
        if (null != userBox) {
            return userBox;
        } else {
            throw new IdNotFound(id);
        }
    }

    @Override
    public List<UserBox> find(String search) throws AttributesNotFound, ErrorType {
        return UserBoxMapper.toDtos(userBoxRepository.findAll(Search.expression(search, UsrUserBox.class)), false);
    }

    @Override
    public List<UserBox> find(String search, Pageable pageable) throws AttributesNotFound, ErrorType {
        return UserBoxMapper.toDtos(userBoxRepository.findAll(Search.expression(search, UsrUserBox.class), pageable), false);
    }

    @Override
    public Long size(String search) throws AttributesNotFound, ErrorType {
        return userBoxRepository.count(Search.expression(search, UsrUserBox.class));
    }

    @Override
    public void delete(Long id) {
        LOGGER.info("save UserBox");
        userBoxRepository.delete(id);
    }

    @Override
    public void delete(UserBox userBox) {
        LOGGER.info("delete UserBox");
        userBoxRepository.delete(UserBoxMapper.toEntity(userBox, false));
    }

    @Override
    public List<UserBox> findAll() {
        return UserBoxMapper.toDtos(userBoxRepository.findAll(), false);
    }

    @Override
    public List<UserBox> findAll(Pageable pageable) {
        return UserBoxMapper.toDtos(userBoxRepository.findAll(pageable), false);
    }
}