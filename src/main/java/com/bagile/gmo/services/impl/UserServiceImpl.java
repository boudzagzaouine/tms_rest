package com.bagile.gmo.services.impl;

import com.bagile.gmo.dto.User;
import com.bagile.gmo.entities.UsrUser;
import com.bagile.gmo.exceptions.AttributesNotFound;
import com.bagile.gmo.exceptions.ErrorType;
import com.bagile.gmo.exceptions.IdNotFound;
import com.bagile.gmo.mapper.UserMapper;
import com.bagile.gmo.repositories.UserRepository;
import com.bagile.gmo.services.SettingService;
import com.bagile.gmo.services.UserService;
import com.bagile.gmo.util.EmsDate;
import com.bagile.gmo.util.Search;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    @Autowired
    private SettingService settingService;


    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public User save(User user) {
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
        return UserMapper.toDto(userRepository.findById(id).orElseThrow(() -> new IdNotFound(id)), false);
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
    public List<User> find(String search,  int page, int size) throws AttributesNotFound, ErrorType {
        if (!search.trim().contains("active:false")) {
            if (!search.endsWith(",")) {
                search += ",";
            }
            search += "active:true";
        }
        search += ",type:1";
        Sort sort = Sort.by(Sort.Direction.DESC, "updateDate");
        Pageable pageable = PageRequest.of(page, size, sort);
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
    public void delete(Long id)  {
         userRepository.findById(id);

    }

    @Override
    public void delete(User user) {
        user.setActive(false);
        userRepository.saveAndFlush(UserMapper.toEntity(user, false));

    }

    @Override
    public List<User> findAll()  {
        return UserMapper.toDtos(userRepository.findAll(), false);
    }

    @Override
    public List<User> findAll(int page, int size) {
        Sort sort = Sort.by(Sort.Direction.DESC, "updateDate");
        Pageable pageable = PageRequest.of(page, size, sort);
        return UserMapper.toDtos(userRepository.findAll(pageable), false);
    }

    @Override
    public User findByEmailAndPassowrd(String email, String password) {
        return UserMapper.toDto(userRepository.findByUsrUserEmailAndUsrUserPasswordAndUsrUserIsActive(email, password, true), false);
    }
    @Override
    public String getNextVal() {
        String value="USR" + userRepository.getNextVal().get(0);
        return value;


    }

}