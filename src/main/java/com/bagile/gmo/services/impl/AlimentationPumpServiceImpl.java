package com.bagile.gmo.services.impl;

import com.bagile.gmo.dto.AlimentationPump;
import com.bagile.gmo.dto.Stock;
import com.bagile.gmo.entities.GmoAlimentationPump;
import com.bagile.gmo.exceptions.AttributesNotFound;
import com.bagile.gmo.exceptions.CustomException;
import com.bagile.gmo.exceptions.ErrorType;
import com.bagile.gmo.exceptions.IdNotFound;
import com.bagile.gmo.mapper.AlimentationPumpMapper;
import com.bagile.gmo.repositories.AlimentationPumpRepository;
import com.bagile.gmo.services.AlimentationPumpService;
import com.bagile.gmo.services.LocationService;
import com.bagile.gmo.services.StockService;
import com.bagile.gmo.util.EmsClone;
import com.bagile.gmo.util.Search;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.io.IOException;
import java.math.BigDecimal;
import java.util.List;


@Service
@Transactional
public class AlimentationPumpServiceImpl implements AlimentationPumpService {

    private final AlimentationPumpRepository alimentationPumpRepository;

    @Autowired
    private LocationService locationService;

    @Autowired
    private StockService stockService;

    private final static Logger LOGGER = LoggerFactory
            .getLogger(AlimentationPumpService.class);

    public AlimentationPumpServiceImpl(AlimentationPumpRepository alimentationPumpRepository) {
        this.alimentationPumpRepository = alimentationPumpRepository;
    }

    @Override
    public AlimentationPump save(AlimentationPump alimentationPump) throws IdNotFound, AttributesNotFound, ErrorType, CustomException, IOException {

try {

    List<Stock> stocks = stockService.find("location.id!" + 20000L + ",product.id:" + alimentationPump.getFuelPump().getProduct().getId());
   // stocks.sort(Comparator.comparing(o -> o.getReceptionDate()));

    if (stocks == null || stocks.isEmpty()) {
        throw new RuntimeException("Stock empty");
    }

    BigDecimal sumQuantity = stocks.stream().map(p -> p.getQuantity())
            .reduce(BigDecimal.ZERO, (b1, b2) -> b1.add(b2));

    BigDecimal quantityToServe = alimentationPump.getQuantity();

    if (sumQuantity.compareTo(quantityToServe) <0) {
        throw new RuntimeException("Quantité en stock :" + sumQuantity);
    }

    for (int i = 0; i < stocks.size(); i++) {
        Stock stock = stocks.get(i);

        if (stock.getQuantity().compareTo(quantityToServe) == 0) {
            stock.setLocation(alimentationPump.getFuelPump().getLocation());
            stock.setActive(false);
            quantityToServe = BigDecimal.ZERO;
            stockService.save(stock);
            break;
        } else if (stock.getQuantity().compareTo(quantityToServe) == 1) {
            Stock stockNew = EmsClone.clone(stock, Stock.class);
            stockNew.setId(0);
            stockNew.setQuantity(quantityToServe);
            stockNew.setLocation(alimentationPump.getFuelPump().getLocation());
            stockNew.setActive(false);
            stock.setQuantity(stock.getQuantity().subtract(quantityToServe));
            quantityToServe = BigDecimal.ZERO;
            stockService.save(stock);
            stockService.save(stockNew);
            break;
        } else {
            stock.setLocation(alimentationPump.getFuelPump().getLocation());
            quantityToServe = quantityToServe.subtract(stock.getQuantity());
            stockService.save(stock);
        }
        if (quantityToServe.compareTo(BigDecimal.ZERO) == 0) {
            break;
        }

    }
   }catch ( IdNotFound | AttributesNotFound | ErrorType | CustomException  e) {
    LOGGER.error(e.getMessage(), e);
    }

        return  AlimentationPumpMapper.toDto(alimentationPumpRepository.saveAndFlush(AlimentationPumpMapper.toEntity(alimentationPump, false)), false);
    }

    @Override
    public Long size() {
        return alimentationPumpRepository.count();
    }

    @Override
    public Boolean isExist(Long id) {
        return alimentationPumpRepository.existsById(id);
    }

    @Override
    public AlimentationPump findById(Long id) throws IdNotFound {
        return AlimentationPumpMapper.toDto(alimentationPumpRepository.findById(id).orElseThrow(() -> new IdNotFound(id)), false);
    }

    @Override
    public List<AlimentationPump> find(String search) throws AttributesNotFound, ErrorType {
        if (search.equals("")){
            return findAll ();
        }
        return AlimentationPumpMapper.toDtos(alimentationPumpRepository.findAll(Search.expression(search, GmoAlimentationPump.class)), false);
    }

    @Override
    public List<AlimentationPump> find(String search, int page, int size) throws AttributesNotFound, ErrorType {
        if (search.equals("")){
            return findAll (page, size);
        }
        Sort sort = Sort.by(Sort.Direction.DESC, "updateDate");
        Pageable pageable = PageRequest.of(page, size, sort);
        return AlimentationPumpMapper.toDtos(alimentationPumpRepository.findAll(Search.expression(search, GmoAlimentationPump.class), pageable), false);
    }

    @Override
    public Long size(String search) throws AttributesNotFound, ErrorType {
        if (search.equals("")){
            return size ();
        }
        return alimentationPumpRepository.count(Search.expression(search, GmoAlimentationPump.class));
    }

    @Override
    public void delete(Long id) {
        alimentationPumpRepository.deleteById(id);
    }

    @Override
    public void deleteAll(List<Long> ids) {

        for (Long id : ids) {
            alimentationPumpRepository.deleteById(id);        }
    }

    @Override
    public void delete(AlimentationPump alimentationPump) {
        alimentationPumpRepository.delete(AlimentationPumpMapper.toEntity(alimentationPump, false));
    }

    @Override
    public List<AlimentationPump> findAll() {
        return AlimentationPumpMapper.toDtos(alimentationPumpRepository.findAll(), false);
    }

    @Override
    public List<AlimentationPump> findAll(int page, int size) {
        Sort sort = Sort.by(Sort.Direction.DESC, "updateDate");
        Pageable pageable = PageRequest.of(page, size, sort);
        return AlimentationPumpMapper.toDtos(alimentationPumpRepository.findAll(pageable), false);
    }



}

