package com.bagile.tms.services.impl;

import com.bagile.tms.dto.Warehouse;
import com.bagile.tms.entities.WrhWarehouse;
import com.bagile.tms.exceptions.AttributesNotFound;
import com.bagile.tms.exceptions.ErrorType;
import com.bagile.tms.exceptions.IdNotFound;
import com.bagile.tms.exceptions.WarehouseException;
import com.bagile.tms.mapper.WarehouseMapper;
import com.bagile.tms.repositories.DeliveryRepository;
import com.bagile.tms.repositories.SaleOrderRepository;
import com.bagile.tms.repositories.StockRepository;
import com.bagile.tms.repositories.WarehouseRepository;
import com.bagile.tms.services.ContainerRepository;
import com.bagile.tms.services.WarehouseService;
import com.bagile.tms.util.EmsDate;
import com.bagile.tms.util.Search;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class WarehouseServiceImpl implements WarehouseService {

    @Autowired
    private WarehouseRepository warehouseRepository;
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
        return warehouseRepository.existsById(id);
    }

    @Override
    public Warehouse findById(Long id) throws IdNotFound {
        Warehouse warehouse = WarehouseMapper.toDto(warehouseRepository.findById(id).get(), false);
        if (null != warehouse) {
            return warehouse;
        } else {
            throw new IdNotFound(id);
        }
    }

    @Override
    public Warehouse findOne(String search) throws AttributesNotFound, ErrorType {
        return WarehouseMapper.toDto(warehouseRepository.findOne(Search.expression(search, WrhWarehouse.class)).get(), false);
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
        Pageable pageable = PageRequest.of(page, size, sort);
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
        WrhWarehouse wrhWarehouse = warehouseRepository.findById(id).get();
        wrhWarehouse.setWrhWarehouseIsActive(false);
        warehouseRepository.saveAndFlush(wrhWarehouse);
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


}