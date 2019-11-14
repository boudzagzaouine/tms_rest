package com.bagile.tms.services;

import com.bagile.tms.dto.BadgeType;
import com.bagile.tms.dto.Vehicle;
import com.bagile.tms.dto.VehicleCategory;
import com.bagile.tms.exceptions.AttributesNotFound;
import com.bagile.tms.exceptions.IdNotFound;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.dao.EmptyResultDataAccessException;

import java.util.Date;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class VehicleServiceTest {

    @Autowired
    private VehicleService vehicleService;

    @Autowired
    private VehicleCategoryService vehicleCategoryService;

    @Autowired
    private BadgeTypeService badgeTypeService;


    @Test
    void save() {
        VehicleCategory category = new VehicleCategory ();
        category.setCode ("CAT1001");
        VehicleCategory vehicleCategory = vehicleCategoryService.save (category);
        assertNotNull (vehicleCategory);

        BadgeType badgeType = new BadgeType ();
        badgeType.setCode ("C");
        BadgeType badgeType1 = badgeTypeService.save (badgeType);
        assertNotNull (badgeType1);

        Vehicle vehicle1 = new Vehicle ();
        vehicle1.setCode ("VEH1002");
        vehicle1.setRegistrationNumber ("23456-A-15");
        vehicle1.setTechnicalVisit (new Date ());
        vehicle1.setBadgeType (badgeType1);
        vehicle1.setVehicleCategory (vehicleCategory);

        Vehicle vehicle2 = new Vehicle ();
        vehicle2.setCode ("VEH1002");
        vehicle2.setRegistrationNumber ("23456-A-15");
        vehicle2.setTechnicalVisit (new Date ());
        vehicle2.setBadgeType (badgeType1);
        vehicle2.setVehicleCategory (vehicleCategory);

        Vehicle vehicle3 = new Vehicle ();
        vehicle3.setCode ("VEH1002");
        vehicle3.setRegistrationNumber ("23456-A-15");
        vehicle3.setTechnicalVisit (new Date ());
        vehicle3.setBadgeType (badgeType1);
        vehicle3.setVehicleCategory (vehicleCategory);



        Vehicle save1 = vehicleService.save (vehicle1);
        Vehicle save2 = vehicleService.save (vehicle2);
        Vehicle save3 = vehicleService.save (vehicle3);
        assertNotNull (save1);
        assertNotNull (save2);
        assertNotNull (save3);
    }

    @Test
    void size_Db_vide_return_zero() {

        assertEquals(0, vehicleService.size());

    }

    @Test
    void isExist_Id_not_In_Db_return_False() {
        boolean d = vehicleService.isExist(4587L);
        assertFalse(d);

    }

    @Test
    void findById_Id_not_in_db_return_Exeption_IdNotFound() {

        assertThrows(IdNotFound.class,
                () -> vehicleService.findById(54181L));
    }

    @Test
    void find_search_not_in_db_return_Exeption_AttributesNotFound() {
        assertThrows(NumberFormatException.class,
                () -> vehicleService.find("id:kjk"));
    }

    @Test
    void find1_searchPageSize_not_in_db_return_Exeption_AttributesNotFound() {

        assertThrows(NullPointerException.class,
                () -> vehicleService.find("ll:4", 5, 44));
    }

    @Test
    void size1_Search_not_in_db_return_Exeption_AttributesNotFound() {
        assertThrows(AttributesNotFound.class,
                () ->
                        vehicleService.size("azsfsdg"));
    }

    @Test
    void delete_Byid_not_inDb_return_exeptionEmptyResultDataAccessException() {
        assertThrows(EmptyResultDataAccessException.class,
        ()->
        vehicleService.delete(9512L));
    }

    @Test
    void delete1_byVehicle_notinDb_return_exeption_NotNull_EmptyResultDataAccessException() {
    Vehicle z = new Vehicle();
    assertNotNull(z.getId());
    assertEquals(0,z.getId());
        assertThrows(EmptyResultDataAccessException.class,
                ()->
        vehicleService.delete(z.getId()));
    }

    @Test
    void findAll_empty_return_zero() {
        assertEquals(0, vehicleService.findAll().size());

    }

    @Test
    void findAll1_searchPageSize_empty_return_zero() {
        assertEquals(0, vehicleService.findAll(125,3).size());

    }
}