package com.sinno.ems.sqlite.service.impl;

import com.sinno.ems.sqlite.repositories.WmsSorderStockRepository;
import com.sinno.ems.sqlite.service.WmsSorderStockService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by Enissay on 18/11/2016.
 */
@Service
public class WmsSorderStockServiceImpl implements WmsSorderStockService {
    @Autowired
    private WmsSorderStockRepository wmsSorderStockRepository;

    @Override
    public String getContainerSourceCode(Long lineNumber, String sorderCode, String containerTarget) {
        return wmsSorderStockRepository.getSourceContainerCode(lineNumber, sorderCode, containerTarget);
    }
}
