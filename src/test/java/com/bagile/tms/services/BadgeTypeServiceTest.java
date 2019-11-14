package com.bagile.tms.services;

import com.bagile.tms.dto.BadgeType;
import com.bagile.tms.exceptions.AttributesNotFound;
import com.bagile.tms.exceptions.IdNotFound;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.test.annotation.DirtiesContext;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class BadgeTypeServiceTest {

    @Autowired
    private BadgeTypeService badgeTypeService;



    @Test
    @Disabled
    @DirtiesContext
    void save() {
        BadgeType badgeType = new BadgeType();
        assertEquals(0,badgeType.getId());
        BadgeType save = badgeTypeService.save(badgeType);
        assertNotNull(save);
    }

    @Test
    void update() throws IdNotFound {

        BadgeType badgeTypeFindByid=badgeTypeService.findById(1L);
        assertNotNull(badgeTypeFindByid);
        badgeTypeFindByid.setCode("ddd");
        BadgeType save = badgeTypeService.save(badgeTypeFindByid);
        assertNotNull(save);
        assertEquals("ddd",save.getCode());

    }



    @Test
    void size_Db_vide_return_zero() {

        assertEquals(0, badgeTypeService.size());

    }

    @Test
    void isExist_Id_not_In_Db_return_False() {
        boolean d = badgeTypeService.isExist(4587L);
        assertFalse(d);

    }

    @Test
    void findById_Id_not_in_db_return_Exeption_IdNotFound() {

        assertThrows(IdNotFound.class,
                () -> badgeTypeService.findById(54181L));
    }

    @Test
    void find_search_not_in_db_return_Exeption_AttributesNotFound() {

        assertThrows(AttributesNotFound.class,
                () -> badgeTypeService.find("klm:pmlk"));
    }

    @Test
    void find1_searchPageSize_not_in_db_return_Exeption_AttributesNotFound() {
        assertThrows(AttributesNotFound.class,
                () ->
                        badgeTypeService.find("pmlj:hjkd", 13, 44));
    }

    @Test
    void size1_Search_not_in_db_return_Exeption_AttributesNotFound() {
        assertThrows(AttributesNotFound.class,
                () ->

                        badgeTypeService.size("azsfsdg"));
    }

    @Test
    void delete_Byid_not_inDb_return_exeptionEmptyResultDataAccessException() {
        assertThrows(EmptyResultDataAccessException.class,
        ()->
        badgeTypeService.delete(9512L));
    }

    @Test
    void delete1_byBadgeType_notinDb_return_exeption_NotNull_EmptyResultDataAccessException() {
    BadgeType z = new BadgeType();
    assertNotNull(z.getId());
    assertEquals(0,z.getId());
        assertThrows(EmptyResultDataAccessException.class,
                ()->
        badgeTypeService.delete(z.getId()));
    }

    @Test
    void findAll_empty_return_zero() {
        assertEquals(0, badgeTypeService.findAll().size());

    }

    @Test
    void findAll1_searchPageSize_empty_return_zero() {
        assertEquals(0, badgeTypeService.findAll(125,3).size());

    }
}