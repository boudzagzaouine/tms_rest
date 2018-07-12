package com.sinno.ems.service;

import com.sinno.ems.exception.AttributesNotFound;
import com.sinno.ems.exception.ErrorType;
import com.sinno.ems.exception.IdNotFound;
import org.springframework.data.domain.Pageable;

import java.util.List;

/**
 * Created by Enissay on 03/12/2016.
 */
public interface AccountLitigationService {
    public AccountLitigation save(AccountLitigation actions);

    public Long size();

    public Boolean isExist(Long id);

    public AccountLitigation findById(Long id) throws IdNotFound;

    public List<AccountLitigation> find(String search) throws AttributesNotFound, ErrorType;

    List<AccountLitigation> find(String search, int page, int size) throws AttributesNotFound, ErrorType;

    public Long size(String search) throws AttributesNotFound, ErrorType;

    public void delete(Long id);

    public void delete(AccountLitigation actions);

    public List<AccountLitigation> findAll();

    public List<AccountLitigation> findAll(Pageable pageable);
}
