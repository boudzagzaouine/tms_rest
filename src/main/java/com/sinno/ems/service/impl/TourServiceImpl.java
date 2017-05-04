package com.sinno.ems.service.impl;

import com.sinno.ems.dto.*;
import com.sinno.ems.exception.AttributesNotFound;
import com.sinno.ems.exception.ErrorType;
import com.sinno.ems.exception.IdNotFound;
import com.sinno.ems.service.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Created by Enissay on 18/04/2017.
 */
@Service
public class TourServiceImpl implements TourService {
    /*    @Autowired
        private TourRepository tourRepository;*/
    @Autowired
    private DeliveryService deliveryService;
    @Autowired
    private OrderStatusService orderStatusService;
    @Autowired
    private TransportService transportService;
    @Autowired
    private SaleOrderStockService saleOrderStockService;
    @Autowired
    private DeliveryLineService deliveryLineService;
    private final static Logger LOGGER = LoggerFactory
            .getLogger(TourService.class);

    private List<Tour> tours;

    @PostConstruct
    private void initList() {
        Pageable pageable = new PageRequest(0, 10);
        List<Delivery> all = deliveryService.findAll(pageable);
        List<Transport> transports = transportService.findAll();
        tours = new ArrayList<>();
        Tour tour = new Tour();
        tour.setCode("tourTest");

        tour.setStatus("Encours");
        tour.setSaleOrders(createSaleOrders(all));
        tour.setVehicule("Camion1");
        List<String> transporters = new ArrayList<>();
        String transportr = "Transpoter1";
        transporters.add(transportr);
        tour.setTransporters(transporters);
        tours.add(tour);


    }

    @Override
    public Tour save(Tour tour) {
        initList();
        LOGGER.info("save Tour");


        return tour;
    }

    @Override
    public Long size() {
        initList();
        return Long.valueOf(tours.size());
    }

    @Override
    public Boolean isExist(Long id) {
        return true;
    }

    @Override
    public Tour findById(Long id) throws IdNotFound {
        initList();
        return tours.get(0);
    }

    @Override
    public List<Tour> find(String search) throws AttributesNotFound, ErrorType {
        initList();
        return tours;
    }

    @Override
    public List<Tour> find(String search, int page, int size) throws AttributesNotFound, ErrorType {
        initList();
        return tours;
    }

    @Override
    public Long size(String search) throws AttributesNotFound, ErrorType {
        initList();

        return Long.valueOf(tours.size());
    }

    @Override
    public void delete(Long id) {
        initList();

        tours.remove(tours.get(0));
    }

    @Override
    public void delete(Tour tour) {
        initList();

        tours.remove(tour);

    }

    @Override
    public List<Tour> findAll() {
        initList();

        return tours;
    }

    @Override
    public List<Tour> findAll(int page, int size) throws AttributesNotFound, ErrorType {
        return tours;
    }

    private Vehicule createVehicule() {
        Vehicule vehicule = new Vehicule();
        vehicule.setCode("vihicule");
        vehicule.setBrand("brand");
        vehicule.setModel("1999");
        return vehicule;
    }

    private List<TourSaleOrder> createSaleOrders(List<Delivery> deliveries) {
        List<TourSaleOrder> tourSaleOrders = new ArrayList<TourSaleOrder>();
        for (Delivery delivery : deliveries) {
            TourSaleOrder tourSaleOrder = new TourSaleOrder();
            tourSaleOrder.setCode(delivery.getCode());
            tourSaleOrder.setAccount(delivery.getAccount().getCode());
            tourSaleOrder.setOwner(delivery.getOwner().getCode());
            tourSaleOrder.setWarehouse(delivery.getWarehouse().getCode());
            tourSaleOrder.setStatus(delivery.getOrderStatus().getCode());
            tourSaleOrder.setLoadDate(delivery.getLoadDate());
            tourSaleOrder.setAddress(delivery.getDeliveryAddress().getLine1() + " " + delivery.getDeliveryAddress().getLine2() + " " +
                    delivery.getDeliveryAddress().getCity() + " " + delivery.getDeliveryAddress().getZip() + " " + delivery.getDeliveryAddress().getState() + " " + delivery.getDeliveryAddress().getCountry());
            tourSaleOrder.setLocation(delivery.getLocation().getCode());
            tourSaleOrder.setTourSaleOrderLines(createSaleOrderLine(new ArrayList<>(delivery.getLines())));
            tourSaleOrders.add(tourSaleOrder);
        }
        return tourSaleOrders;
    }

