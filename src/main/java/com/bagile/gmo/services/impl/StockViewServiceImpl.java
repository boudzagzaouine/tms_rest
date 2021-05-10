package com.bagile.gmo.services.impl;

import com.bagile.gmo.dto.StockView;
import com.bagile.gmo.entities.StkStockView;
import com.bagile.gmo.exceptions.AttributesNotFound;
import com.bagile.gmo.exceptions.CustomException;
import com.bagile.gmo.exceptions.ErrorType;
import com.bagile.gmo.exceptions.IdNotFound;
import com.bagile.gmo.mapper.StockViewMapper;
import com.bagile.gmo.repositories.StockViewRepository;
import com.bagile.gmo.services.NotificationService;
import com.bagile.gmo.services.ProductPackService;
import com.bagile.gmo.services.SettingService;
import com.bagile.gmo.services.StockViewService;
import com.bagile.gmo.util.Search;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StockViewServiceImpl implements StockViewService {

    @Autowired
    private StockViewRepository stockViewRepository;
    @Autowired
    private SettingService settingService;
   
    private final static Logger LOGGER = LoggerFactory
            .getLogger(StockViewService.class);
    @Autowired
    private ProductPackService productPackService;

    @Autowired
    private NotificationService notificationService;


    @Override
    public StockView save(StockView stockView) throws IdNotFound, CustomException, AttributesNotFound, ErrorType {
        return null;
    }

    @Override
    public Long size() {
        return stockViewRepository.count();
    }

    /**
     * check if id exist in database
     *
     * @param id
     * @return
     */
    @Override
    public Boolean isExist(Long id) {
        return stockViewRepository.existsById(id);
    }

    /**
     * find entity by id
     *
     * @param id
     * @return the entity if found
     * @throws IdNotFound
     */
    @Override
    public StockView findById(Long id) throws IdNotFound {
        return StockViewMapper.toDto(stockViewRepository.findById(id).orElseThrow(() -> new IdNotFound(id)), false);

    }

    /**
     * find only one entity
     *
     * @param search query
     * @return StockView
     * @throws AttributesNotFound
     * @throws ErrorType
     */
    @Override
    public StockView findOne(String search) throws AttributesNotFound, ErrorType {
        return StockViewMapper.toDto(stockViewRepository.findOne(Search.expression (search, StkStockView.class)).orElseThrow (() -> new AttributesNotFound (search)), false);
    }

    /**
     * find list of stocks
     *
     * @param search query
     * @return List<StockView>
     * @throws AttributesNotFound
     * @throws ErrorType
     */
    @Override
    public List<StockView> find(String search) throws AttributesNotFound, ErrorType {

        if (search.equals("")){
            return findAll ();
        }
        return StockViewMapper.toDtos(stockViewRepository.findAll(Search.expression(search, StkStockView.class)), false);



    }

    /**
     * find list of accounts with pagination
     *
     * @param search query
     * @param page   page number
     * @param size   size of the page
     * @return List<StockView>
     * @throws AttributesNotFound
     * @throws ErrorType
     */
    @Override
    public List<StockView> find(String search, int page, int size) throws AttributesNotFound, ErrorType {

        if (search.equals("")){
            return findAll (page, size);
        }
       // Sort sort = Sort.by(Sort.Direction.DESC, "updateDate");
        Pageable pageable = PageRequest.of(page, size);
        return StockViewMapper.toDtos(stockViewRepository.findAll(Search.expression(search, StkStockView.class), pageable), false);
    }

    /**
     * get the size of records for a search query
     *
     * @param search search query
     * @return Long
     * @throws AttributesNotFound
     * @throws ErrorType
     */
    @Override
    public Long size(String search) throws AttributesNotFound, ErrorType {
        if (search.equals("")){
            return size ();
        }
        return stockViewRepository.count(Search.expression(search, StkStockView.class));
    }

    /**
     * delete a record on the database
     *
     * @param id the id that will be deleted
     */
    @Override
    public void delete(Long id) throws IdNotFound {
        LOGGER.info("delete StockView");
        delete(findById(id));
    }

    /**
     * delete a record on the database
     *
     * @param stock the stock that will be deleted
     */
    @Override
    public void delete(StockView stock) {

      //  stock.setActive(false);
       // stock.setSalePrice(BigDecimal.ZERO);
        stockViewRepository.saveAndFlush(StockViewMapper.toEntity(stock, false));
    }

    /**
     * get all the records from the database
     *
     * @return List<StockView>
     * @throws AttributesNotFound
     * @throws ErrorType
     */
    @Override
    public List<StockView> findAll() {

        return StockViewMapper.toDtos(stockViewRepository.findAll(), false);
    }

    @Override
    public List<StockView> findAll(int page, int size) throws AttributesNotFound, ErrorType {
        //Sort sort = Sort.by(Sort.Direction.DESC, "updateDate");
        Pageable pageable = PageRequest.of(page, size);
        return StockViewMapper.toDtos(stockViewRepository.findAll(pageable), false);
    }

    /**
     * get all the records from the database with pagination
     *

     * @return List<Account>
     * @throws AttributesNotFound
     * @throws ErrorType
     */



    @Override
    public void deleteAll(List<Long> ids) {

        for (Long id : ids) {
            stockViewRepository.deleteById(id);        }
    }


}