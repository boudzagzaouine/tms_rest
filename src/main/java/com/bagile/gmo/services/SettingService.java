package com.bagile.gmo.services;

import com.bagile.gmo.dto.Setting;
import com.bagile.gmo.exceptions.AttributesNotFound;
import com.bagile.gmo.exceptions.ErrorType;
import com.bagile.gmo.exceptions.IdNotFound;


import java.math.BigDecimal;
import java.util.List;

/**
 * Created by Enissay on 08/06/2016.
 */
public interface SettingService {
    Setting save(Setting setting);

    Long size();

    Boolean isExist(Long id);

    Setting findById(Long id) throws IdNotFound;

    Setting findOne(String search) throws AttributesNotFound, ErrorType;

    List<Setting> find(String search) throws AttributesNotFound, ErrorType;

    List<Setting> find(String search, int page, int size) throws AttributesNotFound, ErrorType;

    Long size(String search) throws AttributesNotFound, ErrorType;

    void delete(Long id);

    void delete(Setting setting);

    List<Setting> findAll();

    List<Setting> findAll(int page, int size);

    default boolean containerManagement() {
        Setting setting = null;
        try {
            setting = findById(1L);
        } catch (IdNotFound idNotFound) {
            return false;

        }
        return setting != null && setting.getValue().equals("1");
    }// id = 1


    default boolean syncWms() {
        Setting setting = null;
        try {
            setting = findById(2L);
        } catch (IdNotFound idNotFound) {
            return false;

        }
        return setting != null && setting.getValue().equals("1");
    }            // id = 2

    default boolean warehouseManagement() {
        Setting setting = null;
        try {
            setting = findById(3L);
        } catch (IdNotFound idNotFound) {
            return false;

        }
        return setting != null && setting.getValue().equals("1");
    }              // id = 3

    default boolean devisManagement() {
        Setting setting = null;
        try {
            setting = findById(4L);
        } catch (IdNotFound idNotFound) {
            idNotFound.printStackTrace();
        }
        return setting != null && setting.getValue().equals("1");
    }              // id = 4

    default boolean preparationManagement() {
        Setting setting = null;
        try {
            setting = findById(5L);
        } catch (IdNotFound idNotFound) {
            return false;
        }
        return setting != null && setting.getValue().equals("1");
    }          // id = 5

    default boolean assetManagement() {
        Setting setting = null;
        try {
            setting = findById(6L);
        } catch (IdNotFound idNotFound) {
            return false;
        }
        return setting != null && setting.getValue().equals("1");
    }                 // id = 6

    default boolean litigationManagement() {
        Setting setting = null;
        try {
            setting = findById(7L);
        } catch (IdNotFound idNotFound) {
            return false;

        }
        return setting != null && setting.getValue().equals("1");
    }            // id = 7

    default boolean warrantyManagement() {
        Setting setting = null;
        try {
            setting = findById(8L);
        } catch (IdNotFound idNotFound) {
            return false;

        }
        return setting != null && setting.getValue().equals("1");
    }              // id = 8

    default boolean colorManagement()                  // id = 9
    {
        Setting setting = null;
        try {
            setting = findById(9L);
        } catch (IdNotFound idNotFound) {
            return false;

        }
        return setting != null && setting.getValue().equals("1");
    }

    default boolean lotManagement()                   // id = 10
    {
        Setting setting = null;
        try {
            setting = findById(10L);
        } catch (IdNotFound idNotFound) {
            return false;

        }
        return setting != null && setting.getValue().equals("1");
    }

    default boolean qualityManagement()             // id = 11
    {
        Setting setting = null;
        try {
            setting = findById(11L);
        } catch (IdNotFound idNotFound) {
            return false;

        }
        return setting != null && setting.getValue().equals("1");
    }

    default boolean serialNumberManagement()           // id = 12
    {
        Setting setting = null;
        try {
            setting = findById(12L);
        } catch (IdNotFound idNotFound) {
            return false;

        }
        return setting != null && setting.getValue().equals("1");
    }

    default boolean dlcManagement()                    // id = 13
    {
        Setting setting = null;
        try {
            setting = findById(13L);
        } catch (IdNotFound idNotFound) {
            return false;

        }
        return setting != null && setting.getValue().equals("1");
    }

    default boolean dluoManagement()                // id = 14
    {
        Setting setting = null;
        try {
            setting = findById(14L);
        } catch (IdNotFound idNotFound) {
            return false;

        }
        return setting != null && setting.getValue().equals("1");
    }

