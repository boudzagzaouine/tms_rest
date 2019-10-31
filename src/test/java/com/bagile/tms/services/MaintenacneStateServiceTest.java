package com.bagile.tms.services;

import com.bagile.tms.dto.MaintenanceState;
import com.bagile.tms.exceptions.AttributesNotFound;
import com.bagile.tms.exceptions.IdNotFound;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.dao.EmptyResultDataAccessException;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class MaintenacneStateServiceTest {

    @Autowired
    private MaintenanceStateService maintenanceStateService;


    @Test
    void save() {

    }

    @Test
    void size_Db_vide_return_zero() {

        assertEquals(0, maintenanceStateService.size());

    }

    @Test
    void isExist_Id_not_In_Db_return_False() {
        boolean d = maintenanceStateService.isExist(4587L);
        assertFalse(d);

    }

    @Test
    void findById_Id_not_in_db_return_Exeption_IdNotFound() {

        assertThrows(IdNotFound.class,
                () -> maintenanceStateService.findById(54181L));
    }

    @Test
    void find_search_not_in_db_return_Exeption_AttributesNotFound() {

        assertThrows(NullPointerException.class,
                () -> maintenanceStateService.find("klm:pmlk"));
    }

    @Test
    void find1_searchPageSize_not_in_db_return_Exeption_AttributesNotFound() {
        assertThrows(NullPointerException.class,
                () ->
                        maintenanceStateService.find("pmlj:hjkd", 13, 44));
    }

    @Test
    void size1_Search_not_in_db_return_Exeption_AttributesNotFound() {
        assertThrows(AttributesNotFound.class,
                () ->

                        maintenanceStateService.size("azsfsdg"));
    }

    @Test
    void delete_Byid_not_inDb_return_exeptionEmptyResultDataAccessException() {
        assertThrows(EmptyResultDataAccessException.class,
        ()->
        maintenanceStateService.delete(9512L));
    }

    @Test
    void delete1_byMaintenanceState_notinDb_return_exeption_NotNull_EmptyResultDataAccessException() {
    MaintenanceState z = new MaintenanceState();
    assertNotNull(z.getId());
    assertEquals(0,z.getId());
        assertThrows(EmptyResultDataAccessException.class,
                ()->
        maintenanceStateService.delete(z.getId()));
    }

    @Test
    void findAll_empty_return_zero() {
        assertEquals(0, maintenanceStateService.findAll().size());

    }

    @Test
    void findAll1_searchPageSize_empty_return_zero() {
        assertEquals(0, maintenanceStateService.findAll(125,3).size());

    }
}