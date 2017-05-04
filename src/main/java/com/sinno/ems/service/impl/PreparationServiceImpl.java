package com.sinno.ems.service.impl;

import com.google.common.collect.Lists;
import com.sinno.ems.dto.*;
import com.sinno.ems.entities.CmdPreparation;
import com.sinno.ems.entities.StkStockView;
import com.sinno.ems.exception.AttributesNotFound;
import com.sinno.ems.exception.ErrorType;
import com.sinno.ems.exception.IdNotFound;
import com.sinno.ems.mapper.PreparationMapper;
import com.sinno.ems.mapper.StockMapper;
import com.sinno.ems.repositories.PreparationRepository;
import com.sinno.ems.repositories.StockViewRepository;
import com.sinno.ems.service.*;
import com.sinno.ems.util.EmsComprator;
import com.sinno.ems.util.EmsDate;
import com.sinno.ems.util.Search;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.math.RoundingMode;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Created by Enissay on 02/12/2016.
 */
@Service
public class PreparationServiceImpl implements PreparationService {
    @Autowired
    private StockViewRepository stockViewRepository;
    @Autowired
    private ProductService productService;
    @Autowired
    private StockReservedService stockReservedService;
    @Autowired
    private SaleOrderService saleOrderService;
    @Autowired
    private SaleOrderLineService saleOrderLineService;
    @Autowired
    private PreparationRepository preparationRepository;
    @Autowired
    private OrderStatusService orderStatusService;
    private final static Logger LOGGER = LoggerFactory
            .getLogger(PreparationServiceImpl.class);


    @Override
    public Preparation save(Preparation preparation) {
        LOGGER.info("save Preparation");
        return PreparationMapper.toDto(preparationRepository.saveAndFlush(PreparationMapper.toEntity(preparation, false)), false);
    }

    @Override
    public Long size() {
        return preparationRepository.count();
    }

    @Override
    public Boolean isExist(Long id) {
        return preparationRepository.exists(id);
    }

    @Override
    public Preparation findById(Long id) throws IdNotFound {
        Preparation preparation = PreparationMapper.toDto(preparationRepository.findOne(id), false);
        if (null != preparation) {
            return preparation;
        } else {
            throw new IdNotFound(id);
        }
    }

    @Override
    public List<Preparation> find(String search) throws AttributesNotFound, ErrorType {

        return PreparationMapper.toDtos(preparationRepository.findAll(Search.expression(search, CmdPreparation.class)), false);
    }

    @Override
    public List<Preparation> find(String search, Pageable pageable) throws AttributesNotFound, ErrorType {
        return PreparationMapper.toDtos(preparationRepository.findAll(Search.expression(search, CmdPreparation.class), pageable), false);
    }

    @Override
    public Long size(String search) throws AttributesNotFound, ErrorType {
        return preparationRepository.count(Search.expression(search, CmdPreparation.class));
    }

    @Override
    public void delete(Long id) {
        LOGGER.info("delete Preparation");
        preparationRepository.delete(id);
    }

    @Override
    public void delete(Preparation preparation) {
        LOGGER.info("delete Preparation");
        preparationRepository.delete(PreparationMapper.toEntity(preparation, false));
    }

    @Override
    public List<Preparation> findAll() {
        return PreparationMapper.toDtos(preparationRepository.findAll(), false);
    }

    @Override
    public List<Preparation> findAll(Pageable pageable) {
        return PreparationMapper.toDtos(preparationRepository.findAll(pageable), false);
    }

    @Override
    public Preparation generatePreparation(SaleOrder saleOrder) {
        return generatePreparationFromSorder(saleOrder);
    }

