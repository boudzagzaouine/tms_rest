package com.bagile.tms.services;

import com.bagile.tms.dto.Setting;
import com.bagile.tms.exceptions.AttributesNotFound;
import com.bagile.tms.exceptions.ErrorType;
import com.bagile.tms.exceptions.IdNotFound;

import java.util.List;

/**
 * Created by Enissay on 08/06/2016.
 */
public interface SettingService {
    public Setting save(Setting setting);

    public Long size();

    public Boolean isExist(Long id);

    public Setting findById(Long id) throws IdNotFound;

    Setting findOne(String search) throws AttributesNotFound, ErrorType;

    public List<Setting> find(String search) throws AttributesNotFound, ErrorType;

    public List<Setting> find(String search, int page, int size) throws AttributesNotFound, ErrorType;

    public Long size(String search) throws AttributesNotFound, ErrorType;

    public void delete(Long id);

    public void delete(Setting setting);

    public List<Setting> findAll();

    public List<Setting> findAll(int page, int size);

    boolean containerManagement()             // id = 1
    ;

    boolean syncWms()            // id = 2
    ;

    boolean warehouseManagement()              // id = 3
    ;

    boolean devisManagement()              // id = 4
    ;

    boolean preparationManagement()          // id = 5
    ;

    boolean assetManagement()                 // id = 6
    ;

    boolean litigationManagement()            // id = 7
    ;

    boolean warrantyManagement()              // id = 8
    ;

    boolean colorManagement()                  // id = 9
    ;

    boolean lotManagement()                   // id = 10
    ;

    boolean qualityManagement()             // id = 11
    ;

    boolean serialNumberManagement()           // id = 12
    ;

    boolean dlcManagement()                    // id = 13
    ;

    boolean dluoManagement()                // id = 14
    ;

    boolean weightManagement()                  // id = 15
    ;

    boolean locationManagement()            // id = 16
    ;

    boolean dimensionManagement()              // id = 17
    ;

    boolean generateReception()              // id = 18
    ;

    boolean generatePreparation()              // id = 19
    ;

    String generateCodePreparation()              // id = 20
    ;

    String generateCodeSaleOrder()              // id = 21
    ;

    String generateCodePurshaseOrder()              // id = 22
    ;

    String generateCodeReception()              // id = 23
    ;

    String generateCodeDelivery()              // id = 24
    ;

    String generateCodeProduct()              // id = 25
    ;

    String generateCodeAccountInvoice()              // id = 26
    ;

    String generateCodeSupplierInvoice()              // id = 27
    ;

    String generateCodeAssetSupplier()              // id = 28
    ;

    String generateCodeAssetAccount()              // id = 29
    ;

    String generateCodeDevis()              // id = 30
    ;

    String commercialCommissionSetting()              // id = 32
    ;
}
