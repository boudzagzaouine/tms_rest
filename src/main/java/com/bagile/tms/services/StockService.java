package com.bagile.tms.services;

import com.bagile.tms.dto.Stock;
import com.bagile.tms.exceptions.AttributesNotFound;
import com.bagile.tms.exceptions.ErrorType;
import com.bagile.tms.exceptions.IdNotFound;
import com.bagile.tms.exceptions.ProductControls;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public interface StockService {

    public Stock save(Stock stock) throws ProductControls;

    public Long size();

    public Boolean isExist(Long id);

    public Stock findById(Long id) throws IdNotFound;

    public List<Stock> find(String search) throws AttributesNotFound, ErrorType;

    public List<Stock> find(String search, int page, int size) throws AttributesNotFound, ErrorType;

    public Long size(String search) throws AttributesNotFound, ErrorType;

    public void delete(Long id);

    public void delete(Stock stock);

    public List<Stock> findAll() throws AttributesNotFound, ErrorType;

    public List<Stock> findAll(Pageable pageable) throws AttributesNotFound, ErrorType;
}