package com.bagile.tms.services.impl;

import com.bagile.tms.dto.User;
import com.bagile.tms.entities.UsrUser;
import com.bagile.tms.exceptions.AttributesNotFound;
import com.bagile.tms.exceptions.ErrorType;
import com.bagile.tms.exceptions.IdNotFound;
import com.bagile.tms.mapper.UserMapper;
import com.bagile.tms.repositories.UserRepository;
import com.bagile.tms.services.OrganisationService;
import com.bagile.tms.services.UserService;
import com.bagile.tms.util.EmsDate;
import com.bagile.tms.util.Search;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;
    private final static Logger LOGGER = LoggerFactory
            .getLogger(UserService.class);

    @Override
    public User save(User user) {
        LOGGER.info("save User");
        user.setUpdateDate(EmsDate.getDateNow());
        user.setType(1L);
        if (0 >= user.getId()) {
            user.setCreationDate(EmsDate.getDateNow());
        }
        return UserMapper.toDto(userRepository.saveAndFlush(UserMapper.toEntity(user, false)), false);
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
        return userRepository.existsById(id);
    }

    @Override
    public User findById(Long id) throws IdNotFound {
        User user = UserMapper.toDto(userRepository.findById(id).get(), false);
        if (null != user) {
            return user;
        } else {
            throw new IdNotFound(id);
        }
    }

    public User findByEmailAndPassword(String email, String password) {
        return UserMapper.toDto(userRepository.findByUsrUserEmailAndUsrUserPasswordAndUsrUserIsActive(email, password, true), false);
    }

    @Override
    public List<User> find(String search) throws AttributesNotFound, ErrorType {

        if (!search.trim().contains("active:false")) {
            if (!search.endsWith(",")) {
                search += ",";
            }
            search += "active:true";

        }
        search += ",type:1";
        return UserMapper.toDtos(userRepository.findAll(Search.expression(search, UsrUser.class)), false);
    }

    @Override
    public List<User> find(String search, Pageable pageable) throws AttributesNotFound, ErrorType {
        if (!search.trim().contains("active:false")) {
            if (!search.endsWith(",")) {
                search += ",";
            }
            search += "active:true";
        }
        search += ",type:1";
        return UserMapper.toDtos(userRepository.findAll(Search.expression(search, UsrUser.class), pageable), false);
    }

    @Override
    public Long size(String search) throws AttributesNotFound, ErrorType {
        if (!search.trim().contains("active:false")) {
            if (!search.endsWith(",")) {
                search += ",";
            }
            search += "active:true";
        }
        search += ",type:1";

        return userRepository.count(Search.expression(search, UsrUser.class));
    }

    @Override
    public void delete(Long id) {
        LOGGER.info("delete User");
        UsrUser usrUser = userRepository.findById(id).get();
        usrUser.setUsrUserIsActive(false);
        userRepository.saveAndFlush(usrUser);
    }

    @Override
    public void delete(User user) {
        LOGGER.info("delete User");
        user.setActive(false);
        userRepository.saveAndFlush(UserMapper.toEntity(user, false));

    }

    @Override
    public List<User> findAll() throws AttributesNotFound, ErrorType {
        return find("");
    }

    @Override
    public List<User> findAll(Pageable pageable) throws AttributesNotFound, ErrorType {
        return find("", pageable);
    }

    @Override
    public User findByEmailAndPassowrd(String email, String password) {
        return UserMapper.toDto(userRepository.findByUsrUserEmailAndUsrUserPasswordAndUsrUserIsActive(email, password, true), false);
    }


}