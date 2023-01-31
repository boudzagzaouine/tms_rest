package com.bagile.gmo.services;

import com.bagile.gmo.dto.User;
import com.bagile.gmo.exceptions.AttributesNotFound;
import com.bagile.gmo.exceptions.ErrorType;
import com.bagile.gmo.exceptions.IdNotFound;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface UserService {

    public User save(User user);

    public Long size();

    public Boolean isExist(Long id);

    public User findById(Long id) throws IdNotFound;

    public List<User> find(String search) throws AttributesNotFound, ErrorType;

    public List<User> find(String search, int page, int size) throws AttributesNotFound, ErrorType;

    public Long size(String search) throws AttributesNotFound, ErrorType;

    public void delete(Long id) ;

    public void delete(User user);

    public List<User> findAll();

    public List<User> findAll(int page, int size) ;

    public User findByEmailAndPassowrd(String email, String password);

    String getNextVal();
}