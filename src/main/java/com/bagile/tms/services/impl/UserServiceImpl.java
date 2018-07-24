package com.bagile.tms.services.impl;

import com.sinno.ems.dto.User;
import com.sinno.ems.entities.EmsLicenceId;
import com.sinno.ems.entities.EmsLicense;
import com.sinno.ems.entities.UsrUser;
import com.sinno.ems.exception.AttributesNotFound;
import com.sinno.ems.exception.ErrorType;
import com.sinno.ems.exception.IdNotFound;
import com.sinno.ems.mapper.UserMapper;
import com.sinno.ems.repositories.UserRepository;
import com.sinno.ems.service.EmsLicenceService;
import com.sinno.ems.service.OrganisationService;
import com.sinno.ems.service.UserService;
import com.sinno.ems.util.EmsDate;
import com.sinno.ems.util.Search;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private EmsLicenceService emsLicenceService;
    @Autowired
    private OrganisationService organisationService;

    private final static Logger LOGGER = LoggerFactory
            .getLogger(UserService.class);

    @Override
    public User save(User user) {
        LOGGER.info("save User");
        user.setUpdateDate(EmsDate.getDateNow());
        user.setType(1L);
        user = checkNumberOfLincensedUsers(user);
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
        return userRepository.exists(id);
    }

    @Override
    public User findById(Long id) throws IdNotFound {
        User user = UserMapper.toDto(userRepository.findOne(id), false);
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
        UsrUser usrUser = userRepository.findOne(id);
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

    private User checkNumberOfLincensedUsers(User user) {
        String account = null;
        String module = "3PL";
        try {
            account = organisationService.findById(1L).getCode();
        } catch (IdNotFound idNotFound) {
            idNotFound.printStackTrace();
        }
        EmsLicenceId emsLicenceId = new EmsLicenceId();
        emsLicenceId.setAccount(account);
        emsLicenceId.setModule(module);
        EmsLicense emsLicense = null;

        try {
            emsLicense = emsLicenceService.findById(emsLicenceId);

            if (null != emsLicense) {
                List<User> users = find("type:1,active:true");
                if (emsLicense.getUsersNumber() > users.size()) {
                    user.setActive(true);
                } else {
                    user.setActive(false);
                }
            }
        } catch (AttributesNotFound attributesNotFound) {
            attributesNotFound.printStackTrace();
        } catch (ErrorType errorType) {
            errorType.printStackTrace();
        } catch (IdNotFound idNotFound) {
            idNotFound.printStackTrace();
        }
        return user;
    }
}