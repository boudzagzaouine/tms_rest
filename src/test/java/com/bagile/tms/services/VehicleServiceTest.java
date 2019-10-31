package com.bagile.tms.services;

import com.bagile.tms.dto.Vehicle;
import com.bagile.tms.exceptions.AttributesNotFound;
import com.bagile.tms.exceptions.IdNotFound;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.dao.EmptyResultDataAccessException;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class VehicleServiceTest {

    @Autowired
    private VehicleService vehicleService;


    @Test
    void save() {

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