    private Preparation generatePreparationFromSorder(SaleOrder saleOrder) {
        Set<PreparationLine> preparationLines = new HashSet<PreparationLine>();
        Preparation preparation = new Preparation();
        preparation.setAccount(saleOrder.getAccount());
        preparation.setUpdateDate(EmsDate.getDateNow());
        preparation.setSaleOrder(saleOrder);
        preparation.setCreationDate(EmsDate.getDateNow());
        preparation.setOwner(saleOrder.getOwner());
        preparation.setPreparationDate(EmsDate.getDateNow());
        try {
            preparation.setOrderStatus(orderStatusService.findById(2L));
        } catch (IdNotFound idNotFound) {
            idNotFound.printStackTrace();
        }
        preparation.setWarehouse(saleOrder.getWarehouse());
        preparation.setCode("PRE" + getNextVal());
        for (SaleOrderLine saleOrderLine : saleOrder.getLines()) {
            try {
                saleOrderLine = saleOrderLineService.findById(saleOrderLine.getId());
            } catch (IdNotFound idNotFound) {
                idNotFound.printStackTrace();
            }
            saleOrderLine.setQuantityServed(saleOrderLine.getQuantityServed() != null ? saleOrderLine.getQuantityServed() : BigDecimal.ZERO);
            PreparationLine preparationLine = new PreparationLine();
            BigDecimal quatityFound = searchStocks(saleOrderLine);
            if (0 <= quatityFound.compareTo(saleOrderLine.getQuantity().subtract(saleOrderLine.getQuantityServed())))
                preparationLine.setQuantityFound(saleOrderLine.getQuantity().subtract(saleOrderLine.getQuantityServed()));
            else
                preparationLine.setQuantityFound(quatityFound);
            preparationLine.setNumber(saleOrderLine.getLineNumber());
            preparationLine.setQuantity(saleOrderLine.getQuantity().subtract(saleOrderLine.getQuantityServed()));
            preparationLine.setProduct(saleOrderLine.getProduct());
            preparationLine.setOwner(saleOrder.getOwner());
            preparationLine.setDlc(saleOrderLine.getDlc());
            preparationLine.setDluo(saleOrderLine.getDluo());
            preparationLine.setSerialNo(saleOrderLine.getSerialNo());
            preparationLine.setLot(saleOrderLine.getLot());
            preparationLine.setColor(saleOrderLine.getColor());
            preparationLine.setQuality(saleOrderLine.getQuality());
            preparationLine.setWeight(saleOrderLine.getWeight());
            preparationLine.setUpdateDate(EmsDate.getDateNow());
            preparationLine.setCreationDate(EmsDate.getDateNow());
            preparationLine.setSaleOrderLine(saleOrderLine);
            preparationLine.setUom(saleOrderLine.getUom());
            try {
                creatStockReserved(preparationLine);
            } catch (IdNotFound idNotFound) {
                idNotFound.printStackTrace();
            }
            preparationLines.add(preparationLine);
        }
        preparation.setPreparationLines(preparationLines);
        CmdPreparation cmdPreparation = preparationRepository.saveAndFlush(PreparationMapper.toEntity(preparation, false));
        preparation = PreparationMapper.toDto(cmdPreparation, false);
        return preparation;
    }

    private void creatStockReserved(PreparationLine preparationLine) throws IdNotFound {
        SaleOrderLine saleOrderLine = saleOrderLineService.findById(preparationLine.getSaleOrderLine().getId());
        SaleOrder saleOrder = saleOrderService.findById(saleOrderLine.getSaleOrder().getId());
        StockReserved stockReserved = new StockReserved();
        stockReserved.setCreationDate(EmsDate.getDateNow());
        stockReserved.setUpdateDate(EmsDate.getDateNow());
        stockReserved.setQuantity(preparationLine.getQuantityFound());
        stockReserved.setOwner(preparationLine.getOwner());
        stockReserved.setWarehouse(preparationLine.getWarehouse());
        stockReserved.setSaleOrder(saleOrder);
        stockReserved.setProduct(saleOrderLine.getProduct());
        stockReserved.setSaleOrderLine(saleOrderLine);
        stockReserved.setSupplier(saleOrder.getSupplier());
        stockReserved.setAccount(saleOrder.getAccount());
        stockReserved.setQuality(saleOrderLine.getQuality());
        stockReserved.setSerialNo(saleOrderLine.getSerialNo());
        stockReserved.setLot(saleOrderLine.getLot());
        stockReserved.setColor(saleOrderLine.getColor());
        stockReserved.setUom(saleOrderLine.getUom());
        stockReserved.setDlc(saleOrderLine.getDlc());
        stockReserved.setDluo(saleOrderLine.getDluo());
        stockReserved.setBlockType(saleOrderLine.getBlockType());
        stockReservedService.save(stockReserved);

    }

