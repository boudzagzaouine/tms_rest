package com.sinno.ems.service.impl;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.sinno.ems.dto.Container;
import com.sinno.ems.dto.Product;
import com.sinno.ems.dto.Stock;
import com.sinno.ems.entities.StkStockView;
import com.sinno.ems.exception.AttributesNotFound;
import com.sinno.ems.exception.ErrorType;
import com.sinno.ems.exception.IdNotFound;
import com.sinno.ems.exception.ProductControls;
import com.sinno.ems.mapper.ContainerMapper;
import com.sinno.ems.mapper.LocationMapper;
import com.sinno.ems.mapper.StockArcMapper;
import com.sinno.ems.mapper.StockMapper;
import com.sinno.ems.repositories.LocationRepository;
import com.sinno.ems.repositories.SettingRepository;
import com.sinno.ems.repositories.StockArcRepository;
import com.sinno.ems.repositories.StockRepository;
import com.sinno.ems.repositories.StockViewRepository;
import com.sinno.ems.service.StockService;
import com.sinno.ems.util.EmsDate;
import com.sinno.ems.util.Search;

@Service
public class StockServiceImpl implements StockService {

    @Autowired
    private StockRepository stockRepository;
    @Autowired
    private StockViewRepository stockViewRepository;

    @Autowired
    private SettingRepository settingRepository;

    @Autowired
    private LocationRepository locationRepository;

    @Autowired
    private ContainerRepository containerRepository;
    @Autowired
    private StockArcRepository stockArcRepository;
    private final static Logger LOGGER = LoggerFactory
            .getLogger(StockService.class);

    @Override
    public Stock save(Stock stock) throws ProductControls {
        LOGGER.info("save Stock");
        //stock = checkControls(stock);
        boolean containerManagement = settingRepository.findOne(1L).getPrmSettingValue().equals("1") ? true : false;

        Container container = null;
        if (containerManagement) {
            container = ContainerMapper.toDto(containerRepository.findOne(stock.getContainer().getId()), false);
            stock.setLocation(container.getLocation());
        } else {
            container = createContainer(stock);
            stock.setContainer(container);
        }

        if (0 == stock.getId()) {
            stock.setCreationDate(EmsDate.getDateNow());
        }
        stock.setUpdateDate(EmsDate.getDateNow());
        return StockMapper.toDto(stockRepository.saveAndFlush(StockMapper.toEntity(stock, false)), false);

    }


    private Stock checkControls(Stock stock) throws ProductControls {
        Product product = stock.getProduct();

        if (null != product.getDlcControl()) {
            if (product.getDlcControl() && null == stock.getDlc()) {
                throw new ProductControls("Dlc");
            }
        }
        if (null != product.getDluoControl()) {
            if (product.getDluoControl() && null == stock.getDluo()) {
                throw new ProductControls("Dluo");
            }
        }
        if (null != product.getLotControl()) {
            if (product.getLotControl() && null == stock.getLot()) {
                throw new ProductControls("Lot");
            }
        }
        if (null != product.getColorControl()) {
            if (product.getColorControl() && null == stock.getColor()) {
                throw new ProductControls("Coleur");
            }
        }
        if (null != product.getSerialNoControl()) {
            if (product.getSerialNoControl() && null == stock.getSerialNo()) {
                throw new ProductControls("SerialNo");
            }
        }
        if (null != product.getWeightControl()) {
            if (product.getWeightControl() && null == stock.getWeight()) {
                throw new ProductControls("Poid");
            }
        }
        if (null != product.getQualityOfControl()) {
            if (product.getQualityOfControl() && null == stock.getQuality()) {
                throw new ProductControls("Qualit�");
            }
        }


        return stock;
    }

    @Override
    public Long size() {
        return stockViewRepository.count();
    }

    @Override
    public Boolean isExist(Long id) {
        return stockRepository.exists(id);
    }

    @Override
    public Stock findById(Long id) throws IdNotFound {
        Stock stock = StockMapper.toDto(stockRepository.findOne(id), false);
        if (null != stock) {
            return stock;
        } else {
            throw new IdNotFound(id);
        }
    }

