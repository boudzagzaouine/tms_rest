package com.bagile.gmo.services.impl;

import com.bagile.gmo.dto.Template;
import com.bagile.gmo.entities.GmoTemplate;
import com.bagile.gmo.exceptions.AttributesNotFound;
import com.bagile.gmo.exceptions.ErrorType;
import com.bagile.gmo.exceptions.IdNotFound;
import com.bagile.gmo.mapper.TemplateMapper;
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
public class TemplateServiceImpl implements TemplateService {
    private final TemplateRepository templateRepository;
    public TemplateServiceImpl(TemplateRepository templateRepository) {
        this.templateRepository = templateRepository;
    }

    @Override
    public Template save(Template template) {

        return TemplateMapper.toDto(templateRepository.saveAndFlush(TemplateMapper.toEntity(template, false)), false);

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
        return TemplateMapper.toDto(templateRepository.findById(id).orElseThrow(() -> new IdNotFound(id)), false);

    }


    @Override
    public void delete(Long id) {
        templateRepository.deleteById(id);
    }

    @Override
    public void delete(Template template) {
        templateRepository.delete(TemplateMapper.toEntity(template, false));


    }

    @Override
    public List<Template> findAll() {
        return TemplateMapper.toDtos(templateRepository.findAll(), false);

    }

    @Override
    public List<Template> findAll(int page, int size) {
        Sort sort = Sort.by(Sort.Direction.DESC, "updateDate");
        Pageable pageable = PageRequest.of(page, size, sort);
        return TemplateMapper.toDtos(templateRepository.findAll(pageable), false);

    }

    @Override
    public Iterable<Template> find(String search) throws AttributesNotFound, ErrorType {
        if (search.equals("")){
            return findAll ();
        }
        return TemplateMapper.toDtos(templateRepository.findAll(Search.expression(search, GmoTemplate.class)), false);

    }

    @Override
    public List<Template> find(String search, int page, int size) throws AttributesNotFound, ErrorType {
        if (search.equals("")){
            return findAll (page, size);
        }
        Sort sort = Sort.by(Sort.Direction.DESC, "updateDate");
        Pageable pageable = PageRequest.of(page, size, sort);
        return TemplateMapper.toDtos(templateRepository.findAll(Search.expression(search, GmoTemplate.class), pageable), false);

    }

    @Override
    public Long size(String search) throws AttributesNotFound, ErrorType {
        if (search.equals("")){
            return size ();
        }
        return templateRepository.count(Search.expression(search, Template.class));
    }
}
