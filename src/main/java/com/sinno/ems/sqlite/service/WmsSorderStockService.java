package com.sinno.ems.sqlite.service;

/**
 * Created by Enissay on 18/11/2016.
 */
public interface WmsSorderStockService {
    String getContainerSourceCode(Long lineNumber, String sorderCode, String containerTarget);
}