    @Override
    public List<Stock> find(String search) throws AttributesNotFound, ErrorType {
        return StockMapper.toViewDtos(stockViewRepository.findAll(Search.expression(search, StkStockView.class)), false);
    }

    @Override
    public List<Stock> find(String search, int page, int size) throws AttributesNotFound, ErrorType {
        Sort sort = new Sort(Sort.Direction.DESC, "stkStockUpdateDate");
        Pageable pageable = new PageRequest(page, size, sort);
        return StockMapper.toViewDtos(stockViewRepository.findAll(Search.expression(search, StkStockView.class), pageable), false);
    }

    @Override
    public Long size(String search) throws AttributesNotFound, ErrorType {
        return stockViewRepository.count(Search.expression(search, StkStockView.class));
    }

    @Override
    public void delete(Long id) {
        LOGGER.info("delete Stock");
        stockRepository.delete(id);

        if (0 > 1) {
            Stock stock = StockMapper.toDto(stockRepository.findOne(id), false);
            archiveStock(stock);
        }

    }

    @Override
    public void delete(Stock stock) {

        LOGGER.info("delete Stock");
        stockRepository.delete(StockMapper.toEntity(stock, false));
    }

    @Override
    public List<Stock> findAll() {
        return StockMapper.toViewDtos(stockViewRepository.findAll(), false);
    }

    @Override
    public List<Stock> findAll(Pageable pageable) {
        return StockMapper.toViewDtos(stockViewRepository.findAll(pageable), false);
    }

    private String getContainerCode() {
        return String.format("%1$018d", containerRepository.getNextVal().get(0));
    }

    private Container createContainer(Stock stock) {
        Container container = new Container();
        container.setCode(getContainerCode());
        container.setLocation(stock.getLocation());
        container.setOwner(stock.getOwner());
        Location location = LocationMapper.toDto(locationRepository.findOne(stock.getLocation().getId()), false);
        container.setWarehouse(location.getWarehouse());
        container.setCreationDate(EmsDate.getDateNow());
        container.setUpdateDate(EmsDate.getDateNow());
        container.setReceptionDate(EmsDate.getDateNow());
        return ContainerMapper.toDto(containerRepository.saveAndFlush(ContainerMapper.toEntity(container, false)), false);
    }

    private void archiveStock(Stock stock) {
        StockArc stockArc = new StockArc();
        stockArc.setProduct(stock.getProduct());
        stockArc.setOwner(stock.getOwner());
        stockArc.setLocation(stock.getLocation());
        stockArc.setBlockType(stock.getBlockType());
        stockArc.setLot(stock.getLot());
        stockArc.setSerialNo(stock.getSerialNo());
        stockArc.setWeight(stock.getWeight());
        stockArc.setDlc(stock.getDlc());
        stockArc.setDluo(stock.getDluo());
        stockArc.setColor(stock.getColor());
        stockArc.setQuality(stock.getQuality());
        stockArc.setCreationDate(EmsDate.getDateNow());
        stockArc.setUpdateDate(EmsDate.getDateNow());
        stockArc.setComment(stock.getComment());
        stockArc.setSupplier(stock.getSupplier());
        stockArc.setUom(stock.getUom());
        stockArc.setQuantity(stock.getQuantity());
        stockArc.setVariable1(stock.getVariable1());
        stockArc.setVariable2(stock.getVariable2());
        stockArc.setVariable3(stock.getVariable3());
        stockArc.setVariable4(stock.getVariable4());
        stockArc.setVariable5(stock.getVariable5());
        stockArc.setVariable6(stock.getVariable6());
        stockArc.setVariable7(stock.getVariable7());
        stockArc.setVariable8(stock.getVariable8());
        stockArc.setVariable9(stock.getVariable9());
        stockArc.setVariable10(stock.getVariable10());
        stockArcRepository.saveAndFlush(StockArcMapper.toEntity(stockArc, false));
    }

}