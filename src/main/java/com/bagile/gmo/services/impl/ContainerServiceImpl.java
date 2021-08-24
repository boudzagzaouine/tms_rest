package com.bagile.gmo.services.impl;

import com.bagile.gmo.dto.*;
import com.bagile.gmo.entities.StkContainer;
import com.bagile.gmo.exceptions.AttributesNotFound;
import com.bagile.gmo.exceptions.ContainerException;
import com.bagile.gmo.exceptions.ErrorType;
import com.bagile.gmo.exceptions.IdNotFound;
import com.bagile.gmo.mapper.ContainerMapper;
import com.bagile.gmo.repositories.ContainerRepository;
import com.bagile.gmo.services.ContainerService;
import com.bagile.gmo.services.LocationService;
import com.bagile.gmo.services.SettingService;
import com.bagile.gmo.util.AddActive;
import com.bagile.gmo.util.EmsDate;
import com.bagile.gmo.util.Search;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.math.BigInteger;
import java.util.Date;
import java.util.List;

@Service
public class ContainerServiceImpl implements ContainerService, AddActive {

    @Autowired
    private ContainerRepository containerRepository;
    @Autowired
    private LocationService locationService;
    @Autowired
    private SettingService settingService;

    private final static Logger LOGGER = LoggerFactory
            .getLogger(ContainerService.class);

    /**
     * create or update container
     *
     * @param container
     * @return
     */
    @Override
    public Container save(Container container) {
        LOGGER.info("save Container");
        container.setUpdateDate(EmsDate.getDateNow());
        if (0 >= container.getId()) {
            container.setCreationDate(EmsDate.getDateNow());
        }
        return ContainerMapper.toDto(containerRepository.saveAndFlush(ContainerMapper.toEntity(container, false)), false);
    }

    @Override
    public Long size() {
        return containerRepository.count();
    }

    @Override
    public Boolean isExist(Long id) {
        return containerRepository.existsById(id);
    }

    @Override
    public Container findById(Long id) throws IdNotFound {
        Container container = ContainerMapper.toDto(containerRepository.findById(id).orElseThrow(() -> new IdNotFound(id)), false);
        if (null != container) {
            return container;
        } else {
            throw new IdNotFound(id);
        }
    }

    @Override
    public Container findOne(String search) throws AttributesNotFound, ErrorType {
        return ContainerMapper.toDto(containerRepository.findOne(Search.expression(search, StkContainer.class)).orElseThrow(() -> new AttributesNotFound(search)), false);
    }

    @Override
    public Container findByCode(String code) {
        return ContainerMapper.toDto(containerRepository.findByStkContainerCode(code), false);
    }

    @Override
    public List<Container> find(String search) throws AttributesNotFound, ErrorType {
        return ContainerMapper.toDtos(containerRepository.findAll(Search.expression(addActiveToSearch(search), StkContainer.class)), false);
    }

    @Override
    public List<Container> find(String search, Pageable pageable) throws AttributesNotFound, ErrorType {
        return ContainerMapper.toDtos(containerRepository.findAll(Search.expression(addActiveToSearch(search), StkContainer.class), pageable), false);
    }

    @Override
    public Long size(String search) throws AttributesNotFound, ErrorType {
        return containerRepository.count(Search.expression(addActiveToSearch(search), StkContainer.class));
    }

    @Override
    public void delete(Long id) {
        LOGGER.info("delete Container");

        if (0 > 1) {
            //archiveContainer(container);
        }
        /*Container container = ContainerMapper.toDto(containerRepository.findOne(id), false);
        container.setOutBoundDate(EmsDate.getDateNow());
        containerRepository.saveAndFlush(ContainerMapper.toEntity(container, false));*/
        containerRepository.deleteById(id);

    }

    @Override
    public void delete(Container container) {
        LOGGER.info("delete Container");
        container.setOutBoundDate(EmsDate.getDateNow());
        containerRepository.saveAndFlush(ContainerMapper.toEntity(container, false));
        //containerRepository.delete(ContainerMapper.toEntity(container, false));
    }

