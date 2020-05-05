package com.bagile.tms.services;
import com.bagile.gmo.dto.Vacation;
import com.bagile.tms.exceptions.AttributesNotFound;
import com.bagile.tms.exceptions.IdNotFound;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.test.annotation.DirtiesContext;

import java.text.SimpleDateFormat;
import java.util.Date;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class VacationServiceTest {

    @Autowired
    private VacationService vacationService;


    @Test
    @Disabled
    @DirtiesContext
    void save()throws IdNotFound {

        Vacation vacation = new Vacation();
        assertEquals(0,vacation.getId());
        Vacation save = vacationService.save(vacation);
        assertNotNull(save);


    }

    @Test
    void update() throws IdNotFound {

        Vacation vacationFindByid=vacationService.findById(1L);
        assertNotNull(vacationFindByid);
        Date date = new Date();

        vacationFindByid.setStartDate(date);
        Vacation save = vacationService.save(vacationFindByid);
        assertNotNull(save);
        assertEquals(date,save.getStartDate());

    }




    @Test
    void size_Db_return_count() {

        assertEquals(2, vacationService.size());

    }
    @ParameterizedTest
    @ValueSource(longs = {1L})
    void isExist_Id_exist_In_Db_return_true(long id) {
        boolean d = vacationService.isExist(id);
        assertTrue(d);

    }
    @Test
    void findById_Id_exist_in_db_return_Object() throws IdNotFound {
        Vacation vacation = vacationService.findById(1L);
        assertNotNull(vacation);
        assertEquals(1,vacation.getId());
    }



    @Test
    void size_Db_vide_return_zero() {

        assertEquals(0, vacationService.size());

    }

    @Test
    void isExist_Id_not_In_Db_return_False() {
        boolean d = vacationService.isExist(4587L);
        assertFalse(d);

    }

    @Test
    void findById_Id_not_in_db_return_Exeption_IdNotFound() {

        assertThrows(IdNotFound.class,
                () -> vacationService.findById(54181L));
    }

    @Test
    void find_search_not_in_db_return_Exeption_AttributesNotFound() {

        assertThrows(AttributesNotFound.class,
                () -> vacationService.find("klm:pmlk"));
    }

    @Test
    void find1_searchPageSize_not_in_db_return_Exeption_AttributesNotFound() {
        assertThrows(AttributesNotFound.class,
                () ->
                        vacationService.find("pmlj:hjkd", 13, 44));
    }

    @Test
    void size1_Search_not_in_db_return_Exeption_AttributesNotFound() {
        assertThrows(AttributesNotFound.class,
                () ->

                        vacationService.size("azsfsdg"));
    }

    @Test
    void delete_Byid_not_inDb_return_exeptionEmptyResultDataAccessException() {
        assertThrows(EmptyResultDataAccessException.class,
        ()->
        vacationService.delete(9512L));
    }

    @Test
    void delete1_byVacation_notinDb_return_exeption_NotNull_EmptyResultDataAccessException() {
    Vacation z = new Vacation();
    assertNotNull(z.getId());
    assertEquals(0,z.getId());
        assertThrows(EmptyResultDataAccessException.class,
                ()->
        vacationService.delete(z.getId()));
    }

    @Test
    void findAll_empty_return_zero() {
        assertEquals(0, vacationService.findAll().size());

    }

    @Test
    void findAll1_searchPageSize_empty_return_zero() {
        assertEquals(0, vacationService.findAll(125,3).size());

    }
}