package com.bagile.tms.services;

import com.bagile.gmo.dto.VacationType;
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
class VacationTypeServiceTest {

    @Autowired
    private VacationTypeService vacationTypeService;


    @Test
    void save() {
        VacationType vacationType = new VacationType();
        assertEquals(0,vacationType.getId());
        VacationType save = vacationTypeService.save(vacationType);
        assertNotNull(save);
    }

    @Test
    void update() throws IdNotFound {

        VacationType vacationTypeFindByid=vacationTypeService.findById(1L);
        assertNotNull(vacationTypeFindByid);
        vacationTypeFindByid.setCode("vv");
        VacationType save = vacationTypeService.save(vacationTypeFindByid);
        assertNotNull(save);
        assertEquals("vv",save.getCode());

    }


    @ParameterizedTest
    @ValueSource(strings = {"qs123", "ze5478"})
    void saveNewValid(String code) {

        VacationType vacationType = new VacationType();
        vacationType.setCode(code);
        assertEquals(0,vacationType.getId());

        VacationType save = vacationTypeService.save(vacationType);
        assertEquals(code.toUpperCase(), save.getCode().toUpperCase());
        assertNotNull(save);

    }

    @Test
    void size_Db_return_count() {

        assertEquals(2, vacationTypeService.size());

    }
    @ParameterizedTest
    @ValueSource(longs = {1L,2L})
    void isExist_Id_exist_In_Db_return_true(long id) {
        boolean d = vacationTypeService.isExist(id);
        assertTrue(d);

    }
    @Test
    void findById_Id_exist_in_db_return_Object() throws IdNotFound {
        VacationType vacationType = vacationTypeService.findById(1L);
        assertNotNull(vacationType);
        assertEquals(1,vacationType.getId());
    }





    @Test
    void size_Db_vide_return_zero() {

        assertEquals(0, vacationTypeService.size());

    }

    @Test
    void isExist_Id_not_In_Db_return_False() {
        boolean d = vacationTypeService.isExist(4587L);
        assertFalse(d);

    }

    @Test
    void findById_Id_not_in_db_return_Exeption_IdNotFound() {

        assertThrows(IdNotFound.class,
                () -> vacationTypeService.findById(54181L));
    }

    @Test
    void find_search_not_in_db_return_Exeption_AttributesNotFound() {

        assertThrows(AttributesNotFound.class,
                () -> vacationTypeService.find("klm:pmlk"));
    }

    @Test
    void find1_searchPageSize_not_in_db_return_Exeption_AttributesNotFound() {
        assertThrows(AttributesNotFound.class,
                () ->
                        vacationTypeService.find("pmlj:hjkd", 13, 44));
    }

    @Test
    void size1_Search_not_in_db_return_Exeption_AttributesNotFound() {
        assertThrows(AttributesNotFound.class,
                () ->

                        vacationTypeService.size("azsfsdg"));
    }

    @Test
    void delete_Byid_not_inDb_return_exeptionEmptyResultDataAccessException() {
        assertThrows(EmptyResultDataAccessException.class,
        ()->
        vacationTypeService.delete(9512L));
    }

    @Test
    void delete1_byVacationType_notinDb_return_exeption_NotNull_EmptyResultDataAccessException() {
    VacationType z = new VacationType();
    assertNotNull(z.getId());
    assertEquals(0,z.getId());
        assertThrows(EmptyResultDataAccessException.class,
                ()->
        vacationTypeService.delete(z.getId()));
    }

    @Test
    void findAll_empty_return_zero() {
        assertEquals(0, vacationTypeService.findAll().size());

    }

    @Test
    void findAll1_searchPageSize_empty_return_zero() {
        assertEquals(0, vacationTypeService.findAll(125,3).size());

    }
}