    default boolean weightManagement()                  // id = 15
    {
        Setting setting = null;
        try {
            setting = findById(15L);
        } catch (IdNotFound idNotFound) {
            return false;

        }
        return setting != null && setting.getValue().equals("1");
    }

    default boolean locationManagement()            // id = 16
    {
        Setting setting = null;
        try {
            setting = findById(16L);
        } catch (IdNotFound idNotFound) {
            return false;

        }
        return setting != null && setting.getValue().equals("1");
    }

    default boolean dimensionManagement()              // id = 17
    {
        Setting setting = null;
        try {
            setting = findById(17L);
        } catch (IdNotFound idNotFound) {
            return false;

        }
        return setting != null && setting.getValue().equals("1");
    }

    default boolean restaurantManagement() {
        Setting setting = null;
        try {
            setting = findById(18L);
        } catch (IdNotFound idNotFound) {
            return false;

        }
        return setting != null && setting.getValue().equals("1");
    }

    default String generateCodePreparation()              // id = 20
    {
        Setting setting = null;
        try {
            setting = findById(20L);
        } catch (IdNotFound idNotFound) {
            return null;
        }
        return (setting != null) ? setting.getValue() : "";
    }

    default String generateCodeSaleOrder()              // id = 21
    {
        Setting setting = null;
        try {
            setting = findById(21L);
        } catch (IdNotFound idNotFound) {
            return null;
        }
        return (setting != null) ? setting.getValue() : "";
    }

    default String generateCodePurshaseOrder()              // id = 22
    {
        Setting setting = null;
        try {
            setting = findById(22L);
        } catch (IdNotFound idNotFound) {
            return null;
        }
        return (setting != null) ? setting.getValue() : "";
    }

    default String generateCodeReception()              // id = 23
    {
        Setting setting = null;
        try {
            setting = findById(23L);
        } catch (IdNotFound idNotFound) {
            return null;
        }
        return (setting != null) ? setting.getValue() : "";
    }



    default String generateCodeVehicle()
    {
        Setting setting = null;
        try {
            setting = findById(102L);
        } catch (IdNotFound idNotFound) {
            return null;
        }
        return (setting != null) ? setting.getValue() : "";
    }

    default String generateAgent()
    {
        Setting setting = null;
        try {
            setting = findById(106L);
        } catch (IdNotFound idNotFound) {
            return null;
        }
        return (setting != null) ? setting.getValue() : "";
    }
    default String generateCodeMachinee()
    {
        Setting setting = null;
        try {
            setting = findById(103L);
        } catch (IdNotFound idNotFound) {
            return null;
        }
        return (setting != null) ? setting.getValue() : "";
    }

    default String generateCodeChauffeur()              // id = 23
    {
        Setting setting = null;
        try {
            setting = findById(104L);
        } catch (IdNotFound idNotFound) {
            return null;
        }
        return (setting != null) ? setting.getValue() : "";
    }
    default String generateCodeMaintenancePlan()              // id = 23
    {
        Setting setting = null;
        try {
            setting = findById(100L);
        } catch (IdNotFound idNotFound) {
            return null;
        }
        return (setting != null) ? setting.getValue() : "";
    }
    default String generateCodeMaintenance()              // id = 23
    {
        Setting setting = null;
        try {
            setting = findById(101L);
        } catch (IdNotFound idNotFound) {
            return null;
        }
        return (setting != null) ? setting.getValue() : "";
    }

    default String generateCodedieselDeclaration()              // id = 23
    {
        Setting setting = null;
        try {
            setting = findById(105L);
        } catch (IdNotFound idNotFound) {
            return null;
        }
        return (setting != null) ? setting.getValue() : "";
    }


    default String generateCodeDelivery()              // id = 24
    {
        Setting setting = null;
        try {
            setting = findById(24L);
        } catch (IdNotFound idNotFound) {
            return null;
        }
        return (setting != null) ? setting.getValue() : "";
    }

    default String generateCodeProduct()              // id = 25
    {
        Setting setting = null;
        try {
            setting = findById(25L);
        } catch (IdNotFound idNotFound) {
            return null;
        }
        return (setting != null) ? setting.getValue() : "";
    }

    default String generateCodeAccountInvoice()              // id = 26
    {
        Setting setting = null;
        try {
            setting = findById(26L);
        } catch (IdNotFound idNotFound) {
            return null;
        }
        return (setting != null) ? setting.getValue() : "";
    }

