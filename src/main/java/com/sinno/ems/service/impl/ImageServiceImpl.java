package com.sinno.ems.service.impl;

import com.sinno.ems.dto.Image;
import com.sinno.ems.entities.PrmImage;
import com.sinno.ems.exception.AttributesNotFound;
import com.sinno.ems.exception.ErrorType;
import com.sinno.ems.exception.IdNotFound;
import com.sinno.ems.mapper.ImageMapper;
import com.sinno.ems.repositories.ImageRepository;
import com.sinno.ems.service.AddressService;
import com.sinno.ems.service.ImageService;
import com.sinno.ems.util.Search;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ImageServiceImpl implements ImageService {

    @Autowired
    private ImageRepository imageRepository;
    private final static Logger LOGGER = LoggerFactory
            .getLogger(ImageService.class);

    @Override
    public Image save(Image image) {
        LOGGER.info("save Image");
        return ImageMapper.toDto(imageRepository.saveAndFlush(ImageMapper.toEntity(image, false)), false);
    }

    @Override
    public Long size() {
        return imageRepository.count();
    }

    @Override
    public Boolean isExist(Long id) {
        return imageRepository.exists(id);
    }

    @Override
    public Image findById(Long id) throws IdNotFound {
        Image image = ImageMapper.toDto(imageRepository.findOne(id), false);
        if (null != image) {
            return image;
        } else {
            throw new IdNotFound(id);
        }
    }

    @Override
    public List<Image> find(String search) throws AttributesNotFound, ErrorType {
        return ImageMapper.toDtos(imageRepository.findAll(Search.expression(search, PrmImage.class)), false);
    }

    @Override
    public List<Image> find(String search, Pageable pageable) throws AttributesNotFound, ErrorType {
        return ImageMapper.toDtos(imageRepository.findAll(Search.expression(search, PrmImage.class), pageable), false);
    }

    @Override
    public Long size(String search) throws AttributesNotFound, ErrorType {
        return imageRepository.count(Search.expression(search, PrmImage.class));
    }

    @Override
    public void delete(Long id) {
        LOGGER.info("delete Image");
        imageRepository.delete(id);
    }

    @Override
    public void delete(Image image) {
        LOGGER.info("delete Image");
        imageRepository.delete(ImageMapper.toEntity(image, false));
    }

    @Override
    public List<Image> findAll() {
        return ImageMapper.toDtos(imageRepository.findAll(), false);
    }

    @Override
    public List<Image> findAll(Pageable pageable) {
        return ImageMapper.toDtos(imageRepository.findAll(pageable), false);
    }
}