    private BigDecimal searchStocks(SaleOrderLine saleOrderLine) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        BigDecimal quantityToDeliver = saleOrderLine.getQuantity();
        BigDecimal quantityFound = BigDecimal.ZERO;

        StringBuffer search = new StringBuffer();
        if (null != saleOrderLine.getProduct()) {
            search.append("product.id:");
            search.append(saleOrderLine.getProduct().getId());
        }
        if (null != saleOrderLine.getOwner()) {
            search.append(",owner.id:");
            search.append(saleOrderLine.getOwner().getId());
        }
        if (saleOrderLine.getBlockType() != null) {
            search.append(",blockType.id:");
            search.append(saleOrderLine.getBlockType().getId());
        }

        if (saleOrderLine.getDlc() != null) {
            Calendar calendar1 = Calendar.getInstance();
            calendar1.setTime(saleOrderLine.getDlc());
            search.append(",dlc:");
            search.append(dateFormat.format(calendar1.getTime()));
        }
        if (saleOrderLine.getColor() != null) {
            search.append(",color.id:");
            search.append(saleOrderLine.getColor().getId());
        }
        if (saleOrderLine.getDluo() != null) {
            Calendar calendar2 = Calendar.getInstance();
            calendar2.setTime(saleOrderLine.getDluo());
            search.append(",dluo:");
            search.append(dateFormat.format(calendar2.getTime()));
        }
        if (saleOrderLine.getLot() != null && !saleOrderLine.getLot().trim().equals("")) {
            search.append(",lot:");
            search.append(saleOrderLine.getLot());
        }
        if (saleOrderLine.getWeight() != null) {
            search.append(",weight:");
            search.append(saleOrderLine.getWeight());
        }
        if (saleOrderLine.getQuality() != null) {
            search.append(",quality:");
            search.append(saleOrderLine.getQuality());
        }

        try {
            List<Stock> stocks = StockMapper.toViewDtos(stockViewRepository.findAll(Search.expression(search.toString(), StkStockView.class)), false);
            if (stocks == null || stocks.size() == 0) {
                return null;
            }
            saleOrderLine.setQuantityServed(saleOrderLine.getQuantityServed() != null ? saleOrderLine.getQuantityServed() : BigDecimal.ZERO);
            BigDecimal quantityServed = saleOrderLine.getQuantity().subtract(saleOrderLine.getQuantityServed());
            for (Stock stock : stocks) {
                if (EmsComprator.compare(saleOrderLine.getBlockType(), stock.getBlockType())
                        && EmsComprator.compare(saleOrderLine.getDlc(), stock.getDlc())
                        && EmsComprator.compare(saleOrderLine.getDluo(), stock.getDluo())
                        && EmsComprator.compare(saleOrderLine.getLot(), stock.getLot())
                        && EmsComprator.compare(saleOrderLine.getWeight(), stock.getWeight())
                        && EmsComprator.compare(saleOrderLine.getQuality(), stock.getQuality())
                        && EmsComprator.compare(saleOrderLine.getProduct(), stock.getProduct())
                        && EmsComprator.compare(saleOrderLine.getSerialNo(), stock.getSerialNo())
                        && EmsComprator.compare(saleOrderLine.getColor(), stock.getColor())
                        ) {
                    BigDecimal quantityReserved = searchStockReserved(saleOrderLine);
                    BigDecimal convertedStockQuantity = convertUom(stock.getQuantity().subtract(quantityReserved), saleOrderLine.getUom(), stock.getUom(), saleOrderLine.getProduct());
                    if (convertedStockQuantity.compareTo(quantityServed) == -1) {
                        quantityServed = quantityServed.subtract(convertedStockQuantity);
                        if (convertedStockQuantity.compareTo(BigDecimal.ZERO) < 1) {
                            quantityFound.add(convertedStockQuantity);
                            quantityToDeliver = quantityToDeliver.subtract(convertedStockQuantity);
                        }
                    } else if (convertedStockQuantity.compareTo(quantityServed) == 1) {
                        quantityFound = convertedStockQuantity;
                        quantityToDeliver = BigDecimal.ZERO;
                    } else {
                        quantityFound = convertedStockQuantity;
                        quantityServed = BigDecimal.ZERO;
                    }
                    if (0 == BigDecimal.ZERO.compareTo(quantityToDeliver))
                        break;
                }
            }
        } catch (AttributesNotFound attributesNotFound) {
            attributesNotFound.printStackTrace();
        } catch (ErrorType errorType) {
            errorType.printStackTrace();
        }

