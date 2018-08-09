package com.bagile.tms.services.impl;

import com.bagile.tms.dto.Category;
import com.bagile.tms.entities.TmsCategory;
import com.bagile.tms.exceptions.AttributesNotFound;
import com.bagile.tms.exceptions.ErrorType;
import com.bagile.tms.exceptions.IdNotFound;
import com.bagile.tms.mapper.CategoryMapper;
import com.bagile.tms.repositories.CategoryRepository;
import com.bagile.tms.services.CategoryService;
import com.bagile.tms.services.CategoryService;
import com.bagile.tms.util.Search;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class CategoryServiceImpl implements CategoryService {


    @Autowired
    private CategoryRepository CategoryRepository;
    private final static Logger LOGGER = LoggerFactory
            .getLogger(CategoryService.class);
    @Override
    public Category save(Category Category) {
        LOGGER.info("save Category");


        return CategoryMapper.toDto(CategoryRepository.saveAndFlush(CategoryMapper.toEntity(Category, false)), false);
    }

    @Override
    public Long size() {
        return CategoryRepository.count();
    }
    @Override
    public Boolean isExist(Long id) {
        return CategoryRepository.existsById(id);
    }
    @Override
    public Category findById(Long id) throws IdNotFound {
        Category Category = CategoryMapper.toDto(CategoryRepository.findById(id).get(), false);
        if (null != Category) {
            return Category;
        } else {
            throw new IdNotFound(id);
        }
    }
    @Override
    public List<Category> find(String search) throws AttributesNotFound, ErrorType {
        return CategoryMapper.toDtos(CategoryRepository.findAll(Search.expression(search, TmsCategory.class)), false);
    }
    @Override
    public List<Category> find(String search, Pageable pageable) throws AttributesNotFound, ErrorType {
        return CategoryMapper.toDtos(CategoryRepository.findAll(Search.expression(search, TmsCategory.class), pageable), false);
    }
    @Override
    public Long size(String search) throws AttributesNotFound, ErrorType {
        return CategoryRepository.count(Search.expression(search, TmsCategory.class));
    }
    @Override
    public void delete(Long id) {
        LOGGER.info("save Category");
        CategoryRepository.deleteById(id);
    }
    @Override
    public void delete(Category Category) {
        LOGGER.info("delete Category");
        CategoryRepository.delete(CategoryMapper.toEntity(Category, false));
    }
    @Override
    public List<Category> findAll() {
        return CategoryMapper.toDtos(CategoryRepository.findAll(), false);
    }
    @Override
    public List<Category> findAll(Pageable pageable) {
        return CategoryMapper.toDtos(CategoryRepository.findAll(pageable), false);
    }



}
