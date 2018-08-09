package com.bagile.tms.services.impl;

import com.bagile.tms.dto.SaleOrder;
import com.bagile.tms.entities.CmdSaleOrder;
import com.bagile.tms.exceptions.AttributesNotFound;
import com.bagile.tms.exceptions.ErrorType;
import com.bagile.tms.exceptions.IdNotFound;
import com.bagile.tms.mapper.SaleOrderMapper;
import com.bagile.tms.repositories.SaleOrderRepository;
import com.bagile.tms.services.*;
import com.bagile.tms.util.AddActive;
import com.bagile.tms.util.EmsDate;
import com.bagile.tms.util.Search;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.text.SimpleDateFormat;
import java.util.List;

@Service
@Transactional

public class SaleOrderServiceImpl implements SaleOrderService, AddActive {

    @Autowired
    private SaleOrderRepository saleOrderRepository;
    @Autowired
    private OrderStatusService orderStatusService;
    @Autowired
    private SettingService settingService;

    private SimpleDateFormat dateFormat = new SimpleDateFormat("yyyyMMddHHmmssS");
    private final static Logger LOGGER = LoggerFactory
            .getLogger(SaleOrderService.class);
    /**
     * create or updated purchase order
     * if order status is transfer or production generate purshase order
     * @param saleOrder sale order to create
     * @return sale order
     */

    @Transactional
    @Override
    public SaleOrder save(SaleOrder saleOrder) throws IdNotFound {
        LOGGER.info("save SaleOrder");
        saleOrder.setUpdateDate(EmsDate.getDateNow());
        char mode = 'U';
        //saleOrder = SaleOrderMapper.toDto(cmdSaleOrder, false);

        if (0 >= saleOrder.getId()) {
            saleOrder.setCreationDate(EmsDate.getDateNow());
            saleOrder.setActive(true);
            mode = 'I';
        }

        //SaleOrderExport.export(servletContext.getRealPath("/WEB-INF/classes"), cmdSaleOrder, "F",servletContext);



        return saleOrder;
    }


    /**
     * get the size of the records in sale order table
     * @return the count of sale order table
     */
    @Override
    public Long size() {
        return saleOrderRepository.count();
    }
    /**
     * check if id exist in database
     * @param id id to search
     * @return true if found
     */
    @Override
    public Boolean isExist(Long id) {
        return saleOrderRepository.existsById(id);
    }
    /**
     * find entity by id
     * @param id id to search
     * @return the entity if found
     * @throws IdNotFound id not found
     */
    @Override
    public SaleOrder findById(Long id) throws IdNotFound {
        SaleOrder saleOrder = SaleOrderMapper.toDto(saleOrderRepository.findById(id).get(), false);
        if (null != saleOrder) {
            return saleOrder;
        } else {
            throw new IdNotFound(id);
        }
    }
    /**
     * find only one entity
     * @param search query
     * @return sale order
     * @throws AttributesNotFound  search query attribute not found in dto
     * @throws ErrorType custom error
     */
    @Override
    public SaleOrder findOne(String search) throws AttributesNotFound, ErrorType {
        return SaleOrderMapper.toDto(saleOrderRepository.findOne(Search.expression(addActiveToSearch(search), CmdSaleOrder.class)).get(), false);
    }
    /**
     * find list of sale Orders
     * @param search query
     * @return List<SaleOrder>

     */
    @Override
    public List<SaleOrder> find(String search) throws AttributesNotFound, ErrorType {
        return SaleOrderMapper.toDtos(saleOrderRepository.findAll(Search.expression(addActiveToSearch(search), CmdSaleOrder.class)), false);
    }
    /**
     * find list of sale orders with pagination
     * @param search query
     * @param page page number
     * @param size size of the page
     * @return List<SaleOrder>
     */
    @Override
    public List<SaleOrder> find(String search, int page, int size) throws AttributesNotFound, ErrorType {
        Sort sort = new Sort(Sort.Direction.DESC, "cmdSaleOrderUpdateDate");
        Pageable pageable = new PageRequest(page, size, sort);
        return SaleOrderMapper.toDtos(saleOrderRepository.findAll(Search.expression(addActiveToSearch(search), CmdSaleOrder.class), pageable), false);
    }
    /**
     *  get the size of records for a search query
     * @param search search query
     * @return Long

     */
    @Override
    public Long size(String search) throws AttributesNotFound, ErrorType {
        return saleOrderRepository.count(Search.expression(addActiveToSearch(search), CmdSaleOrder.class));
    }
    /**
     * delete a record on the database
     * @param id the id that will be deleted
     */
    @Override
    public void delete(Long id) {
        LOGGER.info("delete SaleOrder");
        saleOrderRepository.deleteById(id);
    }
    /**
     * delete a record on the database
     * @param saleOrder the sale order that will be deleted
     */

    @Override
    public void delete(SaleOrder saleOrder) {
        LOGGER.info("delete SaleOrder");
        saleOrderRepository.delete(SaleOrderMapper.toEntity(saleOrder, false));
    }
    /**
     * get all the records from the database
     * @return List<SaleOrder>
     */
    @Override
    public List<SaleOrder> findAll() {
        return SaleOrderMapper.toDtos(saleOrderRepository.findAll(), false);
    }
    /**
     * get all the records from the database with pagination
     * @return List<SaleOrder>
     * @param pageable pagination object
     */
    @Override
    public List<SaleOrder> findAll(Pageable pageable) {
        return SaleOrderMapper.toDtos(saleOrderRepository.findAll(pageable), false);
    }

    /**
     * generate sale order code
     * @return new code
     */
    @Override
    public String getNextVal() {
        return settingService.generateCodeSaleOrder() + saleOrderRepository.getNextVal().get(0);

    }

    /**
     * find sale order by code
     * @param code sale order code
     * @return SaleOrder
     */
    @Override
    public SaleOrder findByCode(String code) {
        return SaleOrderMapper.toDto(saleOrderRepository.findByCmdSaleOrderCode(code), false);
    }

    /**
     * update sale order when deliver one deliver line
     * @param saleOrder sale order to update
     * @throws IdNotFound id not found
     */
    @Override
    public void updateSaleOrder(SaleOrder saleOrder) throws IdNotFound {
        try {
            saleOrder = findById(saleOrder.getId());
            long countClosedLines = saleOrder.getLines().stream().filter(saleOrderLine -> saleOrderLine.getOrderStatus().getId() == 1).count();
            if (countClosedLines == saleOrder.getLines().size()) {
                saleOrder.setActive(false);
                saleOrder.setOrderStatus(orderStatusService.closedStatus());
            } else if (countClosedLines > 1) {
                saleOrder.setOrderStatus(orderStatusService.partialStatus());
            }
        } catch (IdNotFound idNotFound) {
            idNotFound.printStackTrace();
        }
        save(saleOrder);
    }


}