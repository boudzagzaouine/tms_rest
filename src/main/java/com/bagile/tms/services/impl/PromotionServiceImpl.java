package com.bagile.tms.services.impl;

import com.sinno.ems.exception.AttributesNotFound;
import com.sinno.ems.exception.ErrorType;
import com.sinno.ems.exception.IdNotFound;
import com.sinno.ems.mapper.PromotionMapper;
import com.sinno.ems.repositories.PromotionRepository;
import com.sinno.ems.service.PromotionService;
import com.sinno.ems.util.Search;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Enissay on 24/01/2017.
 */
@Service
public class PromotionServiceImpl implements PromotionService{
    @Autowired
    private PromotionRepository promotionRepository;
    private final static Logger LOGGER = LoggerFactory
            .getLogger(PromotionService.class);

    @Override
    public Promotion save(Promotion promotion) {
        LOGGER.info("save Promotion");

        return PromotionMapper.toDto(promotionRepository.saveAndFlush(PromotionMapper.toEntity(promotion, false)), false);
    }

    @Override
    public Long size() {
        return promotionRepository.count();
    }

    @Override
    public Boolean isExist(Long id) {
        return promotionRepository.exists(id);
    }

    @Override
    public Promotion findById(Long id) throws IdNotFound {
        Promotion promotion = PromotionMapper.toDto(promotionRepository.findOne(id), false);
        if (null != promotion) {
            return promotion;
        } else {
            throw new IdNotFound(id);
        }
    }

    @Override
    public List<Promotion> find(String search) throws AttributesNotFound, ErrorType {
        return PromotionMapper.toDtos(promotionRepository.findAll(Search.expression(search, PmtPromotion.class)), false);
    }

    @Override
    public List<Promotion> find(String search, int page, int size) throws AttributesNotFound, ErrorType {
        Pageable pageable = new PageRequest(page, size);
        return PromotionMapper.toDtos(promotionRepository.findAll(Search.expression(search, PmtPromotion.class), pageable), false);
    }

    @Override
    public Long size(String search) throws AttributesNotFound, ErrorType {
        return promotionRepository.count(Search.expression(search, PmtPromotion.class));
    }

    @Override
    public void delete(Long id) {
        LOGGER.info("delete Promotion");
        promotionRepository.delete(id);
    }

    @Override
    public void delete(Promotion promotion) {
        LOGGER.info("delete Promotion");
        promotionRepository.delete(PromotionMapper.toEntity(promotion, false));
    }

    @Override
    public List<Promotion> findAll() {
        return PromotionMapper.toDtos(promotionRepository.findAll(), false);
    }

    @Override
    public List<Promotion> findAll(Pageable pageable) {
        return PromotionMapper.toDtos(promotionRepository.findAll(pageable), false);
    }
}
