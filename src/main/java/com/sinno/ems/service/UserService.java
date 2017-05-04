package com.sinno.ems.service;

import com.sinno.ems.dto.User;
import com.sinno.ems.exception.AttributesNotFound;
import com.sinno.ems.exception.ErrorType;
import com.sinno.ems.exception.IdNotFound;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface UserService {

    public User save(User user);

    public Long size();

    public Boolean isExist(Long id);

    public User findById(Long id) throws IdNotFound;

    public List<User> find(String search) throws AttributesNotFound, ErrorType;

    public List<User> find(String search, Pageable pageable) throws AttributesNotFound, ErrorType;

    public Long size(String search) throws AttributesNotFound, ErrorType;

    public void delete(Long id);

    public void delete(User user);

    public List<User> findAll() throws AttributesNotFound, ErrorType;

    public List<User> findAll(Pageable pageable) throws AttributesNotFound, ErrorType;

    public User findByEmailAndPassowrd(String email, String password);
}