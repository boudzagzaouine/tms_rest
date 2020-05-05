package com.bagile.tms.services;

import com.bagile.gmo.dto.MaintenanceState;
import com.bagile.tms.exceptions.AttributesNotFound;
import com.bagile.tms.exceptions.IdNotFound;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
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
        MaintenanceState maintenanceState = new MaintenanceState();
        assertEquals(0,maintenanceState.getId());
        MaintenanceState save = maintenanceStateService.save(maintenanceState);
        assertNotNull(save);    }

    @Test
    void update() throws IdNotFound {

        MaintenanceState maintenanceStateFindByid=maintenanceStateService.findById(1L);
        assertNotNull(maintenanceStateFindByid);
        maintenanceStateFindByid.setCode("ddd");
        MaintenanceState save = maintenanceStateService.save(maintenanceStateFindByid);
        assertNotNull(save);
        assertEquals("ddd",save.getCode());

    }


    @ParameterizedTest
    @ValueSource(strings = {"pm785", "nb458"})
    void saveNewValid(String code) {

        MaintenanceState maintenanceState = new MaintenanceState();
        maintenanceState.setCode(code);
        assertEquals(0,maintenanceState.getId());

        MaintenanceState save = maintenanceStateService.save(maintenanceState);
        assertEquals(code.toUpperCase(), save.getCode().toUpperCase());
        assertNotNull(save);

    }

    @Test
    void size_Db_return_count() {

        assertEquals(2, maintenanceStateService.size());

    }
    @ParameterizedTest
    @ValueSource(longs = {1L,2L})
    void isExist_Id_exist_In_Db_return_true(long id) {
        boolean d = maintenanceStateService.isExist(id);
        assertTrue(d);

    }
    @Test
    void findById_Id_exist_in_db_return_Object() throws IdNotFound {
        MaintenanceState maintenanceState = maintenanceStateService.findById(1L);
        assertNotNull(maintenanceState);
        assertEquals(1,maintenanceState.getId());
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