    default String generateCodeSupplierInvoice()              // id = 27
    {
        Setting setting = null;
        try {
            setting = findById(27L);
        } catch (IdNotFound idNotFound) {
            return null;
        }
        return (setting != null) ? setting.getValue() : "";
    }

    default String generateCodeAssetSupplier()              // id = 28
    {
        Setting setting = null;
        try {
            setting = findById(28L);
        } catch (IdNotFound idNotFound) {
            return null;
        }
        return (setting != null) ? setting.getValue() : "";
    }

    default String generateCodeAssetAccount()              // id = 29
    {
        Setting setting = null;
        try {
            setting = findById(29L);
        } catch (IdNotFound idNotFound) {
            return null;
        }
        return (setting != null) ? setting.getValue() : "";
    }

    default String generateCodeDevis()              // id = 30
    {
        Setting setting = null;
        try {
            setting = findById(30L);
        } catch (IdNotFound idNotFound) {
            return null;
        }
        return (setting != null) ? setting.getValue() : "";
    }

    default boolean productionManagement()              // id = 31
    {
        Setting setting = null;
        try {
            setting = findById(31L);
        } catch (IdNotFound idNotFound) {
            return false;
        }
        return setting != null && setting.getValue().equals("1");
    }

    default boolean posCanStockBeNegative()              // id = 31
    {
        Setting setting = null;
        try {
            setting = findById(54L);
        } catch (IdNotFound idNotFound) {
            return false;
        }
        return setting != null && setting.getValue().equals("1");
    }

    default String commercialCommissionSetting()              // id = 32
    {
        Setting setting = null;
        try {
            setting = findById(32L);//1 commission based on SaleOrder -2commission based on payment 3-commission when  invoice closed
        } catch (IdNotFound idNotFound) {
            return null;
        }
        return (setting != null) ? setting.getValue() : "";
    }

    default Boolean commercialCommissionForSale() {
        Setting setting = null;
        try {
            setting = findById(32L);
        } catch (IdNotFound idNotFound) {
            return false;

        }
        return setting != null && setting.getValue().equals("1");
    }

    default Boolean commercialCommissionForInvoice() {
        Setting setting = null;
        try {
            setting = findById(32L);
        } catch (IdNotFound idNotFound) {
            return false;

        }
        return setting != null && setting.getValue().equals("2");
    }

    default Boolean commercialCommissionForPayment() {
        Setting setting = null;
        try {
            setting = findById(32L);
        } catch (IdNotFound idNotFound) {
            return false;

        }
        return setting != null && setting.getValue().equals("3");
    }


    default String generateCodeOwner() {

        Setting setting = null;
        try {
            setting = findById(35L);
        } catch (IdNotFound idNotFound) {
            return "";
        }
        return (setting != null) ? setting.getValue() : "";
    }                // id = 34

    default String generateCodeAccount() {

        Setting setting;
        try {
            setting = findById(34L);
        } catch (IdNotFound idNotFound) {
            return "ACC";
        }
        return (setting != null) ? setting.getValue() : "";
    }             // id = 35

    default String generateCodeCommercial() {

        Setting setting = null;
        try {
            setting = findById(36L);
        } catch (IdNotFound idNotFound) {
            return "";
        }
        return (setting != null) ? setting.getValue() : "";
    }   // id = 36

    default String generateCodeWarehouse() {
        Setting setting = null;
        try {
            setting = findById(37L);
        } catch (IdNotFound idNotFound) {
            return "";
        }
        return (setting != null) ? setting.getValue() : "";
    }     // id = 37

    default String generateCodeSupplier() {
        Setting setting = null;
        try {
            setting = findById(38L);
        } catch (IdNotFound idNotFound) {
            return "";
        }
        return (setting != null) ? setting.getValue() : "";
    }     // id = 38


    default String generateCodeContact() {

        Setting setting = null;
        try {
            setting = findById(39L);
        } catch (IdNotFound idNotFound) {
            return "";
        }
        return (setting != null) ? setting.getValue() : "";
    }   // id = 39


    default String generateCodeTransport() {

        Setting setting = null;
        try {
            setting = findById(40L);
        } catch (IdNotFound idNotFound) {
            return "";
        }
        return (setting != null) ? setting.getValue() : "";
    }   // id = 40

    default String generateCodeZone() {

        Setting setting = null;
        try {
            setting = findById(41L);
        } catch (IdNotFound idNotFound) {
            return "";
        }
        return (setting != null) ? setting.getValue() : "";
    }   // id = 41

