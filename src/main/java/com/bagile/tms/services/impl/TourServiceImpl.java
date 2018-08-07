package com.bagile.tms.services.impl;

import com.bagile.tms.dto.*;
import com.bagile.tms.exceptions.AttributesNotFound;
import com.bagile.tms.exceptions.ErrorType;
import com.bagile.tms.exceptions.IdNotFound;
import com.bagile.tms.services.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Created by Enissay on 18/04/2017.
 */
@Service @Transactional
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
    private DeliveryLineService deliveryLineService;
    private final static Logger LOGGER = LoggerFactory
            .getLogger(TourService.class);

    private List<Tour> tours;

    @PostConstruct
    private void initList() {
        Pageable pageable = new PageRequest(0, 10);
        List<Delivery> all = null;
        try {
            all = deliveryService.find("active:false",0,10);

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
    } catch (AttributesNotFound attributesNotFound) {
        attributesNotFound.printStackTrace();
    } catch (ErrorType errorType) {
        errorType.printStackTrace();
    }

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
            tourSaleOrder.setAddress(delivery.getDeliveryAddress());
            tourSaleOrder.setTourSaleOrderLines(createSaleOrderLine(delivery.getLines()));
            tourSaleOrders.add(tourSaleOrder);
        }
        return tourSaleOrders;
    }

    private Set<TourSaleOrderLine> createSaleOrderLine(Set<DeliveryLine> deliveryLines) {
        Set<TourSaleOrderLine> tourSaleOrderLines = new HashSet<>();
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
            tourSaleOrderLines.add(tourSaleOrderLine);
           // tourSaleOrderLine.setTourSaleOrderStocks(createSaleOrderStock(new ArrayList<>(deliveryLine.getSaleOrderStocks())));
        }
        return tourSaleOrderLines;
    }



}
