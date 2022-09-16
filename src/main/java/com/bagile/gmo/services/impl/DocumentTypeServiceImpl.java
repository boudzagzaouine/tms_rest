package com.bagile.gmo.services.impl;

import com.bagile.gmo.dto.DocumentType;
import com.bagile.gmo.entities.GmoDocumentType;
import com.bagile.gmo.exceptions.AttributesNotFound;
import com.bagile.gmo.exceptions.ErrorType;
import com.bagile.gmo.exceptions.IdNotFound;
import com.bagile.gmo.mapper.DocumentTypeMapper;
import com.bagile.gmo.repositories.DocumentTypeRepository;
import com.bagile.gmo.services.DocumentTypeService;
import com.bagile.gmo.util.Search;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class DocumentTypeServiceImpl implements DocumentTypeService {

    private final DocumentTypeRepository badgeTypeRepository;

    public DocumentTypeServiceImpl(DocumentTypeRepository badgeTypeRepository) {
        this.badgeTypeRepository = badgeTypeRepository;
    }

    @Override
    public DocumentType save(DocumentType badgeType) {
        return DocumentTypeMapper.toDto(badgeTypeRepository.saveAndFlush(DocumentTypeMapper.toEntity(badgeType, false)), false);
    }

    @Override
    public Long size() {
        return badgeTypeRepository.count();
    }

    @Override
    public Boolean isExist(Long id) {
        return badgeTypeRepository.existsById(id);
    }

    @Override
    public DocumentType findById(Long id) throws IdNotFound {
        return DocumentTypeMapper.toDto(badgeTypeRepository.findById(id).orElseThrow(() -> new IdNotFound(id)), false);
    }

    @Override
    public List<DocumentType> find(String search) throws AttributesNotFound, ErrorType {
        if (search.equals("")){
            return findAll ();
        }
        return DocumentTypeMapper.toDtos(badgeTypeRepository.findAll(Search.expression(search, GmoDocumentType.class)), false);
    }

    @Override
    public List<DocumentType> find(String search, int page, int size) throws AttributesNotFound, ErrorType {
        if (search.equals("")){
            return findAll (page, size);
        }
        Sort sort = Sort.by(Sort.Direction.DESC, "updateDate");
        Pageable pageable = PageRequest.of(page, size, sort);
        return DocumentTypeMapper.toDtos(badgeTypeRepository.findAll(Search.expression(search, GmoDocumentType.class), pageable), false);
    }

    @Override
    public Long size(String search) throws AttributesNotFound, ErrorType {
        if (search.equals("")){
            return size ();
        }
        return badgeTypeRepository.count(Search.expression(search, GmoDocumentType.class));
    }

    @Override
    public void delete(Long id) {
        badgeTypeRepository.deleteById(id);
    }

    @Override
    public void delete(DocumentType badgeType) {
        badgeTypeRepository.delete(DocumentTypeMapper.toEntity(badgeType, false));
    }


    @Override
    public void deleteAll(List<Long> ids) {

        for (Long id : ids) {
            badgeTypeRepository.deleteById(id);        }
    }


    @Override
    public List<DocumentType> findAll()
    {
        return DocumentTypeMapper.toDtos(badgeTypeRepository.findAll(), false);
    }

    @Override
    public List<DocumentType> findAll(int page, int size) {
        Sort sort = Sort.by(Sort.Direction.DESC, "updateDate");
        Pageable pageable = PageRequest.of(page, size, sort);
        return DocumentTypeMapper.toDtos(badgeTypeRepository.findAll(pageable), false);
    }



}

