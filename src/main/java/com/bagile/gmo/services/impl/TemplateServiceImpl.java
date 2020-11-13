package com.bagile.gmo.services.impl;

import com.bagile.gmo.entities.Template;
import com.bagile.gmo.exceptions.AttributesNotFound;
import com.bagile.gmo.exceptions.ErrorType;
import com.bagile.gmo.exceptions.IdNotFound;
import com.bagile.gmo.repositories.TemplateRepository;
import com.bagile.gmo.services.TemplateService;
import com.bagile.gmo.util.Search;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class TemplateServiceImpl implements TemplateService {
    private final TemplateRepository templateRepository;
    public TemplateServiceImpl(TemplateRepository templateRepository) {
        this.templateRepository = templateRepository;
    }

    @Override
    public Template save(Template template) {
        return templateRepository.saveAndFlush(template);
    }

    @Override
    public Long size() {
        return templateRepository.count();
    }

    @Override
    public Boolean isExist(Long id) {
        return templateRepository.existsById(id);
    }

    @Override
    public Template findById(Long id) throws IdNotFound {
        return templateRepository.findById(id).orElseThrow(() -> new IdNotFound(id));
    }


    @Override
    public void delete(Long id) {
        templateRepository.deleteById(id);
    }

    @Override
    public void delete(Template template) {
        templateRepository.delete(template);
    }

    @Override
    public List<Template> findAll() {
        return templateRepository.findAll();
    }

    @Override
    public List<Template> findAll(int page, int size) {
        Sort sort = Sort.by(Sort.Direction.DESC, "updateDate");
        Pageable pageable = PageRequest.of(page, size, sort);
        return templateRepository.findAll(pageable).toList();
    }

    @Override
    public Iterable<Template> find(String search) throws AttributesNotFound, ErrorType {
        if (search.equals("")){
            return findAll ();
        }
        return templateRepository.findAll(Search.expression(search, Template.class));
    }

    @Override
    public List<Template> find(String search, int page, int size) throws AttributesNotFound, ErrorType {
        if (search.equals("")){
            return findAll (page, size);
        }
        Sort sort = Sort.by(Sort.Direction.DESC, "updateDate");
        Pageable pageable = PageRequest.of(page, size, sort);
        return templateRepository.findAll(Search.expression(search, Template.class), pageable).toList();
    }

    @Override
    public Long size(String search) throws AttributesNotFound, ErrorType {
        if (search.equals("")){
            return size ();
        }
        return templateRepository.count(Search.expression(search, Template.class));
    }
}
