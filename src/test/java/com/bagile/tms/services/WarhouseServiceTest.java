package com.bagile.tms.services;

import com.bagile.tms.dto.Warehouse;
import com.bagile.tms.exceptions.AttributesNotFound;
import com.bagile.tms.exceptions.ErrorType;
import com.bagile.tms.exceptions.IdNotFound;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.dao.EmptyResultDataAccessException;

import java.util.NoSuchElementException;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class WarehouseServiceTest {

    @Autowired
    private WarehouseService WarehouseService;


    @Test
    void save() {

    }

    @Test
    void size_Db_vide_return_zero() {

        assertEquals(0, WarehouseService.size());

    }

    @Test
    void isExist_Id_not_In_Db_return_False() {
        boolean d = WarehouseService.isExist(4587L);
        assertFalse(d);

    }

    @Test
    void findById_Id_not_in_db_return_Exeption_IdNotFound() {

        assertThrows(NoSuchElementException.class,
                () -> WarehouseService.findById(54181L));
    }

    @Test
    void find_search_not_in_db_return_Exeption_AttributesNotFound() {

        assertThrows(NullPointerException.class,
                () -> WarehouseService.find("klm:pmlk"));
    }

    @Test
    void find1_searchPageSize_not_in_db_return_Exeption_AttributesNotFound() {
        assertThrows(NumberFormatException.class,
                () ->
                        WarehouseService.find("id:hjkd", 0, 44));
    }

    @Test
    void size1_Search_not_in_db_return_Exeption_AttributesNotFound() {
        assertThrows(NumberFormatException.class,
                () ->

                        WarehouseService.size("id:azsfsdg"));
    }

    @Test
    void delete_Byid_not_inDb_return_exeptionEmptyResultDataAccessException() {
        assertThrows(NoSuchElementException.class,
        ()->
        WarehouseService.delete(9512L));
    }

    @Test
    void delete1_byWarehouse_notinDb_return_exeption_NotNull_EmptyResultDataAccessException() {
    Warehouse z = new Warehouse();
    assertNotNull(z.getId());
    assertEquals(0,z.getId());
        assertThrows(NoSuchElementException.class,
                ()->
        WarehouseService.delete(z.getId()));
    }

    @Test
    void findAll_empty_return_zero() throws AttributesNotFound, ErrorType {


        assertEquals(0, WarehouseService.findAll().size());

    }

    @Test
    void findAll1_searchPageSize_empty_return_zero() {
        assertEquals(0, WarehouseService.findAll(125,3).size());

    }
}