    default String generateCodeAisle() {

        Setting setting = null;
        try {
            setting = findById(42L);
        } catch (IdNotFound idNotFound) {
            return "";
        }
        return (setting != null) ? setting.getValue() : "";
    }   // id = 42

    default String generateCodePrinter() {

        Setting setting = null;
        try {
            setting = findById(43L);
        } catch (IdNotFound idNotFound) {
            return "";
        }
        return (setting != null) ? setting.getValue() : "";
    }   // id = 43


    default String generateCodeAddress() {

        Setting setting = null;
        try {
            setting = findById(44L);
        } catch (IdNotFound idNotFound) {
            return "";
        }
        return (setting != null) ? setting.getValue() : "";
    }   // id = 44

    default String generateCodeAgency() {

        Setting setting = null;
        try {
            setting = findById(45L);
        } catch (IdNotFound idNotFound) {
            return "";
        }
        return (setting != null) ? setting.getValue() : "";
    }   // id = 45

    default String generateCodeBank() {

        Setting setting = null;
        try {
            setting = findById(46L);
        } catch (IdNotFound idNotFound) {
            return "";
        }
        return (setting != null) ? setting.getValue() : "";
    }   // id = 46

    default String generateCodeColor() {

        Setting setting = null;
        try {
            setting = findById(47L);
        } catch (IdNotFound idNotFound) {
            return "";
        }
        return (setting != null) ? setting.getValue() : "";
    }   // id = 47

    default String generateCodeMachine() {

        Setting setting = null;
        try {
            setting = findById(48L);
        } catch (IdNotFound idNotFound) {
            return "";
        }
        return (setting != null) ? setting.getValue() : "";
    }   // id = 48

    default String generateCodeProcess() {

        Setting setting = null;
        try {
            setting = findById(49L);
        } catch (IdNotFound idNotFound) {
            return "";
        }
        return (setting != null) ? setting.getValue() : "";
    }   // id = 49

    default String generateCodeProductType() {

        Setting setting = null;
        try {
            setting = findById(50L);
        } catch (IdNotFound idNotFound) {
            return "";
        }
        return (setting != null) ? setting.getValue() : "";
    }   // id = 50

    default String generateCodeWallet() {

        Setting setting = null;
        try {
            setting = findById(51L);
        } catch (IdNotFound idNotFound) {
            return "";
        }
        return (setting != null) ? setting.getValue() : "";
    }   // id = 51

    default String generateCodeCompany() {

        Setting setting = null;
        try {
            setting = findById(52L);
        } catch (IdNotFound idNotFound) {
            return "";
        }
        return (setting != null) ? setting.getValue() : "";
    }   // id = 52

    default BigDecimal randomInvoiceTolerance() {
        Setting setting = null;
        try {
            setting = findById(53L);
        } catch (IdNotFound idNotFound) {
            return BigDecimal.ZERO;

        }
        return new BigDecimal(setting.getValue());
    }//id = 53

    default String generateInventoryCode() {
        Setting setting = null;
        try {
            setting = findById(60L);
        } catch (IdNotFound idNotFound) {
            return "";

        }
        return setting.getValue();
    }//id = 60


    default boolean deliveryCostManagement() {
        Setting setting = null;
        try {
            setting = findById(68L);
        } catch (IdNotFound idNotFound) {
            return false;

        }
        return setting != null && setting.getValue().equals("1");
    }              // id = 68

    default String deliveryCostCode() {
        Setting setting = null;
        try {
            setting = findById(69L);
        } catch (IdNotFound idNotFound) {
            return "";

        }
        return setting.getValue();
    }//id = 69

    default BigDecimal deliveryCostValue() {
        Setting setting = null;
        try {
            setting = findById(70L);
        } catch (IdNotFound idNotFound) {
            return BigDecimal.ZERO;

        }
        return new BigDecimal(setting.getValue());
    }//id = 70

    default Long shrinkageWastageBatchInterval() {
        Setting setting = null;
        try {
            setting = findById(72L);
        } catch (IdNotFound idNotFound) {
            return null;

        }
        return Long.valueOf(setting.getValue());
    }//id = 72

    default String generateCodeDeal() {
        Setting setting = null;
        try {
            setting = findById(73L);
        } catch (IdNotFound idNotFound) {
            return "";
        }
        return (setting != null) ? setting.getValue() : "";
    }//id = 73
}