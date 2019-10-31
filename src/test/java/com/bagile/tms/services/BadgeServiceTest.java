package com.bagile.tms.services;

import com.bagile.tms.dto.Badge;
import com.bagile.tms.exceptions.AttributesNotFound;
import com.bagile.tms.exceptions.IdNotFound;
import com.bagile.tms.repositories.BadgeRepository;
import javafx.beans.binding.When;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.dao.EmptyResultDataAccessException;

import static javafx.beans.binding.Bindings.when;
import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class BadgeServiceTest {

    @Autowired
    private BadgeService badgeService;


    @Test
    void save() {

        Badge badge = new Badge();
        assertEquals(0,badge.getId());
        Badge save = badgeService.save(badge);


    }

    @Test
    void size_Db_vide_return_zero() {

        assertEquals(0, badgeService.size());

    }

    @Test
    void isExist_Id_not_In_Db_return_False() {
        boolean d = badgeService.isExist(4587L);
        assertFalse(d);

    }

    @Test
    void findById_Id_not_in_db_return_Exeption_IdNotFound() {

        assertThrows(IdNotFound.class,
                () -> badgeService.findById(54181L));
    }

    @Test
    void find_search_not_in_db_return_Exeption_AttributesNotFound() {

        assertThrows(AttributesNotFound.class,
                () -> badgeService.find("klm:pmlk"));
    }

    @Test
    void find1_searchPageSize_not_in_db_return_Exeption_AttributesNotFound() {
        assertThrows(AttributesNotFound.class,
                () ->
                        badgeService.find("pmlj:hjkd", 13, 44));
    }

    @Test
    void size1_Search_not_in_db_return_Exeption_AttributesNotFound() {
        assertThrows(AttributesNotFound.class,
                () ->

                        badgeService.size("azsfsdg"));
    }

    @Test
    void delete_Byid_not_inDb_return_exeptionEmptyResultDataAccessException() {
        assertThrows(EmptyResultDataAccessException.class,
        ()->
        badgeService.delete(9512L));
    }

    @Test
    void delete1_byBadge_notinDb_return_exeption_NotNull_EmptyResultDataAccessException() {
    Badge z = new Badge();
    assertNotNull(z.getId());
    assertEquals(0,z.getId());
        assertThrows(EmptyResultDataAccessException.class,
                ()->
        badgeService.delete(z.getId()));
    }

    @Test
    void findAll_empty_return_zero() {
        assertEquals(0, badgeService.findAll().size());

    }

    @Test
    void findAll1_searchPageSize_empty_return_zero() {
        assertEquals(0, badgeService.findAll(125,3).size());

    }
}