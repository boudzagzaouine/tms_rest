package com.bagile.tms.services;

import com.bagile.gmo.dto.MaintenanceType;
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
class MaintenanceTypeServiceTest {

    @Autowired
    private MaintenanceTypeService maintenanceTypeService;


    @Test
    void save() {
        MaintenanceType maintenanceType = new MaintenanceType();
        assertEquals(0,maintenanceType.getId());
        MaintenanceType save = maintenanceTypeService.save(maintenanceType);
        assertNotNull(save);
    }

    @Test
    void update() throws IdNotFound {

        MaintenanceType maintenanceTypeFindByid=maintenanceTypeService.findById(1L);
        assertNotNull(maintenanceTypeFindByid);
        maintenanceTypeFindByid.setCode("ddd");
        MaintenanceType save = maintenanceTypeService.save(maintenanceTypeFindByid);
        assertNotNull(save);
        assertEquals("ddd",save.getCode());

    }



    @ParameterizedTest
    @ValueSource(strings = {"fg123", "vggf78"})
    void saveNewValid(String code) {

        MaintenanceType maintenanceType = new MaintenanceType();
        maintenanceType.setCode(code);
        assertEquals(0,maintenanceType.getId());

        MaintenanceType save = maintenanceTypeService.save(maintenanceType);
        assertEquals(code.toUpperCase(), save.getCode().toUpperCase());
        assertNotNull(save);

    }

    @Test
    void size_Db_return_count() {

        assertEquals(2, maintenanceTypeService.size());

    }
    @ParameterizedTest
    @ValueSource(longs = {1L,2L})
    void isExist_Id_exist_In_Db_return_true(long id) {
        boolean d = maintenanceTypeService.isExist(id);
        assertTrue(d);

    }
    @Test
    void findById_Id_exist_in_db_return_Object() throws IdNotFound {
        MaintenanceType maintenanceType = maintenanceTypeService.findById(1L);
        assertNotNull(maintenanceType);
        assertEquals(1,maintenanceType.getId());
    }



    @Test
    void size_Db_vide_return_zero() {

        assertEquals(0, maintenanceTypeService.size());

    }

    @Test
    void isExist_Id_not_In_Db_return_False() {
        boolean d = maintenanceTypeService.isExist(4587L);
        assertFalse(d);

    }

    @Test
    void findById_Id_not_in_db_return_Exeption_IdNotFound() {

        assertThrows(IdNotFound.class,
                () -> maintenanceTypeService.findById(54181L));
    }

    @Test
    void find_search_not_in_db_return_Exeption_AttributesNotFound() {

        assertThrows(NullPointerException.class,
                () -> maintenanceTypeService.find("klm:pmlk"));
    }

    @Test
    void find1_searchPageSize_not_in_db_return_Exeption_AttributesNotFound() {
        assertThrows(NullPointerException.class,
                () ->
                        maintenanceTypeService.find("pmlj:hjkd", 13, 44));
    }

    @Test
    void size1_Search_not_in_db_return_Exeption_AttributesNotFound() {
        assertThrows(AttributesNotFound.class,
                () ->

                        maintenanceTypeService.size("azsfsdg"));
    }

    @Test
    void delete_Byid_not_inDb_return_exeptionEmptyResultDataAccessException() {
        assertThrows(EmptyResultDataAccessException.class,
        ()->
        maintenanceTypeService.delete(9512L));
    }

    @Test
    void delete1_byMaintenanceType_notinDb_return_exeption_NotNull_EmptyResultDataAccessException() {
    MaintenanceType z = new MaintenanceType();
    assertNotNull(z.getId());
    assertEquals(0,z.getId());
        assertThrows(EmptyResultDataAccessException.class,
                ()->
        maintenanceTypeService.delete(z.getId()));
    }

    @Test
    void findAll_empty_return_zero() {
        assertEquals(0, maintenanceTypeService.findAll().size());

    }

    @Test
    void findAll1_searchPageSize_empty_return_zero() {
        assertEquals(0, maintenanceTypeService.findAll(125,3).size());

    }
}