    @Override
    public List<Container> findAll() {
        return ContainerMapper.toDtos(containerRepository.findAll(), false);
    }

    @Override
    public List<Container> findAll(Pageable pageable) {
        return ContainerMapper.toDtos(containerRepository.findAll(pageable), false);
    }

    /**
     * generate container code and write it  on 18 numeric's number
     *
     * @return
     */
    @Override
    public String getNextVal() {
        List<BigInteger> objects = containerRepository.getNextVal();
        return String.format("%1$018d", objects.get(0));
    }

    /**
     * create container from SaleOrderStock
     *
     * @param maintenanceStock
     * @return
     */

    @Override
    public Container createContainer(MaintenanceStock maintenanceStock) {
        Container container;
        boolean containerManagement = settingService.containerManagement();
        //containerManagement || (maintenanceStock.getContainer() != null && maintenanceStock.getContainer().getId() > 0)
        if (containerManagement && maintenanceStock.getContainer() != null) {
            container = maintenanceStock.getContainer();
        } else {
            container = new Container();
            container.setCode(getNextVal());
        }

        //
        //container.setLocation(maintenanceStock.getLocation());
        try {
            container.setLocation(maintenanceStock.getLocation() != null ? maintenanceStock.getLocation() : locationService.getDefaultLocationForDelivery());
        } catch (AttributesNotFound attributesNotFound) {
            attributesNotFound.printStackTrace();
        } catch (ErrorType errorType) {
            errorType.printStackTrace();
        }

        container.setOwner(maintenanceStock.getOwner());
        container.setWarehouse(maintenanceStock.getWarehouse());
        container.setCreationDate(EmsDate.getDateNow());
        container.setUpdateDate(EmsDate.getDateNow());
        container.setReceptionDate(maintenanceStock.getOrderDate() != null ? maintenanceStock.getOrderDate() : new Date());
        container.setOutBoundDate(maintenanceStock.getOrderDate());
        return save(container);
    }

    @Override
    public Container createContainer(AlimentationPump alimentationPump) {
        Container container;
        boolean containerManagement = settingService.containerManagement();
        //containerManagement || (maintenanceStock.getContainer() != null && maintenanceStock.getContainer().getId() > 0)

            container = new Container();
            container.setCode(getNextVal());


        //
        //container.setLocation(maintenanceStock.getLocation());
        try {
            container.setLocation(locationService.getDefaultLocationForDelivery());
        } catch (AttributesNotFound attributesNotFound) {
            attributesNotFound.printStackTrace();
        } catch (ErrorType errorType) {
            errorType.printStackTrace();
        }

       // container.setOwner(alimentationPump.getOwner());
       // container.setWarehouse(maintenanceStock.getWarehouse());
        container.setCreationDate(EmsDate.getDateNow());
        container.setUpdateDate(EmsDate.getDateNow());
        //container.setReceptionDate(maintenanceStock.getOrderDate() != null ? maintenanceStock.getOrderDate() : new Date());
        //container.setOutBoundDate(maintenanceStock.getOrderDate());
        return save(container);
    }

    @Override
    public Container createContainer(DeliveryLine deliveryLine) {
        return null;
    }


    /**
     * Create Container from DeliveryLine
     * @param deliveryLine
     * @return
     */

    /**
     * create container from stock
     *
     * @param stock
     * @return
     * @throws IdNotFound
     */
    @Override
    public Container createContainer(Stock stock) throws IdNotFound, AttributesNotFound, ErrorType {
        Container container = new Container();
        container.setCode(getNextVal());
        //
        container.setOwner(stock.getOwner());
        Location location = null;
        if (null != stock.getLocation())
            location = locationService.findById(stock.getLocation().getId());
        else {
            location = locationService.getDefaultLocationForReception();
            container.setLocation(location);
            stock.setLocation(location);
        }
        container.setLocation(location);

        container.setWarehouse(stock.getWarehouse() != null ? stock.getWarehouse() : location.getWarehouse());
        container.setCreationDate(EmsDate.getDateNow());
        container.setUpdateDate(EmsDate.getDateNow());
        container.setReceptionDate(EmsDate.getDateNow());
        return save(container);
    }


