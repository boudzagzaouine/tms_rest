package com.bagile.tms.services.impl;

import com.google.common.collect.Lists;
import com.sinno.ems.entities.*;
import com.sinno.ems.exception.AttributesNotFound;
import com.sinno.ems.exception.ErrorType;
import com.sinno.ems.exception.IdNotFound;
import com.sinno.ems.exception.WarehouseException;
import com.sinno.ems.mapper.WarehouseMapper;
import com.sinno.ems.repositories.*;
import com.sinno.ems.service.WarehouseService;
import com.sinno.ems.util.EmsDate;
import com.sinno.ems.util.Search;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class WarehouseServiceImpl implements WarehouseService {

    @Autowired
    private WarehouseRepository warehouseRepository;
    @Autowired
    private ReceptionRepository receptionRepository;
    @Autowired
    private PurshaseOrderRepository purshaseOrderRepository;
    @Autowired
    private SaleOrderRepository saleOrderRepository;
    @Autowired
    private DeliveryRepository deliveryRepository;
    @Autowired
    private StockRepository stockRepository;
    @Autowired
    private ContainerRepository containerRepository;
    private final static Logger LOGGER = LoggerFactory
            .getLogger(WarehouseService.class);

    @Override
    public Warehouse save(Warehouse warehouse) {
        LOGGER.info("save Warehouse");
        warehouse.setUpdateDate(EmsDate.getDateNow());
        if (0 >= warehouse.getId()) {
            warehouse.setCreationDate(EmsDate.getDateNow());
        }
        return WarehouseMapper.toDto(warehouseRepository.saveAndFlush(WarehouseMapper.toEntity(warehouse, false)), false);
    }

    @Override
    public Long size() {
        return warehouseRepository.count();
    }

    @Override
    public Boolean isExist(Long id) {
        return warehouseRepository.exists(id);
    }

    @Override
    public Warehouse findById(Long id) throws IdNotFound {
        Warehouse warehouse = WarehouseMapper.toDto(warehouseRepository.findOne(id), false);
        if (null != warehouse) {
            return warehouse;
        } else {
            throw new IdNotFound(id);
        }
    }

    @Override
    public List<Warehouse> find(String search) throws AttributesNotFound, ErrorType {
        if (!search.trim().contains("active:false")) {
            if (!search.endsWith(",")) {
                search += ",";
            }
            search += "active:true";
        }
        return WarehouseMapper.toDtos(warehouseRepository.findAll(Search.expression(search, WrhWarehouse.class)), false);
    }

    @Override
    public List<Warehouse> find(String search, int page, int size) throws AttributesNotFound, ErrorType {
        Sort sort = new Sort(Sort.Direction.DESC, "wrhWarehouseUpdateDate");
        Pageable pageable = new PageRequest(page, size, sort);
        if (!search.trim().contains("active:false")) {
            if (!search.endsWith(",")) {
                search += ",";
            }
            search += "active:true";
        }
        return WarehouseMapper.toDtos(warehouseRepository.findAll(Search.expression(search, WrhWarehouse.class), pageable), false);
    }

    @Override
    public Long size(String search) throws AttributesNotFound, ErrorType {
        if (!search.trim().contains("active:false")) {
            if (!search.endsWith(",")) {
                search += ",";
            }
            search += "active:true";
        }
        return warehouseRepository.count(Search.expression(search, WrhWarehouse.class));
    }

    @Override
    public void delete(Long id) throws WarehouseException {
        LOGGER.info("delete Warehouse");
        WrhWarehouse wrhWarehouse = warehouseRepository.findOne(id);
        if (checkBeforeDelete(id)) {
            wrhWarehouse.setWrhWarehouseIsActive(false);
            warehouseRepository.saveAndFlush(wrhWarehouse);
        }
        else{
            throw new WarehouseException("impossible de supprimer "+wrhWarehouse.getWrhWarehouseCode());
        }

    }

    @Override
    public void delete(Warehouse warehouse) {
        LOGGER.info("delete Warehouse");
        warehouse.setActive(false);
        warehouseRepository.saveAndFlush(WarehouseMapper.toEntity(warehouse, false));


    }

    @Override
    public List<Warehouse> findAll() throws AttributesNotFound, ErrorType {
        return find("");
    }

    @Override
    public List<Warehouse> findAll(Pageable pageable) {
        return WarehouseMapper.toDtos(warehouseRepository.findAll(pageable), false);
    }

    @Override
    public List<CountOwnerWareHouses> sizeContainerByOwner() {
        List<Object[]> owners = warehouseRepository.sizeContainerByOwner();
        List<CountOwnerWareHouses> ownersCount = new ArrayList<>();
        for (Object o : owners) {
            Object[] tab = (Object[]) o;
            ownersCount.add(new CountOwnerWareHouses(tab[0].toString(), tab[1].toString()));
        }
        return ownersCount;
    }

    @Override
    public List<CountOwnerWareHouses> sizeContainerByOwner(String code) {
        List<Object[]> owners = warehouseRepository.sizeContainerByOwnerByCode(code);
        List<CountOwnerWareHouses> ownersCount = new ArrayList<>();
        for (Object o : owners) {
            Object[] tab = (Object[]) o;
            ownersCount.add(new CountOwnerWareHouses(tab[0].toString(), tab[1].toString()));
        }
        return ownersCount;
    }

    private Boolean checkBeforeDelete(Long id) {
        String search = "warehouse.id:" + id;

        try {
            //ArrayList<StkStock> stkStocks = Lists.newArrayList(stockRepository.findAll(Search.expression(search, StkStock.class)));
            ArrayList<RcpReception> rcpReceptions = Lists.newArrayList(receptionRepository.findAll(Search.expression(search, RcpReception.class)));
            ArrayList<RcpPurshaseOrder> rcpPurshaseOrders = Lists.newArrayList(purshaseOrderRepository.findAll(Search.expression(search, RcpPurshaseOrder.class)));
            ArrayList<CmdDelivery> cmdDeliveries = Lists.newArrayList(deliveryRepository.findAll(Search.expression(search, CmdDelivery.class)));
            ArrayList<CmdSaleOrder> cmdSaleOrders = Lists.newArrayList(saleOrderRepository.findAll(Search.expression(search, CmdSaleOrder.class)));
            ArrayList<StkContainer> stkContainers = Lists.newArrayList(containerRepository.findAll(Search.expression(search, StkContainer.class)));
            if ((null == stkContainers || 0 == stkContainers.size())
                    //&& (null == stkStocks || 0 == stkStocks.size())
                    && (null == rcpPurshaseOrders || 0 == rcpPurshaseOrders.size())
                    && (null == cmdDeliveries || 0 == cmdDeliveries.size())
                    && (null == rcpReceptions || 0 == rcpReceptions.size())
                    && (null == cmdSaleOrders || 0 == cmdSaleOrders.size())
                    ) {
                return true;
            }

        } catch (AttributesNotFound attributesNotFound) {
            //attributesNotFound.printStackTrace();
        } catch (ErrorType errorType) {
            //e.printStackTrace();
        }
        return false;
    }

    @Override
    public List<Warehouse> findAllForHabilitation() throws AttributesNotFound, ErrorType {
        String search = "active:true";
        return WarehouseMapper.toDtos(warehouseRepository.findAll(Search.expression(search, WrhWarehouse.class)), false);

    }

}