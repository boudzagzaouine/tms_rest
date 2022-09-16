package com.bagile.gmo.services.impl;

import com.bagile.gmo.dto.Document;
import com.bagile.gmo.entities.GmoDocument;
import com.bagile.gmo.exceptions.AttributesNotFound;
import com.bagile.gmo.exceptions.ErrorType;
import com.bagile.gmo.exceptions.IdNotFound;
import com.bagile.gmo.mapper.DocumentMapper;
import com.bagile.gmo.repositories.DocumentRepository;
import com.bagile.gmo.services.DocumentService;
import com.bagile.gmo.util.Search;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class DocumentServiceImpl implements DocumentService {

    private final DocumentRepository badgeTypeRepository;

    public DocumentServiceImpl(DocumentRepository badgeTypeRepository) {
        this.badgeTypeRepository = badgeTypeRepository;
    }

    @Override
    public Document save(Document badgeType) {
        return DocumentMapper.toDto(badgeTypeRepository.saveAndFlush(DocumentMapper.toEntity(badgeType, false)), false);
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
    public Document findById(Long id) throws IdNotFound {
        return DocumentMapper.toDto(badgeTypeRepository.findById(id).orElseThrow(() -> new IdNotFound(id)), false);
    }

    @Override
    public List<Document> find(String search) throws AttributesNotFound, ErrorType {
        if (search.equals("")){
            return findAll ();
        }
        return DocumentMapper.toDtos(badgeTypeRepository.findAll(Search.expression(search, GmoDocument.class)), false);
    }

    @Override
    public List<Document> find(String search, int page, int size) throws AttributesNotFound, ErrorType {
        if (search.equals("")){
            return findAll (page, size);
        }
        Sort sort = Sort.by(Sort.Direction.DESC, "updateDate");
        Pageable pageable = PageRequest.of(page, size, sort);
        return DocumentMapper.toDtos(badgeTypeRepository.findAll(Search.expression(search, GmoDocument.class), pageable), false);
    }

    @Override
    public Long size(String search) throws AttributesNotFound, ErrorType {
        if (search.equals("")){
            return size ();
        }
        return badgeTypeRepository.count(Search.expression(search, GmoDocument.class));
    }

    @Override
    public void delete(Long id) {
        badgeTypeRepository.deleteById(id);
    }

    @Override
    public void delete(Document badgeType) {
        badgeTypeRepository.delete(DocumentMapper.toEntity(badgeType, false));
    }


    @Override
    public void deleteAll(List<Long> ids) {

        for (Long id : ids) {
            badgeTypeRepository.deleteById(id);        }
    }


    @Override
    public List<Document> findAll()
    {
        return DocumentMapper.toDtos(badgeTypeRepository.findAll(), false);
    }

    @Override
    public List<Document> findAll(int page, int size) {
        Sort sort = Sort.by(Sort.Direction.DESC, "updateDate");
        Pageable pageable = PageRequest.of(page, size, sort);
        return DocumentMapper.toDtos(badgeTypeRepository.findAll(pageable), false);
    }



}