    /**
     * setOutBoundDate for container
     *
     * @param maintenanceStock
     * @return container
     * @throws IdNotFound
     */
    @Override
    public Container setOutBoundDate(MaintenanceStock maintenanceStock) throws IdNotFound {
        if (null == maintenanceStock.getContainer().getOutBoundDate()) {
            Container container = findById(maintenanceStock.getContainer().getId());

            Location quaiExp = null;
            try {
                quaiExp = locationService.getDefaultLocationForDelivery();
            } catch (AttributesNotFound attributesNotFound) {
                attributesNotFound.printStackTrace();
            } catch (ErrorType errorType) {
                errorType.printStackTrace();
            }
            if (null != quaiExp) {
                container.setLocation(quaiExp);
            }
            container.setOutBoundDate(null != maintenanceStock.getOrderDate() ? maintenanceStock.getOrderDate() : EmsDate.getDateNow());
            return save(container);
        }
        return maintenanceStock.getContainer();
    }

    /**
     * create container from receptionStock
     *
     * @param receptionStock
     * @return container
     * @throws ContainerException
     */

    @Override
    public Container createContainer(ReceptionStock receptionStock) throws ContainerException {
        LOGGER.info("> Creating container for reception stock");
        Container container;
        boolean containerManagement = settingService.containerManagement();
        if (containerManagement && receptionStock.getContainer() != null) {
            container = receptionStock.getContainer();
        } else {
            container = new Container();
            container.setCode(getNextVal());
        }

        if (receptionStock.getLocation() != null) {
            LOGGER.info("> Reception stock came with it's Location ");
            container.setLocation(receptionStock.getLocation());

        } else {
            try {
                LOGGER.info("> Reception Stock doesn't have location, so it will be attributed the default location");
                List<Location> locations = locationService.find("defaultLocation:true,locationStatus.id:2");
                if (locations != null && locations.size() > 0) {
                    LOGGER.info("> Found the default location");
                    container.setLocation(locations.get(0));
                   // container.setWarehouse(receptionStock.getLocation().getWarehouse());
                } else {

                    LOGGER.error("> Defalut location could not be found");
                    throw new ContainerException("Emplacemnt par default non trouvé");
                }
            } catch (AttributesNotFound attributesNotFound) {
                attributesNotFound.printStackTrace();
            } catch (ErrorType errorType) {
                errorType.printStackTrace();
            } catch (Exception e) {

                LOGGER.error(e.getMessage(), e);
                throw new ContainerException("Code conteneur exist déja");
            }
        }

        container.setOwner(receptionStock.getOwner());
        container.setWarehouse(receptionStock.getWarehouse());
        container.setCreationDate(receptionStock.getReceptionDate());
        container.setUpdateDate(EmsDate.getDateNow());
        container.setReceptionDate(receptionStock.getReceptionDate() != null ? receptionStock.getReceptionDate() : EmsDate.getDateNow());
        LOGGER.info("< Container created and will be saved into DB");
        return save(container);

    }

    /**
     * create contianer from saleOrderLine
     *
     * @param saleOrderLine
     * @return
     */
    @Override
    public Container createContainer(SaleOrderLine saleOrderLine) {
        Container container = new Container();
        container.setCode(getNextVal());
        container.setOwner(saleOrderLine.getOwner());
        container.setWarehouse(saleOrderLine.getWarehouse());
        container.setCreationDate(EmsDate.getDateNow());
        container.setUpdateDate(EmsDate.getDateNow());
        container.setReceptionDate(EmsDate.getDateNow());
        return ContainerMapper.toDto(containerRepository.saveAndFlush(ContainerMapper.toEntity(container, false)), false);
    }

    @Override
    public void archiveContainer(Container container) {
        try {
            container = findById(container.getId());
        } catch (IdNotFound idNotFound) {
            idNotFound.printStackTrace();
        }
        container.setActive(false);
        save(container);
    }

}