    private List<TourSaleOrderLine> createSaleOrderLine(List<DeliveryLine> deliveryLines) {
        List<TourSaleOrderLine> tourSaleOrderLines = new ArrayList<>();
        for (DeliveryLine deliveryLine : deliveryLines) {
            try {
                deliveryLine = deliveryLineService.findById(deliveryLine.getId());
            } catch (IdNotFound idNotFound) {
                idNotFound.printStackTrace();
            }
            TourSaleOrderLine tourSaleOrderLine = new TourSaleOrderLine();
            tourSaleOrderLine.setLineNumber(deliveryLine.getLineNumber());
            tourSaleOrderLine.setUom(deliveryLine.getUom().getCode());
            tourSaleOrderLine.setContainer(deliveryLine.getContainerCode());
            tourSaleOrderLine.setDlc(deliveryLine.getDlc());
            tourSaleOrderLine.setDluo(deliveryLine.getDluo());
            if (null != deliveryLine.getProductDimension())
                tourSaleOrderLine.setDimension(deliveryLine.getProductDimension().getHeight() + "X" + deliveryLine.getProductDimension().getWidth() + "X" + deliveryLine.getProductDimension().getDepth());
            tourSaleOrderLine.setLot(deliveryLine.getLot());
            tourSaleOrderLine.setSalePrice(deliveryLine.getSalePrice());
            tourSaleOrderLine.setSerialNo(deliveryLine.getSerialNo());
            if (deliveryLine.getBlockType() != null)
                tourSaleOrderLine.setBlockType(deliveryLine.getBlockType().getCode());
            tourSaleOrderLine.setPriceHt(deliveryLine.getTotalPriceHT());
            tourSaleOrderLine.setPriceTtc(deliveryLine.getTotalPriceTTC());
            tourSaleOrderLine.setDiscount(deliveryLine.getDiscount());
            tourSaleOrderLines.add(tourSaleOrderLine);
            tourSaleOrderLine.setTourSaleOrderStocks(createSaleOrderStock(new ArrayList<>(deliveryLine.getSaleOrderStocks())));
        }
        return tourSaleOrderLines;
    }

    private List<TourSaleOrderStock> createSaleOrderStock(List<SaleOrderStock> saleOrderStocks) {
        List<TourSaleOrderStock> tourSaleOrderStocks = new ArrayList<>();
        for (SaleOrderStock saleOrderStock : saleOrderStocks) {
            try {
                saleOrderStock = saleOrderStockService.findById(saleOrderStock.getId());
            } catch (IdNotFound idNotFound) {
                idNotFound.printStackTrace();
            }
            TourSaleOrderStock tourSaleOrderStock = new TourSaleOrderStock();
            tourSaleOrderStock.setContainer(saleOrderStock.getContainer().getCode());
            tourSaleOrderStock.setLot(saleOrderStock.getLot());
            tourSaleOrderStock.setSerialNo(saleOrderStock.getSerialNo());
            tourSaleOrderStock.setDlc(saleOrderStock.getDlc());
            tourSaleOrderStock.setDluo(saleOrderStock.getDluo());
            tourSaleOrderStock.setQuality(saleOrderStock.getQuality());
            tourSaleOrderStock.setWeight(saleOrderStock.getWeight());
            tourSaleOrderStock.setProduct(saleOrderStock.getProduct().getCode());
            tourSaleOrderStock.setServedQuantity(saleOrderStock.getQuantityServed());
            tourSaleOrderStock.setStockId(saleOrderStock.getStock().getId());
            if (saleOrderStock.getProductDimension() != null)
                tourSaleOrderStock.setDimension(saleOrderStock.getProductDimension().getHeight() + "X" + saleOrderStock.getProductDimension().getWidth() + "X" + saleOrderStock.getProductDimension().getDepth());
            tourSaleOrderStocks.add(tourSaleOrderStock);
        }
        return tourSaleOrderStocks;
    }

}
