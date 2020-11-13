package com.bagile.gmo.services.impl;

import com.bagile.gmo.config.mail.MailConfig;
import com.bagile.gmo.exceptions.AttributesNotFound;
import com.bagile.gmo.exceptions.ErrorType;
import com.bagile.gmo.exceptions.IdNotFound;
import com.bagile.gmo.repositories.MailConfigRepository;
import com.bagile.gmo.services.MailConfigService;
import com.bagile.gmo.util.Search;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class MailConfigServiceImpl implements MailConfigService {
    private final MailConfigRepository mailConfigRepository;

    public MailConfigServiceImpl(MailConfigRepository mailConfigRepository) {
        this.mailConfigRepository = mailConfigRepository;
    }

    @Override
    public MailConfig save(MailConfig mailConfig) {
        return mailConfigRepository.saveAndFlush(mailConfig);
    }

    @Override
    public Long size() {
        return mailConfigRepository.count();
    }

    @Override
    public Boolean isExist(Long id) {
        return mailConfigRepository.existsById(id);
    }

    @Override
    public MailConfig findById(Long id) throws IdNotFound {
        return mailConfigRepository.findById(id).orElseThrow(() -> new IdNotFound(id));
    }


    @Override
    public void delete(Long id) {
        mailConfigRepository.deleteById(id);
    }

    @Override
    public void delete(MailConfig mailConfig) {
        mailConfigRepository.delete(mailConfig);
    }

    @Override
    public List<MailConfig> findAll() {
        return mailConfigRepository.findAll();
    }

    @Override
    public Page<MailConfig> findAll(int page, int size) {
        Sort sort = Sort.by(Sort.Direction.DESC, "updateDate");
        Pageable pageable = PageRequest.of(page, size, sort);
        return mailConfigRepository.findAll(pageable);
    }

    @Override
    public Iterable<MailConfig> find(String search) throws AttributesNotFound, ErrorType {
        if (search.equals("")){
            return findAll ();
        }
        return mailConfigRepository.findAll(Search.expression(search, MailConfig.class));
    }

    @Override
    public List<MailConfig> find(String search, int page, int size) throws AttributesNotFound, ErrorType {
        if (search.equals("")){
            return findAll (page, size).toList();
        }
        Sort sort = Sort.by(Sort.Direction.DESC, "updateDate");
        Pageable pageable = PageRequest.of(page, size, sort);
        return mailConfigRepository.findAll(Search.expression(search, MailConfig.class), pageable).toList();
    }

    @Override
    public Long size(String search) throws AttributesNotFound, ErrorType {
        if (search.equals("")){
            return size ();
        }
        return mailConfigRepository.count(Search.expression(search, MailConfig.class));
    }
}