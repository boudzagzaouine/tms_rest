package com.bagile.gmo.services;

import com.bagile.gmo.config.mail.MailConfig;
import com.bagile.gmo.exceptions.AttributesNotFound;
import com.bagile.gmo.exceptions.ErrorType;
import com.bagile.gmo.exceptions.IdNotFound;
import org.springframework.data.domain.Page;

import java.util.List;

public interface MailConfigService {
    MailConfig save(MailConfig mailConfig);

    Long size();

    Boolean isExist(Long id);

    MailConfig findById(Long id) throws IdNotFound;

    void delete(Long id);

    void delete(MailConfig mailConfig);

    List<MailConfig> findAll();

    Page<MailConfig> findAll(int page, int size);

    Iterable<MailConfig> find(String search) throws AttributesNotFound, ErrorType;

    Iterable<MailConfig> find(String search, int page, int size) throws AttributesNotFound, ErrorType;

    Long size(String search) throws AttributesNotFound, ErrorType;
}