        return quantityFound;
    }

    private BigDecimal searchStockReserved(SaleOrderLine saleOrderLine) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        BigDecimal quantityFound = BigDecimal.ZERO;

        StringBuffer search = new StringBuffer();
        if (null != saleOrderLine.getProduct()) {
            search.append("product.id:");
            search.append(saleOrderLine.getProduct().getId());
        }
        if (null != saleOrderLine.getOwner()) {
            search.append(",owner.id:");
            search.append(saleOrderLine.getOwner().getId());
        }
        if (saleOrderLine.getBlockType() != null) {
            search.append(",blockType.id:");
            search.append(saleOrderLine.getBlockType().getId());
        }

        if (saleOrderLine.getDlc() != null) {
            Calendar calendar1 = Calendar.getInstance();
            calendar1.setTime(saleOrderLine.getDlc());
            search.append(",dlc:");
            search.append(dateFormat.format(calendar1.getTime()));
        }
        if (saleOrderLine.getColor() != null) {
            search.append(",color.id:");
            search.append(saleOrderLine.getColor().getId());
        }
        if (saleOrderLine.getDluo() != null) {
            Calendar calendar2 = Calendar.getInstance();
            calendar2.setTime(saleOrderLine.getDluo());
            search.append(",dluo:");
            search.append(dateFormat.format(calendar2.getTime()));
        }
        if (saleOrderLine.getLot() != null && !saleOrderLine.getLot().trim().equals("")) {
            search.append(",lot:");
            search.append(saleOrderLine.getLot());
        }
        if (saleOrderLine.getWeight() != null) {
            search.append(",weight:");
            search.append(saleOrderLine.getWeight());
        }
        if (saleOrderLine.getQuality() != null) {
            search.append(",quality:");
            search.append(saleOrderLine.getQuality());
        }

        List<StockReserved> stockReserveds = stockReservedService.findAll();

        for (StockReserved stockReserved : stockReserveds) {

            if (EmsComprator.compare(saleOrderLine.getBlockType(), stockReserved.getBlockType())
                    && EmsComprator.compare(saleOrderLine.getDlc(), stockReserved.getDlc())
                    && EmsComprator.compare(saleOrderLine.getDluo(), stockReserved.getDluo())
                    && EmsComprator.compare(saleOrderLine.getLot(), stockReserved.getLot())
                    && EmsComprator.compare(saleOrderLine.getWeight(), stockReserved.getWeight())
                    && EmsComprator.compare(saleOrderLine.getQuality(), stockReserved.getQuality())
                    && EmsComprator.compare(saleOrderLine.getProduct(), stockReserved.getProduct())
                    && EmsComprator.compare(saleOrderLine.getSerialNo(), stockReserved.getSerialNo())
                    && EmsComprator.compare(saleOrderLine.getColor(), stockReserved.getColor())
                    ) {
                BigDecimal convertedStockQuantity = convertUom(stockReserved.getQuantity(), saleOrderLine.getUom(), stockReserved.getUom(), saleOrderLine.getProduct());
                quantityFound.add(convertedStockQuantity);
            }
        }
        return quantityFound;

    }

    private BigDecimal convertUom(BigDecimal qte, Uom uom, Uom uomServed, Product product) {
        try {
            product = productService.findById(product.getId());
        } catch (IdNotFound idNotFound) {
            idNotFound.printStackTrace();
        }

        List<ProductPack> productPacks = Lists.newArrayList(product.getProductPacks());
        ProductPack served = new ProductPack();
        ProductPack expected = new ProductPack();


        for (ProductPack productPack : productPacks) {
            if (productPack.getUom().equals(uomServed)) {
                served = productPack;
            }
            if (productPack.getUom().equals(uom)) {
                expected = productPack;
            }
        }
        BigDecimal newQte = qte.multiply(served.getQuantity().divide(expected.getQuantity(), 2, RoundingMode.HALF_DOWN));

        return newQte;

    }

    @Override
    public BigInteger getNextVal() {
        List<BigInteger> objects = preparationRepository.getNextVal();
        BigInteger tab = objects.get(0);
        return tab;
    }
}
